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
    Type getType();
    int getLevel();
    Map<Resource, Integer> getUpgradeCost();
    void onTick(Faction faction);
    default BuildCondition getBuildingCondition() {
        return null;
    }

    void addEffect(BuildingEffect effect);

    String getDescription();
    void applyEffect(Faction faction);
}
