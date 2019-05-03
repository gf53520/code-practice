package array;

// 136  只出现一次的数字 https://leetcode-cn.com/problems/single-number/
/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
输入: [2,2,1]
输出: 1
 */
// 异或
public class SingleNumber {
  public int singleNumber(int[] nums) {
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      res = res ^ nums[i];
    }
    return res;
  }
}
