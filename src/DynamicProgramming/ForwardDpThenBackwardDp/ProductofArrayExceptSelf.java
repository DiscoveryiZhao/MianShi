package DynamicProgramming.ForwardDpThenBackwardDp;

import java.util.Arrays;

/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
*/
public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf_1(new int[]{1, 0}))); // [0,1]
        System.out.println(Arrays.toString(productExceptSelf_1(new int[]{0, 0}))); // [0,0]
        System.out.println(Arrays.toString(productExceptSelf_1(new int[]{1, 2, 3, 4, 5}))); // [120, 60, 40, 30, 24]
    }

    /*
    * space O(n)
    * */
    public static int[] productExceptSelf_1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int[] dpF = new int[n];
        int[] dpB = new int[n];

        dpF[0] = 1;
        dpB[n - 1] = 1;

        //scan from left to right, [1, 1, 2, 6, 24]
        for (int i = 0; i < n - 1; i++) {
            dpF[i + 1] = nums[i] * dpF[i];
        }

        //scan from right to left, [120, 60, 20, 5, 1]
        for (int i = n - 1; i > 0; i--) {
            dpB[i - 1] = dpB[i] * nums[i];
        }

        //multiply
        for (int i = 0; i < n; i++) {
            result[i] = dpF[i] * dpB[i];
        }

        return result;
    }


    /*
    * space O(1)
    * */
    public int[] productExceptSelf_2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[result.length - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            result[i] = result[i + 1] * nums[i + 1];
        }

        int left = 1;
        for (int i = 0; i < n; i++) {
            result[i] *= left;
            left *= nums[i];
        }

        return result;
    }
}
