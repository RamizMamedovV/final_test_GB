package org.example;

import java.time.LocalDate;

public class Dog extends Pets implements Capable, Comparable<HumanFriends>{


    public Dog(String name, LocalDate birthday, String commands) {
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", commands='" + commands + '\'' +
                '}';
    }

    @Override
    public String getType() {
        return "Dog";
    }


    @Override
    public boolean compareTo(Pets o) {
        return this.getBirthday().isAfter(o.getBirthday());
    }

}
