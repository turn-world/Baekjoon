import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int t;
    static StringBuilder sb =new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int time = 0; time < t; time++) {

            int n = Integer.parseInt(br.readLine());
            int []su1 = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) su1[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(su1);

            int m = Integer.parseInt(br.readLine());
            int []su2 = new int[m];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < m; i++) {
                su2[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < m; i++) {
                BinarySearch(su2[i],n,su1);
            }

        }
        System.out.println(sb);
    }
    public static void BinarySearch(int val,int n,int su1[]) {
        int left = 0;
        int right = n-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (val < su1[mid]) right = mid-1;
            else if (val == su1[mid]) {
                sb.append(1).append("\n");
                return;
            } else left = mid + 1;

        }
        sb.append(0).append("\n");
    }
}