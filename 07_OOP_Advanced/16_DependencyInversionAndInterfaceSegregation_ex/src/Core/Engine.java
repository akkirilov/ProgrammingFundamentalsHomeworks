package Core;

import contracts.ICommandHandler;
import contracts.Printer;
import contracts.Reader;
import io.TerminalPrinter;
import io.TerminalReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {
	
    private CommandHandler commandHandler;
    private Reader reader;
    private Printer printer;
    

    public Engine(CommandHandler commandHandler, Reader reader, Printer printer) {
        this.commandHandler = commandHandler;
        this.reader = reader;
        this.printer = printer;
    }

    public Engine() {
        this.commandHandler = new CommandHandler();
        this.reader = new TerminalReader();
        this.printer = new TerminalPrinter();
    }

    public ICommandHandler getCommandHandler;

    public void run() {
        while (true) {
            String line = this.reader.readLine();
            if (line.equals("End")) {
                break;
            }

            List<String> parameters = Arrays.stream(line.split("\\\\")).collect(Collectors.toList());
            String name = parameters.remove(0);
            try {
                String commandResult = this.commandHandler.executeCommand(name, parameters);
                this.printer.printLine(commandResult);
            } catch (Exception ex) {
            	this.printer.printLine(ex.getMessage());
            }
        }
        this.reader.close();
    }

}
