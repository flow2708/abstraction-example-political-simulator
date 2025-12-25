package com.flow.flowpolitics.buildings;

import com.flow.flowpolitics.Faction;
import com.flow.flowpolitics.enums.Resource;
import com.flow.flowpolitics.enums.Type;

public class FoodFactory extends BuildingBase {
    public FoodFactory(Type type, String name, int level, String description) {
        super(type, name, level, description);
    }

    @Override
    public void onTick(Faction faction) {
        int quantity = level * 3;

        if (level >= 10) {
            quantity = level * 2;
        }

        faction.getStorage().addResource(Resource.FOOD, quantity);
    }
}
