import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[][] Arr;
    static int[][] Dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = 1;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N==0) break;
            Arr = new int[N][N];
            Dist = new int[N][N];
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    Arr[i][j] = Integer.parseInt(st.nextToken());
                    Dist[i][j] = Integer.MAX_VALUE;
                }
            }
            Dijkstra();
            sb.append("Problem ").append(T).append(": ").append(Dist[N-1][N-1]).append("\n");
            T ++ ;
        }
        System.out.println(sb);
    }
    public static void Dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>(((o1, o2) -> o1.time-o2.time));
        q.add(new Node(0, 0, Arr[0][0]));
        Dist[0][0] = Arr[0][0];
        while(!q.isEmpty()) {
            Node Now = q.poll();
            int x = Now.x;
            int y= Now.y;
            for(int i=0;i<4;i++) {
                int Nowx = x+dx[i];
                int Nowy = y+dy[i];
                if(0>Nowx||0>Nowy||N<=Nowx||N<=Nowy) continue;
                if(Dist[x][y]+Arr[Nowx][Nowy]<Dist[Nowx][Nowy]) {
                    Dist[Nowx][Nowy] = Dist[x][y]+Arr[Nowx][Nowy];
                    q.add(new Node(Nowx, Nowy, Dist[Nowx][Nowy]));
                }
            }
        }
    }
}
class Node{
    int x, y, time;
    public Node(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}