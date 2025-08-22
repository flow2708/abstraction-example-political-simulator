package com.flow.flowpolitics;

public enum Resource {
    COIN("Монета"),
    WOOD("Дерево"),
    STONE("Камень"),
    IRON("Железо"),
    FOOD("Еда");
    private final String name;
    Resource(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
