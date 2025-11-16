package mortalkombat.factory;

import mortalkombat.hero.*;

public class CharacterFactory {

    public Hero create(String type, String name) {
        return switch (type.toLowerCase()) {
            case "warrior" -> new Warrior(name);
            case "barbarian" -> new Barbarian(name);
            case "tank" -> new Tank(name);
            default -> throw new IllegalArgumentException("Unknown hero type: " + type);
        };
    }
}
