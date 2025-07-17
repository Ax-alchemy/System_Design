package LLD.VendingMachine.VendingMachineState;

import LLD.VendingMachine.Coin;
import LLD.VendingMachine.VendingMachine;

/**
 * @author parachau
 **/
public class AcceptMoneyState extends State {

    public AcceptMoneyState(VendingMachine machine) {
        super(machine);
    }
    @Override
    public void selectItem(String code) {
        System.out.println("Item is already accepted");
    }

    @Override
    public void acceptMoney(Coin coin) {
        machine.addBalance(coin.getValue());
        if(machine.getBalance() >= machine.getSelectedItemPrice()){
            System.out.println("Enough money");
            machine.setState(new HasMoneyState(machine));
            return;
//            machine.dispenseItem();
        }
        System.out.println("Not enough money. Please enter more.");
    }

    @Override
    public void dispenseItem() {
        System.out.println("First enter enough money");
    }

    @Override
    public void returnMoney() {
        if(machine.getBalance()>0){
            System.out.println(machine.getBalance() + " has been returned");
        }
        machine.reset();
        machine.setState(new IdleState(machine));
    }
}
