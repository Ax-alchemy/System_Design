package LLD.VendingMachine.VendingMachineState;

import LLD.VendingMachine.Coin;
import LLD.VendingMachine.VendingMachine;

/**
 * @author parachau
 **/
public class IdleState extends State {
    public IdleState(VendingMachine machine) {
        super(machine);
    }
    @Override
    public void selectItem(String code) {
        if(!machine.isSelectedItemAvailable(code)){
            System.out.println("Item not available");
            return;
        }
        machine.setSelectedItemCode(code);
        machine.setState(new AcceptMoneyState(machine));
    }

    @Override
    public void acceptMoney(Coin coin) {
        System.out.println("First select item");
    }

    @Override
    public void dispenseItem() {
        System.out.println("First select item and pay money");
    }

    @Override
    public void returnMoney() {
        System.out.println("First select item and pay money");
    }
}
