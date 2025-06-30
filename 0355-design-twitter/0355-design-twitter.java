// class Twitter {
//     PriorityQueue<int[]> tweetList;
//     HashMap<Integer, List<Integer>> followers;
//     int time;
//     public Twitter() {
//         tweetList = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
//         followers = new HashMap<>();
//         time = 0;
//     }
    
//     public void postTweet(int userId, int tweetId) {
//         int[] tweetFormat = new int[3];
//         tweetFormat[0] = tweetId;
//         tweetFormat[1] = userId;
//         tweetFormat[2] = time;
//         this.time += 1;
//         tweetList.add(tweetFormat);
//     }
    
//     public List<Integer> getNewsFeed(int userId) {
//         List<Integer> newsFeed = new ArrayList<>();
//         int limit = 0;
//         for(int[] tweet : tweetList) {
//             if(limit == 10) break;
//             if(tweet[1] == userId || followers.getOrDefault(userId, new ArrayList<>()).contains(tweet[1])) {
//                 System.out.println(tweet[0] + " " + tweet[2]);
//                 newsFeed.add(tweet[0]);
//             }
//             limit++;
//         }
//         return newsFeed;
//     }
    
//     public void follow(int followerId, int followeeId) {
//         List<Integer> follow = followers.getOrDefault(followerId, new ArrayList<>());
//         follow.add(followeeId);
//         followers.put(followerId, follow);
//     }
    
//     public void unfollow(int followerId, int followeeId) {
//         List<Integer> follow = followers.getOrDefault(followerId, new ArrayList<>());
//         if(follow.contains(followeeId)) {
//             follow.remove(Integer.valueOf(followeeId));
//             followers.put(followerId, follow);
//         }
//     }
// }

// /**
//  * Your Twitter object will be instantiated and called as such:
//  * Twitter obj = new Twitter();
//  * obj.postTweet(userId,tweetId);
//  * List<Integer> param_2 = obj.getNewsFeed(userId);
//  * obj.follow(followerId,followeeId);
//  * obj.unfollow(followerId,followeeId);
//  */


// above aprroach is good but sometimes the decreasing order does'nt work properly. So below approach is better.

import java.util.*;

class Twitter {

    // Global timestamp
    private int time;

    // userId -> set of followees
    private Map<Integer, Set<Integer>> followMap;

    // userId -> list of tweets (each as int[]: {tweetId, userId, timestamp})
    private Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{tweetId, userId, time++});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2])); // max-heap by timestamp

        // Get all followees + self
        Set<Integer> users = new HashSet<>();
        users.add(userId);
        if (followMap.containsKey(userId)) {
            users.addAll(followMap.get(userId));
        }

        for (int uid : users) {
            List<int[]> tweets = tweetMap.getOrDefault(uid, new ArrayList<>());
            for (int[] tweet : tweets) {
                pq.offer(tweet);
            }
        }

        List<Integer> res = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            res.add(pq.poll()[0]); // tweetId
            count++;
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
