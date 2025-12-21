package com.flow.flowpolitics.buildings;

import com.flow.flowpolitics.Faction;
import com.flow.flowpolitics.enums.Resource;
import com.flow.flowpolitics.enums.Type;

public class BakeryBuilding extends BuildingBase {

    public BakeryBuilding(String id, Type type, String name, int level, String description) {
        super(id, type, name, level, description);
    }

    @Override
    public void onTick(Faction faction) {
        faction.getStorage().addResource(Resource.FOOD, level * 1.5);
    }
}
