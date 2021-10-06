package task.flowerStore.model.flowers;

import java.util.List;


public class GardenFlower extends Flower {

    private int numberOfBerries;

    public GardenFlower() {}

    public GardenFlower(String name, double stemLength, List<FlowerColors> colors,
                        double price, double hoursAfterCutOf, int numberOfBerries) {
        super(name, stemLength, colors, price, hoursAfterCutOf);
        this.numberOfBerries = numberOfBerries;
    }

    public int getNumberOfBerries() {
        return numberOfBerries;
    }

    public void setNumberOfBerries(int numberOfBerries) {
        this.numberOfBerries = numberOfBerries;
    }
}
