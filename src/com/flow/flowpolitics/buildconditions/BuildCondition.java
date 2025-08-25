package com.flow.flowpolitics.buildconditions;

import com.flow.flowpolitics.Faction;

@FunctionalInterface
public interface BuildCondition {
    boolean check(Faction faction);
}
