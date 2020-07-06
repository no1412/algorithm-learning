/**
 * @program: algorithm-learning
 * @description:
 * @author: Malcolm Li
 * @create: 2020-07-06 17:53
 */
public class DynamicArraySum {
  public static int[] runningSum(int[] nums) {
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        result[i] = nums[i];
      } else {
        result[i] = result[i-1] + nums[i];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] ints = runningSum(new int[]{1, 2, 3, 4});
    for (int anInt : ints) {
      System.out.println(anInt);

    }
  }
}
