package com.flow.flowpolitics.interfaces;

import com.flow.flowpolitics.Faction;

@FunctionalInterface
public interface BuildCondition {
    boolean check(Faction faction);
}
