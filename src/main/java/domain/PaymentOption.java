package domain;

import java.util.Arrays;

public enum PaymentOption {

    CARD(1),
    CASH(2);

    private int option;

    PaymentOption(final int option) {
        this.option = option;
    }

    public static PaymentOption from(final int optionNumber) {
        return Arrays.stream(PaymentOption.values())
                .filter(option -> option.option == optionNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("주문등록(1), 결제하기(2), 프로그램 종료(3)만 선택 가능합니다."));
    }

    public boolean isCash() {
        return option == CASH.option;
    }
}
