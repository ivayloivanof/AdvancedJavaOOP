package enumerations_and_anotations.infernoInfinity.weapons.contracts;

import enumerations_and_anotations.infernoInfinity.gems.contracts.Gem;

public interface Weapon extends Comparable<Weapon>{
    void addGem(Gem gem, int index);
    void remove(int index);
    String getName();
    double calculateLevel();
}
