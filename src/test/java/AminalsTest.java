import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AminalsTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void aminal_instantiatesCorrectly_true() {
        Aminals aminals= new Aminals("lion",  1);
        assertEquals(true, aminals instanceof Aminals);
    }

    @Test
    public void SightingInstantiatesWithName_true() throws Exception {
        Aminals aminals = new Aminals("lion", 1);
        assertEquals("lion", aminals.getName());

    }

    @Test
    public void SightingInstantiatesWithType_true() throws Exception {
        Aminals aminals = new Aminals("lion",  1);
        assertEquals("animal", aminals.getDatabaseType());

    }

    @Test
    public void SightingInstantiatesWithSightingId_true() throws Exception {
        Aminals aminals = new Aminals("lion",  1);
        assertEquals(1, aminals.getSightingsId());

    }

    @Test
    public void equals_returnsTrueIfNameAreSame_true() {
        Aminals aminals = new Aminals("lion",  1);
        Aminals aminals1 = new Aminals("lion",  1);
        assertTrue(aminals.equals(aminals1));
    }

    @Test
    public void save_insertsObjectIntoDatabase_Wildlife_Tracker() {
        Aminals testAnimal= new Aminals("lion",  1);
        testAnimal.save();
        assertTrue(Aminals.all().get(0).equals(testAnimal));
    }

    //return all instances of animal
    @Test
    public void all_returnsAllInstancesOfPerson_true() {
        Aminals firstAnimal = new Aminals("lion",  1);
        firstAnimal.save();
        Aminals secondAminals = new Aminals("kangaroo", 2);
        secondAminals.save();
        assertEquals(true, Aminals.all().get(0).equals(firstAnimal));
        assertEquals(true, Aminals.all().get(1).equals(secondAminals));
    }

    //saving our ids form the db to our classes
    @Test
    public void save_assignsIdToObject() {
        Aminals testAminals= new Aminals("lion", 1);
        testAminals.save();
        Aminals savedAminals = Aminals.all().get(0);
        assertEquals(testAminals.getId(), savedAminals.getId());
    }

    //find animals based on their id
    @Test
    public void find_returnsPersonWithSameId_secondPerson() {
        Aminals firstAminals= new Aminals("camel",  3);
        firstAminals.save();
        Aminals secondAminals = new Aminals("wathog",  4);
        secondAminals.save();
        assertEquals(Aminals.find(secondAminals.getId()), secondAminals);
    }

    //update animal
    @Test
    public void update_updatesAnimalName_true() {
        Aminals myAminals= new Aminals("lion",  1);
        myAminals.save();
        myAminals.update("elephant");
        assertEquals("elephant", Aminals.find(myAminals.getId()).getName());
    }

    @Test
    public void delete_deletesAnimal_true() {
        Aminals myAminals = new Aminals("lion", 1);
        myAminals.save();
        int myAminalsId = myAminals.getId();
        myAminals.delete();
        assertEquals(null, Aminals.find(myAminalsId));
    }
}