class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int s = strs[0].length();
        int ansCol = 0;
        int[] vis = new int[s];

        String strPrev = strs[0];

        for(int i=1; i<n; i++) {
            String strNext = strs[i];
            for(int j=0; j<s; j++) {
                if(vis[j] != 1) {
                    if(strPrev.charAt(j) > strNext.charAt(j)) {
                        vis[j] = 1;
                        ansCol++;
                    }
                    else {
                        // all good ! Following lexicographical order.
                    }
                }
            }
            strPrev = strNext;
        }

        return ansCol;
    }
}