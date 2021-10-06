package task.flowerStore;

import task.flowerStore.model.accessories.Accessory;
import task.flowerStore.model.accessories.AccessoryType;
import task.flowerStore.model.bouquet.Bouquet;
import task.flowerStore.model.bouquet.BouquetFactory;
import task.flowerStore.model.flowers.Flower;
import task.flowerStore.model.flowers.FlowerColors;
import task.flowerStore.model.flowers.WildFlower;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BouquetTest {

    @Test
    public void testAddToBouquet() {
        Bouquet bouquet = BouquetFactory.getFlowerBouquet();

        Flower rose = new Flower("Rose", 30, Arrays.asList(FlowerColors.RED), 10, 5);
        Flower chamomile = new WildFlower("Chamomile", 20, Arrays.asList(FlowerColors.WHITE, FlowerColors.YELLOW), 5, 6, false);
        Flower anotherChamomile = new WildFlower("Chamomile", 20, Arrays.asList(FlowerColors.WHITE, FlowerColors.YELLOW), 5, 7, false);
        Accessory paper = new Accessory(AccessoryType.WRAPPING_PAPER, 5);

        bouquet.addFlower(rose);
        bouquet.addFlower(chamomile);
        bouquet.addFlower(anotherChamomile);
        bouquet.addAccessory(paper);

        assertEquals(4, bouquet.getAccessories().size() + bouquet.getFlowers().size());
    }

    @Test
    public void testGetPrice() {
        final double ROSE_PRICE = 10;
        final double PAPER_PRICE = 4;

        Bouquet bouquet = BouquetFactory.getFlowerBouquet();

        Flower rose = new Flower("Rose", 30, Arrays.asList(FlowerColors.RED), ROSE_PRICE, 5);
        Accessory accessory = new Accessory(AccessoryType.WRAPPING_PAPER, PAPER_PRICE);

        bouquet.addFlower(rose);
        bouquet.addAccessory(accessory);

        assertEquals(bouquet.getPrice(), ROSE_PRICE + PAPER_PRICE, 0.0001);
    }

    @Test
    public void testSortByCutoffTime() {
        final double ROSE_CUTOFF_TIME = 5;
        final double CHAMOMILE_CUTOFF_TIME = 7;
        final double ANOTHER_CHAMOMILE_CUTOFF_TIME = 6;

        Bouquet bouquet = BouquetFactory.getFlowerBouquet();

        Flower rose = new Flower("Rose", 30, Arrays.asList(FlowerColors.RED), 10, ROSE_CUTOFF_TIME);
        Flower chamomile = new WildFlower("Chamomile", 20, Arrays.asList(FlowerColors.WHITE, FlowerColors.YELLOW), 5,
                CHAMOMILE_CUTOFF_TIME, false);
        Flower anotherChamomile = new WildFlower("Chamomile", 20, Arrays.asList(FlowerColors.WHITE, FlowerColors.YELLOW), 5,
                ANOTHER_CHAMOMILE_CUTOFF_TIME, false);

        bouquet.addFlower(rose);
        bouquet.addFlower(chamomile);
        bouquet.addFlower(anotherChamomile);

        List<Flower> sorted = Arrays.asList(rose, anotherChamomile, chamomile);

        assertEquals(sorted, bouquet.sort());
    }

    @Test
    public void testSearchByStemLength() {
        final double ROSE_STEM_LENGTH = 30;
        final double CHAMOMILE_STEM_LENGTH = 20;
        final double BOTTOM_STEM_LENGTH = 25;
        final double TOP_STEM_LENGTH = 35;

        Bouquet bouquet = BouquetFactory.getFlowerBouquet();

        Flower rose = new Flower("Rose", ROSE_STEM_LENGTH, Arrays.asList(FlowerColors.RED), 10, 5);
        Flower chamomile = new WildFlower("Chamomile", CHAMOMILE_STEM_LENGTH,
                Arrays.asList(FlowerColors.WHITE, FlowerColors.YELLOW), 5, 7, false);
        Flower anotherChamomile = new WildFlower("Chamomile", CHAMOMILE_STEM_LENGTH,
                Arrays.asList(FlowerColors.WHITE, FlowerColors.YELLOW), 5, 6, false);

        bouquet.addFlower(rose);
        bouquet.addFlower(chamomile);
        bouquet.addFlower(anotherChamomile);

        List<Flower> result = bouquet.getFlowersFromStemDiapason(BOTTOM_STEM_LENGTH, TOP_STEM_LENGTH);

        if(!result.contains(rose)) {
            fail();
        }

        assertEquals(1, result.size());
    }
}
