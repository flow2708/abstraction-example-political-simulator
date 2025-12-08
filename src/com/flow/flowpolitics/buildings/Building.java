package com.flow.flowpolitics.buildings;

import com.flow.flowpolitics.Faction;
import com.flow.flowpolitics.Resource;
import com.flow.flowpolitics.Type;
import com.flow.flowpolitics.buildconditions.BuildCondition;
import com.flow.flowpolitics.effects.BuildingEffect;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface Building {
    String getId();
    Type getType();
    String getName();
    int getLevel();
    String getDescription();
    Map<Resource, Integer> getUpgradeCost();
    void onTick(Faction faction);
    default BuildCondition getBuildingCondition() {
        return null;
    }

    void addEffect(BuildingEffect effect);
    void removeEffect(BuildingEffect effect);
    void applyEffect(Faction faction);
}
