package problems;

import java.util.Arrays;

/* leetcode 第977题-有序数组的平方 */

class Solution977 {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        int i = right;
        while (left <= right) {
            if (-A[left] > A[right]) {
                res[i] = A[left] * A[left];
                left += 1;
            } else {
                res[i] = A[right] * A[right];
                right -= 1;
            }
            i--;
        }
        return res;
    }
}
