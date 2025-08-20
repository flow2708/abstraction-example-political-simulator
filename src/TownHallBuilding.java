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
    public Map<Resource, Integer> getUpgradeCost() {
        Map<Resource, Integer> cost = new HashMap<>();

        switch (level) {
            case 1:
                cost.put(Resource.COIN, 100);
                cost.put(Resource.WOOD, 64);
                break;
            case 2:
                cost.put(Resource.COIN, 200);
                cost.put(Resource.WOOD, 128);
                cost.put(Resource.STONE, 64);
                break;
            case 3:
                cost.put(Resource.COIN, 400);
                cost.put(Resource.WOOD, 256);
                cost.put(Resource.STONE, 64);
                break;
        }
        return cost;
    }
}
