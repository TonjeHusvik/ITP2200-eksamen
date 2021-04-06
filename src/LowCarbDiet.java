public class LowCarbDiet extends Diet {

    private float minWeightKg;

    public LowCarbDiet(int daysDuration, String purpose, Food[] allowedFood, boolean isVegan, float minWeightKg) {
        super(daysDuration, purpose, allowedFood, isVegan);
        this.minWeightKg = minWeightKg;
    }

    public float getMinWeightKg() {
        return minWeightKg;
    }
    public void setMinWeightKg(float minWeightKg) {
        this.minWeightKg = minWeightKg;
    }

    @Override
    public String writeDuration() {
        int days = getDaysDuration();

        int years = days / 365;
        int weeks = (days % 365) / 7;
        days = (days % 365) % 7;

        return "The low carb diet lasts for " + years + " year/s, " + weeks + " week/s, and " + days + " day/s.";
    }

    @Override
    public String writeAllowedFood() {
        return null;
    }
}
