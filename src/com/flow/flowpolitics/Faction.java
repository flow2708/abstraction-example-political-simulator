package com.flow.flowpolitics;

import com.flow.flowpolitics.war.War;

public class Faction extends PolitStructure{
    public Faction(String name, double treasury, int maxSoldiers, int currentSoldiers, War war) {
        super(name, treasury, maxSoldiers, currentSoldiers, war);

    }

    /*public void addClaim(ChunkClaim claim) {
        this.claims.add(claim);
        System.out.println("[FACTION] " + name + " заявило права на чанк (" + claim.getX() + ", " + claim.getZ() + ")");
    }
    public Boolean canBuildBuilding(Building building) {
        BuildCondition buildCondition = building.getBuildingCondition();
        if (buildCondition != null) {
            if (!buildCondition.check(this)) {
                return false;
            }
        }
        return true;
    }

    // Важный метод! Добавляет здание и сразу применяет его эффект.
    public void addBuilding(Building building) {
        if (!canBuildBuilding(building)) {
            System.out.println("Условия постройки не выполнены!");
            return;
        }
        buildings.put(building.getType(), building);
        building.applyEffect(this);
        System.out.println("[FACTION] " + name + " построило: " + building.getType() + " (Ур. " + building.getLevel() + ")");
    }

    // Этот метод вызывается глобально для всех государств раз в тик.
    public void onTick() {
        System.out.println("\n--- Тик государства " + name + " ---");
        for (Building building : buildings.values()) {
            building.onTick(this); // Каждое здание влияет на государство
        }
        printStatus();
    }
    public void printStatus() {
        System.out.printf("Казна: %.2f монет | Армия: %d/%d%n", treasury, currentSoldiers, maxSoldiers);
    }

    // Getters и Setters
    public String getName() { return name; }
    public Map<Type, Building> getBuildings() {
        return this.buildings;
    }
    public Storage getStorage() { return this.storage; }
    public void printStorage() {
        this.storage.printResources();
    }
    public double getTreasury() { return treasury; }
    public void setTreasury(double treasury) { this.treasury = treasury; }
    public void addTreasury(double treasury) {
        this.treasury += treasury;
        this.storage.addResource(Resource.COIN, treasury);
    }
    public int getMaxSoldiers() { return maxSoldiers; }
    public void setMaxSoldiers(int maxSoldiers) { this.maxSoldiers = maxSoldiers; }
    public void addMaxSoldiers(int maxSoldiers) { this.maxSoldiers += maxSoldiers; }
    public int getCurrentSoldiers() { return currentSoldiers; }
    public void setCurrentSoldiers(int currentSoldiers) { this.currentSoldiers = currentSoldiers; }
    public void addCurrentSoldiers(int soldiers) { this.currentSoldiers = currentSoldiers + soldiers; }
    public int getSoldiersQuantityPerTrain() { return this.soldiersQuantityPerTrain; }

     */
}