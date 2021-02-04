package problems;

import java.util.Deque;
import java.util.LinkedList;

/* leetcode 第1614题-括号的最大嵌套深度 */

class Solution1614 {
    // 不用栈更简单
    public int maxDepth(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] arr = s.toCharArray();
        int left = 0;
        int max = 0;
        for (char c : arr) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                left--;
            }
            if (max < left) max = left;
            //max = Math.max(max, left);
        }
        return max;
    }
}
