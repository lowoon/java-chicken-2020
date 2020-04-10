package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menus {

    private static final int MAX_COUNT = 99;
    private Map<Menu, Integer> menus;

    public Menus(final List<Menu> menus) {
        this.menus = new HashMap<>();
        for (Menu menu : menus) {
            this.menus.put(menu, 0);
        }
    }

    public void add(Menu menu, int count) {
        if (menus.get(menu) == null) {
            menus.putIfAbsent(menu, 0);
        }
        if (menus.get(menu) + count > MAX_COUNT) {
            throw new IllegalArgumentException("한 메뉴의 최대 수량 99개입니다.");
        }
        menus.computeIfPresent(menu, (key, value) -> value + count);
    }

    public Map<Menu, Integer> getMenus() {
        return menus;
    }
}
