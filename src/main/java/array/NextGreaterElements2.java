package array;


import java.util.Stack;

// 503. 下一个更大元素 II https://leetcode-cn.com/problems/next-greater-element-ii/
/*
给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。

输入: [1,2,1]
输出: [2,-1,2]
解释: 第一个 1 的下一个更大的数是 2；
数字 2 找不到下一个更大的数；
第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 */
public class NextGreaterElements2 {

  // 扩充数组到2倍求解
  // 1,2,1 => 1,2,1,1,2,1 =>  2
  public int[] nextGreaterElements(int[] nums) {

    int[] solutions = new int[nums.length];
    Stack<Integer> stack = new Stack<>();
    for (int i = 2 * nums.length - 1; i >= 0; i--) {
      int val = nums[i % nums.length];
      while (!stack.isEmpty() && val >= stack.peek()) {
        stack.pop();
      }

      solutions[i % nums.length] = (stack.isEmpty()) ? -1 : stack.peek();
      stack.push(val);
    }
    return solutions;
  }
}
