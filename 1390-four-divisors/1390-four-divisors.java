class Solution {
    public boolean primeNumber(int num) {
        if(num < 2) return false;
        if(num == 2) {
            return true;
        }
        if(num % 2 == 0) return false;

        for(int i=3; i*i<=num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for(int num : nums) {
            int p = (int) Math.round(Math.cbrt(num));
            if(p * p * p == num && primeNumber(p)) {
                ans += (1 + p + p*p + num);
                continue;
            }


            int flag = 0;
            int primeFact = 0;
            for(int i=2; i * i<=num; i++) {
                if(num % i == 0 && i != (num / i) && primeNumber(i) && primeNumber(num / i)) {
                    flag = 1;
                    primeFact = i;
                    break;
                }
            }
            if(flag == 1) {
                ans += (1 + primeFact + (num / primeFact) + num);
            }
        }

        return ans;
    }
}