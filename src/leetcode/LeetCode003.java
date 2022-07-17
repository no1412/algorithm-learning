package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">3. 无重复字符的最长子串</a>
 */
class LeetCode003 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        // 定义左右游标
        int left = 0, right = 0;
        // 记录最大不重复字符串结果
        int result = 0;

        // 遍历字符串
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            right++;

            // 记录右侧游标的出现次数+1，默认值为0，
            window.put(rightChar, window.computeIfAbsent(rightChar, key -> 0) + 1);

            // 是否左侧游标需要向右移动收缩，直到右侧游标对应的出现的次数降为1
            while(window.get(rightChar) > 1 && left <= right) {
                char leftChar = s.charAt(left);
                left++;
                // 窗口数据更新，将窗口左侧的字符对应出现的次数 - 1
                window.put(leftChar, window.get(leftChar) - 1);
            }
            // 左闭右开区间，和已有的最大值作比较
            result = Integer.max(result, right - left);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode003().lengthOfLongestSubstring("abcadefgh"));
    }
}