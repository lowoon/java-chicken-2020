package service;

import domain.Menu;
import domain.MenuRepository;
import domain.Menus;
import domain.Order;
import domain.PaymentOption;
import domain.Table;
import domain.TableRepository;

public class POSService {

    private Order order = new Order();
    private MenuRepository menuRepository = new MenuRepository();
    private TableRepository tableRepository = new TableRepository();

    public void applyOrder(int tableNumber, int menuNumber, int count) {
        Table table = findTable(tableNumber);
        Menu menu = findMenu(menuNumber);
        order.addOrder(table, menu, count);
        tableRepository.updateTableByTableNumber(tableNumber, table.gotOrder());
    }

    private Table findTable(int tableNumber) {
        return tableRepository.findTableByTableNumber(tableNumber)
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 테이블입니다."));
    }

    private Menu findMenu(int menuNumber) {
        return menuRepository.findMenuByMenuNumber(menuNumber)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
    }

    public double pay(int tableNumber, int paymentOption) {
        Table table = findTable(tableNumber);
        if (table.notOrdered()) {
            throw new IllegalArgumentException("주문하지 않은 테이블입니다.");
        }
        PaymentOption option = PaymentOption.from(paymentOption);
        double totalPrice = order.calculatePrice(option, table);
        tableRepository.updateTableByTableNumber(tableNumber, table.initial());
        order.initializeTable(table);
        return totalPrice;
    }

    public Menus getMenus(int tableNumber) {
        Table table = findTable(tableNumber);
        return order.getMenus(table);
    }
}
