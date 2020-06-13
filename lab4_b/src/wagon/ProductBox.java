package wagon;

import java.util.Objects;
import product.Product;


public class ProductBox implements Comparable<ProductBox>  {
    private Product product;
    private int quantity;

    public ProductBox(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        synchronized(product){return product;}
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
       return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(ProductBox other) {
        return this.product.compareTo(other.product);
    }

    @Override
    public String toString() {
        return this.product.toString() + " - " + this.quantity + " pcs\n";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.product);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof ProductBox) {
            ProductBox tmpProductBox = (ProductBox) obj;
            if (!tmpProductBox.product.equals(this.product)) return false;
            return true;
        }
        return false;
    }
}