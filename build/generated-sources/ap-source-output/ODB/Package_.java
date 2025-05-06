package ODB;

import ODB.Trainee;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-05-06T16:50:30")
@StaticMetamodel(Package.class)
public class Package_ { 

    public static volatile SingularAttribute<Package, String> Type;
    public static volatile SingularAttribute<Package, Integer> Duration;
    public static volatile SingularAttribute<Package, Long> id;
    public static volatile SingularAttribute<Package, Float> packageFee;
    public static volatile ListAttribute<Package, Trainee> traineeList;

}