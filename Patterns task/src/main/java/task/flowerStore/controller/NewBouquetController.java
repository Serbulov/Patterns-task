package task.flowerStore.controller;

import task.flowerStore.model.accessories.Accessory;
import task.flowerStore.model.bouquet.Bouquet;
import task.flowerStore.model.bouquet.FlowerBouquet;
import task.flowerStore.model.flowers.Flower;
import task.flowerStore.view.View;

import java.util.Scanner;

public class NewBouquetController extends Controller {

    private final int BOTTOM_SELECTION_VALUE = 1;
    private final int TOP_SELECTION_VALUE = 8;
    private final int CREATE_NEW_BOUQUET = 1;
    private final int SHOW_BOUQUET = 2;
    private final int ADD_FLOWER = 3;
    private final int ADD_ACCESSORY = 4;
    private final int SHOW_PRICE = 5;
    private final int SORT = 6;
    private final int SEARCH = 7;
    private final int RETURN_CODE = 8;

    private View view;

    public NewBouquetController() {
        view = new View();
    }


    public void processNewBouquet(Scanner scanner) {
        Bouquet bouquet = new FlowerBouquet();
        int userSelection = Constants.DEFAULT_SELECTION_CODE;
        while (userSelection != RETURN_CODE) {
            view.printNewBouquetMessage();

            while(!scanner.hasNextInt()) {
                view.printIncorrectChoiceMessage();
                view.printNewBouquetMessage();
                scanner.next();
            }

            userSelection = scanner.nextInt();
            if(!checkInput(userSelection)) {
                view.printIncorrectChoiceMessage();
                continue;
            }

            switch (userSelection) {
                case CREATE_NEW_BOUQUET: bouquet = new FlowerBouquet();
                    break;
                case SHOW_BOUQUET: view.showBouquet(bouquet);
                    break;
                case ADD_FLOWER: bouquet.addFlower(getFlower(scanner));
                    break;
                case ADD_ACCESSORY: bouquet.addAccessory(getAccessory(scanner));
                    break;
                case SHOW_PRICE: view.printMessage(bouquet.getPrice());
                    break;
                case SORT: bouquet.sort();
                    break;
                case SEARCH: view.printAll(processSearch(scanner, bouquet));
            }
        }
    }


    private boolean checkInput(int input) {
        return input >= BOTTOM_SELECTION_VALUE && input <= TOP_SELECTION_VALUE;
    }


    private Flower getFlower(Scanner scanner) {
        return  new NewFlowerController().processNewFlower(scanner);
    }


    private Accessory getAccessory(Scanner scanner) {
        return new NewAccessoryController().processNewAccessory(scanner);
    }
}
