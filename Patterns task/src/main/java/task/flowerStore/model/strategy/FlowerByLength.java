package task.flowerStore.model.strategy;

import task.flowerStore.model.flowers.Flower;

import java.util.Comparator;
import java.util.List;

public class FlowerByLength implements SortStrategy<Flower> {
    @Override
    public void sort(List<Flower> list) {
        list.sort(Comparator.comparingDouble(Flower::getStemLength).reversed());
    }
}
