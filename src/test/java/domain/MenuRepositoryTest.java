package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MenuRepositoryTest {

    private MenuRepository menuRepository;

    @BeforeEach
    void setUp() {
        menuRepository = new MenuRepository();
    }

    @Test
    void create() {
        assertThat(MenuRepository.menus().size()).isEqualTo(8);
    }

    @Test
    void findByTableNumber() {
        assertThat(menuRepository.findMenuByMenuNumber(1).orElse(null)).isEqualTo(new Menu(1, "후라이드", Category.CHICKEN, 16_000));
    }

    @Test
    void findByTableNumberWithInvalid() {
        assertThatThrownBy(() -> menuRepository.findMenuByMenuNumber(7).orElseThrow(IllegalArgumentException::new))
                .isInstanceOf(IllegalArgumentException.class);
    }
}