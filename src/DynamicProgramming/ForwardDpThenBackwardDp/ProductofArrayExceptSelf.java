package DynamicProgramming.ForwardDpThenBackwardDp;

import java.util.Arrays;

/**
 * Created by yizhao on 8/15/15.
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

        int[] dpForward = new int[n];
        int[] dpBackward = new int[n];

        dpForward[0] = 1;
        dpBackward[n - 1] = 1;

        //scan from left to right, [1, 1, 2, 6, 24]
        for (int i = 0; i < n - 1; i++) {
            dpForward[i + 1] = nums[i] * dpForward[i];
        }

        //scan from right to left, [120, 60, 20, 5, 1]
        for (int i = n - 1; i > 0; i--) {
            dpBackward[i - 1] = dpBackward[i] * nums[i];
        }

        //multiply
        for (int i = 0; i < n; i++) {
            result[i] = dpForward[i] * dpBackward[i];
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