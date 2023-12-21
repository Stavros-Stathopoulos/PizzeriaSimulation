package pizza;

import java.util.LinkedList;

public class Pizza {

    private int pizzaPrice;
    private final LinkedList<ExtraIngrediens> ingredients;
    @SuppressWarnings("FieldCanBeLocal")
    private final int pizzaBasePrice = 5;

    public Pizza(LinkedList<ExtraIngrediens> extraIngredients) {
        this.ingredients = new LinkedList<>();
        this.ingredients.add(ExtraIngrediens.tomatoSause);
        this.ingredients.add(ExtraIngrediens.cheese);

        addIngredients(extraIngredients);
        this.pizzaPrice = calculatePizzaPrice();

    }


    public void addIngredients(LinkedList<ExtraIngrediens> ExtraIngredients) {
        if (ExtraIngredients == null) {
            return;
        }
        this.ingredients.addAll(ExtraIngredients);
    }
    public int getPizzaPrice() {
        return this.pizzaPrice;
    }

    private int calculatePizzaPrice() {
        pizzaPrice = pizzaBasePrice;
        int counter = 0;
        for (ExtraIngrediens ingredient : this.ingredients) {
            if (ingredient.equals(ExtraIngrediens.cheese) && counter < 2) {
                counter += 1;
            }
            else if (ingredient.equals(ExtraIngrediens.tomatoSause) && counter < 2) {
                counter += 1;
            }
            else {
                //System.out.println("Extra ingredient: " + ingredient.toString() + " added to pizza!");
                pizzaPrice += 2;
            }
        }
        //System.out.println("Pizza price: " + pizzaPrice);

        return pizzaPrice;
    }



    public boolean printPizza() {
        System.out.println("Pizza\t" + this);
        System.out.println("Pizza Ingredients: ");
        System.out.println(this.ingredients.toString());

        return false;
    }
}
