import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        // 끝나는 시간을 기준으로 정렬하기 위해 compare함수를 재정의함
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                // o1[1] - o2[1] >0 1로 출력
                // 작으면 -1 똑같으면 0 출력
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int prev = 0;
        for (int i = 0; i<N ; i++){
            if(prev <= time[i][0]){
                prev = time[i][1];
                count++;
            }
        }
        System.out.println(count);
    }




}
