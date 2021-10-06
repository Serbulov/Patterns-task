package task.flowerStore.controller;

import task.flowerStore.model.accessories.Accessory;
import task.flowerStore.model.accessories.AccessoryType;
import task.flowerStore.view.View;

import java.util.Scanner;

public class NewAccessoryController {

    private final int DEFAULT_ACCESSORY_TYPE = 0;
    private final int WRAPPING_PAPER = 1;
    private final int RIBBONS = 2;

    private View view;

    public NewAccessoryController () {
        this.view = new View();
    }

    public Accessory processNewAccessory(Scanner scanner){
        Accessory accessory = new Accessory();
        int accessoryTypeCode = DEFAULT_ACCESSORY_TYPE;

        while (true) {
            view.printAddAccessoryMessage();
            while (!scanner.hasNextInt()) {
                view.printIncorrectChoiceMessage();
                view.printAddAccessoryMessage();
                scanner.next();
            }

            accessoryTypeCode = scanner.nextInt();
            if (!checkUserSelection(accessoryTypeCode)) {
                view.printIncorrectChoiceMessage();
                continue;
            }
            else {
                AccessoryType accessoryType;
                if(accessoryTypeCode == WRAPPING_PAPER) {
                    accessoryType = AccessoryType.WRAPPING_PAPER;
                }
                else {
                    accessoryType = AccessoryType.RIBBONS;
                }
                accessory.setType(accessoryType);
            }

            double price = choosePrice(scanner);
            accessory.setPrice(price);

            break;
        }

        return accessory;
    }


    public boolean checkUserSelection(int input) {
        return input == WRAPPING_PAPER || input == RIBBONS;
    }


    public double choosePrice(Scanner scanner) {
        double price;

        while (true) {
            view.printSelectPriceMessage();
            while (!scanner.hasNextDouble()) {
                view.printIncorrectChoiceMessage();
                view.printSelectPriceMessage();
                scanner.next();
            }

            price = scanner.nextDouble();
            if(price <= 0) {
                view.printIncorrectChoiceMessage();
                continue;
            }

            break;
        }

        return price;
    }
}
