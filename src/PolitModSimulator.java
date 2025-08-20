public class PolitModSimulator {
    public static void main(String[] args) {
        Faction red = new Faction("red1", "red");
        Faction blue = new Faction("blue1", "blue");

        red.addClaim(new ChunkClaim("world1", 383, 552, red, true));
        blue.addClaim(new ChunkClaim("world1", 450, 326, blue, true));

        red.addBuilding(new BarracksBuilding(Type.BARRACKS, 1, "simple"));
        blue.addBuilding(new TownHallBuilding(Type.TOWNHALL, 1, "simple"));

        for (int i = 1; i <= 100; i++) {
            System.out.println("\n>>>> ТИК #" + i);
            red.onTick();
            blue.onTick();
        }
    }
}
