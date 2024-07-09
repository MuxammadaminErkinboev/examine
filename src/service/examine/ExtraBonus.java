package service.examine;

import model.Module;
import model.*;

import java.util.*;

public class ExtraBonus implements Exam {


    @Override
    public void execute(Module module, List<Student> list) {
        Random random = new Random();
        int n = module.getMentorStrategy().getExtra();
        for (Student student: list){
            student.setScores(new Score("extra",module.getModuleType(),random.nextInt(n)+1));
        }

    }
}