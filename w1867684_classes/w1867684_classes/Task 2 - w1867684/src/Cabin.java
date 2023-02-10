public class Cabin {
    private boolean empty;
    private int cabinNumber;

    public Cabin(int cabinNumber) {
        this.cabinNumber = cabinNumber;
        this.empty = true;
    }

    public static void remove(int i) {
    }

    public int getCabinNumber() {
        return cabinNumber + 1;
    }

    public void setCabinNumber(int cabinNumber) {
        this.cabinNumber = cabinNumber;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}


