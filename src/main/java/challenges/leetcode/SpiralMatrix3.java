package challenges.leetcode;

import java.util.Arrays;

/**
 * @date Aug 17, 2018 3:33:42 PM
 * @author Darpan Shah
 */

public class SpiralMatrix3 {
	public static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
		int[][] ans = new int[(R * C)][2];
		int i = 0;
		int rx = r0;
		int ry = c0;
		int dx = r0;
		int dy = c0 + 1;
		int lx = r0 + 1;
		int ly = c0 + 1;
		int tx = r0 + 1;
		int ty = c0 - 1;
		int count = 0;

		while (count != (R * C)) {
			int y = ry;
			while (rx >= 0 && y < dy) {
				if (y >= 0 && y < C) {
					System.out.println("right: " + rx + "," + y);
					ans[i++] = new int[] { rx, y };
					++count;
				}
				++y;
			}
			rx--;
			ry--;
			int x = dx;
			while (dy < C && x < lx) {
				if (x >= 0 && x < R) {
					System.out.println("down: " + x + "," + dy);
					ans[i++] = new int[] { x, dy };
					count++;
				}
				++x;
			}
			dx--;
			dy++;
			y = ly;
			while (lx < R && y > ty) {
				if (y >= 0 && y < C) {
					System.out.println("left: " + lx + "," + y);
					ans[i++] = new int[] { lx, y };
					count++;
				}
				--y;
			}
			lx++;
			ly++;
			x = tx;
			while (ty >= 0 && x > rx) {
				if (x >= 0 && x < R) {
					System.out.println("top: " + x + "," + ty);
					ans[i++] = new int[] { x, ty };
					count++;
				}
				--x;
			}
			tx++;
			ty--;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[][] ans = spiralMatrixIII(2, 2, 0, 2);
		int y = 3;
		for (int[] x : ans) {
			System.out.print(Arrays.toString(x) + " ");
			if (y-- == 0) {
				System.out.println();
				y = 3;
			}
		}
	}
}