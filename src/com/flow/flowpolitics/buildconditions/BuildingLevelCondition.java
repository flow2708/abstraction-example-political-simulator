package com.flow.flowpolitics.buildconditions;

import com.flow.flowpolitics.Faction;
import com.flow.flowpolitics.enums.Type;
import com.flow.flowpolitics.interfaces.BuildCondition;
import com.flow.flowpolitics.interfaces.Building;

public class BuildingLevelCondition implements BuildCondition {
    private Type requiredBuilding;
    private int requiredLevel;
    public BuildingLevelCondition(Type requiredBuilding, int requiredLevel) {
        this.requiredBuilding = requiredBuilding;
        this.requiredLevel = requiredLevel;
    }

    @Override
    public boolean check(Faction faction) {
        Building building = faction.getBuildings().get(requiredBuilding);
        return building != null && building.getLevel() >= requiredLevel;
    }
}
