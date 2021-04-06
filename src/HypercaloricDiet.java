public class HypercaloricDiet extends Diet {

    private float maxWeightKg;
    private float minCaloriesPerDay;

    public HypercaloricDiet(int daysDuration, String purpose, Food[] allowedFood, boolean isVegan, float maxWeightKg, float minCaloriesPerDay) {
        super(daysDuration, purpose, allowedFood, isVegan);
        this.maxWeightKg = maxWeightKg;
        this.minCaloriesPerDay = minCaloriesPerDay;
    }

    public float getMaxWeightKg() {
        return maxWeightKg;
    }
    public void setMaxWeightKg(float maxWeightKg) {
        this.maxWeightKg = maxWeightKg;
    }

    public float getMinCaloriesPerDay() {
        return minCaloriesPerDay;
    }
    public void setMinCaloriesPerDay(float minCaloriesPerDay) {
        this.minCaloriesPerDay = minCaloriesPerDay;
    }

    @Override
    public String writeDuration() {
        int days = getDaysDuration();

        int years = days / 365;
        int weeks = (days % 365) / 7;
        days = (days % 365) % 7;

        return "The hypercaloric diet lasts for " + years + " year/s, " + weeks + " week/s, and " + days + " day/s.";
    }

    @Override
    public String writeAllowedFood() {
        return null;
    }
}
