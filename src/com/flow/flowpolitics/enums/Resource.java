package com.flow.flowpolitics.enums;

public enum Resource {
    COIN("Монета"),
    WOOD("Дерево"),
    STONE("Камень"),
    IRON("Железо"),
    FOOD("Еда"),
    RIFLE("Винтовка"),
    RIFLEBULLET("Патроны для винтовки");
    private final String name;
    Resource(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
