import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static boolean [] prime = new boolean[8000002];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(in.readLine());
        List<Long> list = new ArrayList<Long>();
        chae();
        for (long i = 2; i < 8000000; i++) {
            //소수가 int자료형을 넘을 수 있으므로 long으로
            if (!prime[(int) i]) {
                list.add(i);
            }
        }

        System.out.println(list.get(k - 1));
    }
    public static void chae(){
        prime[0] = prime[1] = true;
        for(int i = 2 ; i <= Math.sqrt(prime.length); i ++){
            if(prime[i])
                continue;

            for(int a = i * i ; a < prime.length; a +=i){
                prime[a] = true;
            }
        }
    }
}
