import java.util.ArrayList;
import java.util.Optional;

public class SympatheticGuardian implements Guardian {

    private ArrayList<Box> boxes;

    public SympatheticGuardian(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }

    @Override
    public void takeAction() {
        Optional<ArrayList<Box>> loop = findLoopLongerOrEqualToHalfOfNumberOfBoxes();
        if (loop.isEmpty()) {
            return;
        }
        ArrayList<Box> loopToCut = loop.get();
        int lastBoxNumberInFirstQuarter = loopToCut.size() / 4;
        Box firstTargetBox = loopToCut.get(lastBoxNumberInFirstQuarter - 1);
        Box secondTargetBox = loopToCut.get(1 + lastBoxNumberInFirstQuarter * 3);
        swapTwoBoxesContent(firstTargetBox, secondTargetBox);
    }

    private Optional<ArrayList<Box>> findLoopLongerOrEqualToHalfOfNumberOfBoxes() {
        int numberOfPrisoners = Utils.NUMBER_OF_PRISONERS;
        int loopLengthLimit = numberOfPrisoners / 2;
        int loopLength;
        for (Box box : boxes) {
            ArrayList<Box> loop = findLoop(box.getOutsiderNumber());
            loopLength = loop.size();
            if (loopLength >= loopLengthLimit) {
                return Optional.of(loop);
            }
        }
        return Optional.empty();
    }

    private ArrayList<Box> findLoop(int startingBoxNumber) {
        ArrayList<Box> openedBoxList = new ArrayList<>();
        int boxNumberToBeOpened = startingBoxNumber;
        while (true) {
            Box openedBox = boxes.get(boxNumberToBeOpened);
            int nextBoxNumber = openedBox.getInsiderNumber();
            if (startingBoxNumber == nextBoxNumber) {
                break;
            } else {
                openedBoxList.add(openedBox);
                boxNumberToBeOpened = nextBoxNumber;
            }
        }
        return openedBoxList;
    }

    private void swapTwoBoxesContent(Box box1, Box box2) {
        int temp = box1.getInsiderNumber();
        box1.setInsiderNumber(box2.getInsiderNumber());
        box2.setInsiderNumber(temp);
    }

}
