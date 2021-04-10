import org.junit.Test;

public class PersonTest {
    public void addPerson(){
        //Person jon = new Person("Meatloaf");
    }

    // TODO a. If their favourite food is nonvegan, they cannot follow a vegan diet.
    @Test
    public void requirement2_a(Person person) {
        if (!person.getFood().isVegan()){
            return false;
        }

    }
}
