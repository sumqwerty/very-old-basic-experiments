package jdbc;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class JDBCModel {

	private static final String[] COL_NAMES_GOLUCOS = { "Id", "EntryType", "GlucoseValue", "TakenAt" };
	private static final String[] COL_NAMES_ACCOUNT = { "Name", "YearOfBirth", "Weight" };

	private static final String QUERY_ENTRYTYPE_SELECT = "SELECT EntryType FROM entrytype";
	private static final String QUERY_ACCOUNT_SELECT = "SELECT Name, YearOfBirth, Weight FROM account where id=?";
	private static final String QUERY_ACCOUNT_UPDATE = "UPDATE account SET Name = ?, YearOfBirth = ?, Weight = ? WHERE Id = ?";
	private static final String QUERY_VALIDATE = "SELECT AccountId FROM security where security.username=? and security.password=?";
	private static final String QUERY_GLUCOSE_INSERT = "INSERT INTO glucosevalue(EntryTypeId,AccountId,GlucoseValue,TakenAt)VALUES((select id from entrytype where entrytype=?),?,?,now())";
	private static final String QUERY_GLUCOSE_NUMBERS = "SELECT g.Id, (SELECT EntryType FROM entrytype where g.EntryTypeId=Id ) as EntryType, g.GlucoseValue, g.TakenAt FROM glucosevalue g where AccountId=?";

	private Connection connection;
	private String user;
	private String pass;

	public void setCredentials( String user, String pass) {
		this.user = user;
		this.pass = pass;
	}

	public void connectTo( String url) throws SQLException {
		if ( isConnected())
			close();
		connection = DriverManager.getConnection( url, user, pass);
	}

	public boolean isConnected() throws SQLException {
		return !( connection == null || connection.isClosed() || !connection.isValid( 60));
	}

	private void hasValidConnection() throws SQLException {
		if ( !isConnected())
			throw new SQLException( "No connection to DB");
	}

	public void addGlucoseValue( String entryType, int activeAccountId, double glucose) throws SQLException {

		hasValidConnection();

		try ( PreparedStatement ps = connection.prepareStatement( QUERY_GLUCOSE_INSERT)) {
			ps.setString( 1, entryType);
			ps.setInt( 2, activeAccountId);
			ps.setDouble( 3, glucose);

			ps.executeUpdate();
		}
	}

	public List< String> getEntryTypes() throws SQLException {
		hasValidConnection();

		List< String> types = new LinkedList<>();

		try ( PreparedStatement ps = connection.prepareStatement( QUERY_ENTRYTYPE_SELECT)) {
			try ( ResultSet rs = ps.executeQuery()) {
				while ( rs.next()) {
					types.add( rs.getString( 1));
				}
			}
		}
		return types;
	}

	public List< String> getAccountInfoFor( int activeAccountId) throws SQLException {
		hasValidConnection();

		List< String> info = new LinkedList<>();

		try ( PreparedStatement ps = connection.prepareStatement( QUERY_ACCOUNT_SELECT)) {
			ps.setInt( 1, activeAccountId);
			try ( ResultSet rs = ps.executeQuery()) {
				while ( rs.next()) {
					for ( String col : COL_NAMES_ACCOUNT) {
						info.add( rs.getString( col));
					}
				}
			}
		}
		return info;
	}

	public void updateInfo( String name, String yob, String weight, int activeAccountId) throws SQLException {
		Objects.requireNonNull( name, "Name cannot be null");
		Objects.requireNonNull( yob, "Year of Birth cannot be null");
		Objects.requireNonNull( weight, "Weight cannot be null");

		hasValidConnection();

		try ( PreparedStatement ps = connection.prepareStatement( QUERY_ACCOUNT_UPDATE)) {
			ps.setString( 1, name);
			ps.setString( 2, yob);
			ps.setString( 3, weight);
			ps.setInt( 4, activeAccountId);

			ps.executeUpdate();
		}
	}

	public int loginWith( String username, String password) throws SQLException {
		Objects.requireNonNull( username, "Username cannot be null");
		Objects.requireNonNull( password, "Password cannot be null");

		hasValidConnection();

		try ( PreparedStatement ps = connection.prepareStatement( QUERY_VALIDATE)) {
			ps.setString( 1, username);
			ps.setString( 2, password);
			try ( ResultSet rs = ps.executeQuery()) {
				if ( rs.next()) {
					return rs.getInt( 1);
				}
			}
		}
		return -1;
	}

	public List< String> getColumnNames() {
		return List.of( COL_NAMES_GOLUCOS);
	}

	public List< List< Object>> getAllGlucoseNumbers( int activeAccountId) throws SQLException {
		hasValidConnection();

		List< List< Object>> rows = new LinkedList<>();

		try ( PreparedStatement ps = connection.prepareStatement( QUERY_GLUCOSE_NUMBERS)) {
			ps.setInt( 1, activeAccountId);
			try ( ResultSet rs = ps.executeQuery()) {
				while ( rs.next()) {
					List< Object> cols = new LinkedList<>();
					for ( String col : COL_NAMES_GOLUCOS) {
						cols.add( rs.getObject( col));
					}
					rows.add( cols);
				}
			}
		}
		return rows;
	}

	public void close() throws SQLException {
		if ( connection != null)
			connection.close();
	}
}
