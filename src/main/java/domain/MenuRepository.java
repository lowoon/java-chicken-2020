package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class MenuRepository {
    private static final Map<Integer, Menu> menus;

    static {
        menus = new TreeMap<>();
        menus.put(1, new Menu(1, "후라이드", Category.CHICKEN, 16_000));
        menus.put(2, new Menu(2, "양념치킨", Category.CHICKEN, 16_000));
        menus.put(3, new Menu(3, "반반치킨", Category.CHICKEN, 16_000));
        menus.put(4, new Menu(4, "통구이", Category.CHICKEN, 16_000));
        menus.put(5, new Menu(5, "간장치킨", Category.CHICKEN, 17_000));
        menus.put(6, new Menu(6, "순살치킨", Category.CHICKEN, 17_000));
        menus.put(21, new Menu(21, "콜라", Category.BEVERAGE, 1_000));
        menus.put(22, new Menu(22, "사이다", Category.BEVERAGE, 1_000));
    }

    public Optional<Menu> findMenuByMenuNumber(int menuNumber) {
        return Optional.ofNullable(menus.get(menuNumber));
    }

    public static List<Menu> menus() {
        return Collections.unmodifiableList(new ArrayList<>(menus.values()));
    }
}
