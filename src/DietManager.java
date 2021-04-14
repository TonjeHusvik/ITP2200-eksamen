public class DietManager {

    public boolean areCompatible(Person p, Diet d) throws IllegalArgumentException {
        if (p.getFavouriteFood().isVegan() && d.isVegan()) {
            return true;
        } else if (true) {

        }
        throw new IllegalArgumentException("The diet and the person is NOT compatible");
    }

    public Diet randomDiet(Person p, Food f[]) {

        return null;
    }
}
