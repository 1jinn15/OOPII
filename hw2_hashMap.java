import java.util.*;
public class hw2_hashMap {
    public static void main(String[] args) {
        HashMap<Integer,String> list = new HashMap<>();
        list.put(1, "January");
        list.put(2, "February");
        list.put(3, "March");
        list.put(4, "April");
        list.put(5, "May");
        list.put(6, "June");
        list.put(7, "July");
        list.put(8, "August");
        list.put(9, "September");
        list.put(10, "October");
        list.put(11, "November");
        list.put(12, "December");
        while (true) {
            System.out.println("請輸入 1~12?");
            Scanner sc = new Scanner(System.in);
            int num= sc.nextInt();
            if(num<1||num>12){
                System.out.println("範圍錯誤!");
                continue;
            }else{
                System.out.println("第"+num+"月的英文單字為 "+list.get(num));
                break;
            }
        }
    }
}
