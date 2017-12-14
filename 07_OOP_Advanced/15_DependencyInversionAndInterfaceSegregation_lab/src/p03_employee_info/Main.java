package p03_employee_info;

import p03_employee_info.interfaces.Database;
import p03_employee_info.interfaces.InfoProvider;
import p03_employee_info.interfaces.Printer;
import p03_employee_info.models.ConsoleClient;
import p03_employee_info.models.ConsoleFormatter;
import p03_employee_info.models.EmployeeDatabase;
import p03_employee_info.models.EmployeeInfoProvider;
import p03_employee_info.models.TerminalPrinter;

public class Main {

    public static void main(String[] args) {
    	
    	Database database = new EmployeeDatabase();
        InfoProvider infoProvider = new EmployeeInfoProvider(database);
        
        Printer printer = new TerminalPrinter();
        
        ConsoleFormatter formatter = new ConsoleFormatter();
        
        ConsoleClient client = new ConsoleClient(infoProvider, printer, formatter);
        client.printEmloyees();

    }
    
}
