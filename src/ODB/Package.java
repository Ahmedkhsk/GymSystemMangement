package ODB;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Package implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String Type;
    private int Duration;
    private float packageFee;

    @OneToMany 
    List<Trainee> traineeList;
    public Package() {}

    public Package(Long id, String Type, int Duration, float packageFee) {
        this.id = id;
        this.Type = Type;
        this.Duration = Duration;
        this.packageFee = packageFee;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return Type;
    }

    public int getDuration() {
        return Duration;
    }

    public float getPackageFee() {
        return packageFee;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setDuration(int Duration) {
        this.Duration = Duration;
    }

    public void setPackageFee(float packageFee) {
        this.packageFee = packageFee;
    }

    @Override
    public String toString() {
        return "Package{" + "id=" + id + ", Type=" + Type + ", Duration=" + Duration + ", packageFee=" + packageFee + '}';
    }
    
    
    
}
