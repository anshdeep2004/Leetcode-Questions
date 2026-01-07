// class Solution {
//     public String multiply(String num1, String num2) {
//         if(num1 == "0" || num2 == "0") return "0";
        
//         String finalProd = "";
//         for(int i=num1.length()-1; i>=0; i++) {
//             int carry = 0;
//             String prodStr = "";
//             for(int j=num2.length()-1; j>=0; j++) {
//                 int numI = num1.charAt(i) - '0';
//                 int numJ = num2.charAt(j) - '0';
//                 int prod = numI * numJ + carry;
//                 if(prod - prod % 10 >= 10) carry = prod / 10;
//                 else carry = 0;
//                 prodStr = String.valueOf(prod % 10) + prodStr;
//             }
//             for(int k=0; k<i; k++) {
//                 prodStr += "0";
//             }
//             if(finalProd.length() == 0) {
//                 finalProd = prodStr;
//             }
//             else {
//                 int k = finalProd.length() - 1;
//                 int m = prodStr.length() - 1;
//                 int carrySum = 0;
//                 String tempSum = "";
//                 while(k >= 0 && m >= 0) {
//                     int nk = finalProd.charAt(k) - '0';
//                     int nm = prodStr.charAt(m) - '0';

//                     int sum = nk + nm + carrySum;
//                     if(sum - sum % 10 == 10) carry = sum / 10;
//                     else carrySum = 0;
//                     tempSum = String.valueOf(sum % 10) + tempSum;
//                     k--;
//                     m--;
//                 }
//                 while(k >= 0) {
//                     int nk = finalProd.charAt(k) - '0';
//                     int sum = nk + carrySum;
//                     if(sum - sum % 10 == 10) carry = sum / 10;
//                     else carrySum = 0;
//                     tempSum = String.valueOf(sum % 10) + tempSum;
//                     k--;
//                 }
//                 while(m >= 0) {
//                     int nm = prodStr.charAt(m) - '0';
//                     int sum = nm + carrySum;
//                     if(sum - sum % 10 == 10) carry = sum / 10;
//                     else carrySum = 0;
//                     tempSum = String.valueOf(sum % 10) + tempSum;
//                     m--;
//                 }
//                 finalProd = tempSum;
//             }

//         }

//         return finalProd;
//     }
// }

class Solution {
    public String multiply(String num1, String num2) {

        // correct string comparison
        if (num1.equals("0") || num2.equals("0")) return "0";

        String finalProd = "";

        for (int i = num1.length() - 1; i >= 0; i--) {

            int carry = 0;
            String prodStr = "";

            int numI = num1.charAt(i) - '0';

            // multiply current digit of num1 with num2
            for (int j = num2.length() - 1; j >= 0; j--) {
                int numJ = num2.charAt(j) - '0';

                int prod = numI * numJ + carry;
                carry = prod / 10;
                prodStr = (prod % 10) + prodStr;
            }

            // add remaining carry
            if (carry > 0) {
                prodStr = carry + prodStr;
            }

            // add zeros (based on position)
            int zeros = num1.length() - 1 - i;
            for (int k = 0; k < zeros; k++) {
                prodStr += "0";
            }

            // add to final result
            if (finalProd.length() == 0) {
                finalProd = prodStr;
            } else {

                int k = finalProd.length() - 1;
                int m = prodStr.length() - 1;
                int carrySum = 0;
                String tempSum = "";

                while (k >= 0 && m >= 0) {
                    int sum = (finalProd.charAt(k) - '0')
                            + (prodStr.charAt(m) - '0')
                            + carrySum;

                    carrySum = sum / 10;
                    tempSum = (sum % 10) + tempSum;

                    k--;
                    m--;
                }

                while (k >= 0) {
                    int sum = (finalProd.charAt(k) - '0') + carrySum;
                    carrySum = sum / 10;
                    tempSum = (sum % 10) + tempSum;
                    k--;
                }

                while (m >= 0) {
                    int sum = (prodStr.charAt(m) - '0') + carrySum;
                    carrySum = sum / 10;
                    tempSum = (sum % 10) + tempSum;
                    m--;
                }

                // leftover carry
                if (carrySum > 0) {
                    tempSum = carrySum + tempSum;
                }

                finalProd = tempSum;
            }
        }

        return finalProd;
    }
}