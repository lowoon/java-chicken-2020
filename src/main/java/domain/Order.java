package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Order {

    private static final double CASH_DISCOUNT = 0.95;
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

    public void initializeTable(Table table) {
        orders.put(table, new Menus(Collections.EMPTY_LIST));
    }

    public double calculatePrice(final PaymentOption option, final Table table) {
        int price = orders.get(table).calculatePrice();
        if (option.isCash()) {
            return price * CASH_DISCOUNT;
        }
        return price;
    }

    public Menus getMenus(final Table table) {
        return orders.get(table);
    }

    public Map<Table, Menus> getOrders() {
        return orders;
    }
}
