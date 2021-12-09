public abstract class Automobile {
    String autoType;

    public String getAutoType() {
        return autoType;
    }

    public Automobile() {
        setAutoType("");
    }

    public void setAutoType(String autoType) {
        this.autoType = autoType;
    }
    public abstract void setRepairPrice();
    public abstract int getRepairPrice();
}
