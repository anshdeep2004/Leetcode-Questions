class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        String ch = String.valueOf(x);
        int w = words.length;
        for(int i=0; i<w; i++) {

            if(words[i].contains(ch)) {
                result.add(i);
            }
        }
        return result;
    }
}