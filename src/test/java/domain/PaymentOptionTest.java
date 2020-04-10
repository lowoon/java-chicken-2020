package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PaymentOptionTest {

    @Test
    void create() {
        PaymentOption paymentOption = PaymentOption.from(1);
        assertThat(paymentOption).isNotNull();
    }

    @Test
    void createWithInvalid() {
        assertThatThrownBy(() -> PaymentOption.from(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("createPayOption")
    void isOrder(PaymentOption option, boolean expected) {
        assertThat(option.isCash()).isEqualTo(expected);
    }

    private static Stream<Arguments> createPayOption() {
        return Stream.of(
                Arguments.of(PaymentOption.from(1), false),
                Arguments.of(PaymentOption.from(2), true)
        );
    }
}