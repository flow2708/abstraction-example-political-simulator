package com.flow.flowpolitics.effects;

import com.flow.flowpolitics.Faction;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class WarriorTrainingEffect implements BuildingEffect{
    private final int trainDuration;
    private int maxUses;
    public WarriorTrainingEffect(int trainDuration, int maxUses) {
        this.trainDuration = trainDuration;
        this.maxUses = maxUses;
    }
    @Override
    public void applyEffect(Faction faction) {
        if (faction.getMaxSoldiers() - faction.getCurrentSoldiers() > faction.getSoldiersQuantityPerTrain()) {
            ExecutorService executor = Executors.newSingleThreadExecutor();

            executor.submit(() -> {
                applyEffectSync(faction);
            });

            // Завершаем executor когда больше не нужен
            executor.shutdown();
        }
    }
    public void applyEffectSync(Faction faction) {
            try {
                // Ожидание 3 секунды
                Thread.sleep(trainDuration);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            faction.addCurrentSoldiers(faction.getSoldiersQuantityPerTrain());
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
        return 0;
    }
}
