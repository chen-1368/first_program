import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static int n,m,x1,x2,y1,y2;
    private static final int[] dx={0,0,-1,1};//上下左右
    private static final int[] dy={1,-1,0,0};//上下左右
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();m=sc.nextInt();
        x1=sc.nextInt()-1;y1=sc.nextInt()-1;
        x2=sc.nextInt()-1;y2=sc.nextInt()-1;
        //读入磁场
        char[][] map=new char[n][m];
        for (int i = 0; i < n; i++) {
            String str=sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j]=str.charAt(j);
            }
        }
        bfs(map);
        sc.close();
    }
    private static void bfs(char[][] map){
        Queue<Point> queue=new LinkedList<>();
        boolean[][] visited=new boolean[n][m];
        queue.add(new Point(x1,y1));
        visited[x1][y1]=true;
        while (!queue.isEmpty()){
            Point p=queue.poll();
            if(p.x==x2&&p.y==y2){
                System.out.println("Yes");
                return;
            }
            int a=map[p.x][p.y]-'A';
            for (int i = 0; i < 4; i++) {
                int x3=p.x+dx[i];
                int y3=p.y+dy[i];
                if(x3<0||x3>n-1||y3<0||y3>m-1)continue;
                if(visited[x3][y3])continue;
                int b=map[x3][y3]-'A';
                if((a+1)%4==b){
                    visited[x3][y3]=true;
                    queue.add(new Point(x3,y3));
                }
            }
        }
        System.out.println("No");
    }
    static class Point{
        int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}