import java.util.Arrays;

public abstract class Diet {
    private int daysDuration;
    private String purpose;
<<<<<<< HEAD
    private Food[] allowedFood;
=======
    private ArrayList<Food> allowedFood;
>>>>>>> origin/main
    private boolean isVegan;

    public Diet(int daysDuration, String purpose, Food[] allowedFood, boolean isVegan) {
        this.daysDuration = daysDuration;
        this.purpose = purpose;
        this.allowedFood = allowedFood;
        this.isVegan = isVegan;
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

<<<<<<< HEAD
    public Food[] getAllowedFood() {
        return allowedFood;
    }

    public void setAllowedFood(Food[] allowedFood) {
=======
    public ArrayList<Food> getAllowedFood() {
        return allowedFood;
    }

    public void setAllowedFood(ArrayList<Food> allowedFood) {
>>>>>>> origin/main
        this.allowedFood = allowedFood;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public String writeDuration() {
        int days = getDaysDuration();
        int years = days / 365;
        int weeks = (days % 365) / 7;
        days = (days % 365) % 7;

        return "This diet lasts for: " + "\r\n" + years + " year/s" + "\r\n" +
                weeks + " week/s" + "\r\n" + days + " day/s";
    }
<<<<<<< HEAD

    //Baserer seg på at toString-metoden i Food-klassen er overridet
    public String writeAllowedFood() {
        String result = "";
        for (int i = 0; i < getAllowedFood().length; ++i) {
            result += getAllowedFood()[i].toString() + "\r\n";
        }
        return result;
    }

=======
>>>>>>> origin/main
}
