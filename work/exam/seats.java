public class seats{
    
    int row;
    int col;
    char [][] seat;
    public seats(int r, int c){
        seat = new char[5][5];
        row = r;
        col = c;
        for(int i=0; i<5; ++i){
            for(int j=0; j<5; ++j){
                if(i==r && j==c)seat[i][j] = 'X';
                else seat[i][j] = 'E';
            }
        }
    }
    
    public void resSeats(int r, int c){
        seat[r][c] = 'X';
    }
    
    public void dispSeats(){
        //System.out.println();
        System.out.print("  ");
        for(char ch='A'; ch<'F'; ++ch){
            System.out.print(ch+" ");
        }
        System.out.println();
        
        for(int i=1; i<=5; ++i){
            System.out.print(i+" ");
            for(int j=0; j<5; ++j){
                System.out.print(seat[i-1][j]+" ");
            }
            System.out.println();
        }
        
    }
}
