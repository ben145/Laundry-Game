public class Clothing {

    private String name;
    private String type;
    private double price;
    private double value;
    private boolean isDirty;
    private int daysDirty;

    Clothing(String name, String type, double price) {
        this.name = name; this.type = type; this.price = price; value = price; daysDirty = 0; isDirty = false;
    }

    String getName() {
        return name;
    }
    String getType() {
        return type;
    }
    double getPrice() {
        return price;
    }
    public double getValue() {
        return value;
    }
    public boolean isDirty() {
        return isDirty;
    }
    public int getDaysDirty() {
        return daysDirty;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void loseValue(double depreciation) {
        value -= depreciation;
    }
    public void setDirty() {
        isDirty = true;
    }
    public void wash() {
        isDirty = false;
    }
    public void stillDirty() {
        daysDirty++;
        value = value - (price * 0.05);
    }
    public void tooOld() {
        value = 0;
    }
}
