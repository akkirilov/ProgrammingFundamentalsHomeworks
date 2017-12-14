package p05_security_system.models;

import java.util.Scanner;

import p05_security_system.interfaces.SecurityCardUI;
import p05_security_system.interfaces.SecurityPinUI;

public class ScannerUI implements SecurityCardUI, SecurityPinUI{

    private Scanner scanner;

    public ScannerUI() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String requestKeyCard() {
        System.out.println("slide your key card");
        return this.scanner.nextLine();
    }

    @Override
    public int requestPinCode() {
        System.out.println("enter your pin code");
        return Integer.parseInt(this.scanner.nextLine());
    }
}
