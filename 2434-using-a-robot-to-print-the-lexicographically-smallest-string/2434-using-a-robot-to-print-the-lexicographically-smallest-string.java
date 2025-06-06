class Solution {
    public String robotWithString(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        Stack<Character> st = new Stack<>();
        char min = 'a';
        String result = "";
        for(char i='a'; i<='z'; i++) {
            freq.put(i, 0);
        }
        for(int j=0; j<s.length(); j++) {
            char c = s.charAt(j);
            freq.put(c, freq.get(c) + 1);
        }
        for(char ch : s.toCharArray()) {
            st.push(ch);
            freq.put(ch, freq.get(ch) - 1);
            while(freq.get(min) == 0 && min != 'z') min++;
            while(!st.isEmpty() && st.peek() <= min) result += st.pop();
        }
        return result;
    }
}