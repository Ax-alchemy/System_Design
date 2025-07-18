package LLD.VendingMachine;

/**
 * @author parachau
 **/
public enum Coin {
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10);

    private final int value;

    Coin(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
