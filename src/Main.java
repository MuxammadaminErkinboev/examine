import model.Group;
import model.Mentor;
import model.Module;
import model.Score;
import model.Student;
import model.enums.MentorStrategy;
import model.enums.ModuleType;
import service.*;

import javax.management.MalformedObjectNameException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
     static Scanner scannerInt = new Scanner(System.in);
     static Scanner scannerStr = new Scanner(System.in);
     static MentorService mentorService = new MentorService();
     static GroupService groupService = new GroupService();
     static StudentService studentService = new StudentService();
     static ExamineService examineService = new ExamineService(studentService);
     static ModuleService moduleService = new ModuleService();
    public static void main(String[] args) {
        int steepcode = 10;
        while (steepcode!=0) {
            System.out.println("1.Mentor, 2.Group 3.Student, 4.Exam, 5.Module, 0.Exit");
            System.out.print("Buyruq tanlang:");
            int res = scannerInt.nextInt();
            switch (res){
                case 0 -> steepcode = 0;
                case 1 -> mentor();
                case 2 -> group();
                case 3 -> student();
                case 4 -> exam();
                case 5 -> module();
            }
        }
    }

    private static void mentor() {
        int steepcode = 10;
        while (steepcode != 0) {
            System.out.println("1.Add Mentor, 2.List Mentor, 0.Exit");
            System.out.print("Buyruq tanlang: ");
            int n = scannerInt.nextInt();
            switch (n) {
                case 0 -> steepcode = 0;
                case 1 -> {
                    System.out.println("Menter name: ");
                    String name = scannerStr.nextLine();
                    Mentor mentor = new Mentor(name);
                    Mentor mentor1 = mentorService.add(mentor);
                    if (mentor1 == null) {
                        System.out.println("Bu mentor bazada mavjud.");
                    } else {
                        System.out.println("Amaliyot muvaffaqiyatli yakunlandi.");
                    }
                }
                case 2 -> {
                    List<Mentor> mentors = mentorService.list();
                    int t = 1;
                    for (Mentor mentor : mentors) {
                        System.out.println(t + ") " + mentor.getName());
                        t++;
                    }
                }
            }
        }
    }

    private static void group() {
        int steepcode = 10;
        while (steepcode != 0) {
            System.out.println("1.Add Group, 2.List Group, 0.Exit");
            System.out.print("Buyruq tanlang: ");
            int n = scannerInt.nextInt();
            switch (n) {
                case 0 -> steepcode = 0;
                case 1 -> {
                    System.out.println("Group name: ");
                    String name = scannerStr.nextLine();
                    Group group = new Group(name);
                    Group group1 = groupService.add(group);
                    if (group1 == null) {
                        System.out.println("Bu Guruh bazada mavjud.");
                    } else {
                        System.out.println("Amaliyot muvaffaqiyatli yakunlandi.");
                    }
                }
                case 2 -> {
                    List<Group> groups = groupService.list();
                    int t = 1;
                    for (Group group: groups) {
                        System.out.println(t + ") " + group.getName());
                        t++;
                    }
                }
            }
        }

    }

    private static void student() {
        int steepcode = 10;
        while (steepcode != 0) {
            System.out.println("1.Add Student, 2.List Student, 0.Exit");
            System.out.print("Buyruq tanlang: ");
            int n = scannerInt.nextInt();
            switch (n) {
                case 0 -> steepcode = 0;
                case 1 -> {
                    System.out.println("Student name:");
                    String name = scannerStr.nextLine();
                    List<Group> groups = groupService.list();
                    int t = 1;
                    for (Group group: groups) {
                        System.out.println(t + ") " + group.getName());
                        t++;
                    }
                    System.out.println("Guruh tanlang : ");
                    int res = scannerInt.nextInt();
                    Group group = groupService.isGroupByNumber(res);
                    Student student = new Student(name,group.getId());
                    studentService.add(student);
                    System.out.println("Amaliyot muvaffaqiyatli yakunlandi.");
                }
                case 2 -> {
                    List<Student> students = studentService.list();
                    int t = 1;
                    for (Student student : students) {
                        System.out.println(t + ") " + student.getName());
                        t++;
                    }
                }
            }
        }
    }

    private static void exam() {
        List<Group> groups = groupService.list();
        int t = 1;
        for (Group group: groups) {
            System.out.println(t + ") " + group.getName());
            t++;
        }
        System.out.println("Guruh tanlang : ");
        int res = scannerInt.nextInt();
        Group group = groupService.isGroupByNumber(res);
        System.out.println("Modulni tanlang: ");
        System.out.println("1) Module FIRST.");
        System.out.println("2) Module SECOND.");
        System.out.println("3) Module THIRD.");
        System.out.println("4) Module FOURTH.");
        System.out.println("5) Module FIFTH.");
        System.out.println("6) Module SIXTH.");
        System.out.println("7) Module SEVENTH.");
        System.out.println("8) Module EIGHTH.");
        System.out.println("9) Module NINTH.");
        int modul = scannerInt.nextInt();
        ModuleType moduleType = null;
        switch (modul){
            case 1 -> moduleType = ModuleType.FIRST;
            case 2 -> moduleType = ModuleType.SECOND;
            case 3 -> moduleType = ModuleType.THIRD;
            case 4 -> moduleType = ModuleType.FOURTH;
            case 5 -> moduleType = ModuleType.FIFTH;
            case 6 -> moduleType = ModuleType.SIXTH;
            case 7 -> moduleType = ModuleType.SEVENTH;
            case 8 -> moduleType = ModuleType.EIGHTH;
            case 9 -> moduleType = ModuleType.NINTH;
        }
        List<Mentor> mentors = mentorService.list();
        int s = 1;
        for (Mentor mentor: mentors){
            System.out.println(s + ") " + mentor.getName());
            s++;
        }
        System.out.println("Mentor tanlang : ");
        int result = scannerInt.nextInt();
        Mentor mentor = mentorService.isMentorByNumber(result);
        System.out.println("Metod tanlang: ");
        System.out.println("1) " + "ONLY_PRACTISE");
        System.out.println("2) " + "PRACTISE_AND_THEORY");
        System.out.println("3) " + "All");
        int n = scannerInt.nextInt();
        MentorStrategy mentorStrategy;
        if (n==1) mentorStrategy = MentorStrategy.ONLY_PRACTISE;
        else if(n==2) mentorStrategy = MentorStrategy.PRACTISE_AND_THEORY;
        else mentorStrategy = MentorStrategy.ALL;
        Module module = new Module(mentor, moduleType, group, mentorStrategy);
        examineService.takeExamine(module);
       List<Student> students = studentService.searchByGroupId(group.getId());
        int nt = 1;
        System.out.println(  moduleType );
        for (Student student : students) {
            System.out.print(n + ".   " + student.getName());
            for (Score score: student.getScores()) {
                if (score.getModuleType() == moduleType) {
                    System.out.print("     " +score.getName() + " -> " + score.getQuantity());
                }
            }
            System.out.println();
            nt ++;
        }
    }

    private static void module() {
        List<Group> groups = groupService.list();
        int t = 1;
        for (Group group: groups) {
            System.out.println(t + ") " + group.getName());
            t++;
        }
        System.out.println("Guruh tanlang : ");
        int res = scannerInt.nextInt();
        Group group = groupService.isGroupByNumber(res);
        System.out.println("Modulni tanlang: ");
        System.out.println("1) Module FIRST.");
        System.out.println("2) Module SECOND.");
        System.out.println("3) Module THIRD.");
        System.out.println("4) Module FOURTH.");
        System.out.println("5) Module FIFTH.");
        System.out.println("6) Module SIXTH.");
        System.out.println("7) Module SEVENTH.");
        System.out.println("8) Module EIGHTH.");
        System.out.println("9) Module NINTH.");
        int modul = scannerInt.nextInt();
        ModuleType moduleType = null;
        switch (modul){
            case 1 -> moduleType = ModuleType.FIRST;
            case 2 -> moduleType = ModuleType.SECOND;
            case 3 -> moduleType = ModuleType.THIRD;
            case 4 -> moduleType = ModuleType.FOURTH;
            case 5 -> moduleType = ModuleType.FIFTH;
            case 6 -> moduleType = ModuleType.SIXTH;
            case 7 -> moduleType = ModuleType.SEVENTH;
            case 8 -> moduleType = ModuleType.EIGHTH;
            case 9 -> moduleType = ModuleType.NINTH;
        }
            Results(group.getId(),moduleType);

    }
    private static void Results(UUID groupID, ModuleType moduleType) {
        List<Student> students = studentService.searchByGroupId(groupID);
        int n = 1;
        System.out.println(  moduleType );
        for (Student student : students) {
            System.out.print(n + ".   " + student.getName());
            for (Score score: student.getScores()) {
                if (score.getModuleType() == moduleType) {
                    System.out.print("     " +score.getName() + " -> " + score.getQuantity());
                }
            }
            System.out.println();
            n ++;
        }
    }
}