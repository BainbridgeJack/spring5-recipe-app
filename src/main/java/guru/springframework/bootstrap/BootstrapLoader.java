package guru.springframework.bootstrap;

import guru.springframework.enumerations.Difficulty;
import guru.springframework.model.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class BootstrapLoader  implements CommandLineRunner {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public BootstrapLoader(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Initialize our Recipe list
        Set<Recipe> recipeList = new HashSet<>();

        /**
         * Get optionals for our UOM.
         */
        Optional<UnitOfMeasure> tablespoonOptional = unitOfMeasureRepository.findByUnitOfMeasure("Tablespoon");
        Optional<UnitOfMeasure> teaspoonOptional = unitOfMeasureRepository.findByUnitOfMeasure("Teaspoon");
        Optional<UnitOfMeasure> cupOptional = unitOfMeasureRepository.findByUnitOfMeasure("Cup");
        Optional<UnitOfMeasure> pintOptional = unitOfMeasureRepository.findByUnitOfMeasure("Pint");
        Optional<UnitOfMeasure> pinchOptional = unitOfMeasureRepository.findByUnitOfMeasure("Pinch");
        Optional<UnitOfMeasure> eachOptional = unitOfMeasureRepository.findByUnitOfMeasure("Each");
        Optional<UnitOfMeasure> ounceOptional = unitOfMeasureRepository.findByUnitOfMeasure("Ounce");
        Optional<UnitOfMeasure> dashOptional = unitOfMeasureRepository.findByUnitOfMeasure("Dash");

        // Get the object
        UnitOfMeasure tablespoon = tablespoonOptional.get();
        UnitOfMeasure teaspoon = teaspoonOptional.get();
        UnitOfMeasure cup = cupOptional.get();
        UnitOfMeasure pint = pintOptional.get();
        UnitOfMeasure pinch = pinchOptional.get();
        UnitOfMeasure each = eachOptional.get();
        UnitOfMeasure ounce = ounceOptional.get();
        UnitOfMeasure dash = dashOptional.get();

        /**
         * Get optional Categories for our Recipes.
         */
        Optional<Category> mexicanOptional = categoryRepository.findByCategoryDescription("Mexican");
        Category mexicanCategory = mexicanOptional.get();

        // Spicy Grilled Tacos
        Recipe grilledChickenTacos = new Recipe();
        Set<Ingredient> grilledChickenIngredientList = new HashSet<>();

        Ingredient anchoChiliPowder = new Ingredient("Ancho Chili Powder", new BigDecimal(2), tablespoon);
        Ingredient driedOregano = new Ingredient("Dried Oregano", new BigDecimal(1), teaspoon);
        Ingredient driedCumin = new Ingredient("Dried Cumin", new BigDecimal(1), teaspoon);
        Ingredient sugar = new Ingredient("Sugar", new BigDecimal(1), teaspoon);
        Ingredient kosherSalt = new Ingredient("Kosher Salt", new BigDecimal(0.5), teaspoon);
        Ingredient garlicClove = new Ingredient("Clove of Garlic", new BigDecimal(1), each);
        Ingredient orangeZest = new Ingredient("Finely Grated Orange Zest", new BigDecimal(1), tablespoon);
        Ingredient freshOJ = new Ingredient("Freshly Squeezed Orange Juice", new BigDecimal(3), tablespoon);
        Ingredient oliveOil = new Ingredient("Olive Oil", new BigDecimal(2), tablespoon);
        Ingredient skinlessBonelessChickenThighs = new Ingredient("Boneless & Skinless Chicken Thighs", new BigDecimal(2), tablespoon);

        grilledChickenTacos.addIngredient(anchoChiliPowder);
        grilledChickenTacos.addIngredient(driedOregano);
        grilledChickenTacos.addIngredient(driedCumin);
        grilledChickenTacos.addIngredient(sugar);
        grilledChickenTacos.addIngredient(kosherSalt);
        grilledChickenTacos.addIngredient(garlicClove);
        grilledChickenTacos.addIngredient(orangeZest);
        grilledChickenTacos.addIngredient(freshOJ);
        grilledChickenTacos.addIngredient(oliveOil);
        grilledChickenTacos.addIngredient(skinlessBonelessChickenThighs);


        // To Serve Section:
        Ingredient cornTortillas = new Ingredient("Small Corn Tortillas", new BigDecimal(8), each);
        Ingredient babyArugala = new Ingredient("Cup of Baby Arugala", new BigDecimal(3), ounce);
        Ingredient avocado = new Ingredient("Sliced Ripe Avocado", new BigDecimal(2), each);
        Ingredient radish = new Ingredient("Sliced Radish", new BigDecimal(4), each);
        Ingredient cherryTomatoes = new Ingredient("Cherry Tomatoes (halved)", new BigDecimal(0.5), pint);
        Ingredient cilantro = new Ingredient("Cilantro", new BigDecimal(1), each);
        Ingredient sourCream = new Ingredient("Sour Cream", new BigDecimal(0.5), cup);
        Ingredient milk = new Ingredient("Milk", new BigDecimal(0.25), cup);
        Ingredient lime = new Ingredient("Lime", new BigDecimal(1), each);

        grilledChickenTacos.addIngredient(cornTortillas);
        grilledChickenTacos.addIngredient(babyArugala);
        grilledChickenTacos.addIngredient(avocado);
        grilledChickenTacos.addIngredient(radish);
        grilledChickenTacos.addIngredient(cherryTomatoes);
        grilledChickenTacos.addIngredient(cilantro);
        grilledChickenTacos.addIngredient(sourCream);
        grilledChickenTacos.addIngredient(milk);
        grilledChickenTacos.addIngredient(lime);

        grilledChickenIngredientList.add(anchoChiliPowder);
        grilledChickenIngredientList.add(driedOregano);
        grilledChickenIngredientList.add(driedCumin);
        grilledChickenIngredientList.add(sugar);
        grilledChickenIngredientList.add(kosherSalt);
        grilledChickenIngredientList.add(garlicClove);
        grilledChickenIngredientList.add(orangeZest);
        grilledChickenIngredientList.add(freshOJ);
        grilledChickenIngredientList.add(oliveOil);
        grilledChickenIngredientList.add(skinlessBonelessChickenThighs);
        grilledChickenIngredientList.add(cornTortillas);
        grilledChickenIngredientList.add(babyArugala);
        grilledChickenIngredientList.add(avocado);
        grilledChickenIngredientList.add(radish);
        grilledChickenIngredientList.add(cherryTomatoes);
        grilledChickenIngredientList.add(cilantro);
        grilledChickenIngredientList.add(sourCream);
        grilledChickenIngredientList.add(milk);
        grilledChickenIngredientList.add(lime);

        grilledChickenTacos.setDescription("Placeholder Description for Chicken Tacos");
        grilledChickenTacos.setPrepTime(20);
        grilledChickenTacos.setCookTime(15);
        grilledChickenTacos.setServings(6);
        grilledChickenTacos.setSource("Simply Recipes");
        grilledChickenTacos.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        grilledChickenTacos.setDirections("Prepare the grill:\n" +
                "Prepare either a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "Make the marinade and coat the chicken:\n" +
                "In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "Spicy Grilled Chicken Tacos\n" +
                "Grill the chicken:\n" +
                "Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165°F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "Thin the sour cream with milk:\n" +
                "Stir together the sour cream and milk to thin out the sour cream to make it easy to drizzle.\n" +
                "\n" +
                "Assemble the tacos:\n" +
                "Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "Warm the tortillas:\n" +
                "Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.");
        grilledChickenTacos.setDifficulty(Difficulty.MODERATE);
        grilledChickenTacos.setIngredient(grilledChickenIngredientList);

        Notes grilledChickenTacoNotes = new Notes();
        grilledChickenTacoNotes.setNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "\n" +
                "Today's tacos are more purposeful a deliberate meal instead of a secretive midnight snack!\n" +
                "\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!");

        grilledChickenTacos.getCategories().add(mexicanCategory);

        grilledChickenTacos.setNotes(grilledChickenTacoNotes);
        grilledChickenTacoNotes.setRecipe(grilledChickenTacos);

        recipeList.add(grilledChickenTacos);

        // Best Guacamole
        Recipe bestGuacamole = new Recipe();
        bestGuacamole.setDescription("Placeholder Description for Perfect Guacamole");
        bestGuacamole.setPrepTime(10);
        bestGuacamole.setCookTime(0);
        bestGuacamole.setServings(4);
        bestGuacamole.setSource("Simply Recipes");
        bestGuacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        bestGuacamole.setDirections("Cut the avocado:\n" +
                "Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "How to make guacamole - scoring avocado\n" +
                "Mash the avocado flesh:\n" +
                "Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "How to make guacamole - smashing avocado with fork\n" +
                "Add the remaining ingredients to taste:\n" +
                "Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chilis. Chili peppers vary individually in their spiciness. So, start with a half of one chili pepper and add more to the guacamole to your desired degree of heat.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "Serve immediately:\n" +
                "If making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.)\n" +
                "\n" +
                "Garnish with slices of red radish or jigama strips. Serve with your choice of store-bought tortilla chips or make your own homemade tortilla chips.\n" +
                "\n" +
                "Refrigerate leftover guacamole up to 3 days.\n" +
                "\n" +
                "Note: Chilling tomatoes hurts their flavor. So, if you want to add chopped tomato to your guacamole, add it just before serving.");
        bestGuacamole.setDifficulty(Difficulty.EASY);

        kosherSalt.setAmount(new BigDecimal(0.25));
        kosherSalt.setRecipe(bestGuacamole);

        cilantro.setAmount(new BigDecimal(2));
        cilantro.setRecipe(bestGuacamole);

        Ingredient redOnion = new Ingredient("Minced Red Onion", new BigDecimal(2), each);
        Ingredient serrano = new Ingredient("Serrano Chilis, Stems and Seeds Removed, Minced", new BigDecimal(2), each);
        Ingredient groundBlackPepper = new Ingredient("Ground Black Pepper", new BigDecimal(1), dash);
        Ingredient tomato = new Ingredient("Ripe Tomato (chopped)", new BigDecimal(0.5), each);

        bestGuacamole.addIngredient(avocado);
        bestGuacamole.addIngredient(kosherSalt);
        bestGuacamole.addIngredient(cilantro);
        bestGuacamole.addIngredient(redOnion);
        bestGuacamole.addIngredient(serrano);
        bestGuacamole.addIngredient(groundBlackPepper);
        bestGuacamole.addIngredient(tomato);

        Set<Ingredient> bestGuacamolegrilledChickenIngredientList = new HashSet<>();
        bestGuacamolegrilledChickenIngredientList.add(avocado);
        bestGuacamolegrilledChickenIngredientList.add(redOnion);
        bestGuacamolegrilledChickenIngredientList.add(serrano);
        bestGuacamolegrilledChickenIngredientList.add(groundBlackPepper);
        bestGuacamolegrilledChickenIngredientList.add(tomato);
        bestGuacamolegrilledChickenIngredientList.add(kosherSalt);
        bestGuacamolegrilledChickenIngredientList.add(cilantro);
        bestGuacamole.setIngredient(bestGuacamolegrilledChickenIngredientList);

        Notes bestGuacamoleNotes = new Notes();
        bestGuacamoleNotes.setNotes("Guacamole! Did you know that over 2 billion pounds of avocados are consumed each year in the U.S.? (Google it.) That's over 7 pounds per person. I'm guessing that most of those avocados go into what has become America's favorite dip: guacamole.\n" +
                "\n" +
                "Guacamole: A Classic Mexican Dish\n" +
                "The word \"guacamole\" and the dip, are both originally from Mexico, where avocados have been cultivated for thousands of years. The name is derived from two Aztec Nahuatl words—ahuacatl (avocado) and molli (sauce).");

        bestGuacamole.getCategories().add(mexicanCategory);

        bestGuacamoleNotes.setRecipe(bestGuacamole);
        bestGuacamole.setNotes(bestGuacamoleNotes);

        recipeList.add(bestGuacamole);

        recipeRepository.saveAll(recipeList);
    }
}
