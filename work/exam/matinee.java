public class matinee extends seats{
    int ticketPrice;
    char[][] sts;
    
    public matinee(int r, int c, char[][] st){
        super(r,c);
        sts = st;
        ticketPrice = 20;
    }
    public int getTicketPrice(){
        return ticketPrice;
    }
    
    public int matineePurch(){
        int cnt = 0;
        for(int i=0; i<5; ++i){
            if(sts[0][i] == 'X')cnt++;
        
        }
        
        return cnt;
    }
}
