package org.example;

import java.time.LocalDate;

public class Hamster extends Pets implements Capable, Comparable<HumanFriends>{

    public Hamster(String name, LocalDate birthday, String commands) {
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }

    @Override
    public String toString() {
        return "Hamster{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", commands='" + commands + '\'' +
                '}';
    }

    @Override
    public String getType() {
        return "Hamster";
    }

    @Override
    public boolean compareTo(Pets o) {
        return this.getBirthday().isAfter(o.getBirthday());
    }

}
