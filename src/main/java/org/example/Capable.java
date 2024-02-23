package org.example;

import java.time.LocalDate;

public interface Capable {

    boolean compareTo(Pets o);
    String getName();

    String getSkills();

    LocalDate getBirthday();

    void setCommands(String commands);
}
