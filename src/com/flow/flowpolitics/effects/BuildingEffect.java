package com.flow.flowpolitics.effects;

import com.flow.flowpolitics.Faction;

public interface BuildingEffect {
    void applyEffect(Faction faction);
    default boolean canUse(int maxUses) {
        if (maxUses > 0) {
            return true;
        }
        if (maxUses < 0) {
            return true;
        }
        return false;
    }
    String getName();
    String getDescription();
    int getMaxUses();
}
