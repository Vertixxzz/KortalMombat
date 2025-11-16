package mortalkombat.hero;

public class HeroBuilder {

    private String name;
    private int health;
    private int attack;
    private int defense;

    public HeroBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public HeroBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    public HeroBuilder setAttack(int attack) {
        this.attack = attack;
        return this;
    }

    public HeroBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    public Hero build() {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Имя героя не задано");
        }

        if (health <= 0) {
            throw new IllegalStateException("Здоровье должно быть больше 0");
        }

        return new Hero(name, health, attack, defense) {

        };
    }
}
