// class Solution {
//     public int divide(int dividend, int divisor) {
//         int min = (int)Math.pow(2, -31);
//         int max = (int)Math.pow(2, 31);
//         if(dividend < divisor && dividend > 0 && divisor > 0) {
//             return 0;
//         }
//         if (dividend == Integer.MIN_VALUE && divisor == -1) {
//             return max;
//         }
//         if(dividend == divisor) {
//             return 1;
//         }
//         if(dividend == (0 - divisor)) {
//             return -1;
//         }
//         if(divisor == 1) return dividend;
//         int newDividend = (int)Math.abs(dividend);
//         int newDivisor = (int)Math.abs(divisor);
//         int quotient = 1;
//         int temp = newDivisor;
//         while(newDividend > temp) {
//             temp += newDivisor;
//             quotient += 1;
//             // System.out.println(temp + " " + quotient);
//         }
//         if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
//             if((quotient - 1) > max) {
//                 return min;
//             }
//             else {
//                 return (0 - quotient + 1);
//             }
//         }
//         else {
//             if((quotient-1) > max) {
//                 return max;
//             }
//             else {
//                 return (quotient - 1);
//             }
//         }
//     }
// }

class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if(divisor == 1) return dividend;
        if(dividend == -1) return -dividend;
        int sign = 1;
        if(dividend>0 && divisor<0) sign = -1;
        if(dividend<0 && divisor>0) sign = -1;

        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        int ans = 0;
        while(n>=d)
        {
            int p = 0;
            while(n >= d<<p)
            p++;

            p--;
            n -= d<<p;
            ans += 1<<p;
        }
        if(ans>=Math.pow(2,31) && sign==1) return Integer.MAX_VALUE;
        if(ans>=Math.pow(2,31) && sign==-1) return Integer.MIN_VALUE;

        return ans*sign;
    }
}