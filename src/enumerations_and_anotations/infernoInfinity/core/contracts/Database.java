package enumerations_and_anotations.infernoInfinity.core.contracts;

import enumerations_and_anotations.infernoInfinity.weapons.contracts.Weapon;

public interface Database {
    void addWeapon(Weapon weapon);
    Weapon getWeapon(String name);
}
