import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int []A = new int [N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine()," ");
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            int key = Integer.parseInt(st.nextToken());

            sb.append(upper(A,key)-lower(A,key)).append(' ');
        }
        System.out.print(sb);
    }

    public static int lower(int []A, int key){
        int lo = 0;
        int hi = A.length;

        while(lo <  hi){
            int mid = (lo + hi)/2;
            if(key <= A[mid] ){
                hi = mid;
            }else{
                lo = mid+1;
            }

        }
        return lo;
    }

    public static int upper(int []A, int key){
        int lo = 0;
        int hi = A.length;
        while (lo < hi){
            int mid = (lo+hi)/2;
            if(key < A[mid]){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }

}
