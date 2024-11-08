import java.util.*;

public class Main {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        System.out.print("Enter males count: ");
        Aquarium.setMalesCount(scanner.nextInt());
        System.out.print("Enter females count: ");
        Aquarium.setFemalesCount(scanner.nextInt());
        System.out.print("Enter max lifespan of all fish: ");
        Fish.setLifespan(scanner.nextDouble());
        System.out.print("Enter max capacity of fish in the aquarium: ");
        Aquarium.setFishMaxPossibleCount(scanner.nextInt());
        System.out.println("There is " + Aquarium.getMalesCount() + " males and " + Aquarium.getFemalesCount() + " females");

        while (true) {
            Aquarium obj = new Aquarium();
            if(Aquarium.totalFish.size() >= Aquarium.getFishMaxPossibleCount())
            {
                break;
            }
        }
    }
}