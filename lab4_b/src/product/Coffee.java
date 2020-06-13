package product;

public class Coffee extends Product {



    public enum CoffeeType {
        Растворимый, Молотый, Зерно
    }

    public enum CoffeePack {
        Пакет, Банка
    }

    public Coffee(String sort, CoffeeType type, Double price,
                  Double netWeight, CoffeePack pack) {

        super("Coffee");
        this.price = price;
        this.sort = sort;
        this.type = type;
        this.pack = pack;
        this.amount = calculateAmount(netWeight);
        this.grossWeight = calculateGrosWeight(netWeight);
        this.grossVolume = calculateGrosVolume(netWeight);

    }



    public String getSort() {
        return this.sort;
    }

    @Override
    public Double getQuality() {
        return (this.amount/this.grossWeight) *
                (type.ordinal() + 1) * (pack.ordinal() + 1);
    }

    /**
     *
     * @param other
     * @return
     */
    @Override
    public int compareTo(Product other) {
        return Double.compare(this.getQuality(), other.getQuality());
    }

    @Override
    public String toString(){
        String string;
        string = "Кофе " + sort + " " + type.toString().toLowerCase() +
                " в " + pack.toString().toLowerCase()+ ". " +
                "Цена: " + this.amount + " USD/pcs";
        return string;
    }

    private final String sort;
    private final Double price;
    private final CoffeeType type;
    private final CoffeePack pack;

    // Density of the coffee as a function of grinding. In kg/m^3
    private final Double [] density = {200.0, 300.0, 430.0};

    // It affects the weight and cost of the goods in the package
    private final Double [] packFactor = {1.1, 1.5};

    private Double calculateGrosVolume(Double netWeight) {

        return (netWeight / this.density[type.ordinal()]) * this.packFactor[pack.ordinal()];
    }

    private Double calculateGrosWeight(Double netWeight) {

        return netWeight * this.packFactor[pack.ordinal()];
    }

    private Double calculateAmount(Double netWeight) {

        return price * netWeight * this.packFactor[pack.ordinal()] *
                (this.density[type.ordinal()]/density[CoffeeType.Зерно.ordinal()]);
    }


}