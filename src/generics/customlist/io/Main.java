package generics.customlist.io;

import generics.customlist.command_interpreter.CommandInterpreter;
import generics.customlist.model.contracts.Interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Interpreter interpreter = new CommandInterpreter();

        String command = br.readLine();

        while (!command.equals("END")) {
            String result = interpreter.processCommand(command);

            if (result != null) {
                System.out.println(result);
            }

            command = br.readLine();
        }

        br.close();
    }
}
