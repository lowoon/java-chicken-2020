package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputOptionNumber() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputMenuNumber() {
        System.out.println("## 메뉴를 선택해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputMenuCount() {
        System.out.println("## 메뉴의 수량을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputPaymentOption() {
        System.out.println("## 신용카드는 1번, 현금은 2번");
        return Integer.parseInt(scanner.nextLine());
    }
}
