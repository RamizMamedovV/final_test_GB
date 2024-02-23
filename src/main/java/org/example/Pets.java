package org.example;

public abstract class Pets extends HumanFriends implements Capable, Comparable<HumanFriends>{

    @Override
    public String getType() {
        return null;
    }

    @Override
    public int compareTo(HumanFriends o) {
        return 0;
    }
}
