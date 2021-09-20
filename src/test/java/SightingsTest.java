import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;

import static org.junit.Assert.*;

public class SightingsTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void sightings_instantiatesCorrectly_true() {
        Sightings sightings= new Sightings("Musa", "near river");
        assertEquals(true, sightings instanceof Sightings);
    }

    @Test
    public void SightingInstantiatesWithName_true() throws Exception {
        Sightings sightings = new Sightings("Musa", "near river");
        assertEquals("Musa", sightings.getName());

    }

    @Test
    public void SightingInstantiatesWithLocation_true() throws Exception {
        Sightings sightings = new Sightings("Musa", "near river");
        assertEquals("near river", sightings.getLocation());

    }

    @Test
    public void equals_returnsTrueIfNameAreSame_true() {
        Sightings sightings = new Sightings("Musa", "near river");
        Sightings sightings1 = new Sightings("Musa", "near river");
        assertTrue(sightings.equals(sightings1));
    }

    @Test
    public void save_insertsObjectIntoDatabase_Wildlife_Tracker() {
        Sightings testSightings= new Sightings("Musa", "near river");
        testSightings.save();
        assertTrue(Sightings.all().get(0).equals(testSightings));
    }

    //return all instances of sighting
    @Test
    public void all_returnsAllInstancesOfSighting_true() {
        Sightings firstSightings = new Sightings("Musa", "near river");
        firstSightings.save();
        Sightings secondSightings= new Sightings("Juma", "near spring");
        secondSightings.save();
        assertEquals(true, Sightings.all().get(0).equals(firstSightings));
        assertEquals(true, Sightings.all().get(1).equals(secondSightings));
    }

    //saving our ids form the db to our classes
    @Test
    public void save_assignsIdToObject() {
        Sightings testSightings= new Sightings("Juma", "near spring");
        testSightings.save();
        Sightings savedSightings = Sightings.all().get(0);
        assertEquals(testSightings.getId(), savedSightings.getId());
    }

    //find animals based on their id
    @Test
    public void find_returnsPersonWithSameId_secondPerson() {
        Sightings firstSightings= new Sightings("Musa", "near river");
        firstSightings.save();
        Sightings secondSightings = new Sightings("Juma", "near spring");
        secondSightings.save();
        assertEquals(Sightings.find(secondSightings.getId()), secondSightings);
    }

    //update sighting
    @Test
    public void update_updatesSightingname_true() {
        Sightings mySightings= new Sightings("Juma", "near spring");
        mySightings.save();
        mySightings.update("Mary");
        assertEquals("Mary", Sightings.find(mySightings.getId()).getName());
    }

    @Test
    public void delete_deletesSighting_true() {
        Sightings mySightings= new Sightings("Juma", "near spring");
        mySightings.save();
        int mySightingsId = mySightings.getId();
        mySightings.delete();
        assertEquals(null, Sightings.find(mySightingsId));
    }

}