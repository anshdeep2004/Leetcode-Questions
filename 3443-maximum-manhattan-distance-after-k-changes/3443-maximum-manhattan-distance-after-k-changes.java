class Solution {
    public int maxDistance(String s, int k) {
        int n = s.length();
        int manDis = 0;
        char convertTo = 'N';
        char safe = 'E';
        int dis = manHattenDis(s, k, convertTo, safe);
        if(dis > manDis) {
            manDis = dis;
        }
        convertTo = 'N';
        safe = 'W';
        dis = manHattenDis(s, k, convertTo, safe);
        if(dis > manDis) {
            manDis = dis;
        }
        convertTo = 'S';
        safe = 'E';
        dis = manHattenDis(s, k, convertTo, safe);
        if(dis > manDis) {
            manDis = dis;
        }
        convertTo = 'S';
        safe = 'W';
        dis = manHattenDis(s, k, convertTo, safe);
        if(dis > manDis) {
            manDis = dis;
        }
        return manDis;
    }
    public int manHattenDis(String s, int k, char convertTo, char safe) {
        int manDis = 0;
        int val = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == convertTo || s.charAt(i) == safe) {
                val++;
            }
            else {
                if(k != 0) {
                    k--;
                    val++;
                }
                else {
                    val--;
                }
            }
            if(val > manDis) {
                manDis = val;
            }
        }
        return manDis;
    }
}