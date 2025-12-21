package com.flow.flowpolitics;

import com.flow.flowpolitics.enums.Resource;
import com.flow.flowpolitics.enums.Type;
import com.flow.flowpolitics.interfaces.BuildCondition;
import com.flow.flowpolitics.interfaces.Building;
import com.flow.flowpolitics.interfaces.Structure;

import java.util.*;

public abstract class PolitStructure implements Structure {
    private final String id = String.valueOf(this.hashCode());
    private final String name;
    private final Set<ChunkClaim> claims = new HashSet<>();
    private final Map<Type, Building> buildings = new HashMap<>(); // Здания по их ID
    private Storage storage = new Storage();
    War war;
    private double treasury; // Казна
    private int maxSoldiers; // Макс. размер армии
    private int currentSoldiers; // Текущий размер армии

    protected PolitStructure(String name, double treasury, int maxSoldiers, int currentSoldiers, War war) {
        this.name = name;
        this.treasury = treasury;
        this.maxSoldiers = maxSoldiers;
        this.currentSoldiers = currentSoldiers;
        this.war = war;
    }
    @Override
    public void addClaim(ChunkClaim claim) {
        this.claims.add(claim);
        System.out.println("[FACTION] " + name + " заявило права на чанк (" + claim.getX() + ", " + claim.getZ() + ")");
    }
    @Override
    public Boolean canBuildBuilding(Building building, Faction faction) {
        BuildCondition buildCondition = building.getBuildingCondition();
        if (buildCondition != null) {
            if (!buildCondition.check(faction)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public void addBuilding(Building building, Faction faction) {
        if (!canBuildBuilding(building, faction)) {
            System.out.println("Условия постройки не выполнены!");
            return;
        }
        buildings.put(building.getType(), building);
        building.applyEffect(faction);
        System.out.println("[FACTION] " + name + " построило: " + building.getType() + " (Ур. " + building.getLevel() + ")");
    }
    @Override
    public void onTick(Faction faction) {
        System.out.println("\n--- Тик государства " + name + " ---");
        for (Building building : buildings.values()) {
            building.onTick(faction); // Каждое здание влияет на государство
        }
    }
    @Override
    public void printStatus() {
        System.out.printf("Казна: %.2f монет | Армия: %d/%d%n", treasury, currentSoldiers, maxSoldiers);
    }
    @Override
    public String getName() { return this.name; }
    @Override
    public String getId() { return this.id; }
    @Override
    public Map<Type, Building> getBuildings() {
        return this.buildings;
    }
    @Override
    public Storage getStorage() { return this.storage; }
    @Override
    public void printStorage() {
        this.storage.printResources();
    }
    @Override
    public double getTreasury() { return this.treasury; }
    @Override
    public void setTreasury(double treasury) { this.treasury = treasury; }
    @Override
    public void addTreasury(double treasury) {
        this.treasury += treasury;
        this.storage.addResource(Resource.COIN, treasury);
    }
    @Override
    public int getMaxSoldiers() { return this.maxSoldiers; }
    @Override
    public void setMaxSoldiers(int maxSoldiers) { this.maxSoldiers = maxSoldiers; }
    @Override
    public void addMaxSoldiers(int maxSoldiers) { this.maxSoldiers += maxSoldiers; }
    @Override
    public int getCurrentSoldiers() { return this.currentSoldiers; }
    @Override
    public void setSoldiers(int currentSoldiers) { this.currentSoldiers = currentSoldiers; }
    @Override
    public void addSoldiers(int soldiers) { this.currentSoldiers += soldiers; }
}
