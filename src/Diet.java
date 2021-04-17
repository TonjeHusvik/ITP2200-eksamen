import java.util.ArrayList;
import java.util.Iterator;

public abstract class Diet {
    private int daysDuration;
    private String purpose;
    private ArrayList<Food> allowedFood;
    public boolean isVegan;
    private String name;

    public Diet(String name, int daysDuration, String purpose, ArrayList<Food> allowedFood, boolean isVegan) {
        this.daysDuration = daysDuration;
        this.purpose = purpose;
        this.allowedFood = allowedFood;
        this.isVegan = isVegan;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDaysDuration() {
        return daysDuration;
    }

    public String getPurpose() {
        return purpose;
    }

    public ArrayList<Food> getAllowedFood() {
        return allowedFood;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }


    public String writeDuration(Diet d) {
        String result = "";
        int days = d.daysDuration;
        int years = days / 365;
        int equivalence = days % 365;
        int months = equivalence / 30;
        days = equivalence % 30;
        result = "This " + d.getName() + " lasts for " + years + " years, " + months + " months and " + days + " days";
        return result;
    }

    public String writeDurationInDays(Diet d) {
        String result = "";
        int days = d.daysDuration;
        result = "This " + d.getName() + " lasts for " + days + " days";
        return result;
    }

    public String writeDurationInMonths(Diet d) {
        String result = "";
        int months = d.daysDuration / 30;
        result = "This " + d.getName() + " lasts for " + months + " months";

        if (d.daysDuration >= 30) {
            return result;
        } else
            throw new IllegalArgumentException("ERROR, the input is less than 1 month");
    }

    public String writeDurationInYears(Diet d) {
        String result = "";
        int years = d.daysDuration / 365;
        result = "This " + d.getName() + " lasts for " + years + " years";

        if (d.daysDuration >= 365) {
            return result;
        } else
            throw new IllegalArgumentException("ERROR, the input is less than 1 year");
    }

    public String writeAllowedFood(Diet d) {
        String result = "";

        result = "The following food is allowed in this " + d.getName() + ": " + allowedFood;
        return result;
    }


    public boolean dietRestriction1b() {
        for (Food f : getAllowedFood()) {
            if (f.isVegan()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean dietRestriction1a(Diet d) {
        for (Food f : allowedFood) {
            if ((!f.isVegan() && !d.isVegan()) || (!f.isVegan() && d.isVegan())) {
                throw new IllegalArgumentException("NOT VEGAN");
            }
        }
        return true;
    }
}