package rpg_lab;

public interface Weapon{
    int getAttackPoints();

    int getDurabilityPoints();

    void attack(Dummy target);
}