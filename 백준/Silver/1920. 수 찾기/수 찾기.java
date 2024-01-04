    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.StringTokenizer;

    public class Main {
        public static void main (String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(in.readLine());

            int []A = new int[N];
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            // N과 배열 A를 받음

            for(int i = 0 ; i < N ; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);

            int M = Integer.parseInt(in.readLine());
            st = new StringTokenizer(in.readLine()," ");

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < M; i++){
                if(Arrays.binarySearch(A,Integer.parseInt(st.nextToken())) >= 0 ){
                    sb.append(1).append('\n');
                }else{
                    sb.append(0).append('\n');
                }
            }
            System.out.println(sb);
        }

        public static int BinarySerach(int N, int A[]) {
            int lo = 0;
            int hi = A.length -1;

            while(lo <= hi){
                int mid = (lo + hi) /2;

                if(N < A[mid]){
                    hi = mid -1;
                }
                else if (N == A[mid]){
                    return 1;
                }
                else if (N > A[mid]){
                    hi = mid +1;
                }

            }

            return 0;
        }
    }
