import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class graph implements Comparable<graph> {
        int end;
        int dist;

        public graph(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(graph o) {
            return dist - o.dist;
        }
    }

    static int N,E;
    static int v1,v2; // 들려야 하는 곳
    static boolean[] visit; // 방문 확인
    static ArrayList<ArrayList<graph>> a;
    static int []dist;
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];
        a = new ArrayList<>();
        dist = new int[N+1];

        Arrays.fill(dist,INF);

        for(int i = 0; i <= N ; i++){
            a.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            a.get(start).add(new graph(end,cost));

            a.get(end).add(new graph(start,cost));

        }

        st = new StringTokenizer(br.readLine());

        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int first = 0,second = 0;
        first += dijkstra(1, v1);
        first += dijkstra(v1, v2);
        first += dijkstra(v2, N);

        second += dijkstra(1, v2);
        second+= dijkstra(v2, v1);
        second+= dijkstra(v1, N);

        int ans = (first >= INF && second >= INF)? -1 : Math.min(first,second);
        System.out.println(ans);
    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(dist,INF);
        Arrays.fill(visit,false);

        PriorityQueue<graph> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[N+1];
        pq.offer(new graph(start,0));
        dist[start] = 0;

        while (!pq.isEmpty()){
            graph cur = pq.poll();
            int curend = cur.end;

            if (!visit[curend]){
                visit[curend] = true;

                for (graph graph: a.get(curend)){
                    if(!visit[graph.end] && dist[graph.end] > dist[curend] +graph.dist){
                        dist[graph.end] = dist[curend] + graph.dist;
                        pq.add(new graph(graph.end,dist[graph.end]));
                    }
                }
            }
        }
        return dist[end];
    }

}
