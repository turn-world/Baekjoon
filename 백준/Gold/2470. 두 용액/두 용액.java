import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long arr[] = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long result = 0;
        long result1 =0;
        long result2 =0;

        int start = 0;
        int end = n-1;

        int first = 0;
        Arrays.parallelSort(arr);

        while(start < end){
            long count = arr[start] + arr[end];
            if(first == 0){
                result = count;
                result1 = arr[start];
                result2 = arr[end];
                first++;
            }

            if(Math.abs(count) < Math.abs(result)){
                result = count;
                result1 = arr[start];
                result2 = arr[end];
            }
            if(Math.abs(arr[start]) < Math.abs(arr[end])){
                end--;
            }else{
                start++;
            }
        }
        System.out.println(result1+" "+result2);


    }
}
