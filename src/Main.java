import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Utils utils = new Utils();

        for (int i = 1; i <= 100; i++) {
            ArrayList<Prisoner> prisoners = utils.createPrisoners();
            ArrayList<Box> boxes = utils.createBoxes();
            boolean allPrisonersFindTheirNumber = true;
            for (Prisoner prisoner: prisoners) {
                boolean prisonerFindHisNumber = utils.travel(prisoner, boxes);
                if(!prisonerFindHisNumber) {
                    allPrisonersFindTheirNumber = false;
                    break;
                }
            }
            System.out.println("i: " + i + " Result: " + allPrisonersFindTheirNumber);
        }
    }
}
