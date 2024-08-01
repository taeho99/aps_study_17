import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class S6958_허서영 {
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int person = sc.nextInt(); // 사람수
            int cnt = sc.nextInt(); // 대회 횟수
 
            List<Integer> winCnt = new ArrayList<>(); // 사람별 우승 횟수 합
            for (int row = 0; row < person; row++) { // 입력 받으면서 우승 횟수 세기
                int sum = 0;
                for (int col = 0; col < cnt; col++) {
                    if (sc.nextInt() == 1) { // 1 : 승리
                        sum++;
                    }
                }
                winCnt.add(sum);
            }
 
            // 최대 우승 횟수 찾기
            int maxCnt = Collections.max(winCnt);
            // 동점 몇명인지 확인
            int maxPerson = 0;
            for (int idx = 0; idx < person; idx++) {
                if (maxCnt == winCnt.get(idx)) {
                    maxPerson++;
                }
            }
            System.out.println("#" + test_case + " " + maxPerson + " " + maxCnt);
        }
    }
}
