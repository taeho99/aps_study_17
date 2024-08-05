package aps_study_17;

import java.io.IOException;
import java.util.Scanner;

public class S6109_허서영 {
	static int size;
	static int[][] board;

	public static void main(String args[]) throws IOException {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			size = sc.nextInt();
			String cmd = sc.next();
			board = new int[size][size];
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					board[row][col] = sc.nextInt();
				}
			}

			if (cmd.equals("up")) {
				// 합치기
				for (int col = 0; col < size; col++) {
					for (int row = 0; row < size - 1; row++) {
						if (board[row][col] == 0) {
							continue;
						}

						int nr = row;
						while (++nr < size && board[nr][col] == 0) {
						}
						if (nr >= size)
							continue;
						if (board[row][col] == board[nr][col]) {
							board[row][col] *= 2;
							board[nr][col] = 0;
							row = nr;
						} else {
							row = nr - 1;
						}
					}
				}
				// 당기기
				for (int col = 0; col < size; col++) {
					for (int row = 0; row < size - 1; row++) {
						if (board[row][col] == 0) {
							int nr = row;
							while (++nr < size && board[nr][col] == 0) {
							}
							if (nr >= size)
								continue;
							board[row][col] = board[nr][col];
							board[nr][col] = 0;
						}
					}
				}
			} else if (cmd.equals("down")) {
				// 합치기
				for (int col = 0; col < size; col++) {
					for (int row = size - 1; row > 0; row--) {
						if (board[row][col] == 0) {
							continue;
						}

						int nr = row;
						while (--nr >= 0 && board[nr][col] == 0) {
						}
						if (nr < 0)
							continue;
						if (board[row][col] == board[nr][col]) {
							board[row][col] *= 2;
							board[nr][col] = 0;
							row = nr;
						} else {
							row = nr + 1;
						}
					}
				}
				// 당기기
				for (int col = 0; col < size; col++) {
					for (int row = size - 1; row > 0; row--) {
						if (board[row][col] == 0) {
							int nr = row;
							while (--nr >= 0 && board[nr][col] == 0) {
							}
							if (nr < 0)
								continue;
							board[row][col] = board[nr][col];
							board[nr][col] = 0;
						}
					}
				}
			} else if (cmd.equals("left")) {
				// 합치기
				for (int row = 0; row < size; row++) {
					for (int col = 0; col < size - 1; col++) {
						if (board[row][col] == 0) {
							continue;
						}

						int nc = col;
						while (++nc < size && board[row][nc] == 0) {
						}
						if (nc >= size)
							continue;
						if (board[row][col] == board[row][nc]) {
							board[row][col] *= 2;
							board[row][nc] = 0;
							col = nc;
						} else {
							col = nc - 1;
						}
					}
				}
				// 당기기
				for (int row = 0; row < size; row++) {
					for (int col = 0; col < size - 1; col++) {
						if (board[row][col] == 0) {
							int nc = col;
							while (++nc < size && board[row][nc] == 0) {
							}
							if (nc >= size)
								continue;
							board[row][col] = board[row][nc];
							board[row][nc] = 0;
						}
					}
				}
			} else {
				// 합치기
				for (int row = 0; row < size; row++) {
					for (int col = size - 1; col >= 0; col--) {
						if (board[row][col] == 0) {
							continue;
						}

						int nc = col;
						while (--nc >= 0 && board[row][nc] == 0) {
						}
						if (nc < 0)
							continue;
						if (board[row][col] == board[row][nc]) {
							board[row][col] *= 2;
							board[row][nc] = 0;
							col = nc;
						} else {
							col = nc + 1;
						}
					}
				}
				// 당기기
				for (int row = 0; row < size; row++) {
					for (int col = size - 1; col >= 0; col--) {
						if (board[row][col] == 0) {
							int nc = col;
							while (--nc >= 0 && board[row][nc] == 0) {
							}
							if (nc < 0)
								continue;
							board[row][col] = board[row][nc];
							board[row][nc] = 0;
						}
					}
				}
			}

			// 출력
			System.out.println("#" + test_case);
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					System.out.print(board[row][col] + " ");
				}
				System.out.println();
			}

		}
	}

}