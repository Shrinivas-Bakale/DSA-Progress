
class School {
    private String name;

    School() {
        name = "DPS";
    }

    public void printSchoolName() {
        System.out.println("School Name: " + name);
    }
}

class Student extends School {
    private String name;

    Student(String name) {
        this.name = name;
    }

    public void printStudentName() {
        System.out.println("Student Name: " + name);
    }
}

class Parent extends Student {
    private String name;

    Parent(String name, String studentName) {
        super(studentName);
        this.name = name;
    }

    public void printParentName() {
        System.out.println("Parent Name: " + name);
    }
}

class Inheritance {

    public static void main(String[] args) {
        Student st = new Student("Raj");
        Parent pt = new Parent("Dad", "Raj");
        st.printStudentName();
        st.printSchoolName();
        pt.printStudentName();
        pt.printParentName();
    }
}