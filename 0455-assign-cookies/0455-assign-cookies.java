class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int contentChild = 0;
        int greed = 0;
        int size = 0;
        while(greed < g.length && size < s.length) {
            if(g[greed] <= s[size]) {
                contentChild++;
                greed++;
                size++;
            }
            else {
                size++;
            }
        }
        return contentChild;
    }
}