import java.util.Scanner;

public class testDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int q= sc.nextInt();
        for (int i = 0; i < q; i++) {
            int a2= sc.nextInt();
            int a3= sc.nextInt();
            int a4= sc.nextInt();
            int b4= sc.nextInt();
            int b6= sc.nextInt();
            int sum=0;
            //4放4人桌满席
            while (a4>0&&b4>0){
                a4--;b4--;sum+=4;
            }
            //2和2放4人桌满席
            while (a2>1&&b4>0){
                a2-=2;b4--;sum+=4;
            }
            //2和4放6人桌满席
            while (a2>0 && a4>0 && b6>0){
                a2--;a4--;b6--;sum+=6;
            }
            //3和3放6人桌满席
            while (a3>1 && b6>0){
                a3-=2;b6--;sum+=6;
            }
            //2、2和2放6人桌满席
            while (a2>2 && b6>0){
                a2-=3;b6--;sum+=6;
            }
            //4桌放3人,4缺一
            while (a3>0&&b4>0){
                a3--;b4--;sum+=3;
            }
            //6桌放5人，6缺一
            while (a2>0&&a3>0&&b6>0){
                a2--;a3--;b6--;sum+=5;
            }
            //4缺二
            while (a2>0&&b4>0){
                a2--;b4--;sum+=2;
            }
            //6缺二
            while (a4>0&&b6>0){
                a4--;b6--;sum+=4;
            }
            //6缺二
            while (a2>1&&b6>0){
                a2-=2;b6--;sum+=4;
            }
            //6缺三
            while (a3>0&&b6>0){
                a3--;b6--;sum+=3;
            }
            //6缺四
            while (a2>0&&b6>0){
                a2--;b6--;sum+=2;
            }
            System.out.println(sum);
        }
        sc.close();
    }
}
