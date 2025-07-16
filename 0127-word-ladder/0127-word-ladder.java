class Solution {
    class Pair {
        String word;
        int steps;
        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Queue<Pair> que = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);

        que.offer(new Pair(beginWord, 1));
        while(!que.isEmpty()) {
            Pair p = que.poll();
            String word = p.word;
            int steps = p.steps;
            for(int i=0; i<word.length(); i++) {
                for(char j='a'; j<='z'; j++) {
                    if(j != word.charAt(i)) {
                        String newWord = word.substring(0, i) + j + word.substring(i+1);
                        if(wordSet.contains(newWord)) {
                            if(newWord.equals(endWord)) {
                                return steps + 1;
                            }
                            que.offer(new Pair(newWord, steps + 1));
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}