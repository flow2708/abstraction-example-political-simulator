package com.flow.flowpolitics.buildings;

import com.flow.flowpolitics.Faction;
import com.flow.flowpolitics.enums.Resource;
import com.flow.flowpolitics.enums.Type;
import com.flow.flowpolitics.interfaces.Building;

import java.util.Map;
import java.util.UUID;

public class BuildingBase implements Building {
    private final String id;
    private final Type type;
    private String name;
    protected int level;
    protected String description;
    //protected List<BuildingEffect> effects = new ArrayList<>();
    public BuildingBase(Type type,String name, int level, String description) {
        this.id = "building_" + UUID.randomUUID().toString().substring(0, 8);
        this.type = type;
        this.name = name;
        this.level = level;
        this.description = description;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public Map<Resource, Integer> getUpgradeCost() {
        return null;
    }

    @Override
    public void onTick(Faction faction) {

    }
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public void applyEffect(Faction faction) {

    }
}
