package service;

import model.*;
import java.util.*;

public class MentorService implements BaseService<Mentor> {
    List<Mentor> mentors = new ArrayList<>();
    @Override
    public Mentor add(Mentor mentor) {
        if (hasMentor(mentor)) {
            return null;
        }
        mentors.add(mentor);
        return mentor;
    }

    private boolean hasMentor(Mentor mentor) {
        for(Mentor teacher : mentors) {
            if (teacher.getName().equals(mentor.getName())) {
                return true;
            }
        }
        return false;
    }


    @Override
    public List<Mentor> list() {
        if (mentors.isEmpty()){
            return null;
        }
        return mentors;
    }

    @Override
    public void delete(UUID id) {
        for(Mentor mentor : mentors) {
            if (mentor.getId().equals(id)) {
                mentors.remove(mentor);
            }
        }
    }

    @Override
    public Mentor update(UUID id, Mentor mentor) {
        for (Mentor teacher : mentors) {
            if (teacher.getId().equals(id)) {
                mentors.set(mentors.indexOf(teacher),mentor);
                return mentor;
            }
        }
        return null;
    }

    public Mentor isMentorByNumber(int result) {
        int i = 1;
        for (Mentor mentor: mentors){
            if (i == result){
                return mentor;
            }
                i++;
        }
        return null;
    }
}
