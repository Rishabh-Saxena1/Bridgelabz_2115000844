import java.util.*;

// Interface for all meal plans
interface MealPlan {
    String getMealType();
}

// Meal Plan Categories
class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto Meal";
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High-Protein Meal";
    }
}

class Meal<T extends MealPlan> {
    private String mealName;
    private T mealType;

    public Meal(String mealName, T mealType) {
        this.mealName = mealName;
        this.mealType = mealType;
    }

    public String getMealName() {
        return mealName;
    }

    public T getMealType() {
        return mealType;
    }

    public String toString() {
        return mealName + " - " + mealType.getMealType();
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> void generateMealPlan(T mealPlan) {
        System.out.println("Generating Meal Plan: " + mealPlan.getMealType());
    }
}

public class PersonalizedMealPlan {
    public static void main(String[] args) {
        VegetarianMeal vegMeal = new VegetarianMeal();
        VeganMeal veganMeal = new VeganMeal();
        KetoMeal ketoMeal = new KetoMeal();
        HighProteinMeal proteinMeal = new HighProteinMeal();

        Meal<VegetarianMeal> meal1 = new Meal<>("Paneer Makhani", vegMeal);
        Meal<VeganMeal> meal2 = new Meal<>("Quinoa", veganMeal);
        Meal<KetoMeal> meal3 = new Meal<>("Peanut butter chicken", ketoMeal);
        Meal<HighProteinMeal> meal4 = new Meal<>("Eggs", proteinMeal);

        System.out.println(meal1);
        System.out.println(meal2);
        System.out.println(meal3);
        System.out.println(meal4);

        MealPlanGenerator.generateMealPlan(vegMeal);
        MealPlanGenerator.generateMealPlan(veganMeal);
        MealPlanGenerator.generateMealPlan(ketoMeal);
        MealPlanGenerator.generateMealPlan(proteinMeal);
    }
}
