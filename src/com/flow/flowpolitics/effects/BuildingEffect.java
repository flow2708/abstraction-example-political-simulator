package com.flow.flowpolitics.effects;

import com.flow.flowpolitics.Faction;

public interface BuildingEffect {
    void applyEffect(Faction faction);
    String getName();
    String getDescription();
}
