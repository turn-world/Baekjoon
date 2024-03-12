import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node {
        int start;
        int end;
        int distance;
        public Node(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    static int N, D, result;
    static ArrayList<Node> path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        path = new ArrayList<>();
        result = D;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (e > D) continue;
            if (e - s <= w) continue;
            path.add(new Node(s, e, w));
        }
        Collections.sort(path, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.start == o2.start){
                    return Integer.compare(o1.end,o2.end);
                    // o1이 더 크면 return 1 그럼 바뀜
                    // 오름 차순
                }
                return Integer.compare(o1.start,o2.start);
            }
        });
        int [] distance = new int[D+1];
        int move =0;
        int idx =0;
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0] = 0;

        while (move < D){
            if(idx < path.size()){
                Node s = path.get(idx);
                if(move == s.start){
                    distance[s.end] = Math.min(distance[move]+s.distance,distance[s.end]);
                    idx++;
                }else{
                    distance[move+1] = Math.min(distance[move+1],distance[move]+1);
                    move++;
                }
            }else{
                distance[move+1] = Math.min(distance[move+1],distance[move]+1);
                move++;
            }

        }
        System.out.println(distance[D]);
    }
}


