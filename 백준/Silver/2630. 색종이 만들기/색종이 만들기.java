import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int [][]arr;
    public static int black = 0;
    public static int white = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0,0,N);
        System.out.println(white);
        System.out.println(black);
    }

    private static void partition(int row,int col, int size) {
        if(colorcheck(row,col,size)){
            if(arr[row][col] == 0){
                white++;
            }else{
                black++;
            }
            return;
        }

        int newsize = size /2;

        partition(row,col,newsize);
        partition(row,col+newsize,newsize);
        partition(row+newsize,col,newsize);
        partition(row+newsize,col+newsize,newsize);
    }

    private static boolean colorcheck(int row, int col, int size){
        int color = arr[row][col];

        for(int i = row; i< row + size; i++){
            for(int j = col; j < col + size; j++){
                if(arr[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }

}
