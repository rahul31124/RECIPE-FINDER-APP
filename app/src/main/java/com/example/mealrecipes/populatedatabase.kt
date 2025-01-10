package com.example.mealrecipes

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun populateDatabase(context: Context, viewModel: CategoryViewModel ,foodViewModel: FoodViewModel) {

    withContext(Dispatchers.IO) {
        if (viewModel.isDatabasePopulated()) {
            return@withContext
        }
    }

    val categories = listOf(
        Category(
            cname = "Chicken",
            imageUrl = "https://img.freepik.com/free-vector/realistic-fried-chicken-with-vegetable-garnish-plate-vector-illustration_1284-78963.jpg?t=st=1720254391~exp=1720257991~hmac=383fc739f6f0bc64ef5662acd0b8c09b4329b6b9eec57b738309182e0927df79&w=996"
        ),
        Category(
            cname = "Breakfast",
            imageUrl = "https://img.freepik.com/free-vector/breakfast-set-white-background_1308-98707.jpg?t=st=1720254346~exp=1720257946~hmac=84de90e758542b34051723d792b86c40a707b1aadec91ebb41415a3c7f025248&w=826"
        ),
        Category(
            cname = "Dessert",
            imageUrl = "https://img.freepik.com/free-vector/pastry-set-cartoon-style-food-cake-sweet-bakery-tasty-snack-with-cream-vector-illustration_1284-42437.jpg?t=st=1720253448~exp=1720257048~hmac=5269e980a504af7bffabdd5af13a2d36b48484b4c8254406662d721255caf4a9&w=740"
        ),
        Category(
            cname = "Drinks",
            imageUrl = "https://img.freepik.com/free-vector/vector-set-popular-cocktails-shots-cuba-libre-blue-lagoon-mojito-margarita-pina-colada-tequila-sunrise-cosmopolitan-martini-isolated-white-background_1284-45423.jpg?t=st=1720254267~exp=1720257867~hmac=f37a5b2aed4703999551b4bcc85c204b5be0b41331524aaa126569118433f812&w=740"
        ),
        Category(
            cname = "Vegan",
            imageUrl = "https://img.freepik.com/free-vector/leaves-circle-green_78370-1827.jpg?t=st=1720254474~exp=1720258074~hmac=83f62451b8cb4e64295d351e62367629ae0ccedbdb37d88eaa4003b2d41ff193&w=740"
        ),
        Category(
            cname = "Lunch",
            imageUrl = "https://img.freepik.com/premium-vector/indian-food-cartoon-illustration-with-various-collection-flat-style-design_2175-5848.jpg?w=996"
        ),
        Category(
            cname = "Sandwiches",
            imageUrl = "https://img.freepik.com/free-vector/sandwich-with-cheese-vegetable-cartoon-style_1308-92384.jpg?t=st=1720254562~exp=1720258162~hmac=5fdc7c199285ac1e5f65960b6240c80a5af5cd1762c98ef1c204b68118b1613f&w=900"
        ),
        Category(
            cname = "Hamburger",
            imageUrl = "https://img.freepik.com/free-vector/hamburger-ingredients_98292-3567.jpg?t=st=1720254625~exp=1720258225~hmac=1e106fbd30785e1a26ac88b06355ebbffc315ccef57264f9b2acd7a8b03933d4&w=740"
        ),
        Category(
            cname = "Indian",
            imageUrl = "https://img.freepik.com/free-vector/hand-drawn-indian-cuisine-illustration_23-2149323580.jpg?t=st=1720254594~exp=1720258194~hmac=1768d144e4d703bacc4550bdbdf7634fdd9e1900a7ccd0d3326a4b8bb78f74d5&w=740"
        ),
        Category(
            cname = "Pizza",
            imageUrl = "https://img.freepik.com/premium-vector/pizza-board_70172-80.jpg?w=740"
        ),
        Category(
            cname = "Custom",
            imageUrl = "https://img.freepik.com/free-vector/choosing-healthy-unhealthy-food_23-2148565865.jpg?t=st=1720952539~exp=1720956139~hmac=c9abb30abdcd80f04d77807aafc86ae59527f1e500d44bef3b8321d0a83f6361&w=1060"
        ),
        Category(
            cname = "Favorite",
            imageUrl = "https://img.freepik.com/free-vector/choosing-healthy-unhealthy-food_23-2148557445.jpg?t=st=1720367339~exp=1720370939~hmac=1583cab920bf6fcaa72d41ffb0293d0b91abaf4f464fc225bbbc47292dbc2513&w=740"
        ),
    )
    viewModel.insertAll(categories)


    val foods = listOf(
        // Chicken Category
        Food(
            categoryId = "Chicken", // Chicken
            name = "Chicken Parmesan",
            description = "Breaded chicken breast topped with marinara sauce and melted cheese",
            imageUrl = "https://www.onceuponachef.com/images/2019/04/chicken-parmesan-1-2-1200x1554.jpg",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = true,
            ingredients = """
            - 4 chicken breasts
            - 1 cup breadcrumbs
            - 1/2 cup grated Parmesan cheese
            - 1 tsp Italian seasoning
            - 2 eggs, beaten
            - 2 cups marinara sauce
            - 1 1/2 cups shredded mozzarella cheese
            - 2 tbsp olive oil
        """.trimIndent(),
            recipeDetails = """
            1. Preheat oven to 375°F.
            2. Mix breadcrumbs, Parmesan cheese, and Italian seasoning in a shallow dish.
            3. Dip chicken in beaten eggs, then coat with breadcrumb mixture.
            4. Heat oil in a large skillet over medium heat. Cook chicken until golden brown and cooked through.
            5. Spread marinara sauce over chicken, then top with mozzarella cheese.
            6. Bake for 20 minutes or until cheese is melted and bubbly.
            7. Serve hot with pasta or salad.
        """.trimIndent()
        ),


        Food(
            categoryId = "Chicken", // Chicken
            name = "Chicken Curry",
            description = "Spicy and flavorful chicken curry cooked in a rich tomato sauce",
            imageUrl = "https://images.pexels.com/photos/9567078/pexels-photo-9567078.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            isGlutenFree = true,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = true,
            ingredients = """
            - 1 kg chicken, cut into pieces
            - 2 onions, finely chopped
            - 3 tomatoes, pureed
            - 2 tbsp ginger-garlic paste
            - 2 tsp chili powder
            - 1 tsp turmeric powder
            - 2 tsp garam masala
            - Salt to taste
            - Fresh coriander leaves
        """.trimIndent(),
            recipeDetails = """
            1. Heat oil in a pan and sauté onions until golden brown.
            2. Add ginger-garlic paste and cook for 2 minutes.
            3. Add chicken pieces and fry until browned.
            4. Add pureed tomatoes, chili powder, turmeric, and salt. Cook until oil separates.
            5. Add garam masala and cook for another 5 minutes.
            6. Garnish with fresh coriander leaves and serve hot with rice or naan.
        """.trimIndent()
        ),
        Food(
            categoryId = "Chicken", // Chicken
            name = "Grilled Chicken",
            description = "Juicy grilled chicken breasts marinated in a blend of herbs and spices",
            imageUrl = "https://images.pexels.com/photos/19615781/pexels-photo-19615781/free-photo-of-roasted-chicken-with-vegetables-on-flatbread-with-sauce.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            isGlutenFree = true,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = true,
            ingredients = """
            - 4 chicken breasts
            - 2 tbsp olive oil
            - 1 tbsp lemon juice
            - 2 cloves garlic, minced
            - 1 tsp dried oregano
            - 1 tsp dried thyme
            - Salt and pepper to taste
        """.trimIndent(),
            recipeDetails = """
            1. In a bowl, mix olive oil, lemon juice, garlic, oregano, thyme, salt, and pepper.
            2. Marinate chicken breasts in the mixture for at least 30 minutes.
            3. Preheat grill to medium-high heat.
            4. Grill chicken for 6-7 minutes on each side or until fully cooked.
            5. Serve hot with a side of vegetables or salad.
        """.trimIndent()
        ),
        Food(
            categoryId = "Chicken", // Chicken
            name = "Chicken Alfredo",
            description = "Creamy Alfredo sauce over tender chicken and pasta",
            imageUrl = "https://www.dinneratthezoo.com/wp-content/uploads/2019/07/chicken-alfredo-bake-5-2.jpg",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = false,
            ingredients = """
            - 2 chicken breasts
            - 8 oz fettuccine pasta
            - 2 cups heavy cream
            - 1 cup grated Parmesan cheese
            - 2 tbsp butter
            - 2 cloves garlic, minced
            - Salt and pepper to taste
            - Fresh parsley, chopped
        """.trimIndent(),
            recipeDetails = """
            1. Cook pasta according to package instructions.
            2. In a large skillet, melt butter and sauté garlic until fragrant.
            3. Add chicken breasts and cook until golden brown and fully cooked. Remove and slice.
            4. In the same skillet, add heavy cream and bring to a simmer.
            5. Stir in Parmesan cheese until melted and smooth.
            6. Add cooked pasta and sliced chicken to the sauce, tossing to coat.
            7. Season with salt and pepper, and garnish with fresh parsley.
            8. Serve hot.
        """.trimIndent()
        ),
        Food(
            categoryId = "Chicken", // Chicken
            name = "Chicken Tikka",
            description = "Marinated chicken pieces cooked to perfection",
            imageUrl = "https://img.freepik.com/free-photo/chicken-skewers-with-slices-apples-chili-top-view_2829-19996.jpg?w=1060&t=st=1720249673~exp=1720250273~hmac=9f1ea0fe1f8b64c302021985832d7dbb79dc41643d826fef1b961c8611da742f",
            isGlutenFree = true,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = true,
            ingredients = """
            - 1 kg chicken, cut into pieces
            - 1 cup yogurt
            - 2 tbsp lemon juice
            - 2 tsp chili powder
            - 1 tsp turmeric powder
            - 2 tsp garam masala
            - 2 tbsp ginger-garlic paste
            - Salt to taste
        """.trimIndent(),
            recipeDetails = """
            1. In a bowl, mix yogurt, lemon juice, chili powder, turmeric, garam masala, ginger-garlic paste, and salt.
            2. Marinate chicken pieces in the mixture for at least 4 hours.
            3. Preheat oven to 400°F or heat a grill.
            4. Cook chicken pieces until fully cooked and charred on the edges.
            5. Serve hot with mint chutney.
        """.trimIndent()
        ),
        Food(
            categoryId = "Chicken", // Chicken
            name = "BBQ Chicken Wings",
            description = "Tender chicken wings coated in a tangy BBQ sauce",
            imageUrl = "https://img.freepik.com/free-photo/close-up-delicious-chicken-meal_23-2150741653.jpg?t=st=1720249725~exp=1720253325~hmac=7c9bc7eb4aec619c9c09e5c224723a190d0e3ba9233c57ba23e709d000a9d3d4&w=1380",
            isGlutenFree = true,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = true,
            ingredients = """
            - 2 lbs chicken wings
            - 1 cup BBQ sauce
            - 2 tbsp olive oil
            - 1 tsp garlic powder
            - 1 tsp onion powder
            - Salt and pepper to taste
        """.trimIndent(),
            recipeDetails = """
            1. Preheat oven to 375°F.
            2. In a bowl, mix olive oil, garlic powder, onion powder, salt, and pepper.
            3. Toss chicken wings in the mixture to coat.
            4. Arrange wings on a baking sheet and bake for 25 minutes.
            5. Remove wings, coat with BBQ sauce, and bake for an additional 10 minutes.
            6. Serve hot with extra BBQ sauce.
        """.trimIndent()
        ),

        // Breakfast Category
        Food(
            categoryId = "Breakfast", // Breakfast
            name = "Pancakes",
            description = "Fluffy pancakes served with syrup and butter",
            imageUrl = "https://img.freepik.com/free-photo/pancakes-with-berries-syrup-rustic-style_2829-19891.jpg?t=st=1720249780~exp=1720253380~hmac=2f5c8fddb083e87f3d05158b4d2b57df3caa627ef98c47d10ac3dd5c220f2221&w=360",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - 1 cup flour
            - 2 tbsp sugar
            - 1 tsp baking powder
            - 1/2 tsp baking soda
            - 1/2 tsp salt
            - 1 cup buttermilk
            - 1 egg
            - 2 tbsp melted butter
            - Syrup and butter for serving
        """.trimIndent(),
            recipeDetails = """
            1. In a bowl, mix flour, sugar, baking powder, baking soda, and salt.
            2. In another bowl, whisk buttermilk, egg, and melted butter.
            3. Combine wet and dry ingredients, mixing until just combined.
            4. Heat a griddle or pan over medium heat and lightly grease.
            5. Pour batter onto the griddle and cook until bubbles form on the surface.
            6. Flip and cook until golden brown.
            7. Serve hot with syrup and butter.
        """.trimIndent()
        ),
        Food(
            categoryId = "Breakfast", // Breakfast
            name = "Omelette",
            description = "A fluffy omelette filled with cheese, vegetables, and herbs",
            imageUrl = "https://img.freepik.com/premium-psd/so-yummy-omelette-isolated-transparent-background_1069883-2974.jpg?w=826",
            isGlutenFree = true,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = false,
            ingredients = """
            - 3 eggs
            - 1/4 cup shredded cheese
            - 1/4 cup chopped vegetables (bell peppers, onions, tomatoes)
            - 1 tbsp chopped herbs (parsley, chives)
            - Salt and pepper to taste
            - 1 tbsp butter
        """.trimIndent(),
            recipeDetails = """
            1. In a bowl, whisk eggs with salt and pepper.
            2. Heat butter in a non-stick pan over medium heat.
            3. Pour eggs into the pan and cook until edges start to set.
            4. Add cheese, vegetables, and herbs to one half of the omelette.
            5. Fold the omelette in half and cook for another minute.
            6. Serve hot.
        """.trimIndent()
        ),
        Food(
            categoryId = "Breakfast", // Breakfast
            name = "French Toast",
            description = "Bread slices soaked in egg mixture and pan-fried to perfection",
            imageUrl = "https://img.freepik.com/premium-photo/crepes-with-cream-cheese-red-caviar_2829-18341.jpg?w=1060",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - 4 slices of bread
            - 2 eggs
            - 1/2 cup milk
            - 1 tsp vanilla extract
            - 1/2 tsp cinnamon
            - Butter for frying
            - Syrup and powdered sugar for serving
        """.trimIndent(),
            recipeDetails = """
            1. In a bowl, whisk eggs, milk, vanilla extract, and cinnamon.
            2. Dip bread slices in the egg mixture, coating both sides.
            3. Heat butter in a pan over medium heat.
            4. Cook bread slices until golden brown on both sides.
            5. Serve hot with syrup and powdered sugar.
        """.trimIndent()
        ),
        Food(
            categoryId = "Breakfast", // Breakfast
            name = "Smoothie Bowl",
            description = "A thick and creamy smoothie topped with fruits and granola",
            imageUrl = "https://img.freepik.com/premium-photo/minimalist-topview-smoothie-bowl-with-berries-wooden-bowl_818261-71500.jpg?w=740",
            isGlutenFree = true,
            isVegan = true,
            isVegetarian = true,
            isLactoseFree = true,
            ingredients = """
            - 1 cup frozen berries
            - 1 banana
            - 1/2 cup almond milk
            - 1 tbsp honey
            - Toppings: sliced fruits, granola, chia seeds
        """.trimIndent(),
            recipeDetails = """
            1. In a blender, combine frozen berries, banana, almond milk, and honey.
            2. Blend until smooth and thick.
            3. Pour into a bowl and top with sliced fruits, granola, and chia seeds.
            4. Serve immediately.
        """.trimIndent()
        ),
        Food(
            categoryId = "Breakfast", // Breakfast
            name = "Breakfast Burrito",
            description = "A hearty burrito filled with scrambled eggs, sausage, and cheese",
            imageUrl = "https://img.freepik.com/free-photo/selective-focus-shot-mexican-style-delicious-pork-flautas-white-plate_181624-38905.jpg?t=st=1720250005~exp=1720253605~hmac=dea195a7487c88018089388f9cba0628e351f020afd4425a5980ce18774ba674&w=1060",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = false,
            ingredients = """
            - 4 flour tortillas
            - 6 eggs, scrambled
            - 1/2 cup cooked sausage, crumbled
            - 1/2 cup shredded cheese
            - 1/4 cup salsa
            - 1 avocado, sliced
        """.trimIndent(),
            recipeDetails = """
            1. Warm tortillas in a pan or microwave.
            2. Fill each tortilla with scrambled eggs, sausage, cheese, salsa, and avocado slices.
            3. Roll up the tortillas to form burritos.
            4. Serve hot.
        """.trimIndent()
        ),
        Food(
            categoryId = "Breakfast", // Breakfast
            name = "Avocado Toast",
            description = "Toasted bread topped with mashed avocado and seasonings",
            imageUrl = "https://img.freepik.com/free-photo/tasty-appetizing-crispbread-with-mashed-avocado-served-plate_1220-6278.jpg?t=st=1720250069~exp=1720253669~hmac=2172cf560edc644bce851d51d470f9c0c1884ab18409ed47c4268b18c0bccde9&w=1060",
            isGlutenFree = false,
            isVegan = true,
            isVegetarian = true,
            isLactoseFree = true,
            ingredients = """
            - 2 slices of bread
            - 1 ripe avocado
            - 1/2 tsp lemon juice
            - Salt and pepper to taste
            - Red pepper flakes (optional)
        """.trimIndent(),
            recipeDetails = """
            1. Toast the bread slices until golden brown.
            2. In a bowl, mash the avocado with lemon juice, salt, and pepper.
            3. Spread the mashed avocado on the toasted bread.
            4. Sprinkle with red pepper flakes if desired.
            5. Serve immediately.
        """.trimIndent()
        ),



        // Dessert Category
        Food(
            categoryId = "Dessert", // Dessert
            name = "Cheesecake",
            description = "A rich and creamy cheesecake with a graham cracker crust",
            imageUrl = "https://img.freepik.com/free-photo/side-view-cheesecake-with-cherry-jelly-top-white-plate_141793-2955.jpg?t=st=1720250151~exp=1720253751~hmac=f7dd32b89a6042b9da9395da8e41fed914856c492b35891a0215c8e92e72ff26&w=1060",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - 1 1/2 cups graham cracker crumbs
            - 1/2 cup melted butter
            - 3 (8 oz) packages cream cheese, softened
            - 1 cup sugar
            - 3 eggs
            - 1 tsp vanilla extract
        """.trimIndent(),
            recipeDetails = """
            1. Preheat oven to 325°F.
            2. In a bowl, mix graham cracker crumbs and melted butter. Press into the bottom of a springform pan.
            3. In a large bowl, beat cream cheese and sugar until smooth.
            4. Add eggs one at a time, mixing well after each addition. Stir in vanilla extract.
            5. Pour the mixture over the crust and spread evenly.
            6. Bake for 50-60 minutes or until the center is set.
            7. Allow to cool before refrigerating for at least 4 hours.
            8. Serve chilled.
        """.trimIndent()
        ),
        Food(
            categoryId = "Dessert" , // Dessert
            name = "Chocolate Cake",
            description = "A moist and rich chocolate cake with chocolate frosting",
            imageUrl = "https://img.freepik.com/premium-photo/healthy-chocolate-cake-advertising-purposes_1057389-52513.jpg?w=740",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - 1 3/4 cups flour
            - 1 1/2 cups sugar
            - 3/4 cup cocoa powder
            - 1 1/2 tsp baking powder
            - 1 1/2 tsp baking soda
            - 1 tsp salt
            - 2 eggs
            - 1 cup milk
            - 1/2 cup vegetable oil
            - 2 tsp vanilla extract
            - 1 cup boiling water
        """.trimIndent(),
            recipeDetails = """
            1. Preheat oven to 350°F. Grease and flour two 9-inch round baking pans.
            2. In a large bowl, combine flour, sugar, cocoa powder, baking powder, baking soda, and salt.
            3. Add eggs, milk, oil, and vanilla extract. Beat on medium speed for 2 minutes.
            4. Stir in boiling water (batter will be thin).
            5. Pour batter into prepared pans.
            6. Bake for 30-35 minutes or until a toothpick inserted in the center comes out clean.
            7. Cool in pans for 10 minutes, then remove to wire racks to cool completely.
            8. Frost with your favorite chocolate frosting.
        """.trimIndent()
        ),
        Food(
            categoryId = "Dessert", // Dessert
            name = "Apple Pie",
            description = "A classic apple pie with a flaky crust and sweet apple filling",
            imageUrl = "https://img.freepik.com/premium-vector/vector-pie-chart-circle-graphic-diagram-presentation-business-design-illustration-round-i_1013341-4417.jpg?w=740",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - 1 package of pie crusts
            - 6 cups thinly sliced apples
            - 3/4 cup sugar
            - 2 tbsp flour
            - 1/2 tsp ground cinnamon
            - 1/4 tsp ground nutmeg
            - 1 tbsp lemon juice
        """.trimIndent(),
            recipeDetails = """

              1. Preheat oven to 425°F. Place one pie crust in a pie plate.
            2. In a large bowl, mix apples, sugar, flour, cinnamon, nutmeg, and lemon juice.
            3. Pour apple mixture into the pie crust.
            4. Cover with the second pie crust, seal the edges, and cut slits in the top crust.
            5. Bake for 45 to 55 minutes, or until crust is golden brown and filling is bubbly.
            6. Cool on a wire rack before serving.
        """.trimIndent()
        ),


            Food(
                categoryId = "Dessert", // Dessert
                name = "Tiramisu",
                description = "An elegant Italian dessert made with layers of coffee-soaked ladyfingers and mascarpone cheese",
                imageUrl = "https://img.freepik.com/free-photo/assortment-pieces-cake_114579-28268.jpg?t=st=1720250334~exp=1720253934~hmac=e0eb80ef2c32bf0e543a0b7efd39ca54fe05dd556fe35cc5bb6769fda7846543&w=360",
                isGlutenFree = false,
                isVegan = false,
                isVegetarian = true,
                isLactoseFree = false,
                ingredients = """
            - 1 cup heavy cream
            - 8 oz mascarpone cheese
            - 1/2 cup sugar
            - 1 tsp vanilla extract
            - 1 cup strong brewed coffee, cooled
            - 24 ladyfinger cookies
            - Cocoa powder for dusting
        """.trimIndent(),
                recipeDetails = """
            1. In a bowl, beat heavy cream until stiff peaks form.
            2. In another bowl, whisk mascarpone cheese, sugar, and vanilla extract until smooth.
            3. Fold whipped cream into the mascarpone mixture until well combined.
            4. Quickly dip each ladyfinger into the cooled coffee and arrange them in a single layer in a dish.
            5. Spread half of the mascarpone mixture over the ladyfingers.
            6. Repeat with another layer of dipped ladyfingers and mascarpone mixture.
            7. Dust the top with cocoa powder.
            8. Refrigerate for at least 4 hours before serving.
        """.trimIndent()
            ),
    Food(
        categoryId = "Dessert", // Dessert
        name = "Key Lime Pie",
        description = "A tangy and creamy pie made with fresh key lime juice",
        imageUrl = "https://img.freepik.com/premium-vector/tangy-key-lime-pie-dessert-cartoon-style_1253557-6083.jpg?w=740",
        isGlutenFree = false,
        isVegan = false,
        isVegetarian = true,
        isLactoseFree = false,
        ingredients = """
            - 1 1/2 cups graham cracker crumbs
            - 1/3 cup sugar
            - 6 tbsp unsalted butter, melted
            - 1 (14 oz) can sweetened condensed milk
            - 4 egg yolks
            - 1/2 cup key lime juice
            - Whipped cream for serving
            - Lime slices for garnish
        """.trimIndent(),
        recipeDetails = """
            1. Preheat oven to 350°F. Grease a 9-inch pie dish.
            2. In a bowl, mix graham cracker crumbs, sugar, and melted butter.
            3. Press mixture into the bottom and up the sides of the pie dish.
            4. Bake for 10 minutes, then remove and let cool slightly.
            5. In another bowl, whisk sweetened condensed milk, egg yolks, and key lime juice until smooth.
            6. Pour filling into the crust.
            7. Bake for 15 minutes or until set.
            8. Let cool to room temperature, then refrigerate for at least 2 hours.
            9. Serve chilled with whipped cream and lime slices.
        """.trimIndent()
    ),
    Food(
        categoryId = "Dessert", // Dessert
        name = "Brownies",
        description = "Rich and fudgy chocolate brownies",
        imageUrl = "https://img.freepik.com/free-photo/chocolate-brownies-sackcloth-coffee-beans-wooden-table_1150-20938.jpg?t=st=1720250532~exp=1720254132~hmac=4320a300a63c80cd3dd38d1af4c0539aa6eac20f5c239d080c1323cf55f1719f&w=1060",
        isGlutenFree = false,
        isVegan = false,
        isVegetarian = true,
        isLactoseFree = false,
        ingredients = """
            - 1 cup butter
            - 2 cups sugar
            - 4 eggs
            - 1 1/2 cups flour
            - 1 cup cocoa powder
            - 1 tsp vanilla extract
            - 1/2 tsp salt
            - 1 cup chocolate chips (optional)
        """.trimIndent(),
        recipeDetails = """
            1. Preheat oven to 350°F. Grease a 9x13 inch baking dish.
            2. In a saucepan, melt butter over medium heat. Remove from heat.
            3. Stir in sugar, eggs, and vanilla extract until well combined.
            4. Mix in flour, cocoa powder, and salt until smooth.
            5. Fold in chocolate chips if using.
            6. Spread batter evenly into the prepared baking dish.
            7. Bake for 25-30 minutes or until a toothpick inserted in the center comes out with moist crumbs.
            8. Let cool completely before cutting into squares.
            9. Serve at room temperature.
        """.trimIndent()
    ),
    Food(
        categoryId = "Dessert", // Dessert
        name = "Ice Cream",
        description = "Creamy vanilla ice cream",
        imageUrl = "https://img.freepik.com/free-photo/delicious-ice-cream-studio_23-2150696700.jpg?t=st=1720250616~exp=1720254216~hmac=b6c14c4b54710ab4e500be1c377b6725d0922bd0dbba08f3bd7606bdc60747c6&w=360",
        isGlutenFree = true,
        isVegan = false,
        isVegetarian = true,
        isLactoseFree = false,
        ingredients = """
            - 2 cups heavy cream
            - 1 cup whole milk
            - 3/4 cup sugar
            - 1 tbsp vanilla extract
            - Pinch of salt
        """.trimIndent(),
        recipeDetails = """
            1. In a bowl, whisk together heavy cream, whole milk, sugar, vanilla extract, and salt until sugar is dissolved.
            2. Pour mixture into an ice cream maker and churn according to manufacturer's instructions.
            3. Transfer ice cream to a container and freeze until firm.
            4. Serve scoops of ice cream in bowls or cones.
        """.trimIndent()
    ),
    Food(
        categoryId = "Dessert", // Dessert
        name = "Fruit Tart",
        description = "A delightful tart filled with pastry cream and fresh fruits",
        imageUrl = "https://img.freepik.com/free-photo/homemade-delicious-rustic-summer-berry-tartles_114579-11035.jpg?t=st=1720250675~exp=1720254275~hmac=77f51b38df9040bfd16c55aab0f1c03086a1665a6a295df9dc380fc2eb625d24&w=1060",
        isGlutenFree = false,
        isVegan = false,
        isVegetarian = true,
        isLactoseFree = false,
        ingredients = """
            - 1 sheet of puff pastry
            - 1 cup pastry cream
            - Assorted fresh fruits (berries, kiwi, mango)
            - Apricot jam for glaze
        """.trimIndent(),
        recipeDetails = """
            1. Preheat oven to 400°F.
            2. Roll out puff pastry sheet into a rectangle and transfer to a baking sheet.
            3. Prick pastry with a fork and bake for 15-20 minutes or until golden brown.
            4. Let pastry cool completely.
            5. Spread pastry cream evenly over the cooled pastry.
            6. Arrange fresh fruits on top of the pastry cream.
            7. Warm apricot jam and brush over the fruits for a glossy finish.
            8. Chill tart before serving.
        """.trimIndent()
    ),
    Food(
        categoryId = "Dessert", // Dessert
        name = "Banana Bread",
        description = "Moist and flavorful banana bread",
        imageUrl = "https://img.freepik.com/free-photo/close-up-banana-bread_23-2151005994.jpg?t=st=1720250729~exp=1720254329~hmac=bf1210599cc9abd03da105f90ec6abc5d68627800777d7fb7a6702564b06b5f5&w=360",
        isGlutenFree = false,
        isVegan = false,
        isVegetarian = true,
        isLactoseFree = false,
        ingredients = """
            - 2 ripe bananas, mashed
            - 1/3 cup melted butter
            - 1/2 cup sugar
            - 1 egg, beaten
            - 1 tsp vanilla extract
            - 1 tsp baking soda
            - Pinch of salt
            - 1 1/2 cups all-purpose flour
        """.trimIndent(),
        recipeDetails = """
            1. Preheat oven to 350°F. Grease a 4x8 inch loaf pan.
            2. In a bowl, mix mashed bananas and melted butter.
            3. Stir in sugar, egg, and vanilla extract until well combined.
            4. Mix in baking soda and salt.
            5. Add flour and stir until just combined.
            6. Pour batter into the prepared loaf pan.
            7. Bake for 60-65 minutes or until a toothpick inserted into the center comes out clean.
            8. Let cool in the pan for 10 minutes, then transfer to a wire rack to cool completely.
            9. Slice and serve.
        """.trimIndent()
    ),

    // Drinks Category

        Food(
            categoryId = "Drinks",
            name = "Masala Chai",
            description = "Spiced tea with milk and aromatic spices",
            imageUrl = "https://img.freepik.com/premium-photo/masala-chai-tea-with-spices-star-anise-cinnamon-stick-peppercorns-sack-wooden-background_1028938-118927.jpg?w=360",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - 2 cups water
            - 1 cup milk
            - 2 tbsp black tea leaves
            - 2-3 tbsp sugar (adjust to taste)
            - 1-inch piece of fresh ginger, grated
            - 2-3 whole cloves
            - 2-3 whole green cardamom pods, lightly crushed
            - 1 cinnamon stick
        """.trimIndent(),
            recipeDetails = """
            1. In a saucepan, bring water to a boil.
            2. Add tea leaves, grated ginger, cloves, cardamom pods, and cinnamon stick.
            3. Let it simmer for 2-3 minutes until aromatic.
            4. Add milk and sugar, bring to a boil again.
            5. Reduce heat and simmer for another 2-3 minutes.
            6. Strain the chai into cups and serve hot.
            7. Optionally, garnish with a sprinkle of ground cinnamon.
        """.trimIndent()
        ),
        Food(
            categoryId = "Drinks",
            name = "Mango Shake",
            description = "Refreshing milkshake made with ripe mangoes",
            imageUrl = "https://www.vegrecipesofindia.com/wp-content/uploads/2021/04/mango-shake-recipe-1.jpg",
            isGlutenFree = true,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - 2 ripe mangoes, peeled and diced
            - 2 cups cold milk
            - 2 tbsp sugar (adjust to taste)
            - Ice cubes (optional)
        """.trimIndent(),
            recipeDetails = """
            1. In a blender, combine diced mangoes, cold milk, and sugar.
            2. Blend until smooth and creamy.
            3. Add ice cubes if desired for a colder shake.
            4. Blend again until ice cubes are crushed and well incorporated.
            5. Pour into glasses and serve immediately.
        """.trimIndent()
        ),


        Food(
            categoryId = "Drinks",
            name = "Lassi",
            description = "Traditional yogurt-based drink, sweet or salty",
            imageUrl = "https://img.freepik.com/free-photo/ayran-drink-with-mint-cucumber-glass_123827-21607.jpg?t=st=1720251587~exp=1720255187~hmac=d85e25d22f95f2a8ea6087f561c97c52db8ea5dd6ba8ccd49e41ffc11a117876&w=360",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - 1 cup plain yogurt
            - 1/2 cup cold water
            - 2 tbsp sugar (for sweet lassi) or 1/2 tsp salt (for salty lassi)
            - A pinch of ground cardamom (optional)
            - Ice cubes (optional)
        """.trimIndent(),
            recipeDetails = """
            1. In a blender, combine yogurt, water, and sugar (for sweet lassi) or salt (for salty lassi).
            2. Blend until smooth and frothy.
            3. Add a pinch of ground cardamom if desired.
            4. Pour into glasses over ice cubes if using.
            5. Serve chilled.
        """.trimIndent()
        ),
        Food(
            categoryId = "Drinks",
            name = "Thandai",
            description = "Cooling milk-based drink with nuts and spices, often served during festivals",
            imageUrl = "https://img.freepik.com/free-photo/glass-vanilla-milkshake-with-pistachio-sprinkles_140725-4884.jpg?t=st=1720251539~exp=1720255139~hmac=7f3c5d52c83262e221ecefe3e0a0ef4690353e64eeb36e01bad3b5afbcb1a410&w=360",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - 2 cups milk
            - 1/4 cup sugar
            - 2 tbsp almonds, blanched and peeled
            - 1 tbsp pistachios, blanched and peeled
            - 1 tbsp melon seeds (optional)
            - 1 tsp poppy seeds (optional)
            - 1/2 tsp black peppercorns
            - 1/2 tsp fennel seeds
            - 1/2 tsp cardamom powder
            - A pinch of saffron strands (optional)
        """.trimIndent(),
            recipeDetails = """
            1. Soak almonds, pistachios, melon seeds, and poppy seeds (if using) in water for 1 hour, then drain.
            2. In a blender, combine soaked nuts and seeds with a little milk to form a smooth paste.
            3. In a saucepan, heat the remaining milk with sugar until it starts to boil.
            4. Add the nut paste, black peppercorns, fennel seeds, cardamom powder, and saffron strands (if using).
            5. Simmer for 5-7 minutes, stirring occasionally.
            6. Strain the mixture through a fine sieve.
            7. Chill in the refrigerator.
            8. Serve cold, optionally garnished with chopped nuts.
        """.trimIndent()
        ),
        Food(
            categoryId = "Drinks",
            name = "Nimbu Pani",
            description = "Refreshing lemonade with Indian spices",
            imageUrl = "https://img.freepik.com/premium-photo/lemon-water-fresh-juice-with-cut-lemon-fruit-herb-good-healthy-wooden-table_39768-324.jpg?w=1060",
            isGlutenFree = true,
            isVegan = true,
            isVegetarian = true,
            isLactoseFree = true,
            ingredients = """
            - 4 cups water
            - Juice of 3-4 lemons
            - 1/2 cup sugar (adjust to taste)
            - 1 tsp black salt
            - 1/2 tsp roasted cumin powder
            - Mint leaves for garnish
            - Ice cubes
        """.trimIndent(),
            recipeDetails = """
            1. In a pitcher, combine water, lemon juice, sugar, black salt, and roasted cumin powder.
            2. Stir until sugar is dissolved.
            3. Add ice cubes and mint leaves.
            4. Stir well and serve chilled.
        """.trimIndent()
        ),
        Food(
            categoryId = "Drinks",
            name = "Jal-jeera",
            description = "Spiced cumin water, tangy and refreshing",
            imageUrl = "https://img.freepik.com/premium-photo/jal-jeera-jaljira-is-indian-beverage-prepared-using-mixing-cumin-powder-water-served-cold-with-boondi-mint-lemon-slice-served-moody-background-selective-focus_466689-56383.jpg?w=1060",
            isGlutenFree = true,
            isVegan = true,
            isVegetarian = true,
            isLactoseFree = true,
            ingredients = """
            - 2 tbsp tamarind paste
            - 1/2 cup mint leaves
            - 1/4 cup cilantro leaves
            - 2 tbsp roasted cumin powder
            - 1 tsp black salt
            - 1/2 tsp chaat masala
            - 1/2 tsp ground black pepper
            - 4 cups water
            - Ice cubes
        """.trimIndent(),
            recipeDetails = """
            1. In a blender, combine tamarind paste, mint leaves, cilantro leaves, roasted cumin powder, black salt, chaat masala, and ground black pepper with 1 cup water.
            2. Blend until smooth.
            3. Strain the mixture through a fine sieve into a pitcher.
            4. Add remaining water and ice cubes.
            5. Stir well and serve chilled.
        """.trimIndent()
        ),
        Food(
            categoryId = "Drinks",
            name = "Badam Milk",
            description = "Sweet almond milk flavored with saffron and cardamom",
            imageUrl = "https://img.freepik.com/free-photo/almond-milk-with-almond-top-view_114579-7192.jpg?w=360&t=st=1720251417~exp=1720252017~hmac=7abf5e0a4cab19cfadfccd032cb9152b44c6e860e823f3f3df6bbb41a38ef1c6",
            isGlutenFree = true,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - 1 cup almonds, blanched and peeled
            - 4 cups milk
            - 1/2 cup sugar (adjust to taste)
            - 1/2 tsp cardamom powder
            - A few saffron strands
        """.trimIndent(),
            recipeDetails = """
            1. In a blender, blend almonds with 1 cup milk until smooth.
            2. In a saucepan, heat remaining milk with sugar, cardamom powder, and saffron strands until it starts to boil.
            3. Add almond paste to the boiling milk.
            4. Simmer for 5-7 minutes, stirring occasionally.
            5. Serve hot or cold, garnished with a few more saffron strands.
        """.trimIndent()
        ),






 // Vegan Category
    Food(
        categoryId = "Vegan", // Vegan
        name = "Vegan Buddha Bowl",
        description = "A nourishing bowl filled with grains, vegetables, and a creamy tahini dressing",
        imageUrl = "https://th.bing.com/th/id/OIP.F_yy3-U1LZmKQurG-DlDHgHaIL?rs=1&pid=ImgDetMain",
        isGlutenFree = true,
        isVegan = true,
        isVegetarian = true,
        isLactoseFree = true,
        ingredients = """
            - 1 cup cooked quinoa
            - 1 cup roasted sweet potatoes
            - 1 cup steamed broccoli
            - 1/2 cup cooked chickpeas
            - 1/2 avocado, sliced
            - 1/4 cup shredded carrots
            - Creamy tahini dressing
        """.trimIndent(),
        recipeDetails = """
            1. Arrange quinoa, sweet potatoes, broccoli, chickpeas, avocado, and shredded carrots in a bowl.
            2. Drizzle with creamy tahini dressing.
            3. Serve immediately and enjoy.
        """.trimIndent()
    ),
    Food(
        categoryId = "Vegan", // Vegan
        name = "Vegan Pancakes",
        description = "Fluffy pancakes made without eggs or dairy",
        imageUrl = "https://lovingitvegan.com/wp-content/uploads/2018/04/Vegan-Pancakes-15.jpg",
        isGlutenFree = false,
        isVegan = true,
        isVegetarian = true,
        isLactoseFree = true,
        ingredients = """
            - 1 cup all-purpose flour
            - 1 tbsp sugar
            - 2 tsp baking powder
            - 1/8 tsp salt
            - 3/4 cup almond milk
            - 1 tbsp vegetable oil
            - 1 tsp vanilla extract
        """.trimIndent(),
        recipeDetails = """
            1. In a bowl, whisk together flour, sugar, baking powder, and salt.
            2. In another bowl, mix almond milk, vegetable oil, and vanilla extract.
            3. Pour wet ingredients into dry ingredients and stir until just combined (batter will be lumpy).
            4. Heat a non-stick skillet or griddle over medium heat.
            5. Pour batter onto the skillet to form pancakes.
            6. Cook until bubbles form on the surface, then flip and cook until golden brown.
            7. Serve warm with maple syrup or fresh fruits.
        """.trimIndent()
    ),
    Food(
        categoryId = "Vegan", // Vegan
        name = "Quinoa Salad",
        description = "A refreshing salad with quinoa, fresh vegetables, and a zesty lemon dressing",
        imageUrl = "https://cdn.loveandlemons.com/wp-content/uploads/2020/08/quinoa-salad.jpg",
        isGlutenFree = true,
        isVegan = true,
        isVegetarian = true,
        isLactoseFree = true,
        ingredients = """
            - 1 cup quinoa, cooked and cooled
            - 1 cucumber, diced
            - 1 cup cherry tomatoes, halved
            - 1/4 cup red onion, thinly sliced
            - 1/4 cup chopped fresh parsley
            - Zest and juice of 1 lemon
            - 2 tbsp olive oil
            - Salt and pepper to taste
        """.trimIndent(),
        recipeDetails = """
            1. In a large bowl, combine quinoa, cucumber, cherry tomatoes, red onion, and parsley.
            2. In a small bowl, whisk together lemon zest, lemon juice, olive oil, salt, and pepper.
            3. Pour dressing over the salad and toss to coat evenly.
            4. Serve chilled or at room temperature.
        """.trimIndent()
    ),
    Food(
        categoryId = "Vegan", // Vegan
        name = "Chickpea Curry",
        description = "A flavorful curry made with chickpeas, tomatoes, and aromatic spices",
        imageUrl = "https://th.bing.com/th/id/OIP.HA6Ly50bhJU7TRSvmvPGrAHaLH?rs=1&pid=ImgDetMain",
        isGlutenFree = true,
        isVegan = true,
        isVegetarian = true,
        isLactoseFree = true,
        ingredients = """
            - 1 tbsp coconut oil
            - 1 onion, finely chopped
            - 3 cloves garlic, minced
            - 1 tbsp grated ginger
            - 1 tbsp curry powder
            - 1/2 tsp ground turmeric
            - 1 can (15 oz) chickpeas, drained and rinsed
            - 1 can (14 oz) diced tomatoes
            - 1 can (14 oz) coconut milk
            - Salt and pepper to taste
            - Fresh cilantro for garnish
        """.trimIndent(),
        recipeDetails = """
            1. Heat coconut oil in a large skillet over medium heat.
            2. Add chopped onion and cook until translucent.
            3. Stir in minced garlic, grated ginger, curry powder, and ground turmeric. Cook for 1 minute until fragrant.
            4. Add chickpeas, diced tomatoes (with juices), and coconut milk. Stir to combine.
            5. Bring to a simmer and cook for 15-20 minutes, stirring occasionally.
            6. Season with salt and pepper to taste.
            7. Garnish with fresh cilantro before serving.
            8. Serve hot with rice or naan bread.
        """.trimIndent()
    ),
    Food(
        categoryId = "Vegan", // Vegan
        name = "Stuffed Bell Peppers",
        description = "Colorful bell peppers stuffed with quinoa, black beans, corn, and spices",
        imageUrl = "https://img.freepik.com/free-photo/top-view-cooked-bell-peppers-grey-surface-food-dolma-vegetable-meal-beef_140725-74493.jpg?t=st=1720252029~exp=1720255629~hmac=9f473732a8e345d122c0158fe8222fe4d1eb2121fd4c88e7df28022cc6b49388&w=1060",
        isGlutenFree = true,
        isVegan = true,
        isVegetarian = true,
        isLactoseFree = true,
        ingredients = """
            - 4 bell peppers, halved and seeds removed
            - 1 cup cooked quinoa
            - 1 cup black beans, drained and rinsed
            - 1 cup corn kernels
            - 1/2 cup diced tomatoes
            - 1/4 cup chopped cilantro
            - 1 tsp chili powder
            - 1/2 tsp cumin
            - Salt and pepper to taste
            - Salsa for serving
        """.trimIndent(),
        recipeDetails = """
            1. Preheat oven to 375°F. Grease a baking dish.
            2. In a bowl, combine quinoa, black beans, corn, diced tomatoes, cilantro, chili powder, cumin, salt, and pepper.
            3. Stuff each bell pepper half with the quinoa mixture.
            4. Place stuffed peppers in the prepared baking dish.
            5. Cover with foil and bake for 25-30 minutes or until peppers are tender.
            6. Serve hot with salsa.
        """.trimIndent()
    ),


    // Lunch Category

        Food(
            categoryId = "Lunch",
            name = "Paneer Butter Masala",
            description = "Rich and creamy curry made with paneer (Indian cottage cheese) in a tomato-based sauce",
            imageUrl = "https://th.bing.com/th/id/OIP.-rZiit_GDlRDoR4WZ3AYpAHaLH?rs=1&pid=ImgDetMain",
            isGlutenFree = true,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - 200g paneer, cubed
            - 2 tbsp butter
            - 1 onion, finely chopped
            - 2 tomatoes, pureed
            - 1 tbsp ginger-garlic paste
            - 1/2 tsp cumin seeds
            - 1/2 tsp turmeric powder
            - 1 tsp red chili powder
            - 1 tsp garam masala
            - 1/2 cup cream
            - Salt to taste
            - Fresh coriander leaves, chopped for garnish
        """.trimIndent(),
            recipeDetails = """
            1. Heat butter in a pan, add cumin seeds, and sauté until fragrant.
            2. Add chopped onions and cook until golden brown.
            3. Add ginger-garlic paste and sauté for a minute.
            4. Add tomato puree, turmeric powder, red chili powder, garam masala, and salt. Cook until oil separates.
            5. Add cubed paneer and mix well to coat with the masala.
            6. Stir in cream and simmer for 2-3 minutes.
            7. Garnish with chopped coriander leaves and serve hot with naan or rice.
        """.trimIndent()
        ),
        Food(
            categoryId = "Lunch",
            name = "Palak Paneer",
            description = "Creamy spinach curry with paneer (Indian cottage cheese)",
            imageUrl = "https://img.freepik.com/premium-photo/traditional-national-indian-plate-freshly-prepared-indian-palak-paneer-with-spinach_651280-818.jpg?w=740",
            isGlutenFree = true,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - 200g paneer, cubed
            - 2 cups spinach leaves, blanched and pureed
            - 1 onion, finely chopped
            - 2 tomatoes, pureed
            - 1 tbsp ginger-garlic paste
            - 1/2 tsp cumin seeds
            - 1/2 tsp turmeric powder
            - 1 tsp red chili powder
            - 1/2 cup cream
            - Salt to taste
            - Fresh cream for garnish
        """.trimIndent(),
            recipeDetails = """
            1. Heat oil in a pan, add cumin seeds, and sauté until fragrant.
            2. Add chopped onions and cook until golden brown.
            3. Add ginger-garlic paste and sauté for a minute.
            4. Add tomato puree, turmeric powder, red chili powder, and salt. Cook until oil separates.
            5. Add spinach puree and cook for 5-7 minutes.
            6. Add cubed paneer and mix gently.
            7. Stir in cream and simmer for another 2-3 minutes.
            8. Garnish with a swirl of fresh cream and serve hot with roti or rice.
        """.trimIndent()
        ),
        Food(
            categoryId = "Lunch",
            name = "Chicken Biryani",
            description = "Fragrant rice dish with marinated chicken and aromatic spices, cooked in layers",
            imageUrl = "https://img.freepik.com/free-photo/close-up-appetizing-ramadan-meal_23-2151182540.jpg?t=st=1720252623~exp=1720256223~hmac=9883c7771c65f496450a19028f4957d6b21d2177fd11b22aebb87e3ce835eaac&w=1060",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = true,
            ingredients = """
            - 1 cup basmati rice, soaked for 30 minutes
            - 250g chicken, cut into pieces
            - 1 onion, thinly sliced
            - 2 tomatoes, chopped
            - 1/2 cup yogurt
            - 2 tbsp biryani masala
            - 1 tsp turmeric powder
            - 1 tsp red chili powder
            - A pinch of saffron strands, soaked in 2 tbsp warm milk
            - Fresh coriander leaves, chopped for garnish
            - Fried onions for garnish
        """.trimIndent(),
            recipeDetails = """
            1. Heat oil in a pan, add thinly sliced onions, and fry until golden brown. Remove and set aside.
            2. In the same pan, add chicken pieces and sauté until browned.
            3. Add chopped tomatoes, biryani masala, turmeric powder, red chili powder, and salt. Cook until tomatoes are soft.
            4. In a separate pot, boil water and add soaked rice. Cook until rice is 70% done. Drain and set aside.
            5. Layer the cooked chicken masala and rice in the pot. Sprinkle fried onions, saffron milk, and chopped coriander leaves between layers.
            6. Cover and cook on low heat for 10-15 minutes until rice is fully cooked and aromatic.
            7. Serve hot with raita and salad.
        """.trimIndent()
        ),
        Food(
            categoryId = "Lunch",
            name = "Rajma Chawal",
            description = "Red kidney beans cooked in a spiced tomato gravy, served with steamed rice",
            imageUrl = "https://img.freepik.com/free-photo/dry-spices-near-rice-dish_23-2147894748.jpg?t=st=1720253722~exp=1720257322~hmac=4bf07a413cb23e1e77096c0f91778144b2464b5f2495f068cc051b1cec3f68f5&w=360",
            isGlutenFree = true,
            isVegan = true,
            isVegetarian = true,
            isLactoseFree = true,
            ingredients = """
            - 1 cup red kidney beans (rajma), soaked overnight
            - 1 onion, finely chopped
            - 2 tomatoes, pureed
            - 1 tbsp ginger-garlic paste
            - 1/2 tsp cumin seeds
            - 1 tsp coriander powder
            - 1/2 tsp turmeric powder
            - 1 tsp red chili powder
            - 1/2 cup fresh cream (optional)
            - Fresh coriander leaves, chopped for garnish
            - Steamed rice for serving
        """.trimIndent(),
            recipeDetails = """
            1. Pressure cook soaked rajma until tender. Drain and set aside.
            2. Heat oil in a pan, add cumin seeds, and sauté until fragrant.
            3. Add chopped onions and cook until golden brown.
            4. Add ginger-garlic paste and sauté for a minute.
            5. Add tomato puree, coriander powder, turmeric powder, red chili powder, and salt. Cook until oil separates.
            6. Add cooked rajma and simmer for 10-12 minutes.
            7. Stir in fresh cream (if using) and simmer for another 2-3 minutes.
            8. Garnish with chopped coriander leaves and serve hot with steamed rice.
        """.trimIndent()
        ),
        Food(
            categoryId = "Lunch",
            name = "Dal Tadka",
            description = "Yellow lentils tempered with cumin seeds, garlic, and spices",
            imageUrl = "https://img.freepik.com/free-photo/delicious-soup-made-with-peanuts_23-2150361186.jpg?t=st=1720253762~exp=1720257362~hmac=78b7e526cebeae2a772d9ed43dfd45de69de558bf85a866b64d2a3ca9ee3252b&w=360",
            isGlutenFree = true,
            isVegan = true,
            isVegetarian = true,
            isLactoseFree = true,
            ingredients = """
            - 1 cup yellow lentils (toor dal), washed and soaked for 30 minutes
            - 1 onion, finely chopped
            - 2 tomatoes, chopped
            - 1 tbsp ginger-garlic paste
            - 1/2 tsp cumin seeds
            - 1/2 tsp mustard seeds
            - 1/2 tsp turmeric powder
            - 1 tsp red chili powder
            - 1/2 tsp garam masala
            - Fresh coriander leaves, chopped for garnish
            - Lemon wedges for serving
        """.trimIndent(),
            recipeDetails = """
            1. Pressure cook soaked lentils until soft. Mash lightly and set aside.
            2. Heat oil in a pan, add mustard seeds and cumin seeds, and sauté until they crackle.
            3. Add chopped onions and cook until golden brown.
            4. Add ginger-garlic paste and sauté for a minute.
            5. Add chopped tomatoes, turmeric powder, red chili powder, garam masala, and salt. Cook until tomatoes are soft.
            6. Add cooked lentils and simmer for 5-7 minutes.
            7. Garnish with chopped coriander leaves and serve hot with rice or roti.
        """.trimIndent()
        ),
        Food(
            categoryId = "Lunch",
            name = "Aloo Gobi",
            description = "Stir-fried cauliflower and potatoes with spices",
            imageUrl = "https://img.freepik.com/premium-photo/dry-potato-vegetable-fry-recipe-with-onion-pyaj-paratha-served-with-mango-pickle-achar-indian-food_466689-2921.jpg?w=1060",
            isGlutenFree = true,
            isVegan = true,
            isVegetarian = true,
            isLactoseFree = true,
            ingredients = """
            - 1 medium cauliflower, cut into florets
            - 2 potatoes, peeled and cubed
            - 1 onion, finely chopped
            - 2 tomatoes, chopped
            - 1 tbsp ginger-garlic paste
            - 1/2 tsp cumin seeds
            - 1/2 tsp turmeric powder
            - 1 tsp red chili powder
            - 1 tsp cumin powder
            - Salt to taste
            - Fresh coriander leaves, chopped for garnish
        """.trimIndent(),
            recipeDetails = """
            1. Heat oil in a pan, add cumin seeds, and sauté until fragrant.
            2. Add chopped onions and cook until golden brown.
            3. Add ginger-garlic paste and sauté for a minute.
            4. Add chopped tomatoes, turmeric powder, red chili powder, cumin powder, and salt. Cook until tomatoes are soft.
            5. Add cubed potatoes and cauliflower florets. Mix well to coat with the spices.
            6. Cover and cook on low heat until potatoes and cauliflower are tender, stirring occasionally.
            7. Garnish with chopped coriander leaves and serve hot with roti or rice.
        """.trimIndent()
        ),




        // Dessert Category
  /*  Food(
        categoryId = 7, // Dessert
        name = "Chocolate Chip Cookies",
        description = "Classic cookies loaded with chocolate chips",
        imageUrl = "https://spoonacular.com/recipeImages/716525-312x231.jpg",
        isGlutenFree = false,
        isVegan = false,
        isVegetarian = true,
        isLactoseFree = false,
        ingredients = """
            - 1 cup unsalted butter, softened
            - 1 cup granulated sugar
            - 1 cup packed brown sugar
            - 2 large eggs
            - 1 tsp vanilla extract
            - 3 cups all-purpose flour
            - 1 tsp baking soda
            - 1/2 tsp salt
            - 2 cups semisweet chocolate chips
        """.trimIndent(),
        recipeDetails = """
            1. Preheat oven to 350°F. Line baking sheets with parchment paper.
            2. In a large bowl, beat softened butter, granulated sugar, and packed brown sugar until creamy.
            3. Add eggs, one at a time, beating well after each addition. Stir in vanilla extract.
            4. In a separate bowl, whisk together all-purpose flour, baking soda, and salt.
            5. Gradually add flour mixture to butter mixture, beating until combined.
            6. Stir in semisweet chocolate chips.
            7. Drop tablespoonfuls of dough onto prepared baking sheets.
            8. Bake for 10-12 minutes or until edges are golden brown.
            9. Cool on baking sheets for 2 minutes before transferring to wire racks to cool completely.
        """.trimIndent()
    ),
    Food(
        categoryId = 7, // Dessert
        name = "Cheesecake",
        description = "Creamy cheesecake with a graham cracker crust",
        imageUrl = "https://spoonacular.com/recipeImages/716609-312x231.jpg",
        isGlutenFree = false,
        isVegan = false,
        isVegetarian = true,
        isLactoseFree = false,
        ingredients = """
            - 1 1/2 cups graham cracker crumbs
            - 1/4 cup granulated sugar
            - 1/2 cup unsalted butter, melted
            - 4 packages (8 oz each) cream cheese, softened
            - 1 cup granulated sugar
            - 1 tsp vanilla extract
            - 4 large eggs
            - 1 cup sour cream
            - Fresh berries for garnish
        """.trimIndent(),
        recipeDetails = """
            1. Preheat oven to 325°F. Grease a 9-inch springform pan.
            2. In a medium bowl, combine graham cracker crumbs, granulated sugar, and melted butter. Press mixture into the bottom of the prepared pan.
            3. In a large bowl, beat softened cream cheese, granulated sugar, and vanilla extract until smooth.
            4. Add eggs one at a time, beating well after each addition. Stir in sour cream.
            5. Pour cream cheese mixture over crust in the pan.
            6. Bake for 55-60 minutes or until center is set.
            7. Cool in the pan on a wire rack for 10 minutes.
            8. Run a knife around the edge of the pan to loosen; cool completely.
            9. Chill in the refrigerator for at least 4 hours or overnight.
            10. Garnish with fresh berries before serving.
        """.trimIndent()
    ),
    Food(
        categoryId = 7, // Dessert
        name = "Tiramisu",
        description = "Classic Italian dessert made with layers of coffee-soaked ladyfingers and mascarpone cream",
        imageUrl = "https://spoonacular.com/recipeImages/716575-312x231.jpg",
        isGlutenFree = false,
        isVegan = false,
        isVegetarian = true,
        isLactoseFree = false,
        ingredients = """
            - 1 1/2 cups strong brewed coffee, cooled
            - 1/4 cup coffee liqueur (optional)
            - 24 ladyfinger cookies
            - 16 oz mascarpone cheese, softened
            - 1 cup powdered sugar
            - 1 tsp vanilla extract
            - 1 cup heavy cream, chilled
            - Cocoa powder for dusting
        """.trimIndent(),
        recipeDetails = """
            1. In a shallow dish, combine cooled brewed coffee and coffee liqueur if using.
            2. Quickly dip each ladyfinger into the coffee mixture and line the bottom of a 9x13-inch dish.
            3. In a large bowl, beat softened mascarpone cheese, powdered sugar, and vanilla extract until smooth.
            4. In another bowl, whip chilled heavy cream until stiff peaks form.
            5. Gently fold whipped cream into mascarpone mixture until combined.
            6. Spread half of the mascarpone mixture over the ladyfingers in the dish.
            7. Repeat with another layer of dipped ladyfingers and remaining mascarpone mixture.
            8. Cover and refrigerate for at least 2 hours or overnight.
            9. Before serving, dust with cocoa powder.
        """.trimIndent()
    ),
    Food(
        categoryId = 7, // Dessert
        name = "Lemon Bars",
        description = "Tangy lemon bars with a buttery shortbread crust",
        imageUrl = "https://spoonacular.com/recipeImages/716482-312x231.jpg",
        isGlutenFree = false,
        isVegan = false,
        isVegetarian = true,
        isLactoseFree = false,
        ingredients = """
            - 1 cup unsalted butter, softened
            - 1/2 cup powdered sugar
            - 2 cups all-purpose flour
            - 4 large eggs
            - 1 1/2 cups granulated sugar
            - 1/4 cup all-purpose flour
            - 2/3 cup fresh lemon juice
            - Zest of 1 lemon
            - Powdered sugar for dusting
        """.trimIndent(),
        recipeDetails = """
            1. Preheat oven to 350°F. Grease a 9x13-inch baking pan.
            2. In a large bowl, beat softened butter and powdered sugar until creamy.
            3. Gradually add 2 cups all-purpose flour, beating until mixture resembles coarse crumbs.
            4. Press mixture evenly into the bottom of the prepared baking pan.
            5. Bake for 20-25 minutes or until edges are lightly golden.
            6. In another bowl, whisk together eggs, granulated sugar, 1/4 cup all-purpose flour, lemon juice, and lemon zest until well combined.
            7. Pour lemon mixture over baked crust.
            8. Return to oven and bake for an additional 20-25 minutes or until set.
            9. Cool completely in the pan on a wire rack.
            10. Dust with powdered sugar before cutting into bars.
        """.trimIndent()
    ),
    Food(
        categoryId = 7, // Dessert
        name = "Berry Parfait",
        description = "Layers of yogurt, granola, and fresh berries",
        imageUrl = "https://spoonacular.com/recipeImages/716517-312x231.jpg",
        isGlutenFree = false,
        isVegan = false,
        isVegetarian = true,
        isLactoseFree = false,
        ingredients = """
            - 2 cups Greek yogurt
            - 1/2 cup granola
            - 1 cup fresh mixed berries (strawberries, blueberries, raspberries)
            - Honey for drizzling
        """.trimIndent(),
        recipeDetails = """
            1. In serving glasses or bowls, layer Greek yogurt, granola, and fresh mixed berries.
            2. Repeat layers.
            3. Drizzle with honey.
            4. Serve immediately.
        """.trimIndent()
    ),

    // Snack Category
    Food(
        categoryId = 8, // Snack
        name = "Guacamole",
        description = "Creamy avocado dip with tomatoes, onions, cilantro, and lime juice",
        imageUrl = "https://spoonacular.com/recipeImages/716540-312x231.jpg",
        isGlutenFree = true,
        isVegan = true,
        isVegetarian = true,
        isLactoseFree = true,
        ingredients = """
            - 3 ripe avocados, peeled and pitted
            - 1 lime, juiced
            - 1/2 tsp salt
            - 1/2 tsp ground cumin
            - 1/2 tsp cayenne pepper (optional)
            - 1/2 cup diced red onion
            - 1/2 cup diced tomatoes
            - 1/4 cup chopped fresh cilantro
            - Tortilla chips for serving
        """.trimIndent(),
        recipeDetails = """
            1. In a bowl, mash avocados with lime juice, salt, ground cumin, and cayenne pepper if using.
            2. Fold in diced red onion, diced tomatoes, and chopped fresh cilantro.
            3. Taste and adjust seasoning if necessary.
            4. Serve with tortilla chips.
        """.trimIndent()
    ),
    Food(
        categoryId = 8, // Snack
        name = "Hummus",
        description = "Smooth and creamy chickpea dip with tahini, garlic, and lemon juice",
        imageUrl = "https://spoonacular.com/recipeImages/716572-312x231.jpg",
        isGlutenFree = true,
        isVegan = true,
        isVegetarian = true,
        isLactoseFree = true,
        ingredients = """
            - 1 can (15 oz) chickpeas, drained and rinsed
            - 1/4 cup tahini
            - 1/4 cup water
            - 1/4 cup olive oil
            - 1 clove garlic, minced
            - Juice of 1 lemon
            - 1/2 tsp ground cumin
            - Salt and pepper to taste
            - Paprika and olive oil for garnish
        """.trimIndent(),
        recipeDetails = """
            1. In a food processor, combine chickpeas, tahini, water, olive oil, minced garlic, lemon juice, ground cumin, salt, and pepper.
            2. Process until smooth and creamy, scraping down sides as needed.
            3. Taste and adjust seasoning if necessary.
            4. Transfer to a serving bowl, drizzle with olive oil, and sprinkle with paprika.
            5. Serve with pita bread, crackers, or fresh vegetables.
        """.trimIndent()
    ),
    Food(
        categoryId = 8, // Snack
        name = "Fruit Salad",
        description = "Fresh assortment of seasonal fruits",
        imageUrl = "https://spoonacular.com/recipeImages/716469-312x231.jpg",
        isGlutenFree = true,
        isVegan = true,
        isVegetarian = true,
        isLactoseFree = true,
        ingredients = """
            - 2 cups cubed watermelon
            - 1 cup sliced strawberries
            - 1 cup blueberries
            - 1 cup green grapes
            - 1/4 cup fresh mint leaves
            - Honey and lime juice for drizzling
        """.trimIndent(),
        recipeDetails = """
            1. In a large bowl, combine cubed watermelon, sliced strawberries, blueberries, green grapes, and fresh mint leaves.
            2. Drizzle with honey and lime juice.
            3. Toss gently to combine.
            4. Serve chilled.
        """.trimIndent()
    ),
    Food(
        categoryId = 8, // Snack
        name = "Bruschetta",
        description = "Toasted bread topped with a mixture of tomatoes, garlic, basil, and olive oil",
        imageUrl = "https://spoonacular.com/recipeImages/716573-312x231.jpg",
        isGlutenFree = false,
        isVegan = true,
        isVegetarian = true,
        isLactoseFree = true,
        ingredients = """
            - 1 baguette, sliced
            - 4 tomatoes, diced
            - 2 cloves garlic, minced
            - 1/4 cup chopped fresh basil
            - 2 tbsp extra virgin olive oil
            - Balsamic glaze for drizzling
            - Salt and pepper to taste
        """.trimIndent(),
        recipeDetails = """
            1. Preheat oven to 375°F. Arrange baguette slices on a baking sheet.
            2. Bake for 5-7 minutes or until golden brown and crisp.
            3. In a bowl, combine diced tomatoes, minced garlic, chopped fresh basil, and extra virgin olive oil.
            4. Season with salt and pepper to taste.
            5. Spoon tomato mixture onto toasted baguette slices.
            6. Drizzle with balsamic glaze.
            7. Serve immediately.
        """.trimIndent()
    ),
    Food(
        categoryId = 8, // Snack
        name = "Trail Mix",
        description = "A blend of nuts, dried fruits, and chocolate",
        imageUrl = "https://spoonacular.com/recipeImages/716614-312x231.jpg",
        isGlutenFree = true,
        isVegan = true,
        isVegetarian = true,
        isLactoseFree = true,
        ingredients = """
            - 1 cup almonds
            - 1 cup cashews
            - 1 cup dried cranberries
            - 1 cup dark chocolate chips
            - 1 cup pretzel sticks
        """.trimIndent(),
        recipeDetails = """
            1. In a large bowl, combine almonds, cashews, dried cranberries, dark chocolate chips, and pretzel sticks.
            2. Toss gently to mix.
            3. Store in an airtight container.
            4. Serve as a snack or pack into individual portions.
        """.trimIndent()
    ),

    // Drink Category
    Food(
        categoryId = 9, // Drink
        name = "Smoothie",
        description = "Refreshing blend of fruits, yogurt, and juice",
        imageUrl = "https://spoonacular.com/recipeImages/716537-312x231.jpg",
        isGlutenFree = true,
        isVegan = false,
        isVegetarian = true,
        isLactoseFree = false,
        ingredients = """
            - 1 cup mixed berries (strawberries, blueberries, raspberries)
            - 1 banana, sliced
            - 1 cup Greek yogurt
            - 1/2 cup orange juice
            - Honey or agave syrup (optional)
            - Ice cubes
        """.trimIndent(),
        recipeDetails = """
            1. In a blender, combine mixed berries, sliced banana, Greek yogurt, orange juice, and honey or agave syrup if using.
            2. Add ice cubes to achieve desired consistency.
            3. Blend until smooth.
            4. Pour into glasses and serve immediately.
        """.trimIndent()
    ),
    Food(
        categoryId = 9, // Drink
        name = "Iced Coffee",
        description = "Chilled coffee with milk and sweetener, served over ice",
        imageUrl = "https://spoonacular.com/recipeImages/716606-312x231.jpg",
        isGlutenFree = true,
        isVegan = false,
        isVegetarian = true,
        isLactoseFree = false,
        ingredients = """
            - 2 cups brewed coffee, chilled
            - 1/2 cup milk or cream
            - 2 tbsp sweetened condensed milk
            - Ice cubes
        """.trimIndent(),
        recipeDetails = """
            1. Fill glasses with ice cubes.
            2. In a pitcher, stir together chilled brewed coffee, milk or cream, and sweetened condensed milk.
            3. Pour over ice in glasses.
            4. Serve immediately.
        """.trimIndent()
    ),
    Food(
        categoryId = 9, // Drink
        name = "Green Tea",
        description = "Hot or cold brewed green tea",
        imageUrl = "https://spoonacular.com/recipeImages/716515-312x231.jpg",
        isGlutenFree = true,
        isVegan = true,
        isVegetarian = true,
        isLactoseFree = true,
        ingredients = """
            - 2 green tea bags
            - 2 cups water, hot or cold
            - Honey or sugar (optional)
            - Lemon slices (optional)
        """.trimIndent(),
        recipeDetails = """
            1. Place green tea bags in a mug or pitcher.
            2. Pour hot or cold water over tea bags.
            3. Steep for 3-5 minutes.
            4. Remove tea bags.
            5. Sweeten with honey or sugar if desired.
            6. Serve hot or refrigerate to serve cold with lemon slices if desired.
        """.trimIndent()
    ),
    Food(
        categoryId = 9, // Drink
        name = "Mango Lassi",
        description = "Refreshing Indian yogurt drink with mango and spices",
        imageUrl = "https://spoonacular.com/recipeImages/716540-312x231.jpg",
        isGlutenFree = true,
        isVegan = false,
        isVegetarian = true,
        isLactoseFree = false,
        ingredients = """
            - 1 cup ripe mango, diced
            - 1 cup plain yogurt
            - 1/2 cup milk or water
            - 2 tbsp honey or sugar (optional)
            - Pinch of ground cardamom (optional)
            - Ice cubes
        """.trimIndent(),
        recipeDetails = """
            1. In a blender, combine diced ripe mango, plain yogurt, milk or water, honey or sugar if using, and ground cardamom if using.
            2. Add ice cubes to achieve desired consistency.
            3. Blend until smooth.
            4. Pour into glasses and serve immediately.
        """.trimIndent()
    ),
    Food(
        categoryId = 9, // Drink
        name = "Strawberry Lemonade",
        description = "Refreshing lemonade with fresh strawberries",
        imageUrl = "https://spoonacular.com/recipeImages/716580-312x231.jpg",
        isGlutenFree = true,
        isVegan = true,
        isVegetarian = true,
        isLactoseFree = true,
        ingredients = """
            - 1 cup fresh strawberries, hulled
            - 1 cup fresh lemon juice
            - 1/2 cup granulated sugar
            - 4 cups cold water
            - Ice cubes
            - Lemon slices for garnish
        """.trimIndent(),
        recipeDetails = """
            1. In a blender, combine fresh strawberries, fresh lemon juice, and granulated sugar.
            2. Blend until smooth.
            3. Pour strawberry mixture into a pitcher.
            4. Add cold water and stir well.
            5. Serve over ice cubes.
            6. Garnish with lemon slices.
        """.trimIndent()
    ),*/


            // Existing foods...

            // Chicken Category
            Food(
                categoryId = "Chicken", // Chicken
                name = "Chicken Tikka Masala",
                description = "Grilled chicken cooked in a creamy tomato sauce with Indian spices",
                imageUrl = "https://www.modernhoney.com/wp-content/uploads/2018/10/Chicken-Tikka-Masala-1-c.jpg",
                isGlutenFree = false,
                isVegan = false,
                isVegetarian = false,
                isLactoseFree = false,
                ingredients = """
            - 500g boneless chicken thighs
            - 1 cup plain yogurt
            - 2 tbsp vegetable oil
            - 1 onion, finely chopped
            - 2 tsp ginger-garlic paste
            - 1 cup tomato puree
            - 1 tsp garam masala
            - Salt and pepper to taste
        """.trimIndent(),
                recipeDetails = """
            1. Marinate chicken in yogurt, salt, and garam masala for 1 hour.
            2. Heat oil in a pan and sauté onions until golden brown.
            3. Add ginger-garlic paste and cook until fragrant.
            4. Add tomato puree, salt, and pepper. Cook until oil separates.
            5. Add marinated chicken and cook until tender.
            6. Garnish with cilantro and serve hot with rice or naan.
        """.trimIndent()
            ),

    // Breakfast Category
        Food(
            categoryId = "Breakfast",
            name = "Masala Dosa",
            description = "Thin, crispy crepe made from fermented rice and lentil batter, filled with spiced potatoes",
            imageUrl = "https://img.freepik.com/free-photo/delicious-indian-dosa-composition_23-2149086052.jpg?t=st=1720251770~exp=1720255370~hmac=17e5a3022a4c73a847235776a44f526aff6738fd03b40847979848080aff877a&w=360",
            isGlutenFree = true,
            isVegan = true,
            isVegetarian = true,
            isLactoseFree = true,
            ingredients = """
            - 1 cup rice
            - 1/2 cup urad dal (black gram lentils)
            - Salt to taste
            - Oil for cooking
            - 2 medium potatoes, boiled and mashed
            - 1 onion, finely chopped
            - 1 green chili, chopped
            - 1/2 tsp mustard seeds
            - 1/2 tsp cumin seeds
            - A pinch of asafoetida (hing)
            - Curry leaves
            - Turmeric powder
            - Fresh coriander leaves, chopped
        """.trimIndent(),
            recipeDetails = """
            1. Soak rice and urad dal separately in water for 4-6 hours.
            2. Drain and blend together to form a smooth batter, adding water as needed.
            3. Add salt and let the batter ferment overnight or for 8-10 hours.
            4. Heat a non-stick skillet or dosa pan over medium heat.
            5. Pour a ladleful of batter in the center and spread it in a circular motion to form a thin crepe.
            6. Drizzle oil around the edges and cook until golden and crisp.
            7. For the filling, heat oil in a pan, add mustard seeds, cumin seeds, asafoetida, and curry leaves.
            8. Add chopped onion, green chili, and sauté until onions are translucent.
            9. Add turmeric powder, mashed potatoes, salt, and mix well. Cook for 2-3 minutes.
            10. Place a portion of the potato filling in the center of the dosa, fold and serve hot with coconut chutney and sambar.
        """.trimIndent()
        ),
        Food(
            categoryId = "Breakfast",
            name = "Poha",
            description = "Flattened rice flakes tempered with mustard seeds, curry leaves, and spices",
            imageUrl = "https://img.freepik.com/premium-photo/kande-pohe-aloo-poha-is-popular-indian-breakfast-recipe-made-using-flattened-rice-usually-served-with-hot-tea_466689-47715.jpg?w=1060",
            isGlutenFree = true,
            isVegan = true,
            isVegetarian = true,
            isLactoseFree = true,
            ingredients = """
            - 1 cup poha (flattened rice flakes)
            - 1 onion, finely chopped
            - 1 potato, boiled and diced
            - 1/2 cup green peas
            - 1/2 tsp mustard seeds
            - 1/2 tsp cumin seeds
            - 1/2 tsp turmeric powder
            - A pinch of asafoetida (hing)
            - 1 green chili, chopped
            - Curry leaves
            - Fresh coriander leaves, chopped
            - Salt to taste
            - Lemon juice
        """.trimIndent(),
            recipeDetails = """
            1. Rinse poha in a colander under running water until softened. Set aside.
            2. Heat oil in a pan, add mustard seeds, cumin seeds, asafoetida, and curry leaves.
            3. Add chopped onion, green chili, and sauté until onions are translucent.
            4. Add turmeric powder, diced potatoes, green peas, and salt. Mix well and cook for 3-4 minutes.
            5. Add rinsed poha to the pan, mix gently to combine with the potato mixture.
            6. Cover and cook on low heat for 2-3 minutes.
            7. Remove from heat, drizzle with lemon juice, and garnish with fresh coriander leaves.
            8. Serve hot with a side of coconut chutney or yogurt.
        """.trimIndent()
        ),

    // Dessert Category
    Food(
        categoryId = "Dessert", // Dessert
        name = "Chocolate Lava Cake",
        description = "Rich chocolate cake with a gooey, molten chocolate center",
        imageUrl = "https://img.freepik.com/free-photo/dessert-cake-with-chocolate-jam_144627-6614.jpg?t=st=1720253909~exp=1720257509~hmac=f73f2ce531ccca35ffbec1651a5c141647eb9fc84a2262ffcf56608932092c7c&w=1060",
        isGlutenFree = false,
        isVegan = false,
        isVegetarian = true,
        isLactoseFree = false,
        ingredients = """
            - 4 oz semi-sweet chocolate
            - 1/2 cup unsalted butter
            - 1 cup powdered sugar
            - 2 eggs + 2 egg yolks
            - 1/2 cup all-purpose flour
            - Vanilla ice cream for serving
        """.trimIndent(),
        recipeDetails = """
            1. Preheat oven to 425°F. Grease four ramekins with butter and dust with cocoa powder.
            2. Melt chocolate and butter in a microwave-safe bowl until smooth.
            3. Stir in powdered sugar until well combined.
            4. Add eggs and egg yolks, one at a time, stirring well after each addition.
            5. Fold in flour until just combined.
            6. Divide batter evenly among prepared ramekins.
            7. Bake for 12-14 minutes, until the edges are firm but the center is soft.
            8. Let cool for 1 minute. Invert onto plates and serve immediately with vanilla ice cream.
        """.trimIndent()
    ),

    // Drinks Category
    Food(
        categoryId = "Drinks", // Drinks
        name = "Mojito",
        description = "Classic Cuban cocktail made with fresh mint leaves, lime juice, white rum, soda water, and sugar",
        imageUrl = "https://img.freepik.com/free-photo/front-view-blue-cool-lemonade-with-ice-blue-background-fruit-cold-cocktail-drink-color-bar-juice_140725-156766.jpg?t=st=1720250859~exp=1720254459~hmac=e119911b96fe9f46a5e58391cde1633dcae8ccdfff0d22cfc9332e3a5bcaa533&w=360",
        isGlutenFree = true,
        isVegan = true,
        isVegetarian = true,
        isLactoseFree = true,
        ingredients = """
            - 10 fresh mint leaves
            - 1/2 lime, cut into wedges
            - 2 tbsp white sugar
            - 2 oz white rum
            - 1/2 cup soda water
            - Ice cubes
        """.trimIndent(),
        recipeDetails = """
            1. Place mint leaves and lime wedges in a sturdy glass.
            2. Use a muddler to crush the mint and lime to release the mint oils and lime juice.
            3. Add sugar and continue to muddle.
            4. Fill the glass almost to the top with ice cubes.
            5. Pour rum over the ice and fill the glass with soda water.
            6. Stir well and garnish with a lime wedge and mint sprig.
        """.trimIndent()
    ),

    // Vegan Category
    Food(
        categoryId = "Vegan", // Vegan
        name = "Chickpea Curry",
        description = "A flavorful vegan curry made with chickpeas, tomatoes, and coconut milk",
        imageUrl = "https://img.freepik.com/free-photo/delicious-cooked-beans-bowl_23-2148746863.jpg?t=st=1720254000~exp=1720257600~hmac=c2f2f0df4c98c3872c301cf8c7d8086fc6655c2917911a56afeb7f9a6f00b84e&w=900",
        isGlutenFree = true,
        isVegan = true,
        isVegetarian = true,
        isLactoseFree = true,
        ingredients = """
            - 1 tbsp coconut oil
            - 1 onion, finely chopped
            - 3 cloves garlic, minced
            - 1 tbsp ginger, grated
            - 1 tbsp curry powder
            - 1 can (15 oz) chickpeas, drained and rinsed
            - 1 can (15 oz) diced tomatoes
            - 1 can (14 oz) coconut milk
            - Salt and pepper to taste
        """.trimIndent(),
        recipeDetails = """
            1. Heat coconut oil in a large skillet over medium heat.
            2. Add chopped onion and sauté until translucent.
            3. Stir in minced garlic, grated ginger, and curry powder. Cook until fragrant.
            4. Add chickpeas, diced tomatoes (with juices), and coconut milk.
            5. Season with salt and pepper. Simmer for 15-20 minutes, stirring occasionally.
            6. Serve hot with rice or naan.
        """.trimIndent()
    ),

    // Lunch Category




    // Indian Category
     Food(
            categoryId = "Indian",
            name = "Rogan Josh",
            description = "Tender lamb cooked in a rich, aromatic gravy with Kashmiri spices",
            imageUrl = "https://th.bing.com/th/id/OIP.8B8-BAn-yXwFQpNVoFa2-wHaHa?rs=1&pid=ImgDetMain",
            isGlutenFree = true,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = true,
            ingredients = """
            - 500g lamb, cut into pieces
            - 2 onions, finely chopped
            - 2 tomatoes, pureed
            - 1 tbsp ginger-garlic paste
            - 1/2 cup yogurt
            - 2 tbsp Kashmiri red chili powder
            - 1 tsp cumin seeds
            - 1 tsp coriander powder
            - 1/2 tsp turmeric powder
            - 1/2 tsp garam masala
            - Fresh coriander leaves, chopped for garnish
        """.trimIndent(),
            recipeDetails = """
            1. Heat oil in a pan, add cumin seeds, and sauté until fragrant.
            2. Add chopped onions and cook until golden brown.
            3. Add ginger-garlic paste and sauté for a minute.
            4. Add tomato puree, Kashmiri red chili powder, coriander powder, turmeric powder, and salt. Cook until oil separates.
            5. Add yogurt and cook until the gravy thickens.
            6. Add lamb pieces and simmer until tender.
            7. Sprinkle garam masala and garnish with chopped coriander leaves.
            8. Serve hot with naan or rice.
        """.trimIndent()
        ),
        Food(
            categoryId = "Indian",
            name = "Dhokla",
            description = "Steamed savory cakes made from fermented rice and chickpea batter, tempered with mustard seeds and curry leaves",
            imageUrl = "https://th.bing.com/th/id/OIP.3kkjkUOSU1bdWPkYHYPDlQHaHa?rs=1&pid=ImgDetMain",
            isGlutenFree = true,
            isVegan = true,
            isVegetarian = true,
            isLactoseFree = true,
            ingredients = """
            - 1 cup rice, soaked for 4-6 hours
            - 1/2 cup split chickpeas (chana dal), soaked for 4-6 hours
            - 1/2 cup yogurt
            - 1 tbsp ginger-green chili paste
            - 1/2 tsp turmeric powder
            - 1 tsp fruit salt (eno)
            - Salt to taste
            - Fresh coriander leaves, chopped for garnish
            - For tempering: oil, mustard seeds, curry leaves
        """.trimIndent(),
            recipeDetails = """
            1. Drain soaked rice and chickpeas, blend into a smooth batter with yogurt, ginger-green chili paste, turmeric powder, and salt.
            2. Add fruit salt and mix well. Pour into greased steaming trays.
            3. Steam for 15-20 minutes until a toothpick inserted comes out clean.
            4. For tempering, heat oil in a pan, add mustard seeds and curry leaves, and sauté until they crackle.
            5. Pour tempering over steamed dhokla.
            6. Garnish with chopped coriander leaves and serve warm with green chutney.
        """.trimIndent()
        ),
        Food(
            categoryId = "Indian",
            name = "Hyderabadi Biryani",
            description = "Fragrant rice dish with marinated chicken or mutton, layered with aromatic spices and caramelized onions",
            imageUrl = "https://img.freepik.com/free-photo/top-view-pakistan-meal-assortment_23-2148821514.jpg?t=st=1720255009~exp=1720258609~hmac=e3e4a6e2f1e72809477b47d07cd21e161ee3b5b6f60706ec9d920098aa6d569f&w=360",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = true,
            ingredients = """
            - 1 cup basmati rice, soaked for 30 minutes
            - 250g chicken or mutton, cut into pieces
            - 2 onions, thinly sliced
            - 2 tomatoes, chopped
            - 1/2 cup yogurt
            - 2 tbsp biryani masala
            - 1 tsp turmeric powder
            - 1 tsp red chili powder
            - A pinch of saffron strands, soaked in 2 tbsp warm milk
            - Fresh coriander leaves, chopped for garnish
            - Fried onions for garnish
        """.trimIndent(),
            recipeDetails = """
            1. Heat oil in a pan, add thinly sliced onions, and fry until golden brown. Remove and set aside.
            2. In the same pan, add chicken or mutton pieces and sauté until browned.
            3. Add chopped tomatoes, biryani masala, turmeric powder, red chili powder, and salt. Cook until tomatoes are soft.
            4. In a separate pot, boil water and add soaked rice. Cook until rice is 70% done. Drain and set aside.
            5. Layer the cooked meat masala and rice in the pot. Sprinkle fried onions, saffron milk, and chopped coriander leaves between layers.
            6. Cover and cook on low heat for 10-15 minutes until rice is fully cooked and aromatic.
            7. Serve hot with raita and salad.
        """.trimIndent()
        ),
        Food(
            categoryId = "Indian",
            name = "Fish Curry",
            description = "Fish simmered in a spicy coconut milk gravy with curry leaves and mustard seeds",
            imageUrl = "https://img.freepik.com/free-photo/top-view-delicious-fish-meal-tray_23-2148734692.jpg?t=st=1720255040~exp=1720258640~hmac=6f55f3596b8c4db4835fe4e2f410ea293d76622e0aa4620b583ed3f67bcd42c9&w=1060",
            isGlutenFree = true,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = false,
            ingredients = """
            - 500g fish fillets (any firm fish), cut into pieces
            - 1 onion, finely chopped
            - 2 tomatoes, chopped
            - 1/2 cup coconut milk
            - 1 tbsp ginger-garlic paste
            - 1/2 tsp mustard seeds
            - 1/2 tsp turmeric powder
            - 1 tsp red chili powder
            - Curry leaves
            - Fresh coriander leaves, chopped for garnish
            - Salt to taste
        """.trimIndent(),
            recipeDetails = """
            1. Heat oil in a pan, add mustard seeds and curry leaves, and sauté until they crackle.
            2. Add chopped onions and cook until golden brown.
            3. Add ginger-garlic paste and sauté for a minute.
            4. Add chopped tomatoes, turmeric powder, red chili powder, and salt. Cook until tomatoes are soft.
            5. Add fish pieces and coconut milk. Simmer gently until fish is cooked through.
            6. Garnish with chopped coriander leaves and serve hot with steamed rice.
        """.trimIndent()
        ),
        Food(
            categoryId = "Indian",
            name = "Gatte ki Sabzi",
            description = "Rajasthani dish made with gram flour (besan) dumplings simmered in a yogurt-based gravy",
            imageUrl = "https://i2.wp.com/vegecravings.com/wp-content/uploads/2017/06/Gatte-Ki-Sabzi-Recipe-Step-By-Step-Instructions.jpg?fit=2243%2C1908&quality=65&strip=all&ssl=1",
            isGlutenFree = true,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - For Gatte (dumplings):
                - 1 cup gram flour (besan)
                - 1/4 tsp turmeric powder
                - 1/2 tsp red chili powder
                - Salt to taste
                - Water, as needed
            - For Gravy:
                - 1 cup yogurt
                - 1 onion, finely chopped
                - 2 tomatoes, pureed
                - 1 tbsp ginger-garlic paste
                - 1/2 tsp cumin seeds
                - 1/2 tsp mustard seeds
                - 1/2 tsp turmeric powder
                - 1 tsp red chili powder
                - Fresh coriander leaves, chopped for garnish
        """.trimIndent(),
            recipeDetails = """
            1. For Gatte: Mix gram flour with turmeric powder, red chili powder, salt, and enough water to form a stiff dough.
            2. Divide the dough into small portions and shape into cylindrical dumplings (gatte).
            3. Boil gatte in water until they float. Drain and set aside.
            4. For Gravy: Heat oil in a pan, add cumin seeds, mustard seeds, and sauté until they crackle.
            5. Add chopped onions and cook until golden brown.
            6. Add ginger-garlic paste and sauté for a minute.
            7. Add tomato puree, turmeric powder, red chili powder, and salt. Cook until oil separates.
            8. Whisk yogurt and gradually add to the pan, stirring continuously. Cook until the gravy thickens.
            9. Add boiled gatte to the gravy and simmer for 5-7 minutes.
            10. Garnish with chopped coriander leaves and serve hot with roti or rice.
        """.trimIndent()
        ),
        Food(
            categoryId = "Indian",
            name = "Pongal",
            description = "South Indian dish made with rice and lentils, tempered with black pepper, cumin, and curry leaves",
            imageUrl = "https://recipes.timesofindia.com/photo/61051454.cms",
            isGlutenFree = true,
            isVegan = true,
            isVegetarian = true,
            isLactoseFree = true,
            ingredients = """
            - 1/2 cup rice
            - 1/4 cup split yellow moong dal (lentils)
            - 1 tsp black pepper
            - 1 tsp cumin seeds
            - A pinch of asafoetida (hing)
            - 10-12 curry leaves
            - Salt to taste
            - Fresh coriander leaves, chopped for garnish
        """.trimIndent(),
            recipeDetails = """
            1. Dry roast rice and moong dal until lightly golden.
            2. Pressure cook with 3 cups of water, black pepper, cumin seeds, asafoetida, curry leaves, and salt until well-cooked and mashed.
            3. For tempering, heat ghee in a pan, add mustard seeds, cumin seeds, and curry leaves, and sauté until they crackle.
            4. Pour tempering over cooked pongal.
            5. Garnish with chopped coriander leaves and serve hot with coconut chutney.
        """.trimIndent()
        ),



     Food(
            categoryId = "Sandwiches",
            name = "Grilled Cheese Sandwich",
            description = "A classic sandwich with melted cheese between two slices of grilled bread",
            imageUrl = "https://img.freepik.com/premium-photo/broccoli-cheese-sandwiches-wooden-cutting-board-concrete-slate-background_156140-1108.jpg?w=1060",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - 4 slices of bread
            - 4 slices of cheddar cheese
            - 2 tbsp butter
        """.trimIndent(),
            recipeDetails = """
            1. Heat a skillet over medium heat.
            2. Butter one side of each slice of bread.
            3. Place two slices of bread, buttered side down, on the skillet.
            4. Add two slices of cheese on each piece of bread.
            5. Top with remaining slices of bread, buttered side up.
            6. Cook until bread is golden brown and cheese is melted, about 2-3 minutes per side.
            7. Serve hot.
        """.trimIndent()
        ),
        Food(
            categoryId = "Sandwiches",
            name = "Caprese Sandwich",
            description = "A fresh and flavorful sandwich with tomatoes, mozzarella, and basil",
            imageUrl = "https://img.freepik.com/free-photo/baguette-cheese-wooden_155003-2885.jpg?t=st=1720266060~exp=1720269660~hmac=49716f8fbcd76dd26f73e9dc1dc4c2c5fe515c60d6c03e7be302d898c131178e&w=360",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - 4 slices of ciabatta bread
            - 2 large tomatoes, sliced
            - 8 slices of fresh mozzarella cheese
            - Fresh basil leaves
            - 2 tbsp balsamic glaze
            - 2 tbsp olive oil
        """.trimIndent(),
            recipeDetails = """
            1. Drizzle olive oil on each slice of bread.
            2. Layer tomato slices, mozzarella cheese, and basil leaves on two slices of bread.
            3. Drizzle balsamic glaze over the basil.
            4. Top with remaining bread slices.
            5. Serve immediately.
        """.trimIndent()
        ),
        Food(
            categoryId = "Sandwiches",
            name = "Chicken Salad Sandwich",
            description = "A creamy chicken salad served between slices of bread",
            imageUrl = "https://img.freepik.com/free-photo/big-sandwich-with-chicken-kebab-lettuce_2829-16529.jpg?t=st=1720266112~exp=1720269712~hmac=710ff2fb7dff383d5a345fef5d5d059772ea5a8a38c1b26535c7b574e72ffe64&w=900",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = false,
            ingredients = """
            - 2 cups cooked chicken, shredded
            - 1/2 cup mayonnaise
            - 1/4 cup celery, finely chopped
            - 1/4 cup red onion, finely chopped
            - 1 tbsp Dijon mustard
            - Salt and pepper to taste
            - 4 slices of bread
            - Lettuce leaves
        """.trimIndent(),
            recipeDetails = """
            1. In a bowl, mix together chicken, mayonnaise, celery, red onion, and Dijon mustard.
            2. Season with salt and pepper.
            3. Spread chicken salad on two slices of bread.
            4. Top with lettuce leaves and remaining bread slices.
            5. Serve chilled.
        """.trimIndent()
        ),
        Food(
            categoryId = "Sandwiches",
            name = "Egg Salad Sandwich",
            description = "A creamy egg salad served between slices of bread",
            imageUrl = "https://img.freepik.com/free-photo/cheese-pork-hamburger_1339-8475.jpg?t=st=1720266148~exp=1720269748~hmac=e521dae5c75de954991442f37cf12776717a5244e709af2c82ecc6026dc8025a&w=1060",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = false,
            ingredients = """
            - 4 hard-boiled eggs, chopped
            - 1/4 cup mayonnaise
            - 1 tbsp Dijon mustard
            - 1 tbsp fresh dill, chopped
            - Salt and pepper to taste
            - 4 slices of bread
            - Lettuce leaves
        """.trimIndent(),
            recipeDetails = """
            1. In a bowl, mix together chopped eggs, mayonnaise, Dijon mustard, and fresh dill.
            2. Season with salt and pepper.
            3. Spread egg salad on two slices of bread.
            4. Top with lettuce leaves and remaining bread slices.
            5. Serve chilled.
        """.trimIndent()
        ),
        Food(
            categoryId = "Sandwiches",
            name = "Turkey and Avocado Sandwich",
            description = "A healthy sandwich with turkey, avocado, and fresh vegetables",
            imageUrl = "https://img.freepik.com/free-photo/high-angle-sandwiches-with-greens-cucumber_23-2148893624.jpg?t=st=1720266189~exp=1720269789~hmac=f71718eb5bf697d7956fa835e7f5efdc7d5cf1e94838a89e6f62e49a3dd5ee2a&w=900",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = true,
            ingredients = """
            - 4 slices of whole grain bread
            - 8 slices of turkey breast
            - 1 avocado, sliced
            - 1 tomato, sliced
            - Lettuce leaves
            - 2 tbsp mayonnaise
        """.trimIndent(),
            recipeDetails = """
            1. Spread mayonnaise on each slice of bread.
            2. Layer turkey, avocado, tomato, and lettuce on two slices of bread.
            3. Top with remaining bread slices.
            4. Serve immediately.
        """.trimIndent()
        ),
        Food(
            categoryId = "Sandwiches",
            name = "Veggie Sandwich",
            description = "A colorful sandwich packed with fresh vegetables and hummus",
            imageUrl = "https://img.freepik.com/free-photo/high-angle-sandwiches-breakfast_23-2148454820.jpg?t=st=1720266227~exp=1720269827~hmac=463b9e770ad56925f10199bcd42f5d646caafff25dd11b407414eab65021466a&w=1060",
            isGlutenFree = false,
            isVegan = true,
            isVegetarian = true,
            isLactoseFree = true,
            ingredients = """
            - 4 slices of whole grain bread
            - 1/2 cup hummus
            - 1 cucumber, sliced
            - 1 tomato, sliced
            - 1/2 red bell pepper, sliced
            - 1/2 avocado, sliced
            - Fresh spinach leaves
        """.trimIndent(),
            recipeDetails = """
            1. Spread hummus on each slice of bread.
            2. Layer cucumber, tomato, bell pepper, avocado, and spinach on two slices of bread.
            3. Top with remaining bread slices.
            4. Serve immediately.
        """.trimIndent()
        ),



    Food(
            categoryId = "Hamburger", // Hamburger
            name = "Classic Cheeseburger",
            description = "Juicy plant-based patty with melted vegan cheese, lettuce, tomato, and pickles in a sesame seed bun",
            imageUrl = "https://www.unileverfoodsolutions.com.sg/dam/global-ufs/mcos/SEA/calcmenu/recipes/SG-recipes/vegetables-&-vegetable-dishes/%E7%BB%8F%E5%85%B8%E8%8A%9D%E5%A3%AB%E6%B1%89%E5%A0%A1/main-header.jpg",
            isGlutenFree = false,
            isVegan = true,
            isVegetarian = true,
            isLactoseFree = true,
            ingredients = """
            - Plant-based burger patty
            - Salt and pepper
            - Vegan cheese slice
            - Lettuce
            - Tomato slices
            - Pickles
            - Sesame seed bun
        """.trimIndent(),
            recipeDetails = """
            1. Season plant-based burger patty with salt and pepper.
            2. Grill or pan-fry until heated through.
            3. Melt vegan cheese slice on top of the patty.
            4. Toast sesame seed bun.
            5. Assemble burger with lettuce, tomato, pickles, and any desired condiments.
            6. Serve hot with fries or salad.
        """.trimIndent()
        ),
        Food(
            categoryId = "Hamburger", // Hamburger
            name = "BBQ Mushroom Burger",
            description = "Portobello mushroom cap topped with sautéed vegetables, vegan cheese, and barbecue sauce",
            imageUrl = "https://img.freepik.com/free-photo/double-bacon-cheeseburger-french-fries_140725-7508.jpg?t=st=1720371613~exp=1720375213~hmac=b5d7a7140fb7aae04da7e9c7dcc0d400df55b00bdaad426cbae30aa2db703c77&w=740",
            isGlutenFree = false,
            isVegan = true,
            isVegetarian = true,
            isLactoseFree = true,
            ingredients = """
            - Portobello mushroom cap
            - Salt and pepper
            - Sautéed vegetables (onions, peppers, etc.)
            - Vegan cheese
            - BBQ sauce
            - Lettuce
            - Sesame seed bun
        """.trimIndent(),
            recipeDetails = """
            1. Season Portobello mushroom cap with salt and pepper.
            2. Grill or pan-fry until tender.
            3. Sauté vegetables until soft and caramelized.
            4. Melt vegan cheese on top of the mushroom cap.
            5. Toast sesame seed bun.
            6. Assemble burger with sautéed vegetables, BBQ sauce, and lettuce.
            7. Serve hot with sweet potato fries or coleslaw.
        """.trimIndent()
        ),
        Food(
            categoryId = "Hamburger", // Hamburger
            name = "Avocado Veggie Burger",
            description = "Veggie burger patty with avocado, lettuce, tomato, and vegan mayo on a whole wheat bun",
            imageUrl = "https://img.freepik.com/free-photo/tasty-hamburger-avocado-wooden-board_23-2148575433.jpg?t=st=1720371653~exp=1720375253~hmac=e868d088cfad631a2169c92acda7899ef4713f2a0a8095d98929a940ae41fcd9&w=1060",
            isGlutenFree = false,
            isVegan = true,
            isVegetarian = true,
            isLactoseFree = true,
            ingredients = """
            - Veggie burger patty
            - Salt and pepper
            - Avocado slices
            - Tomato slices
            - Lettuce
            - Whole wheat bun
        """.trimIndent(),
            recipeDetails = """
            1. Season veggie burger patty with salt and pepper.
            2. Grill or pan-fry until heated through.
            3. Toast whole wheat bun.
            4. Assemble burger with avocado, lettuce, tomato, and vegan mayo.
            5. Serve hot with sweet potato fries or a side salad.
        """.trimIndent()
        ),
        Food(
            categoryId = "Hamburger", // Hamburger
            name = "Chickpea Burger",
            description = "Chickpea patty with hummus, cucumber, and lettuce on a whole grain bun",
            imageUrl = "https://img.freepik.com/free-photo/lassic-hamburger-with-sesame-bun_140725-4151.jpg?t=st=1720371692~exp=1720375292~hmac=c5b55ad253206241fb0a609012718d42c19c3b799bf0dfcc1d8f506524cba7dd&w=740",
            isGlutenFree = false,
            isVegan = true,
            isVegetarian = true,
            isLactoseFree = true,
            ingredients = """
            - Chickpea burger patty
            - Salt and pepper
            - Hummus
            - Sliced cucumber
            - Lettuce
            - Whole grain bun
        """.trimIndent(),
            recipeDetails = """
            1. Cook chickpea burger patty according to package instructions.
            2. Toast whole grain bun.
            3. Assemble burger with hummus, cucumber slices, and lettuce.
            4. Serve hot with a side of baked sweet potato wedges or coleslaw.
        """.trimIndent()
        ),
        Food(
            categoryId = "Hamburger", // Hamburger
            name = "Spinach and Feta Burger",
            description = "Spinach and feta cheese patty with tzatziki sauce on a ciabatta bun",
            imageUrl = "https://th.bing.com/th/id/R.a6904dce072a81035be90691fb040e4c?rik=UYLFaabG73H0sg&riu=http%3a%2f%2fimages.media-allrecipes.com%2fuserphotos%2f960x960%2f5322667.jpg&ehk=tXNYX8L1T6UGPZIp8W1%2bnRCodZson6zsFo079GG1e1k%3d&risl=&pid=ImgRaw&r=0",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - Spinach and feta burger patty
            - Salt and pepper
            - Tzatziki sauce
            - Lettuce
            - Tomato slices
            - Ciabatta bun
        """.trimIndent(),
            recipeDetails = """
            1. Cook spinach and feta burger patty according to package instructions.
            2. Toast ciabatta bun.
            3. Assemble burger with tzatziki sauce, lettuce, and tomato slices.
            4. Serve hot with a side of Greek salad or roasted vegetables.
        """.trimIndent()
        ),
        Food(
            categoryId = "Hamburger", // Hamburger
            name = "Quinoa Burger",
            description = "Quinoa and black bean patty with guacamole, lettuce, and salsa on a whole grain bun",
            imageUrl = "https://th.bing.com/th/id/OIP.QfLk4qYwmzreN8Jj5rXSogHaLH?rs=1&pid=ImgDetMain",
            isGlutenFree = true,
            isVegan = true,
            isVegetarian = true,
            isLactoseFree = true,
            ingredients = """
            - Quinoa and black bean burger patty
            - Salt and pepper
            - Guacamole
            - Lettuce
            - Salsa
            - Whole grain bun
        """.trimIndent(),
            recipeDetails = """
            1. Cook quinoa and black bean burger patty according to package instructions.
            2. Toast whole grain bun.
            3. Assemble burger with guacamole, lettuce, and salsa.
            4. Serve hot with a side of corn chips or a green salad.
        """.trimIndent()
        ),


        Food(
            categoryId = "Pizza", // Pizza
            name = "Margherita Pizza",
            description = "Classic pizza topped with tomato sauce, fresh mozzarella, and basil leaves",
            imageUrl = "https://cdn.loveandlemons.com/wp-content/uploads/2019/09/margherita-pizza-1080x1080.jpg",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - Pizza dough
            - Tomato sauce
            - Fresh mozzarella cheese
            - Fresh basil leaves
            - Olive oil
            - Salt and pepper
        """.trimIndent(),
            recipeDetails = """
            1. Preheat oven to 475°F (245°C).
            2. Roll out pizza dough into a round shape.
            3. Spread tomato sauce evenly over the dough.
            4. Tear fresh mozzarella into small pieces and distribute over the sauce.
            5. Bake pizza in preheated oven for 10-12 minutes, or until crust is golden and cheese is bubbly.
            6. Remove from oven, sprinkle with fresh basil leaves, drizzle with olive oil, and season with salt and pepper.
            7. Slice and serve hot.
        """.trimIndent()
        ),
        Food(
            categoryId = "Pizza", // Pizza
            name = "Vegetarian Pizza",
            description = "Pizza topped with assorted vegetables, marinara sauce, and melted cheese",
            imageUrl = "https://th.bing.com/th/id/OIP.Xx0j4C97GRtmrBzJHq8RFgAAAA?rs=1&pid=ImgDetMain",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - Pizza dough
            - Marinara sauce
            - Assorted vegetables (bell peppers, onions, mushrooms, olives, etc.)
            - Mozzarella cheese
            - Olive oil
            - Salt and pepper
        """.trimIndent(),
            recipeDetails = """
            1. Preheat oven to 475°F (245°C).
            2. Roll out pizza dough into a round shape.
            3. Spread marinara sauce evenly over the dough.
            4. Arrange assorted vegetables over the sauce.
            5. Sprinkle mozzarella cheese evenly over the vegetables.
            6. Bake pizza in preheated oven for 12-15 minutes, or until crust is golden and cheese is melted.
            7. Remove from oven, drizzle with olive oil, season with salt and pepper, and serve hot.
        """.trimIndent()
        ),
        Food(
            categoryId = "Pizza", // Pizza
            name = "BBQ Chicken Pizza",
            description = "Pizza topped with BBQ sauce, grilled chicken, red onions, and mozzarella cheese",
            imageUrl = "https://www.aberdeenskitchen.com/wp-content/uploads/2017/05/BBQ-Chicken-Pizza-9-680x1024.jpg",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = false,
            ingredients = """
            - Pizza dough
            - BBQ sauce
            - Grilled chicken breast, sliced
            - Red onion, thinly sliced
            - Mozzarella cheese
            - Olive oil
            - Salt and pepper
        """.trimIndent(),
            recipeDetails = """
            1. Preheat oven to 475°F (245°C).
            2. Roll out pizza dough into a round shape.
            3. Spread BBQ sauce evenly over the dough.
            4. Scatter grilled chicken slices and red onion slices over the sauce.
            5. Sprinkle mozzarella cheese evenly over the toppings.
            6. Bake pizza in preheated oven for 12-15 minutes, or until crust is golden and cheese is bubbly.
            7. Remove from oven, drizzle with olive oil, season with salt and pepper, and serve hot.
        """.trimIndent()
        ),
        Food(
            categoryId = "Pizza", // Pizza
            name = "Mushroom and Truffle Oil Pizza",
            description = "Pizza topped with sautéed mushrooms, truffle oil, fresh herbs, and Parmesan cheese",
            imageUrl = "https://th.bing.com/th/id/OIP.k037IQwptL4k2PCxoswNpwHaLH?rs=1&pid=ImgDetMain",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - Pizza dough
            - Olive oil
            - Sautéed mushrooms (shiitake, cremini, or wild mushrooms)
            - Truffle oil
            - Fresh herbs (thyme, rosemary)
            - Parmesan cheese, shaved
            - Salt and pepper
        """.trimIndent(),
            recipeDetails = """
            1. Preheat oven to 475°F (245°C).
            2. Roll out pizza dough into a round shape.
            3. Brush olive oil over the dough.
            4. Spread sautéed mushrooms evenly over the dough.
            5. Drizzle truffle oil over the mushrooms.
            6. Sprinkle fresh herbs and shaved Parmesan cheese over the pizza.
            7. Bake pizza in preheated oven for 10-12 minutes, or until crust is golden and toppings are aromatic.
            8. Remove from oven, season with salt and pepper, and serve hot.
        """.trimIndent()
        ),
        Food(
            categoryId = "Pizza", // Pizza
            name = "Spinach and Ricotta Pizza",
            description = "Pizza topped with sautéed spinach, ricotta cheese, garlic, and red pepper flakes",
            imageUrl = "https://food.fnr.sndimg.com/content/dam/images/food/fullset/2012/9/5/1/FNK_Healthy-Spinach-Ricotta-Pizza-Recipe_s4x3.jpg.rend.hgtvcom.826.620.suffix/1382543770718.jpeg",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - Pizza dough
            - Olive oil
            - Sautéed spinach
            - Ricotta cheese
            - Garlic, minced
            - Red pepper flakes
            - Mozzarella cheese
            - Salt and pepper
        """.trimIndent(),
            recipeDetails = """
            1. Preheat oven to 475°F (245°C).
            2. Roll out pizza dough into a round shape.
            3. Brush olive oil over the dough.
            4. Spread sautéed spinach evenly over the dough.
            5. Dollop ricotta cheese over the spinach.
            6. Sprinkle minced garlic and red pepper flakes over the pizza.
            7. Sprinkle mozzarella cheese evenly over the toppings.
            8. Bake pizza in preheated oven for 12-15 minutes, or until crust is golden and cheese is melted.
            9. Remove from oven, season with salt and pepper, and serve hot.
        """.trimIndent()
        ),
        Food(
            categoryId = "Pizza", // Pizza
            name = "Pesto and Artichoke Pizza",
            description = "Pizza topped with pesto sauce, marinated artichoke hearts, sun-dried tomatoes, and mozzarella cheese",
            imageUrl = "https://www.tasteofhome.com/wp-content/uploads/2019/02/Artichoke-Chicken-Pesto-Pizza_EXPS_SDAM19_23872_E12_07_5b-1.jpg?fit=700%2C1024",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = true,
            isLactoseFree = false,
            ingredients = """
            - Pizza dough
            - Pesto sauce
            - Marinated artichoke hearts, drained and sliced
            - Sun-dried tomatoes, sliced
            - Mozzarella cheese
            - Olive oil
            - Salt and pepper
        """.trimIndent(),
            recipeDetails = """
            1. Preheat oven to 475°F (245°C).
            2. Roll out pizza dough into a round shape.
            3. Spread pesto sauce evenly over the dough.
            4. Scatter marinated artichoke hearts and sun-dried tomatoes over the sauce.
            5. Sprinkle mozzarella cheese evenly over the toppings.
            6. Bake pizza in preheated oven for 12-15 minutes, or until crust is golden and cheese is melted.
            7. Remove from oven, drizzle with olive oil, season with salt and pepper, and serve hot.
        """.trimIndent()
        ),





   /*

        Food(
            categoryId = "Noodles", // Noodles
            name = "Pad Thai",
            description = "Traditional Thai stir-fried noodles with shrimp, tofu, bean sprouts, and peanuts",
            imageUrl = "https://img.freepik.com/free-photo/stir-noodles-fry-green-chinese_1203-5877.jpg?t=st=1720523953~exp=1720527553~hmac=f4ce2aafba5649ebdfbd61b97d88d39ec223344d12df7464c6fa80f28d2efe9a&w=1060",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = true,
            ingredients = """
            - Rice noodles
            - Shrimp
            - Tofu, cubed
            - Bean sprouts
            - Peanuts, crushed
            - Eggs
            - Garlic, minced
            - Green onions, chopped
            - Pad Thai sauce (tamarind paste, fish sauce, sugar)
            - Vegetable oil
            - Lime wedges
        """.trimIndent(),
            recipeDetails = """
            1. Cook rice noodles according to package instructions. Drain and set aside.
            2. Heat vegetable oil in a large pan or wok over medium heat. Add garlic and green onions, sauté until fragrant.
            3. Push garlic and onions to the side of the pan, crack eggs into the empty space. Scramble until cooked through, then mix with garlic and onions.
            4. Add shrimp and tofu, cook until shrimp turns pink and tofu is lightly browned.
            5. Add cooked noodles and pad Thai sauce to the pan. Toss everything together until well combined.
            6. Stir in bean sprouts and crushed peanuts.
            7. Serve hot with lime wedges on the side.
        """.trimIndent()
        ),
        Food(
            categoryId = "Noodles", // Noodles
            name = "Ramen",
            description = "Japanese noodle soup with broth, ramen noodles, pork belly, soft-boiled egg, and green onions",
            imageUrl = "https://img.freepik.com/free-photo/delicious-ramen-dark-surface_1150-41973.jpg?t=st=1720523990~exp=1720527590~hmac=d0c88582c782c701e86d8907a6e1148f605c6fe0ae6fdc552ffccde9ef1397e9&w=1060",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = true,
            ingredients = """
            - Ramen noodles
            - Soft-boiled eggs
            - Green onions, chopped
            - Nori (seaweed sheets)
            - Shiitake mushrooms
            - Soy sauce
            - Mirin
            - Dashi broth (kombu and bonito flakes)
            - Vegetable oil
            - Sesame seeds
        """.trimIndent(),
            recipeDetails = """
            1. Cook ramen noodles according to package instructions. Drain and set aside.
            2. Heat vegetable oil in a large pot over medium heat. Add shiitake mushrooms, green onions, and dashi broth to the pot. Simmer for 10 minutes.
            3. Stir in soy sauce and mirin to taste.
            4. Divide cooked noodles into serving bowls. Pour hot broth over the noodles.
            5. Garnish with soft-boiled eggs, nori strips, and sesame seeds.
            6. Serve hot.
        """.trimIndent()
        ),
        Food(
            categoryId = "Noodles", // Noodles
            name = "Chicken Chow Mein",
            description = "Chinese stir-fried noodles with chicken, vegetables, and savory sauce",
            imageUrl = "https://img.freepik.com/free-photo/flat-lay-noodles-with-vegetables-chicken_23-2148377422.jpg?t=st=1720524024~exp=1720527624~hmac=e467aa090a9a76a4f1b473d1df073cc74fc1b8e7275e845488dfce1524442dd4&w=1060",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = true,
            ingredients = """
            - Chow mein noodles
            - Chicken breast, thinly sliced
            - Bell peppers, sliced
            - Carrots, julienned
            - Bok choy, chopped
            - Soy sauce
            - Oyster sauce
            - Sesame oil
            - Garlic, minced
            - Ginger, grated
            - Vegetable oil
        """.trimIndent(),
            recipeDetails = """
            1. Cook chow mein noodles according to package instructions. Drain and set aside.
            2. Heat vegetable oil in a large pan or wok over medium heat. Add garlic and ginger, sauté until fragrant.
            3. Add chicken slices and cook until browned and cooked through.
            4. Stir in bell peppers, carrots, and bok choy. Cook until vegetables are tender-crisp.
            5. Add soy sauce, oyster sauce, and sesame oil to taste. Toss everything together.
            6. Add cooked noodles to the pan and toss until well combined.
            7. Serve hot.
        """.trimIndent()
        ),
        Food(
            categoryId = "Noodles", // Noodles
            name = "Pasta Carbonara",
            description = "Italian pasta dish with spaghetti, pancetta, eggs, and Parmesan cheese",
            imageUrl = "https://img.freepik.com/free-photo/spaghetti-carbonara_1203-8905.jpg?t=st=1720524057~exp=1720527657~hmac=9c91cfe03cecd90e457320da3a8b676451e21562d3a60b4ecd112febe48d54c9&w=1060",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = false,
            ingredients = """
            - Spaghetti
            - Pancetta or bacon, diced
            - Eggs
            - Parmesan cheese, grated
            - Garlic, minced
            - Black pepper
            - Olive oil
            - Salt
        """.trimIndent(),
            recipeDetails = """
            1. Cook spaghetti according to package instructions. Drain, reserving some pasta water, and set aside.
            2. Heat olive oil in a large pan over medium heat. Add pancetta or bacon and cook until crispy.
            3. Add minced garlic and cook until fragrant.
            4. In a bowl, whisk eggs, grated Parmesan cheese, and black pepper.
            5. Add cooked spaghetti to the pan with pancetta. Remove from heat.
            6. Quickly stir in egg mixture, tossing until creamy. If too dry, add reserved pasta water.
            7. Serve hot, garnished with additional Parmesan cheese and black pepper.
        """.trimIndent()
        ),
        Food(
            categoryId = "Noodles", // Noodles
            name = "Singapore Noodles",
            description = "Spicy stir-fried rice noodles with shrimp, vegetables, and curry powder",
            imageUrl = "https://www.seriouseats.com/thmb/Q3LbIBiUQXAhBSP-dvJXmzS5kMU=/1500x1125/filters:fill(auto,1)/__opt__aboutcom__coeus__resources__content_migration__serious_eats__seriouseats.com__recipes__images__2015__05__20150424-singapore-noodles-shao-zhong-20-130b0ed9d8ad45b3bd164cbe1328abef.jpg",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = true,
            ingredients = """
            - Rice vermicelli noodles
            - Shrimp
            - Eggs
            - Bean sprouts
            - Bell peppers, sliced
            - Carrots, julienned
            - Curry powder
            - Soy sauce
            - Garlic, minced
            - Ginger, grated
            - Vegetable oil
        """.trimIndent(),
            recipeDetails = """
            1. Cook rice vermicelli noodles according to package instructions. Drain and set aside.
            2. Heat vegetable oil in a large pan or wok over medium heat. Add garlic and ginger, sauté until fragrant.
            3. Push garlic and ginger to the side of the pan, crack eggs into the empty space. Scramble until cooked through, then mix with garlic and ginger.
            4. Add shrimp, bell peppers, and carrots. Cook until shrimp turns pink and vegetables are tender.
            5. Stir in curry powder and soy sauce.
            6. Add cooked noodles and bean sprouts to the pan. Toss everything together until well combined.
            7. Serve hot.
        """.trimIndent()
        ),
        Food(
            categoryId = "Noodles", // Noodles
            name = "Chicken Yakisoba",
            description = "Japanese stir-fried noodles with chicken, vegetables, and savory sauce",
            imageUrl = "https://th.bing.com/th/id/OIP.-6O58XuH1zi-VOheCMB85AHaLH?rs=1&pid=ImgDetMain",
            isGlutenFree = false,
            isVegan = false,
            isVegetarian = false,
            isLactoseFree = true,
            ingredients = """
            - Yakisoba noodles
            - Chicken breast, thinly sliced
            - Cabbage, shredded
            - Carrots, julienned
            - Bell peppers, sliced
            - Soy sauce
            - Worcestershire sauce
            - Oyster sauce
            - Garlic, minced
            - Ginger, grated
            - Vegetable oil
        """.trimIndent(),
            recipeDetails = """
            1. Cook yakisoba noodles according to package instructions. Drain and set aside.
            2. Heat vegetable oil in a large pan or wok over medium heat. Add garlic and ginger, sauté until fragrant.
            3. Add chicken slices and cook until browned and cooked through.
            4. Stir in cabbage, carrots, and bell peppers. Cook until vegetables are tender-crisp.
            5. Add soy sauce, Worcestershire sauce, and oyster sauce to taste. Toss everything together.
            6. Add cooked noodles to the pan and toss until well combined.
            7. Serve hot.
        """.trimIndent()
        )
   */



    )



/*kjhkjhhkjjhk*/



















    foodViewModel.insertAllFoods(foods)


}