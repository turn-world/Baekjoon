import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        //StringTokenizer 클래스의 메서드로 입력을 받아들이면, 라인 단위로
        // 읽어들일 수 밖에 없음 문자를 토큰화 하다
        // nextToken(String delim) delim 기준으로 다음 토큰 반환

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = search(arr, N, M);
        System.out.println(result);
    }

    static int search(int[] arr, int N, int M) {
        int result = 0;
        for (int i = 0; i < N - 2; i++) {

            if (arr[i] > M) continue;

            for (int j = i + 1; j < N - 1; j++) {

                if (arr[i] + arr[j] > M) continue;

                for (int k = j + 1; k < N; k++) {

                    int temp = arr[i] + arr[j] + arr[k];

                    if (M == temp) {
                        return temp;
                    }

                    if (result < temp && temp < M) {
                        result = temp;
                    }
                }
            }
        }

        return result;
    }
}