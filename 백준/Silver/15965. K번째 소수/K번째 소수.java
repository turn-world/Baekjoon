import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static boolean [] prime = new boolean[500001];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(in.readLine());
        chae();
        int count =1;
        for ( int i = 2; k <= 500000 ; i ++){
            if(!prime[i]){
                if(count == k){
                    System.out.println(i);
                    break;
                }
                count++;
            }
        }
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
