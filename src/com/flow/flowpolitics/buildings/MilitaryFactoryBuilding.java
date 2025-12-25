package com.flow.flowpolitics.buildings;

import com.flow.flowpolitics.Faction;
import com.flow.flowpolitics.enums.Resource;
import com.flow.flowpolitics.enums.Type;

public class MilitaryFactoryBuilding extends BuildingBase{
    public MilitaryFactoryBuilding(Type type, String name, int level, String description) {
        super(type, name, level, description);
    }

    @Override
    public void onTick(Faction faction) {
        if (level > 1) {
            int RiflesToAdd = level;
            int BulletsToAdd = level*2;

            if (level > 20) {
                RiflesToAdd = level/2;

                if (level > 40) {
                    BulletsToAdd = level;
                }
            }

            faction.getStorage().addResource(Resource.RIFLE, RiflesToAdd);
            faction.getStorage().addResource(Resource.RIFLEBULLET, BulletsToAdd);
        }
    }
}
