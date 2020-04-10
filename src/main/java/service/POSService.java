package service;

import domain.Menu;
import domain.MenuRepository;
import domain.Option;
import domain.Order;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

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

    public void pay(int tableNumber) {
        Table table = findTable(tableNumber);
        if (table.notOrdered()) {
            throw new IllegalArgumentException("주문하지 않은 테이블입니다.");
        }
    }
}
