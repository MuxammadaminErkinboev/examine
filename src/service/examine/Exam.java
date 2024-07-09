package service.examine;

import model.*;
import model.Module;

import java.util.List;

public interface Exam {
    void execute(Module module, List<Student> list);
}
