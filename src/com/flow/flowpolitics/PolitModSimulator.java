package com.flow.flowpolitics;

import com.flow.flowpolitics.buildings.BarracksBuilding;
import com.flow.flowpolitics.buildings.FarmBuilding;
import com.flow.flowpolitics.buildings.TownHallBuilding;

public class PolitModSimulator {
    public static void main(String[] args) throws InterruptedException {
        Faction red = new Faction("red1", "red");
        Faction blue = new Faction("blue1", "blue");

        Storage redStorage = red.getStorage();
        Storage blueStorage = blue.getStorage();

        red.addClaim(new ChunkClaim("world1", 383, 552, red, true));
        blue.addClaim(new ChunkClaim("world1", 450, 326, blue, true));

        red.addBuilding(new BarracksBuilding(Type.BARRACKS, 1, "simple barracks"));
        blue.addBuilding(new TownHallBuilding(Type.TOWNHALL, 1, "simple townhall"));
        blue.addBuilding(new FarmBuilding(Type.FARM, 1, "simple farm"));


        for (int i = 1; i <= 100; i++) {
            Thread.sleep(1000);
            System.out.println("\n>>>> ТИК #" + i);
            red.onTick();
            blue.onTick();
            red.printStorage();
            blue.printStorage();
        }
    }
}
