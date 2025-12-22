package com.flow.flowpolitics.buildconditions;

import com.flow.flowpolitics.Faction;
import com.flow.flowpolitics.enums.Resource;
import com.flow.flowpolitics.interfaces.BuildCondition;

import java.util.Map;
import java.util.UUID;

public class BuildingQuantityResourcesCondition implements BuildCondition {
    String id;
    private Map<Resource, Double> requiredQuantity;
    public BuildingQuantityResourcesCondition(Map<Resource, Double> requiredQuantity) {
        this.id = "building_quantity_resources_condition_" + UUID.randomUUID().toString().substring(0, 8);
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
