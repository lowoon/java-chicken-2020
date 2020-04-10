package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class TableRepository {
    private static final Map<Integer, Table> tables;

    static {
        tables = new TreeMap<>();
        tables.put(1, new Table(1, Table.NOT_ORDER));
        tables.put(2, new Table(2, Table.NOT_ORDER));
        tables.put(3, new Table(3, Table.NOT_ORDER));
        tables.put(4, new Table(5, Table.NOT_ORDER));
        tables.put(6, new Table(6, Table.NOT_ORDER));
        tables.put(8, new Table(8, Table.NOT_ORDER));
    }

    public Optional<Table> findTableByTableNumber(int tableNumber) {
        return Optional.ofNullable(tables.get(tableNumber));
    }

    public void updateTableByTableNumber(int tableNumber, Table table) {
        tables.put(tableNumber, table);
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(new ArrayList<>(tables.values()));
    }
}
