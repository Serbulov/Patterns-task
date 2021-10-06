package task.flowerStore.controller;

import task.flowerStore.model.flowers.GardenFlower;
import task.flowerStore.model.flowers.Flower;
import task.flowerStore.model.flowers.FlowerColors;
import task.flowerStore.model.flowers.WildFlower;
import task.flowerStore.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class NewFlowerController {
    View view;

    public NewFlowerController() {
        this.view = new View();
    }


    public Flower processNewFlower(Scanner scanner) {
        Flower flower;

        flower = chooseFlowerType(scanner);

        view.printSelectNameMessage();
        flower.setName(scanner.next());

        view.printSelectStemLengthMessage();
        flower.setStemLength(readDouble(scanner));

        flower.setColors(readColors(scanner));

        view.printSelectPriceMessage();
        flower.setPrice(readDouble(scanner));

        view.printSelectHoursAfterCutOffMessage();
        flower.setHoursAfterCutoff(readDouble(scanner));

        return flower;
    }


    private Flower chooseFlowerType(Scanner scanner) {
        final int GARDEN_TYPE = 1;
        final int WILD_TYPE = 2;
        final int REGULAR_TYPE = 3;
        int selectedType;

        while(true) {
            view.printAddFlowerMessage();
            while(!scanner.hasNextInt()) {
                view.printIncorrectChoiceMessage();
                view.printAddFlowerMessage();
                scanner.next();
            }

            selectedType = scanner.nextInt();
            if(selectedType != GARDEN_TYPE && selectedType != WILD_TYPE && selectedType != REGULAR_TYPE) {
                view.printIncorrectChoiceMessage();
                continue;
            }
            else {
                if(selectedType == GARDEN_TYPE) {
                    return new GardenFlower();
                }
                if(selectedType == WILD_TYPE) {
                    return new WildFlower();
                }
                else {
                    return new Flower();
                }
            }
        }
    }

    private double readDouble(Scanner scanner) {
        double value;

        while (true) {
            while (!scanner.hasNextDouble()) {
                view.printIncorrectChoiceMessage();
                scanner.next();
            }
            value = scanner.nextDouble();
            if(value <= 0) {
                view.printIncorrectChoiceMessage();
                continue;
            }
            break;
        }

        return value;
    }


    private boolean readBoolean(Scanner scanner) {
        boolean value;

        while (true) {
            while (!scanner.hasNextBoolean()) {
                view.printIncorrectChoiceMessage();
                scanner.next();
            }

            value = scanner.nextBoolean();
            break;
        }

        return value;
    }


    private List<FlowerColors> readColors(Scanner scanner){
        List<FlowerColors> colors = new ArrayList<>();
        final int END_CODE = 8;

        int userSelection = 0;

        while(userSelection != END_CODE) {
            view.printColorSelectionMenu();

            while(!scanner.hasNextInt()) {
                view.printIncorrectChoiceMessage();
                view.printColorSelectionMenu();
                scanner.next();
            }

            userSelection = scanner.nextInt();

            if(userSelection <=0 || userSelection > END_CODE) {
                view.printIncorrectChoiceMessage();
            }
            else {
                if(userSelection != END_CODE) {
                    FlowerColors flowerColor = FlowerColors.values()[userSelection - 1];
                    if(!colors.contains(flowerColor)) {
                        colors.add(flowerColor);
                    }
                }
            }
        }

        return colors;
    }

}
