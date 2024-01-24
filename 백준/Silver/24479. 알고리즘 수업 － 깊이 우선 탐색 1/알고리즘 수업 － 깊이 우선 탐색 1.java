import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        HashMap<Integer, ArrayList<Integer>> graph= new HashMap<>();
        // hashmap 해시 값으로 찾는 것으로 map 보다 빠름
        // <key,value>
        for(int i = 0 ; i< M ; i++ ){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(graph.get(k) == null) graph.put(k, new ArrayList<Integer>());
            graph.get(k).add(v);

            if(graph.get(v) == null) graph.put(v, new ArrayList<Integer>());
            graph.get(v).add(k);
        }
        // 인접 노드 오름차순으로 방문 하기 위해 연결되어 있는 노드들을 내림차순으로 정렬
        for(ArrayList<Integer> val: graph.values()){
            Collections.sort(val,Collections.reverseOrder());
        }
        boolean []visited = new boolean[N+1];
        int []order = new int[N+1];
        int cnt = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(R);

        while (!stack.empty()){
            int n = stack.pop();

            if(visited[n]) continue;

            visited[n] = true;
            cnt++;
            order[n] = cnt;

            if(graph.get(n) == null) continue;

            for(int i = 0; i< graph.get(n).size(); i++){
                if(!visited[graph.get(n).get(i)]) stack.push(graph.get(n).get(i));
            }

        }
        for(int i = 1; i < order.length; i++) System.out.println(order[i]);

    }



}
