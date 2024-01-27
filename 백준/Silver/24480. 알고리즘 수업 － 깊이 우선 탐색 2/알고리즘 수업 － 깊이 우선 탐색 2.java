import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int r;
    public static int m;
    static int cnt = 1;
    static boolean []visited;
    static int []order;
    static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (graph.get(k) == null) graph.put(k, new ArrayList<>());
            graph.get(k).add(v);
            if (graph.get(v) == null) graph.put(v, new ArrayList<>());
            graph.get(v).add(k);

        }

        for(ArrayList<Integer> val : graph.values()){
            Collections.sort(val,Collections.reverseOrder());
        }
        visited = new boolean[n+1];
        order = new int[n];
        dfs(r);
        for (Integer result : order){
            System.out.println(result);
        }
    }
    public static void dfs( int cur ){
        visited[cur] = true;
        order[cur-1] = cnt++;
        if(graph.get(cur) == null) return;
        for( Integer next : graph.get(cur)) if (!visited[next]) dfs(next);
    }

}
