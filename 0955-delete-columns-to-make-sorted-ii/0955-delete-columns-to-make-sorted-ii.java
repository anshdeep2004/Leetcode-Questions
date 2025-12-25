class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int col = strs[0].length();
        int deletions = 0;
        boolean[] resolved = new boolean[n-1];
        // Arrays.fill(resolved, false);

        for(int i=0; i<col; i++) {
            boolean bad = false;
            for(int j=0; j<n-1; j++) {
                if(resolved[j] != true && strs[j].charAt(i) > strs[j+1].charAt(i)) {
                    deletions++;
                    bad = true;
                    break;
                }
            }

            // if column is to be deleted then it cannot resolve a pair, so resolved cannot be updated.
            if(bad == true) continue;

            // resolve the pair as the column is not being deleted.
            for (int j = 0; j < n - 1; j++) {
                if(!resolved[j] && strs[j].charAt(i) < strs[j + 1].charAt(i)) {
                    resolved[j] = true;
                }
            }
        }

        return deletions;
    }
}