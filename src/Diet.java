import java.util.ArrayList;
import java.util.Arrays;

public abstract class Diet {
    private int daysDuration;
    private String purpose;
    private ArrayList<Food> allowedFood;
    private boolean isVegan;
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

    public void setName(String name) {
        this.name = name;
    }

    public int getDaysDuration() {
        return daysDuration;
    }

    public void setDaysDuration(int daysDuration) {
        this.daysDuration = daysDuration;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public ArrayList<Food> getAllowedFood() {
        return allowedFood;
    }

    public void setAllowedFood(ArrayList<Food> allowedFood) {
        this.allowedFood = allowedFood;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public String writeDuration(Diet d) {
        String result = "";

        int days = daysDuration;
        int years = days / 365;
        int balance = days % 365;
        int months = balance / 30;
        days = balance % 30;
        result =  "This " + d.getName() + " lasts for " + years + " years, " + months + " months and " + days + " days";
        return result;
    }

    //Baserer seg på at toString-metoden i Food-klassen er overridet

    public String writeAllowedFood(Diet d) {
        String result = "";
        for (int i = 0; i < getAllowedFood().size(); i++) {
            result = "The following food is allowed in this " + d.getName() +": "+ allowedFood;
        }
        return result;
    }


/*    public String writeAllowedFood() {
        String result = "";
        for (int i = 0; i < getAllowedFood().size(); ++i) {
            result += getAllowedFood().get(i).toString() + result;
        }
        return result;
    }*/
}
