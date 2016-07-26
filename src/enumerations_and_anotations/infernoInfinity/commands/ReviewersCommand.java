package enumerations_and_anotations.infernoInfinity.commands;

import enumerations_and_anotations.infernoInfinity.core.contracts.Database;
import enumerations_and_anotations.infernoInfinity.weapons.WeaponImpl;
import enumerations_and_anotations.infernoInfinity.weapons.WeaponInfo;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReviewersCommand extends Command{
    public ReviewersCommand(Database database, String[] params) {
        super(database, params);
    }

    @Override
    public String execute() {
        String[] reviewers = WeaponImpl.class.getAnnotation(WeaponInfo.class).reviewers();
        return String.format("Reviewers: %s", Arrays.stream(reviewers).collect(Collectors.joining(", ")));
    }
}
