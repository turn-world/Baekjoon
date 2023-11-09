import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());


        for (int a = 1; a <= T; a++){
            int k = Integer.parseInt(in.readLine());
            Map<Integer,Integer> map = new HashMap<>();
            PriorityQueue<Integer> minque = new PriorityQueue<>();
            PriorityQueue<Integer> maxque = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 1; i <= k; i++){
                String [] input = in.readLine().split(" ");
                char ch = input[0].charAt(0);
                int n = Integer.parseInt(input[1]);
                if(ch == 'I'){
                    map.put(n, map.getOrDefault(n,0)+1);
                    minque.add(n);
                    maxque.add(n);
                } else{
                    if(map.size() == 0)
                        continue;

                    PriorityQueue<Integer> que = n == 1 ? maxque:minque;
                    removeApp(que,map);
                }
            }
        if (map.size() ==0){
            System.out.println("EMPTY");
        }else{
            int n = removeApp(maxque,map);
            System.out.println(n+ " " + (map.size()>0 ? removeApp(minque,map):n ));
        }
        }
    }
    public static int removeApp(PriorityQueue<Integer> que,Map<Integer,Integer> map){
        int num;
        while (true){
            num = que.poll();
            int cnt = map.getOrDefault(num,0);
            if( cnt == 0)
                continue;
            if(cnt == 1)
                map.remove(num);
            else
                map.put(num,cnt-1);

            break;
        }
        return num;
    }
}
