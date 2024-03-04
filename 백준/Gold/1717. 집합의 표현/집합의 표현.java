import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n,m;
    public static int []parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        for (int i =0 ; i <= n; i++){
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int check = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(check == 0){
                union(a,b);
            }else if(check == 1){
                sb.append((isSameparent(a,b) ? "YES" : "NO")+"\n");
            }else {
                continue;
            }
        }
        System.out.println(sb);
    }

    private static boolean isSameparent(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b){
            return true;
        }
        return false;
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a < b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }

    private static int find(int a) {
        if( a == parent[a]){
            return a;
        }

        return parent[a] = find(parent[a]);
    }


}
