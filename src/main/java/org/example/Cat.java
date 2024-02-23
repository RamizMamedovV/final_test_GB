package org.example;

import java.time.LocalDate;

public class Cat extends Pets implements Capable, Comparable<HumanFriends>{


    public Cat(String name, LocalDate birthday, String commands) {
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", commands='" + commands + '\'' +
                '}';
    }

    @Override
    public String getType() {
        return "Cat";
    }


    @Override
    public boolean compareTo(Pets o) {
        return this.getBirthday().isAfter(o.getBirthday());
    }

}
