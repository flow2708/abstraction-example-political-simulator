package com.flow.flowpolitics.buildings;

import com.flow.flowpolitics.Faction;
import com.flow.flowpolitics.Resource;
import com.flow.flowpolitics.Type;

public class BakeryBuilding extends BuildingBase{
    public BakeryBuilding(Type type, int level, String description) {
        super(type, level, description);
    }
    @Override
    public void onTick(Faction faction) {
        faction.getStorage().addResource(Resource.FOOD, level * 1.5);
    }
}
