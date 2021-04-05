public abstract class Diet {
    private int daysDuration;
    private String purpose;
    private Food[] allowedFood;
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

    public Food[] getAllowedFood() {
        return allowedFood;
    }

    public void setAllowedFood(Food[] allowedFood) {
        this.allowedFood = allowedFood;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public String writeDuration() {
        return "";
    }

    public String writeAllowedFood() {
        return "";
    }

}
