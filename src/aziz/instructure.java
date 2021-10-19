package aziz;

import java.text.SimpleDateFormat;
import java.util.*;

import static aziz.person.assessment.count;

public class instructure extends person implements comments {
    public instructure(int _id, String _name) {
        this._id = _id;
        this._name = _name;
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

    public void add_mats(ArrayList<String> slide_content, ArrayList<String> video) {
        System.out.println("1. Add Lecture Slide\n" +
                "2. Add Lecture Video");
        int choice = sci.nextInt();
        if (choice == 1) {
//            System.out.println("Enter topic of slides: Slide 1");
            System.out.println("enter number of slides");
            int noofs = sci.nextInt();
            slide sl = new slide();
            sl.setNumber_of_slides(noofs);
            sl.slide_content_methode_(slide_content);


        } else if (choice == 2) {
            new video().video_upload_methode_(video);
        }

    }

    public void add_assessment(ArrayList<assessment> _assessment) {
        System.out.println("""
                1. Add Assignment
                2. Add Quiz""");
        int c = sci.nextInt();
        if (c == 1) {
            System.out.print("enter problem statement:");
            String s = scs.nextLine();
            System.out.print("enter max marks:");
            int max_marks = sci.nextInt();
            _assessment.add(new assessment(false, s, max_marks));

        } else if (c == 2) {
            System.out.print("enter problem statement:");

            String s = scs.nextLine();

            _assessment.add(new assessment(true, s, 1));

        } else {
            System.out.println("wrong input hi hi hi");
        }
        System.out.println("welcome " + get_name());


    }

    @Override
    public void view_mats(ArrayList<String> slide_content, ArrayList<String> video) {
        for (String i : slide_content) {
            System.out.println(i);
        }
        for (String j : video) {
            System.out.println(j);
        }

    }

    public void view_assessments(ArrayList<assessment> _assessment) {
        for (assessment i : _assessment) {
            if (!i.status) {
                System.out.println(i.id + ":" + i.content);
                System.out.println("Max Marks : " + i.marks);
            }
        }

    }

    public void grade_assessment(ArrayList<assessment> _assessment, TreeMap<Integer, ArrayList<assessment>> submissions_list) {

        view_assessments(_assessment);
        if (_assessment.size() > 0) {
            System.out.print("Enter ID of assessment to view submissions:");
            int assessment_id = sci.nextInt();
//        _assessment.get(assessment_id).
//        sou
            System.out.println("Choose ID from these ungraded submissions");
            boolean ch = false;

            for (Map.Entry<Integer, ArrayList<assessment>> entry : submissions_list.entrySet()) {
                Integer key = entry.getKey();
                ArrayList<assessment> value = entry.getValue();
                for (assessment k : value) {
                    if (k.id == assessment_id) {
                        System.out.println(key + ": S" + key);
                        ch = true;
                    }

                }

            }
            if (!ch) {
                System.out.println("no submissions");
                return;
            }

            int st_id = sci.nextInt();

            for (assessment j : submissions_list.get(st_id)) {
                System.out.println("submission" + ": " + j.ans);
                System.out.println(j.submission_status_student);
                if (j.submission_status_student) {
                    j.submission_status_prof = true;
                    System.out.println("max marks");
                    System.out.println(j.marks);
                    System.out.print("marks scored: ");
                    j.marks = sci.nextInt();
                    j.graded_by = get_name();
                }
            }


        }
    }

    void close_assessment(ArrayList<assessment> _assessment, TreeMap<Integer, ArrayList<assessment>> submissions_list) {
        System.out.println("list of open assessments");
        for (assessment k : _assessment) {
            if (!k.status) {
                System.out.println(k.id + ":" + k.content);
            }
        }

        System.out.println("Enter id of assignment to close: ");
        int _close = sci.nextInt();
        for (int j = 0; j < submissions_list.size(); j++) {
            for (assessment i : submissions_list.get(j)) {
                i.status = true;
            }


        }
    }


    @Override
    public void view_comments(ArrayList<String> list_of_comments) {

        for (String i : list_of_comments) {
            System.out.println(i);
        }
    }

    @Override
    public void add_comments(ArrayList<String> list_of_comments) {
        System.out.println("enter comment");
        Scanner scs = new Scanner(System.in);
        String comment = scs.nextLine();

        String total_comments = comment + " " + get_name() + "\n" + new mats().date();
        list_of_comments.add(total_comments);
    }
}
