// class Solution {
//     public boolean parseBoolExpr(String expression) {
//         Stack<Character> bracketBool = new Stack<>();
//         Stack<Character> symbol = new Stack<>();
        
//         Boolean ans = null;
//         int n = expression.length();
//         int flag = 0;

//         for(char ch : expression.toCharArray()) {
//             if(ch == '(' || ch == 'f' || ch == 't') {
//                 if(flag == 0) {
//                     if(ch == 'f') ans = false;
//                     else ans = true;
//                 }
//                 bracketBool.push(ch);
//             }
//             else if(ch == '&' || ch == '|' || ch == '!') {
//                 symbol.push(ch);
//             }
//             else if(ch == ')') {
//                 char sym = symbol.pop();
//                 if(sym == '!') ans = !(ans);

//                 while(bracketBool.peek() != '(') {
//                     char bool = bracketBool.pop();
//                     boolean b = (bool == 't') ? true : false;
                    
//                     if(sym == '|') {
//                         ans = ans | b;
//                     }
//                     else if(sym == '&') {
//                         ans = ans & b;
//                     }
//                 }

//                 bracketBool.pop();
//             }
//             else {
//                 // do nothing
//             }
//         }

//         return ans;
//     }
// }


class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> bracketBool = new Stack<>();
        Stack<Character> symbol = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ',' || ch == ' ') continue;

            if (ch == 't' || ch == 'f' || ch == '(') {
                bracketBool.push(ch);
            } 
            else if (ch == '&' || ch == '|' || ch == '!') {
                symbol.push(ch);
            } 
            else if (ch == ')') {
                char op = symbol.pop();

                boolean hasTrue = false;
                boolean hasFalse = false;

                while (bracketBool.peek() != '(') {
                    char val = bracketBool.pop();
                    if (val == 't') hasTrue = true;
                    else hasFalse = true;
                }
                bracketBool.pop(); // remove '('

                char result;
                if (op == '!') {
                    result = hasTrue ? 'f' : 't';
                } else if (op == '&') {
                    result = hasFalse ? 'f' : 't';
                } else { // '|'
                    result = hasTrue ? 't' : 'f';
                }

                bracketBool.push(result);
            }
        }

        return bracketBool.pop() == 't';
    }
}