package Classes;

public class Trainer extends Person {
    private int TID;
    private float salary;
    private String speciality;
    
    // Constructor
    public Trainer(int TID, String name, int age, String phone, float salary, String speciality) {
        super(name, age, phone);
        this.TID = TID;
        this.salary = salary;
        this.speciality = speciality;
    }
    
    public int getTID() {
        return TID;
    }

    public float getSalary() {
        return salary;
    }

    // Getters and Setters
    public String getSpeciality() {    
        return speciality;
    }

    public void setTID(int TID) {
        this.TID = TID;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    
    

    @Override
    public String toString() {
        return "Trainer{" + super.toString() + " , Salary = " + salary + '}';
    }
    
    
}

