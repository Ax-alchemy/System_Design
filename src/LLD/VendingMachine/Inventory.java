package LLD.VendingMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author parachau
 **/
public class Inventory {
    private Map<String,Item> itemMap = new HashMap<>();

    public void addItem(String code, Item item) {
        itemMap.put(code, item);
    }

    public Item getItem(String code) {
        return itemMap.getOrDefault(code,null);
    }

    public void reduceItemStock(String code) {
        if(itemMap.containsKey(code))
            itemMap.get(code).setQuantity(itemMap.get(code).getQuantity() - 1);
    }

    public boolean isItemAvailable(String code) {
        return itemMap.containsKey(code) && itemMap.get(code).getQuantity()>0;

    }

    public int getItemPrice(String code) {
        return itemMap.containsKey(code)?itemMap.get(code).getPrice():0;
    }

}
