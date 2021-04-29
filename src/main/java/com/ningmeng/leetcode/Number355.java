package com.ningmeng.leetcode;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Number355 {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        Consumer<Integer> f = e -> System.out.print(e + "\t");
//        twitter.postTweet(1,5);
//        twitter.getNewsFeed(1).forEach(f);
//        System.out.println();
//        twitter.follow(1,2);
//        twitter.postTweet(2,6);
//        twitter.getNewsFeed(1).forEach(f);
//        System.out.println();
//        twitter.unfollow(1,2);
//        twitter.getNewsFeed(1).forEach(f);
//        System.out.println();
//        twitter.postTweet(3,7);
//        twitter.follow(1,3);
//
//        int idx = 8;
//        Random random = new Random();
//        for (int i = 1; i < 100; i++) {
//            twitter.postTweet(random.nextInt(1000) % 3 + 1, idx++);
//        }
//
//        System.out.println("------");
//
//        twitter.getNewsFeed(1).forEach(f);
//        System.out.println();
//        twitter.getNewsFeed(2).forEach(f);
//        System.out.println();
//        twitter.getNewsFeed(3).forEach(f);

        twitter.postTweet(1,1);
        twitter.getNewsFeed(1).forEach(f);
        System.out.println();
        twitter.follow(2, 1);

    }



    static class Twitter {

        private class Tweet {
            int id;
            int time;
            public Tweet(int id, int time) {
                this.id = id;
                this.time = time;
            }

        }

        private final HashMap<Integer, LinkedList<Tweet>> twitterUserMap = new HashMap<>();
        private final HashMap<Integer, Set<Integer>> relation = new HashMap<>();
        private final AtomicInteger count = new AtomicInteger(0);
        /** Initialize your data structure here. */
        public Twitter() {

        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            if (twitterUserMap.containsKey(userId)) {
                LinkedList<Tweet> queue = twitterUserMap.get(userId);
                if (queue.size() == 10) {
                    queue.removeFirst();
                }
                queue.addLast(new Tweet(tweetId, count.getAndIncrement()));
            } else {
                LinkedList<Tweet> queue = new LinkedList<>();
                queue.addLast(new Tweet(tweetId, count.getAndIncrement()));
                twitterUserMap.put(userId, queue);

                if (!relation.containsKey(userId)) {
                    HashSet<Integer> list = new HashSet<>();
                    list.add(userId);
                    relation.put(userId, list);
                }
            }
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            if (relation.containsKey(userId)) {
                Set<Integer> follweeList = relation.get(userId);
                return follweeList.stream().map(e -> twitterUserMap.getOrDefault(e, new LinkedList<>()))
                        .flatMap(Collection::stream)
                        .sorted((n, m) -> Integer.compare(m.time, n.time))
                        .limit(10)
                        .map(e -> e.id)
                        .collect(Collectors.toList());
            } else {
                return new LinkedList<>();
            }
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if (!relation.containsKey(followerId)) {
                HashSet<Integer> list = new HashSet<>();
                list.add(followerId);
                relation.put(followerId, list);
            }
            relation.get(followerId).add(followeeId);

        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if (relation.containsKey(followerId)) {
                relation.get(followerId).remove(followeeId);
            }
        }
    }
}
