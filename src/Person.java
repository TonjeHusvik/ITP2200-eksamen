import java.time.Period;

public class Person {
    private Food favouriteFood;
    private Food[] allergies;
    private Diet diet;
    private float weight;

    public Person(Food favouriteFood, Food[] allergies, Diet diet, float weight) {
        this.favouriteFood = favouriteFood;
        this.allergies = allergies;
        this.diet = diet;
        this.weight = weight;
    }

    public Person(Food favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    public Person(Food favouriteFood, Diet diet) {
        this.diet = diet;
        this.favouriteFood = favouriteFood;
    }

    public Person(Diet diet, float weight) {
        this.diet = diet;
        this.weight = weight;
    }

    public Person (Diet diet){
        this.diet = diet;
    }


    public Food getFavouriteFood() {
        return favouriteFood;
    }

    public void setFavouriteFood(Food favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    public Food[] getAllergies() {
        return allergies;
    }

    public void setAllergies(Food[] allergies) {
        this.allergies = allergies;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    //If their favorite food is non-vegan, they cannot follow a VeganDiet
    public boolean personRestriction2a() {
        if (!getFavouriteFood().isVegan()) {
            return !getDiet().isVegan();
        }
        return getDiet().isVegan();
    }

    //They cannot follow a diet if they are allergic to 50% or more of the food allowed by the diet.
    public void personRestriction2b() {

    }

    //If they weigh less than the limit set by the VeganDiet or the LowCarbDiet,
    //they cannot be following these diets (for health reasons).
    public void personRestriction2c() {

    }

    //If they weigh more than the limit set by the HypercaloricDiet,
    //they cannot be following this diet (for health reasons).
    public void personRestriction2d() {

    }
}
