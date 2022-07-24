import java.util.ArrayList;
import java.util.Collections;

public class Utils {

    public static final int NUMBER_OF_PRISONERS = 100;

    public ArrayList<Prisoner> createPrisoners() {
        ArrayList<Prisoner> prisoners = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_PRISONERS; i++) {
            Prisoner p = new Prisoner(i);
            prisoners.add(p);
        }
        return prisoners;
    }

    public ArrayList<Box> createBoxes() {
        ArrayList<Box> boxes = new ArrayList<>();
        ArrayList<Integer> randomizedInsiderNumbers = generateRandomizedInsiderNumbers();
        for (int i = 0; i < NUMBER_OF_PRISONERS; i++) {
            Box b = new Box(i, randomizedInsiderNumbers.get(i));
            boxes.add(b);
        }
        return boxes;
    }

    public boolean travel(Prisoner prisoner, ArrayList<Box> boxes) {
        int numberOfTry = 0;
        int prisonerNumber = prisoner.getPrisonerNumber();
        int boxNumberToBeOpenedNext = prisonerNumber;
        do {
            numberOfTry++;
            Box openedBox = boxes.get(boxNumberToBeOpenedNext);
            int boxInsiderNumber = openedBox.getInsiderNumber();
            if (prisonerNumber == boxInsiderNumber) {
                return true;
            }
            boxNumberToBeOpenedNext = boxInsiderNumber;
        } while (numberOfTry < NUMBER_OF_PRISONERS / 2);
        return false;
    }

    private ArrayList<Integer> generateRandomizedInsiderNumbers() {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_PRISONERS; i++) {
            result.add(i);
        }
        Collections.shuffle(result);
        return result;
    }
}
