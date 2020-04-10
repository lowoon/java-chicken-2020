package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MenusTest {

    private Menus menus;

    @BeforeEach
    void setUp() {
        menus = new Menus(Collections.EMPTY_LIST);
    }

    @Test
    void create() {
        assertThat(menus).isNotNull();
    }

    @Test
    void addWithMaxCount() {
        menus.add(new Menu(1, "후라이드", Category.CHICKEN, 16_000), 99);
        assertThatThrownBy(() -> menus.add(new Menu(1, "후라이드", Category.CHICKEN, 16_000), 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("한 메뉴의 최대 수량 99개입니다.");
    }
}