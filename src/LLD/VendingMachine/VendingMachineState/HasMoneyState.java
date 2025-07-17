package LLD.VendingMachine.VendingMachineState;

import LLD.VendingMachine.Coin;
import LLD.VendingMachine.VendingMachine;

/**
 * @author parachau
 **/
public class HasMoneyState extends State {
    public HasMoneyState(VendingMachine machine) {
        super(machine);
    }
    @Override
    public void selectItem(String code) {
        System.out.println("Item is already accepted");
    }

    @Override
    public void acceptMoney(Coin coin) {
        System.out.println("Money is already accepted. Please wait for the product");
    }

    @Override
    public void dispenseItem() {
        machine.addBalance(-machine.getSelectedItemPrice());
        machine.reduceItemStock(machine.getSelectedItemCode());
        System.out.println("Product " + machine.getItem().getName() + " dispensed");
//        machine.setState(new DispenseProductState(machine));
        machine.returnMoney();
    }

    @Override
    public void returnMoney() {
        if(machine.getBalance()>0){
            System.out.println("Returned " + machine.getBalance() + " amount");
        }
        machine.reset();
        machine.setState(new IdleState(machine));
    }
}
