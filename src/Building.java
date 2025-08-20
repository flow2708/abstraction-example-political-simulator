import java.util.Map;

public interface Building {
    Type getType();
    int getLevel();
    Map<Resource, Integer> getUpgradeCost();
    void onTick(Faction faction);
    String getDescription();
    void applyEffect(Faction faction);
}
