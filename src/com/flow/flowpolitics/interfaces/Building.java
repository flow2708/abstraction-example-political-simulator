package com.flow.flowpolitics.interfaces;

import com.flow.flowpolitics.Faction;
import com.flow.flowpolitics.Resource;
import com.flow.flowpolitics.Type;

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
    /**
     * Вызов метода происходит при постройке (addBuilding())
     * @param faction
     */
    void applyEffect(Faction faction);
}
