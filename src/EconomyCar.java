import java.util.Random;

public class EconomyCar extends Automobile implements RepairTimes {
    public static Random randyEcon = new Random(3);
    public static int economyCounter = 0;
    private String economyID;
    private int repairPrice, repairTime, repairTimeRemaining, endTime;

    public EconomyCar() {
        setEconomyID();
        setRepairPrice();
        setRepairTime();
    }

    @Override
    public void setRepairPrice() {
        repairPrice = 100 + randyEcon.nextInt(1000 - 100 + 1);
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
        repairTime = 15 + randyEcon.nextInt(90 - 15 + 1);
        repairTimeRemaining=repairTime;
    }

    @Override
    public void decrementRepairTimeRemaining() {
       repairTimeRemaining= repairTimeRemaining-1;
    }

    @Override
    public int getRepairTimeRemaining() {
        return repairTimeRemaining;
    }

    public String getEconomyID() {
        return economyID;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setEconomyID() {
        economyCounter=economyCounter + 1;
        this.economyID = "Economy" + economyCounter;
    }

    @Override
    public String toString() {
        return
                economyID +
                        " repairs cost $" + repairPrice +
                        " with a repair time of " + repairTime +
//                        " repairTimeRemaining " + repairTimeRemaining +
                        " minutes finished at clock time " + endTime + " minutes";

    }
}
