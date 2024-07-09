package service;

import model.*;
import model.Module;
import model.enums.MentorStrategy;
import service.examine.*;
import java.util.*;

public class ExamineService {
     StudentService studentService;
     public ExamineService(StudentService studentService){
         this.studentService = studentService;
     }
    private class Node{
        Exam val;
        Node next;

        public Node(Exam val) {
            this.val = val;
        }
    }

    Node first;
    Node last;

    public void getExams(Module module){
        if (module.getMentorStrategy() == MentorStrategy.ALL){
            addExam(new PractiseExam());
            addExam(new TheoryExam());
            addExam(new ExtraBonus());
        }
        else if (module.getMentorStrategy() == MentorStrategy.ONLY_PRACTISE){
            addExam(new PractiseExam());
        }
        else if (module.getMentorStrategy() == MentorStrategy.PRACTISE_AND_THEORY) {
            addExam(new PractiseExam());
            addExam(new TheoryExam());
        }

    }

    private void addExam(Exam exam) {
        if (first == null){
            first = last = new Node(exam);
            return;
        }
        Node node = new Node(exam);
        last.next = node;
        last = node;
    }

    public void takeExamine(Module module) {
        List<Student> students = studentService.searchByGroupId(module.getGroup().getId());
        getExams(module);
        while (first != null){
            first.val.execute(module,students);
            first = first.next;
        }
    }
}
