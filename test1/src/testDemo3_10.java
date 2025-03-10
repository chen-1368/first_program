import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class testDemo3_10 {
    private static String S;

    private static int getIndex(int start,int end){
        for (int i = start+1; i <= end; i++) {
            if(S.charAt(i)==S.charAt(start))
                return i-1;
        }
        return end;
    }
    //算灵感分
    private static int getLingGan(String s){
        if(s.contains("lanqiobe"))return 80;
        if(s.contains("lanqiob"))return 70;
        if(s.contains("lanqio"))return 60;
        if(s.contains("lanqi"))return 50;
        if(s.contains("lanq"))return 40;
        if(s.contains("lan"))return 30;
        if(s.contains("la"))return 20;
        if(s.contains("l"))return 10;
        return 0;
    }
    private static int getSum(String s){
        int sum=0;
        for (int i = 0; i < s.length(); i++) {
            sum+=s.charAt(i)-'a'+1;
        }
        sum+=getLingGan(s);
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N= sc.nextInt();
        S=sc.next();
        ArrayList<String> fu_sing = new ArrayList<>();
        //得到所有副歌
        for (int i = 0; i < S.length(); i++) {
            int index=S.length()-1;
            int num=i;//计数，算到哪个索引了
            while (num<index){
                index=Math.min(index,getIndex(num,index));
                num++;
            }
            fu_sing.add(S.substring(i,index+1));
        }
//        System.out.println(fu_sing);
        //求出所有副歌对应的感染力
        int[] power=new int[fu_sing.size()];
        for (int i = 0; i < power.length; i++) {
            power[i]=getSum(fu_sing.get(i));
        }
        //打印对应最高感染力的副歌
        int max=power[0];
        for (int i = 1; i < power.length; i++) {
            if(max<power[i])
                max=power[i];
        }
        TreeSet<String> set=new TreeSet<>();
        for (int i = 0; i < power.length; i++) {
            if(power[i]==max){
                set.add(fu_sing.get(i));
            }
        }
        System.out.println(set.first());
        sc.close();
    }
}
