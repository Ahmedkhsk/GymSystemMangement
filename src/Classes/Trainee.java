package Classes;

public class Trainee extends Person {
    private int id;
    private float weight;
    private float height;
    private String goal;
    private String startDate;
    private String endDate;
    
    //Relationship
    private int PID;
    private int TID;
    
    public Trainee(){ }
    
    public Trainee(int id ,String name, int age, String phone , float weight, float height, String goal, String startDate, String endDate, int PID, int TID) {
        super(name, age, phone);
        this.weight = weight;
        this.height = height;
        this.goal = goal;
        this.startDate = startDate;
        this.endDate = endDate;
        this.PID = PID;
        this.TID = TID;
        this.id = id;
    }

    // Getters and Setters

    public int getId() {
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

    public int getPID() {
        return PID;
    }

    public int getTID() {
        return TID;
    }

    @Override
    public String toString() {
        return "Trainee{" + "weight=" + weight + ", height=" + height + ", goal=" + goal + ", startDate=" + startDate + ", endDate=" + endDate + ", PID=" + PID + ", TID=" + TID + '}';
    }
    
}

