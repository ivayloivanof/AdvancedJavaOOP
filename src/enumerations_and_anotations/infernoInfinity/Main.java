package enumerations_and_anotations.infernoInfinity;


import enumerations_and_anotations.infernoInfinity.core.*;
import enumerations_and_anotations.infernoInfinity.core.contracts.*;
import enumerations_and_anotations.infernoInfinity.io.*;
import enumerations_and_anotations.infernoInfinity.io.contracts.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Database database = new DatabaseImpl();
        Engine engine = new InfinityEngine(reader, writer, database);
        engine.run();
    }
}
