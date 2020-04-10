package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MenuTest {

    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
    }

    @Test
    void create() {
        assertThat(menu).isNotNull();
    }

    @Test
    void getName() {
        assertThat(menu.getName()).isEqualTo("후라이드");
    }

    @Test
    void getPrice() {
        assertThat(menu.getPrice()).isEqualTo(16_000);
    }
}