package aziz;
import java.util.ArrayList;
import java.util.*;

public class student extends person implements comments {
    public student(int _id, String _name) {
        set_id(_id);
        set_name(_name);

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }


    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }
    boolean c=false;

    @Override
    public void view_mats(ArrayList<String> slide_content, ArrayList<String> video) {
        for (String i : slide_content) {
            System.out.println(i);
        }
        for (String j : video) {
            System.out.println(j);
        }

    }
    public void vassessments(ArrayList<assessment> assessment_list_from_teacher){
        for (assessment i: assessment_list_from_teacher){
            System.out.print("ID: "+i.id+" "+i.content);
            System.out.println(" "+i.marks);
        }
    }
    ArrayList<assessment> Assessment_of_students= new ArrayList<>();
    public void vassessment(ArrayList<assessment> assessment_list_from_teacher,  TreeMap<Integer, ArrayList<assessment>> assessment_of_students_list) {
        assessment j;
        for(int i= Assessment_of_students.size();i<assessment_list_from_teacher.size();i++)
        {

            j=new assessment(assessment_list_from_teacher.get(i));// j
            Assessment_of_students.add(j);

        }
        //new copy make
        assessment_of_students_list.put(get_id(), Assessment_of_students);

        System.out.println("pending assingments");
        for (assessment i : Assessment_of_students) {
            if (!i.status && !i.submission_status_student ) {
                System.out.print("ID: "+i.id+" "+i.content);
                System.out.println(" "+i.marks);
                c=true;
            }
        }
        if(!c) System.out.println("no pending");


    }

    public void submit_assessment(ArrayList<assessment> assessment_list_from_teacher, TreeMap<Integer, ArrayList<assessment>> assessment_of_students_list) {

        vassessment(assessment_list_from_teacher,  assessment_of_students_list);

        if (c) {

            System.out.print("Enter ID of Assessment ");
            int id_of_asg = sci.nextInt();
            if (!assessment_of_students_list.get(get_id()).get(id_of_asg).type) {
                System.out.print("Enter filename of assignment:");
                String name_asg = scs.nextLine();
                if (name_asg.contains(".zip")) {
//                System.out.println(assessment_of_students_list.get(get_id()).get(id_of_asg).submission_status_student);

                    assessment_of_students_list.get(get_id()).get(id_of_asg).submission_status_student = true;
                    assessment_of_students_list.get(get_id()).get(id_of_asg).ans = name_asg;
//                System.out.println(assessment_of_students_list.get(get_id()).get(id_of_asg).submission_status_student);

                } else {
                    System.out.println("wrong file format sir");
                }


            } else {
                System.out.print(assessment_of_students_list.get(get_id()).get(id_of_asg).content + ":");
                String name_asg = scs.nextLine();
                assessment_of_students_list.get(get_id()).get(id_of_asg).submission_status_student = true;
                assessment_of_students_list.get(get_id()).get(id_of_asg).ans = name_asg;


            }
//        assessment_of_students_list.get(get_id()).remove(id_of_asg);// still to check if it removes from student list or not
        }
        c=false;

    }

    public void view_grade(TreeMap<Integer, ArrayList<assessment>> assessment_of_students_list) {

        for (assessment i : assessment_of_students_list.get(get_id())) {
            if (i.submission_status_prof) {
                System.out.println("graded submission");
                System.out.println("Submission: " + i.content + "\n marks scored " + i.marks + "\n graded by " + i.graded_by);


            }

        }
        for (assessment j : assessment_of_students_list.get(get_id())) {
            if (!j.submission_status_prof && j.submission_status_student) {
                System.out.println("ungraded submission");
                System.out.println(j.content);
                System.out.println(j.ans);
            }
        }


    }

    //////////////////////////////////////////////////////////////////////////////
    @Override
    public void view_comments(ArrayList<String> list_of_comments) { //polymorphism

        for (String i : list_of_comments) {
            System.out.println(i);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    @Override
    public void add_comments(ArrayList<String> list_of_comments) {

        System.out.println("enter comment");

        Scanner scs = new Scanner(System.in);
        String comment = scs.nextLine();

        String total_comments = comment + " " + get_name() + "\n" + new mats().date();
        list_of_comments.add(total_comments);
    }

    ////////////////////////////////////////////////////////////////////////////

}
