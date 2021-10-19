package aziz;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class app {
    static ArrayList<person.assessment> teachers_assessment = new ArrayList<>();
    static ArrayList<String> list_of_comments = new ArrayList<>();
    static ArrayList<String> video = new ArrayList<>();
    static ArrayList<String> slide_content = new ArrayList<>();


    static TreeMap<Integer, ArrayList<person.assessment>> assessment_of_students_list = new TreeMap<>();

    public static void main(String[] args) {
        ArrayList<student> student_list = new ArrayList<>();
        ArrayList<instructure> instructure_list = new ArrayList<>();
        instructure_list.add(new instructure(0, "I0"));
        instructure_list.add(new instructure(1, "I1"));
//        student_list.add(new )
//        ins1.set_id(0);
//        ins2.set_id(1);
//        System.out.println(ins1.get_name());

        student_list.add(new student(0, "S0"));
        student_list.add(new student(1, "S1"));
        student_list.add(new student(2, "S2"));
//        student st2=new student(2,"mc");
//        st2.set_name("ronni");
//        st2.set_id(1);
//        st1.set_name("messi");
//        st1.set_id(0);
        Scanner sci = new Scanner(System.in);
        int expression;
        while (true) {
            System.out.println("""
                     Welcome to Backpack
                    1. Enter as instructor
                    2. Enter as student
                    3. Exit""");
            expression = sci.nextInt();
            switch (expression) {
                case 1 -> {
                    boolean ai = true;
                    System.out.println("""
                            Instructors:
                            0 - I0
                            1 - I1""");
                    int inst = sci.nextInt();
                    instructure iob = instructure_list.get(inst);
                    while (ai) {
                        System.out.println("""
                                INSTRUCTOR MENU
                                1. Add class material
                                2. Add assessments
                                3. View lecture materials
                                4. View assessments
                                5. Grade assessments
                                6. Close assessment
                                7. View comments
                                8. Add comments
                                9. Logout
                                """);
                        int case_s = sci.nextInt();
                        switch (case_s) {
                            case 1 -> iob.add_mats(slide_content, video);
                            case 2 -> iob.add_assessment(teachers_assessment);
                            case 3 -> iob.view_mats(slide_content, video);
                            case 4 -> iob.view_assessments(teachers_assessment);
                            case 5 -> iob.grade_assessment(teachers_assessment, assessment_of_students_list);
                            case 6 -> iob.close_assessment(teachers_assessment, assessment_of_students_list);
                            case 7 -> iob.view_comments(list_of_comments);
                            case 8 -> iob.add_comments(list_of_comments);
                            case 9 -> ai = false;
                        }
                    }
                }
                case 2 -> {
                    boolean a = true;
                    System.out.println("""
                            Students:
                            0 - S0
                            1 - S1
                            2 - S2""");
                    int selection = sci.nextInt();
                    student sob = student_list.get(selection);
                    while (a) {

                        System.out.println("""
                                STUDENT MENU
                                1. View lecture materials
                                2. View assessments
                                3. Submit assessment
                                4. View grades
                                5. View comments
                                6. Add comments
                                7. Logout
                                """);
                        int day = sci.nextInt();
                        switch (day) {
                            case 1 -> sob.view_mats(slide_content, video);
                            case 2 -> sob.vassessment(teachers_assessment,  assessment_of_students_list);
                            case 3 -> sob.submit_assessment(teachers_assessment, assessment_of_students_list);
                            case 4 -> sob.view_grade(assessment_of_students_list);
                            case 5 -> sob.view_comments(list_of_comments);
                            case 6 -> sob.add_comments(list_of_comments);
                            case 7 -> a = false;
                            case 9 ->System.out.println(assessment_of_students_list.get(0).get(0).submission_status_student);

                        }
                    }
                }
                // code block
                case 3 -> {
                    System.out.println("Exiting Program...");
                    System.exit(0);
                }
                // code block
            }
        }


    }

}
