import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4613_허서영 {
	static int[][] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int rowSize = Integer.parseInt(st.nextToken());
			int colSize = Integer.parseInt(st.nextToken());
			cnt = new int[rowSize + 1][3]; // 해당 줄까지를 흰/파/빨 색으로 만드는데 필요한 색칠 횟수 (1번째 줄부터 시작)

			// 입력을 받으면서 1부터 현재 row까지 누적 횟수 구하기
			// 0번째 줄은 0
			for (int row = 1; row <= rowSize; row++) {
				String line = br.readLine();
				for (int col = 0; col < colSize; col++) {
					// 현재 줄 횟수 구하기
					char color = line.charAt(col);
					if (color == 'W') { // 흰색
						cnt[row][1]++;
						cnt[row][2]++;
					} else if (color == 'B') { // 파랑
						cnt[row][0]++;
						cnt[row][2]++;
					} else { // 빨강
						cnt[row][0]++;
						cnt[row][1]++;
					}
				}
				// 최종적으로 기존 횟수 + 현재 줄 횟수
				cnt[row][0] += cnt[row - 1][0];
				cnt[row][1] += cnt[row - 1][1];
				cnt[row][2] += cnt[row - 1][2];
			}

			int ans = Integer.MAX_VALUE;
			// 어디서부터(from) 어디까지(to) 파랑색으로 칠할지
			// 예를 들어 6줄 중에서 흰색 빨간색은 한줄씩만 칠한다면 from~to는 2~5 / 파란색이 한줄이라면 2~2, 3~3 등..
			for (int from = 2; from < rowSize; from++) {
				int priceW = cnt[from - 1][0]; // 흰색 부분 총 횟수 : 파란색줄 전까지
				for (int to = from; to < rowSize; to++) {
					int priceB = cnt[to][1] - cnt[from - 1][1]; // 파란색 부분 총 횟수 : 마지막 파란색 줄 - 흰색 줄
					int priceR = cnt[rowSize][2] - cnt[to][2]; // 빨간색 부분 총 횟수 : 마지막줄 - 마지막 파란색 줄
					ans = Math.min((priceW + priceB + priceR), ans);
				}
			}

			System.out.println("#" + test_case + " " + ans);
		}
	}
}
