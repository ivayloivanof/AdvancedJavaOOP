package enumerations_and_anotations.infernoInfinity.io;

import enumerations_and_anotations.infernoInfinity.io.contracts.Writer;

public class ConsoleWriter implements Writer {
    @Override
    public void write(Object message) {
        System.out.println(message);
    }
}
