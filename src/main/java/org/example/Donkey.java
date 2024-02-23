package org.example;

import java.time.LocalDate;

public class Donkey extends PackAnimals implements Capable, Comparable<HumanFriends>{

    public Donkey(String name, LocalDate birthday, String commands) {
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }

    @Override
    public String toString() {
        return "Donkey{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", commands='" + commands + '\'' +
                '}';
    }

    @Override
    public String getType() {
        return "Donkey";
    }


    @Override
    public int compareTo(HumanFriends o) {
        if (this.getBirthday().isAfter(o.getBirthday())){
            return 1;
        }
        return 0;
    }

    @Override
    public boolean compareTo(Pets o) {
        return false;
    }

}
