import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3499_허서영 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int num = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] strArr = new String[num];
            for (int idx = 0; idx < num; idx++) {
                strArr[idx] = st.nextToken();
            }
 
            StringBuilder sb = new StringBuilder();
            int idxL = 0;
            int idxR = (num + 1) / 2;
            for (; idxL < num / 2; idxL++, idxR++) {
                sb.append(strArr[idxL]).append(" ").append(strArr[idxR]).append(" ");
            }
            if (num%2==1) sb.append(strArr[idxL]);
            System.out.println("#" + test_case + " " + sb.toString());
        }
 
    }
}
