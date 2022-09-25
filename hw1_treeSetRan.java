import java.util.*;
public class hw1_treeSetRan {
    public static void main(String[] args) {
        System.out.println("電腦從1~100的整數中,亂數取出10個不重複的號碼....");
        TreeSet<Integer> ts = new TreeSet<>();
        TreeSet<Integer> ran = new TreeSet<>();
        int num=0;
        for(int i=1;i<=10;i++){
            num=(int)(Math.random()*100)+1;
            ts.add(num);
            if(num>30&&num<70){
                ran.add(num);
            }
            System.out.println("第"+i+"個號碼:"+num);
        }
        System.out.println("物件內元素個數為:"+ts.size());
        System.out.println("物件內元素的內容:"+ts);
        System.out.println("第一個元素內容為:"+ts.first());
        System.out.println("最後一個元素內容:"+ts.last());
        System.out.println("內容介於30~70者:"+ran);
    }
    
}