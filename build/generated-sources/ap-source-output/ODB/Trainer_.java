package ODB;

import ODB.Trainee;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-05-06T16:50:30")
@StaticMetamodel(Trainer.class)
public class Trainer_ { 

    public static volatile SingularAttribute<Trainer, String> speciality;
    public static volatile SingularAttribute<Trainer, Long> id;
    public static volatile SingularAttribute<Trainer, Float> salary;
    public static volatile ListAttribute<Trainer, Trainee> traineeList;

}