package wagon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import product.Product;


public class Wagon {
    private enum pack {
        PRODUCT, QUANTITY
    }
    private final Double volume;
    private Double freeVolume;
    private final Double amount;
    private Double freeAmount;

    private List<ProductBox> productBox = new ArrayList<>();

    public Wagon(Double volume, Double amount) {
        this.volume = volume;
        freeVolume = volume;

        this.amount = amount;
        freeAmount = amount;
    }

    public boolean addPack (Product product, int quantity) {

        Double addVolume = quantity * product.getGrossVolume();
        Double addAmount = quantity * product.getAmount();

        if (addAmount > freeAmount) {
            return false;
        }
        if (addVolume > freeVolume) {
            return false;
        }

        freeAmount -= addAmount;
        freeVolume -= addVolume;


        ProductBox newPack = new ProductBox(product, quantity);

        int index = productBox.indexOf(newPack);
        if( index >= 0){
            int oldQuantity = productBox.get(index).getQuantity();
            productBox.get(index).setQuantity(oldQuantity + quantity);
        } else {
            productBox.add(newPack);
        }

        return true;
    }

    public Double getFreeVolume() {
         synchronized(freeVolume){return freeVolume;}
    }

    public Double getFreeAmount() {
        synchronized(freeAmount){return freeAmount;}
    }

    public void makeWagonEmpty() {
        productBox.clear();
        freeVolume = volume;
        freeAmount = amount;
    }

    public List selectByPrice (Double from, Double to){

        List<ProductBox> selectedProducts = new ArrayList<>();

        for(ProductBox p:productBox) {
            if((from <= p.getProduct().getAmount()) &&
                    (p.getProduct().getAmount() <= to)) {
                selectedProducts.add(p);
            }
        }
        return selectedProducts;
    }

    public List  selectByVolume (Double from, Double to){

        List<ProductBox> selectedProducts = new ArrayList<>();

        for(ProductBox p:productBox) {
            if((from <= p.getProduct().getGrossVolume()) &&
                    (p.getProduct().getGrossVolume() <= to)) {
                selectedProducts.add(p);
            }
        }
        return selectedProducts;
    }

    public List  selectByWeight (Double from, Double to){

        List<ProductBox> selectedProducts = new ArrayList<>();

        for(ProductBox p:productBox) {
            if((from <= p.getProduct().getGrossWeight()) &&
                    (p.getProduct().getGrossWeight() <= to)) {
                selectedProducts.add(p);
            }
        }
        return selectedProducts;
    }

    public List sortByQuality() {
        Collections.sort(productBox);
        return productBox;
    }

    @Override
    public String toString() {

        String string = "";

        for(ProductBox b : productBox) {
            string += b.toString();
        }

        return string;
    }
}
