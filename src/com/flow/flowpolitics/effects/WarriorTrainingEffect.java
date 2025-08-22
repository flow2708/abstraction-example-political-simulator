package com.flow.flowpolitics.effects;

import com.flow.flowpolitics.Faction;

public class WarriorTrainingEffect implements BuildingEffect{
    private final int maxUses;
    private final int trainDuration;
    private final int warriorQuantityPerTrain;
    public WarriorTrainingEffect(int maxUses, int trainDuration, int warriorQuantityPerTrain) {
        this.maxUses = maxUses;
        this.trainDuration = trainDuration;
        this.warriorQuantityPerTrain = warriorQuantityPerTrain;
    }
    @Override
    public void applyEffect(Faction faction) {

    }

    @Override
    public String getName() {
        return "Эффект тренировки";
    }

    @Override
    public String getDescription() {
        return getName() + ": тренирует войско и добавляет в армию";
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }
}
