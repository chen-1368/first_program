import java.util.Scanner;

public class testDemo3_9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N= sc.nextInt();
        double p=sc.nextDouble();
        int minK=N;
        double minCount=Double.MAX_VALUE;
        for (int k=N ; k>0 ; k--) {
            if(N==1){
                minK=1;
                break;
            }
            if(N%k==0){
                double P=Math.pow(1-p,k);
                double count=(P+(1-P)*(k+1))*N/k;
                if(k==N)
                    count=N;
                if(count<minCount){
                    minCount=count;
                    minK=k;
                }
            }
        }
        if(N==0)
            minK=0;
        System.out.println(minK);
        sc.close();
    }
}
