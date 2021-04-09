public class DietManager {

    public boolean areCompatible(Person p, Diet d) {
        //Given a Person and a Diet, return true if they are compatible, false otherwise.
        return p.getDiet().equals(d.getAllowedFood()); //Sammenligner Person og Diet
    }

<<<<<<< HEAD
    public Diet randomDiet(Person p, Food[] f) {
        return null;
=======
    public Diet randomDiet(Person p, Food f[]) {
>>>>>>> origin/main

        return null;
    }
}
