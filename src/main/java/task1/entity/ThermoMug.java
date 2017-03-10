package task1.entity;

import java.math.BigDecimal;

public class ThermoMug extends Cup {

    private Integer timeHeatHold;
    private LockType type;

    public ThermoMug() {
    }

    public ThermoMug(BigDecimal price, String country, String color, Integer volume,
                     Integer handle, Integer time, LockType type, String article) {
        super(price, country, color, volume, handle, article);
        this.timeHeatHold = time;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ThermoMug thermoMug = (ThermoMug) o;

        if (Double.compare(thermoMug.timeHeatHold, timeHeatHold) != 0) return false;
        return type == thermoMug.type;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(timeHeatHold);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + type.hashCode();
        return result;
    }

    public Integer getTimeHeatHold() {
        return timeHeatHold;
    }

    public void setTimeHeatHold(Integer timeHeatHold) {
        this.timeHeatHold = timeHeatHold;
    }

    public LockType getType() {
        return type;
    }

    public void setType(LockType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + " THERMO MUG " +
                " timeHeatHold = " + timeHeatHold +
                " type = " + type;
    }
}
