class Solution {
    public String removeKdigits(String num, int k) {
        List<Integer> result = new ArrayList<>();
        String res = "";
        int n = num.length();
        if(n == k) {
            return "0";
        }
        else {
            for(char ch : num.toCharArray()) {
                int intNum = ch - '0';
                while(!result.isEmpty() && intNum < result.get(result.size() - 1) && k > 0) {
                    // System.out.println(result.get(result.size() - 1));
                    result.remove(result.size() - 1);
                    k--;
                }
                result.add(intNum);
                
            }
            System.out.println(k);
            System.out.println(result.size());
            while(k > 0) {
                result.remove(result.size() - 1);
                k--;
            }
            for(int i=0; i<result.size(); i++) {
                if(result.get(i) != 0) {
                    res += (char) (result.get(i) + '0');
                }
                else {
                    if(res.length() != 0) {
                        res += (char) (result.get(i) + '0');
                    }
                }
            }
            if(res.length() == 0) {
                return "0";
            }
            return res;
        }
    }
}