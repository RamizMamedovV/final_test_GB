package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Registry {
    private List<HumanFriends> humanFriendsList;
    private List<Capable> capables;


    public Registry() {
        humanFriendsList = new ArrayList<>();
        capables = new ArrayList<>();
    }

    public List<Capable> getCapables() {
        return capables;
    }

    public void addFriend(Capable friend) {
        capables.add(friend);
    }

    public String findFriend(String name) {
        for (Capable friend : capables) {
            if (friend.getName().equals(name)) {
                return friend.getSkills();
            }
        }
        return "Не найдено((";
    }

    public String addSkills(String name, String skill) {
        for (Capable friend : capables) {
            if (friend.getName().equals(name)) {
                StringBuilder addSkill = new StringBuilder(friend.getSkills());
                addSkill.append(", " + skill);
                friend.setCommands(addSkill.toString());
                return "Добавил ;)";
            }
        }
        return "Не найдено((";
    }

    public void printListOfFriends() {
        Arrays.sort(capables.toArray());
        for (Capable capable : capables) {
            System.out.println(capable);
        }
    }
}
