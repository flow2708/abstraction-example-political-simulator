package com.flow.flowpolitics.buildconditions;

import com.flow.flowpolitics.Faction;
import com.flow.flowpolitics.enums.Type;
import com.flow.flowpolitics.interfaces.BuildCondition;
import com.flow.flowpolitics.interfaces.Building;

import java.util.UUID;

public class BuildingLevelCondition implements BuildCondition {
    private String id;
    private Type requiredBuilding;
    private int requiredLevel;
    public BuildingLevelCondition(Type requiredBuilding, int requiredLevel) {
        this.id = "building_level_condition_" + UUID.randomUUID().toString().substring(0, 8);
        this.requiredBuilding = requiredBuilding;
        this.requiredLevel = requiredLevel;
    }

    @Override
    public boolean check(Faction faction) {
        Building building = faction.getBuildings().get(requiredBuilding);
        return building != null && building.getLevel() >= requiredLevel;
    }
}
