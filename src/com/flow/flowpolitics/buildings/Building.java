package com.flow.flowpolitics.buildings;

import com.flow.flowpolitics.Faction;
import com.flow.flowpolitics.Resource;
import com.flow.flowpolitics.Type;
import com.flow.flowpolitics.effects.BuildingEffect;

import java.util.Map;

public interface Building {
    Type getType();
    int getLevel();
    Map<Resource, Integer> getUpgradeCost();
    void onTick(Faction faction);

    void addEffect(BuildingEffect effect);

    String getDescription();
    void applyEffect(Faction faction);
}
