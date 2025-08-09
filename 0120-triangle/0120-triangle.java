class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        int min = (int) 1e9;
        for(int i=0; i<triangle.size(); i++) {
            dp.add(new ArrayList<>());
        }
        for(int i=0; i<triangle.size(); i++) {
            for(int j=0; j<triangle.get(i).size(); j++) {
                if(i == 0 && j == 0) dp.get(i).add(triangle.get(i).get(j));
                else {
                    int upLeft = (int) 1e9;
                    int upRight = (int) 1e9;
                    if(j < dp.get(i-1).size()) upLeft = triangle.get(i).get(j) + dp.get(i-1).get(j);
                    if(j > 0) upRight = triangle.get(i).get(j) + dp.get(i-1).get(j-1);
                    dp.get(i).add(Math.min(upLeft, upRight));
                }
                if(i == triangle.size() - 1) min = Math.min(min, dp.get(i).get(j));
            }
        }
        return min;
    }
}