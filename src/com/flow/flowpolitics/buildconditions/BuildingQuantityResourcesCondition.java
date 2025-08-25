package com.flow.flowpolitics.buildconditions;

import com.flow.flowpolitics.Faction;
import com.flow.flowpolitics.Resource;

import java.util.Map;

public class BuildingQuantityResourcesCondition implements BuildCondition {
    private Map<Resource, Double> requiredQuantity;
    public BuildingQuantityResourcesCondition(Map<Resource, Double> requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }
    @Override
    public boolean check(Faction faction) {
        // Проходим по всем ресурсам, которые требуются для постройки
        for (Map.Entry<Resource, Double> entry : requiredQuantity.entrySet()) {
            Resource requiredResource = entry.getKey();
            Double requiredAmount = entry.getValue();

            // Получаем текущее количество этого ресурса у фракции
            Double currentAmount = faction.getStorage().getAmount(requiredResource);

            // Если хотя бы одного ресурса недостаточно - возвращаем false
            if (currentAmount < requiredAmount) {
                System.out.println("Недостаточно " + requiredResource.getName() +
                        ". Нужно: " + requiredAmount + ", есть: " + currentAmount);
                return false;
            }
        }

        // Всех ресурсов достаточно
        return true;
    }
}
