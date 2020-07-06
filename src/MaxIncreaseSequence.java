import java.util.Arrays;

/**
 * @program: algorithm-learning
 * @description: 最⻓递增⼦序列
 * @author: Malcolm Li
 * @create: 2020-07-06 18:30
 */
public class MaxIncreaseSequence {


  /**
   * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
   * 示例:
   *
   * 输入: [10,9,2,5,3,7,101,18]
   * 输出: 4
   * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
   * @param nums 无序的整数数组
   * @return 最长上升子序列的长度
   */
  public static int lengthOfLIS(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    // 声明dp数组，dp[i]表示以nums[i]结尾的最长上升子序列的长度
    int[] dp = new int[nums.length];
    // base case：dp 数组全都初始化为 1
    Arrays.fill(dp, 1);

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }
    int maxSequenceLength = 1;
    for (int i : dp) {
      System.out.print(i + " ");
      maxSequenceLength = Math.max(i, maxSequenceLength);
    }
    System.out.println();
    return maxSequenceLength;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
  }
}
