package com.flow.flowpolitics.buildconditions;

import com.flow.flowpolitics.Faction;

public class BuildingSoldiersCondition implements BuildCondition{
    private int requiredSoldiers;
    public BuildingSoldiersCondition(int requiredSoldiers) {
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
