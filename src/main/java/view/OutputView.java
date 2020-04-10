package view;

import domain.Menu;
import domain.Menus;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ %s ┘";

    public static void printOptions() {
        System.out.println("## 메인 화면");
        System.out.println("1 - 주문하기");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    private static void printBottomLine(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(BOTTOM_LINE, table.getStatus());
        }
        System.out.println();
    }

    public static void printOrders(final Menus menus) {
        System.out.println("## 주문 내역");
        menus.getMenus()
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() != 0)
                .forEach(entry -> System.out.println(entry.getKey().getName() + " " +  entry.getValue() + " " + entry.getKey().getPrice()));
    }

    public static void printPaymentOfTable(final int tableNumber) {
        System.out.println("## " + tableNumber + "번 테이블의 결제를 진행합니다.");
    }

    public static void printTotalPrice(final double pay) {
        System.out.println("## 최종 결제할 금액");
        System.out.printf("%.0f원\n", pay);
    }
}
