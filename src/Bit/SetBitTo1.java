package Bit;

/**
 * Created by yizhao on 3/25/15.
 */
public class SetBitTo1 {
    public static void main(String[] args) {
        System.out.println(setBitTo1(16, 0)); // 17
        System.out.println(setBitTo1(16, 1)); // 18
        System.out.println(setBitTo1(16, 2)); // 20
        System.out.println(setBitTo1(16, 3)); // 24
        System.out.println(setBitTo1(16, 4)); // 16
    }

    public static int setBitTo1(int n, int k) {
        return n |= (1 << k);
    }
}
