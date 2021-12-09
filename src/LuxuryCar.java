import java.util.Random;

public class LuxuryCar extends Automobile implements RepairTimes {

    public static Random randyLux = new Random(7);
    public static int luxuryCounter = 0;

    private String luxuryID;
    private int repairPrice, repairTime, repairTimeRemaining, endTime;

    public LuxuryCar() {
        setLuxuryID();
        setRepairPrice();
        setRepairTime();
    }


    @Override
    public void setRepairPrice() {
        repairPrice = 550 + randyLux.nextInt(2600 - 550 + 1);
    }

    @Override
    public int getRepairPrice() {
        return repairPrice;
    }

    @Override
    public int getRepairTime() {
        return repairTime;
    }

    @Override
    public void setRepairTime() {
        repairTime = 20 + randyLux.nextInt(120 - 20 + 1);
        repairTimeRemaining=repairTime;
    }

    @Override
    public void decrementRepairTimeRemaining() {
        repairTimeRemaining=repairTimeRemaining-1;
    }



    @Override
    public int getRepairTimeRemaining() {
        return repairTimeRemaining;
    }


    public String getLuxuryID() {
        return luxuryID;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setLuxuryID() {
        luxuryCounter = luxuryCounter + 1;
        this.luxuryID = "Luxury" + luxuryCounter;
    }

    @Override
    public String toString() {
        return
                luxuryID +
                        " repairs cost $" + repairPrice +
                        " with a repair time of " + repairTime +
                        //" repairTimeRemaining=" + repairTimeRemaining +
                        " minutes finished at clock time " + endTime + " minutes";

    }
}
