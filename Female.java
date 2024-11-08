import java.util.*;

class Female extends Fish
{
    private static final Random random = new Random();
    private String key;
    private static double lifespan;
    private String gender;

    public Female(int y, double lifespan) {
        super.setKey(String.format("#%d", y));
        key = super.getKey();

        super.setGender("Female");
        gender = super.getGender();

        Fish.setLifespan(lifespan);
        lifespan = Fish.getLifespan();
    }    

    @Override
    public void run()
    {
        try {
            Thread.sleep((int)lifespan * 10000);
        } catch (InterruptedException e) {
        }
    }

    // getters & setters
    public void setKey(String key)
    {
        this.key = key;
    }
    public String getKey()
    {
        return this.key;
    }

    public static void setLifespan(double ls)
    {
        lifespan = ls;
    }
    public static double getLifespan()
    {
        return lifespan;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }
    public String getGender()
    {
        return this.gender;
    }
}