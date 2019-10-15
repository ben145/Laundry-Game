import java.util.ArrayList;
import java.util.Formatter;


public class Laundry {

    private ArrayList<Clothing> laundry;
    private ArrayList<Clothing> available;
    private ArrayList<Clothing> store;
    private double myMoney;
    private int days;
    String clothes[] = {"pants", "shirts", "socks", "underwear"};

    Laundry() {
        laundry = new ArrayList<>();
        available = new ArrayList<>();
        store = new ArrayList<>();
        myMoney = 50.00;
        days = 0;
    }

    public ArrayList<Clothing> getLaundry() {
        return laundry;
    }

    public ArrayList<Clothing> getAvailable() {
        return available;
    }

    public double getMyMoney() {
        return myMoney;
    }

    public int getDays() {
        return days;
    }

    public void addToLaundry(Clothing c) {
        laundry.add(c);
    }

    public void cleanLaundry(Clothing c) {
        available.add(c);
        laundry.remove(c);
    }

    public void addMoney(double money) {
        myMoney += money;
    }

    public void spendMoney(double money) {
        myMoney -= money;
    }

    public void loseMoney(double money) {
        myMoney -= money;
    }

    public void buyClothing(Clothing c) {
        available.add(c);
        myMoney -= c.getPrice();
    }

    public void toStringAvailable() {
        for (Clothing anAvailable : available) {
            double v = (Math.floor(anAvailable.getValue() * 100)) / 100;
            System.out.print("[Type: " + anAvailable.getType() + "]   [Article: " + anAvailable.getName());
            System.out.println("]   [Price: " + anAvailable.getPrice() + "]   [Value: " + v + "]");
        }
    }

    private void toStringLaundry() {
        System.out.println("Laundry:");
        for (Clothing clothing : laundry) {
            double v = (Math.floor(clothing.getValue() * 100)) / 100;
            System.out.print("\t[Type: " + clothing.getType() + "]   [Article: " + clothing.getName());
            System.out.println("]   [Price: " + clothing.getPrice() + "]   [Value: " + v + "]");
        }
    }

    public void dayEnd() {
        days++;
        for (Clothing clothing : laundry) {
            clothing.stillDirty();
        }
    }

    boolean meetMin() {
        int pants = 1;
        int shirts = 1;
        int socks = 2;
        int underwear = 1;
        for (Clothing c: available) {
            switch (c.getType()) {
                case "pants": pants--;
                case "shirts": shirts--;
                case "socks": socks--;
                case "underwear": underwear--;
            }
        }
        return pants < 1 && shirts < 1 && socks < 1 && underwear < 1;
    }

    public static void main(String[] args) {
        Laundry main = new Laundry();
        Clothing c = new Clothing("Red Tee", "shirt", 10.49);
        main.addToLaundry(c);
        main.toStringLaundry();
        main.dayEnd();
        main.toStringLaundry();
    }
}
