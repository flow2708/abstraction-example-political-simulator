package com.flow.flowpolitics.buildings;

import com.flow.flowpolitics.Faction;
import com.flow.flowpolitics.Resource;
import com.flow.flowpolitics.Type;
import com.flow.flowpolitics.effects.BuildingEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuildingBase implements Building{
    protected final String id;
    protected final Type type;
    protected String name;
    protected int level;
    protected String description;
    protected List<BuildingEffect> effects = new ArrayList<>();
    public BuildingBase(String id,Type type,String name, int level, String description) {
        this.id = id;
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
        for (BuildingEffect effect : effects) {
            effect.applyEffect(faction);
        }
    }
    @Override
    public void addEffect(BuildingEffect effect) {
        effects.add(effect);
    }

    @Override
    public void removeEffect(BuildingEffect effect) {
        effects.remove(effect);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void applyEffect(Faction faction) {

    }
}
