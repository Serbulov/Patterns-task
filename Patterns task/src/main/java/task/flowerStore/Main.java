package task.flowerStore;

import task.flowerStore.controller.Controller;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.processUser(new Scanner(System.in));
    }
}
