// class Solution {
//     public int maxDiff(int num) {
//         String number = Integer.toString(num);
//         int n = number.length();
//         if(n == 1) {
//             return 8;
//         }
//         String max = "";
//         String min = "";
//         char nonNine = 'a';
//         for(char ch : number.toCharArray()) {
//             if(ch != '9') {
//                 nonNine = ch;
//                 break;
//             }
//         }
//         if(nonNine == 'a') {
//             min = "1".repeat(n);
//             max = number;

//         }
//         else {
//             for(char ch : number.toCharArray()) {
//                 if(ch == nonNine) {
//                     max += 9;
//                     min += 0;
//                 }
//                 else {
//                     max += ch;
//                     min += ch;
//                 }
//             }
//         }
        
//         int numMax = Integer.parseInt(max);
//         int numMin = Integer.parseInt(min);
//         if(numMin == 0) {
//             numMin = num;
//         }
//         return (numMax - numMin);
//     }
// }

// Below appraoch is good as it handles the case when the first number is non zero then the replacement of that number is 1 and a number 571 can be converted to 171 but when the first number is 1 then we find the first non one number and if we get it we replace that with 0 or else if there no non one number like in 111 so it will remain 111.  

class Solution {
    public int maxDiff(int num) {
        String str = Integer.toString(num);
        StringBuilder maxStr = new StringBuilder(str);
        StringBuilder minStr = new StringBuilder(str);

        // Get max number by replacing first non-'9' digit
        char maxDigit = ' ';
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '9') {
                maxDigit = str.charAt(i);
                break;
            }
        }

        if (maxDigit != ' ') {
            for (int i = 0; i < maxStr.length(); i++) {
                if (maxStr.charAt(i) == maxDigit) {
                    maxStr.setCharAt(i, '9');
                }
            }
        }

        // Get min number
        char minDigit = str.charAt(0);
        char replace = '1';

        if (minDigit == '1') {
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) != '0' && str.charAt(i) != '1') {
                    minDigit = str.charAt(i);
                    replace = '0';
                    break;
                }
            }
        }

        for (int i = 0; i < minStr.length(); i++) {
            if (minStr.charAt(i) == minDigit) {
                minStr.setCharAt(i, replace);
            }
        }

        int maxVal = Integer.parseInt(maxStr.toString());
        int minVal = Integer.parseInt(minStr.toString());

        return maxVal - minVal;
    }
}