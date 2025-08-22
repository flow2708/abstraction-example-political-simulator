package com.flow.flowpolitics;

public class ChunkClaim {
    private final String worldName;
    private final int x;
    private final int z;
    private final Faction owner;
    private boolean isCapital;
    public ChunkClaim(String worldName, int x, int z, Faction owner, boolean isCapital) {
        this.worldName = worldName;
        this.x = x;
        this.z = z;
        this.owner = owner;
        this.isCapital = isCapital;
    }
    public String getWorldName() {
        return this.worldName;
    }
    public int getX() {
        return this.x;
    }
    public int getZ() {
        return this.z;
    }
    public Faction getOwner() {
        return this.owner;
    }

    public boolean isCapital() {
        return isCapital;
    }
    public void setCapital(boolean isCapital) {
        this.isCapital = isCapital;
    }
}
