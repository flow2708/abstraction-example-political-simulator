package com.flow.flowpolitics.buildings;

import com.flow.flowpolitics.Resource;
import com.flow.flowpolitics.Type;
import com.flow.flowpolitics.effects.IncomeEffect;

import java.util.HashMap;
import java.util.Map;

public class FarmBuilding extends BuildingBase {

    public FarmBuilding(Type type, int level, String description) {
        super(type, level, description);
        this.effects.add(new IncomeEffect(Resource.FOOD, 5, -1));
    }
    @Override
    public Map<Resource, Integer> getUpgradeCost() {
        Map<Resource, Integer> cost = new HashMap<>();

        switch (level) {
            case 1:
                cost.put(Resource.COIN, 150);
                cost.put(Resource.WOOD, 100);
                break;
            case 2:
                cost.put(Resource.COIN, 300);
                cost.put(Resource.WOOD, 200);
                break;
            case 3:
                cost.put(Resource.COIN, 600);
                cost.put(Resource.WOOD, 400);
                cost.put(Resource.STONE, 200);
                break;
        }
        return cost;
    }
}
