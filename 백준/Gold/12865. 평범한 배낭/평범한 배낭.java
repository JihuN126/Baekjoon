import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] W= new int[N+1];
        int[] V= new int[N+1];
        int[][] MaxValue = new int[N+1][K+1];
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=K;j++){
                MaxValue[i][j] = MaxValue[i-1][j];
                if(j-W[i]>=0) MaxValue[i][j] = Math.max(MaxValue[i-1][j], V[i]+MaxValue[i-1][j-W[i]]);
            }
        }
        System.out.println(MaxValue[N][K]);
    }
}