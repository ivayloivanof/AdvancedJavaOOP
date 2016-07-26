package generics.customlist.command_interpreter;

import generics.customlist.model.contracts.CustomList;
import generics.customlist.model.contracts.Interpreter;
import generics.customlist.model.impl.CustomListImpl;
import generics.customlist.sortrer.Sorter;

public class CommandInterpreter implements Interpreter {

    private CustomList<String> list;

    public CommandInterpreter() {
        this.list = new CustomListImpl<>();
    }

    @Override
    public String processCommand(String command) {
        if (command.startsWith("Add")) {
            list.add(command.split("\\s+")[1]);
        } else if (command.startsWith("Remove")) {
            list.remove(Integer.valueOf(command.split("\\s+")[1]));
        } else if (command.startsWith("Contains")) {
            return String.valueOf(list.contains(command.split("\\s+")[1]));
        } else if (command.startsWith("Swap")) {
            String indexInfo[] = command.split("\\s+");
            int index1 = Integer.parseInt(indexInfo[1]);
            int index2 = Integer.parseInt(indexInfo[2]);
            list.swap(index1, index2);
        } else if (command.startsWith("Greater")) {
            return String.valueOf(list.countGreaterThat(command.split("\\s+")[1]));
        } else if (command.startsWith("Max")) {
            return String.valueOf(list.getMax());
        } else if (command.startsWith("Min")) {
            return String.valueOf(list.getMin());
        } else if (command.startsWith("Print")) {
            return list.toString();
        } else if (command.startsWith("Sort")) {
            Sorter.sortList(list);
        }

        return null;
    }

}
