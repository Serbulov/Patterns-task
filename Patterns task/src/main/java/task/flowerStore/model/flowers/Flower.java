package task.flowerStore.model.flowers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Flower {

    private String name;

    private double stemLength;

    private List<FlowerColors> colors; // Попробовать сделать 1

    private double price;

    private double hoursAfterCutoff;

    public Flower() {
        colors = new ArrayList<>();
    }

    public Flower(String name, double stemLength, List<FlowerColors> colors,
                  double price, double hoursAfterCutoff) {
        this.name = name;
        this.stemLength = stemLength;
        this.colors = colors;
        this.price = price;
        this.hoursAfterCutoff = hoursAfterCutoff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStemLength() {
        return stemLength;
    }

    public void setStemLength(double stemLength) {
        this.stemLength = stemLength;
    }

    public List<FlowerColors> getColors() {
        return colors;
    }

    public void setColors(List<FlowerColors> colors) {
        this.colors = colors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getHoursAfterCutoff() {
        return hoursAfterCutoff;
    }

    public void setHoursAfterCutoff(double hoursAfterCutoff) {
        this.hoursAfterCutoff = hoursAfterCutoff;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if(!(obj instanceof Flower)) {
            return false;
        }

        Flower flower = (Flower) (obj);

        return this.name.equals(flower.getName()) &&
               this.stemLength == flower.stemLength &&
               this.colors.equals(flower.colors) &&
               this.price == flower.price &&
               this.hoursAfterCutoff == flower.hoursAfterCutoff;
    }

    @Override
    public String toString() {
        return "Name: " + name + " " +
               "| stem length: " + stemLength + " " +
               "| colors: " + colors.stream().map(FlowerColors::toString).collect(Collectors.joining(", ")) + " " +
               "| price: " + price + " " +
               "| hours after cutoff: " + hoursAfterCutoff + " ";
    }
}
