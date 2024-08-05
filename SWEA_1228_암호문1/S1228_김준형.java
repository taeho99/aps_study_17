import java.io.*;
import java.util.*;

public class S1228_김준형 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        for(int t=0; t<10; t++) {
            bw.write("#"+(t+1)+" ");

            int n = Integer.parseInt(br.readLine()); // 암호문 길이

            LinkedList<String> list = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                list.add(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine()); //명령어 개수
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++) {
                String command = st.nextToken(); //명령어 종류
                int idx = Integer.parseInt(st.nextToken()); // idx 바로 다음에
                int cnt = Integer.parseInt(st.nextToken()); // cnt 개 숫자 삽입한다.

                for(int j=0; j<cnt; j++) {
                    list.add(idx+j,st.nextToken());
                }
            }
            for(int i=0; i<10; i++) {
                bw.write(list.pollFirst()+" ");
            }
            bw.newLine();
        }


        bw.flush();
        bw.close();
    }
}