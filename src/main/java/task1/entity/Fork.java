package task1.entity;

import java.math.BigDecimal;

public class Fork extends Tableware {

    private Integer prong;
    private Type type;

    public Fork() {
    }

    public Fork(BigDecimal price, String country, String color, Integer prong, Type type, String article) {
        super(price, country, color, article);
        this.prong = prong;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Fork fork = (Fork) o;

        if (prong != fork.prong) return false;
        return type == fork.type;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + prong;
        result = 31 * result + type.hashCode();
        return result;
    }

    public Integer getProng() {
        return prong;
    }

    public void setProng(Integer prong) {
        this.prong = prong;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + " FORK" +
                " prong = " + prong +
                " type = " + type;
    }
}
