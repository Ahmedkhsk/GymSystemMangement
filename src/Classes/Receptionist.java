package Classes;

import java.util.ArrayList;
import java.util.Calendar;

public class Receptionist {
    private int GID;
    private String name;
    private String pass;
    
    private ArrayList<Equipment> equipments;
    private ArrayList<Trainer> trainers;
    private ArrayList<Trainee> trainees;
    


    public Receptionist(int GID, String name, String pass) {
        this.GID = GID;
        this.name = name;
        this.pass = pass;
        this.equipments = new ArrayList<>();
        this.trainers = new ArrayList<>();
        this.trainees = new ArrayList<>();
    }
    

    //is a measure that uses a person's weight and height to estimate if they are underweight, normal weight, overweight, or obese
    public double calcBMI(Trainee trainee) {
        double heightInMeters = trainee.getHeight() / 100;
        return trainee.getWeight() / (heightInMeters * heightInMeters);
    }
    
    //Check Exp Date
//    public boolean checkExp(Trainee trainee) 
//    {
//        Calendar t1 = Calendar.getInstance(); //Current Time
//        int r = trainee.getEndDate().getTime().compareTo(t1.getTime());
//        if(r >= 0)
//        return true;
//        else
//        return false;
//    }
    
    
    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }

    public void removeTrainee(Trainee trainee) {
        trainees.remove(trainee);
    }

    public void addTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    public void removeTrainer(Trainer trainer) {
        trainers.remove(trainer);
    }

    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    public void removeEquipment(Equipment equipment) {
        equipments.remove(equipment);
    }

    public void displayTrainees() {
        for (Trainee trainee : trainees) {
            System.out.println(trainee);
        }
    }

    public void displayTrainers() {
        for (Trainer trainer : trainers) {
            System.out.println(trainer);
        }
    }

    public void displayEquipment() {
        for (Equipment eq : equipments) {
            System.out.println(eq);
        }
    }

    @Override
    public String toString() {
        return  GID + "\t" + name;
    }
    
    
}

