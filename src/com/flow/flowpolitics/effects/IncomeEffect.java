package com.flow.flowpolitics.effects;

import com.flow.flowpolitics.Faction;
import com.flow.flowpolitics.Resource;

public class IncomeEffect implements BuildingEffect{
    private final Resource resource;
    private final double amount;
    public IncomeEffect(Resource resource, double amount) {
        this.resource = resource;
        this.amount = amount;
    }
    @Override
    public void applyEffect(Faction faction) {
        faction.getStorage().addResource(resource, amount);
    }

    @Override
    public String getName() {
        return "Эффект дохода";
    }

    @Override
    public String getDescription() {
        return getName() + ": добавляет определенное количество определенного ресурса";
    }
}
