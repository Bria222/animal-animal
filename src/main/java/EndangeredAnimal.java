import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimal extends Animal{

    public static final String DATABASE_TYPE = "endangeredAnimal";

    public EndangeredAnimal(String name) {
        this.name = name;
        type = DATABASE_TYPE;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getHealthLevel() {
        return super.getHealthLevel();
    }

    @Override
    public String getAgeLevel() {
        return super.getAgeLevel();
    }

    @Override
    public int getEndangeredAnimalId() {
        return super.getEndangeredAnimalId();
    }

    @Override
    public boolean equals(Object otherEndangeredAnimal){
        if (!(otherEndangeredAnimal instanceof EndangeredAnimal)) {
            return false;
        } else {
            EndangeredAnimal newEndangeredAnimal = (EndangeredAnimal) otherEndangeredAnimal;
            return this.getName().equals(newEndangeredAnimal.getName());
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    //save endangered animal into db
    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, type) VALUES (:name, :type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("type", this.type)
                    .executeUpdate()
                    .getKey();
        }
    }

    //get all endangered animals
    public static List<EndangeredAnimal> all() {
        String sql = "SELECT * FROM animals WHERE type='endangeredAnimal';";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(EndangeredAnimal.class);
        }
    }

    //find endangered animals by id
    public static EndangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            EndangeredAnimal endangeredAnimal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return endangeredAnimal;
        }
    }

    //update an endangeredAnimal aminal
    public void update(String name) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "UPDATE animals SET name = :name WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    //delete endangeredAnimal animal
    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM animals WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

}
