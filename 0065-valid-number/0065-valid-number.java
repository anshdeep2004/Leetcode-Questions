class Solution {
    public boolean isNumber(String s) {
        s = s.trim();

        boolean pointAppear = false;
        boolean eAppear = false;
        boolean numberAppear = false;
        boolean numAfterEAppear = true;

        for(int i=0; i<s.length(); i++) {
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberAppear = true;
                numAfterEAppear = true;
            } 
            else if(s.charAt(i) == '.') {
                if(eAppear || pointAppear) return false;
                pointAppear = true;
            }
            else if(s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if(eAppear || !numberAppear) return false;
                eAppear = true;
                numAfterEAppear = false;
            }
            else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E') return false;
            }
            else {
                return false;
            }
        }

        return numberAppear && numAfterEAppear;
    }

    // public boolean isNumber(String s) {
    //     s = s.trim();
        
    //     boolean pointSeen = false;
    //     boolean eSeen = false;
    //     boolean numberSeen = false;
    //     boolean numberAfterE = true;
    //     for(int i=0; i<s.length(); i++) {
    //         if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
    //             numberSeen = true;
    //             numberAfterE = true;
    //         } else if(s.charAt(i) == '.') {
    //             if(eSeen || pointSeen) {
    //                 return false;
    //             }
    //             pointSeen = true;
    //         } else if(s.charAt(i) == 'e') {
    //             if(eSeen || !numberSeen) {
    //                 return false;
    //             }
    //             numberAfterE = false;
    //             eSeen = true;
    //         } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
    //             if(i != 0 && s.charAt(i-1) != 'e') {
    //                 return false;
    //             }
    //         } else {
    //             return false;
    //         }
    //     }
        
    //     return numberSeen && numberAfterE;
    // }
}