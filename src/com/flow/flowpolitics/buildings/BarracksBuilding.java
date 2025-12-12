package com.flow.flowpolitics.buildings;

import com.flow.flowpolitics.Faction;
import com.flow.flowpolitics.Resource;
import com.flow.flowpolitics.Type;
import com.flow.flowpolitics.buildconditions.BuildCondition;
import com.flow.flowpolitics.buildconditions.BuildingQuantityResourcesCondition;

import java.util.HashMap;
import java.util.Map;

public class BarracksBuilding extends BuildingBase {
    private int soldiersQuantityPerTick = level;

    public BarracksBuilding(String id, Type type, String name, int level, String description) {
        super(id, type, name, level, description);
    }
    @Override
    public void onTick(Faction faction) {
        int quantityPerTick = soldiersQuantityPerTick;
        if (faction.getCurrentSoldiers() + quantityPerTick <= faction.getMaxSoldiers()) {
            faction.addSoldiers(quantityPerTick);
        } else {
            System.out.println("Достигнуто максимальное количество солдат!");
        }
    }
    @Override
    public Map<Resource, Integer> getUpgradeCost() {
        Map<Resource, Integer> cost = new HashMap<>();

        switch (level) {
            case 1:
                cost.put(Resource.COIN, 200);
                cost.put(Resource.STONE, 100);
                break;
            case 2:
                cost.put(Resource.COIN, 400);
                cost.put(Resource.STONE, 200);
                break;
            case 3:
                cost.put(Resource.COIN, 800);
                cost.put(Resource.STONE, 400);
                break;
        }
        return cost;
    }
    @Override
    public void applyEffect(Faction faction) {
        faction.addMaxSoldiers(50 * level);
    }
    @Override
    public BuildCondition getBuildingCondition() {
        Map<Resource, Double> requiredQuantity = new HashMap<>();
        requiredQuantity.put(Resource.STONE, 40.0);
        requiredQuantity.put(Resource.COIN, 20.0);

        return new BuildingQuantityResourcesCondition(requiredQuantity);
    }
}
