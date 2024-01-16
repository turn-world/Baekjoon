import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;

        while (end <= N && start <= N) {
            if (sum < S) {
                sum += arr[end++];
            } else if (sum >= S) {
                len = Math.min(len,end-start);
                sum-= arr[start++];
            }

        }
        System.out.println(len == Integer.MAX_VALUE ? 0 : len);
    }
}