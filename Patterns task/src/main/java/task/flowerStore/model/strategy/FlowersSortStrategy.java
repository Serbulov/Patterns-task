package task.flowerStore.model.strategy;

import task.flowerStore.model.flowers.Flower;

import java.util.Comparator;
import java.util.List;

/**
 Сортировка цветов в букете на основе уровня свежести.
 **/

public class FlowersSortStrategy implements SortStrategy<Flower>{
    @Override
    public void sort(List<Flower> list) {
        list.sort((firstFlower, secondFlower) -> (int) (firstFlower.getHoursAfterCutoff() - secondFlower.getHoursAfterCutoff()));
    }
}
