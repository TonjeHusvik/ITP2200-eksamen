import java.util.ArrayList;

public class Person {
    private Food food;
    private Food[] allergies;
    private Diet diet;
    private float weight;

    public Person(Food food, Food[] allergies, Diet diet, float weight) {
        this.food = food;
        this.allergies = allergies;
        this.diet = diet;
        this.weight = weight;
    }

    public Person(Food food) {
        this.food = food;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
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
}
