import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S1228_허서영 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			int originNum = Integer.parseInt(br.readLine());	// 원본 데이터 개수
			List<String> arr = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int idx = 0; idx < originNum; idx++) {
				arr.add(st.nextToken());
			}

			// 명령 실행
			int cmdCnt = Integer.parseInt(br.readLine());	// 명령어 개수
			st = new StringTokenizer(br.readLine());
			for (int cnt = 0; cnt < cmdCnt; cnt++) {
				st.nextToken();	// I 필요없으므로 버림
				int idx = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				for (int n = 0; n < num; n++) {
					arr.add(idx++, st.nextToken());
				}
			}

			// 앞에서 10개의 숫자 출력
			StringBuilder sb = new StringBuilder();
			for (int idx = 0; idx < 10; idx++) {
				sb.append(" " + arr.get(idx));
			}
			System.out.println("#" + test_case + sb.toString());
		}
	}
}
