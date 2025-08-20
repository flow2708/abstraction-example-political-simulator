import java.util.*;

public class Faction {
    private final String id;
    private final String name;
    private final Set<ChunkClaim> claims = new HashSet<>();
    private final Map<Type, Building> buildings = new HashMap<>(); // Здания по их ID
    private Storage storage = new Storage();
    private double treasury; // Казна
    private int maxSoldiers = 0; // Макс. размер армии
    private int currentSoldiers; // Текущий размер армии

    public Faction(String id, String name) {
        this.id = id;
        this.name = name;
        this.treasury = 100.0; // Стартовый капитал
        this.maxSoldiers = 20;
    }

    public void addClaim(ChunkClaim claim) {
        this.claims.add(claim);
        System.out.println("[FACTION] " + name + " заявило права на чанк (" + claim.getX() + ", " + claim.getZ() + ")");
    }

    // Важный метод! Добавляет здание и сразу применяет его эффект.
    public void addBuilding(Building building) {
        buildings.put(building.getType(), building);
        building.applyEffect(this);
        System.out.println("[FACTION] " + name + " построило: " + building.getType() + " (Ур. " + building.getLevel() + ")");
    }

    // Этот метод вызывается глобально для всех государств раз в тик.
    public void onTick() {
        System.out.println("\n--- Тик государства " + name + " ---");
        for (Building building : buildings.values()) {
            building.onTick(this); // Каждое здание влияет на государство
        }
        printStatus();
    }

    public void printStatus() {
        System.out.printf("Казна: %.2f монет | Армия: %d/%d%n", treasury, currentSoldiers, maxSoldiers);
    }

    // Getters и Setters
    public String getName() { return name; }
    public Map<Type, Building> getBuildings() {
        return this.buildings;
    }
    public Storage getStorage() { return this.storage; }
    public void printStorage() {
        this.storage.printResources();
    }
    public double getTreasury() { return treasury; }
    public void setTreasury(double treasury) { this.treasury = treasury; }
    public void addTreasury(double treasury) { this.treasury += treasury; }
    public int getMaxSoldiers() { return maxSoldiers; }
    public void setMaxSoldiers(int maxSoldiers) { this.maxSoldiers = maxSoldiers; }
    public void addMaxSoldiers(int maxSoldiers) { this.maxSoldiers += maxSoldiers; }
    public int getCurrentSoldiers() { return currentSoldiers; }
    public void setCurrentSoldiers(int currentSoldiers) { this.currentSoldiers = currentSoldiers; }
}