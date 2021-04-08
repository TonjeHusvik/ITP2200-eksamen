public class DietManager {

    public boolean areCompatible(Person p, Diet d) {
        //Given a Person and a Diet, return true if they are compatible, false otherwise.

        // Sammenligner Person og Diet
        return p.getDiet().equals(d.getAllowedFood());
    }

    public Diet randomDiet(Person p, Food f[]) {
        return null;

    }
}
