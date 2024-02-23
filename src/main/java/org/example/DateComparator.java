package org.example;

import java.util.Comparator;
import java.util.Date;

public class DateComparator implements Comparator<HumanFriends> {

    public DateComparator() {
    }

    @Override
    public int compare(HumanFriends o1, HumanFriends o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}
