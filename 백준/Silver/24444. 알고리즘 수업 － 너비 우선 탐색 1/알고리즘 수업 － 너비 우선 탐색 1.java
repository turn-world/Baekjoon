import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int N,M,R;
    public static StringBuilder sb = new StringBuilder();
    public static boolean []visit;
    public static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        // 저장해둘 큐와 방문 생성
        visit = new boolean[N+1];



        for(int i = 0 ; i < M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(graph.get(a) == null) graph.put(a,new ArrayList<>());
            graph.get(a).add(b);

            if(graph.get(b) == null) graph.put(b,new ArrayList<>());
            graph.get(b).add(a);

        }
        for(ArrayList<Integer> val : graph.values()){
            Collections.sort(val);
        }
        bfs(R);

    }

    public static void bfs(int R) {
        Queue<Integer> queue = new LinkedList<>();
        int count =0;
        int result[] = new int[N+1];
        queue.add(R);
        visit[R] = true;
        result[R] = ++ count;

        while (!queue.isEmpty()){
            int now = queue.poll();

            for(int i = 0 ; i< graph.get(now).size();i++){
                int next = graph.get(now).get(i);
                if(!visit[next]){
                    queue.add(next);
                    visit[next] = true;
                    result[next] = ++count;
                }
            }
        }
        for(int i=1;i<result.length;i++) System.out.println(result[i]);
    }
}
