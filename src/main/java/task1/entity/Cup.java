package task1.entity;

import java.math.BigDecimal;

public class Cup extends Tableware {

    private Integer volume;
    private Integer handleAmount;

    public Cup() {
    }

    public Cup(BigDecimal price, String country, String color, int volume, int handle, String article) {
        super(price, country, color, article);
        this.volume = volume;
        this.handleAmount = handle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cup cup = (Cup) o;

        if (volume != cup.volume) return false;
        return handleAmount == cup.handleAmount;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + volume;
        result = 31 * result + handleAmount;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + " CUP" +
                " volume = " + volume +
                " handleAmount = " + handleAmount;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public int getHandleAmount() {
        return handleAmount;
    }

    public void setHandleAmount(Integer handleAmount) {
        this.handleAmount = handleAmount;
    }
}
