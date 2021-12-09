import java.io.IOException;
import java.util.Scanner;

public class ModelAutoRepairShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Shop name ");
        String shopName = scanner.nextLine();

        AutoRepairShop autoRepairShop = new AutoRepairShop(shopName);

        System.out.print("Enter numbers of Luxury Cars ");
        int numLux = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter numbers of Economy Cars ");
        int econLux = Integer.parseInt(scanner.nextLine());

        autoRepairShop.initializeAutoRepairShop(numLux, econLux);
        autoRepairShop.simulateAutoRepairShop();

        System.out.print("Enter File name ");
        String fileName = scanner.nextLine();
        try {
            autoRepairShop.generateAutoRepairShopStatistics(fileName + ".txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();


    }
}
