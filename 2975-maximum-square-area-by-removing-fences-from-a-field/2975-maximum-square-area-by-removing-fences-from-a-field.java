class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        long MOD = (int) 1e9 + 7;
        List<Integer> hList = new ArrayList<>();
        hList.add(1);
        for(int h : hFences) hList.add(h);
        hList.add(m);

        List<Integer> vList = new ArrayList<>();
        vList.add(1);
        for(int v : vFences) vList.add(v);
        vList.add(n);

        Set<Integer> set = new HashSet<>();
        long ans = 0;

        for(int i=0; i<hList.size(); i++) {
            for(int j=i+1; j<hList.size(); j++) {
                set.add(Math.abs(hList.get(j) - hList.get(i)));
            }
        }

        for(int i=0; i<vList.size(); i++) {
            for(int j=i+1; j<vList.size(); j++) {
                int val = Math.abs(vList.get(j) - vList.get(i));
                if(set.contains(val)) {
                    ans = Math.max(ans, val);
                }
            }
        }

        if(ans == 0) {
            return -1;
        }

        return (int) ((ans * ans) % MOD);
    }
}