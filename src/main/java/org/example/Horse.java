package org.example;

import java.time.LocalDate;

public class Horse extends PackAnimals implements Capable, Comparable<HumanFriends>{

    public Horse(String name, LocalDate birthday, String commands) {
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", commands='" + commands + '\'' +
                '}';
    }

    @Override
    public String getType() {
        return "Horse";
    }

    @Override
    public boolean compareTo(Pets o) {
        return this.getBirthday().isAfter(o.getBirthday());
    }

}
