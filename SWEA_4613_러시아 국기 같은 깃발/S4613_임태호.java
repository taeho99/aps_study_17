import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4613_임태호 {
	static String[] flag;
    static int[] pointer;
    static boolean[] visited;
    static int rowSize, colSize, result;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=testCase; t++) {
        	sb.append('#').append(t).append(' ');
        	st = new StringTokenizer(br.readLine());
        	rowSize = Integer.parseInt(st.nextToken());
        	colSize = Integer.parseInt(st.nextToken());
        	
        	flag = new String[rowSize]; //입력으로 들어온 국기
        	pointer = new int[2]; //W, B, R 구분하는 위치 2곳
            visited = new boolean[rowSize-1];
            result = Integer.MAX_VALUE; //최솟값 탐색 위해 MAX_VALUE로 초기화
            
            //[입력] 국기
            for(int row=0; row<rowSize; row++) {
            	flag[row] = br.readLine();
            }
            
            //W, B, R을 구분하는 위치를 구하기 위해 DFS 탐색
            //예를 들어, rowSize == 4 이면 W, B, R을 구분하는 위치는
            //[1,2) [2,3) [1,3)
            //중복없는 조합 (rowSize-1)C2 -> 3C2
            dfs(rowSize-1, 2, 0, 0);
            sb.append(result).append('\n');
        }
        
        System.out.print(sb);
    }

    private static void dfs(int n, int m, int depth, int at) {
        if(depth == m) {
            result = Math.min(result, match());
            return;
        }

        for(int i=at; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                pointer[depth] = i+1;
                dfs(n, m, depth+1, i+1);
                visited[i] = false;
            }
        }
    }

	private static int match() {
		int diffCnt = 0;
		
		//white matching
		//[0, pointer[0]) 위치는 W이어야 함. W가 아닌 갯수 카운팅
		for(int row=0; row<pointer[0]; row++) {
			for(char ch : flag[row].toCharArray()) {
				if(ch != 'W') diffCnt++;
			}
		}
		
		//blue matching
		//[pointer[0], pointer[1]) 위치는 B이어야 함. B가 아닌 갯수 카운팅
		for(int row=pointer[0]; row<pointer[1]; row++) {
			for(char ch : flag[row].toCharArray()) {
				if(ch != 'B') diffCnt++;
			}
		}
		
		//red matching
		//[pointer[1], rowSize) 위치는 R이어야 함. R이 아닌 갯수 카운팅
		for(int row=pointer[1]; row<rowSize; row++) {
			for(char ch : flag[row].toCharArray()) {
				if(ch != 'R') diffCnt++;
			}
		}
		
		return diffCnt;
	}
}
