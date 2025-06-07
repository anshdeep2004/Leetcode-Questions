// class Solution {
//     public String clearStars(String s) {
//         int n = s.length();
//         List<Character> ch = new ArrayList<>();
//         StringBuilder result = new StringBuilder();
//         PriorityQueue<Character> pq = new PriorityQueue<>();
//         for(char c : s.toCharArray()) {
//             if(!ch.isEmpty() && !pq.isEmpty() && c == '*') {
//                 char minChar = pq.poll();
//                 int lastIndexOfMinChar = ch.lastIndexOf(minChar);
//                 ch.remove(lastIndexOfMinChar);
//                 continue;
//             }
//             pq.offer(c);
//             ch.add(c);
//         }
//         for(int i=0; i<ch.size(); i++) {
//             result.append(ch.get(i));
//         }
//         return result.toString();
//     }
// }

// above approach is good but the only problem is that when it wants to return the lexographically smallest string then it uses more complexity due to which only 2 testcases don't pass this approach.

import java.util.*;

class Solution {
    public String clearStars(String s) {
        Set<Integer> toRemove = new HashSet<>();
        Map<Character, List<Integer>> mp = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    List<Integer> list = mp.getOrDefault(ch, new ArrayList<>());
                    if (!list.isEmpty()) {
                        int idx = list.get(list.size() - 1);  // get last index
                        toRemove.add(idx);
                        list.remove(list.size() - 1);         // remove last index
                        mp.put(ch, list);
                        break;
                    }
                }
            } else {
                mp.putIfAbsent(c, new ArrayList<>());
                mp.get(c).add(i);  // add index of character
            }
        }

        // Build result string
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!toRemove.contains(i) && c != '*') {
                res.append(c);
            }
        }

        return res.toString();
    }
}
