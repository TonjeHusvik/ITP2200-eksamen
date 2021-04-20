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

    //Removed setDiet because it's not used in program or tests

    public float getWeight() {
        return weight;
    }

    public boolean favoriteFoodVeganAndDietVeganOrNot() throws IllegalArgumentException {
        if (!getFavouriteFood().isVegan() && diet.isVegan()) {
            System.out.println("An illegal argument exception is thrown as expected, because favorite food is not vegan.");
            throw new IllegalArgumentException();
        }
        System.out.println("This person has a vegan favorite food, and can therefore follow a vegan diet.");
        return getDiet().isVegan();
    }

    public boolean personAllergicToHalfOrMoreFoodsInDiet(Person p, Diet d) {
        if(p.getAllergies().size() >= (d.getAllowedFood().size()/2)) {
            System.out.println("This person is allergic to the following foods in the diet: "
                    + p.getAllergies().toString() + "\r\n" + "An exception is thrown as expected.");
            throw new IllegalArgumentException();
        }
        System.out.println("The person can follow this diet.");
        return true;
    }

    public void personAllergiesAndLowCarb(Person p, Diet d) {
        FoodContainerReq_2 fc = new FoodContainerReq_2();
        fc.allowedInDietAndAllergiesTooMany().get(1).retainAll(fc.allowedInDietAndAllergiesTooMany().get(0));
        if(fc.allowedInDietAndAllergiesTooMany().get(1).size() >= (fc.allowedInDietAndAllergiesTooMany().get(0).size()/2)) {
            System.out.println("This person is allergic to the following foods in the diet: "
                    + p.getAllergies().toString() + "\r\n" + "An exception is thrown as expected.");
            throw new IllegalArgumentException();
        }
        System.out.println("The person can follow this diet.");
    }

    public boolean checkAllergiesAgainstDietFoods(Person p, Diet d) {
        p.getAllergies().retainAll(d.getAllowedFood());
        if(p.getAllergies().size() >= (d.getAllowedFood().size()/2)) {
            System.out.println("This person is allergic to the following foods in the diet: "
                    + p.getAllergies().toString() + "\r\n" + "An exception is thrown as expected.");
            throw new IllegalArgumentException();
        }
        System.out.println("The person can follow this diet.");
        return true;
    }

    public boolean weightLessThanVeganDietMinimumOrNot(VeganDiet d) throws IllegalArgumentException {
        if(getWeight() < d.getMinWeightKg()){
            throw new IllegalArgumentException("ERROR! You cannot follow a vegan diet if you weigh less than the minimum weight requirement");
        }
        else{
            return true;
        }
    }

    public boolean weightLessThanLowCarbDietMinimumOrNot(LowCarbDiet d) throws IllegalArgumentException {
        if(getWeight() < d.getMinWeightKg()){
            throw new IllegalArgumentException("ERROR! You cannot follow a lowcarb diet if you weigh less than the minimum weight requirement");
        }
        else{
            return true;
        }
    }

    public boolean weightMoreThanMaximumOrNot(HypercaloricDiet h) throws IllegalArgumentException {
        if(getWeight() > h.getMaxWeightKg()){
            throw new IllegalArgumentException("ERROR! You cannot follow a hypercaloric diet if you weigh more than the maximum weight requirement");

        }else{
            System.out.println("Can follow this diet.");
            return true;
        }
    }

}
