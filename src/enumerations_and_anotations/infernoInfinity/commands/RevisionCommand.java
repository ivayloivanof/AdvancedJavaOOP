package enumerations_and_anotations.infernoInfinity.commands;

import enumerations_and_anotations.infernoInfinity.core.contracts.Database;
import enumerations_and_anotations.infernoInfinity.weapons.WeaponImpl;
import enumerations_and_anotations.infernoInfinity.weapons.WeaponInfo;

public class RevisionCommand extends Command{
    public RevisionCommand(Database database, String[] params) {
        super(database, params);
    }

    @Override
    public String execute() {
        int revision = WeaponImpl.class.getAnnotation(WeaponInfo.class).revision();
        return String.format("Revision: %d", revision);
    }
}
