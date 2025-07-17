package LLD.VendingMachine;

/**
 * @author parachau
 **/
public class Item {
    private String code;
    private String name;
    private int price;
    private int quantity;

    public Item(String code, String name, int price, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
