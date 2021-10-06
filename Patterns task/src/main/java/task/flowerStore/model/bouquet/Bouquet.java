package task.flowerStore.model.bouquet;

import task.flowerStore.model.accessories.Accessory;
import task.flowerStore.model.flowers.Flower;

import java.util.List;

public interface Bouquet {


    List<Flower> sort();

    double getPrice();

    List<Flower> getFlowersFromStemDiapason(double bottomLimit, double topLimit);

    List<Flower> getFlowers();

    List<Accessory> getAccessories();

    void addFlower(Flower flower);

    void addAccessory(Accessory accessory);
}
