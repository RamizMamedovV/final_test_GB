package org.example;

import java.time.LocalDate;

public abstract class HumanFriends implements Capable, Comparable<HumanFriends>{
    @Override
    public int compareTo(HumanFriends o) {
        return this.getBirthday().compareTo(o.getBirthday());
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getSkills() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    protected String name;
    protected LocalDate birthday;

    protected String commands;

    private String type;
    private static int count = 0;
    {
        ++count;
    }
    public static int getCount() {
        return count;
    }

    public abstract String getType();

    public HumanFriends() {
    }

    /*

    // Метод для подсчета возраста
    public static int calculateAge(LocalDate birthday, LocalDate currentDate) {
        return Period.between(birthday, currentDate).getYears();
    }

* */
}
