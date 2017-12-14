package p05_security_system.models;

import p05_security_system.interfaces.SecurityPinUI;

public class PinCodeCheck extends SecurityCheck {

    private SecurityPinUI securityPinUI;

    public PinCodeCheck(SecurityPinUI securityPinUI) {
        this.securityPinUI = securityPinUI;
    }

    @Override
    public boolean validateUser() {
        int pin = securityPinUI.requestPinCode();
        if (isValid(pin)) {
            return true;
        }

        return false;
    }

    private boolean isValid(int pin) {
        return true;
    }

}
