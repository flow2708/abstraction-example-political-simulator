package com.flow.flowpolitics.buildings;

import com.flow.flowpolitics.Faction;
import com.flow.flowpolitics.Resource;
import com.flow.flowpolitics.Type;

import java.util.Map;

public class BuildingBase implements Building{
    protected final Type type;
    protected int level;
    protected String description;
    public BuildingBase(Type type, int level, String description) {
        this.type = type;
        this.level = level;
        this.description = description;
    }
    @Override
    public Type getType() {
        return type;
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
