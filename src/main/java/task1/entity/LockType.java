package task1.entity;

import java.io.Serializable;

public enum LockType implements Serializable {
    LATCH("Latch"), BUNG("Bung"), SCREW_CAP("Screw cap");

    private final String name;

    LockType(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return " LockType = " + name;
    }

    public static int enumSize() {
        return LockType.values().length;
    }
}
