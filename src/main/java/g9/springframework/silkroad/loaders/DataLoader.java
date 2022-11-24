package g9.springframework.silkroad.loaders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import g9.springframework.silkroad.models.Admin;
import g9.springframework.silkroad.models.CartItem;
import g9.springframework.silkroad.models.Category;
import g9.springframework.silkroad.models.Customer;
import g9.springframework.silkroad.models.Manager;
import g9.springframework.silkroad.models.Order;
import g9.springframework.silkroad.models.Product;
import g9.springframework.silkroad.repositories.AdminRepository;
import g9.springframework.silkroad.repositories.CategoryRepository;
import g9.springframework.silkroad.repositories.CustomerRepository;
import g9.springframework.silkroad.repositories.ManagerRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {
  private final AdminRepository adminRepository;
  private final ManagerRepository managerRepository;
  private final CustomerRepository customerRepository;
  private final CategoryRepository categoryRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {

    // Load admin data
    adminRepository.save(new Admin("Abdul", "abdul@email.com", new BCryptPasswordEncoder().encode("password"), "101"));

    // Load manager data
    managerRepository
        .save(new Manager("James", "man@email.com", new BCryptPasswordEncoder().encode("badApple"), "420"));

    // Load customer data
    var john = customerRepository
        .save(new Customer("John", "john@email.com", new BCryptPasswordEncoder().encode("secret"), "666"));

    var steve = customerRepository
        .save(new Customer("Steve", "steve@email.com", new BCryptPasswordEncoder().encode("pwdpwd"), "666"));

    // Categories and products
    Category Pantry = new Category("Pantry");
    Category MeatAndSeafood = new Category("Meat & Seafood");
    Category Deli = new Category("Deli");
    Category WineBeerAndLiquor = new Category("Wine, Beer & Liquor");
    Category Dairy = new Category("Dairy");
    Category Snacks = new Category("Snacks");
    Category Beverages = new Category("Beverages");
    Category BakeryAndBread = new Category("Bakery & Bread");
    Category BreakfastAndCereal = new Category("Breakfast & Cereal");
    Category Candy = new Category("Candy");
    Category FrozenFoods = new Category("Frozen Foods");

    Product[] PantryArray = new Product[11];
    Product[] MeatAndSeafoodArray = new Product[1];
    Product[] DeliArray = new Product[3];
    Product[] WineBeerAndLiquorArray = new Product[27];
    Product[] DairyArray = new Product[4];
    Product[] SnacksArray = new Product[6];
    Product[] BeveragesArray = new Product[12];
    Product[] BakeryAndBreadArray = new Product[3];
    Product[] BreakfastAndCerealArray = new Product[1];
    Product[] CandyArray = new Product[5];
    Product[] FrozenFoodsArray = new Product[4];

    PantryArray[0] = new Product("Goya Chorizos - 3.5oz",
        "Goya Chorizo, 3.5 Ounce | GOYA Chorizo is a delicious spanish dry hot sausage with a great texture and spiced with traditional seasonings. Perfect for everyday cooking in omlettes, as party snacks, or simply on it's own, Goya Chorizo is a delicious pantry staple that is sure to be a family favorite. Naturally smoked, and meaty and tasty on its own, Goya Chorizo also adds loads of flavor to rice dishes and stews—and of course, it makes fantastic tapas dishes! If it's Goya ... it has to be good!",
        3.29, "https://target.scene7.com/is/image/Target/GUEST_e5baf9e7-4476-402a-9c59-304dfa87c676", 5, Pantry);
    PantryArray[1] = new Product("Cholula Chili Garlic Hot Sauce - 5oz",
        "Calling all garlic fans, this Cholula Chili Garlic Hot Sauce is a must try. The robust goodness of garlic comes alive when paired with Cholula's arbol and piquin peppers and signature spices. It's a natural fit on pasta, soups and believe it or not - popcorn. Uncap Real Flavor with Cholula Chili Garlic. Imported from Mexico. Made in Mexico.",
        3.39, "https://target.scene7.com/is/image/Target/GUEST_5efa4c75-4e9d-4ad0-bbb5-d11bc6704130", 2, Pantry);
    PantryArray[2] = new Product("Shake 'N Bake Extra Crispy Seasoned Coating Mix - 5oz",
        "Kraft Shake 'N Bake Extra Crispy Seasoned Coating Mix adds a crispy crust to your chicken without the mess of frying for a quick home-style meal. This crispy coating is perfectly seasoned with savory flavors for a delicious, irresistible crunch. For simple prep, moisten the chicken, shake it in the coating and bake it until it's fully cooked. Use it with bone-in or boneless chicken to make crispy baked chicken, a crispy chicken sandwich or easy chicken nuggets. Each 5 ounce box contains two pouches of chicken coating, so you can enjoy more than one family dinner over oven baked crispy chicken. This extra-crispy chicken seasoning is all you need to take your home-style chicken from good to incredible.",
        3.59, "https://target.scene7.com/is/image/Target/GUEST_77d5ce57-e2ad-4b94-90a7-96cde23118a0", 4, Pantry);
    PantryArray[3] = new Product("Del Monte Fresh Cut Sliced Carrots 8.25oz",
        "The Del Monte Canned Sliced Carrot, with their flavor, complement All of your favorite recipes and different types of dishes, salads, drinks, and desserts. These delicious slices are a tasty topping for yogurt, cereal, salads, and your favorite flavored gelatin for a fun and tasty treat. The fruit, immersed in a Naturally refreshing fruit juice, will elevate any dish you make to another level. They contain much-needed nutrition apart from vitamins A and C. They also contain calcium and iron, which are beneficial for your body and health. The peach slices are the perfect snack to be eaten on-the-go and with whatever you desire. When you trust Del Monte, you can be sure what you're buying is the peak of quality and nutrition! The Del Monte name has been synonymous with premium foods since its debut in 1886. For generations, our company has proudly earned its reputation with a series of innovations and a singular dedication to quality. Today that commitment to quality is deeply embedded in our culture.",
        0.99, "https://target.scene7.com/is/image/Target/GUEST_379e1c4d-5594-4113-8086-1291c9080e3d", 1, Pantry);
    PantryArray[4] = new Product(
        "McCormick Gluten Free Pink Sea Salt, Black Pepper, Garlic All Purpose Seasoning - 6.5oz",
        "McCormick Himalayan Pink Salt with Black Pepper and Garlic All Purpose Seasoning is made for the meals you’re eating today. With its unique blend of garlicky meets citrusy and sweet, it’s got just the right flavors for beef, chicken, meatless dishes and more. A flavorful blend of Himalayan pink salt, black pepper, garlic and lemon peel, this convenient seasoning can be added to dishes without even measuring. Shake it on in the kitchen, at the table or on the grill! Use it in the morning on avocado toast or breakfast wraps straight through to dinner in stir-fries, grain bowls and meat(less) dishes to dial up flavor in a big modern way. This versatile seasoning is sure to be a favorite!",
        4.49, "https://target.scene7.com/is/image/Target/GUEST_9fea0459-511e-4f8a-9e04-c5a9119a944c", 3, Pantry);
    PantryArray[5] = new Product("Knorr Pasta Sides Fusili with Cheddar Broccoli - 4.3oz",
        "Treat your taste buds to Knorr Pasta Side's Cheddar Broccoli Fusilli Pasta. Our pasta side dish expertly combines broccoli florets and fusilli pasta with a creamy, cheddar cheese sauce; your family is sure to love the flavor of our easy pasta dishes. On top of tasting delicious, our Cheddar Broccoli pasta is quick and easy to prepare. Knorr pasta side dishes cook in just 10 minutes on the stovetop or in the microwave, and they’re perfect as the base for a delicious main dish or as a standalone rice side dish. Make Knorr Pasta Sides the foundation of a crowd-pleasing dinner or an easy meal.<br /><br />Knorr Pasta Sides have no artificial flavors or preservatives, and no added MSG, except those naturally occurring glutamates. Use these easy pasta side dishes to create a mouthwatering main dish. Simply prepare Knorr Pasta Sides and add your favorite meat and vegetables to make a dinner your family is sure to love. You can find great recipes from Knorr, like our chef-inspired Chicken & Garden Vegetables.<br /> <br />Discover more quick and delicious dinner ideas at Knorr.com. Hundreds of recipes are available to help you find dinner inspiration. We at Knorr believe that good food matters, and everyday meals can be just as magical as special occasions. Our products owe their taste and flavors to the culinary skills and passion of our chefs, and we source high-quality ingredients to create delicious side dishes, bouillons, sauces, gravies, soups, and seasonings enjoyed by families everywhere.",
        1.39, "https://target.scene7.com/is/image/Target/GUEST_06be3fc7-bfa2-49c1-9fc8-0643ce5ffa4b", 4, Pantry);
    PantryArray[6] = new Product("Idahoan Gluten Free Baby Reds Mashed Potatoes - 4oz",
        "Whip up delicious, rich mashed potatoes in minutes with Idahoan Baby Reds Mashed Potatoes! Our instant mashed potatoes are always made with 100-Percent Real Idaho potatoes. Perfect for a variety of wholesome recipes, Idahoan Baby Reds Mashed Potatoes are easy to prepare and ready in minutes. Simply heat water on stovetop or in a microwave, add the entire pouch of mashed potatoes, and voilà! Each order includes 1 (4.1oz) pouch with 4 (1/2 cup) servings. Our mission of innovation will continue to bring you quality 100-percent REAL Idaho potatoes in all the ways you love.  Whether it’s quality mashed potatoes, soups, casseroles or hash browns, in a pouch, bowl, cup or more, Idahoan Foods will continue to bring you Homemade Taste—Every Time",
        1.19, "https://target.scene7.com/is/image/Target/GUEST_251ab437-9c2b-4317-8dea-3378683477cd", 2, Pantry);
    PantryArray[7] = new Product("Tapatio Pollo Asado Marinade - 8oz",
        "Preparing authentic Mexican favorite Pollo Asado has never been easier.  TAPATIO's convenient ready-to-use 8oz pouch provides enough marinade for about 2 pounds of chicken.  Use citrus flavored Pollo Asado marinade, made with authentic TAPATIO salsa picante as the star ingredient, for the most flavorful, mouth watering  chicken.  Make every day a fiesta.",
        2.59, "https://target.scene7.com/is/image/Target/GUEST_65556dfc-1f36-42e1-b209-b2083e1ad79e", 3, Pantry);
    PantryArray[8] = new Product("Smucker's Simply Apricot Spread - 10oz",
        "This delicious spread captures the essence of the apricot: nectarous, with a touch of tartness. Our Simply Fruit Apricot Speadable Fruit pairs well with Swiss cheese and is perfect for sweetening rice and couscous dishes. Sweetened with ingredients made from real fruit. With a name like Smucker's, it has to be good!",
        3.49, "https://target.scene7.com/is/image/Target/GUEST_fc6cefaf-f9d3-4cf9-a81b-211a09110e02", 2, Pantry);
    PantryArray[9] = new Product("Annie's White Cheddar Macaroni & Cheese Microwavable Cupes - 16.08oz/8pk",
        "Your favorite comfort food comes perfectly packaged in an easy microwave meal with Annie's White Cheddar Macaroni and Cheese Cup. Simply add water, microwave and enjoy a cup of creamy mac and cheese without the extra time or dishes. Plus, this organic pasta and real cheese deliciousness is made with just the good stuff: no artificial flavors, synthetic colors or preservatives here. Pack this for an easy lunch or grab one for an afternoon snack.",
        11.49, "https://target.scene7.com/is/image/Target/GUEST_4ebd3938-a795-449d-a9b7-4c49ac2b5d64", 4, Pantry);
    PantryArray[10] = new Product("Gluten Free Chickpea Spaghetti - 8oz - Good & Gather™",
        "Going gluten-free doesn't mean you have to cut pasta out of your diet when you have Gluten-Free Chickpea Spaghetti from Good & Gather™ on hand. This gluten-free pasta has a classic spaghetti shape, but are made entirely from chickpeas, letting you enjoy your favorite pasta dishes while maintaining your gluten-free lifestyle. This chickpea pasta also makes a great alternative for those just looking to add some more protein into their diet, with each 3.5-ounce portion* dishing up 22 grams of protein. Use in place of traditional spaghetti or angel hair pasta in all your go-to pasta recipes. This pasta is made with no artificial flavors, preservatives or synthetic colors.<br /><br />Prep Directions:<br />1. Bring 4 quarts of water to a rolling boil; salt to taste, if desired.<br />2. Add pasta and return to a boil, stirring occasionally.**<br />3. Boil 8 to 10 minutes or until pasta is desired tenderness.<br />4. Remove from heat; rinse and drain.<br />**You may need to break spaghetti or stir as it softens to ensure it is fully covered with water.<br /><br />Every product that carries the Good & Gather™ name starts with quality ingredients that deliver great taste, making it easier for you and your family to eat well, every day. We promise you’ll love each bite, or your money back.",
        2.79, "https://target.scene7.com/is/image/Target/GUEST_1a308868-3f68-45c7-b3b1-255ac34eb60a", 4, Pantry);

    MeatAndSeafoodArray[0] = new Product("Tyson Grilled & Ready Oven Roasted Diced Chicken Breast - Frozen - 22oz",
        "Made with chicken raised with no antibiotics ever and no added hormones or steroids, Tyson Grilled and Ready Fully Cooked Diced Oven Roasted Chicken Breast is a delicious addition to any meal. These oven roasted frozen chicken breasts are seasoned, diced and oven roasted to perfection. Simply toss this seasoned chicken with fresh vegetables, pasta and a splash of olive oil for a delicious weeknight dinner. With high quality farm raised chicken with no antibiotics ever, we keep it real in everything we do. Keep it real. Keep it Tyson. *Minimally processed, no artificial ingredients.\n",
        10.39, "https://target.scene7.com/is/image/Target/GUEST_89fac4a8-d4c6-400a-9ba1-571bfbbfb9a1", 5,
        MeatAndSeafood);

    DeliArray[0] = new Product("The Drunken Goat Semi Soft Goat Cheese Bathed in Red Wine - 6oz",
        "Literally meaning ''goat with wine'' this semi-firm pasteurized goat from Spain's Mediterranean coast is cured for 48-72 hours in Doble Pasta red wine. The paste remains nearly pure white and the rind absorbs a lovely violet hue. The paste is sweet and smooth, delicately grapey, with a gentle, pliable texture and mild fruity flavor. ",
        9.39, "https://target.scene7.com/is/image/Target/GUEST_f2eb83be-c3f0-4fa0-92aa-14e2ce69bf7b", 1, Deli);
    DeliArray[1] = new Product("Ore-Ida Just Crack an Egg Omelet Rounds Three Meat Egg Bites - 4.6oz",
        "A protein-packed breakfast to add some spring to your step? Get outta here! Enjoy a hot, fluffy omelet in under two minutes with Just Crack an Egg Omelet Rounds. Made with cage free eggs*, our Just Crack an Egg Omelet Rounds Three Meat Egg Bites are filled with pork sausage, uncured bacon, uncured ham and cheddar cheese. Our Three Meat Omelet Rounds are packed with 18 grams of protein per serving. For a quick and easy breakfast at home or on the go, simply remove the film, microwave in the tray for 50 seconds and let cool before eating. Try eating our egg bites cold for a protein-packed breakfast or snack anytime. Each fluffy omelet bite has no artificial flavors, dyes or preservatives. Keep our egg bites refrigerated until you’re ready to eat. \n\n*Made with eggs from chickens never confined to cages",
        3.19, "https://target.scene7.com/is/image/Target/GUEST_49045abf-b654-46cc-b312-51cc3c476c38", 2, Deli);
    DeliArray[2] = new Product("Shaved Parmesan Cheese Cup - 5oz - Good & Gather™",
        "Put an elegant finishing touch on any dish while adding a hint of extra flavor with the Shaved Parmesan Cheese from Good & Gather™. Featuring the hard texture and subtle, nutty flavor you expect from high-quality Parmesan, this shaved cheese is aged for 10 months to achieve its distinctive flavor, and the five-ounce package is the ideal size for keeping on hand. Use it to add a perky finishing touch to your lasagna or to add a little extra flavor and flourish to dinner salads, or simply add it to a cheese board and serve with fruit, preserves and water crackers for a mouthwatering appetizer choice that's sure to please. <br /><br />Every product that carries the Good & Gather name starts with quality ingredients that deliver great taste, making it easier for you and your family to eat well, every day. We promise you'll love each bite, or your money back.",
        3.99, "https://target.scene7.com/is/image/Target/GUEST_abdc1f0b-b640-4f8f-a0aa-fa7f015997bb", 4, Deli);

    WineBeerAndLiquorArray[0] = new Product("Bud Light Beer - 18pk/12 fl oz Bottles",
        "Bud Light is brewed using barley malts, rice and a blend of premium aroma hop varieties and has a fresh, clean taste. This lager delivers a crisp finish. Bud Light is made with no preservatives or artificial flavors and has a 4.2% ABV. 18 pack of bottles.",
        17.99, "https://target.scene7.com/is/image/Target/GUEST_03c3d05f-413a-4e8d-bf1f-d08dd034dd31", 1,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[1] = new Product("J. Lohr Estates Flume Crossing Sauvignon Blanc - 750ml Bottle",
        "The grapes for the Flume Crossing Sauvignon Blanc are grown in the well-drained, sandy, cobblestone soils deposited by the Arroyo Seco River. These rugged soils keep yields in check and produce fruit with varietal intensity, minerality and exceptional weight. The long cool growing season of the Arroyo Seco appellation ensures that the fleeting, exotic fruit flavors of Sauvignon Blanc are retained along with a vibrant natural acidity. The Flume Crossing Sauvignon Blanc is created to be an expression of pure varietal character, influenced only by its terroir, gently guided by minimal farming and winemaking practices. Pale yellow in color and displays aromas of honeysuckle, sweet herbs, lime, and fig. These aromas are complemented on the palate by the bright flavors of grapefruit, kiwi, passionfruit, and lemongrass, with the rich texture and long finish provided by the acacia barrels. This wine has earned the Certified California Sustainable seal.",
        12.99, "https://target.scene7.com/is/image/Target/GUEST_7297f261-dae3-43f6-9cb2-39018f7ae4c8", 5,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[2] = new Product("Busch Non-Alcoholic Beer - 12pk/12 fl oz Cans",
        "Busch Non Alcoholic Beer lets you enjoy traditional rich Busch flavor without the alcohol. This beer features a smooth, full bodied, malty flavor. It is fully brewed with a blend of American hops, fine barley malt, cereal grains, and pure water. 12 pack.",
        9.99, "https://target.scene7.com/is/image/Target/GUEST_2f13521b-4525-4ec8-aefe-33907df0f75e", 3,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[3] = new Product("Natural Light Beer - 12pk/12 fl oz Cans",
        "Natural Light delivers a satisfyingly refreshing beer for a satisfying value. It is a well blended and balanced American-style light lager. A longer brewing process produces a lighter body, fewer calories, and an easy-drinking character. 15 pack.",
        9.99, "https://target.scene7.com/is/image/Target/GUEST_b66f1c18-9b1e-477b-9436-4b2233e4b410", 4,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[4] = new Product("Our Daily Red Wine - 750ml Bottle",
        "Ripe notes of fresh raspberry and juicy cherry are accented by a subtle aroma of violets. Light-bodied and vibrant with an elegant finish.",
        8.99, "https://target.scene7.com/is/image/Target/GUEST_58c5798b-2e2a-4af7-b088-e2be2aafea97", 4,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[5] = new Product("Luna Bay Booch Hibiscus Lavender Hard Kombucha - 4pk/12 fl oz Cans", "",
        13.99, "https://target.scene7.com/is/image/Target/GUEST_4aaf8d20-aa44-404d-9b59-8d37906bb00e", 1,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[6] = new Product("Kendall-Jackson Avant Unoaked Chardonnay White Wine - 750ml Bottle",
        "Kendall-Jackson Avant Unoaked Chardonnay White Wine is primarily sourced from California's Monterey County, Santa Barbara County and Mendocino County. This Kendall-Jackson Chardonnay wine combines crisp green apple, citrus and tropical fruit notes for the perfect dry white wine that is a superb accompaniment for food. It also has flavors and aromas of pineapple, juicy pear and wildflowers.\n\nThis youthful and lively white wine Chardonnay is handcrafted to be expressive, fruit forward and vibrant. It is 100% stainless steel fermented with a Stelvin screw cap closure helps to preserve the aromatic freshness and youthfulness of the wine. Pair this white wine Chardonnay with sushi, halibut, fried calamari and fish tacos for an excellent meal.\n\nKendall-Jackson is committed to producing only the finest quality wines from Chardonnay grape varietals grown in California. One aspect that distinguishes a Kendall-Jackson wine is vineyard sourcing. The majority of fruit sourced for Kendall-Jackson wines is grown on the 12,000 acres of estate vineyards owned by the Jackson family. All of the estate vineyards are certified sustainable by the CCSW (Certified California Sustainable Winegrowing) and SIP (Sustainability in Practice) programs. The proprietary approach to winemaking has earned Kendall-Jackson a world-renowned reputation for white wines that consistently exhibit signature rich layers of flavor, combined with a delicate balance.\n\nThis bottled wine has a 13.5% ABV.",
        13.99, "https://target.scene7.com/is/image/Target/GUEST_22ed0cf9-d3f5-43da-84cb-ba13775255dd", 2,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[7] = new Product("Yellow Tail Chardonnay White Wine - 1.5L Bottle",
        "Made in South Eastern Australia, [ yellow tail ] Chardonnay is a white wine that brings the flavors and essence of the region to your glass, ensuring a smile with each sip. This chardonnay is everything a great wine should be with its easy to drink, rich taste and vibrant flavor profile. Featuring fresh flavors of peach and melon with a hint of vanilla, this white wine is full bodied and silky smooth. Enjoy this white wine with roast chicken or salad greens. Take an adventurous approach to this bottle of wine by adding chardonnay wine to a cinnamon pear cocktail, perfect for sharing with friends. [ yellow tail ] wine is wonderful for livening up casual dinners with loved ones and bringing a lighthearted spirit to any and every event and celebration. This [ yellow tail ] wine bottle is 1.5 L and has a 13% ABV. Great quality wine can be affordable and good fun too. We like our wines to be vibrant, flavorsome and approachable, making everyday moments even more enjoyable. A wine for any occasion, [ yellow tail ] is easy to choose, drink and enjoy.",
        11.99, "https://target.scene7.com/is/image/Target/GUEST_025e12b8-711c-44bc-828a-1d8e6463ae75", 2,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[8] = new Product("Bogle Vineyards Phantom Red Blend Wine - 750ml Bottle",
        "Intriguing, beguiling... This mysterious apparition of ripe berry and relentless spice returns to haunt wine lovers. Enveloped in shadow, this wine's intensity and concentration will entice you with every sip. Full-bodied and jammy, Phantom's origins of Petite Sirah and Zinfandel emerge from the glass. Spicy pepper and juniper tantalize your senses, while black plums and blueberries emerge on the palate. Notes of pipe tobacco and clove settle around the finish, long and lingering, like Delta fog.",
        15.99, "https://target.scene7.com/is/image/Target/GUEST_0f5e7f06-c862-4680-b133-596f2509d33d", 1,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[9] = new Product("Bud Light & Clamato Beer - 4pk/16 fl oz Cans",
        "Bud Light Chelada Light Beer combines the refreshing taste of Bud Light with the richness of a Clamato tomato cocktail. It follows the traditional brewing process for Bud Light, then Clamato is carefully blended with the beer to create the proper balance of the crisp finish of Bud Light and the signature taste of Clamato. Bud Light Chelada has a 4.2% ABV. Enjoy Bud Light Chelada beer anytime the occasion calls for refreshing drinks. To best enjoy, gently rotate the chilled can once before pouring. Then pour over ice into a traditional goblet-style glass and garnish with a slice of lime. The spicy beer pairs perfectly with many dishes, and is great for backyard gatherings with friends, family and food. Grab a pack of the convenient beer cans anytime you're looking for alcohol drinks.",
        6.99, "https://target.scene7.com/is/image/Target/GUEST_89c28d6f-c432-472d-a243-5b495396a83a", 5,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[10] = new Product("Budweiser Lager Beer - 6pk/16 fl oz Cans",
        "Budweiser beer is a medium-bodied, American-style lager beer. Brewed with high quality barley malt, a blend of premium hop varieties, fresh rice and filtered water, this American beer is crisp and full of flavor. Budweiser beer has a 5% ABV. 6 pack.",
        6.99, "https://target.scene7.com/is/image/Target/GUEST_3fa718ca-ae8c-4a92-a29c-b78da7c41516", 2,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[11] = new Product("Devils Backbone Vienna Lager Beer - 15pk/12 fl oz Cans",
        "Devils Backbone Brewing Company Vienna Lager is a beer with mild, toasted and caramel notes. This smooth, medium bodied and semi sweet craft beer is not too heavy or bitter. It has an amber chestnut color, a smooth, malty finish and a 5.2% ABV. 15 pack.",
        17.99, "https://target.scene7.com/is/image/Target/GUEST_3c91dd5b-194b-4199-9052-16b0a42937ec", 5,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[12] = new Product("Moab Johnny's American IPA Beer - 4pk/16 fl oz Cans", "", 6.99,
        "https://target.scene7.com/is/image/Target/GUEST_f02be08e-8818-44e6-bf9b-ac87927187d7", 2, WineBeerAndLiquor);
    WineBeerAndLiquorArray[13] = new Product("Summit Extra Pale Ale Beer - 12pk/12 fl oz Bottles",
        "Summit Extra Pale Ale is not a beer brewed only for beer snobs. Just the opposite. It’s a beer for everyone to enjoy: construction workers, stock brokers, farmers, sales people, clerks, teachers, lawyers, doctors, even other brewers. Its light bronze color and distinctly hoppy flavor have made it a favorite in St. Paul, Minneapolis and the rest of the Upper Midwest ever since we first brewed it back in 1986.12oz 12Pk",
        15.99, "https://target.scene7.com/is/image/Target/GUEST_ddd24e65-b712-4fa4-a98f-5341ff2de8fd", 3,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[14] = new Product("Sixpoint The Crisp Pilsner Beer - 6pk/12 fl oz Cans",
        "Tettnang and Hallertau Hops, 100% sourced directly from Germany, give THE CRISP that signature floral aroma. Cargill Pilsner Malt is the backbone, and helps make the finish snappy and clean.<br />Legit pilz has a hop aroma that leaps from the glass   THE CRISP blasts you with a huge floral aroma, but finishes crisp, clean, and refreshing.",
        9.99, "https://target.scene7.com/is/image/Target/GUEST_a9ea9eef-f2c0-4531-8aec-eda1dc1c367d", 3,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[15] = new Product("Josh Pinot Grigio White Wine - 750ml Bottle",
        "Our Pinot Gris, from the cool climate of Washington, is expressive and crisp with flavors of citrus and mango.   Pairs well with sauteed scallops, fettucine alfredo or roasted butternut squash.",
        12.99, "https://target.scene7.com/is/image/Target/GUEST_b8a83d1b-e4fc-4633-93e9-4828c3975c14", 5,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[16] = new Product("Absolut Lime & Cucumber Sparkling Vodka Soda - 4pk/355ml Cans",
        "A high quality – low calorie drink, ready to be enjoyed with just the flick of the wrist. Inspired by the iconic, go-to drink but with an added twist, our Absolut Vodka Sodas are your perfectly balanced premix made perfect for any occasion, free from any artificial ingredients and full of natural flavors. With Absolut Vodka and the taste of either Raspberry & Lemongrass, Lime & Cucumber or Grapefruit & Rosemary, the question is not whether you have found your favorite drink for the summer, but which one is your pick.",
        12.99, "https://target.scene7.com/is/image/Target/GUEST_eace27cd-9e10-468d-823c-5692c27f2d11", 1,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[17] = new Product("Bota Box Sauvignon Blanc White Wine - 3L Box",
        "Bota Box wines are always ready for an adventure. Packaged using sustainable materials and a resealable spout that keeps light and air out, you can enjoy quality wines anywhere, anytime for up to 30 days after opening. So whether your plans include a weekend camping trip or a movie night in with your dog, the full-bodied flavor of Bota Box white wine pairs perfectly with all of life’s adventures.",
        18.99, "https://target.scene7.com/is/image/Target/GUEST_feb81859-7663-4f76-8d60-375162cb2d49", 3,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[18] = new Product("Wild Turkey 101P Bourbon Whiskey - 1.75L Bottle",
        "Wild Turkey 101 offers a lesson in traditional American values, most notably the refusal to compromise on standards of excellence. This iconic bourbon is perfectly aged a minimum of ﬁve years in American White Oak barrels with the deepest #4 alligator char for more character.",
        48.99, "https://target.scene7.com/is/image/Target/GUEST_63efaf0b-b4f9-479a-bbfc-4609eefe1a05", 2,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[19] = new Product("Wild Turkey 101 Proof Bourbon Whiskey - 750ml Bottle",
        "Wild Turkey 101 offers a lesson in traditional American values, most notably the refusal to compromise on standards of excellence. This iconic bourbon is perfectly aged a minimum of ﬁve years in American White Oak barrels with the deepest #4 alligator char for more character.",
        21.99, "https://target.scene7.com/is/image/Target/GUEST_877b1278-45c4-4413-bfde-8abf837c1c72", 4,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[20] = new Product("Espolòn Tequila Blanco - 750ml Bottle",
        "Inspired by and a tribute to Mexican culture, Espolòn tequila is named for the spur of the iconic rooster, a historic symbol of strength nobility and national pride. Espolon was established in 1998 as a tequila for the people.  Unaged, Espolon Blanco is the purest expression of Espolòn tequila.",
        24.99, "https://target.scene7.com/is/image/Target/GUEST_8b32cb3b-8b14-4f39-8715-72231c9b8e7f", 5,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[21] = new Product("Grand Marnier Orange Liqueur - 750ml Bottle",
        "Mix up a classic cocktail with Grand Marnier Cordon Rouge, Grand Marnier's signature expression. Created in 1880 by Louis-Alexandre Marnier Lapostolle, Grand Marnier offers a premium blend of cognacs with wild tropical oranges from the Caribbean. Grand Marnier Cordon Rouge balances the flavors of bitter orange with cognac notes of hazelnuts and toffee before reaching a long, harmonious finish. Enjoy this cognac and orange liqueur on the rocks, or mix into your favorite cocktails to elevate them from good to Grand. Use the cognac for a sophisticated twist on a Margarita, Old Fashioned or a Sidecar.  This award-winning orange liqueur is closed in the iconic, highly recognizable bottle with the wax seal. It is distinguished by the red ribbon, a symbol of its quality. The 750ml ml bottle of Grand Marnier Cordon Rouge liquor has a 40% alcohol by volume and should be enjoyed responsibly. Grand Marnier is the result of a time-honored tradition of master blenders that skillfully and carefully have passed their savoir faire onto one another since 1880. The result is an extraordinary alchemy of passion, audacity and tradition. Live Grand.",
        39.99, "https://target.scene7.com/is/image/Target/GUEST_5d5c14cd-d8db-4838-a7d6-6563461a40da", 4,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[22] = new Product("Codigo 1530 Rosa Blanco Tequila - 750ml Bottle",
        "Rosa begins with the purity of Blanco, then is rested for one month in a Napa Valley Cabernet French Oak barrel. It is rested just long enough for the wine barrels to enrich the natural agave flavor but maintain the elegant floral notes.",
        64.99, "https://target.scene7.com/is/image/Target/GUEST_a9c57566-9e00-47a6-a9c1-23649b5d4048", 4,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[23] = new Product("Margaritaville Gold Tequila - 750ml Bottle", "", 11.99,
        "https://target.scene7.com/is/image/Target/GUEST_11b3999d-3d0f-4e6b-a3e0-3c5517fc69e5", 3, WineBeerAndLiquor);
    WineBeerAndLiquorArray[24] = new Product("New Amsterdam Vodka - 750ml Plastic Bottle", "", 14.99,
        "https://target.scene7.com/is/image/Target/GUEST_6e790b29-f2a5-4f73-85b2-35bf8fa1eb60", 2, WineBeerAndLiquor);
    WineBeerAndLiquorArray[25] = new Product("Notorious Pink Grenache Rosé Wine - 750ml Bottle",
        "Notorious Pink is a special blush cuvée made from 100% Grenache, the leading grape varietal at Domaine la Colombette in the south of France. At this estate, the techniques used have been tried and tested. The grapes from the oldest vines are bled using the saignée method, while those from younger vines are pressed. After settling, the musts are fermented at low temperatures (14-18°). Blush pink in color, Notorious Pink is inviting with a pleasant under-ripe strawberry, mango, and citrus zest scent with a crisp and refreshing mineral character. Ours is not as dry as most French rosé wines and can be enjoyed with seafood, vegetables, pastas, and poultry dishes, but easily stands on it’s own. Perfect for every day in every season.",
        15.99, "https://target.scene7.com/is/image/Target/GUEST_2c343843-a855-4908-b492-64b177219ae5", 2,
        WineBeerAndLiquor);
    WineBeerAndLiquorArray[26] = new Product("Roséhaven Rosé Wine - 750ml Bottle", "", 9.99,
        "https://target.scene7.com/is/image/Target/GUEST_2889a428-839f-4707-ae1b-d0af001b7043", 4, WineBeerAndLiquor);

    DairyArray[0] = new Product("Country Crock Calcium Vegetable Oil Spread Tub - 15oz",
        "Bring authentic, country-fresh flavor to the table with Country Crock® Calcium Buttery Spread Tub - 15 oz. This buttery spread gives you the rich, creamy, and delicious flavor you love, along with 8% daily value of calcium per 1 tbsp serving. Slow-churned in Kansas and carefully crafted with farm-grown ingredients, you can always count on Country Crock to be free of any artificial flavors and preservatives. There's a reason Country Crock has been a trusted favorite at the center of family tables for generations! \n\nReady to use right out of the fridge, Country Crock Calcium Buttery Spread can be spread on top of your favorite breads and pastries for a deliciously decadent buttery treat. Use it as a secret ingredient to add depth of flavor and richness to your cooking and baking favorites from appetizers to main dishes, desserts, and more. Country Crock Calcium is free of gluten, hydrogenated oils, dairy, and lactose, has 0g cholesterol and trans fat per 1 tbsp serving, and has 75% less saturated fat than a 1 tbsp serving of traditional dairy butter. \n\nBrought to you by Country Crock, a brand committed to welcoming everyone to the table. We treat everyone like family and every place like home. Our products are sustainably farmed and responsibly sourced. When you can spread, top, cook and bake just about anything with this buttery spread, the options are endless with Country Crock!",
        3.19, "https://target.scene7.com/is/image/Target/GUEST_200ad2d7-68e1-4562-bece-bc219e359e89", 2, Dairy);
    DairyArray[1] = new Product("Good Culture Organic Whole Milk Classic Cottage Cheese - 16oz",
        "At Good Culture, our mission is to make real healing foods available to all, without hurting animals or our planet.  Made from stuff you can pronounce, produced by people who love the planet and really, really like cottage cheese.  The little black dress of the dairy world. You can never go wrong with a classic! Creamy Organic Cottage Cheese from pasture-raised cows. Our recipe for delicious is simple; we use organic milk, organic cream, celtic sea salt, and live & active cultures. Nothing else. Got it? Good.",
        4.99, "https://target.scene7.com/is/image/Target/GUEST_32bc7b04-72e3-4dcf-865f-026e48806abe", 4, Dairy);
    DairyArray[2] = new Product("Oikos Triple Zero Variety Pack Greek Yogurt - 6ct/5.3oz Cups",
        "Oikos Triple Zero Greek Nonfat Yogurt gives you all the flavor you seek in a Greek yogurt--but with 0 added sugar*, 0 artificial sweeteners, and 0 fat, with 15 grams of protein per 5.3 oz cup. Full of delicious strawberry (or mixed berry) flavor, this Greek nonfat yogurt makes a delicious snack any time of day. It also fits into a healthy lifestyle, providing important nutrients such as calcium, protein, and vitamin D. And for your convenience, Oikos Triple Zero Greek Nonfat Yogurt comes packaged in single-serve cups, perfect for snacking on the go. <br /><br /> <br />*Not a low-calorie food.<br />Discover yogurt and dairy products that are made for you with Oikos. Want the creamy one with the fruit chunks? We got you. Need 0 sugar, 0 artificial sweeteners, and 0 fat? Try Oikos Triple Zero. Looking for extra protein? Oikos Pro has 20g per serving. With our wide selection of creamy yogurts, you’re bound to find an epic food experience that sparks pure joy. Dig into deliciousness with Oikos.",
        5.29, "https://target.scene7.com/is/image/Target/GUEST_cfd38a75-37e9-4cb2-9a4d-a2ce63b08e89", 4, Dairy);
    DairyArray[3] = new Product("Annie's Organic Cinnamon Rolls with Icing - 17.5oz/5ct",
        "Sweeten up your morning with Annie’s Organic Cinnamon Rolls! Made with the goodness of Annie’s, our yummy cinnamon rolls are made with high-quality ingredients and no artificial flavors, hydrogenated oils or high-fructose corn syrup. Even sweeter, our ready-to-bake cinnamon rolls come with a side of old-fashioned icing for swirled-on deliciousness. Simply place flat on a cookie sheet and bake at 350 degrees for 18-20 minutes. Then, slather your cinnamon rolls in creamy icing and prepare to devour. Head over to the refrigerated dough aisle and grab a can of five organic cinnamon rolls!\n\nAnnie's makes products in over 20 family-friendly categories — from fruit-flavored snacks and cereal to mac & cheese. For busy bunnies and families on the go, we help make life a little easier and more delicious by sweetening-up packed lunches or by adding to a savory, yummy dinner. Annie’s is devoted to spreading goodness through nourishing, tasty foods and kindness to the planet.",
        5.59, "https://target.scene7.com/is/image/Target/GUEST_100b7f65-20e8-4334-b1ba-f3ab2a5c9137", 4, Dairy);

    SnacksArray[0] = new Product("MadeGood Organic Gluten Free Chocolate Chip Cookies Soft Baked - 12ct Traypack",
        "When we set out to bake cookies we wanted them to be like homemade: soft, moist and tender. MadeGood® Soft Baked Cookies are everything you crave. They are just the right size, low in sugar, gluten-free, packed with a serving of vegetables, high in vitamin A, C, D, E and B6 so you can always treat yourself! With flavors that wow, these are cookies made with love!",
        7.99, "https://target.scene7.com/is/image/Target/GUEST_b55f5cd7-df55-426e-89c3-00b869a1880c", 2, Snacks);
    SnacksArray[1] = new Product("Bob's Red Mill Hemp Seed - 8oz",
        "Bob's Red Mill Hulled Hemp Seed Hearts are beautiful little seeds with a serious nutritional bang. These raw seeds hold 10g of plant-based, vegetarian protein in each serving, plus omega-3 and omega-6 fatty acids, and a wealth of other minerals. These seeds are mild in flavor and can be almost inconspicuously added to just about any dish - salads, smoothies, pastas, yogurts, cereals, and even ice cream! They are also a great addition to baked goods such as breads and cookies or in dips, dressings, and sauces.",
        12.19, "https://target.scene7.com/is/image/Target/GUEST_2ef84f39-77ec-410a-ad69-2477ab149f9a", 2, Snacks);
    SnacksArray[2] = new Product("Goldfish Special Edition Mickey Mouse Cheddar Crackers - 30oz",
        "A special edition twist on the irresistible little snack that always delights! Just imagine munching on Goldfish snack crackers featuring Disney’s Mickey Mouse. Shaped like your favorite cartoon friend, they’re baked with 100% real Cheddar cheese and made with colors sourced from plants. Talk about a feel-good snack! These Mickey Mouse-inspired munchables are as fun as it gets. And they make the perfect anytime snack – after school, on the weekends or whenever you just spend time together. Snack time with friends is always sure to end up in smiles all around. Plus, they’re every bit as good at lunch as they are for a crunchable, munchable snack. Add them to soups, sprinkle them on salads or just simply munch on them as a fun side with your sandwich. Expect everyone to come back for more. Go for the handful!",
        7.99, "https://target.scene7.com/is/image/Target/GUEST_45a160d9-7623-4c06-a716-d8bcd3bc6b57", 5, Snacks);
    SnacksArray[3] = new Product("Blue Diamond Almonds Whole Natural - 12oz",
        "Whole Natural Blue Diamond almonds are the best way to appreciate the flavor of the almond. It's also a good way to get a handful of almonds' benefits every day.",
        6.99, "https://target.scene7.com/is/image/Target/GUEST_ac72143a-4d63-4e9a-a9d3-1f498d25f914", 4, Snacks);
    SnacksArray[4] = new Product("Ritz Toasted Chips, Cheddar - 8.1oz",
        "RITZ Cheddar Toasted Chips are a crispy, crunchy twist on the classic cracker you know and love. These oven baked chips are toasted, not fried, so they contain 40 percent less fat than the leading regular fried potato chips. Pack these snack chips in lunchboxes for a crunchy companion to sandwiches, or add them to your snack food shelf as a tasty after school treat. Serve these reduced fat chips alongside other salted chips, by themselves or with your favorite dips. Each 8.1 ounce bag of RITZ Cheddar Toasted Chips is sealed to lock in freshness and great taste.",
        3.59, "https://target.scene7.com/is/image/Target/GUEST_745c2e06-3709-4f46-8cf8-59a987f90de2", 2, Snacks);
    SnacksArray[5] = new Product("Annie's Organic Cheddar Snack Mix - 9oz",
        "Annie's Organic Cheddar Snack Mix is hopping with flavor! This kid snack has a crunchy, cheesy combination of pretzels and crackers, all lightly coated in a yummy savory seasoning. Besides being totally delicious, the adorable bunny-shaped crackers pack even more fun into the mix. Kiddos will enjoy the taste of this snack mix, and parents will love that it's made with real cheese and without artificial flavors or synthetic colors. It's excellent for snack packs, party mixes or anytime you and your family are craving something downright delicious. \n\nAnnie's makes products in over 20 family-friendly categories —from fruit-flavored snacks and cereal to mac & cheese. For busy bunnies and families on the go, we help make life a little easier and more delicious by sweetening-up packed lunches or by adding to a savory, yummy dinner. Annie’s is devoted to spreading goodness through nourishing, tasty foods and kindness to the planet.",
        4.19, "https://target.scene7.com/is/image/Target/GUEST_fd19fabc-a56f-4ffc-884f-78adb2bd7f45", 4, Snacks);

    BeveragesArray[0] = new Product("Lion Coffee Lion Gold Medium Roast Ground Coffee - 10oz",
        "LION Gold Coffee is a classic medium-light roast coffee that makes a great breakfast coffee. This means that there is some real caffeine kick in this bag to get your day started! This LION Coffee brew is bright in the cup with a mellow taste and sweet, delicate, and slightly citrus finish.",
        7.39, "https://target.scene7.com/is/image/Target/GUEST_41282053-add3-4bc7-a40c-46670c171932", 5, Beverages);
    BeveragesArray[1] = new Product("Royal Kona 100% Kona Medium Roast Whole Bean Coffee - 7oz",
        "Natural Kona coffee is extremely rare and makes our 100% Kona coffee exceptionally special. The intricate process to harvest and mill the coffee beans gives our premium Kona coffee the delicious taste and silky mouthfeel you know and love. As with all Royal Kona Coffees, this blend is gluten-free and does not contain nut allergens. Supply of natural Kona coffee is extremely limited, so try this while you can!",
        19.69, "https://target.scene7.com/is/image/Target/GUEST_14d5715e-3216-41d5-84f7-648dde78077a", 4, Beverages);
    BeveragesArray[2] = new Product("Alkaline Water - 1.5L Bottle - Good & Gather™",
        "Alkaline Water from Good & Gather™ is a great way to stay hydrated and refreshed no matter what your day has in store. This bottle of  purified water with electrolytes for taste will keep you feeling refreshed and hydrated, and it has a pH 9.5+ balance, making it the perfect choice for rehydrating after a demanding workout, a vigorous game of flag football or just a day spent out in the sun. Throw a bottle in your backpack or keep one in your gym bag to stay refreshed and hydrated before, during and after your workout, or keep a couple bottles on hand for thirst-quenching goodness no matter what's on your schedule. <br /><br />Every product that carries the Good & Gather™ name starts with quality ingredients that deliver great taste, making it easier for you and your family to eat well, every day. We promise you'll love each bite, or your money back.",
        1.69, "https://target.scene7.com/is/image/Target/GUEST_310d542b-f9ad-4d35-8940-6845c5ea13f8", 2, Beverages);
    BeveragesArray[3] = new Product("The Original Donut Shop Regular Keurig K-Cup Coffee Pods - Medium Roast - 24ct",
        "Before coffee was complicated, great coffee was simply fresh, bold, and flavorful. The Original Donut Shop Regular single serve K-Cup pods bring back the classic donut companion, with this ideally balanced brew of the highest quality beans...dunking is encouraged. Full-flavored and easy going, this medium roast blend embodies one of the best things in life - simply great coffee. These single-serve K-Cup pods are compatible with all Keurig K-Cup Pod Single-Serve Coffee Makers and brew up to 12 oz. of The Original Donut Shop Regular coffee each. Each K-Cup pod is filled with the freshest ground coffee and brews a perfect, great tasting cup of coffee, every time. Certified Orthodox Union Kosher and contains no artificial ingredients. Introducing Recyclable* K-Cup Pods: Simple. Delicious. And now Recyclable. Enjoy the same great-tasting coffee you know and love, and when you’re done just peel, empty and recycle. *Check locally, not recycled in all communities. Packaging may vary.",
        14.99, "https://target.scene7.com/is/image/Target/GUEST_e575561f-cbf9-4453-836e-5dff7a955ef5", 1, Beverages);
    BeveragesArray[4] = new Product("Yogi Tea - Honey Chai Turmeric Vitality Tea - 16ct",
        "Yogi Honey Chai Turmeric Vitality tea is an intriguing Chai tea blend that combines Turmeric, traditionally used in Ayurveda for its abundant health-promoting qualities, with naturally sweet Organic Honey Flavor and rich, warming spices including Cinnamon, Cardamom, Ginger, and Clove. Enjoy deliciously spicy-sweet Yogi Honey Chai Turmeric Vitality tea throughout the day to support your overall health and well-being.*<br /><br />BREWING SUGGESTIONS: To get the most out of every cup, bring water to boiling and steep 7 minutes. For a stronger tea, use 2 tea bags. Add your favorite sweetener and milk or milk substitute.<br /><br />FDA Statement: *These statements have not been evaluated by the FDA. This product is not intended to diagnose, treat, cure, or prevent any disease.<br /><br />Consult your healthcare provider prior to use if you are pregnant or nursing.<br />",
        4.29, "https://target.scene7.com/is/image/Target/GUEST_c8492955-97c4-4366-885f-fe084ca866ab", 5, Beverages);
    BeveragesArray[5] = new Product("Vita Coco Original Coconut Water - 4pk/500ml Cartons",
        "Full of nutrients, electrolytes, and vitamins that give you a boost, which makes it great for a lot of situations, like when you're thirsty and, well... mostly when you're thirsty.",
        8.29, "https://target.scene7.com/is/image/Target/GUEST_14b5e172-fb90-43d4-92b4-17355c4e7f8c", 2, Beverages);
    BeveragesArray[6] = new Product("Gatorade Cool Blue Sports Drink - 12pk/12 fl oz Bottles",
        "The proven classic. With a legacy of over 50 years in the making, it's the most scientifically researched and game-tested way to replace electrolytes lost in sweat. Gatorade Thirst Quencher is specifically made to help keep you hydrated, which is why it's trusted by some of the world's best athletes.",
        6.69, "https://target.scene7.com/is/image/Target/GUEST_2f923797-f4a3-454c-b69d-3e342d03dbbc", 5, Beverages);
    BeveragesArray[7] = new Product("Tazo Classic Chai Latte Black Tea Coffee Pods – 12ct",
        "TAZO Classic Chai Latte Black Tea K-cups is a blend of black tea, cinnamon, cardamom, black pepper & spices with sweetened dairy packets included to make the perfect latte. Made with pure black tea, the spiced chai tea contains less caffeine than coffee. Each pack contains 12 individual k-cups of chai tea for your convenience. Quick and easy to make; enjoy a cafe-style latte right in your home. Then relax, and enjoy the aromatic blend hot or iced. At TAZO, we're on a quest to be the world's most unexpected tea makers. We explore unexpected blends. We tell unexpected stories to go with them. Witty, entertaining, unconventional stories of TAZO drinkers: People seeking to brew the unexpected in every aspect of their lives. We're always curious, always seeking, always questioning. What's this? What's that? We love to get right in there and mix it up. We're half curious kid, half intrepid explorer, half undaunted alchemist. Yes - one and a half. It's the unpredictable, the unforeseen that drives us. They drive us away from our safe comfort zone in a commandeered golf cart or on the first flight we could find to who knows where or to the last stop of the subway, whichever gets us to points unexplored. That spirit? We bring it to tea. We do it through vibrant, unexpected blends with a twist that unlock the undiscovered flavors the world has stashed away.",
        14.99, "https://target.scene7.com/is/image/Target/GUEST_4d580844-79e9-4abc-b8a2-a7546fccab4b", 1, Beverages);
    BeveragesArray[8] = new Product("Chicago French Press Black Tuxe Medium Roast Coffee - 8oz",
        "Chicago French Press Black Tuxe is a premium, organic Ethiopia Yirgacheffe 100% arabica coffee sourced from the Gambela region of Ethiopia that is hand-picked, naturally processed, sun-dried and cultivated to the highest industry standards. Freshly roasted in Chicago, it brews a refined, exotic cup with fruity nuances and chocolatey undertones.",
        12.99, "https://target.scene7.com/is/image/Target/GUEST_7be27de7-cf4b-41b7-b2b0-62e6a3de1117", 3, Beverages);
    BeveragesArray[9] = new Product(
        "Tropical Fusion Liquid Water Enhancer Drops with Caffeine - 1.62 fl oz - Market Pantry™",
        "Energy Tropical Fusion naturally flavored with other natural flavors Liquid Water Enhancer Drops from market pantry™ add a bright, fruity taste with natural flavors to water, and includes taurine, guarana extract and ginseng extract. Plus, they're infused with B vitamins and caffeine for a boost of energy. Just add the tasty enhancer drops to a bottle of water and shake, it’s great for taking with you while running errands or as your drink of choice at the gym, or use it as an at-home thirst quencher. Zero calories mean these water enhancer drops create a delicious alternative to plain water without adding the things you don’t want.",
        2.19, "https://target.scene7.com/is/image/Target/GUEST_0f68db9e-df65-421a-a342-625e6b899018", 1, Beverages);
    BeveragesArray[10] = new Product("V8 Splash Mango Peach Juice - 64 fl oz Bottle",
        "V8 Splash Mango Peach Flavored Beverage is a refreshing thirst-quencher for the whole family. Made with 5% carrot juice concentrate along with other natural flavors, this V8 juice features notes of mango and peach for delicious kids drinks. Gluten free V8 Splash contains antioxidants vitamin C and B vitamins, and it has 25% less sugar than leading brands of juice drinks (1). Serve this mango peach juice beverage anytime you need a refreshing drink. V8 Splash juice drinks taste best when chilled before serving.\n\n\n(1) PER 8 FL OZ: LEADING SHELF STABLE BRANDS, 17G; SPLASH 10G",
        2.39, "https://target.scene7.com/is/image/Target/GUEST_74267472-4165-42f0-a03e-fc4e6c844a16", 5, Beverages);
    BeveragesArray[11] = new Product("V8 Splash Strawberry Lemonade Juice - 64 fl oz Bottle",
        "V8 Splash Strawberry Lemonade Flavored Beverage is a refreshing thirst-quencher for the whole family. Made with a 5% juice blend along with other natural flavors, this V8 juice features notes of strawberry, watermelon and bright citrus for a fun twist on a classic summer drink. Gluten free V8 Splash contains antioxidant C and B vitamins, and it has 25% less sugar than leading brands of juice drinks (1). Serve this strawberry pink lemonade anytime you need a taste of summer. \n\n\n\n\n\n\n\n(1) PER 8 FL OZ: LEADING SHELF STABLE BRANDS, 17G; SPLASH 12G",
        2.39, "https://target.scene7.com/is/image/Target/GUEST_3400ce64-6040-4109-9810-16722cd12fbf", 2, Beverages);

    BakeryAndBreadArray[0] = new Product("Oroweat Sourdough English Muffins - 13oz",
        "Oroweat sour dough english muffins are soft, tangy, and delicious when toasted. Top with butter or your favorite spread, and savor that old world sourdough flavor.",
        3.39, "https://target.scene7.com/is/image/Target/GUEST_0c4e7b50-f3ef-42a4-8d35-a6ec6f97f9e3", 3,
        BakeryAndBread);
    BakeryAndBreadArray[1] = new Product("Old El Paso Gluten Free Crunchy Taco Shells - 6.89/18ct",
        "Feed the taco frenzy with an 18-count package of Old El Paso Crunchy Taco Shells. Made with only three ingredients, these gluten-free hard taco shells add a satisfying crunch to taco night. Simply add your favorite meats, cheeses, beans and fresh toppings for tasty tacos that are easily customized to make the whole family happy. Tonight, we taco!\n\nFor more than 80 years, Old El Paso has been bringing families and communities together to celebrate old and new traditions around delicious, Mexican-inspired flavors. We believe that any night can be a taco night, and we’re here to help make it a little easier and a lot more delicious. Our variety of crispy hard taco shells, tasty soft tortillas, flavorful seasonings, and much more help make taco night fun.",
        2.69, "https://target.scene7.com/is/image/Target/GUEST_c2ac0ccd-c8c7-4f2f-93dc-c246889ddf78", 5,
        BakeryAndBread);
    BakeryAndBreadArray[2] = new Product("La Banderita Carb Counter Keto Friendly White Tortilla Wraps - 11.9oz/8ct",
        "La Banderita Carb Counter Tortillas are a great choice for a healthier lifestyle. You get only 4g of net carbs, 5g of protein, and 11g of fiber per serving, with only 45 calories! And they are perfect for a Keto Diet! Our delicious Low Carb Tortillas have no added sugars and they are cholesterol free.<br /><br />Taste the tradition!<br /><br />Kosher Parve ═ Certified",
        3.59, "https://target.scene7.com/is/image/Target/GUEST_603e2b66-4dca-4ab7-bdc6-63841ffe821d", 3,
        BakeryAndBread);

    BreakfastAndCerealArray[0] = new Product("Kashi Go Peanut Butter Crunch Cereal - 13.2oz",
        "Treat yourself to the delicious taste of multigrain clusters bursting with peanut buttery goodness in every bite of Kashi GO Peanut Butter Crunch breakfast cereal. Includes 1, 13.2-ounce box of breakfast cereal. Whether it’s starting the morning with a quick and easy breakfast or enjoying as a midday snack, Kashi GO breakfast cereal delivers big peanut butter flavor that’s sure to please. Both vegan and Non-GMO Project Verified, each wholesome serving provides 10g of protein and 6g of fiber; Kashi GO breakfast cereal is the perfect way to power your day. Enjoy with your favorite milk or pair with fruit or yogurt for a delicious breakfast. For a portable snack, pack reusable baggies of Kashi GO Peanut Butter Crunch into your purse, lunch box or gym bag. Kashi GO Peanut Butter Crunch cereal also makes a great after dinner treat by the handful or as a topping on your favorite ice cream. Anytime is the right time for Kashi GO Peanut Butter Crunch cereal. Kashi is making planet-positive choices to lower our company’s impact on climate change. We measure the amount of emissions from the manufacturing plants that create our foods and invest in renewable energy projects and programs in the US that remove the same amount of emissions from the air.",
        3.99, "https://target.scene7.com/is/image/Target/GUEST_326f2c2e-a4ae-4c5a-a4b7-ced13674bdd5", 1,
        BreakfastAndCereal);

    CandyArray[0] = new Product("Tootsie Fruit Chews Standup Bag – 37oz",
        "Offering the same look and chew as the original Tootsie Roll in fruit-flavored varieties, Tootsie Fruit Chews are equally tasty candy treats. The individally wrapped, bite-sized treats are available in five great tasting flavors: Cherry, Lemon, Vanilla, Orange, and Lime. Pefect for parties, holidays, parades, or for keeping for yourself. Peanut free and Gluten free.",
        6.99, "https://target.scene7.com/is/image/Target/GUEST_9cd539e1-ed8b-4268-9362-7a88e07e4c70", 5, Candy);
    CandyArray[1] = new Product("Jelly Belly 49 Flavor Jelly Beans - 2lbs",
        "Jelly Belly makes more jelly bean flavors than anyone on the market today, and here are just a few of them - 49 to be exact! This plentiful assortment has the delicious flavors you love, and new favorites to discover. From most popular to nostalgic to unexpectedly delightful, this wide variety has something for everyone to enjoy. Snack, share, or pack into party favors. This generous bag is a great choice for so many occasions. <br /><br />True-to-life flavors in this assortment include: A&W cream soda, A&W root beer, Berry Blue, blueberry, bubble gum, buttered popcorn, cantaloupe, cappuccino, caramel corn, chocolate pudding, cinnamon, coconut, cotton candy, crushed pineapple, Dr Pepper, French vanilla, green apple, island punch, Juicy Pear, kiwi, lemon drop, lemon lime, Sunkist lemon, licorice, Sunkist lime, mango, margarita, mixed berry smoothie, orange sherbet, Sunkist orange, peach, Sunkist pink grapefruit, piña colada, plum, pomegranate, raspberry, red apple, Sizzling Cinnamon, strawberry cheesecake, Sunkist tangerine, toasted marshmallow, top banana, tutti-fruitti, Very Cherry, and watermelon.<br /><br />For generations, Jelly Belly fans have thoughtfully combined Jelly Belly jelly bean flavors to make new tastes. These Jelly Belly recipes are favorites among candy lovers with combinations like 2 A&W root beer + 1 A&W cream soda = root beer float, 2 blueberry + 1 buttered popcorn = blueberry muffin, and 2 green apple + 1 cinnamon = candy apple. Try your own combinations!<br /><br />Jelly Belly jelly beans are famous for their wide range of delicious and true-to-life flavors. With flavor packed into the center as well as the irresistible outer shell, each bite is an intense flavor adventure. The company got its start in 1898, and today makes more than 100 flavors of jelly beans worldwide. Jelly Belly jelly beans have millions of fans around the world with a flavor for everyone. Discover your new favorite flavor.<br /><br />",
        12.69, "https://target.scene7.com/is/image/Target/GUEST_d2d62483-66b4-4b81-b894-d3488c740c6f", 3, Candy);
    CandyArray[2] = new Product("Justin's Milk Chocolate Peanut Butter Cups - 4.7oz",
        "Pour Justin's Milk Chocolate Peanut Butter Cups into your favorite candy dish for a mini treat for everyone who stops by for a visit. They are individually wrapped, so they are the perfectly shareable snack. Or you can keep them to yourself for a quick little pick-me-up throughout your busy day.",
        5.99, "https://target.scene7.com/is/image/Target/GUEST_ffe41147-fe1f-4a18-9ac7-437bc14bd756", 4, Candy);
    CandyArray[3] = new Product("Twizzlers Strawberry Flavored Twists - 16oz",
        "There ain't no party like a TWIZZLERS candy party! Seriously though, TWIZZLERS Twists strawberry-flavored chewy candies are too fun not to enjoy at every movie marathon, birthday party and tailgate. With a bag of strawberry-flavored chewy candies ready for action, you'll never find yourself without a delicious shareable snack. Bite both ends of a TWIZZLERS Twists candy off to create a straw, then dip your straw into a cold glass of milk, a steaming hot chocolate or a frothy milkshake. If you're more into eating a couple of these chewy treats on their own, you'll be ready to go the second you open the bag. Keep your pantry stocked with kosher-certified, low-fat TWIZZLERS Twists candies, store some in your work desk, take a bag on a road trip and bring a pack to your next party gathering. Looking for an even greater adventure? For a unique twist, melt several white or milk chocolate bars. Dip your TWIZZLERS candies in the melted gooiness, then cover each piece in sprinkles and let the new treats cool!",
        2.69, "https://target.scene7.com/is/image/Target/GUEST_dbbf0fff-3d70-4040-9707-70795a45b487", 4, Candy);
    CandyArray[4] = new Product("Kisses Milk Chocolate Candy - 17.9oz",
        "Need to make sure the whole family is happy with the snack selection? Looking to give your employees a midday treat they actually enjoy? Whatever the case, HERSHEY'S KISSES candies have you covered. These milk chocolate classics make the perfect creamy treat throughout the day. Try some in a new dessert recipe or on top of your favorite cookie and cake treats for an extra bite of bliss your loved ones won't want to miss. Sprinkle a few over your homemade ice cream sundaes, or place them in party favors to delight guests with stunning foil wrappers and even more stunning flavor. These treats are perfect as stocking stuffers at Christmas, party favor filling during Valentine's Day, trick-or-treat candy at Halloween and basket sweets on Easter. Just don't forget to hang onto a few bite-size milk chocolates to include in your movie night snack selection and on-the-go trips. Try them chilled, on top of baked desserts and, of course, straight from the wrapper — any choice is a route straight to delicious!",
        5.99, "https://target.scene7.com/is/image/Target/GUEST_c7a35f31-9a80-4a74-86d8-2c29e27da2cd", 4, Candy);

    FrozenFoodsArray[0] = new Product("Healthy Choice Café Steamers Frozen Chicken Margherita - 9.5oz",
        "Healthy Choice Café Steamers Chicken Margherita With Balsamic Frozen Meal satisfies your cravings with quality ingredients. Savor a quick and delicious microwaveable meal featuring true steaming technology anytime. This dish combines juicy white meat chicken, al dente angel hair pasta, roasted garlic and tomatoes tossed in a balsamic vinaigrette sauce for a meal that's as delicious as it is healthy. Made with no preservatives, this wholesome, microwave-ready meal delivers a bold experience any day of the week. Perfect for an on-the-go power lunch or a quick and delicious dinner at home after a long day, this single-serve meal contains 270 calories, 0 grams of trans fat and 17 grams of protein to keep you satisfied. Healthy Choice makes it easy to eat mindfully with bold, flavorful meals made with high-quality ingredients and contemporary recipes that are easy to prepare. Stock your freezer with a variety of Healthy Choice Café Steamers to keep healthy, wholesome meals on hand.",
        3.49, "https://target.scene7.com/is/image/Target/GUEST_3b2887f0-c710-4ed7-bd9c-d75756d0ebc6", 2, FrozenFoods);
    FrozenFoodsArray[1] = new Product("Wholly Veggie! Gluten Free and Vegan Frozen Ranch Cauliflower Wings - 13.2oz",
        "", 6.99, "https://target.scene7.com/is/image/Target/GUEST_83d810bd-a86f-40d8-a9a3-18470c331278", 3,
        FrozenFoods);
    FrozenFoodsArray[2] = new Product("Ben & Jerry's Ice Glampfire Trail Mix Frozen Dessert - 16oz",
        "Ben & Jerry's Chocolate Ice Cream with Crunchy Pretzel Swirls, Marshmallow Swirls & Fudge Covered Almonds. Inspired by glampfire tales of outdoorsy getaways filled with indoorsy perks, our trail mix is uber chocolatey, nutty, marshmallowed & pretzeled, so you can get lost in this ice cream dessert without leaving the yurt.<br />The pleasures of camping are numerous: twinkling stars overhead. Glorious vistas. Fresh air. A chance to reconnect with nature. Wildlife sightings Thoreau, Emerson, and Audubon all waxed poetic about the joys of the outdoor world, but here’s one thing that never came up in their verse: the food. It’s a funny little trick of nature that the farther you get out in the middle of it, the more proficient you’d better be at hunting, gathering, harvesting, and campfire cooking.<br />But then we realized that we’re actually pretty darned good at hunting down deliciously chocolatey ice cream, gathering crunchy and gooey swirls to fill it, and stalking the perfect herd of fudge covered almonds to make a wildly delicious concoction. So go ahead: go for that camping trip Or simply crack a pint of Glampfire Trail Mix, grab a spoon and kick your feet up no campfire required though we do think it tastes even better under the stars<br />We get all starry eyed over our ingredients, which is why we use Fairtrade certified cocoa, sugar, and vanilla in this pint, as well as cage free eggs, Non GMO ingredients and milk from our Caring Dairy Program. And because we love nature too, we also wrap it up in responsibly sourced packaging for a treat that you and the earth can love",
        4.79, "https://target.scene7.com/is/image/Target/GUEST_d55257d8-01bf-4411-a409-37d6a3d9ff44", 5, FrozenFoods);
    FrozenFoodsArray[3] = new Product("Halo Top Mint Chip Ice Cream - 16oz",
        "Treat yourself with the great tasting flavor of our Halo Top Mint Chip Frozen Dessert. Made with high-quality  ingredients, this any-time treat contains less sugar than regular ice cream but tastes just as good! Here at Halo Top, we believe that rules are meant to be frozen. That's why we think you can eat the whole pint! Indulge in your sweet cravings with this delectable and refreshing mint ice creamy dessert. Inside our Mint Chip light ice cream, the fresh taste of mint is best accompanied by rich chocolate chips and is only enhanced by a good source of protein. Together, the three are unstoppable at only 330 calories per pint.",
        4.99, "https://target.scene7.com/is/image/Target/GUEST_bba79185-63eb-47ac-b8e3-9b9cd347c1b2", 4, FrozenFoods);

    Pantry.setProducts(Arrays.asList(PantryArray));
    MeatAndSeafood.setProducts(Arrays.asList(MeatAndSeafoodArray));
    Deli.setProducts(Arrays.asList(DeliArray));
    WineBeerAndLiquor.setProducts(Arrays.asList(WineBeerAndLiquorArray));
    Dairy.setProducts(Arrays.asList(DairyArray));
    Snacks.setProducts(Arrays.asList(SnacksArray));
    Beverages.setProducts(Arrays.asList(BeveragesArray));
    BakeryAndBread.setProducts(Arrays.asList(BakeryAndBreadArray));
    BreakfastAndCereal.setProducts(Arrays.asList(BreakfastAndCerealArray));
    Candy.setProducts(Arrays.asList(CandyArray));
    FrozenFoods.setProducts(Arrays.asList(FrozenFoodsArray));

    categoryRepository.save(Pantry);
    categoryRepository.save(MeatAndSeafood);
    categoryRepository.save(Deli);
    categoryRepository.save(WineBeerAndLiquor);
    categoryRepository.save(Dairy);
    categoryRepository.save(Snacks);
    categoryRepository.save(Beverages);
    categoryRepository.save(BakeryAndBread);
    categoryRepository.save(BreakfastAndCereal);
    categoryRepository.save(Candy);
    categoryRepository.save(FrozenFoods);

    john.getCart().addProductToCart(new CartItem(PantryArray[0], 3));
    john.getCart().addProductToCart(new CartItem(DeliArray[0], 1));

    List<Order> orders = new ArrayList<>();
    orders.add(new Order(john.getCart().getCartItems()));

    john.setOrders(orders);
    customerRepository.save(john);
    customerRepository.save(steve);
  }

}
