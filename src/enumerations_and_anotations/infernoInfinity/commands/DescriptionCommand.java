package enumerations_and_anotations.infernoInfinity.commands;

import enumerations_and_anotations.infernoInfinity.core.contracts.Database;
import enumerations_and_anotations.infernoInfinity.weapons.WeaponImpl;
import enumerations_and_anotations.infernoInfinity.weapons.WeaponInfo;

public class DescriptionCommand extends Command {
    public DescriptionCommand(Database database, String[] params) {
        super(database, params);
    }

    @Override
    public String execute() {
        String description = WeaponImpl.class.getAnnotation(WeaponInfo.class).description();
        return String.format("Class description: %s", description);
    }
}
