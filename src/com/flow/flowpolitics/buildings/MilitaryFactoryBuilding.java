package com.flow.flowpolitics.buildings;

import com.flow.flowpolitics.Faction;
import com.flow.flowpolitics.Resource;
import com.flow.flowpolitics.Type;

public class MilitaryFactoryBuilding extends BuildingBase{
    public MilitaryFactoryBuilding(Type type, int level, String description) {
        super(type, level, description);
    }
    @Override
    public void onTick(Faction faction) {
        faction.getStorage().addResource(Resource.RIFLE, level * 1.5);
        faction.getStorage().addResource(Resource.RIFLEBULLET, level * 1.5);
    }
}
