import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean[] prime = new boolean [10001];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader BufferedWriter
        //InputStreamReader 문자(열이 아님)를 입력 그대로 받아들이게 해줌 10진수 utf-16으로 받아들이게 되면 한글이 깨짐
        //그래서 buffer에 한꺼번에 담아서 처리하는 거임
        // BufferedWriter는 'write()', 'flush()', 'close()'
        // write로 쓰고, flush로 담은 내용 출력 close로 닫음
        StringBuilder sb = new StringBuilder();
        //문자열끼리 더하기는 매우 비효율적임
        //StringBuilder는 변경가능한 문자열을 만들어줌
        // 이때 append를 써서 추가해주면 됨
        get_prime();

        int T  = Integer.parseInt(in.readLine());
        // Integer의 parseInt는 String타입의 숫자를 int타입으로 변환해주는 녀석
        // parseInt는 Integer의 메소드임
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
