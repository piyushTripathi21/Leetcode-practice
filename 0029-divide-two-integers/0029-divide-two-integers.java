class Solution {
    public int divide(int dividend, int divisor) {

        // Overflow case bcz if hamne -2^31 ko -1 se divide kia to -- cut jayega and value range se bhr ho jayegi
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign of answer XOR (^) operator tab true hota hai jab ek number negative ho aur dusra positive.
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Work with long to avoid overflow
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int result = 0;

        while (a >= b) {
            long temp = b;
            int multiple = 1;

            // Double temp until it exceeds a
            while (a >= (temp << 1)) {
                temp <<= 1;        // temp = temp * 2
                multiple <<= 1;   // multiple = multiple * 2
            }

            a -= temp;
            result += multiple;
        }

        return negative ? -result : result;
    }
}
