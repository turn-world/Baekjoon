import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int []arr = new int[N-1];

        int dasom = Integer.parseInt(in.readLine());
        for (int i = 0; i < N-1 ; i++){
            arr[i]=Integer.parseInt(in.readLine());
        }
        if(N==1){
            System.out.println("0");
            return;
        }
        search(arr,dasom);


    }

    public static void search(int []arr, int dasom){
        int count=0;

        while (true){
            Arrays.sort(arr);
            boolean pass = true;
            if(dasom <= arr[arr.length-1]){
                dasom++;
                arr[arr.length-1]--;
                count++;
                pass = false;
            }

            if(pass) break;
        }
        System.out.println(count);
    }
}
