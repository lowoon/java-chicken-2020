package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    void create() {
        Menu menu = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        assertThat(menu).isNotNull();
    }
}