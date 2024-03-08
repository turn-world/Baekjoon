import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int []arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N+1];

        for(int i = 1 ; i <= N; i++){
            arr[0] = 0;
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(arr[b]-arr[a-1]).append("\n");
        }

        System.out.println(sb);
    }
}
