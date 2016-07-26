package enumerations_and_anotations.infernoInfinity.commands;

import enumerations_and_anotations.infernoInfinity.core.contracts.Database;
import enumerations_and_anotations.infernoInfinity.enums.WeaponType;
import enumerations_and_anotations.infernoInfinity.weapons.Axe;
import enumerations_and_anotations.infernoInfinity.weapons.Knife;
import enumerations_and_anotations.infernoInfinity.weapons.Sword;
import enumerations_and_anotations.infernoInfinity.weapons.contracts.Weapon;

public class CreateCommand extends Command{

    public CreateCommand(Database database, String[] params) {
        super(database, params);
    }

    @Override
    public String execute() {
        String[] input = this.getParams();
        WeaponType type = WeaponType.valueOf(input[1]);
        String name = input[2];
        Weapon weapon;
        switch (type){
            case AXE:
                weapon = new Axe(name);
                break;

            case SWORD:
                weapon = new Sword(name);
                break;

            case KNIFE:
                weapon = new Knife(name);
                break;

            default:
                return null;
        }

        this.getDatabase().addWeapon(weapon);
        return null;
    }
}
