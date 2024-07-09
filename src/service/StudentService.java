package service;

import model.*;
import java.util.*;

public class StudentService implements BaseService<Student> {
    List<Student> students = new ArrayList<>();


    @Override
    public Student add(Student student) {
        if (hasStudent(student.getName())) {
            return null;
        }
        students.add(student);
        return student;
    }

    private boolean hasStudent(String studentName) {
        for (Student student : students) {
            if(student.getName().equals(studentName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void delete(UUID id) {
        for(Student student : students) {
            if(student.getId().equals(id)) {
                students.remove(student);
            }
        }
    }

    @Override
    public Student update(UUID id, Student student) {
        for(Student person : students) {
            if(person.getId().equals(id)) {
                person.setName(student.getName());
                person.setGroupId(student.getGroupId());
                return person;
            }
        }
        return null;
    }

    @Override
    public List<Student> list() {
        if (students.isEmpty()){
            return null;
        }
        return students;
    }
    public List<Student> searchByGroupId(UUID id){
        List<Student> studentsId = new ArrayList<>();
        for (Student student: students){
            if (student.getGroupId().equals(id)){
                studentsId.add(student);
            }
        }
        return studentsId;
    }
}
