package p05_security_system.models;

import p05_security_system.interfaces.SecurityCardUI;

public class KeyCardCheck extends SecurityCheck {

    private SecurityCardUI securityCardUI;

    public KeyCardCheck(SecurityCardUI securityCardUI) {
        this.securityCardUI = securityCardUI;
    }

    private boolean isValid(String code) {
        return true;
    }
    
    @Override
    public boolean validateUser() {
        String code = securityCardUI.requestKeyCard();
        if (isValid(code)) {
            return true;
        }
        return false;
    }

}
