package enumerations_and_anotations.infernoInfinity.commands;

import enumerations_and_anotations.infernoInfinity.core.contracts.Database;
import enumerations_and_anotations.infernoInfinity.enums.GemType;
import enumerations_and_anotations.infernoInfinity.gems.Amethyst;
import enumerations_and_anotations.infernoInfinity.gems.Emerald;
import enumerations_and_anotations.infernoInfinity.gems.Ruby;
import enumerations_and_anotations.infernoInfinity.gems.contracts.Gem;
import enumerations_and_anotations.infernoInfinity.weapons.contracts.Weapon;

public class AddCommand extends Command{
    public AddCommand(Database database, String[] params) {
        super(database, params);
    }

    @Override
    public String execute() {
        String[] input = this.getParams();
        String name = input[1];
        Weapon weapon = this.getDatabase().getWeapon(name);
        if (weapon == null){
            return null;
        }

        int index = Integer.valueOf(input[2]);
        GemType gemType = GemType.valueOf(input[3]);
        Gem gem;
        switch (gemType){
            case RUBY:
                gem = new Ruby();
                break;

            case EMERALD:
                gem = new Emerald();
                break;

            case AMETHYST:
                gem = new Amethyst();
                break;

            default:
                return null;
        }
        weapon.addGem(gem, index);
        return null;
    }
}
