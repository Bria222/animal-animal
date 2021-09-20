public abstract class Animal {

    public int id;
    public String name;

    public int endangeredAnimalId;

    //CONSTANTS
    public String healthLevel;
    public String ageLevel;

    public String type;

    public static final String MAX_HEALTH_LEVEL = "healthy";
    public static final String MEDIUM_HEALTH_LEVEL = "okay";
    public static final String MIN_HEALTH_LEVEL = "ill";

    public static final String MAX_AGE_LEVEL = "adult";
    public static final String MEDIUM_AGE_LEVEL = "young";
    public static final String MIN_AGE_LEVEL = "mewborn";

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHealthLevel() {
        return healthLevel;
    }

    public String getAgeLevel() {
        return ageLevel;
    }

    public int getEndangeredAnimalId() {
        return endangeredAnimalId;
    }
}
