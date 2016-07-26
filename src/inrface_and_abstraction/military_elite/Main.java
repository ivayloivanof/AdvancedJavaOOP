package inrface_and_abstraction.military_elite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ivanof on 7/18/16.
 */
public class Main {

    public static LinkedHashMap<String, Soldier> soldiers = new LinkedHashMap<>();
    public static LinkedHashMap<String, Private> privatesAll = new LinkedHashMap<>();

    public static void main(String[] args) {


        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String line = br.readLine();
            while (!Objects.equals(line, "End")) {
                String[] data = line.split("\\s+");
                if (Objects.equals(data[0], "Private")) {
                    soldiers.put(data[2], new Private(Integer.parseInt(data[1]), data[2], data[3], Double.parseDouble(data[4])));
                    privatesAll.put(data[1], new Private(Integer.parseInt(data[1]), data[2], data[3], Double.parseDouble(data[4])));
                }

                if (Objects.equals(data[0], "LeutenantGeneral")) {
                    soldiers.put(data[2], new LeutenantGeneral(Integer.parseInt(data[1]), data[2], data[3], Double.parseDouble(data[4]), args));
                }

                if (Objects.equals(data[0], "Commando")) {
                    soldiers.put(data[2], new Commando(Integer.parseInt(data[1]), data[2], data[3], Double.parseDouble(data[4]), data[5]));
                }

                if (Objects.equals(data[0], "Engineer")) {
                    soldiers.put(data[2], new Engineer(Integer.parseInt(data[1]), data[2], data[3], Double.parseDouble(data[4]), data[5]));
                }

                line = br.readLine();
            }

            soldiers.entrySet().stream()
                    .forEach(stringSoldier -> {
                        System.out.print(stringSoldier.toString());
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class SpecialisedSoldier extends Private {

    private String corps;

    protected SpecialisedSoldier(int id, String firstName, String lastName, Double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    public String getCorps() {
        return this.corps;
    }

    private void setCorps(String corps) {
        this.corps = corps;
    }
}

class Soldier implements ISoldier {

    private int id;
    private String firstName;
    private String lastName;

    protected Soldier(int id, String firstName, String lastName) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    @Override
    public int getId() {
        return this.id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

class Private extends Soldier implements IPrivate {

    private Double salary;

    public Private(int id, String firstName, String lastName, Double salary) {
        super(id, firstName, lastName);
        this.setSalary(salary);
    }

    @Override
    public Double getSalary() {
        return this.salary;
    }

    private void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(String.format("Name: %s %s Id: %d Salary: %.2f%n",
                        this.getFirstName(),
                        this.getLastName(),
                        this.getId(),
                        this.getSalary()));
        return stringBuilder.toString();
    }
}

class Spy extends Soldier implements ISpy {

    private String codeNumber;

    public Spy(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.setCodeNumber(codeNumber);
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    private void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(String.format("Name: %s %s Id: %d%n",
                        this.getFirstName(),
                        this.getLastName(),
                        this.getId()))
                .append(String.format("Code Number: %s%n", this.getCodeNumber()));
        return stringBuilder.toString();
    }
}

class LeutenantGeneral extends Private implements ILeutenantGeneral {

    private LinkedList<Private> privates;

    public LeutenantGeneral(int id, String firstName, String lastName, Double salary, String... privatesId) {
        super(id, firstName, lastName, salary);
        this.privates = new LinkedList<>();
        for (String privateId : privatesId) {
            this.getPrivates().add(Main.privatesAll.get(privateId));
        }
    }

    private void setPrivates(Private privates) {
        this.getPrivates().add(privates);
    }

    @Override
    public LinkedList<Private> getPrivates() {
        return this.privates;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(String.format("Name: %s %s Id: %d Salary: %.2f%n",
                        this.getFirstName(),
                        this.getLastName(),
                        this.getId(),
                        this.getSalary()))
                .append(String.format("Privates:%n"));
        for (Private aPrivate : this.getPrivates()) {
            stringBuilder.append(String.format("    %s", aPrivate.toString()));
        }
        return stringBuilder.toString();
    }
}

class Engineer extends SpecialisedSoldier implements IEngineer {

    private Set<Repair> repairs;

    public Engineer(int id, String firstName, String lastName, Double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new HashSet<>();
    }

    @Override
    public Set<Repair> getRepairs() {
        return this.repairs;
    }

    private void setRepairs(Repair repair) {
        this.getRepairs().add(repair);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(String.format("Name: %s %s Id: %d Salary: %.2f%n",
                        this.getFirstName(),
                        this.getLastName(),
                        this.getId(),
                        this.getSalary()))
                .append(String.format("Corps: %s%n", this.getCorps()))
                .append(String.format("Repairs:%n"));
        for (Repair repair : this.getRepairs()) {
            stringBuilder.append(String.format("%s", repair.toString()));
        }
        return stringBuilder.toString();
    }
}

class Commando extends SpecialisedSoldier implements ICommando {

    private Set<Mission> missions;

    public Commando(int id, String firstName, String lastName, Double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new HashSet<>();
    }

    @Override
    public Set<Mission> getMissions() {
        return this.missions;
    }

    private void setMissions(Mission mission) {
        this.getMissions().add(mission);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(String.format("Name: %s %s Id: %d Salary: %.2f%n",
                        this.getFirstName(),
                        this.getLastName(),
                        this.getId(),
                        this.getSalary()))
                .append(String.format("Corps: %s%n", this.getCorps()))
                .append(String.format("Missions:%n"));
        for (Mission mission : this.getMissions()) {
            stringBuilder.append(String.format("    %s", mission.toString()));
        }

        return stringBuilder.toString();
    }
}

class Repair {

    private int partTime;
    private int hoursWorked;

    public Repair(int partTime, int hoursWorked) {
        this.setPartTime(partTime);
        this.setHoursWorked(hoursWorked);
    }

    public int getPartTime() {
        return this.partTime;
    }

    private void setPartTime(int partTime) {
        this.partTime = partTime;
    }

    public int getHoursWorked() {
        return this.hoursWorked;
    }

    private void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(
                String.format("Part Name: %s Hours Worked: %s%n",
                        this.getPartTime(),
                        this.getHoursWorked()));
        return stringBuilder.toString();
    }
}

class Mission {

    private String codeName;
    private String state;

    public Mission(String codeName) {
        this.setCodeName(codeName);
        this.setState("inProgress");
    }

    public String getCodeName() {
        return this.codeName;
    }

    private void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getState() {
        return this.state;
    }

    private void setState(String state) {
        this.state = state;
    }

    public void CompleteMission() {
        this.setState("Finished");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(
                String.format("Code Name: %s State: %s%n",
                        this.getCodeName(),
                        this.getState()));
        return stringBuilder.toString();
    }
}

interface ISoldier {

    int getId();

    String getFirstName();

    String getLastName();
}

interface IPrivate {

    Double getSalary();
}

interface ILeutenantGeneral {

    LinkedList<Private> getPrivates();
}

interface IEngineer {

    Set<Repair> getRepairs();
}

interface ICommando {

    Set<Mission> getMissions();
}

interface ISpy {

    String getCodeNumber();
}