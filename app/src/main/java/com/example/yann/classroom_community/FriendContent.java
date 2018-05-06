package com.example.yann.classroom_community;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class designed to store friend data
 */
public class FriendContent {

    /**
     * An array of sample friends.
     */
    public static final List<FriendContent.Friend> FRIENDS = new ArrayList<FriendContent.Friend>();

    /**
     * A map of sample friends, by ID.
     */
    public static final Map<String, FriendContent.Friend> FRIEND_MAP = new HashMap<String, FriendContent.Friend>();

    private static final int COUNT = 25;

    static {
        // Add some sample friends.
        /*
         ** Create random friends
        for (int i = 1; i <= COUNT; i++) {
            addItem(createFriend(i));
        }
        */

        // A list of preestablished friends
        addItem(new Friend("1","bob","online"));
        addItem(new Friend("2","tom","offline"));
        addItem(new Friend("3","rob","online"));
        addItem(new Friend("4","jojo","offline"));
        addItem(new Friend("5","hello","online"));
        addItem(new Friend("6","321","offline"));
        addItem(new Friend("7","iosjfddsif","online"));
        addItem(new Friend("8","hi","offline"));


    }

    private static void addItem(FriendContent.Friend friend) {
        FRIENDS.add(friend);
        FRIEND_MAP.put(friend.id, friend);
    }

    private static FriendContent.Friend createFriend(int position) {
        return new FriendContent.Friend(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Friend: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * Data structure for a friend
     */
    public static class Friend {
        public final String id;
        public final String name;
        public final String status;


        /**
         * @param id Identifier
         * @param name Nickname for the friend
         * @param status Status (Online/Offline)
         */
        public Friend(String id, String name, String status) {
            this.id = id;
            this.name = name;
            this.status = status;
        }

        @Override
        public String toString() {
            return name;
        }
    }


}
