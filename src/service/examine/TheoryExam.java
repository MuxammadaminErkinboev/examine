package service.examine;

import model.*;
import model.Module;
import java.util.*;

public class TheoryExam implements Exam {
    @Override
    public void execute(Module module, List<Student> list){
        Random random = new Random();
        int n = module.getMentorStrategy().getTheory();
        for (Student student: list){
            student.setScores(new Score("theory",module.getModuleType(),random.nextInt(n)+1));
        }

    }

}
