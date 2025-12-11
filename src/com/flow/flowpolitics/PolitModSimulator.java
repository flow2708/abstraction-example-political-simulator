package com.flow.flowpolitics;

import com.flow.flowpolitics.buildings.BarracksBuilding;
import com.flow.flowpolitics.buildings.Building;
import com.flow.flowpolitics.buildings.FarmBuilding;
import com.flow.flowpolitics.buildings.TownHallBuilding;
import com.flow.flowpolitics.effects.WarriorTrainingEffect;

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
        if (red.canBuildBuilding(redBarracks, red)) {
            red.addBuilding(redBarracks, red);
            System.out.println("Красные построили казармы!");
        } else {
            System.out.println("Красные не могут построить казармы: недостаточно ресурсов");
        }

        Building blueTownHall = new TownHallBuilding("townhall", Type.TOWNHALL, "Townhall", 1, "simple townhall");
        if (blue.canBuildBuilding(blueTownHall, blue)) {
            blue.addBuilding(blueTownHall, blue);
            System.out.println("Синие построили ратушу!");
        }

        Building blueFarm = new FarmBuilding("farm", Type.FARM, "Farm", 1, "simple farm");
        if (blue.canBuildBuilding(blueFarm, blue)) {
            blue.addBuilding(blueFarm, blue);
            System.out.println("Синие построили ферму!");
        }

        for (int i = 1; i <= 20; i++) {
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

            if (i == 5) {
                Building barracks = red.getBuildings().get(Type.BARRACKS);
                if (barracks != null) {
                    barracks.addEffect(new WarriorTrainingEffect(3, 2)); // 3 солдата, 2 использования
                    System.out.println("Добавлен эффект тренировки в казармы красных!");
                } else {
                    System.out.println("Казармы красных не построены, эффект не добавлен");
                }
            }
        }
    }
}