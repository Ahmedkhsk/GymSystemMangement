package Classes;
    
public class Equipment {
    private String equipmentName;
    private String targetMuscle;

    public Equipment(String equipmentName, String targetMuscle) {
        this.equipmentName = equipmentName;
        this.targetMuscle = targetMuscle;
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
        return "Equipment{" + "equipmentName = " + equipmentName + " , targetMuscle = " + targetMuscle + '}';
    }
    
    
}

