public class regular extends seats{
    int ticketPrice;
    char sts[][];
    public regular(int r, int c, char[][] st){
        super(r,c);
        sts = st;
        ticketPrice = 10;
    }
    public int getTicketPrice(){
        return ticketPrice;
    }
    
    public int regularPurch(){
        int cnt = 0;
        for(int i=1; i<5; ++i){
            for(int j=0; j<5; ++j){
                if(sts[i][j] == 'X')cnt++;
            }
        }
        
        return cnt;
    }

}
