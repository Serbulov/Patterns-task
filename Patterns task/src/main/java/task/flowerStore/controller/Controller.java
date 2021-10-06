package task.flowerStore.controller;

import task.flowerStore.model.bouquet.Bouquet;
import task.flowerStore.model.flowers.Flower;
import task.flowerStore.view.View;

import java.util.List;
import java.util.Scanner;

public class Controller {

    private View view;

    public Controller() {
        this.view = new View();
    }

    public void processUser(Scanner scanner) {
        int userSelection = Constants.DEFAULT_SELECTION_CODE;
        while (userSelection != Constants.EXIT_CODE) {
            view.printBaseMenu();

            while (!scanner.hasNextInt()) {
                view.printIncorrectChoiceMessage();
                view.printBaseMenu();
                scanner.next();
            }

            userSelection = scanner.nextInt();
            if (!checkInput(userSelection)) {
                view.printIncorrectChoiceMessage();
                continue;
            }

            switch (userSelection) {
                case Constants.NEW_BOUQUET:
                    processNewBouquet(scanner);
                    break;
            }
        }
    }

    private boolean checkInput(int input) {
        return input >= Constants.BOTTOM_SELECTION_VALUE && input <= Constants.TOP_SELECTION_VALUE;
    }

    private void processNewBouquet(Scanner scanner) {
        new NewBouquetController().processNewBouquet(scanner);
    }


    protected List<Flower> processSearch(Scanner scanner, Bouquet bouquet) {
        double min, max;

        view.printBottomLimit();
        while (!scanner.hasNextDouble()) {
            view.printIncorrectChoiceMessage();
            view.printBottomLimit();
            scanner.next();
        }
        min = scanner.nextDouble();

        view.printTopLimit();
        while (!scanner.hasNextDouble()) {
            view.printTopLimit();
            view.printIncorrectChoiceMessage();
            scanner.next();
        }
        max = scanner.nextDouble();

        return bouquet.getFlowersFromStemDiapason(min, max);
    }
}
