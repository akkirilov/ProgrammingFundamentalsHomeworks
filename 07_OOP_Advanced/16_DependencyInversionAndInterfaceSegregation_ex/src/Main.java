import Core.CommandHandler;
import Core.Engine;
import contracts.IBoatSimulatorController;
import contracts.Printer;
import contracts.Reader;
import controllers.BoatSimulatorController;
import io.TerminalPrinter;
import io.TerminalReader;

public class Main {
	
	public static void main(String[] args) {

		IBoatSimulatorController controller = new BoatSimulatorController();
		
		CommandHandler commandHandler = new CommandHandler(controller);
		
		Reader reader = new TerminalReader();
		
		Printer printer = new TerminalPrinter();
		
		Engine engine = new Engine(commandHandler, reader, printer);

		engine.run();

	}
	
}
