package model;

import java.util.*;

public class Student {
    private UUID id;
    private String name;
    private UUID groupId;
    private List<Score> scores = new ArrayList<>();
    public Student(){
        this.id = UUID.randomUUID();
    }

    public Student(String name, UUID groupId) {
        this();
        this.name = name;
        this.groupId = groupId;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(Score scores) {
        this.scores.add(scores);
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }
}
