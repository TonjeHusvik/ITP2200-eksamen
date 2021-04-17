import java.util.ArrayList;

public class Person {
    private Food favouriteFood;
    private ArrayList<Food> allergies;
    private Diet diet;
    private float weight;

    public Person(Food favouriteFood, ArrayList<Food> allergies, Diet diet, float weight) {
        this.favouriteFood = favouriteFood;
        this.allergies = allergies;
        this.diet = diet;
        this.weight = weight;
    }

    public Person(Food favouriteFood, ArrayList<Food> allergies, float weight) {
        this.favouriteFood = favouriteFood;
        this.allergies = allergies;
        this.weight = weight;
    }

    public Person(Food favouriteFood, Diet diet) {
        this.diet = diet;
        this.favouriteFood = favouriteFood;
    }

    public Person(Diet diet, float weight) {
        this.diet = diet;
        this.weight = weight;
    }

    public Person(ArrayList<Food> allergies) {
        this.allergies = allergies;
    }

    public Food getFavouriteFood() {
        return favouriteFood;
    }

    public ArrayList<Food> getAllergies() {
        return allergies;
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

    public boolean personRestriction2a() throws IllegalArgumentException {
        if (!getFavouriteFood().isVegan() && diet.isVegan()) {
            System.out.println("An illegal argument exception is thrown as expected, because favorite food is not vegan.");
            throw new IllegalArgumentException();
        }
        System.out.println("This person has a vegan favorite food, and can therefore follow a vegan diet.");
        return getDiet().isVegan();
    }

    public boolean personRestriction2b(Person p, Diet d) {
        if(p.getAllergies().size() >= (d.getAllowedFood().size()/2)) {
            System.out.println("This person is allergic to the following foods in the diet: "
                    + p.getAllergies().toString() + "\r\n" + "An exception is thrown as expected.");
            throw new IllegalArgumentException();
        }
        System.out.println("The person can follow this diet.");
        return true;
    }

    public boolean personRestriction2c_1(VeganDiet d) throws IllegalArgumentException {

        if(getWeight() < d.getMinWeightKg()){
            throw new IllegalArgumentException("ERROR! You cannot follow a vegan diet if you weigh less than the minimum weight requirement");
        }
        else{
            return true;
        }
    }

    public boolean personRestriction2c_2(LowCarbDiet d) throws IllegalArgumentException {

        if(getWeight() < d.getMinWeightKg()){
            throw new IllegalArgumentException("ERROR! You cannot follow a lowcarb diet if you weigh less than the minimum weight requirement");
        }
        else{
            return true;
        }
    }

    public boolean personRestriction2_d(HypercaloricDiet h) throws IllegalArgumentException {
        if(getWeight() > h.getMaxWeightKg()){
            throw new IllegalArgumentException("ERROR! You cannot follow a hypercaloric diet if you weigh more than the maximum weight requirement");

        }else{
            System.out.println("Can follow this diet.");
            return true;
        }
    }
}
