public class FlexitarianDiet extends Diet {

    private float maxMeatGramsPerWeek;
    private Food preferredMeat;

    public FlexitarianDiet(int daysDuration, String purpose, Food[] allowedFood, boolean isVegan, float maxMeatGramsPerWeek, Food preferredMeat) {
        super(daysDuration, purpose, allowedFood, isVegan);
        this.maxMeatGramsPerWeek = maxMeatGramsPerWeek;
        this.preferredMeat = preferredMeat;
    }

    public float getMaxMeatGramsPerWeek() {
        return maxMeatGramsPerWeek;
    }
    public void setMaxMeatGramsPerWeek(float maxMeatGramsPerWeek) {
        this.maxMeatGramsPerWeek = maxMeatGramsPerWeek;
    }

    public Food getPreferredMeat() {
        return preferredMeat;
    }
    public void setPreferredMeat(Food preferredMeat) {
        this.preferredMeat = preferredMeat;
    }

    @Override
    public String writeDuration() {
        int days = getDaysDuration();

        int years = days / 365;
        int weeks = (days % 365) / 7;
        days = (days % 365) % 7;

        return "The flexitarian diet lasts for " + years + " year/s, " + weeks + " week/s, and " + days + " day/s.";
    }

    @Override
    public String writeAllowedFood() {
        return null;
    }
}
