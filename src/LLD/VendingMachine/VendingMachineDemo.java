package LLD.VendingMachine;


/**
 * @author parachau
 **/
public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();
        addItems(vendingMachine);

        System.out.println("item 102");
        vendingMachine.selectItem("102");
        vendingMachine.acceptMoney(Coin.TEN);
        vendingMachine.acceptMoney(Coin.ONE);
        vendingMachine.acceptMoney(Coin.TEN);
        vendingMachine.dispenseItem();

        System.out.println();
        System.out.println("item 101");
        vendingMachine.selectItem("101");
        vendingMachine.acceptMoney(Coin.TEN);
        vendingMachine.returnMoney();
        vendingMachine.acceptMoney(Coin.FIVE);
        vendingMachine.acceptMoney(Coin.TEN);
        vendingMachine.returnMoney();

        System.out.println();
        System.out.println("item 101");
        vendingMachine.selectItem("101");
        vendingMachine.acceptMoney(Coin.TEN);
        vendingMachine.dispenseItem();

    }

    static void addItems(VendingMachine machine){
        machine.addItem("101", "Coke", 20, 1);
        machine.addItem("102", "Soda", 15, 2);
        machine.addItem("103", "Oreo", 20, 5);
        machine.addItem("104", "Lays Chips", 10, 3);
    }

}
