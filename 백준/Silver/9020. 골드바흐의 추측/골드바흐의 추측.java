import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
        false : 소수
        range : 0 ~ 10000
    */
    public static boolean[] prime = new boolean[10001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader BufferedWriter
        //InputStreamReader 문자(열이 아님)를 입력 그대로 받아들이게 해줌 10진수 utf-16으로 받아들이게 되면 한글이 깨짐
        //그래서 buffer에 한꺼번에 담아서 처리하는 거임
        StringBuilder sb = new StringBuilder();

        get_prime();

        int T = Integer.parseInt(br.readLine());	// 테스트케이스

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int first_partition = n / 2;
            int second_partition = n / 2;

            while (true) {

                // 두 파티션이 모두 소수일 경우
                if (!prime[first_partition] && !prime[second_partition]) {
                    sb.append(first_partition).append(' ').append(second_partition).append('\n');
                    break;
                }
                first_partition--;
                second_partition++;
            }
        }
        System.out.print(sb);
    }
    public static void get_prime() {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i])
                continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
