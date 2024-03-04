import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int []arr;
    public static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int multi = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());

        result = new ArrayList<>(N^N);

        calculate (plus, minus,multi,div,1,arr[0]);

        System.out.println(Collections.max(result));
        System.out.println(Collections.min(result));
    }

    private static void calculate(int plus, int minus, int multi, int div,int cur,int res) {

        if(cur == N){
            result.add(res);
            return;
        }

        if(plus > 0 ){
            calculate(plus-1,minus,multi,div,cur+1,res+ arr[cur]);
        }
        if(minus > 0 ){
            calculate(plus,minus-1,multi,div,cur+1,res - arr[cur]);
        }
        if(multi > 0 ){
            calculate(plus,minus,multi-1,div,cur+1,res * arr[cur]);
        }
        if(div > 0 ){
            calculate(plus,minus,multi,div-1,cur+1,res / arr[cur]);
        }


    }
}
