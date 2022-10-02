public class hw3_HSR implements Runnable{
    static int tickets=10000;
    int tk;
    Thread tre;
    public static int sellT;
    hw3_HSR(String machine){
        tk=0;
        tre = new Thread(this,machine);
        tre.start();
    }
    public void run(){
        while(sellTicket()==true){
            sellT=(int)(Math.random()*4)+1;
           while (tickets<sellT) {
            sellT=(int)(Math.random()*sellT)+1;
           }
           tickets-=sellT;
            System.out.println(tre.getName()+" run: "+sellT);

            tk=tk+sellT;
            
            //System.out.println(tre.getName()+" 賣了"+sellT+" 張票("+tickets);
        }
        System.out.println(tre.getName()+" 總共賣了"+this.tk+" 張票");
    }
    synchronized static boolean sellTicket(){
        
        if(tickets>0){
           System.out.println("syn: "+sellT+", tickets: "+tickets);
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        hw3_HSR m1 = new hw3_HSR("machine A");
        hw3_HSR m2 = new hw3_HSR("machine B");
        hw3_HSR m3 = new hw3_HSR("machine C");
        hw3_HSR m4 = new hw3_HSR("machine D");
        
    }
}
