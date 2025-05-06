package ODB;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Trainee extends Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;
    private float weight;
    private float height;
    private String goal;
    private String startDate;
    private String endDate;

    @ManyToOne
    Trainer trainer;
    
    @ManyToOne
    Package packa;
    
    public Trainee(){}
    public Trainee(String name, int age, String phone, float weight, float height, String goal,String startDate,String endDate,Trainer trainer,Package packa) {
        super(name, age, phone);
        this.weight = weight;
        this.height = height;
        this.goal = goal;
        this.startDate = startDate;
        this.endDate = endDate;
        this.trainer = trainer;
        this.packa = packa;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Package getPacka() {
        return packa;
    }

    public void setPacka(Package packa) {
        this.packa = packa;
    }

    public Trainer getTrainee() {
        return trainer;
    }

    public void setTrainee(Trainer trainer) {
        this.trainer = trainer;
    }
    
    public Long getId() {
        return id;
    }

    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }

    public String getGoal() {
        return goal;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Trainee{" + "id=" + id + ", weight=" + weight + ", height=" + height + ", goal=" + goal + ", startDate=" + startDate + ", endDate=" + endDate + ", trainer=" + trainer + ", packa=" + packa + '}';
    }


}
