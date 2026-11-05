class Employee {
    private String name;
    private int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayDetails() {
        System.out.println("Name:" + name);
        System.out.println("Id:" + id);
    }
}

class Manager extends Employee {
    private int teamSize;

    Manager(String name, int id, int teamSize) {
        super(name, id);
        this.teamSize = teamSize;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size:" + teamSize);
    }
}

class Engineer extends Employee {
    private String specialization;

    Engineer(String name, int id, String specialization) {
        super(name, id);
        this.specialization = specialization;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Specialization : " + specialization);
    }
}

public class Inheritance2 {
    public static void main(String[] args) {

        String M_name = "Jax", E_name = "William", E_specialization = "Backend Developer";
        int M_id = 101, E_id = 202, M_teamSize = 8;

        // Create Manager instance
        Manager manager = new Manager(M_name, M_id, M_teamSize);
        System.out.println("Manager Details");
        manager.displayDetails();

        // Create Engineer instance
        Engineer engineer = new Engineer(E_name, E_id, E_specialization);
        System.out.println("\nEngineer Details");
        engineer.displayDetails();
    }
}
