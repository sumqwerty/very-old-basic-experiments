package foldr;
public class Account{
	private String acc_num;
	private double acc_bal;
	private String acc_name;

	String get_acc_num(){
		return acc_num;
	}

	double get_acc_balance(){
		return acc_bal;
	}

	String get_acc_name(){
		return acc_name;
	}

	boolean set_acc_num(String _acn){
		for(int i=0; i < _acn.length(); ++i){
			if(!((_acn.charAt(i) >= '1' && _acn.charAt(i) <= '9') || ((_acn.charAt(i) >= 'A' && _acn.charAt(i) <= 'Z') || (_acn.charAt(i)>='a' && _acn.charAt(i)<= 'z') ))){
				return false;
			}
		}


		acc_num = _acn;
		return true;
	}

	boolean set_acc_name(String _name){
		for(int i=0; i < _name.length(); ++i){
            if(!((_name.charAt(i) >= 'A' && _name.charAt(i) <= 'Z') || (_name.charAt(i) >= 'a' && _name.charAt(i) <= 'z') || _name.charAt(i) == '-' || _name.charAt(i) == ' ') ){
                return false;
            }
		}
		
		acc_name = _name;
		
		return true;
	}
	
	boolean set_acc_balance(double _bal){
        if(_bal < 0 )return false;
        
        acc_bal = _bal;
        return true;
	}

	
}
