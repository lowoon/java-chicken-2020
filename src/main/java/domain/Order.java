package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Order {

    private static Map<Table, Menus> orders;

    static {
        orders = new HashMap<>();
        for (Table table : TableRepository.tables()) {
            orders.put(table, new Menus(Collections.EMPTY_LIST));
        }
    }

    public void addOrder(Table table, Menu menu, int count) {
        Menus menus = orders.get(table);
        menus.add(menu, count);
    }

    public Map<Table, Menus> getOrders() {
        return orders;
    }
}
