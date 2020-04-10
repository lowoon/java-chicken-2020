package domain;

import java.util.Objects;

public class Table {
    public static final String NOT_ORDER = "-";
    public static final String ORDERED = "₩";

    private final int number;
    private final String status;

    public Table(final int number, final String status) {
        this.number = number;
        this.status = status;
    }

    public Table gotOrder() {
        return new Table(number, ORDERED);
    }

    public Table initial() {
        return new Table(number, NOT_ORDER);
    }

    public boolean notOrdered() {
        return status.equals(NOT_ORDER);
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Table))
            return false;
        final Table table = (Table)o;
        return number == table.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
