package ODB;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String equipmentName;
    private String targetMuscle;

    public Equipment() {}
    public Equipment(String equipmentName, String targetMuscle) {
        this.equipmentName = equipmentName;
        this.targetMuscle = targetMuscle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getTargetMuscle() {
        return targetMuscle;
    }

    public void setTargetMuscle(String targetMuscle) {
        this.targetMuscle = targetMuscle;
    }

    @Override
    public String toString() {
        return "Equipment{" + "id=" + id + ", equipmentName=" + equipmentName + ", targetMuscle=" + targetMuscle + '}';
    }
    
    
}
