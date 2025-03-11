import java.util.Scanner;
import java.util.TreeSet;

public class testDemo3_11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N= sc.nextInt();
        TreeSet<Integer> positions=new TreeSet<>();
        for (int i = 0; i < N; i++) {
            positions.add(sc.nextInt());
        }
        while(positions.size()>1){
            //拷贝的位置
            int[] p=positions.stream().mapToInt(Integer::intValue).toArray();
            //猪跑的方向
            int[] direction=new int[p.length];
            int left_distance=Integer.MAX_VALUE;
            for (int i = 0; i < p.length; i++) {
                if(i==p.length-1){
                    direction[i]=-1;
                    break;
                }
                int tem=p[i+1]-p[i];
                direction[i]= left_distance <= tem?-1:1;
                left_distance=tem;
            }
            positions=new TreeSet<>();
            for (int i = 0; i < p.length; i++) {
                positions.add(p[i]+direction[i]);
            }
        }
        System.out.println(positions.first());
        sc.close();
    }
}
