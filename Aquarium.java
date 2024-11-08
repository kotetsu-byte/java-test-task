import java.util.*;

class Aquarium {
    private static final Random random = new Random();
    private static List<Fish> males = new ArrayList<>();
    private static List<Fish> females = new ArrayList<>();
    public static List<Fish> totalFish;
    private static int malesCount;
    private static int femalesCount;
    private Map<Fish, Fish> pairs = new HashMap<>();
    private static int fishMaxCount;

    public Aquarium() {
        for(int i = 0; i < malesCount; i++) {
            Fish male = new Male(i+1, Fish.getLifespan());
            males.add(male);
            male.start();
        }
        for(int i = 0; i < femalesCount; i++) {
            Fish female = new Female(i+1, Fish.getLifespan());
            females.add(female);
            female.start();
        }

        totalFish = new ArrayList<>(males);
        totalFish.addAll(females);

        if(totalFish.size() <= fishMaxCount) {
            this.registerInitialFishes();
        }
    }
    
    public void registerInitialFishes()
    {
        if(males.size() > 0 && females.size() > 0) {
            int pairsNum = Math.min(males.size(), females.size());
            for(int i = 0; i < pairsNum; i++)
            {
                pairs.put(males.get(i), females.get(i));
            }
            pairs.forEach((male, female) -> {
                this.breedFish(male, female);
            });
        }
    }

    private void breedFish(Fish male, Fish female) {
        System.out.println("Fish Male " + male.getKey() + " and fish Female " + female.getKey() + " are breeding");
        int childrenNum = random.nextInt(10) + 1;

        for(int i = 0; i < childrenNum; i++)
        {
            Fish child = new Fish();
            boolean childGender = random.nextBoolean();
            if(childGender == false) {
                child = new Male(i + totalFish.size() + 1, Fish.getLifespan());
                malesCount++;
            } else if (childGender == true) {
                child = new Female(i + totalFish.size() + 1, Fish.getLifespan());
                femalesCount++;
            }
            registerChildren(child);
        }
    }

    private void registerChildren(Fish fish)
    {
        System.out.println("Child fish " + fish.getGender() + " " + fish.getKey() + " has been born");
    }

    // getters and setters
    public static void setFishMaxPossibleCount(int maxCount) {
        fishMaxCount = maxCount;
    }
    public static int getFishMaxPossibleCount()
    {
        return fishMaxCount;
    }

    public static void setMalesCount(int count)
    {
        malesCount = count;
    }
    public static int getMalesCount()
    {
        return malesCount;
    }

    public static void setFemalesCount(int count)
    {
        femalesCount = count;
    }
    public static int getFemalesCount()
    {
        return femalesCount;
    }
}