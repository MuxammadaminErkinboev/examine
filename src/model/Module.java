package model;

import model.enums.*;
import java.util.*;

public class Module {
    private UUID id;
    private Mentor mentor;
    private ModuleType moduleType;
    private Group group;
    private MentorStrategy mentorStrategy;

    public Module() {
        this.id = UUID.randomUUID();
    }

    public Module(Mentor mentor, ModuleType moduleType, Group group, MentorStrategy mentorStrategy) {
        this();
        this.mentor = mentor;
        this.moduleType = moduleType;
        this.group = group;
        this.mentorStrategy = mentorStrategy;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public ModuleType getModuleType() {
        return moduleType;
    }

    public void setModuleType(ModuleType moduleType) {
        this.moduleType = moduleType;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public MentorStrategy getMentorStrategy() {
        return mentorStrategy;
    }

    public void setMentorStrategy(MentorStrategy mentorStrategy) {
        this.mentorStrategy = mentorStrategy;
    }
}
