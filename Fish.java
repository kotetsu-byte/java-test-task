import java.util.*;

class Fish extends Thread {
    private static final Random random = new Random();
    private String key;
    private String gender;
    private static double lifespan;

    public void setKey(String val)
    {
        key = val;
    }
    public String getKey()
    {
        return key;
    }
    
    public void setGender(String val) {
        gender = val;
    }
    public String getGender() {
        return gender;
    }

    public static void setLifespan(double ls)
    {
        lifespan = random.nextDouble(ls) + 1;
    }
    public static double getLifespan()
    {
        return lifespan;
    }
}