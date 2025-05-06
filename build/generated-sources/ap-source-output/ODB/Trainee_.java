package ODB;

import ODB.Package;
import ODB.Trainer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-05-06T16:50:30")
@StaticMetamodel(Trainee.class)
public class Trainee_ { 

    public static volatile SingularAttribute<Trainee, String> goal;
    public static volatile SingularAttribute<Trainee, String> endDate;
    public static volatile SingularAttribute<Trainee, Trainer> trainer;
    public static volatile SingularAttribute<Trainee, Float> weight;
    public static volatile SingularAttribute<Trainee, Long> id;
    public static volatile SingularAttribute<Trainee, String> startDate;
    public static volatile SingularAttribute<Trainee, Float> height;
    public static volatile SingularAttribute<Trainee, Package> packa;

}