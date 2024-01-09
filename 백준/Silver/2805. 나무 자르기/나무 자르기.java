import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine()," ");

        int []arr = new int[N];
        long max = 0;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(max < arr[i]){
                max = arr[i];
            }
        }

        long min = 0;
        long mid = 0;

        while(min < max){
            mid = (max+min)/2;

            long result=0;

            for(int i = 0; i < N; i++){
                if(arr[i] > mid){
                    result+= arr[i] - mid;
                }
            }

            if(result >= M){
                min = mid +1;
                // 증가
            }else{
                max = mid;
                // 감소
            }
        }
        System.out.println(min-1);

    }
}