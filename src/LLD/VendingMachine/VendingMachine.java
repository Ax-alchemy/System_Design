package LLD.VendingMachine;

import LLD.VendingMachine.VendingMachineState.IdleState;
import LLD.VendingMachine.VendingMachineState.State;

import java.util.ArrayList;
import java.util.List;

/**
 * @author parachau
 **/
public class VendingMachine {
    private static final VendingMachine INSTANCE = new VendingMachine();
    private State state;
    private Inventory inventory;
    private String selectedItemCode;
    int balance;

    private VendingMachine() {
        inventory = new Inventory();
        state = new IdleState(this);
    }

    public static VendingMachine getInstance() {
        return INSTANCE;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void selectItem(String code){
        state.selectItem(code);
    }

    public void acceptMoney(Coin coin){
        state.acceptMoney(coin);
    }

    public void dispenseItem(){
        state.dispenseItem();
    }

    public void returnMoney(){
        state.returnMoney();
    }

    public void reset(){
        selectedItemCode = "";
        balance = 0;
    }

    public Item addItem(String code, String name, int price, int quantity){
        Item item = new Item(code, name, price, quantity);
        inventory.addItem(code, item);
        return item;
    }

    public void reduceItemStock(String code){
        inventory.reduceItemStock(code);
    }

    public Item getItem(){
        return inventory.getItem(selectedItemCode);
    }

    public String getSelectedItemCode() {
        return selectedItemCode;
    }

    public void setSelectedItemCode(String selectedItemCode) {
        this.selectedItemCode = selectedItemCode;
    }

    public boolean isSelectedItemAvailable(String code){
        return inventory.isItemAvailable(code);
    }

    public int getSelectedItemPrice(){
        return inventory.getItemPrice(selectedItemCode);
    }

    public void addBalance(int coin){
        balance += coin;
    }

    public int getBalance(){
        return balance;
    }
}
