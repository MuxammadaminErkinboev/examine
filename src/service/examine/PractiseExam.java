package service.examine;

import model.*;
import model.Module;

import java.util.List;
import java.util.Random;

public class PractiseExam implements Exam {
    @Override
    public void execute(Module module, List<Student> list) {
        Random random = new Random();
        int n = module.getMentorStrategy().getPractice();
        for (Student student: list){
            student.setScores(new Score("practise",module.getModuleType(),random.nextInt(n)+1));
        }

    }

}
