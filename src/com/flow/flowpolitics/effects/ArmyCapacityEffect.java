package com.flow.flowpolitics.effects;

import com.flow.flowpolitics.Faction;

public class ArmyCapacityEffect implements BuildingEffect {
    private final int capacityIncrease;
    public ArmyCapacityEffect(int capacityIncrease) {
        this.capacityIncrease = capacityIncrease;
    }

    @Override
    public void applyEffect(Faction faction) {
        faction.addMaxSoldiers(capacityIncrease);
    }

    @Override
    public String getName() {
        return "Эффект вместимости армии";
    }

    @Override
    public String getDescription() {
        return getName() + ": позволяет увеличить максимальную вместимость армии";
    }
}
