package problems;

/* leetcode 第1528题-重新排列字符串 */

class Solution1528 {
    public String restoreString(String s, int[] indices) {
        int length = s.length();
        char[] result = new char[length];

        for (int i = 0; i < length; i++) {
            result[indices[i]] = s.charAt(i);
        }
        return new String(result);
    }
}
