import org.sql2o.Sql2o;

public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "maku", "maku");
//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-54-225-116-36.compute-1.amazonaws.com:5432/da9aaps8f9r9sa", "glwcnxtcekkthr", "85db316d6c524a41cff623d72318efa5b1802320fcf82d58082d7f55711838a8");
}
