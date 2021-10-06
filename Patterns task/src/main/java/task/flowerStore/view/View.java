package task.flowerStore.view;

import task.flowerStore.model.bouquet.Bouquet;

import java.util.List;

public class View {

    public <T> void printMessage(T message) {
        System.out.println(message + " у.е.");
    }

    public <T> void printAll(List<T> list) {
        list.forEach(System.out::println);
    }

    public void printBaseMenu() {
        String menu = "\n1. New bouquet\n" +
                "2. Exit\n";
        System.out.println(menu);
    }

    public void printNewBouquetMessage() {
        String menu = "\n1. New bouquet\n" +
                "2. Show bouquet items\n" +
                "3. Add flower\n" +
                "4. Add accessory\n" +
                "5. Show price\n" +
                "6. Sort flowers by cutoff time\n" +
                "7. Search flowers in stem length diapason\n" +
                "8. Return\n";
        System.out.println(menu);
    }

    public void printIncorrectChoiceMessage() {
        System.out.println("Incorrect option! Try again.");
    }

    public void printBottomLimit() {
        System.out.println("Enter minimal length of stem:");
    }

    public void printTopLimit() {
        System.out.println("Enter maximal length of stem:");
    }

    public String getErrorMessage() {
        return ("An error was occurred:") + " ";
    }

    public void showBouquet(Bouquet bouquet) {
        bouquet.getFlowers().forEach(System.out::println);
        bouquet.getAccessories().forEach(System.out::println);
    }

    public void printAddAccessoryMessage() {
        String message = "\nSelect type:\n" +
                "1. Paper\n" +
                "2. Ribbons\n";
        System.out.println(message);
    }

    public void printSelectPriceMessage() {
        System.out.println("Select price:");
    }

    public void printAddFlowerMessage() {
        String message = "\nSelect type:\n" +
                "1. Garden flower\n" +
                "2. Wild flower\n" +
                "3. Another flower\n";
        System.out.println(message);
    }

    public void printSelectNameMessage() {
        System.out.println("Select name:");
    }

    public void printSelectBudDiameterMessage() {
        System.out.println("Select bud diameter:");
    }

    public void printSelectStemLengthMessage() {
        System.out.println("Select stem length:");
    }

    public void printSelectSpikedMessage() {
        System.out.println("Is spiked? Select \"true\" or \"false\":");
    }

    public void printColorSelectionMenu() {
        String menu = "\nSelect a color:\n" +
                "1. Red\n" +
                "2. Orange\n" +
                "3. Blue\n" +
                "4. White\n" +
                "5. Green\n" +
                "6. Yellow\n" +
                "7. Pink\n" +
                "8. End\n";
        System.out.println(menu);
    }

    public void printSelectHoursAfterCutOffMessage() {
        System.out.println("Enter hours after cutoff:");
    }
}