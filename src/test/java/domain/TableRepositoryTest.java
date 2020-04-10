package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TableRepositoryTest {

    private TableRepository tableRepository;

    @BeforeEach
    void setUp() {
        tableRepository = new TableRepository();
    }

    @Test
    void create() {
        assertThat(TableRepository.tables().size()).isEqualTo(6);
    }

    @Test
    void findByTableNumber() {
        assertThat(tableRepository.findTableByTableNumber(1).orElse(null)).isEqualTo(new Table(1, Table.NOT_ORDER));
    }

    @Test
    void findByTableNumberWithInvalid() {
        assertThatThrownBy(() -> tableRepository.findTableByTableNumber(7).orElseThrow(IllegalArgumentException::new))
                .isInstanceOf(IllegalArgumentException.class);
    }
}