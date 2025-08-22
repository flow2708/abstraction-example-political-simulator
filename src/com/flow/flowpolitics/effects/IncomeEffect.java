package com.flow.flowpolitics.effects;

import com.flow.flowpolitics.Faction;
import com.flow.flowpolitics.Resource;

public class IncomeEffect implements BuildingEffect{
    private final Resource resource;
    private final double amount;
    private int maxUses;
    public IncomeEffect(Resource resource, double amount, int maxUses) {
        this.resource = resource;
        this.amount = amount;
        this.maxUses = maxUses;
    }
    @Override
    public void applyEffect(Faction faction) {
        if (canUse(maxUses)) {
            faction.getStorage().addResource(resource, amount);
            maxUses--;
            applyEffect(faction);
        }
    }

    @Override
    public String getName() {
        return "Эффект дохода";
    }

    @Override
    public String getDescription() {
        return getName() + ": добавляет определенное количество определенного ресурса";
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }
}
