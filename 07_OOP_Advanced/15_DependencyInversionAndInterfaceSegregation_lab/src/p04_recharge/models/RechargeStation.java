package p04_recharge.models;

import p04_recharge.interfaces.Rechargeable;

public class RechargeStation {

    public void recharge(Rechargeable rechargeable) {
        rechargeable.recharge();
    }
}
