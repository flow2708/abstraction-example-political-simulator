package com.flow.flowpolitics.buildings;

import com.flow.flowpolitics.Faction;
import com.flow.flowpolitics.Resource;
import com.flow.flowpolitics.Type;
import com.flow.flowpolitics.effects.BuildingEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuildingBase implements Building{
    protected final Type type;
    protected int level;
    protected String description;
    protected List<BuildingEffect> effects = new ArrayList<>();
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
        for (BuildingEffect effect : effects) {
            effect.applyEffect(faction);
        }
    }
    @Override
    public void addEffect(BuildingEffect effect) {
        effects.add(effect);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void applyEffect(Faction faction) {

    }
}
