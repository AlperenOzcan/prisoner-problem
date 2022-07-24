import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Utils utils = new Utils();

        int numberOfExperiments = 10000;

        double success = 0;
        for (int i = 1; i <= numberOfExperiments; i++) {
            ArrayList<Prisoner> prisoners = utils.createPrisoners();
            ArrayList<Box> boxes = utils.createBoxes();
            // new SympatheticGuardian(boxes).takeAction(); // Activate this line if you want to get 100% success rate
            boolean allPrisonersFoundTheirNumber = true;
            for (Prisoner prisoner : prisoners) {
                boolean prisonerFindHisNumber = utils.travel(prisoner, boxes);
                if (!prisonerFindHisNumber) {
                    allPrisonersFoundTheirNumber = false;
                    break;
                } else {
                    success++;
                }
            }
            System.out.println("i: " + i + " Result: " + allPrisonersFoundTheirNumber);
        }
        System.out.println("Success Rate: " + success / numberOfExperiments);
    }
}
