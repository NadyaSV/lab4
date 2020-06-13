package product;

abstract public class Product implements Comparable<Product> {

    protected Double amount;
    protected Double grossVolume;
    protected Double grossWeight;
    protected String category;

    abstract public Double getQuality();

    public Product(String category) {
        this.category = category;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getGrossVolume() {
        return grossVolume;
    }

    public Double getGrossWeight() {
        return grossWeight;
    }

    public String getCategory() {
        return category;
    }

}
