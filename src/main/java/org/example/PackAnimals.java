package org.example;

public abstract class PackAnimals extends HumanFriends implements Capable, Comparable<HumanFriends> {

    @Override
    public String getType() {
        return null;
    }

    @Override
    public int compareTo(HumanFriends o) {
        return 0;
    }
}
