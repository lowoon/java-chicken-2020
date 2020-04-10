package domain;

import java.util.Arrays;

public enum Option {

    ORDER(1),
    PAY(2),
    EXIT(3);

    private int option;

    Option(final int option) {
        this.option = option;
    }

    public static Option from(final int optionNumber) {
        return Arrays.stream(Option.values())
                .filter(option -> option.option == optionNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("주문등록(1), 결제하기(2), 프로그램 종료(3)만 선택 가능합니다."));
    }

    public boolean isOrder() {
        return option == ORDER.option;
    }

    public boolean isPay() {
        return option == PAY.option;
    }

    public boolean isNotExit() {
        return option != EXIT.option;
    }
}
