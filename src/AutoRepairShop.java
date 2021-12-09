import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AutoRepairShop {
    ArrayList<LuxuryCar> alLux = new ArrayList<>();
    ArrayList<EconomyCar> alEcon = new ArrayList<>();
    ArrayList<Automobile> alRepaired = new ArrayList<>();
    private String autoRepairShopName;
    private int totalCars;

    public AutoRepairShop(String autoRepairShopName) {
        this.autoRepairShopName = autoRepairShopName;
    }

    public void initializeAutoRepairShop(int numLux, int numEcon) {
        for (int i = 0; i < numLux; i++) {
            alLux.add(new LuxuryCar());
        }
        for (int i = 0; i < numEcon; i++) {
            alEcon.add(new EconomyCar());
        }
        totalCars = numLux + numEcon;


    }

    public void simulateAutoRepairShop() {
        LuxuryCar luxInRepair = null;
        int timeOfDay = 1;
        EconomyCar econInRepair = null;
        boolean luxRepairPersonIdle, econRepairPersonIdle = true;


        ArrayList<EconomyCar> tmpEcom=new ArrayList<>(alEcon);
        ArrayList<LuxuryCar> tmplux = new ArrayList<>(alLux);
        while (alRepaired.size()<totalCars) {
            if (luxInRepair == null && !alLux.isEmpty()) {
                luxInRepair = alLux.get(0);
                alLux.remove(0);
                luxRepairPersonIdle = false;
            } else if (luxInRepair != null) {

                luxInRepair.decrementRepairTimeRemaining();

                if (luxInRepair.getRepairTimeRemaining() <= 0) {
                    luxInRepair.setEndTime(timeOfDay);
                    alRepaired.add(luxInRepair);

                    luxRepairPersonIdle = true;
                    luxInRepair = null;
                }
            }
            //EconomyCar processing
            if (econInRepair == null && !alEcon.isEmpty()) {
                econInRepair = alEcon.get(0);
                alEcon.remove(0);
                econRepairPersonIdle = false;
            } else if (econInRepair != null) {
                econInRepair.decrementRepairTimeRemaining();
                if (econInRepair.getRepairTimeRemaining() == 0) {
                    econInRepair.setEndTime(timeOfDay);
                    alRepaired.add(econInRepair);

                    econRepairPersonIdle = true;
                    econInRepair = null;
                }
            }
            timeOfDay++;

        }

        alLux.addAll(tmplux);
        alEcon.addAll(tmpEcom);


    }

    public void generateAutoRepairShopStatistics(String file) throws IOException {
        int econTotal = 0;

//        for(Automobile automobile:alRepaired){
//            automobile.ge
//        }
        for (EconomyCar economyCar : alEcon) {
            econTotal = economyCar.getRepairPrice() + econTotal;
        }
        int econAvg = econTotal / alEcon.size();

        int luxTotal = 0;
        for (LuxuryCar luxuryCar : alLux) {
            luxTotal = luxuryCar.getRepairPrice() + luxTotal;
        }
        int luxAvg = luxTotal / alLux.size();


        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);


        String line = "Results For The AutoRepairShop Named " + autoRepairShopName;
        pw.println(line);

        line = "The average repair cost for " + alLux.size() + " Luxury Cars is $" + luxAvg;
        pw.println(line);

        line = "The average repair cost for " + alEcon.size() + " Economy Cars is $" + econAvg;
        pw.println(line);

        line = "The average repair cost for " + totalCars + " Total Cars is $" + (luxTotal + econTotal) + "\n";
        pw.println(line);


        for (EconomyCar car : alEcon) {
            line = car.toString();
            pw.println(line);
        }

        for (LuxuryCar car : alLux) {
            line = car.toString();
            pw.println(line);
        }

        pw.flush();
        pw.close();
        fw.close();

        System.out.println("Saved to file");
    }
}
