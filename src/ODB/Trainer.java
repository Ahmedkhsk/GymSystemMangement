package ODB;

import java.util.List;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trainer extends Person  implements Serializable {
 
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float salary;
    private String speciality;

    @OneToMany 
    List<Trainee> traineeList;
    
    public Trainer() {}

    public Trainer(float salary, String speciality, String name, int age, String phone) {
        super(name, age, phone);
        this.salary = salary;
        this.speciality = speciality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public List<Trainee> getTraineeList() {
        return traineeList;
    }

    public void setTraineeList(List<Trainee> traineeList) {
        this.traineeList = traineeList;
    }

    

    @Override
    public String toString() {
        return "Trainer{" + "id=" + id + ", salary=" + salary + ", speciality=" + speciality + '}';
    }   
}
