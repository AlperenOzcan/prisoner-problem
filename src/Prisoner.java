import java.util.HashSet;

public class Prisoner {

    private int prisonerNumber;
    private HashSet<Integer> openedBoxes = new HashSet<>();

    public Prisoner(int prisonerNumber) {
         this.prisonerNumber = prisonerNumber;
    }

    public int getPrisonerNumber() {
        return this.prisonerNumber;
    }

    public boolean isBoxOpened(int boxNumber) {
        return openedBoxes.contains(boxNumber);
    }

    public void addOpenedBox(int boxNumber) {
        openedBoxes.add(boxNumber);
    }
}
