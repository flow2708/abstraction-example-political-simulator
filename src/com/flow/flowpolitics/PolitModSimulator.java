package com.flow.flowpolitics;

import com.flow.flowpolitics.buildings.BarracksBuilding;
import com.flow.flowpolitics.buildings.Building;
import com.flow.flowpolitics.buildings.FarmBuilding;
import com.flow.flowpolitics.buildings.TownHallBuilding;

public class PolitModSimulator {
    public static void main(String[] args) throws InterruptedException {
        Faction red = new Faction("red1", 100.0, 20, 0);
        Faction blue = new Faction("blue1", 100.0, 20, 0);

        // Добавляем начальные ресурсы
        red.getStorage().addResource(Resource.STONE, 100.0);
        red.getStorage().addResource(Resource.COIN, 100.0);
        blue.getStorage().addResource(Resource.STONE, 100.0);
        blue.getStorage().addResource(Resource.COIN, 100.0);

        red.addClaim(new ChunkClaim("world1", 383, 552, red, true));
        blue.addClaim(new ChunkClaim("world1", 450, 326, blue, true));

        // Проверяем условия постройки
        Building redBarracks = new BarracksBuilding("barracks", Type.BARRACKS, "Barracks", 1, "simple barracks");
        red.addBuilding(redBarracks, red);

        Building blueTownHall = new TownHallBuilding("townhall", Type.TOWNHALL, "Townhall", 1, "simple townhall");
        blue.addBuilding(blueTownHall, blue);

        Building blueFarm = new FarmBuilding("farm", Type.FARM, "Farm", 1, "simple farm");
        blue.addBuilding(blueFarm, blue);

        for (int i = 1; i <= 200; i++) {
            Thread.sleep(1000);
            System.out.println("\n>>>> ТИК #" + i);

            red.onTick(red);
            System.out.println("=== КРАСНЫЕ ===");
            red.printStatus();
            red.printStorage();

            blue.onTick(blue);
            System.out.println("=== СИНИЕ ===");
            blue.printStatus();
            blue.printStorage();
        }
    }
}