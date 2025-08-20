import java.util.HashMap;
import java.util.Map;

public class BarracksBuilding extends BuildingBase {

    public BarracksBuilding(Type type, int level, String description) {
        super(type, level, description);
    }
    @Override
    public Map<String, Integer> getUpgradeCost() {
        Map<String, Integer> cost = new HashMap<>();

        switch (level) {
            case 1:
                cost.put("coin", 200);
                cost.put("stone", 100);
                break;
            case 2:
                cost.put("coin", 400);
                cost.put("stone", 200);
                break;
            case 3:
                cost.put("coin", 800);
                cost.put("stone", 400);
                break;
        }
        return cost;
    }
    @Override
    public void applyEffect(Faction faction) {
        int barracksQuantity = 0;

        for (Building building : faction.getBuildings().values()) {
            if (building instanceof BarracksBuilding) {
                barracksQuantity++;
            }
        }
        if (barracksQuantity == 0) {
            faction.setMaxSoldiers(20 + (5 * level));
        } else if (barracksQuantity > 0 && barracksQuantity <= 5) {
            faction.addMaxSoldiers(5 * level);
        } else if (barracksQuantity > 5 || barracksQuantity <= 10) {
            faction.addMaxSoldiers(2 * level);
        }
    }
}
