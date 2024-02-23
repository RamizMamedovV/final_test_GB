package org.example;

import java.time.LocalDate;

public class Camel extends PackAnimals implements Capable, Comparable<HumanFriends>{

    public Camel(String name, LocalDate birthday, String commands) {
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }

    @Override
    public String toString() {
        return "Camel{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", commands='" + commands + '\'' +
                '}';
    }

    @Override
    public String getType() {
        return "Camel";
    }

    @Override
    public boolean compareTo(Pets o) {
        return this.getBirthday().isAfter(o.getBirthday());
    }

}
