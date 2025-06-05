class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        int b = baseStr.length();
        List<TreeSet<Character>> equiList = new ArrayList<>();
        TreeSet<Character> visited = new TreeSet<>();
        String result = "";
        for(int i=0; i<n; i++) {
            if(visited.contains(s1.charAt(i)) || visited.contains(s2.charAt(i))) {
                for(int j=0; j<equiList.size(); j++) {
                    if(equiList.get(j).contains(s1.charAt(i)) || equiList.get(j).contains(s2.charAt(i))) {
                        equiList.get(j).add(s1.charAt(i));
                        equiList.get(j).add(s2.charAt(i));
                        visited.add(s1.charAt(i));
                        visited.add(s2.charAt(i));
                        break;
                    }
                }
            }
            else {
                TreeSet<Character> temp = new TreeSet<>();
                temp.add(s1.charAt(i));
                temp.add(s2.charAt(i));
                equiList.add(temp);
                visited.add(s1.charAt(i));
                visited.add(s2.charAt(i));
                //System.out.println(temp);
            }
        }
        for(int i=0; i<b; i++) {
            int flag = 0;
            for(int j=0; j<equiList.size(); j++) {
                if(equiList.get(j).contains(baseStr.charAt(i))) {
                    result += equiList.get(j).first();
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) {
                result += baseStr.charAt(i);
            }
        }
        return result;
    }
}