//package LLD.VendingMachine.VendingMachineState;
//
//import LLD.VendingMachine.Coin;
//import LLD.VendingMachine.VendingMachine;
//
///**
// * @author parachau
// **/
//public class DispenseProductState extends State {
//
//    public DispenseProductState(VendingMachine machine) {
//        super(machine);
//    }
//    @Override
//    public void selectItem(String code) {
//        throw new UnsupportedOperationException("Item is already accepted");
//    }
//
//    @Override
//    public void acceptMoney(Coin coin) {
//        throw new UnsupportedOperationException("Money is already accepted");
//    }
//
//    @Override
//    public void dispenseItem() {
//        throw new UnsupportedOperationException("Item is already dispensed");
//    }
//
//    @Override
//    public void returnMoney() {
//        if(machine.getBalance()>0){
//            System.out.println("Returned " + machine.getBalance() + " amount");
//        }
//        machine.reset();
//        machine.setState(new IdleState(machine));
//    }
//}
