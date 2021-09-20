import org.sql2o.Connection;

import java.util.List;

public class Sightings extends Animal {

    private  String location;

    public Sightings(String rangerName, String location) {
        this.location = location;
        this.name = rangerName;
    }

    public String getLocation() {
        return location;
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
    public boolean equals(Object otherSighting){
        if (!(otherSighting instanceof Sightings)) {
            return false;
        } else {
            Sightings newSighting = (Sightings) otherSighting;
            return this.getName().equals(newSighting.getName());
        }
    }

    //save sighting into db
    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (name, location) VALUES (:name, :location)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("location", this.location)
                    .executeUpdate()
                    .getKey();
        }
    }

    //get all Sightings
    public static List<Sightings> all() {
        String sql = "SELECT * FROM sightings;";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sightings.class);
        }
    }

    //find sightings by id
    public static Sightings find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where id=:id";
            Sightings sightings = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sightings.class);
            return sightings;
        }
    }

    //update an sihtings
    public void update(String name) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "UPDATE sightings SET name = :name WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    //delete animal
    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM sightings WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}
