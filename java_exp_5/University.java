package Experiment5;
class Person {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address; 
    }
}

class Staff extends Person {
    private String staffId;
    private String department;

    public Staff(String name, int age, String address, String staffId, String department) {
        super(name, age, address);
        this.staffId = staffId;
        this.department = department;
    }

    public String getStaffId() {
        return staffId; 
    }

    public String getDepartment() {
        return department; 
    }
}

class Professor extends Staff {
    private String specialization;

    public Professor(String name, int age, String address, String staffId, String department, String specialization) {
        super(name, age, address, staffId, department);
        this.specialization = specialization;
    }

    public void conductLecture() {
        System.out.println("Professor " + getName() + " is conducting a lecture on " + specialization);
    }
}

class Student extends Person {
    private String studentId;
    private String course;

    public Student(String name, int age, String address, String studentId, String course) {
        super(name, age, address);
        this.studentId = studentId;
        this.course = course;
    }

    public String getStudentId() {
        return studentId; 
    }

    public String getCourse() {
        return course; 
    }
}

class GraduateStudent extends Student {
    private String researchTopic;

    public GraduateStudent(String name, int age, String address, String studentId, String course, String researchTopic) {
        super(name, age, address, studentId, course);
        this.researchTopic = researchTopic;
    }

    public void submitThesis() {
        System.out.println("Graduate student " + getName() + " is submitting thesis on " + researchTopic);
    }
}

class Main3 {
    public static void main(String[] args) {
        Person[] people = new Person[2];
        people[0] = new Professor("Dr. KK", 45, "123 Main St", "S101", "Computer Science", "AI");
        people[1] = new GraduateStudent("Agarwal", 25, "456 okko St", "G201", "Data Science", "Machine Learning");

        for (Person person : people) {
            if (person instanceof Professor) {
                ((Professor) person).conductLecture();
            } else if (person instanceof GraduateStudent) {
                ((GraduateStudent) person).submitThesis();
            }
        }
    }
}