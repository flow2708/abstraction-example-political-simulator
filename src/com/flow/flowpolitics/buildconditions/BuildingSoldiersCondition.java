package com.flow.flowpolitics.buildconditions;

import com.flow.flowpolitics.Faction;
import com.flow.flowpolitics.interfaces.BuildCondition;

import java.util.UUID;

public class BuildingSoldiersCondition implements BuildCondition {
    String id;
    private int requiredSoldiers;
    public BuildingSoldiersCondition(int requiredSoldiers) {
        this.id = "building_soldiers_condition_" + UUID.randomUUID().toString().substring(0, 8);
        this.requiredSoldiers = requiredSoldiers;
    }
    @Override
    public boolean check(Faction faction) {
        if (faction.getCurrentSoldiers() >= requiredSoldiers) {
            return true;
        }
        return false;
    }
}
