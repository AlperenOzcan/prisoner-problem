public class Box {

    private int insiderNumber;
    private int outsiderNumber;

    public Box(int outsiderNumber, int insiderNumber) {
        this.outsiderNumber = outsiderNumber;
        this.insiderNumber = insiderNumber;
    }

    public int getInsiderNumber() {
        return insiderNumber;
    }

    public void setInsiderNumber(int insiderNumber) {
        this.insiderNumber = insiderNumber;
    }

    public int getOutsiderNumber() {
        return outsiderNumber;
    }
}
