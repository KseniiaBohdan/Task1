package task1.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class Tableware implements Serializable {

    private BigDecimal price;
    private String country;
    private String color;
    private String article;

    public Tableware() {
    }

    public Tableware(BigDecimal price, String country, String color, String article) {
        this.price = price;
        this.country = country;
        this.color = color;
        this.article = article;
    }

    @Override
    public String toString() {
        return "Tableware" +
                " price = " + price +
                " country = " + country +
                " color = " + color +
                " article = " + article;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tableware tableware = (Tableware) o;

        if (price != null ? !price.equals(tableware.price) : tableware.price != null) return false;
        if (country != null ? !country.equals(tableware.country) : tableware.country != null) return false;
        if (color != null ? !color.equals(tableware.color) : tableware.color != null) return false;
        return article != null ? article.equals(tableware.article) : tableware.article == null;

    }

    @Override
    public int hashCode() {
        int result = price != null ? price.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (article != null ? article.hashCode() : 0);
        return result;
    }
}
