import java.util.HashMap;
import java.util.Map;

public class TownHallBuilding extends BuildingBase{
    public TownHallBuilding(Type type, int level, String description) {
        super(type, level, description);
    }
    @Override
    public void onTick(Faction faction) {
            faction.addTreasury(10.0 * this.level);
    }
    @Override
    public Map<String, Integer> getUpgradeCost() {
        Map<String, Integer> cost = new HashMap<>();

        switch (level) {
            case 1:
                cost.put("coin", 100);
                cost.put("wood", 64);
                break;
            case 2:
                cost.put("coin", 200);
                cost.put("wood", 128);
                cost.put("stone", 64);
                break;
            case 3:
                cost.put("coin", 400);
                cost.put("wood", 256);
                cost.put("stone", 64);
                break;
        }
        return cost;
    }
}
