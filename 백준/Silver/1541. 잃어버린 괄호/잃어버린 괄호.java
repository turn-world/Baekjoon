import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<String> arr = new ArrayList<>(50);
    public static int []result = new int[50];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),"-");
        while (st.hasMoreTokens()){
            arr.add(st.nextToken());
        }

        for(int i = 0; i < arr.size(); i++){
            st = new StringTokenizer(arr.get(i),"+");
            while (st.hasMoreTokens()){
                result[i] += Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < result.length; i++){
            result[0] -= result[i];
        }
        System.out.println(result[0]);
    }
}
