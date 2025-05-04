package Classes;


public class Package {
    private int id;
    private String Type;
    private int Duration;
    private float packageFee;

    public Package(int id, String Type, int Duration, float packageFee) {
        this.id = id;
        this.Type = Type;
        this.Duration = Duration;
        this.packageFee = packageFee;
    }

    public int getId() {
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
        return "Package [" + " Type = " + Type + ", Duration = " + Duration + ", packageFee = " + packageFee + ']';
    }
}
