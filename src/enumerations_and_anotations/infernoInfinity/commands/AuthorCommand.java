package enumerations_and_anotations.infernoInfinity.commands;

import enumerations_and_anotations.infernoInfinity.core.contracts.Database;
import enumerations_and_anotations.infernoInfinity.weapons.WeaponImpl;
import enumerations_and_anotations.infernoInfinity.weapons.WeaponInfo;

public class AuthorCommand extends Command{
    public AuthorCommand(Database database, String[] params) {
        super(database, params);
    }

    @Override
    public String execute() {
        String author = WeaponImpl.class.getAnnotation(WeaponInfo.class).author();
        return String.format("Author: %s", author);
    }
}
