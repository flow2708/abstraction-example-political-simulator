package com.flow.flowpolitics;

import com.flow.flowpolitics.buildings.Building;

import java.util.Map;

public interface Structure {
    void addClaim(ChunkClaim claim);
    Boolean canBuildBuilding(Building building, Faction faction);
    void addBuilding(Building building, Faction faction);
    void onTick(Faction faction);
    void printStatus();
    String getName();
    String getId();

    Map<Type, Building> getBuildings();
    Storage getStorage();
    void printStorage();
    double getTreasury();
    void setTreasury(double treasury);
    void addTreasury(double treasury);
    int getMaxSoldiers();
    void setMaxSoldiers(int maxSoldiers);
    void addMaxSoldiers(int maxSoldiers);
    int getCurrentSoldiers();
    void setSoldiers(int currentSoldiers);
    void addSoldiers(int soldiers);
}
