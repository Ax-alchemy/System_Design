package LLD.VendingMachine.VendingMachineState;

import LLD.VendingMachine.Coin;
import LLD.VendingMachine.VendingMachine;

/**
 * @author parachau
 **/
public abstract class State {
    VendingMachine machine;

    protected State(VendingMachine machine) {
        this.machine = machine;
    }

    public abstract void selectItem(String code);

    public abstract void acceptMoney(Coin coin);

    public abstract void dispenseItem();

    public abstract void returnMoney();
}
