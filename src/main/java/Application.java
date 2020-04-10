import domain.MenuRepository;
import domain.Option;
import domain.TableRepository;
import service.POSService;
import view.InputView;
import view.OutputView;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        POSService pos = new POSService();
        Option option;

        do {
            OutputView.printOptions();
            option = receiveOptionNumber();
            if (option.isOrder()) {
                receiveOrder(pos);
            }
            if (option.isPay()) {
                payOrders(pos);
            }
        } while (option.isNotExit());
    }

    private static void receiveOrder(POSService pos) {
        try {
            OutputView.printTables(TableRepository.tables());
            int tableNumber = receiveTableNumber();
            OutputView.printMenus(MenuRepository.menus());
            int menuNumber = receiveMenuNumber();
            int count = receiveCount();
            pos.applyOrder(tableNumber, menuNumber, count);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            receiveOrder(pos);
        }
    }

    private static Option receiveOptionNumber() {
        try {
            return Option.from(InputView.inputOptionNumber());
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닙니다.");
            return receiveOptionNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return receiveOptionNumber();
        }
    }

    private static int receiveTableNumber() {
        try {
            return InputView.inputTableNumber();
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닙니다.");
            return receiveTableNumber();
        }
    }

    private static int receiveMenuNumber() {
        try {
            return InputView.inputMenuNumber();
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닙니다.");
            return receiveMenuNumber();
        }
    }

    private static int receiveCount() {
        try {
            return InputView.inputMenuCount();
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닙니다.");
            return receiveCount();
        }
    }

    private static void payOrders(final POSService pos) {
        OutputView.printTables(TableRepository.tables());
        int tableNumber = receiveTableNumber();
        OutputView.printOrders(pos.getMenus(tableNumber));
        OutputView.printPaymentOfTable(tableNumber);
        int payOption = receivePayment();
        OutputView.printTotalPrice(pos.pay(tableNumber, payOption));
    }

    private static int receivePayment() {
        try {
            return InputView.inputPaymentOption();
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닙니다.");
            return receivePayment();
        }
    }

}
