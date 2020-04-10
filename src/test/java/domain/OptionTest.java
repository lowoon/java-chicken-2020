package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OptionTest {

    @Test
    void create() {
        Option option = Option.from(1);
        assertThat(option).isNotNull();
    }

    @Test
    void createWithInvalidInput() {
        assertThatThrownBy(() -> Option.from(4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("주문등록(1), 결제하기(2), 프로그램 종료(3)만 선택 가능합니다.");
    }

    @ParameterizedTest
    @MethodSource("createOptionOrder")
    void isOrder(Option option, boolean expected) {
        assertThat(option.isOrder()).isEqualTo(expected);
    }

    private static Stream<Arguments> createOptionOrder() {
        return Stream.of(
                Arguments.of(Option.from(1), true),
                Arguments.of(Option.from(2), false)
        );
    }

    @ParameterizedTest
    @MethodSource("createOptionPay")
    void isPay(Option option, boolean expected) {
        assertThat(option.isPay()).isEqualTo(expected);
    }

    private static Stream<Arguments> createOptionPay() {
        return Stream.of(
                Arguments.of(Option.from(2), true),
                Arguments.of(Option.from(1), false)
        );
    }

    @ParameterizedTest
    @MethodSource("createOptionExit")
    void isNotExit(Option option, boolean expected) {
        assertThat(option.isNotExit()).isEqualTo(expected);
    }

    private static Stream<Arguments> createOptionExit() {
        return Stream.of(
                Arguments.of(Option.from(2), true),
                Arguments.of(Option.from(3), false)
        );
    }
}