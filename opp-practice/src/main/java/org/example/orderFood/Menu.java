package org.example.orderFood;

import java.util.List;

public class Menu {
    private final List<MenuItem> menuItems;

    public <E> Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public MenuItem choose(String name) {
//        return new MenuItem("돈까스", 5000);
        return this.menuItems.stream()
                .filter(menuItem -> menuItem.matches(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴 이름입니다."));
    }
}
