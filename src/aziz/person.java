package aziz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class person {
    Scanner scs = new Scanner(System.in);
    Scanner sci = new Scanner(System.in);
    Scanner sc = new Scanner(System.in);

    protected int _id;
    protected String _name;

    class assessment {
        boolean type;
        String content;
        int marks;
        static int count = 0;
        int id = 0;
        boolean submission_status_student;
        boolean submission_status_prof;
        String ans;
        boolean status = false;
        String graded_by;


        public assessment(boolean type, String content, int marks) {
            this.type = type;
            this.content = content;
            this.marks = marks;
            id = count++;
        }
        public assessment(assessment x){
            this.copy(x);
        }
        public void copy(assessment x) {
            this.type = x.type;
            this.marks = x.marks;
            this.id = x.id;
            this.content = x.content;
            this.ans = x.ans;
            this.status = x.status;
            this.submission_status_student = x.submission_status_student;
            this.submission_status_prof = x.submission_status_prof;
            this.graded_by = x.graded_by;
        }

    }

    class mats {
        protected String topic;

        String date() {
            Date date;
            date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM HH:mm:ss yyy");
            return formatter.format(date);
        }

    }

    class slide extends mats {
        private int number_of_slides;
        ArrayList<String> slide_content_PAGES;

        public int getNumber_of_slides() {
            return number_of_slides;
        }

        public void setNumber_of_slides(int number_of_slides) {
            this.number_of_slides = number_of_slides;
        }

        void slide_content_methode_(ArrayList<String> slide_content) {
            System.out.println("Enter title of slides");
            String slide_c = sc.nextLine();
            StringBuilder s;
            s = new StringBuilder("Title:" + slide_c + "\n");
            for (int i = 0; i < getNumber_of_slides(); i++) {
                System.out.println("enter content of slide");
                String con_slide = sc.nextLine();
                s.append("Slide").append(i).append(":").append(con_slide).append("\n");

            }
            slide_content.add(s + " \n Date of upload:" + date() +
                    "\n Uploaded by: " + _name);
        }

    }

    class video extends mats {
        void video_upload_methode_(ArrayList<String> video) {
            System.out.println("enter topic of video");
            String vvt = sc.nextLine();
            System.out.println("Enter filename of video: lecture1.mp4");
            String file_name = sc.nextLine();

            if (file_name.contains(".mp4")) {
                video.add(" Title of video:" + vvt + " \n Video file: " + file_name + " \n Date of upload:" + date() +
                        "\n Uploaded by: " + _name);
            }
        }

    }

    void view_comments(ArrayList<String> arr) {
    }

    void assessment(ArrayList<assessment> arr) {

    }


}
