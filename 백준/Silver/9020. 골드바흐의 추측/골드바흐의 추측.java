import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean[] prime = new boolean [10001];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        get_prime();

        int T  = Integer.parseInt(in.readLine());

        while (T-- > 0){
            int a = Integer.parseInt(in.readLine());
            int first_partion = a/2;
            int second_partion = a/2;

            while (true){
                if(!prime[first_partion] && !prime[second_partion]){
                    sb.append(first_partion).append(' ').append(second_partion).append('\n');
                    break;
                }
                first_partion--;
                second_partion++;
            }
        }
        System.out.print(sb);
    }
    // 에라토스테네스의 채
    public static void get_prime(){
        prime[0] = prime[1] = true;

        for( int i = 2; i <= Math.sqrt(prime.length);i++){
            // 이미 체크된 배열이면 다음 반복문으로 skip
            if(prime[i])
                continue;
            // i의 배수들을 걸러주기 위한 반복문
            // true일 경우 소수가 아니다.
            for(int j = i * i; j < prime.length; j +=i){
                prime[j] = true;
            }
        }
    }
}
