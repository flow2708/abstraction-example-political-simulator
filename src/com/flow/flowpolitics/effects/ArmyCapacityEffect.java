package com.flow.flowpolitics.effects;

import com.flow.flowpolitics.Faction;

public class ArmyCapacityEffect implements BuildingEffect {
    private final int capacityIncrease;
    private int maxUses;
    public ArmyCapacityEffect(int capacityIncrease, int maxUses) {
        this.capacityIncrease = capacityIncrease;
        this.maxUses = maxUses;
    }

    @Override
    public void applyEffect(Faction faction) {
        if (canUse(maxUses)) {
            faction.addMaxSoldiers(capacityIncrease);
            maxUses--;
            applyEffect(faction);
        }
    }

    @Override
    public String getName() {
        return "Эффект вместимости армии";
    }

    @Override
    public String getDescription() {
        return getName() + ": позволяет увеличить максимальную вместимость армии";
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }
}
