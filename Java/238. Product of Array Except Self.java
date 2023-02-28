package Java;

class Solution {
  public int[] productExceptSelf(int[] nums) {
    int[] L = new int[nums.length];
    L[0] = 1;
    int[] R = new int[nums.length];
    R[nums.length - 1] = 1;

    for (int i = 0; i < nums.length; i++) {
      if (i > 0) {
        L[i] = nums[i - 1] * L[i - 1];
        R[nums.length - i - 1] = nums[nums.length - i] * R[nums.length - i];
      }
    }

    int[] res = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      res[i] = L[i] * R[i];
    }

    return res;
  }
}