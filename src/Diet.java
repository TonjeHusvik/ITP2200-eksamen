import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Diet {
    private int daysDuration;
    private String purpose;
    private ArrayList<Food> allowedFood;
    private boolean isVegan;
    private String name;

    public Diet(String name, int daysDuration, String purpose, ArrayList<Food> allowedFood, boolean isVegan) {
        this.daysDuration = daysDuration;
        this.purpose = purpose;
        this.allowedFood = allowedFood;
        this.isVegan = isVegan;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDaysDuration() {
        return daysDuration;
    }

    public void setDaysDuration(int daysDuration) {
        this.daysDuration = daysDuration;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public ArrayList<Food> getAllowedFood() {
        return allowedFood;
    }

    public void setAllowedFood(ArrayList<Food> allowedFood) {
        this.allowedFood = allowedFood;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }


    public String writeDuration(Diet d) {
        String result = "";
        int days = d.daysDuration;
        int years = days / 365;
        int equivalence = days % 365;
        int months = equivalence / 30;
        days = equivalence % 30;
        result = "This " + d.getName() + " lasts for " + years + " years, " + months + " months and " + days + " days";
        return result;
    }

    public String writeDurationInDays(Diet d) {
        String result = "";
        int days = d.daysDuration;
        result = "This " + d.getName() + " lasts for " + days + " days";
        return result;
    }

    public String writeDurationInMonths(Diet d) {
        String result = "";
        int months = d.daysDuration / 30;
        result = "This " + d.getName() + " lasts for " + months + " months";

        if (d.daysDuration >= 30) {
            return result;
        } else
        throw new IllegalArgumentException("ERROR, the input is less than 1 month");
    }

    public String writeDurationInYears(Diet d) {
        String result = "";
        int years = d.daysDuration / 365;
        result = "This " + d.getName() + " lasts for " + years + " years";

        if (d.daysDuration >= 365) {
            return result;
        } else
            throw new IllegalArgumentException("ERROR, the input is less than 1 year");
    }

    public String writeAllowedFood(Diet d) {
        String result = "";

        result = "The following food is allowed in this " + d.getName() +": "+ allowedFood;
        return result;
    }
    /* Rikke - Denne sjekker kun at dietten er vegan
    * Her må vi lage tre tester
    * d.isV = t & f.isV = t
    * d.isV = f & f.isV = t
    * d.isV = t & f.isV = f
    * d.isV = f & f.isV = f
    */
    public void dietRestriction1a(Diet d) {

        for (Food f:d.getAllowedFood()) {
            if (d.isVegan && f.isVegan()){
                System.out.println("True, this diet is vegan");
            }else{
                System.out.println("False, this diet is not vegan");
            }
        }

    }
    /*Tonje - If a diet contains only vegan food, it is considered vegan, even if it is not a
    VeganDiet (e.g., it could be a LowCarbDiet).

    Denne sjekker at dietten inneholder vegansk mat og skal sjekke at d.isVegan blir til true

    Teste en diett hvor alt er vegan
    Teste en diett hvor en eller fler ikke er vegan
    Kanskje fler tester?

     */
    public boolean dietRestriction1b() {
        for (Food f : getAllowedFood()) {
            if (f.isVegan()) {
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    /* Joachim - A VeganDiet cannot contain non-vegan food.
     *
     * Her tester vi at en diett ikke kan kalle seg vegansk, hvis den i sitt allowed food array inneholder et non vegan objekt
     * En test hvor alle f.isvegan food objekter er true
     * En test med en eller fler food objekter som ikke er isVegan
     */
    public boolean veganDietRestriction1c() throws IllegalArgumentException {
        for (Food f : getAllowedFood()) {
            if (!f.isVegan()) {
                isVegan = false;
                System.out.println("This is an illegal argument being thrown as expected, " +
                                   "because this diet contains non-vegan food.");
                throw new IllegalArgumentException();
            }
        }
        System.out.println("This diet is vegan");
        return true;
    }
    /* Rune - The preferred meat in a FlexitarianDiet MUST be non-vegan food of protein type.
     *
     * EN hvor begge prefferdmeat ikke er vegan OG foodType er protein
     * En hvor prefferdMeat er vegan OG foodType ikke er protein
     * En hvor PF er vegan Og FT er protein
     * En hvor PF ikke er vegan OG FT ikke er protein
     **
     */

    public static String flexDietRestriction1d(FlexitarianDiet d, Food f) {
        if (!d.getPreferredMeat().isVegan() && f.getType() == FoodType.Protein) {
            return "The preferred meat in FlexitarianDiet is not vegan and is of FoodType Protein, ENJOY! =)";
        } else {
            throw new IllegalArgumentException("ERROR! The preferred meat in a FlexitarianDiet MUST be non-vegan of protein type.");
        }
    }


    /*Julie - The maximum carb-type foods that can be included in a LowCarbDiet is two.
     * Her sjekker vi at man ikke kan ha mer enn to food objekter med FoodType.Carb hvis man vil ha en lowcarb diet
     *
     * en test med mer enn 2 FT carb
     * en test med 2 eller mindre FT carb
     * ***/

    public boolean lowCarbRestriction1e() throws IllegalArgumentException {
        int i = 0;
        for (Food f : getAllowedFood()) {
            if (f.getType().equals(FoodType.Carb)) {
                i = i + 1;
                if (i >= 3) {
                    throw new IllegalArgumentException("You can not have more than two types of carb in a lowcarb diet");
                }
            }
        }
        return true;
    }

    //FIXME Joachim
/*    //Test både med allergi 50% eller mer, og under
    public boolean personRestriction2b(Person p, Diet d) throws IllegalArgumentException {
        d.getAllowedFood().retainAll(p.getAllergies());
        if(p.getAllergies().size() >= (d.getAllowedFood().size()/2)) {
            throw new IllegalArgumentException();
        }
        return true;
    }*/

    public boolean dietRestriction1a() {
        Iterator var1 = this.getAllowedFood().iterator();
        if (var1.hasNext()) {
            Food f = (Food)var1.next();
            if (f.isVegan()) {
                System.out.println("True, this diet is vegan");
                return true;
            } else {
                System.out.println("False, this diet is not vegan");
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean dietRestriction1aTest(Diet d) {
        Iterator var2 = this.getAllowedFood().iterator();

        Food f;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            f = (Food) var2.next();
        } while (!d.isVegan || !f.isVegan());

        return true;
    }
}




