import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void aminal_instantiatesCorrectly_true() {
        EndangeredAnimal endangeredAnimal= new EndangeredAnimal("lion");
        assertEquals(true, endangeredAnimal instanceof EndangeredAnimal);
    }

    @Test
    public void equals_returnsTrueIfNameAreSame_true() {
        EndangeredAnimal endangeredAnimal = new EndangeredAnimal("lion");
        EndangeredAnimal endangeredAnimal1 = new EndangeredAnimal("lion");
        assertTrue(endangeredAnimal.equals(endangeredAnimal1));
    }

    @Test
    public void save_insertsObjectIntoDatabase_Wildlife_Tracker() {
        EndangeredAnimal testEndangeredAnimal= new EndangeredAnimal("lion");
        testEndangeredAnimal.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testEndangeredAnimal));
    }

    //return all instances of animal
    @Test
    public void all_returnsAllInstancesOfPerson_true() {
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("lion");
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("kangaroo");
        secondEndangeredAnimal.save();
        assertEquals(true, EndangeredAnimal.all().get(0).equals(firstEndangeredAnimal));
        assertEquals(true, EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
    }

    //saving our ids form the db to our classes
    @Test
    public void save_assignsIdToObject() {
        EndangeredAnimal testEndangeredAnimal= new EndangeredAnimal("Henry");
        testEndangeredAnimal.save();
        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(testEndangeredAnimal.getId(), savedEndangeredAnimal.getId());
    }

    //find animals based on their id
    @Test
    public void find_returnsPersonWithSameId_secondPerson() {
        EndangeredAnimal firstEndangeredAnimal= new EndangeredAnimal("Henry");
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Harriet");
        secondEndangeredAnimal.save();
        assertEquals(EndangeredAnimal.find(secondEndangeredAnimal.getId()), secondEndangeredAnimal);
    }

    //update animal
    @Test
    public void update_updatesAnimalName_true() {
        EndangeredAnimal myEndangeredAnimal= new EndangeredAnimal("lion");
        myEndangeredAnimal.save();
        myEndangeredAnimal.update("elephant");
        assertEquals("elephant", EndangeredAnimal.find(myEndangeredAnimal.getId()).getName());
    }

    @Test
    public void delete_deletesAnimal_true() {
        EndangeredAnimal myEndangeredAnimal = new EndangeredAnimal("lion");
        myEndangeredAnimal.save();
        int myEndangeredAnimalId = myEndangeredAnimal.getId();
        myEndangeredAnimal.delete();
        assertEquals(null, EndangeredAnimal.find(myEndangeredAnimalId));
    }

}