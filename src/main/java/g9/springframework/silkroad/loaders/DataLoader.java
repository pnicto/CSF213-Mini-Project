package g9.springframework.silkroad.loaders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import g9.springframework.silkroad.models.Admin;
import g9.springframework.silkroad.models.Cart;
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
  private final PasswordEncoder passwordEncoder;

  @Override
  public void run(ApplicationArguments args) throws Exception {

    // Load admin data
    adminRepository.save(new Admin("Abdul", "abdul@email.com", passwordEncoder.encode("password"), "101"));

    // Load manager data
    managerRepository
        .save(new Manager("James", "man@email.com", passwordEncoder.encode("badApple"), "420"));


    var steve = customerRepository
        .save(new Customer("Steve", "steve@email.com", passwordEncoder.encode("pwdpwd"), "666"));

    customerRepository.save(new Customer("Irvin", "irvin@email.com", passwordEncoder.encode("irvin"), "108",
        LocalDateTime.now().minusMonths(2)));

    // Categories and products
    Category BabyBathAndSkinCare = new Category("Baby Bath & Skin Care");
    Category Beverages = new Category("Beverages");
    Category BreakfastCereals = new Category("Breakfast Cereals");
    Category CookingSaucesAndVinegar = new Category("Cooking Sauces & Vinegar");
    Category CreamsLotionsSkinCare = new Category("Creams, Lotions, Skin Care");
    Category Dairy = new Category("Dairy");
    Category DeosPerfumesAndTalc = new Category("Deos, Perfumes & Talc");
    Category DetergentsAndLaundry = new Category("Detergents & Laundry");
    Category DiapersAndWipes = new Category("Diapers & Wipes");
    Category FloorAndOtherCleaners = new Category("Floor & Other Cleaners");
    Category GheeAndOils = new Category("Ghee & Oils");
    Category HairCare = new Category("Hair Care");
    Category HealthandWellness = new Category("Health and Wellness");
    Category HouseholdCareAndPetFood = new Category("Household Care|Pet Food");
    Category KajalAndMakeup = new Category("Kajal & Makeup");
    Category MasalasAndSpices = new Category("Masalas & Spices");
    Category RepellantsAndFresheners = new Category("Repellants & Fresheners");
    Category RiceAndRiceProducts = new Category("Rice & Rice Products");
    Category ShavingNeeds = new Category("Shaving Needs");
    Category SoapsAndBodyWash = new Category("Soaps & Body Wash");

    Product[] BabyBathAndSkinCareArray = new Product[12];
    Product[] BeveragesArray = new Product[12];
    Product[] BreakfastCerealsArray = new Product[12];
    Product[] CookingSaucesAndVinegarArray = new Product[4];
    Product[] CreamsLotionsSkinCareArray = new Product[12];
    Product[] DairyArray = new Product[6];
    Product[] DeosPerfumesAndTalcArray = new Product[12];
    Product[] DetergentsAndLaundryArray = new Product[11];
    Product[] DiapersAndWipesArray = new Product[12];
    Product[] FloorAndOtherCleanersArray = new Product[12];
    Product[] GheeAndOilsArray = new Product[8];
    Product[] HairCareArray = new Product[12];
    Product[] HealthandWellnessArray = new Product[12];
    Product[] HouseholdCareAndPetFoodArray = new Product[7];
    Product[] KajalAndMakeupArray = new Product[12];
    Product[] MasalasAndSpicesArray = new Product[12];
    Product[] RepellantsAndFreshenersArray = new Product[12];
    Product[] RiceAndRiceProductsArray = new Product[12];
    Product[] ShavingNeedsArray = new Product[10];
    Product[] SoapsAndBodyWashArray = new Product[12];

    BabyBathAndSkinCareArray[0] = new Product("Johnson's All Day Long Baby Lotion  (100 ml)",
        "When a baby is born, her skin is most delicate. That's why we perfected our formulas over 125 years so they are now more gentle to give her the best care. Johnson's baby lotion has been improved to slow down moisture loss by hydrating skin, locking in moisture and creating a protective barrier to keep moisture in and dryness out. This clinically proven long lasting formula continuously protects babys skin for up to 24 hours, keeping it feeling healthy and baby soft.",
        88,
        "https://rukminim1.flixcart.com/image/832/832/jn3hocw0/moisturizer-cream/v/r/h/100-all-day-long-baby-lotion-johnson-s-lotion-original-imaf9ruu6tchfbfh.jpeg?q=70",
        1, BabyBathAndSkinCare);
    BabyBathAndSkinCareArray[1] = new Product("Himalaya Gentle Baby Shampoo  (200 ml)",
        "While caring for newborns, it is highly important to use gentle products; choose the right shampoo for your little one today. The Himalaya Gentle Baby Shampoo has been formulated so it takes care not to harm the natural balance of your loved one’s hair, instead treats it with utmost love and attention. Ideal for baby boys and girls, this shampoo is infused with hibiscus extracts that soften your baby’s hair and keep it feeling silky always. The shampoo also includes rice, bengal gram and khas-khas, all organic ingredients that will soothe and protect your kid’s hair all the time. All these components in the Himalaya Baby Shampoo help in cleansing your child’s scalp gently and leaves it conditioned. The shampoo takes proper care to nourish the tender hair roots of your child so your baby’s hair is always strong and grows thicker. Apply this shampoo on to wet hair and lather well because this lather helps to soften and cleanse your kid’s hair thoroughly. After using this Baby Shampoo your tiny tot’s hair will feel soft and become tangle free and easily manageable. This baby shampoo is ideal for baby’s and fights hair fall so your baby never loses too much hair. This herbal shampoo is perfect for cleansing.",
        134,
        "https://rukminim1.flixcart.com/image/832/832/jnj7iq80/shampoo/y/n/t/400-gentle-baby-shampoo-himalaya-original-imafa74aweejg9hp.jpeg?q=70",
        4, BabyBathAndSkinCare);
    BabyBathAndSkinCareArray[2] = new Product("Himalaya Refreshing Baby Wash  (200 ml)",
        "HimalayaRefreshing Baby Washhas cooling, refreshing, antibacterial, and anti-inflammatory properties, which effectively help manage prickly heat rashes and excessive sweating in babies. Our baby wash contains Watermelon and Champaca that cool, condition, and refresh the skin, while Neem's antibacterial properties prevent skin ailments. Ideal for use during the summer, Himalaya Refreshing Baby Wash is free from artificial colors.",
        145,
        "https://rukminim1.flixcart.com/image/832/832/jnj7iq80/body-wash/g/y/q/200-refreshing-baby-wash-himalaya-original-imaf9rbjhrgfyrgr.jpeg?q=70",
        1, BabyBathAndSkinCare);
    BabyBathAndSkinCareArray[3] = new Product("MeeMee Gentle Bubble Bath  (500 ml)",
        "All Mee Mee Products are carefully made to the highest safety standards. The gentle and mild formulation cleanses the skin without drying, leaving it soft and beautiful. Specially made for your baby skin it comes with a pure and gentle cleanser.",
        275,
        "https://rukminim1.flixcart.com/image/832/832/jpyddow0/body-wash/u/n/w/500-gentle-bubble-bath-meemee-original-imafcfwsynb8873h.jpeg?q=70",
        1, BabyBathAndSkinCare);
    BabyBathAndSkinCareArray[4] = new Product("MeeMee Mee Mee Fresh Feel Baby Powder 200 g  (200 g)",
        "Mee Mee velvety soft baby powder is extremely light and keeps your baby's skin fresh and dry. Safe to use from birth and microbiologically tested, it can be used after bath, after a nappy change or just to freshen up during the day.",
        168,
        "https://rukminim1.flixcart.com/image/832/832/jpyddow0/talc/a/h/u/200-mee-mee-fresh-feel-baby-powder-200-g-meemee-original-imafcfz8tqqvbge8.jpeg?q=70",
        3, BabyBathAndSkinCare);
    BabyBathAndSkinCareArray[5] = new Product("Johnson's Milk Plus Rice Lotion  (100 ml)",
        "Keeping your baby’s skin soft and supple by using this Johnson’s Baby Milk Lotion. This baby lotion will replenish your baby’s skin with the required moisture. Contains natural milk extract and Vitamins A & E As this lotion contains natural milk extracts and vitamins A & E your baby’s skin is moisturised naturally. Leaves skin feeling baby soft The lotion leaves the skin feeling baby soft as it nourishes it from within. Unique double nourishment formula This lotion is enriched with a unique double nourishment formula which will add moisture to your baby’s skin. Clinically proven mild As this lotion is clinically proven to be mild, you don’t need to think twice before using it on your baby’s skin. Helps replenish moisture To keep your baby’s skin hydrated, this lotion helps replenish the lost moisture.",
        95,
        "https://rukminim1.flixcart.com/image/832/832/jpbic280/moisturizer-cream/k/3/5/100-milk-plus-rice-lotion-lotion-johnson-s-original-imafbhkznnuetuwk.jpeg?q=70",
        3, BabyBathAndSkinCare);
    BabyBathAndSkinCareArray[6] = new Product("Johnson's Baby Milk Cream  (50 g)",
        "Keeping your baby’s skin soft and supple is an integral part of maintaining their hygiene. This Johnson’s Baby Milk Cream will lend your little one’s skin with the required moisture and nourishment. Contains a unique combination of natural milk extract and Vitamins A & E With a perfect blend of natural milk extracts, vitamins A & E, this milk cream naturally replenishes your baby’s skin with moisture and nutrients. Contains rich emollients and added moisture boost The rich emollients and added moisture boost make your baby’s skin soft and giving it a soothing effect. Helps replenish moisture to leave skin feeling baby soft This baby cream helps replenish moisture, thus leaving the skin feeling baby soft and supple. Clinically proven mild As this cream is clinically proven to be mild you need not think twice before applying it on your baby’s skin.",
        75,
        "https://rukminim1.flixcart.com/image/832/832/jk76j680/moisturizer-cream/g/h/t/50-baby-milk-cream-johnson-s-cream-original-imaf7hnwzdqqdgzj.jpeg?q=70",
        4, BabyBathAndSkinCare);
    BabyBathAndSkinCareArray[7] = new Product("MeeMee Chamomile Baby Lotion  (200 ml)",
        "Nurture your baby’s delicate skin with MeeMee Chamomile Baby Lotion. Infused with the goodness of chamomile and antioxidants, this baby lotion nourishes and protects your baby’s delicate skin. Dermatologically Tested    This lotion is clinically safe and dermatologically tested to make sure your baby gets the best care. Antioxidant Properties    With its antioxidant properties, it restores the balance of your baby’s fragile and soft skin without any harmful chemicals. Infused with Chamomile  This lotion has chamomile infused in it to safeguard your baby’s skin and keep it moisturised.",
        168,
        "https://rukminim1.flixcart.com/image/832/832/jpyddow0/moisturizer-cream/f/x/y/200-chamomile-baby-lotion-lotion-meemee-original-imafcfnnduhhftmx.jpeg?q=70",
        3, BabyBathAndSkinCare);
    BabyBathAndSkinCareArray[8] = new Product("MeeMee Mee Mee Baby Bubble Bath 200 ml  (200 ml)",
        "All Mee Mee Products are carefully made to the highest safety standards. The gentle and mild formulation cleanses the skin without drying, leaving it soft and beautiful. Specially made for your baby skin it comes with a pure and gentle cleanser.",
        166,
        "https://rukminim1.flixcart.com/image/832/832/jpyddow0/body-wash/g/q/m/200-mee-mee-baby-bubble-bath-200-ml-meemee-original-imafcfx7rgejywrf.jpeg?q=70",
        4, BabyBathAndSkinCare);
    BabyBathAndSkinCareArray[9] = new Product("Johnson's Babycream  (100 g)",
        "Restoring the suppleness in your child’s skin, Johnsons Baby Cream nourishes his skin and prevents it from irritating wetness and wind burns. Gentle for everyday use, this cream is quickly absorbed and blends well to take care of your child’s skin from the pores. Clinically Proven Mild Formulated with rich ingredients, this cream is mild and perfect for your baby’s tender skin. Protect your baby’s cheek, knees, elbows and nose with a regular application of this cream. With Vitamin E and Glycerin With Vitamin E and Glycerin as key ingredients, this baby cream retains the essential moisture and prevents excessive dryness. Forms a Protective Barrier on Baby's Skin Protecting your baby’s skin from rashes and allergies, this cream forms a barrier on your baby’s skin and keeps it smooth and glowing.",
        124,
        "https://rukminim1.flixcart.com/image/832/832/jk76j680/moisturizer-cream/g/u/6/100-baby-cream-johnson-s-cream-original-imaf5g58nbagwspt.jpeg?q=70",
        3, BabyBathAndSkinCare);
    BabyBathAndSkinCareArray[10] = new Product("Dabur Amla Kids Nourishing Shampoo  (200 ml)",
        "Dabur Amla Kids nourishing Hair shampoo is specially developed for kids keeping in mind their soft scalp and hair. Enriched with natural ingredients such as Amla, Almonds and Shikakai, it does not contain sulphate. It is the safest product for gentle cleansing of your kids' hair. Special formulation without harmful chemicals, developed for Kids, Contains extracts of natural ingredients such as Amla, Almonds and Shikakai , For Gentle cleansing of soft hair , Completely safe and mild product & Contains No Sulphate, no Paraben",
        123,
        "https://rukminim1.flixcart.com/image/832/832/jz5vjbk0/shampoo/z/p/y/200-nourishing-shampoo-dabur-amla-kids-original-imafj52yprzwhrgm.jpeg?q=70",
        5, BabyBathAndSkinCare);
    BabyBathAndSkinCareArray[11] = new Product("Himalaya Extra Moisturizing baby wash 200 ml  (200 ml)",
        "HimalayaRefreshing Baby Washhas cooling, refreshing, antibacterial, and anti-inflammatory properties, which effectively help manage prickly heat rashes and excessive sweating in babies. Our baby wash contains Watermelon and Champaca that cool, condition, and refresh the skin, while Neem's antibacterial properties prevent skin ailments. Ideal for use during the summer, Himalaya Refreshing Baby Wash is free from artificial colors.",
        145,
        "https://rukminim1.flixcart.com/image/832/832/jnj7iq80/body-wash/n/f/b/100-extra-moisturizing-baby-wash-100-ml-himalaya-original-imafa749ympdfehg.jpeg?q=70",
        3, BabyBathAndSkinCare);

    BeveragesArray[0] = new Product("Saffola Fittify Gourmet Lemon Mint Instant Coffee  (30 g, Green Coffee Flavoured)",
        "This Saffola FITTIFY Gourmet - Green Coffee Instant beverage mix has been created by nutritionists and curated by Chef Kunal Kapur. This hot beverage is a health booster that is high in antioxidants that aids in weight loss & management. This green coffee is rich in antioxidants as it has not been roasted. Benefits This green coffee is rich in antioxidants that aid weight loss and regulate metabolism. It also helps regulate blood pressure and sugar levels. ",
        257,
        "https://rukminim1.flixcart.com/image/832/832/jph83gw0/coffee/z/q/g/30-green-coffee-instant-beverage-mix-lemon-mint-instant-coffee-original-imafbpy8sudkhyxh.jpeg?q=70",
        5, Beverages);
    BeveragesArray[1] = new Product("Tropicana Litchi Delight Fruit Beverage  (1 L)",
        "The Tropicana Litchi Delight is a fruity beverage that can be enjoyed by everyone, regardless of their age. This tasty fruit drink provides you with the goodness of litchi.",
        93,
        "https://rukminim1.flixcart.com/image/832/832/jerf7gw0/drinks-juice/j/h/r/1-litchi-delight-fruit-beverage-tetrapack-tropicana-original-imaf3d9qhxmhyytm.jpeg?q=70",
        2, Beverages);
    BeveragesArray[2] = new Product(
        "Saffola Fittify Gourmet Ginger Basil Instant Coffee  (30 g, Green Coffee Flavoured)",
        "This Saffola FITTIFY Gourmet - Green Coffee Instant beverage mix has been created by nutritionists and curated by Chef Kunal Kapur. This hot beverage is a health booster that is high in antioxidants that aids in weight loss & management. This green coffee is rich in antioxidants as it has not been roasted. Benefits This green coffee is rich in antioxidants that aid weight loss and regulate metabolism. It also helps regulate blood pressure and sugar levels. ",
        257,
        "https://rukminim1.flixcart.com/image/832/832/jph83gw0/coffee/d/d/r/30-green-coffee-instant-beverage-mix-ginger-basil-instant-coffee-original-imafbpy8ruzn76tn.jpeg?q=70",
        4, Beverages);
    BeveragesArray[3] = new Product("Saffola Fittify Gourmet Superfood Moringa Jasmine Green Tea Box  (37.5 g)",
        "This Saffola Fittify Gourmet Classic green tea combines nutrition and taste for a healthy lifestyle. Enriched with the goodness of Moringa leaves (of the drumstick plant), this green tea is packed with vitamins, minerals and other nutrients to help manage weight, boost immunity and regulate your metabolism. Healthy and Flavoursome This green tea is scientifically prepared by nutritionists in collaboration with Kunal Kapur - a renowned chef - to add more nutrition to your beverage. Nutrition Powerhouse Moringa leaves are power-packed with vitamins and minerals, and they boost immunity, help manage weight and regulate your metabolism. These leaves are a rich source of protein, iron, calcium and vitamin C, and are known for their antioxidant properties. The Power of Superfood With every sip of this green tea, you can say hello to better bone and joint health. Moringa comprises more calcium than milk, iron than spinach, proteins than dal, and vitamin C than plums.",
        217,
        "https://rukminim1.flixcart.com/image/832/832/jph83gw0/tea/a/5/w/37-5-superfood-moringa-green-tea-jasmine-15-sachets-green-tea-original-imafbpy77q8qchr7.jpeg?q=70",
        1, Beverages);
    BeveragesArray[4] = new Product("Protinex ORGINAL Nutrition Drink  (250 g, ORGINAL Flavored)", "HEALTHDRINKS", 360,
        "https://rukminim1.flixcart.com/image/832/832/jxdkpzk0/energy-sport-drink-mix/n/b/s/250-orginal-protinex-original-imafhujgxxczaur6.jpeg?q=70",
        3, Beverages);
    BeveragesArray[5] = new Product("Minute Maid Litchi Juice  (1 L)",
        "Quench your thirst with the refreshing Minute Maid litchi fruit drink from the Coca-Cola Company that comes infused with the luscious taste of litchis. With the perfect balance of sweet and tart, this drink will leave you wanting for more with every sip that you take. Luscious Taste of Indian Litchis Relish the goodness of litchis with this fruit drink that is not only delicious, but is also refreshing. This drink has the perfect balance of the sweet and tart taste. Share with Your Family Make your quality time with friends and family more fun with this ready-to-drink fruit drink that tastes best when served chilled.",
        78,
        "https://rukminim1.flixcart.com/image/832/832/jqzitu80/drinks-juice/v/v/m/1-litchi-juice-tetrapack-minute-maid-original-imafcvvqvetnzrbs.jpeg?q=70",
        1, Beverages);
    BeveragesArray[6] = new Product("Sprite Can  (300 ml)",
        "Let the lemon-flavour of the Sprite soft drink quench your thirst and refresh your taste buds instantly. This refreshing beverage complements meals, and also, it gives you instant energy to sail through the hot summer days. Clean and Crisp Flavour This lemon-flavour drink has a clean and crisp taste. Ideal Summer Drink This is a refreshing summer drink that hydrates your senses. Drink Anytime You can drink Sprite with your meals, on the move, and also while chilling with friends. Perfect Party Drink This drink is perfect for parties and gatherings. Serve Chilled To quench your thirst, drink it chilled and bubbling.",
        30,
        "https://rukminim1.flixcart.com/image/832/832/jqzitu80/aerated-drink/x/x/h/300-na-can-sprite-original-imafcvvq2njmhfbt.jpeg?q=70",
        3, Beverages);
    BeveragesArray[7] = new Product("Tropicana Pomegranate Delight Fruit Beverage  (1 L)",
        "Pomegranates are a rich source of nutrients. What if we told you that there is a delicious way to add this fruit to your diet? Take a glass and pour this refreshing drink from Tropicana.",
        93,
        "https://rukminim1.flixcart.com/image/832/832/jsaocy80/drinks-juice/g/s/x/1-pomegranate-delight-fruit-beverage-tetrapack-tropicana-original-imafdwkhap7ca8eb.jpeg?q=70",
        3, Beverages);
    BeveragesArray[8] = new Product("Limca Lime n Lemoni Can  (300 ml)",
        "Is it too sunny? Are you having a sudden mood swing? Oh wait, do you really need a reason to relish the flavour of tangy lemon with fizz from this soft drink from Limca? We don't think so! Tangy Lemon with Some Sharp Fizz Whether it’s an interview or just plain boredom, the combination of tangy lemon with some fizz from this drink is enough to say goodbye to all worries. Quench Your Thirst No matter what time of the day it is, you can easily quench your thirst by having this soft drink.",
        30,
        "https://rukminim1.flixcart.com/image/832/832/jqzitu80/aerated-drink/r/h/q/300-lime-n-lemoni-can-limca-original-imafcvvqqhcrvqgx.jpeg?q=70",
        5, Beverages);
    BeveragesArray[9] = new Product("Tropicana Mixed Fruit with Cranberry Delight  (2 L)",
        "The Tropicana Mixed Fruit and Tropicana Cranberry Delight bring to you the goodness of fruits like oranges, apples and cranberries. These beverages feature a special six-layer protection to keep the freshness intact. With no added sugar, these beverages from Tropicana are a great option to take up a healthy lifestyle.",
        201,
        "https://rukminim1.flixcart.com/image/832/832/jwfa5jk0/drinks-juice/p/j/j/mixed-fruit-delight-with-cranberry-delight-fruit-beverage-original-imafh4b7z789pjtz.jpeg?q=70",
        2, Beverages);
    BeveragesArray[10] = new Product("Schweppes Tonic  (300 ml)",
        "Add a dash of zest to your drinks with the Schweppes Tonic that offers a distinctive tang to excite your taste buds. Made with quinine and other delicious ingredients, this tonic can be enjoyed on the rocks and/or with mocktails and cocktails. Refreshing Drink Mixer This is a refreshing and tasty drink mixer to make your favorite drink taste even better. Distinctive Taste Made of quinine and other ingredients, this tonic has a distinctive taste. Ideal for Mocktails and Cocktails Make flavour-rich mocktails and cocktails at home with the Schweppes Tonic. A Standalone Drink Make a standalone drink on the rocks with this tonic and feel refreshed instantly. Serve Chilled Serve the drink chilled and bubbling to enjoy every sip.",
        50,
        "https://rukminim1.flixcart.com/image/832/832/jqzitu80/aerated-drink/e/m/8/300-tonic-schweppes-original-imafcvvqgzgj6dfc.jpeg?q=70",
        4, Beverages);
    BeveragesArray[11] = new Product("Nescafe Sunrise Instant Coffee  (100 g)",
        "Kickstart your day with this Nescafe Sunrise - Instant Coffee-Chicory Mix. The rich aroma and taste of this coffee mix is sure to leave you feeling energized and pumped for the day.  The Ideal Blend The Nescafe Sunrise - Instant Coffee-Chicory Mix is an aromatic blend of coffee (70%) and chicory (30%). Arabica and Robusta Beans This instant coffee-chicory mix has been carefully blended with slow-roasted Arabica and Robusta coffee beans to provide you with a rich taste.",
        180,
        "https://rukminim1.flixcart.com/image/832/832/jph83gw0/coffee/b/3/k/100-sunrise-instant-coffee-pouch-nescafe-original-imafbpghvwtjtcfg.jpeg?q=70",
        1, Beverages);

    BreakfastCerealsArray[0] = new Product("Quaker Oats Plus Multigrain Advantage  (600 g, Pouch)",
        "Featuring the benefits of four different grains (oats, wheat, ragi, and barley), this packet from Quaker will be a delicious and healthy addition to your daily nutrition. You can add various toppings and create your very own multigrain breakfast bowl.",
        134,
        "https://rukminim1.flixcart.com/image/832/832/jsaocy80/cereal-flake/z/e/z/600-oats-plus-multigrain-advantage-pouch-quaker-original-imafdwkhcsfk8y6h.jpeg?q=70",
        5, BreakfastCereals);
    BreakfastCerealsArray[1] = new Product("Saffola Pongal Surprise Masala Oats  (38 g, Pouch)",
        "Made from 100% natural whole grains and bursting with the flavours of the choicest masalas and real vegetables, this Saffola Masala Oats is not only a treat for your taste buds, but also deliciously healthy. The Authentic Taste of Pongal with a Twist The wholesome goodness of oats, sprinkled with a delicious mix of roasted cashews, spices, and condiments make this Saffola Masala Oats a filling and nutritious breakfast or snack option. What’s even better news is that it cooks in just three minutes! Nutritional Benefits Each spoonful of this oats packs natural fibres and protein. Eating a bowl of this oats keeps you full for a long period of time; something you’d find especially beneficial if you’re trying to manage your body weight.",
        15,
        "https://rukminim1.flixcart.com/image/832/832/jf1fafk0/cereal-flake/n/v/d/39-pongal-surprise-masala-oats-pouch-saffola-original-imaf2p2m9c7hzqz7.jpeg?q=70",
        4, BreakfastCereals);
    BreakfastCerealsArray[2] = new Product("Saffola Peppy Tomato Masala Oats  (500 g, Pouch)",
        "Tailored specifically for the Indian palate, Saffola Masala Oats come in a wide variety of flavours such as , Curry & Pepper Masala, Masala & Coriander Masala, Veggie Twist Masala, Chinese Flavour Masala and more. The Saffola Masala Oats is high in fibre and protein, and a quick fix for a healthy meal any time of the day. It also helps you manage your weight. 100% Natural Ingredients The Saffola Masala Oats are made from 100% natural wholegrain oats along with real vegetables. With a wide range of choices, the Saffola Masala Oats come with the choicest of masalas. Easy to Make, High on Taste The Saffola Masala Oats can easily be made an integral part of your daily life. This healthy and delicious dish requires minimal effort for preparation and is ready in just 3 minutes.",
        186,
        "https://rukminim1.flixcart.com/image/832/832/jim0x3k0/cereal-flake/2/2/g/500-peppy-tomato-masala-oats-pouch-saffola-original-imaf6dmfzzstzfk7.jpeg?q=70",
        2, BreakfastCereals);
    BreakfastCerealsArray[3] = new Product("Quaker Whole Oats  (700 g, Plastic Bottle)",
        "With Quaker Whole Oats, you can eat healthy without compromising on taste. These oats feature a larger grain size to give you better taste and texture. This way, your entire family can enjoy a bowl of healthy breakfast porridge. These oats are a natural source of dietary fibre, protein, and carbohydrates. As you regularly consume these oats, you can minimise cholesterol and high blood pressure.",
        160,
        "https://rukminim1.flixcart.com/image/832/832/jsaocy80/cereal-flake/d/g/x/700-whole-oats-plastic-bottle-quaker-original-imafdwkh4yucz9he.jpeg?q=70",
        2, BreakfastCereals);
    BreakfastCerealsArray[4] = new Product("Saffola Masala Oats Mint Chutney  (39 g, Pouch)",
        "Instant doesn’t always mean unhealthy and this packet of Saffola Masala Oats is a living example. Featuring a fresh mint flavour, this packet of oats is not just delicious, but it’s easy-to-prepare as well. Quick You can prepares yourself a healthy bowl of oats in just three minutes. Nutritious Oats are known to be rich in natural fibre and protein, and they help you manage your hunger pangs better. Less Fat A study dated 31/08/07 revealed that this product contains less fat when compared to instant noodles.",
        15,
        "https://rukminim1.flixcart.com/image/832/832/jn3hocw0/cereal-flake/q/t/j/39-masala-oats-mint-chutney-pouch-saffola-original-imaf9uwfzpzatekf.jpeg?q=70",
        3, BreakfastCereals);
    BreakfastCerealsArray[5] = new Product("Bagrry's White Oats  (1 kg, Pouch)",
        "You have read it in health magazines, and also heard it from your doctor that skipping breakfast is the worst that you can do to your body. But how can you cook breakfast regularly when you have to leave for office at 7 am? It’s simple. All you have to do is keep this box of white oats from Bagrry’s in your kitchen, so you can quickly have a bowl of it every morning. Healthy and Crunchy This plastic box contains crunchy roasted oats that are rich in soluble fibres and proteins. These two nutrients supplement your daily dietary intake, without being mean to your taste buds.  Benefits Regular consumption of this breakfast cereal will show a visible difference in your cholesterol levels and weight.",
        145,
        "https://rukminim1.flixcart.com/image/832/832/jbb3wcw0/cereal-flake/u/g/m/1-white-oats-pouch-bagrry-s-original-imafypfnq7ya6fsk.jpeg?q=70",
        1, BreakfastCereals);
    BreakfastCerealsArray[6] = new Product("Saffola Classic Masala Oats  (500 g, Pouch)",
        "Tailored specifically for the Indian palate, Saffola Masala Oats come in a wide variety of flavours such as , Curry & Pepper Masala, Masala & Coriander Masala, Veggie Twist Masala, Chinese Flavour Masala and more. The Saffola Masala Oats is high in fibre and protein, and a quick fix for a healthy meal any time of the day. It also helps you manage your weight. 100% Natural Ingredients The Saffola Masala Oats are made from 100% natural wholegrain oats along with real vegetables. With a wide range of choices, the Saffola Masala Oats come with the choicest of masalas. Easy to Make, High on Taste The Saffola Masala Oats can easily be made an integral part of your daily life. This healthy and delicious dish requires minimal effort for preparation and is ready in just 3 minutes.",
        190,
        "https://rukminim1.flixcart.com/image/832/832/jvtujrk0/cereal-flake/c/u/c/500-classic-masala-oats-pouch-saffola-original-imafgghh2z8eswxr.jpeg?q=70",
        5, BreakfastCereals);
    BreakfastCerealsArray[7] = new Product("Saffola Curry and Pepper Masala Oats  (500 g, Pouch)",
        "Tailored specifically for the Indian palate, Saffola Masala Oats come in a wide variety of flavours such as , Curry & Pepper Masala, Masala & Coriander Masala, Veggie Twist Masala, Chinese Flavour Masala and more. The Saffola Masala Oats is high in fibre and protein, and a quick fix for a healthy meal any time of the day. It also helps you manage your weight. 100% Natural Ingredients The Saffola Masala Oats are made from 100% natural wholegrain oats along with real vegetables. With a wide range of choices, the Saffola Masala Oats come with the choicest of masalas. Easy to Make, High on Taste The Saffola Masala Oats can easily be made an integral part of your daily life. This healthy and delicious dish requires minimal effort for preparation and is ready in just 3 minutes.",
        186,
        "https://rukminim1.flixcart.com/image/832/832/jvv9zm80/cereal-flake/r/n/9/500-0-curry-and-pepper-masala-oats-pouch-saffola-original-imafgghh2bez7xwx.jpeg?q=70",
        1, BreakfastCereals);
    BreakfastCerealsArray[8] = new Product("Kellogg's Real Kesar Pista Badam Corn Flakes  (280 g, Box)",
        "Kellogg's Cornflakes now made irresistible with Real Kesar, Pistachios and almonds. Milk with kesar, pistachios and almonds is a match made in heaven! We got our local chefs to put together a delightful combination of Kellogg's Cornflakes with Real Kesar, Pista and Almonds. Enjoy it with warm or cold milk and energize your busy mornings with a great tasting food.",
        150,
        "https://rukminim1.flixcart.com/image/832/832/jrp8r680/cereal-flake/x/y/v/280-cornflakes-real-kesar-pista-badaam-flavor-pouch-kellogg-s-original-imafcg6mrthyfrys.jpeg?q=70",
        5, BreakfastCereals);
    BreakfastCerealsArray[9] = new Product("Bagrry's Choco Plus  (1.2 kg, Pouch)",
        "Bagrry’s Delicious Chocolaty and Super Crunchy Choco  is made from the Goodness of 3 Great Grains – Whole Wheat, Oats and Rice. With 0% Maida, this yummy cereal is a perfect for making your morning Happy and Healthy",
        416,
        "https://rukminim1.flixcart.com/image/832/832/jhz5vgw0/cereal-flake/f/k/u/1200-choco-1-2-kg-pouch-pouch-bagrry-s-original-imaf5vgrtf4hc724.jpeg?q=70",
        2, BreakfastCereals);
    BreakfastCerealsArray[10] = new Product("Saffola Chinese Masala Oats  (38 g, Pouch)",
        "Made from 100% natural ingredients and infused with appetizing flavor, the Saffola Masala Oats is not just tasty, but it’s also healthy for your body. It makes for a quick breakfast cereal as you can prepare it in just 3 minutes. Tangy Taste With special ingredients, like juicy corn, crunchy beans, and capsicum, this cereal has a spicy and tangy taste to it with a blend of an authentic Chinese flavor. Quick and Easy ‘No time for breakfast.’ - this is an excuse of the past. This pouch of oats will be ready in just 3 minutes, making it your ideal breakfast and evening meal. High in Fibre and Protein It’s high on fiber and protein, keeping you full and controlling your hunger pangs for a long duration. Stay in Shape By keeping you full for a long duration, it keeps a check on your food consumption and thereby maintains your body weight. It also has 70% lesser fat than instant noodles, which makes it a healthy alternative.",
        18,
        "https://rukminim1.flixcart.com/image/832/832/jay8xow0/cereal-flake/s/c/h/39-masala-oats-chinese-pouch-saffola-original-imafyer2gjfxzthh.jpeg?q=70",
        1, BreakfastCereals);
    BreakfastCerealsArray[11] = new Product("Kellogg's Real Thandai Badam Corn Flakes  (280 g, Box)",
        "Kellogg's Cornflakes nowmade irresistible with real almonds and thandai flavour. Don't we all remember the first time we had a glass of chilled thandai? And so, we got the local chefs to put together a delightful combination of Kellogg's Cornflakes with Real Thandai and almonds. Enjoy it with cold milk and add some great taste to energize your busy mornings.",
        150,
        "https://rukminim1.flixcart.com/image/832/832/jrp8r680/cereal-flake/t/t/x/280-cornflakes-real-thandai-badaam-flavor-pouch-kellogg-s-original-imafdg2fchkthzgg.jpeg?q=70",
        4, BreakfastCereals);

    CookingSaucesAndVinegarArray[0] = new Product("Ching's Secret Chilli Vinegar  (170 ml)",
        "Drizzle a few drops of Ching's Secret chilli vinegar sauce to make your dish mouth-watering. This sauce enhances the flavour by combining its vivid green Jwala chilli with your food.       Desi Chinese Zing The Ching's Secret chilli vinegar sauce will give your favourite dish the delicious edge that it needs and tingle your taste buds.   Versatile Sauce An ideal dining table companion, this sauce has a sharp vinegar heat that will complement various dishes.",
        38,
        "https://rukminim1.flixcart.com/image/832/832/jsdj8nk0/vinegar/h/w/n/170-chilli-ching-s-secret-original-imafdyfvx8zjzyfr.jpeg?q=70",
        3, CookingSaucesAndVinegar);
    CookingSaucesAndVinegarArray[1] = new Product("Ching's Secret Green Chilli Sauce  (190 g)",
        "Relish your favourite snack by eating it with the Ching's secret green chilli Sauce. The desi Chinese taste of this sauce will leave you wanting more.  Desi Chinese Zing The Ching's Secret green chilli sauce will give your dishes a delicious buzz with its Jwala green chillies, tangy vinegar, and spices.   Versatile Sauce This versatile dining table companion can make your fried rice and noodles a lot tastier. ",
        42,
        "https://rukminim1.flixcart.com/image/832/832/jsdj8nk0/sauce-ketchup/f/t/h/190-green-chilli-glass-bottle-sauce-ching-s-secret-original-imafdyfurkt34nhh.jpeg?q=70",
        4, CookingSaucesAndVinegar);
    CookingSaucesAndVinegarArray[2] = new Product("Ching's Secret Schezwan Sauce  (250 g)",
        "Eat chicken lollipops, spring rolls, and wontons with the yummy Ching's Secret schezwan sauce. This sauce enhances the flavour of your favourite snacks and dishes with its delectable fusion.   Intense Heat and Aroma The Ching's Secret schezwan sauce is ideal for making schezwan fried rice or Chowmein or even schezwan baby corn.   Versatile Sauce This sauce is a mouth-watering fusion of colour, heat, and aroma with its blend of fiery red chillies, ginger-garlic Sichuan peppercorns and desi Chinese masalas.",
        63,
        "https://rukminim1.flixcart.com/image/832/832/jsdj8nk0/sauce-ketchup/u/f/v/250-schezwan-glass-bottle-sauce-ching-s-secret-original-imafdyfvp98hh2jg.jpeg?q=70",
        2, CookingSaucesAndVinegar);
    CookingSaucesAndVinegarArray[3] = new Product("Ching's Secret Dark Soy Sauce  (210 g)",
        "Make your meals a lot more fun and yummy with the Ching's Secret dark soy sauce. This sauce enhances the taste of your favourite dishes with its delectable flavour. Intriguing Flavours The intense umami flavour of the rich Ching's Secret dark soy sauce is sure to leave you wanting more.  Dip or a Marinade  This versatile sauce can be used as a dip or in a marinade or even in stir-fried rice and Chowmein.",
        42,
        "https://rukminim1.flixcart.com/image/832/832/jsdj8nk0/sauce-ketchup/h/9/b/210-dark-soy-glass-bottle-sauce-ching-s-secret-original-imafdyfuzsgfmjc4.jpeg?q=70",
        5, CookingSaucesAndVinegar);

    CreamsLotionsSkinCareArray[0] = new Product("Beardo Ultraglow All In 1 Lotion  (100 g)",
        "BEARDO Ultraglow All in 1 Men's Face Lotion - 100g , This Special Formula is enriched with Natural and Ayurvedic Herbs which provides protection and moisturising of the skin.This formula for men has an effective sun screen of SPF30 that blocks UVA/UVB rays and prevents premature ageing of skin.This formula not only reduces dark spots and whitens the skin it also controls oil production,firms and improves elasticity of skin giving the skin a healthy radiant look.",
        225,
        "https://rukminim1.flixcart.com/image/832/832/j77xjm80-1/moisturizer-cream/m/c/x/100-ultraglow-all-in-1-men-s-face-lotion-beardo-original-imaexgbrbgq5gbep.jpeg?q=70",
        4, CreamsLotionsSkinCare);
    CreamsLotionsSkinCareArray[1] = new Product("Nivea Body Milk Nourishing Lotion  (400 ml)",
        "Radiant, creamy, and smooth - your skin will get a fresh lease of life with the Nivea Body Milk Nourishing Lotion. It has a creamy formula with Hydra IQ and Almond Oil to give you well-nourished, soft skin. Long-lasting Hydration Get hydrated and smooth skin, thanks to the Hydra IQ formula of this lotion. Repairs Skin This lotion contains almond oil which effectively repairs dry skin.",
        303,
        "https://rukminim1.flixcart.com/image/832/832/jf2uqa80/moisturizer-cream/h/s/2/200-body-milk-nourishing-lotion-nivea-original-imaf3mng2z88kuhf.jpeg?q=70",
        2, CreamsLotionsSkinCare);
    CreamsLotionsSkinCareArray[2] = new Product("Nivea Shine Caring Lip Balm Strawberry  (Pack of: 1, 4.8 g)",
        "Let your lips look beautiful, with a hint of colour and the pleasant fragrance of strawberries by wearing the NIVEA Strawberry Shine lip balm. Greet Everyone with Soft and Smooth Lips This lip balm provides enough moisturization for your lips, thereby making them soft and smooth. Delightful Aroma of Strawberry This lip balm will leave your lips looking pleasant, alongside a slight aroma of strawberries.",
        159,
        "https://rukminim1.flixcart.com/image/832/832/jf2uqa80/lip-balm/k/p/j/4-8-shine-caring-lip-balm-nivea-original-imaf3mngq8xqxuv6.jpeg?q=70",
        4, CreamsLotionsSkinCare);
    CreamsLotionsSkinCareArray[3] = new Product("Nivea Whitening Cool Sensation Body Lotion  (400 ml)",
        "Bring dull and lifeless skin back to its healthy and radiant condition with this Nivea Whitening Body Lotion. Gives Even-toned Skin Enriched with the goodness of camu camu and menthol, this body lotion gives you even-toned skin and keeps you feeling refreshed for hours. Sun Protection It contains SPF 15 to keep your skin protected from the harmful rays of the sun. Light Formula Hate the greasy feeling? This body lotion has a light formula which quickly absorbs into your skin and leaves it feeling soft and moisturized without being too oily or greasy.",
        347,
        "https://rukminim1.flixcart.com/image/832/832/jtbtt3k0/moisturizer-cream/n/b/g/400-whitening-cool-sensation-body-lotion-nivea-lotion-original-imafeph8mtfhjsaj.jpeg?q=70",
        4, CreamsLotionsSkinCare);
    CreamsLotionsSkinCareArray[4] = new Product("Lakme Sun Expert Fairness UV Sunscreen Lotion - SPF 24 PA++  (60 ml)",
        "With the Lakme Sun Expert Fairness plus UV Lotion, you no longer have to hide under a hat or an umbrella. It shields your skin from harmful sun rays. Thanks to its broad spectrum UV protection, it is ideal for hot Indian weathers and you can get lighter and radiant skin. SPF Say goodbye to tan lines as this lotion comes with SPF 24 PA + to protect your sensitive skin from harmful UV rays. Radiant and Healthy Glow It is infused with lemongrass and cucumber extracts to give your skin that radiant and healthy glow. It also gives a cooling effect. All-through the Year Its texture is light enough to be used everyday, and not just during summers. Regular usage will help give you visibly fairer and even-toned skin. Specially Formulated It is specially formulated to prevent sunburns, premature aging and dark spots.",
        179,
        "https://rukminim1.flixcart.com/image/832/832/jesunbk0/sunscreen/8/g/2/60-sun-expert-fairness-uv-sunscreen-lotion-24-lakme-original-imaewnajh2dzzkbb.jpeg?q=70",
        5, CreamsLotionsSkinCare);
    CreamsLotionsSkinCareArray[5] = new Product("Nivea Rose and Argan Oil in Lotion  (400 ml)",
        "Nivea brings the goodness of premium natural oils in a fast absorbing lotion with sensual fragrances.", 390,
        "https://rukminim1.flixcart.com/image/832/832/jtbtt3k0/moisturizer-cream/m/w/z/400-rose-and-argan-oil-in-lotion-nivea-lotion-original-imafeph8hfbhmyhg.jpeg?q=70",
        5, CreamsLotionsSkinCare);
    CreamsLotionsSkinCareArray[6] = new Product("Nivea Extra Whitening Cell Repair SPF 15 Body Lotion  (400 ml)",
        "Dermatologically tested as safe for use on the skin, and free of alcohol content, this NIVEA Extra Whitening Cell Repair Body Lotion knows exactly what your skin needs during humid, summer days. It intensely moisturises your skin without leaving a heavy film of grease on it. Evens Your Skin Tone Lightweight in texture, this non-greasy formula offers itself as the perfect summer body lotion. It absorbs readily into the skin and works to repair cells, to give you even-toned skin in just 14 days. SPF Protection Enriched with an SPF 15 formulation, this lotion protects your skin from damage brought on by exposure to sunlight. Smooths Skin Vitamin C extracts in this lotion repair damaged skin and tackle dullness so your skin looks visibly smooth and nourished.",
        331,
        "https://rukminim1.flixcart.com/image/832/832/jtbtt3k0/moisturizer-cream/w/z/4/400-extra-whitening-cell-repair-spf-15-body-lotion-nivea-lotion-original-imafeph85egp3ngh.jpeg?q=70",
        3, CreamsLotionsSkinCare);
    CreamsLotionsSkinCareArray[7] = new Product(
        "Bio-Oil Specialist Skin Care Oil - Scars, Stretch Mark, Ageing, Uneven Skin Tone  (60 ml)",
        "Say goodbye to stretch marks, uneven skin tone, and dehydrated skin with the Bio-Oil Specialist Skin Care Oil. Nourishment of Essential Oils Infused with the goodness of PurCellin Oil, Calendula Oil, Lavender Oil, Rosemary Oil, Chamomile Oil, and Vitamin A and E, this miracle oil gets rid of stretch marks that occur due to pregnancy or teenage growth spurts and keeps the skin hydrated. For All Skin Types This oil is suitable for all skin types and its also non-comedogenic which means it does not cause reactions like acne or breakouts. It does not leave any residue and your skin absorbs it in no time due to its light and non-sticky consistency.",
        405,
        "https://rukminim1.flixcart.com/image/832/832/juu4jgw0/bath-essential-oil/w/2/b/60-specialist-skincare-bio-oil-original-imaffvhphm7pgmvf.jpeg?q=70",
        5, CreamsLotionsSkinCare);
    CreamsLotionsSkinCareArray[8] = new Product(
        "Olay White Radiance Advanced Fairness Brightening Intensive Cream SPF 24  (20 g)",
        "The Olay Story A brainchild of a chemist, Olay was born out of love and was Graham Wulff’s gift to his doting wife. Graham wanted to create a new beauty product that would leave his wife’s skin nourished and moisturised without leaving a greasy feel. Graham and Dinah started an extensive research and finally created the legendary Oil of Olay Beauty Fluid. Today, Olay is a well-known and trusted brand that promises the dainty ladies healthy and beautiful skin. Olay delivers products that are safe for its customers by ensuring that each product manufactured undergoes a thorough quality test. Celebrate beauty and pamper your skin with Olay. Olay White Radiance Advanced Whitening Brightening Intensive Cream Moisturiser SPF 24 PA + Pamper your skin with the pure moisturisation and nourishment offered by this White Radiance Advanced Whitening Brightening Intensive Cream Moisturiser from Olay.  Claims Formulated with an SPF 24 PA +, this cream moisturiser protects your skin from harmful effects of UVA and UVB rays. In addition, this cream is enhanced with celLucent whitening active and Vitamin B3 that penetrate into the sub-layers of the epidermis and works at cellular level to give your skin a natural and luminous fairness.  Features and Benefits From the very first use of this moisturiser, your skin looks brighter while the appearance of dark spots and uneven tone is visibly reduced. Directions Apply a small amount of this cream onto your cleansed face and neck. Apply it twice a day.  Warnings When applying this cream, make sure you avoid contact with eyes. Wash your eyes thoroughly with plenty of water if the product gets into your eyes. If there is any skin or eye irritation, discontinue the use. Keep out of reach of children.  Ingredients The active formula of this Olay White Radiance Advanced Whitening Brightening Intensive Cream Moisturiser is a composition of water, glycerin, ethylexyl salicylate, niacinamide, isopropyl isostearate, dimethicone, polyacrylamide, octocrylene, polyethylene, cetyl alcohol and other ingredients.",
        375,
        "https://rukminim1.flixcart.com/image/832/832/jg2kqkw0/moisturizer-cream/r/h/y/20-white-radiance-advanced-whitening-fairness-protective-skin-original-imaf4ec2fhxr8c4x.jpeg?q=70",
        2, CreamsLotionsSkinCare);
    CreamsLotionsSkinCareArray[9] = new Product("Maybelline New York Baby Lips Lip Balm Pink Lolita  (Pack of: 1, 4 g)",
        "Be the lover that sings sweet songs to a loved one, love the lips that speak sweet words more so you are always happy and spreading smiles around. The Maybelline Baby Lips Pink Lolita is crafted with the sweetest pink note to give your lips the shade of sweet romance so your life never misses the spark you need to keep going on. Forget the damaged skin on your lips and leave behind those days of worry when you needed to run from any intimate situation because this Maybelline implement will keep your lips in complete tender care so you flaunt the pinkest lips and speak the words of love. The Pink Lolita will caress your lips with a blanket of moist protection so you can never suffer from dry skin and chapped lips. No matter what weather may come and go, your smile and confidence will stay put so you impress with every action and every word. Hydrating every layer of the skin on your lips, this lip balm will keep your lips soft and luscious so you receive compliments for gorgeous looking lips. Infused with SPF 16 and ideal for men and women, this lip balm will not only help in moisturization but also protection.",
        175,
        "https://rukminim1.flixcart.com/image/832/832/jxf05u80/lip-balm/z/8/p/4-new-york-baby-lips-lip-balm-maybelline-original-imafhgmfughysn4h.jpeg?q=70",
        4, CreamsLotionsSkinCare);
    CreamsLotionsSkinCareArray[10] = new Product("Biotique Bio Wheat Germ Nourishing Night Cream  (50 g)",
        "Indulge your skin with the royal treatment as you catch up on your sleep at the end of each day, with this Biotique Bio Wheat Germ Nourishing Night Cream. It contains ingredients such as wheatgerm which hydrates dry skin, almond which prevents premature ageing, and sunflower seeds which promote the overall vitality of the skin to keep it young and supple.",
        218,
        "https://rukminim1.flixcart.com/image/832/832/jq2np8w0/anti-ageing/2/p/p/50-bio-wheat-germ-nourishing-night-cream-biotique-original-imafc64fxzrhcw3g.jpeg?q=70",
        4, CreamsLotionsSkinCare);
    CreamsLotionsSkinCareArray[11] = new Product("Neutrogena Deep Clean Blackhead Scrub  (100 g)",
        "Neutrogena presents this Deep Clean Blackhead Scrub to let you enjoy the new sensory and invigorating experience of cleansing. Helps Eliminate Blackheads for Clearer, Smoother Skin The Neutrogena Deep Clean Blackhead Scrub makes sure that the appearance of blackheads is completely prevented to give clearer, smoother skin. Eliminate Blackheads by Removing Stubborn Dirt and Oil Trapped inside Pores The infusion of Beta Hydroxy acid, also known as salicylic acid, in this scrub acts as a topical exfoliant that clears out blackheads by penetrating deep inside the pores and removing stubborn dirt and oil. Exfoliate without Over Drying Ideal for use on all skin types, the Deep Clean Blackhead Scrub gently exfoliates and cleanses your skin without over drying.",
        299,
        "https://rukminim1.flixcart.com/image/832/832/jk76j680/scrub/s/q/h/100-deep-clean-blackhead-neutrogena-original-imaf7hk6utmhvn3c.jpeg?q=70",
        4, CreamsLotionsSkinCare);

    DairyArray[0] = new Product("Nestle A Plus Slim Milk",
        "The Nestle A Plus Slim Milk pack features the goodness of milk but with 95% less fat when compared to cow or buffalo milk. If you plan on starting a low-fat diet, then this UHT-treated skimmed milk, which includes Calcium and Protein, is an ideal choice to help meet your fitness goal. Low-fat Milk For those aiming to lose weight and get fit, Nestle A Plus Slim Milk is a blessing as it contains less fat and a lot of essential nutrients. Easy to Consume It undergoes 61 stringent quality checks for adulterants, aflatoxin and antibiotics, and can be consumed directly from the carton without having to boil it.",
        80,
        "https://rukminim1.flixcart.com/image/832/832/jsaocy80/milk/b/m/q/1-tetrapack-skimmed-nestle-original-imafdwgjhutwn9rt.jpeg?q=70",
        4, Dairy);
    DairyArray[1] = new Product("Nestle A Plus Nourish Toned Milk",
        "Packed in a 6-layer protection packaging, this Nestle A Plus Nourish Toned Milk provides your body with the calcium and protein content it needs to stay strong and healthy. Just two glasses of this milk a day helps meet at least 2 or 3 of your recommended daily portions of dairy products. Provides the Nutritional Content of Real Cow’s Milk Sourced from healthy cows, this tetra-pack of milk provides your body with calcium and protein. This milk is put under 61 stringent quality checks to ensure the absence of adulterants, aflatoxins, and antibiotics. The Flash Heat Treatment that it is put through ensures that this milk retains its nutritional content and is germ-free.",
        79,
        "https://rukminim1.flixcart.com/image/832/832/jsaocy80/milk/k/n/b/1-tetrapack-toned-nestle-original-imafdwgjfbafhqze.jpeg?q=70",
        4, Dairy);
    DairyArray[2] = new Product("dlecta Dlecta Premium Milk  (1 L)",
        "Toned Milk 3% Fat. UHT sterilized for long shelf life. 100% free from Adulteration. Cow milk has Betacarotene (precursor of Vitamin A) which is good for eyes. No added preservatives. Can consume directly from pack. No need to boil. Suitable for all round use.",
        63,
        "https://rukminim1.flixcart.com/image/832/832/jmnrtzk0-1/milk/z/w/t/1-tetrapack-toned-dlecta-original-imaf9fhgkzg3uqk6.jpeg?q=70",
        4, Dairy);
    DairyArray[3] = new Product("Nescafe  (Hazelnut)",
        "Indulge in some tasty and delicious cold coffee with the Nescafe chilled Latte, Ready-to-drink cold coffee. This aromatic coffee will leave you feeling energized and refreshed wherever you are. Creamy and Milky Coffee This Nescafe chilled Latte, ready-to-drink cold coffee is creamy, milky, and light. If you’re one of those people who loves thick coffee, you’ll want to keep drinking more of this chilled coffee. Anytime Drink This drink will give you an instant energy boost at any time of the day with its rich and mellow flavour.",
        35,
        "https://rukminim1.flixcart.com/image/832/832/jsaocy80/milk/h/z/8/180-flavored-nescafe-original-imafdwgjgbqf97wz.jpeg?q=70",
        4, Dairy);
    DairyArray[4] = new Product("Nescafe Intense Cafe  (Cappuccino)",
        "Indulge in some tasty and delicious cold coffee with the Nescafe chilled latte, ready-to-drink cold coffee. This aromatic coffee will leave you feeling energized and refreshed wherever you are.  Creamy and Milky Coffee This Nescafe chilled latte, ready-to-drink cold coffee is creamy, milky, and light. If you’re one of those people who loves thick coffee, you’ll want to keep drinking more of this. Anytime Drink This drink will give you an instant energy boost at any time of the day with its rich and mellow flavour.  ",
        35,
        "https://rukminim1.flixcart.com/image/832/832/jsaocy80/milk/p/y/z/180-tetrapack-flavored-nescafe-original-imafdwgjppkgdghy.jpeg?q=70",
        1, Dairy);
    DairyArray[5] = new Product("Nestle Everyday Dairy Whitener Milk Powder  (1 kg)",
        "Make your beverage delicious and thick with the Nestle Everyday Dairy Whitener Milk Powder. This milk powder will uplift the taste of your drink and make it tastier.   Uplifts the Taste The Nestle Everyday Dairy Whitener Milk Powder will enhance the taste of your beverage by completely mixing with it. Thick Cuppa You can enjoy a hot, thick, and tasty drink with this milk powder.",
        463,
        "https://rukminim1.flixcart.com/image/832/832/jsaocy80/milk-powder/j/w/q/1-dairy-whitener-nestle-everyday-original-imafdwgkuenzsntt.jpeg?q=70",
        3, Dairy);

    DeosPerfumesAndTalcArray[0] = new Product("Cinthol Dive Deodorant Spray - For Men  (150 ml)",
        "Made for the men of today, this deodorant from Cinthol will make your gloomy and dull day interesting and refreshing. The fragrant smell of this deodorant will keep you going throughout the day and will ensure you look and smell fresh. Fresh and Cool Aqua This deodorant spray will awaken and rejuvenate your senses with its strong and fresh aroma. Skin-Friendly This deodorant is alcohol-free and protects your skin from damage and irritation apart from helping you smell presentable. Long-Lasting All you will need is just a whiff of this spray to smell fresh. The freshness of the aroma will linger around you all day long.",
        144,
        "https://rukminim1.flixcart.com/image/832/832/juk4gi80/deodorant/x/w/b/150-dive-deodorant-spray-cinthol-men-original-imaffnk4b8h4p2sa.jpeg?q=70",
        2, DeosPerfumesAndTalc);
    DeosPerfumesAndTalcArray[1] = new Product("Nivea Musk Talc  (400 g)",
        "Feel fresh throughout the day with this Musk Talc from Nivea and fall in love with your skin all over again. For all those men and women longing for that gentle fragrance, this Musk Talc will be their apt choice. The Nivea Musk Talc is perfect for summer when you are all set to go and play your favourite outdoor game. You are sure to get that soft and supple skin with this Nivea Talc. Also, this talcum powder will protect your body against bad odour and will absorb the moisture from your skin. For all those sport lovers, a talcum powder is a must since it would keep them away from bad body odour. Summers can be extremely uncomfortable, when you feel hot and sticky you can apply this Pure Talc and comfort yourself. Additionally, this Talc can be applied at night to give you that comfortable sleep during those humid days and you are sure to get that pleasant body odour. You can bid farewell to your skin irritation like rashes and chafing with this Musk Talc. Besides giving you that smooth skin, this Nivea Talc will keep your skin clean and fresh. After your fun bike ride, take a soothing shower and apply this talcum powder on your body and get that beautiful skin. Directions for Use Gently apply this talc on your body.",
        156,
        "https://rukminim1.flixcart.com/image/832/832/jtbtt3k0/talc/z/x/r/400-musk-talc-nivea-original-imafeph9ajyyrjd8.jpeg?q=70",
        5, DeosPerfumesAndTalc);
    DeosPerfumesAndTalcArray[2] = new Product("Engage Spray W3 Perfume - 120 ml  (For Women)",
        "Engage presents these perfume sprays for the modern woman who is confident and classy. The fragrances will leave you feeling fresh and smelling beautiful all day. Engage Women W3 Perfume Spray is a casual and breezy fragrance with sparkling fruity-floral scent with clean and crisp elements of apple and lime that evoke the spirit of the Sicilian summer.",
        160,
        "https://rukminim1.flixcart.com/image/832/832/jvfk58w0/perfume/v/t/y/120-spray-w3-perfume-engage-women-original-imaf9x2e72bughbq.jpeg?q=70",
        4, DeosPerfumesAndTalc);
    DeosPerfumesAndTalcArray[3] = new Product("AXE Signature Intense Body Body Spray - For Men  (122 ml)",
        "The World's # 1 Male Deodorant Axe, presents Axe Signature' - a range of premium body perfumes with 0% gas. Designed by the world's leading perfumers, Axe Signature body perfumes are concentrated with 3X more perfume. These body perfumes are not only stronger, they also last longer, helping you make an unforgettable impression when it matters the most. Feel fresh and energetic all day long with Axe Signature Sport body perfume. A dynamic fusion of fruity fragrance notes against a woody base gives a super strong and long-lasting effect. The blend of citrus and woody notes creates a fragrance that is a perfect fit for the go-getter, who is always on the run. The dynamic aroma of this sporty, modern perfume ensures you stay cool and energised for up to 24 hours giving you long-lasting, all-day freshness.Complete your morning preparation with the unforgettable fragrance of Axe Signature Sport Body Perfume. Simply spray it directly on your skin, underarms, chest and neck. Add that extra twist to your style. Like you've got something different from the rest, helping you make an impression that lingers on. Don't fade away like the rest. Catch attention and arouse curiosity in the moments that count. Leave your signature with the Axe Signature range of body perfumes.",
        182,
        "https://rukminim1.flixcart.com/image/832/832/jhkvgy80/deodorant/t/s/m/122-signature-intense-perfume-axe-men-original-imaf5kmhruqgfw7g.jpeg?q=70",
        1, DeosPerfumesAndTalc);
    DeosPerfumesAndTalcArray[4] = new Product(
        "Nivea Fresh Petal & Care Female Deodorizer Deodorant Spray - For Women  (120 ml)",
        "Get day long odour-control and confidence with the Nivea Fresh Petal & Care Deodorizer. Its unique deodorizing formula and refreshing jasmine scent give you day long odour control, with just one use. Its skin-friendly formula with Provitamin B5 gives you nourished and hydrated skin. Odour Protection Its unique deodorizing formula makes sure that a single use of this deodorant is enough to give day-long odour control. Long-lasting Freshness Its sensuous Jasmine scent makes you feel fresh throughout the day. Care For Your Underarms It contains Provitamin B5 which gives your skin the required nourishment and hydration.",
        200,
        "https://rukminim1.flixcart.com/image/832/832/jtbtt3k0/deodorant/x/d/j/120-fresh-petal-care-female-deodorizer-deodorant-spray-nivea-original-imafeph7tzgeug85.jpeg?q=70",
        4, DeosPerfumesAndTalc);
    DeosPerfumesAndTalcArray[5] = new Product("Wild Stone Ultra Sensual Deodorant Spray - For Men  (150 ml)",
        "Infused with a captivating and masculine fragrance, the Ultra Sensual Deodorant Spray from Wild Stone encapsulates your energetic personality and awakens your senses. Irresistible Masculine Fragrance When sprayed, this Ultra Sensual Deodorant releases an irresistible masculine fragrance that unveils the modern man’s enticing appeal. Aromatic Lavender Fragrance Complement your masculine personality with a spritz of this aromatic lavender fragrance and make a lasting impression.",
        179,
        "https://rukminim1.flixcart.com/image/832/832/k1tm1e80/deodorant/h/d/s/150-ultra-sensual-deodorant-150ml-body-spray-wild-stone-men-original-imafhb24u7yzafx2.jpeg?q=70",
        3, DeosPerfumesAndTalc);
    DeosPerfumesAndTalcArray[6] = new Product("Cinthol Cool Talc  (100 g)",
        "Wait a minute. You are looking cool and attractive but what you need before you head out the door and enjoy your day of fun is a dab of this cool talc from Cinthol to keep you looking and feeling fresh all day. A Light Blue Bottle This talc is available in a light blue bottle that looks very pleasant on your bathroom shelf. It is also very light and easy to carry in an overnight bag when you stay away on a weekend. Cooling Aqua Fragrance The talc gives out a pleasant aqua fragrance and also keeps you feeling cool after your bath.",
        55,
        "https://rukminim1.flixcart.com/image/832/832/juk4gi80/talc/y/e/w/100-cool-talc-cinthol-original-imaffnk5fkhemsfg.jpeg?q=70",
        2, DeosPerfumesAndTalc);
    DeosPerfumesAndTalcArray[7] = new Product("Nivea Pure Talc  (400 g)",
        "Take your personal care to the next level by using a good talcum powder. Using a good talcum powder can make a big difference to your body odour and will also make you feel fresh. A lot of your skin issues will be solved by using this Pure Talc from Nivea. For all those men and women longing for that beautiful fragrance on their body, this Pure Talc will be their apt choice. The Nivea Pure Talc will comfort you during summers and will help you get rid of your sweat. Also, this Talcum Powder will reduce the problem of rashes and chafing on your skin. Most athletes use a powder before they wear their sports suit and this will help them reduce discomfort and bad body odour. Besides absorbing the moisture from your skin, this Nivea Talc will leave your skin soft and smooth. Summers can be extremely uncomfortable, when you feel hot and sticky you can apply this Pure Talc and comfort yourself. Additionally, this Talc can be applied at night to give you that comfortable sleep during those humid days and you are sure to get that pleasant body odour. You are sure to feel refreshed throughout the day with this Talcum Powder. After you get back from your morning workout take a soothing shower and apply this Nivea Talcum Powder and you are sure to fall in love with your skin all over again. You can now get that beautiful skin with this talcum powder. Directions for Use Gently apply this talcum powder on your body.",
        156,
        "https://rukminim1.flixcart.com/image/832/832/jtbtt3k0/talc/w/g/u/400-pure-talc-nivea-original-imafeph9fyvhsz8j.jpeg?q=70",
        2, DeosPerfumesAndTalc);
    DeosPerfumesAndTalcArray[8] = new Product("Nivea Pearl & Beauty Deodorant Spray - For Men & Women  (150 ml)",
        "Nivea Anti-Perspirant Deodorant Pearl & Beauty 150ml offers protection and gentle care for up to 48 hours, leaving you with smooth and beautiful looking underarms. It has 0% alcohol and comes with pearl extract.",
        195,
        "https://rukminim1.flixcart.com/image/832/832/jf2uqa80/deodorant/8/5/z/150-pearl-beauty-deodorant-spray-nivea-men-women-original-imaf3mnetdkrkm9t.jpeg?q=70",
        3, DeosPerfumesAndTalc);
    DeosPerfumesAndTalcArray[9] = new Product("Nivea Protect & Care Deodorant Roll-on - For Women  (50 ml)",
        "Enjoy the joy of feeling fresh with this NIVEA Protect & Care Roll On. It lasts for up to 48 hours keeping you fresh throughout the day. NIVEA Creme This roll-on deodorant contains ingredients of NIVEA Creme that give a mild, soothing fragrance and keep you fresh all day long. Gentle and Reliable Care This  Protect & Care roll-on from NIVEA pampers your underarms as it has a 0% alcohol formula combines NIVEA’s gentle care and reliable protection. It has also been dermatologically tested to ensure it is gentle on your skin. Odour Protection This roll-on contains anti-microbial agents that keep bacteria away giving you odour protection that lasts for up to 48 hours.",
        166,
        "https://rukminim1.flixcart.com/image/832/832/j13vqfk0/deodorant/w/k/2/50-protect-and-care-deodorant-roll-on-nivea-original-imaesrgpvqcyxhzy.jpeg?q=70",
        5, DeosPerfumesAndTalc);
    DeosPerfumesAndTalcArray[10] = new Product(
        "Nivea Men Fresh Active long lasting freshness Deodorant Spray - For Men  (150 ml)",
        "The heat won’t be able to bring you down, thanks to this NIVEA deodorant for men. Formulated with refreshing tones of ocean extracts, you’ll feel fresh and active all summer long. You can also hit the beach or party with your friends whenever you want as this deodorant makes you confident and also keeps you free of body odour. Long-lasting Freshness With this deodorant, you’ll feel manly, fresh, and energetic for a long time. Goodbye Body Odour Equipped with antibacterial actives, this deodorant will not let body odour get the best of you. Cares for Your Underarms This product contains the NIVEA Men Care Complex to take proper care of your underarm skin.",
        179,
        "https://rukminim1.flixcart.com/image/832/832/jtbtt3k0/deodorant/f/q/u/150-fresh-active-original-body-spray-nivea-men-men-original-imafeph73yywggnh.jpeg?q=70",
        5, DeosPerfumesAndTalc);
    DeosPerfumesAndTalcArray[11] = new Product("Wild Stone Ultra Sensual Deo Talc  (300 g)",
        "Jumpstart the lousy looking week ahead on a refreshing, revitalizing new note. After all, a great frame of mind that induces positivity allows you to go ahead and seize the day. Be it the big business presentation at the workplace or before heading to college where a long day awaits you and you cannot afford to not be on your feet constantly. So after that quick morning shower, sprinkle the Wild Stone Ultra Sensual Deo Talc generously over your upper torso. Leave behind a lingering trail of ultra masculine fragrance, everywhere you go and make some heads turn. Packed with the goodness of a deodorant and talcum powder, this Ultra Sensual Deo Talc gives you the dual function of a sporty fragrance in addition to the absorbent property only a talcum powder can provide. Kiss unpleasant body odour goodbye, for good. Sail past those endlessly long days in the sun without constantly getting embarrassed by sweat spots around the armpits or across the breadth of your back. The ladies love a well-groomed man and nothing says suave like some good personal grooming. So the next time you’re drawing up a list of wardrobe essentials, you’ll do good to remember putting the Wild Stone Ultra Sensual Deo Talc somewhere in the top.",
        163,
        "https://rukminim1.flixcart.com/image/832/832/talc/p/r/f/wild-stone-300-ultra-sensual-deo-talc-original-imadjcpyzzbmktma.jpeg?q=70",
        4, DeosPerfumesAndTalc);

    DetergentsAndLaundryArray[0] = new Product("Revive Liquid Fabric Stiffener  (400 g)",
        "Make your clothes stiff, bright, and wrinkle-free easily with the help of this fabric stiffener from Revive. Its formula is suitable for all fabrics and it can dissolve in cold water. Suitable for All Fabrics This instant starch is suitable for all types of fabrics, thereby making it suitable for almost anything inside your wardrobe. What’s more, it has been formulated to dissolve even in cold water. Patch-free Stiffness This starch will ensure that your clothes remain stiff but patch-free by forming an even transparent layer on the apparel. Hello Brighter Clothes You can confidently make use of this starch to make your colourful clothes brighter.",
        124,
        "https://rukminim1.flixcart.com/image/832/832/j406vm80/fabric-stiffener/m/q/q/200-liquid-revive-original-imaevyt7aqgu2qhz.jpeg?q=70",
        2, DetergentsAndLaundry);
    DetergentsAndLaundryArray[1] = new Product("Vanish Oxy Action Stain Remover Fresh Liquid Detergent  (800 ml)",
        "For removing even the toughest stains off your clothes, use the Vanish Oxi Action Stain Remover Liquid which features active oxygen to provide improved stain removal. White clothes become whiter and coloured garments get brighter when you use this stain remover liquid. No Stain is Tough Enough Even tough stains can be removed easily with this stain remover liquid. Easy to Use This liquid can be used directly or can be diluted for both hand wash and machine wash. Add this liquid to your detergent, so that your clothes stay clean and fresh.",
        169,
        "https://rukminim1.flixcart.com/image/832/832/j3lwh3k0/laundry-detergent/g/h/c/800-oxy-action-liquid-vanish-original-imaeupfqfnwkhghd.jpeg?q=70",
        2, DetergentsAndLaundry);
    DetergentsAndLaundryArray[2] = new Product("Softouch 2x French Perfume Fabric Conditioner  (800 ml)",
        "Let every apparel that you wear smell fresh when you use this perfumed fabric conditioner from Wipro. It ensures all-day freshness for your clothes with the invigorating aroma of a French perfume. Fresh and Pleasant Smelling Clothes Say goodbye to spraying an overdose of perfume over your clothes. This fabric conditioner features a beautiful fragrance that will make your clothes smell fresh. All Day Freshness You don’t have to worry about your clothes smelling foul anytime, as this conditioner’s fragrance lasts for a really long time. Encapsulation Technology Every time your apparel comes in touch with your body, it will release a burst of fragrance, thanks to this fabric conditioner’s Encapsulation technology. Soft, Shiny, and Bacteria-free Clothes This conditioner will ensure that the clothes you wear are bacteria-free, soft, and shiny. ",
        191,
        "https://rukminim1.flixcart.com/image/832/832/jnc2bgw0/fabric-softener/n/z/p/800-2x-french-perfume-fabric-conditioner-softouch-original-imafafmhfeamhzee.jpeg?q=70",
        1, DetergentsAndLaundry);
    DetergentsAndLaundryArray[3] = new Product(
        "Safewash Gentle Wash Fresh Liquid Detergent  (Combo Pack 1  1 Free, 1 kg each)  (1000 g)",
        "Clothes that feel soft and smell great are always a pleasure to wear. Bring home this Safewash Liquid Detergent to add shine, softness and a pleasant fragrance to your clothes. It includes pH Neutral Formula to retain their softness and it untangles damaged cloth fibres to make your clothes smooth and great to wear. pH Neutral Formula The pH Neutral Formula in this liquid detergent helps in protecting the softness of your delicate woollen and other fine fabrics. Gentle Wash and Fresh Fragrance Washing clothes regularly with detergents can make your clothes lose their natural shine and make them dull and rough. However, this Safewash liquid detergent untangles the damaged cloth fibres and gives them an unbelievable shine, softness and a fresh fragrance. Prevents Shrinkage It helps in retaining the natural color of your clothes and prevents shrinkage, making them soft and comfortable to wear.",
        297,
        "https://rukminim1.flixcart.com/image/832/832/jiyvvrk0/laundry-detergent/z/e/6/1-woolens-liquid-detergent-safewash-original-imaf6n4dzeyhqgag.jpeg?q=70",
        5, DetergentsAndLaundry);
    DetergentsAndLaundryArray[4] = new Product("Softouch Ocean Breeze Fabric Conditioner  (800 ml)",
        "Boasting a German encapsulation technology, this Softouch Ocean Breeze Fabric Conditioner is formulated to keep your clothes looking as good as new even after repeated washing. Added to its anti-shrinking and anti-fading properties,this solution has a pleasant fragrance which lingers on your clothes. Offers an All-round Protection for Your Clothes Acting as an all-round champion for clothes, this conditioner prevents fabric from fading and also helps retain their shine and softness. The solution also neutralizes the damage caused by hard water and poor-quality detergents. Antibacterial Properties This neem-based solution thoroughly cleans clothes and keeps them germ-free.",
        163,
        "https://rukminim1.flixcart.com/image/832/832/jzk5xu80/fabric-softener/t/m/c/800-ocean-breeze-fabric-conditioner-softouch-original-imafjjpyftmwuvzg.jpeg?q=70",
        3, DetergentsAndLaundry);
    DetergentsAndLaundryArray[5] = new Product("Revive Instant Starch Fabric Stiffener  (400 g)",
        "Keep your sarees and shirts wrinkle-free and stiff with the help of the Revive instant starch fabric stiffener. It has been formulated to suit most fabrics. Dissolves in Cold Water You don’t have to worry about the temperature of the water at home. This starch will dissolve easily, even in cold water. For Every Fabric Cotton, silk, wool, and linen - your wardrobe might be filled with clothes made from different fabrics. This fabric stiffener is formulated to suit most fabrics. Patch-free Stiffness Your clothes will remain stiff but without any patches, as this starch forms a transparent layer on your clothes. Brighter Clothes You can utilise this starch to make your colourful clothes appear brighter.",
        125,
        "https://rukminim1.flixcart.com/image/832/832/jfikknk0/fabric-stiffener/c/z/e/400-instant-starch-revive-original-imaf2p2fajs374rf.jpeg?q=70",
        4, DetergentsAndLaundry);
    DetergentsAndLaundryArray[6] = new Product("Vanish Oxy Action Powder  (800 g)",
        "Keep your clothes looking new and stain-free with this Vanish Oxy Action Powder. Its advanced oxygen power removes even the most stubborn stain with ease. Stain Removal No matter how tough the stain is, this powder can effectively remove all types of stains from your clothes. Active Brighteners It has active brighteners that can whiten your whites and brightens your colored garments, keeping them looking as good as new for long. Active Oxygen Formula It creates a reaction between the dirt particles and surfactants in detergents to ensure better stain removal process.",
        342,
        "https://rukminim1.flixcart.com/image/832/832/jy3anbk0/laundry-detergent/u/t/g/oxy-action-powder-vanish-original-imafg92fffnztump.jpeg?q=70",
        4, DetergentsAndLaundry);
    DetergentsAndLaundryArray[7] = new Product(
        "Softouch 2x French Perfume Fabric Conditioner  (200ml Softouch Fabric Conditioner Free)  (800 ml)",
        "Let every apparel that you wear smell fresh when you use this perfumed fabric conditioner from Wipro. It ensures all-day freshness for your clothes with the invigorating aroma of a French perfume. Fresh and Pleasant Smelling Clothes Say goodbye to spraying an overdose of perfume over your clothes. This fabric conditioner features a beautiful fragrance that will make your clothes smell fresh. All Day Freshness You don’t have to worry about your clothes smelling foul anytime, as this conditioner’s fragrance lasts for a really long time. Encapsulation Technology Every time your apparel comes in touch with your body, it will release a burst of fragrance, thanks to this fabric conditioner’s Encapsulation technology. Soft, Shiny, and Bacteria-free Clothes This conditioner will ensure that the clothes you wear are bacteria-free, soft, and shiny. ",
        194,
        "https://rukminim1.flixcart.com/image/832/832/jnc2bgw0/fabric-softener/n/z/p/800-2x-french-perfume-fabric-conditioner-softouch-original-imafafmhfeamhzee.jpeg?q=70",
        2, DetergentsAndLaundry);
    DetergentsAndLaundryArray[8] = new Product("Softouch Ocean Breeze Fabric Conditioner  (7% Extra in Pack)  (800 ml)",
        "Boasting a German encapsulation technology, this Softouch Ocean Breeze Fabric Conditioner is formulated to keep your clothes looking as good as new even after repeated washing. Added to its anti-shrinking and anti-fading properties,this solution has a pleasant fragrance which lingers on your clothes. Offers an All-round Protection for Your Clothes Acting as an all-round champion for clothes, this conditioner prevents fabric from fading and also helps retain their shine and softness. The solution also neutralizes the damage caused by hard water and poor-quality detergents. Antibacterial Properties This neem-based solution thoroughly cleans clothes and keeps them germ-free.",
        178,
        "https://rukminim1.flixcart.com/image/832/832/jzk5xu80/fabric-softener/t/m/c/800-ocean-breeze-fabric-conditioner-softouch-original-imafjjpyftmwuvzg.jpeg?q=70",
        1, DetergentsAndLaundry);
    DetergentsAndLaundryArray[9] = new Product(
        "Safewash Gentle Wash Fresh Liquid Detergent  (Buy 1 Get 1 (1kg each) Free)  (1000 g)",
        "Clothes that feel soft and smell great are always a pleasure to wear. Bring home this Safewash Liquid Detergent to add shine, softness and a pleasant fragrance to your clothes. It includes pH Neutral Formula to retain their softness and it untangles damaged cloth fibres to make your clothes smooth and great to wear. pH Neutral Formula The pH Neutral Formula in this liquid detergent helps in protecting the softness of your delicate woollen and other fine fabrics. Gentle Wash and Fresh Fragrance Washing clothes regularly with detergents can make your clothes lose their natural shine and make them dull and rough. However, this Safewash liquid detergent untangles the damaged cloth fibres and gives them an unbelievable shine, softness and a fresh fragrance. Prevents Shrinkage It helps in retaining the natural color of your clothes and prevents shrinkage, making them soft and comfortable to wear.",
        255,
        "https://rukminim1.flixcart.com/image/832/832/jiyvvrk0/laundry-detergent/z/e/6/1-woolens-liquid-detergent-safewash-original-imaf6n4dzeyhqgag.jpeg?q=70",
        4, DetergentsAndLaundry);
    DetergentsAndLaundryArray[10] = new Product("Vanish Oxy Action Stain Remover Fresh Liquid Detergent  (400 ml)",
        "For removing even the toughest stains off your clothes, use the Vanish Oxi Action Stain Remover Liquid which features active oxygen to provide improved stain removal. White clothes become whiter and coloured garments get brighter when you use this stain remover liquid. No Stain is Tough Enough Even tough stains can be removed easily with this stain remover liquid. Easy to Use This liquid can be used directly or can be diluted for both hand wash and machine wash. Add this liquid to your detergent, so that your clothes stay clean and fresh.",
        96,
        "https://rukminim1.flixcart.com/image/832/832/j3lwh3k0/laundry-detergent/w/6/v/400-oxy-action-liquid-vanish-original-imaeupfqzkchktgy.jpeg?q=70",
        3, DetergentsAndLaundry);

    DiapersAndWipesArray[0] = new Product("Pampers Baby-Dry Pants Diaper - New Born  (86 Pieces)",
        "New Pampers Baby Dry Pants style diapers have 3 revolutionary Extra Absorb Channels, that help distribute wetness evenly throughout the pants diapers, so wetness doesn't collect in one place. Their Magic Gel Layer locks wetness inside and offers up to 12 hours of dryness to help your baby sleep soundly all night.",
        786,
        "https://rukminim1.flixcart.com/image/832/832/jrqo70w0/diaper/7/q/v/baby-dry-pants-diaper-new-born-86-pampers-original-imafdgpsesqvwtuu.jpeg?q=70",
        4, DiapersAndWipes);
    DiapersAndWipesArray[1] = new Product("Johnson's Skincare Wipes  (80 Pieces)",
        "Taking care of your baby’s hygiene is extremely important. Get these Johnson’s Baby Wipes to keep your little one’s skin and hydrated. Cloth wipe instead of paper These wipes are made of cloth and not paper, thus they are gentle on your child’s skin and ensure no damage is caused. Contains one of Mother Natures Moisturisers - Glyceryl Oleate - which nourishes, hydrates and protects As these wipes contain natural ingredients like glyceryl oleate which nourishes, hydrates and protects your little one’s skin thoroughly and keeps it clean too.    Hypoallergenic - soap free - alcohol free These wipes are hypoallergenic, thus reducing the risk of causing allergy. Furthermore, these wipes are soap and alcohol free ensuring no harm is caused to the baby’s skin. Wipes are extra soft with embossed SOFTWAVE fabric that help reduce friction To help reduce friction and increase chafing, these wipes are embossed with SOFTWAVE fabric which makes them extra soft and gentle on your skin. Enriched with moisturising lotion To keep your baby’s skin moistened and prevent dryness, these Johnson’s Baby Wipes are enriched with moisturising lotion.",
        218,
        "https://rukminim1.flixcart.com/image/832/832/jk4bngw0/wipe/4/h/g/skincare-wipes-80-skincare-wipes-johnson-s-original-imaf7jsy2sznuxz7.jpeg?q=70",
        3, DiapersAndWipes);
    DiapersAndWipesArray[2] = new Product("Pampers Premium Care Pants - XS  (24 Pieces)",
        "Protect your newborn baby’s precious and delicate skin with these diapers from Pampers. Made from Silky Soft Materials, these diapers will give your baby the best skin protection. They come with Three Extra Absorb Channels and have a Top Dry Layer to lock away wetness and distribute it evenly. Also, these diapers are ideal for babies weighing around 3 to 5 kg. Silky Soft The super-soft material of these diapers will keep your baby’s skin dry and comfortable. Three Extra Absorb Channels These channels help in quick absorption and in evenly distributing wetness throughout the diaper. Top Dry Layer These diapers keep the top layer dry by absorbing and locking the wetness inside. Breathable Materials The diapers have around one million micropores, so your baby’s skin can breathe easily.",
        293,
        "https://rukminim1.flixcart.com/image/832/832/jf8khow0/diaper/9/s/v/premium-care-pants-diapers-extra-small-24-pampers-original-imaf3rf2zhxxgrxp.jpeg?q=70",
        3, DiapersAndWipes);
    DiapersAndWipesArray[3] = new Product("Huggies Wonder Pants Diaper - M  (76 Pieces)",
        "Your baby spends a good part of their day in a diaper. Therefore, choosing the right diaper for their tender and delicate skin is extremely important. And this is where, we introduce our next generation product, India's 1st diaper pants with the unique Bubble-Bed technology.There are 3 areas where a diaper surrounds the baby's skin-the baby's bottom, the baby's waist, and the baby's thigh. The skin of the baby in all these areas is extremely delicate and sensitive Features: *The 3-D Bubble-BedTM in the inside layer of the diaper is super fluffy and provides cotton like softness to the baby's skin *The 3-D Bubble-BedTM ensures excellent absorption and spreads the wetness evenly-leading to outstanding dryness. *Bubble wala Huggies absorbs wetness for up to 12 hours to allow the baby a dry and comfortable sleep overnight. *The 3-D Bubble-BedTM traps waste matter like runny poo to keep the surface of the diaper unbelievably dry. *Bubble wala Huggies comes with a Cushiony Waistband, which is so soft that it helps protect the baby's waist against red marks *The super flexible waist band elastic provides the baby with a comfortable fit and adapts to the baby's movements. *These disposable diapers come with a Triple Leak-guard, an extra padding on the sides of diaper, which helps reduce leakage from the sides on to the baby's thigh & legs. *Bubble wala Huggies also has an Air-Fresh cover, which allows air and vapour to pass through, and helps protect against the occurrence of rashes. *The 3-D Bubble-BedTM in the inside layer of the diaper is super fluffy and provides cotton like softness to the baby's skin *The 3-D Bubble-BedTM ensures excellent absorption and spreads the wetness evenly-leading to outstanding dryness. *Bubble wala Huggies absorbs wetness for up to 12 hours to allow the baby a dry and comfortable sleep overnight. *The 3-D Bubble-BedTM traps waste matter like runny poo to keep the surface of the diaper unbelievably dry. *Bubble wala Huggies comes with a Cushiony Waistband, which is so soft that it helps protect the baby's waist against red marks *The super flexible waist band elastic provides the baby with a comfortable fit and adapts to the baby's movements. *These disposable diapers come with a Triple Leak-guard, an extra padding on the sides of diaper, which helps reduce leakage from the sides on to the baby's thigh & legs. *Bubble wala Huggies also has an Air-Fresh cover, which allows air and vapour to pass through, and helps protect against the occurrence of rashes.",
        944,
        "https://rukminim1.flixcart.com/image/832/832/k2rwlu80/diaper/z/w/d/wonder-pants-diaper-m-76-huggies-original-imafket4jshjqgej.jpeg?q=70",
        2, DiapersAndWipes);
    DiapersAndWipesArray[4] = new Product("Pampers Active Baby Taped Diapers - M  (62 Pieces)",
        "5 Star Skin Protection: The Best tape style diapers from Pampers, with an outer layer of cotton-like softness, this baby diaper provides intense care to your baby's sensitive skin and protects it effectively from friction rash and redness. These soft and comfort fitting diapers with stretchable sides are best for your baby's rest and playtime. The diaper's fastening tape sticks multiple times thus ensuring it stays in place even after you fasten it after checking your baby's diaper. Protection and nourishment of your baby's skin are taken care of with extracts of moisturising Aloe Vera lotion, characteristic of these best baby diapers.. These diapers are ultra-thin, thanks to the absorbent gel material (AGM), commonly known as Magic Gel. This magic gel core of Pampers diapers is highly effective in absorbing frequent wetness. Naturally your baby's skin remains dry for upto12 hours ,now no more frequent diaper changing or blow leaks for your little angel.",
        999,
        "https://rukminim1.flixcart.com/image/832/832/diaper/b/w/j/4902430671460-62-pampers-active-baby-diapers-original-imaenas2ttkfyhxr.jpeg?q=70",
        4, DiapersAndWipes);
    DiapersAndWipesArray[5] = new Product("Pampers Baby-Dry Pants Diaper - L  (30 Pieces)",
        "Pampers baby-dry pants style diapers are the only pants in India with new Air Channels providing your baby a new type of dryness overnight; breathable dryness.Magic Gel that locks wetness away for up to 12 hours of dryness.The new & improved product design enables a comfortable fit, closer to the baby's body.Flexible waist band that adapts to baby's movements for a comfortable fit. Baby lotion with Aloe Vera helps protect your baby's delicate skin from diaper rash and irritation. A top layer with cotton like soft material, for a comfortable night's sleep. Fun exterior graphics; fun designs & characters to enjoy with your baby.",
        484,
        "https://rukminim1.flixcart.com/image/832/832/jmkwya80/diaper/r/h/f/pants-diapers-new-l-30-pampers-original-imaf9gfgp3ffehxc.jpeg?q=70",
        5, DiapersAndWipes);
    DiapersAndWipesArray[6] = new Product("Pampers Active Baby Diapers - S  (46 Pieces)",
        "5 Star Skin Protection: The Best tape style diapers from Pampers, with an outer layer of cotton-like softness, this baby diaper provides intense care to your baby's sensitive skin and protects it effectively from friction rash and redness. These soft and comfort fitting diapers with stretchable sides are best for your baby's rest and playtime. The diaper's fastening tape sticks multiple times thus ensuring it stays in place even after you fasten it after checking your baby's diaper. Protection and nourishment of your baby's skin are taken care of with extracts of moisturising Aloe Vera lotion, characteristic of these best baby diapers.. These diapers are ultra-thin, thanks to the absorbent gel material (AGM), commonly known as Magic Gel. This magic gel core of Pampers diapers is highly effective in absorbing frequent wetness. Naturally your baby's skin remains dry for upto12 hours ,now no more frequent diaper changing or blow leaks for your little angel.",
        678,
        "https://rukminim1.flixcart.com/image/832/832/j3rm8i80/diaper/t/f/x/active-baby-diapers-small-size-s-46-pampers-original-imaeuapssgtvkfts.jpeg?q=70",
        2, DiapersAndWipes);
    DiapersAndWipesArray[7] = new Product("Pampers Active Baby Diapers - L  (50 Pieces)",
        "5 Star Skin Protection: The Best tape style diapers from Pampers, with an outer layer of cotton-like softness, this baby diaper provides intense care to your baby's sensitive skin and protects it effectively from friction rash and redness. These soft and comfort fitting diapers with stretchable sides are best for your baby's rest and playtime. The diaper's fastening tape sticks multiple times thus ensuring it stays in place even after you fasten it after checking your baby's diaper. Protection and nourishment of your baby's skin are taken care of with extracts of moisturising Aloe Vera lotion, characteristic of these best baby diapers.. These diapers are ultra-thin, thanks to the absorbent gel material (AGM), commonly known as Magic Gel. This magic gel core of Pampers diapers is highly effective in absorbing frequent wetness. Naturally your baby's skin remains dry for upto12 hours ,now no more frequent diaper changing or blow leaks for your little angel.",
        969,
        "https://rukminim1.flixcart.com/image/832/832/j31wb680/diaper/c/x/w/active-baby-diapers-large-size-l-50-pampers-original-imaeu9wqmjbbdm6z.jpeg?q=70",
        3, DiapersAndWipes);
    DiapersAndWipesArray[8] = new Product("MamyPoko Pants Standard Diapers - S  (46 Pieces)",
        "This new and improved Mamy Poko Pants diapers are way more efficient and useful than the cloth nappies. In this Standard diaper pack, you will 46 pant-style diapers which are highly absorbent and are comfortable to wear as well. Small Size The diapers in this set are small in size and are ideal for babies aged between one to six months. Elastic Closure The diapers have a soft elastic waistband without any tapes, so it doesn’t form any lines or hurt your baby's skin.",
        343,
        "https://rukminim1.flixcart.com/image/832/832/jkbguq80/diaper/a/t/z/s-pants-standard-46-mamypoko-original-imaf7p8wksuvfjea.jpeg?q=70",
        3, DiapersAndWipes);
    DiapersAndWipesArray[9] = new Product("Pampers Premium Care Pants - XXL  (22 Pieces)",
        "New Pampers Premium Pants with cotton like soft materials is best for your babys delicate skin. Pampers Premium Pants contain lotion with Aloe Vera and 3 Air Channels which helps your babys skin breathe. Experience 5 Star comfort with unique added features like Wetness Indicator which turns Yellow to Blue indication when you may change and Disposal Tape which helps you in easy disposal of the diaper. Pampers is the No. 1 choice of Doctors for diapers. Pampers Premium Pants are available in New-born (NB), S, M, L, XL and XXL sizes.",
        573,
        "https://rukminim1.flixcart.com/image/832/832/jm6mjrk0/diaper/5/k/h/pants-diaper-xxl-22-pampers-original-imaf8wgrufjjh7mg.jpeg?q=70",
        4, DiapersAndWipes);
    DiapersAndWipesArray[10] = new Product("Pampers Pampers Premium Care Pants Diapers - L  (20 Pieces)",
        "Pampers Premium Care Pants style diapers are designed to give your baby our Best Skin Protection. Made from silky soft materials, these new pants style diapers are superior to ordinary pants and protect your baby's precious skin. They come with 3 Absorbing Channels that distribute wetness evenly and lock it away better to keep your baby dry and comfortable from the very first touch.",
        391,
        "https://rukminim1.flixcart.com/image/832/832/jf8khow0/diaper/p/e/w/pampers-premium-care-pants-diapers-l-20-pampers-original-imaeup7njfkuuebw.jpeg?q=70",
        1, DiapersAndWipes);
    DiapersAndWipesArray[11] = new Product("Pampers Active Baby Diapers Large - L  (50 Pieces)",
        "5 Star Skin Protection: The Best tape style diapers from Pampers, with an outer layer of cotton-like softness, this baby diaper provides intense care to your baby's sensitive skin and protects it effectively from friction rash and redness. These soft and comfort fitting diapers with stretchable sides are best for your baby's rest and playtime. The diaper's fastening tape sticks multiple times thus ensuring it stays in place even after you fasten it after checking your baby's diaper. Protection and nourishment of your baby's skin are taken care of with extracts of moisturising Aloe Vera lotion, characteristic of these best baby diapers.. These diapers are ultra-thin, thanks to the absorbent gel material (AGM), commonly known as Magic Gel. This magic gel core of Pampers diapers is highly effective in absorbing frequent wetness. Naturally your baby's skin remains dry for upto12 hours ,now no more frequent diaper changing or blow leaks for your little angel.",
        959,
        "https://rukminim1.flixcart.com/image/832/832/jf8khow0/diaper/g/f/g/active-baby-diapers-large-l-50-pampers-original-imaf3rf3gjnka7gf.jpeg?q=70",
        4, DiapersAndWipes);

    FloorAndOtherCleanersArray[0] = new Product("Gala Dust Go Set Plastic Dustpan  (Multicolor)",
        "Gala Dust Go Set Dustpan (Multicolor)", 145,
        "https://rukminim1.flixcart.com/image/832/832/jjylw280/dustpan/r/x/q/dustgo-set-gala-original-imaf7ez7qwyr9ywd.jpeg?q=70",
        2, FloorAndOtherCleaners);
    FloorAndOtherCleanersArray[1] = new Product("Lizol Disinfectant Surface Cleaner Citrus  (975 ml)",
        "Get rid of germs from your home using the Lizol Disinfectant Surface Cleaner. Featuring a fragrant formula, this disinfectant kills up to 99.9% of germs to ensure that your house stays clean, shiny and germ-free. Recommended by the Indian Medical Association This disinfectant can remove up to 100 types of stains and germ strains, which makes it ideal for cleaning almost all kinds of surfaces. Pleasant Fragrance Not only does this disinfectant eliminate germs, but it also leaves a pleasant fragrance to keep your house smelling fresh.",
        143,
        "https://rukminim1.flixcart.com/image/832/832/jqzitu80/bathroom-floor-cleaner/9/p/d/citrus-975-disinfectant-surface-cleaner-bottle-lizol-original-imafcvw8xehnhbtp.jpeg?q=70",
        1, FloorAndOtherCleaners);
    FloorAndOtherCleanersArray[2] = new Product("Cif Floor Cleaner Wild Orchid  (1 L)",
        "Experience the beauty of Cif Wild Orchid Floor Cleaner with its fresh aqua scent, it will leave your floor residue free and sparkling. Cif Floor cleaners are specially formulated to cut through stubborn dirt on floors and washable surfaces around your home, whether it’s your kitchen, bathroom or living-room.CIF Ocean Floor cleaner is an all-purpose cleaner that can be used on various number of surfaces such as: linoleum, vinyl and ceramic tile and is residue free to leave a brilliant shine",
        168,
        "https://rukminim1.flixcart.com/image/832/832/jmux18w0/bathroom-floor-cleaner/m/g/h/wild-orchid-1-floor-cleaner-bottle-cif-original-imaf9nza6ubvxkhk.jpeg?q=70",
        1, FloorAndOtherCleaners);
    FloorAndOtherCleanersArray[3] = new Product("Cif Surface Cleaner Cream Lemon Kitchen Cleaner  (500 ml)",
        "New Cif Cream Lemon with its citrus fresh scent is packed with millions of natural microcrystals derived from limestone. The ‘microcrystals’ in our Cif cream are microparticles made from a naturally occurring mineral and are not linked to the plastic microbeads that have the potential to contribute to microplastic marine litter. There are no microplastics in any of our Cif products.",
        126,
        "https://rukminim1.flixcart.com/image/832/832/jy0frm80/kitchen-surface-cleaner/d/q/h/500-surface-cleaner-cream-lemon-cif-original-imafgcevfnrpqjam.jpeg?q=70",
        1, FloorAndOtherCleaners);
    FloorAndOtherCleanersArray[4] = new Product("Lizol Disinfectant Surface Cleaner Jasmine  (975 ml)",
        "This Lizol disinfectant surface cleaner is here to keep your home fresh, germ-free, and aromatic. Its distinctive formulation helps kill up to 99.9% germs, providing up to 10 times better cleaning and germ protection (as compared to standard phenyls). Fend off Germs This floor cleaner can be used to clear your home of germs that may cause food poisoning, diarrhoea, and so on. Versatile Use This Lizol disinfectant surface cleaner can be used directly or after dilution. For lightly soiled areas, you can use this cleaning liquid mixed with water; and, for heavily soiled areas, you can use it without dilution. Fragrant and Suitable for All Areas Thanks to the jasmine aroma of this cleaning liquid, your house will be left clean and aromatic at the same time. It can be used to clean your floors, tiles, kitchen counters, and other washable surfaces. ",
        161,
        "https://rukminim1.flixcart.com/image/832/832/jqzitu80/bathroom-floor-cleaner/y/g/u/jasmine-975-disinfectant-surface-cleaner-bottle-lizol-original-imafcvw8bvv78q6h.jpeg?q=70",
        3, FloorAndOtherCleaners);
    FloorAndOtherCleanersArray[5] = new Product(
        "Scotch Brite Kitchen Squeegee (Pack of 1) Wet & Dry Mop  (White 0.2 m)",
        "A perfect tool to keep your kitchen counters, dining tables and glass surfaces squeaky clean and sparkling!",
        220,
        "https://rukminim1.flixcart.com/image/832/832/j9st5zk0/mop-cleaning-wipe/y/a/5/mop007-scotch-brite-original-imaezggezzckjh6u.jpeg?q=70",
        5, FloorAndOtherCleaners);
    FloorAndOtherCleanersArray[6] = new Product("Lizol Power Orange Burst Kitchen Cleaner  (450 ml)",
        "The Lizol Power Kitchen Cleaner helps remove up to 99.9% of germs, grease, food stains, dirt, and more. It can be used to properly clean non-porous surfaces that come into contact with food items. It helps kill E. Coli, salmonella, staph, Pseudomonas aeruginosa, and so on. Thanks to its orangey aroma, your kitchen will be left smelling fresh without any chemical residue. Eliminates up to 99.9% Germs This kitchen cleaner rids your cooking environment of disease-causing germs so that you can safely and hygienically cook and clean. Ten Times Better Cleaning Compared to ordinary detergent bars, this kitchen cleaner ensures up to 10 times better cleaning. No Harsh Chemical Residue After cleaning your kitchen, there will be no harsh chemical residue left behind. You will also be protected from diseases such as E. Coli, salmonella, staph, Pseudomonas aeruginosa, and so on.",
        109,
        "https://rukminim1.flixcart.com/image/832/832/jievpu80/kitchen-surface-cleaner/s/e/a/450-power-orange-burst-lizol-original-imaf6849xzhhmhth.jpeg?q=70",
        4, FloorAndOtherCleaners);
    FloorAndOtherCleanersArray[7] = new Product("Harpic Disinfectant Bathroom Floral  (500 ml)",
        "This thick liquid cleaner from Harpic is what you will need to keep your bathroom spic, span, and hygienic. Its liquid formula can eliminate up to 99.9% germs from your bathroom surface and leaves it with a fresh floral smell. Keeps Your Bathroom Clean This disinfectant can kill up to 99.9% germs, thereby keeping your bathroom clean and hygienic. Safe for Most Bathroom Surfaces This cleaner can be utilised to clean the basin and almost all bathroom surfaces including ceramic, stainless steel, and granite surfaces. Has a Pleasant Fragrance Your bathroom will not only look clean, but will also smell fresh, thanks to its floral smell.",
        81,
        "https://rukminim1.flixcart.com/image/832/832/jepzrm80/bathroom-floor-cleaner/k/h/n/floral-500-disinfectant-bathroom-harpic-original-imaf3chyshnxvatg.jpeg?q=70",
        4, FloorAndOtherCleaners);
    FloorAndOtherCleanersArray[8] = new Product("Lizol Power Orange Burst Kitchen Cleaner  (250 ml)",
        "The Lizol Power Kitchen Cleaner helps remove up to 99.9% of germs, grease, food stains, dirt, and more. It can be used to properly clean non-porous surfaces that come into contact with food items. It helps kill E. Coli, salmonella, staph, Pseudomonas aeruginosa, and so on. Thanks to its orangey aroma, your kitchen will be left smelling fresh without any chemical residue. Eliminates up to 99.9% Germs This kitchen cleaner rids your cooking environment of disease-causing germs so that you can safely and hygienically cook and clean. Ten Times Better Cleaning Compared to ordinary detergent bars, this kitchen cleaner ensures up to 10 times better cleaning. No Harsh Chemical Residue After cleaning your kitchen, there will be no harsh chemical residue left behind. You will also be protected from diseases such as E. Coli, salmonella, staph, Pseudomonas aeruginosa, and so on.",
        67,
        "https://rukminim1.flixcart.com/image/832/832/jle1qq80/kitchen-surface-cleaner/t/2/y/250-power-orange-burst-lizol-original-imaf8j98cfhubm2e.jpeg?q=70",
        3, FloorAndOtherCleaners);
    FloorAndOtherCleanersArray[9] = new Product("Scotch Brite Multipurpose Wipe Wet and Dry Microfibre Cleaning Cloth",
        "Keep your home and kitchen looking spick and span with this Scotch Brite Multipurpose Cleaning Cloth.   Traps Dirt   As this cloth is made of microfibre, it can trap dirt and grime easily, without leaving anything behind.    No Scratches  This cleaning cloth does not leave any scratches on surfaces while cleaning. Appliances, furniture, and windowpanes are some of the things that can be cleaned using the Scotch Brite Multipurpose Cleaning Cloth.",
        153,
        "https://rukminim1.flixcart.com/image/832/832/joq2qa80/cleaning-cloth/z/p/d/microfiber-multipurpose-wipe-scotch-brite-original-imafb4tzfyy9va3w.jpeg?q=70",
        3, FloorAndOtherCleaners);
    FloorAndOtherCleanersArray[10] = new Product("Lizol Lemon Squeeze All Purpose Cleaner  (450 ml)",
        "Make every part of your house look neat and tidy by cleaning the surfaces using this all-purpose cleaner from Lizol. It can remove tough stains from all hard and non-porous surfaces at home. Can Be Used Anywhere From the walls of your home to your kitchen cabinets, you can utilise this cleaner to make every part of your home look spic and span. Cuts Through Tough Grease Stains It removes up to 99.9% germs and it even clears tough grease stains. It can be utilised on any hard and non-porous surfaces at home.",
        109,
        "https://rukminim1.flixcart.com/image/832/832/jic0u4w0/all-purpose-cleaner/g/q/k/450-power-all-purpose-cleaner-power-all-purpose-cleaner-lizol-original-imaf65byhgydz28z.jpeg?q=70",
        4, FloorAndOtherCleaners);
    FloorAndOtherCleanersArray[11] = new Product("Lizol Disinfectant Surface Cleaner Lavender  (975 ml)",
        "You are constantly exposed to germs and the same happens to your home too. Use this lavender-scented disinfectant surface cleaner from Lizol to ensure that the efforts you put into keeping your home fresh and germ-free don’t go in vain. It has a special formulation that kills 99.9% germs and ensures that it performs better than standard disinfectants. Keeping the whole house cleaner, shinier, germ-free and smelling fresh is no longer going to be a task. Recommended by The Indian Medical Association We are constantly exposed to microorganisms that find their way into our homes. Exposure to these germs can cause contamination of food leading to food poisoning, diarrhoea and other kinds of sicknesses. The Indian Medical Association recommends Lizol as one of the best protective measures against germs. Lizol floor cleaner saves you from up to 100 types of stains and 100 up to strains of harmful germs whilst keeping your home clean. Leaves a Pleasant Fragrance The fragrant scent of this floor cleaner will make keep your home smelling fresh always.  ",
        161,
        "https://rukminim1.flixcart.com/image/832/832/jqzitu80/bathroom-floor-cleaner/a/p/z/lavender-975-disinfectant-surface-cleaner-bottle-lizol-original-imafcvw8jezcjmeg.jpeg?q=70",
        2, FloorAndOtherCleaners);

    GheeAndOilsArray[0] = new Product("Saffola Total Blended Oil Can  (1 L)",
        "Here’s a chance to take care of your family by ensuring their healthy heart with this Saffola Pro Heart Conscious oil. It can track eight biomarkers of your healthy heart, thus helping you to maintain the same. It is a blend of two oils that comes with an advanced antioxidant system, consisting of five antioxidants namely Oryzanol, Vitamin E, Tocotrienols, Phytosterol and Squalene. Enriched with Vitamins A and D This healthy oil from Saffola is enriched with Vitamins A and D that protects you from ailments like night blindness and strengthens your bones as well. Tracks Eight Biomarkers Saffola Pro Heart Conscious oil works with eight biomarkers that help you to maintain a healthy heart and reduce inflammation. Antioxidant Technology This heart-friendly oil comes with a carefully designed antioxidant technology that can withstand high temperature and also prevents the formation of free radicals, thus protecting the oil. LOSORB Technology This oil ensures 31% reduction in oil absorption in your fried food, thanks to its LOSORB technology. ",
        200,
        "https://rukminim1.flixcart.com/image/832/832/jfikknk0/edible-oil/4/n/e/1-total-plastic-bottle-blended-oil-saffola-original-imafy4s69avtpvrz.jpeg?q=70",
        3, GheeAndOils);
    GheeAndOilsArray[1] = new Product("Coco Soul Cold Pressed Natural Virgin Coconut Oil Plastic Bottle  (250 ml)",
        "The Coco Soul Cold Pressed Natural Virgin Coconut Oil is a 100% pure and natural superfood that undergoes a cold extraction process that helps preserve all its natural features. The no-heat process of this extraction ensures that the oil retains all its vital nutrients, rich aroma and flavour, making it fit for raw consumption. Multifaceted Usage Thanks to its organic origin, the Coco Soul Cold Pressed Natural Virgin Coconut Oil can be consumed in its raw form itself. 4-5 teaspoons of this organic coconut oil on a daily basis has many health benefits. You can also use it for cooking purposes, rest assured that its natural and organic origin will not have any adverse effect on your loved ones. It can also be used as a taste enhancer too. Benefits of Organic Coconut Oil Virgin Coconut Oil helps support cognition/memory function. It also helps regulate metabolism and boosts energy. Its antifungal and anti-bacterial properties improve digestive health.",
        225,
        "https://rukminim1.flixcart.com/image/832/832/jp1i93k0/edible-oil/m/b/m/250-cold-pressed-natural-virgin-plastic-bottle-coconut-oil-coco-original-imafbdgqfddhv6fz.jpeg?q=70",
        1, GheeAndOils);
    GheeAndOilsArray[2] = new Product("Saffola Aura Refined Flaxseed Olive Oil Plastic Bottle  (1 L)",
        "This Saffola Cooking Oil is here to be a wonderful culinary addition to your kitchen. Apart from offering a rich taste to all your dishes, this cooking oil comes with health benefits as well. Flaxseed oil is rich in omega-3 that helps renew body cells and reduces inflammation. Ideal for salad dressings, dips, spreads, drizzling, flavouring, and more, this cooking oil is going to leave you and your family smacking your lips in delight. Good MUFA and PUFA Balance With a good monounsaturated fatty acid (MUFA) and polyunsaturated fatty acid (PUFA) balance, this cooking oil helps reduce the risk factors that can lead to cardiovascular disease. Facilitates a Healthy Lifestyle As this cooking oil contains antioxidants, it helps you maintain a healthy lifestyle and helps fight free radicals as well. Five Times More Omega-3 This Saffola cooking oil contains five times more Omega-3, which helps renew body cells and reduces inflammation as well.",
        969,
        "https://rukminim1.flixcart.com/image/832/832/johi3680/edible-oil/g/u/j/1-aura-refined-flaxseed-glass-bottle-olive-oil-saffola-original-imafaxthyxk3wttd.jpeg?q=70",
        3, GheeAndOils);
    GheeAndOilsArray[3] = new Product("Saffola Active Blended Oil Pouch  (1 L)",
        "Keeping your weight in check is essential to be healthy. The first and foremost thing that leads to weight gain is mindless eating. So make a smart choice by eating home cooked food that is prepared using the Saffola Active Blended oil. This oil is made by combining the benefits of the LOSORB technology, dual seed technology, and antioxidants. It also ensures less oil adsorption. LOSORB Technology This technology ensures less oil absorption without affecting the taste of the dish. So, you can cook yummy meals and enjoy them without any change in the taste. Vitamin A and D It also contains the goodness of Vitamin A and D, which are help fight against diseases such as night blindness. It also helps to build strong bones. Dual Seed Technology This Saffola Pro Weight Watchers edible oil also contains a rich blend of refined rice bran oil (80%) and soyabean oil (20%). So you can reap the benefits of both the oils at the same time.",
        85,
        "https://rukminim1.flixcart.com/image/832/832/jfikknk0/edible-oil/t/g/g/1-active-pouch-blended-oil-saffola-original-imafy2qdqjuvzwxg.jpeg?q=70",
        2, GheeAndOils);
    GheeAndOilsArray[4] = new Product("Saffola Gold Blended Oil Pouch  (1 L)",
        "Your health is your treasure and you need the correct food to protect this treasure. The Saffola Gold cooking oil is enriched with oryzanol, natural antioxidants, Vitamin A, Vitamin D, and balanced MUFA and PUFA to keep you at the prime of your health. Pro-health Blended Cooking Oil This cooking oil is crafted by employing the Dual-seed technology which blends 80% refined rice bran oil with 20% important refined safflower oil. LOSORB Technology This cooking oil boasts of the LOSORB technology, which leads to lesser absorption of this oil in deep-friend food items. It is also enriched with Vitamin A and Vitamin D, which help prevent night-blindness and bone weakness. Healthy for Your Heart This cooking oil is enriched with natural antioxidants, which prevent plaque formation on your heart. It also comes with balanced MUFA and PUFA to add to the health of your heart.",
        145,
        "https://rukminim1.flixcart.com/image/832/832/jfikknk0/edible-oil/g/a/d/1-gold-pouch-blended-oil-saffola-original-imafy4s628b4hgge.jpeg?q=70",
        2, GheeAndOils);
    GheeAndOilsArray[5] = new Product("Disano Canola Oil 5L Canola Oil Plastic Bottle  (5 L)",
        "Disano canola oil is low in saturated fats. Has goodness of  omega-3 and contains vitamin E. It has light neutral taste hence does not changes the taste of the preparation. Its ideal for all type of Indian cooking. It has high smoking point so ideal for deep frying as well. It has zero cholesterol.",
        643,
        "https://rukminim1.flixcart.com/image/832/832/jzeg6fk0/edible-oil/d/w/y/5-canola-oil-5l-plastic-bottle-canola-oil-disano-original-imafjf6gzrjzcez2.jpeg?q=70",
        2, GheeAndOils);
    GheeAndOilsArray[6] = new Product("Saffola Tasty Blended Oil Pouch  (1 L)",
        "Make healthy decisions with this Saffola Tasty blended oil which, gives you the goodness of two oils in one. This oil gives you the benefit of Oryzanol and a balanced fatty acid profile. Two-in-One Goodness This Saffola oil uses Dual-seed Technology to create a healthy blend of 40% refined rice bran oil and 60% refined corn oil. LOSORB Technology The use of LOSORB technology leads to lesser oil absorption, making this oil a healthy choice for you. It is also enriched with Vitamin A and Vitamin D which, help improve sight and strengthen bones. MUFA and PUFA The Saffola Tasty oil is crafted to provide you with a good balance of MUFA and PUFA, which keep your heart healthy.",
        110,
        "https://rukminim1.flixcart.com/image/832/832/jfikknk0/edible-oil/j/x/k/1-tasty-pouch-blended-oil-saffola-original-imafy4s6hwhydxpa.jpeg?q=70",
        4, GheeAndOils);
    GheeAndOilsArray[7] = new Product("Coco Soul Cold Pressed Organic Virgin Coconut Oil Plastic Bottle  (250 ml)",
        "The Coco Soul Cold Pressed Natural Virgin Coconut Oil is a 100% pure and natural superfood that undergoes a cold extraction process that helps preserve all its natural features. The no-heat process of this extraction ensures that the oil retains all its vital nutrients, rich aroma and flavour, making it fit for raw consumption. Multifaceted Usage Thanks to its organic origin, the Coco Soul Cold Pressed Natural Virgin Coconut Oil can be consumed in its raw form itself. 4-5 teaspoons of this organic coconut oil on a daily basis has many health benefits. You can also use it for cooking purposes, rest assured that its natural and organic origin will not have any adverse effect on your loved ones. It can also be used as a taste enhancer too. Benefits of Organic Coconut Oil Virgin Coconut Oil helps support cognition/memory function. It also helps regulate metabolism and boosts energy. Its antifungal and anti-bacterial properties improve digestive health.",
        367,
        "https://rukminim1.flixcart.com/image/832/832/jp1i93k0/edible-oil/t/5/m/250-cold-pressed-organic-virgin-plastic-bottle-coconut-oil-coco-original-imafbdjhc3yyu6vy.jpeg?q=70",
        1, GheeAndOils);

    HairCareArray[0] = new Product("Pantene Hair Fall Control Shampoo  (180 ml)",
        "If your hair falls frequently and you leave behind a strand or two wherever you go, it’s time to take a second look at the shampoo you use. Pantene Hair fall Control Shampoo is designed for use by both men and women to reduce hair fall. This Hair fall Control Shampoo gently but effectively removes impurities and excess sebum from your hair and scalp. This facilitates better absorption of the fortifying nutrients present in the Pantene Hair fall Control Shampoo. Your weak hair is left nourished and breakage is reduced considerably. With continued use your hair is left feeling nourished and repaired. Enjoy thick tresses full of bounce and volume with Pantene Hair fall Control Shampoo. Directions for Use Brush your hair before bath. Wash your hair completely with water. Pour the required amount of Pantene Hair fall Control Shampoo and apply evenly through your hair. Work into lather and massage your scalp using your fingertips. Squeeze and remove excessive lather and wash off thoroughly.",
        112,
        "https://rukminim1.flixcart.com/image/832/832/jxtakcw0/shampoo/f/m/b/180-hair-fall-control-shampoo-pantene-original-imafg6zghhyh64e5.jpeg?q=70",
        4, HairCare);
    HairCareArray[1] = new Product("Parachute Pure Coconut Hair Oil  (300 ml)",
        "Treat your mane with the engulfing aroma of coconuts with the Parachute coconut hair oil. This coconut oil has been manufactured using hand-picked coconuts and it has undergone a 5-stage purification process for enhanced purity. 100% Pure Coconut Oil This coconut oil has been made using hand-picked coconuts from India, thereby making it authentic and pure. Consistent Composition Every drop of this oil has the same consistency and viscosity, thereby keeping your hair healthy and strong, with every use. 5-stage Purification Process It has undergone a 5-step purification process to ensure that what you get is nothing but pure and fresh coconut oil for your hair.",
        107,
        "https://rukminim1.flixcart.com/image/832/832/jjylw280/hair-oil/q/v/p/300-coconut-oil-parachute-original-imaf7fg2ftaf9zv2.jpeg?q=70",
        5, HairCare);
    HairCareArray[2] = new Product("Garnier Color Naturals Creme Hair Color  (Shade 5, Light Brown)",
        "Achieving beautiful tresses is not a tough task anymore with the application of this Color Naturals Hair Color from the esteemed beauty house of Garnier. Enriched with the essence of olive oil, this Garnier Color Naturals Hair Color ensures no side effects as it is organic in nature. Revel in the goodness of Olive oil which helps in moisturizing your locks after coloring and protecting them from getting damaged. This Hair Color is neatly packed with a colorant tube, a developer bottle and gloves for easy and safe application. The texture of this Hair Color is in the form of cream which can be easily applied on your tresses without dripping. Available in the fun shade of Light Brown, this Hair Color provides with complete grey coverage while nourishing and conditioning your hair. This Color Naturals Hair Color is a permanent hair color cream which provides radiance and shine to your tresses as it colors. The Garnier Color Naturals Hair Color (Light Brown - 5) lasts longer thus, providing every woman with soft and silky hair.",
        162,
        "https://rukminim1.flixcart.com/image/832/832/jsc3ssw0/hair-color/t/9/v/color-naturals-shade-5-garnier-original-imafdwdbmz9xdzth.jpeg?q=70",
        5, HairCare);
    HairCareArray[3] = new Product("TRESemme Detox & Restore Shampoo- No Parabens, No Dyes  (580 ml)",
        "Launched in 1948, TRESemme was named after renowned hair care expert Edna Emme. Up until the 1950's, TRESemme was sold only in salons. Today it is available at a shop near you, so that you can have salon style hair at home. For over 60 years, TRESemme has built a history of success in 13 countries around the world. From its origins in 1947 and salon expertise, TRESemme has been driven by a simple truth: every woman deserves to look & feel fabulous, like she has just stepped out of the salon, everyday. This range has been carefully selected for its advanced formula. Driven by our salon heritage, we work with our stylists to deliver expert solutions from salon quality products without the salon price tag. Detox your way to stunning, healthy looking hair with every wash. Our expertly crafted system, gently purifies hair from daily residue build up without parabens or dyes. Formulas with our botanical blend of ginseng and neem, help nourish weak and damaged cuticles reviving hair and restoring manageability. Safe for color treated hair. Apply the TRESemme Botanique Detox & Restore Shampoo to wet hair, gently massage and work into a lather. Rinse thoroughly. Follow with TRESemme Botanique Detox & Restore Conditioner.",
        410,
        "https://rukminim1.flixcart.com/image/832/832/jv5k2a80/shampoo/q/s/u/580-detox-restore-shampoo-no-parabens-no-dyes-tresemme-original-imafdu7brvezc4bp.jpeg?q=70",
        3, HairCare);
    HairCareArray[4] = new Product("Set Wet Studio X Clean Cut Shine Hair Wax  (70 g)",
        "‘On fleek’ hair doesn’t happen just like that, but then again, it isn’t as much work as you think it is. Sometimes, all it takes to be ‘the guy with the cool hair’ is using this Set Wet Studio X Styling Wax Clean Cut Shine Hair Styler. This oil-based formula offers your hair an all-day smoothness and a long-lasting hold. Take a dollop of the product on your fingertips and apply it to the ends of hair strands. You can restyle your hair without washing the wax off.",
        199,
        "https://rukminim1.flixcart.com/image/832/832/jvv9zm80/hair-styling/6/k/8/hair-wax-70-0-clean-cut-shine-set-wet-studio-x-original-imaffvhrqff4u3um.jpeg?q=70",
        3, HairCare);
    HairCareArray[5] = new Product("Indulekha Bhringa Hair Oil  (100 ml)",
        "Hair and scalp conditions can be caused due to stress, pollution, infections and much more. With the Indulekha Bhringa Hair Oil, you can keep your hair healthy and nourished. You can apply it directly to your scalp as it comes with a selfie bottle. The ingredients are infused to make an ayurvedic concoction that promotes healthy hair growth. Ayurvedic Concoction The Swethakutaja leaves are dipped in coconut oil to bring out their medicinal quality. The base oil, along with the other ingredients, such as SvethakutajaIt, aloe vera, neem, amla, Bringharaj and virgin coconut oil, makes this oil beneficial for your hair. Anti-dandruff Property SvethakutajaIt gives this oil its anti-inflammatory, antimicrobial and anti-dandruff properties. It helps combat skin diseases, such as psoriasis, and dandruff. Aloe Vera With enzymes that repair dead skin cells on the scalp, this ingredient promotes hair growth, reduces dandruff and prevents itching. It also rejuvenates hair by giving it elasticity and prevent hair breakage. Neem Thanks to its anti-protozoal, antioxidant, anti-inflammatory and antibacterial properties, neem effectively cleanses the scalp and treats various skin conditions for a healthy hair growth. Bringharaj Bringharaj extracts are known to improve hair growth and color, giving you lustrous and healthy hair locks. Amla Being a rich source of vitamin C and antioxidants, amla prevents premature graying and gives strength to the hair follicles. Virgin Coconut Oil This ingredient is extracted by cold compression method. It is high in vitamins, antioxidants, minerals, fragrance and proteins.",
        375,
        "https://rukminim1.flixcart.com/image/832/832/jjq18y80/hair-oil/z/8/p/100-bhringa-indulekha-original-imaf78cbvdgqvyzz.jpeg?q=70",
        2, HairCare);
    HairCareArray[6] = new Product("L'Oreal Paris Casting Creme Gloss Hair Color  (Medium Brown 500)",
        "Give your mane a trendy makeover with this Loreal Paris Casting Cream Gloss Hair Color. The Medium Brown - 500 shade of this hair color gives your hair a smooth natural looking shade. The formula of this hair color will not only cover all the greys but will also give you glossy tresses to flaunt. The hair color set includes a casting cream gloss cream colorant, a casting cream gloss nutri shine conditioner and a casting cream gloss developer. As this hair color does not contain ammonia, it is completely safe for your hair. Enriched with aloe vera and green tea, this Loreal Paris Casting Cream Gloss Hair Color nourishes your hair to make it soft and smooth. The formula gives your hair a shimmery look that is sure to grab attention. This hair color is ideal for women. Directions for Use Read the instructions and precautions provided carefully before using the hair color. Perform a skin allergy test, as per the instructions, to make sure that you are not allergic to the contents of this hair color. Use gloves while handling the cream. Rinse your hair thoroughly after the hair coloring process.",
        495,
        "https://rukminim1.flixcart.com/image/832/832/jyrl4sw0/hair-color/m/n/4/casting-creme-gloss-l-oreal-paris-original-imafgxg5kzfqtwwc.jpeg?q=70",
        3, HairCare);
    HairCareArray[7] = new Product("L'Oreal Paris Fall Resist 3X Anti-Hairfall Shampoo  (10% Extra in Pack)  (640 ml)",
        "Fall Resist 3x Anti-Hair Fall shampoo delivers a triple anti-hair fall action. Your hair is more resistant from the roots and is stronger, looks healthier and more beautiful. The formula helps deliver a triple anti-hair fall action instantly detangles and your hair is more resistant from root to tip. Nourishes The Hair Root. Restructures Hair Fibre; Hair Grows Stronger. Hair Is Stronger From Root To Tip.",
        382,
        "https://rukminim1.flixcart.com/image/832/832/k0463rk0/shampoo/a/f/t/640-fall-repair-3x-shampoo-l-oreal-original-imafjzajtrf9gpgm.jpeg?q=70",
        4, HairCare);
    HairCareArray[8] = new Product("Biotique Bio Green Apple Daily Purifying Shampoo & Conditioner  (200 ml)",
        "This refreshing formula is blended with pure green apple extract, sea algae and centella, to purify and nourish the scalp and hair with natural minerals and proteins. Special pH balanced formula is gentle enough to use every day. Leaves hair refreshed and full of natural body and shine.",
        148,
        "https://rukminim1.flixcart.com/image/832/832/jq4353k0/shampoo/x/c/f/200-bio-green-apple-daily-purifying-shampoo-conditioner-biotique-original-imafc79rgskrtcvg.jpeg?q=70",
        3, HairCare);
    HairCareArray[9] = new Product("L'Oreal Paris Casting Creme Gloss Hair Color  (Black Cherry 360)",
        "Imagine waking up in the morning and spotting grey hair on your head; well nobody would even want to imagine that. However, if you do spot one, do not worry as you can take this opportunity to give yourself a new style statement with this Loreal Paris Hair Color. Every woman will love to flaunt a style statement that is a little away from the usual, with this Black Cherry - 360 color from Loreal Paris. With active ingredients such as aloe vera and green tea, this cream hair color will not only cover grey hair but also give a natural looking hair color. This pack of Loreal Paris Casting Creme Gloss Hair Color contains one cream colorant, one conditioner and one developer. This ammonia-free Hair Color by Loreal Paris is free from chemicals, thus, is safe for your hair. That means you do not have to worry about hair loss or any other hair damage. Also, this Hair Color is crafted to give your hair visible shimmering tones and radiant shine. Directions for Use Apply the hair color using a brush, either full hair coverage or just the root touch-up. Leave it on as directed in the instruction leaflet. Rinse well.",
        539,
        "https://rukminim1.flixcart.com/image/832/832/jyrl4sw0/hair-color/e/w/p/casting-creme-gloss-l-oreal-paris-original-imafgxg3gd5h4vvv.jpeg?q=70",
        5, HairCare);
    HairCareArray[10] = new Product("L'Oreal COLOUR PROTECT SHAMPOO  (10% Extra in Pack)  (360 ml)",
        "Colour Protect shampoo by LOreal Paris nourishes the hair and transforms its surface, keeping the hair protected and prolonging the color radiance. The Colour Protect formula with UV filter- Light Reflecting System combines an active nourishing ingredient and filters for color treated hair. Dry hair, meet your match. LOreal Paris offers hair conditioners for every concern and hair type. Whether youre looking to moisturize dry hair, want a conditioner for colored hair, or want to help repair damaged hair with a deep conditioner, we have the hair conditioner�and complementary shampoo�that best fits your needs!. Nourishes The Hair And Transforms Its Surface. Hair Feels Silky To Touch . Helps Protect The Hair Fibre From External Aggressions And Accentuates The ColorS Radiance.",
        253,
        "https://rukminim1.flixcart.com/image/832/832/k0463rk0/shampoo/a/z/t/360-colour-protect-shampoo-l-oreal-original-imafjzajpmeafg6y.jpeg?q=70",
        5, HairCare);
    HairCareArray[11] = new Product("TRESemme Hair Fall Defense Conditioner  (190 ml)",
        "Get salon-like treatment for your hair right at home with this conditioner from TRESemme. Enriched with high-quality ingredients, such as Keratin, this conditioner gives you longer, stronger and manageable hair with every wash. Hairfall Defense System Enriched with Keratin, this conditioner reinforces hair strength and prevents hair fall caused by breakage. It is specially formulated for Indian hair to give your hair its original strength, and it can be used with other oil treatments too. Long and Strong Hair The lightweight formula incorporated in this conditioner evenly conditions and detangles distressed hair such that it is beautiful, yet manageable.",
        149,
        "https://rukminim1.flixcart.com/image/832/832/js4yljk0/conditioner/f/c/f/190-hair-fall-defense-conditioner-tresemme-original-imafdsyvfkvgghzu.jpeg?q=70",
        2, HairCare);

    HealthandWellnessArray[0] = new Product("Durex Play Massage 2 in 1 Sensual Lubricant  (200 ml)",
        "Spice up your time in between the sheets with your significant other using this Durex Play Massage 2 in 1 Sensual Lubricant which is Easy to Wash Off, is Gentle on Your Skin and Safe to Use.  Water Soluble Made from Water-soluble ingredients, this sensual lubricant can easily dissolve in water and is hence easy to wash off. Gentle on Your Skin This lubricant is non-sticky and Gentle on Your Skin.   Smooth Formula This lubricant has a Smooth Formula which is effective in enhancing sensations. Safe to Use This lubricant is Safe to Use with Condoms.  ",
        455,
        "https://rukminim1.flixcart.com/image/832/832/jyrl4sw0/lubricant/y/c/w/200-play-massage-2-in-1-sensual-durex-original-imafgxg9atynmsb4.jpeg?q=70",
        5, HealthandWellness);
    HealthandWellnessArray[1] = new Product("Durex Cheeky Cherry Lubricant  (50 ml)",
        "Turn that boring night into an adventurous one with the Durex Play Lubricant Gel. Stimulate your senses with its fruity cherry flavour. It is 100% Safe and Secure and Totally Sugar-free so that you don’t have to worry about anything else apart from enjoying yourself. 100% Safe and Secure This luscious cherry-flavoured lubricant gel comes not only is safe for your skin, but also makes your love-making session exciting. Deliciously Fruity Its smooth texture, combined with its sweet taste, invigorates your senses for enhanced pleasure. No More Discomfort Vaginal dryness can be a discomfort while being intimate with your partner. You can ease this discomfort and make your lovemaking session exotic and adventurous for you and your partner. Water Soluble It can be easily washed off. Moreover, it won’t leave any stains. Totally Sugar-free Its delectable cherry flavour does not stem from sugar. So, go on use it on your body and jazz up your sex life. Disclaimer While we work to ensure that product information is correct, on occasion manufacturers may alter their ingredient lists. Actual product packaging and materials may contain more and/or different information than that shown on our Website. We recommend that you do not solely rely on the information presented and that you always read labels, warnings, and directions before using or consuming a product. For additional information about a product, please contact the manufacturer. Content on this site is for reference purposes and is not intended to substitute for advice given by a physician, pharmacist, or other licensed health-care professional. You should not use this information as self-diagnosis or for treating a health problem or disease. Contact your health-care provider immediately if you suspect that you have a medical problem. Information and statements regarding dietary supplements are not intended to diagnose, treat, cure, or prevent any disease or health condition. Flipkart.com assumes no liability for inaccuracies or misstatements about products. Not for sale to persons under the age of 18. By placing an order for this product, you declare that you are 18 years of age or over. This item must be used responsibly and appropriately.",
        403,
        "https://rukminim1.flixcart.com/image/832/832/jyrl4sw0/lubricant/s/b/d/50-cheeky-cherry-durex-original-imafgxg8hcsdapth.jpeg?q=70",
        2, HealthandWellness);
    HealthandWellnessArray[2] = new Product("Dabur Chyawanprakash Sugarfree  (500 g)",
        "Dabur Chyawanprakash Sugar Free is unlike other typical nutrition supplements: it's a specialised immune system booster that's made to ensure that no one gets left out. If you're avoiding sugar for any reason at all, you can still protect yourself from day-to-day ailments like cough & cold.",
        165,
        "https://rukminim1.flixcart.com/image/832/832/jzrb53k0/chyawanprash/a/x/j/500-chyawanprakash-sugarfree-dabur-original-imafjpatqgp64yfk.jpeg?q=70",
        3, HealthandWellness);
    HealthandWellnessArray[3] = new Product("Nestle Nangrow Creamy Vanilla Flavour  (400 g)",
        "Your growing child requires the right amount of nutrition for healthy growth and development. This Nestle Nangrow Milk Drink will provide just that to your kid. Nutritious Milk Drink Formulated for kids that are aged 2 - 5 years, this formula contains Vitamin A and C, zinc, iron and selenium to ensure cognitive development of kids. Creamy Vanilla Flavour It contains DHA that ensures normal brain development and whey protein to ensure easy digestion. In addition to this, its creamy vanilla flavor makes it yummy and flavourful.",
        482,
        "https://rukminim1.flixcart.com/image/832/832/jsdj8nk0/milk-drink-mix/z/z/t/400-creamy-vanilla-flavour-carton-nestle-nangrow-original-imafdymhzr9hpjgg.jpeg?q=70",
        2, HealthandWellness);
    HealthandWellnessArray[4] = new Product("Stayfree Dry-Max All Night XL Wings Sanitary Pad  (Pack of 42)",
        "Get all round protection throughout the night with Stayfree Dry-Max All Night. This specially designed Ultra napkin is extra-long and extra-wide in the back provides 2X better coverage to prevent leakage from all sides no matter how much you move in your sleep. Now you can stay worry free and comfortable all night long. It's super Lock Pockets with gel core lock in fluid for up to 100% protection with zero leakage. It has Odour Control System with natural plant extracts helps prevent odour and Dry-Max Cover for the best dry-feel. Each napkin is individually wraped.",
        378,
        "https://rukminim1.flixcart.com/image/832/832/jxapua80/sanitary-pad-pantyliner/p/q/e/dry-max-all-night-xl-wings-xl-42-sanitary-pad-stayfree-original-imafhsgqfh92fhpf.jpeg?q=70",
        4, HealthandWellness);
    HealthandWellnessArray[5] = new Product(
        "Kotex Overnight Panties Super Absorbent Periodwear S/M Size Sanitary Pad  (Pack of 2)",
        "There’s no need to sacrifice your pretty lingerie to your periods. Let them be because these disposable Kotex Overnight Super-absorbent Period-wear Sanitary Panties offer you a hygienic and convenient solution. They are suitable for heavy and regular flow, and offer a 360-degree protection from leakage. All-night Protection Get your eight hours of beauty sleep even when you’re on your periods. These overnight panties offer a 360-degree anti-leakage protection; feel free to sleep in any position you’re comfortable in. 3D Design Designed to replicate a sanitary pad and a pair of panties in one, these personal hygiene essentials perfectly fit your body to prevent any front, side or back leakage. Soft Material, A Comfortable Wear These panties are made of breathable cotton to ensure your comfort. Their super-absorbent core offers total protection while their panty-like fit eliminates the chances of any discomfort. No Mess, No Fuss Position the blue-colored waistband of the panties at the front. These panties are to be worn in the same way you would wear regular underwear; you don’t have to wear another pair of panties outside these Kotex ones.",
        110,
        "https://rukminim1.flixcart.com/image/832/832/jmi22kw0/sanitary-pad-pantyliner/x/s/2/overnight-panties-super-absorbent-periodwear-m-2-sanitary-pad-original-imaf9e4dqk8cag4m.jpeg?q=70",
        3, HealthandWellness);
    HealthandWellnessArray[6] = new Product("Durex Play Saucy Strawberry Lubricant  (50 ml)",
        "Juice up your intimate moments by using the Durex Play Saucy Strawberry Lubricant. 100% safe and secure, this lubricant will create an exotic experience for you and your partner. 100% Safe and Secure It’s completely safe and secure to use, so you and partner can involve in a relaxed, sensual moment. Aroma of Strawberries Intrigue your senses with the ripe and fresh aroma of lush strawberries and indulge in a smooth and sensual experience. Eases Vaginal Dryness This lubricant will ease out the vaginal dryness to provide a comfortable and intimate sexual experience. Water Soluble This non-greasy, non-sticky and sugar-free lubricant can be easily washed off, without staining your bedsheets or clothes. Safety Note Play Strawberry is water soluble and easily washed off. It's non-sticky and won't stain but it's best to avoid contact with eyes. If you experience irritation, stop using the lube. If irritation continues or additional lube is required all the time then please contact your doctor. Disclaimer While we work to ensure that product information is correct, on occasion manufacturers may alter their ingredient lists. Actual product packaging and materials may contain more and/or different information than that shown on our Website. We recommend that you do not solely rely on the information presented and that you always read labels, warnings, and directions before using or consuming a product. For additional information about a product, please contact the manufacturer. Content on this site is for reference purposes and is not intended to substitute for advice given by a physician, pharmacist, or other licensed health-care professional. You should not use this information as self-diagnosis or for treating a health problem or disease. Contact your health-care provider immediately if you suspect that you have a medical problem. Information and statements regarding dietary supplements are not intended to diagnose, treat, cure, or prevent any disease or health condition. Flipkart.com assumes no liability for inaccuracies or misstatements about products. ? Not for sale to persons under the age of 18. By placing an order for this product, you declare that you are 18 years of age or over. This item must be used responsibly and appropriately.",
        332,
        "https://rukminim1.flixcart.com/image/832/832/jyrl4sw0/lubricant/y/e/s/50-play-saucy-strawberry-durex-original-imafgxg977at3hmz.jpeg?q=70",
        2, HealthandWellness);
    HealthandWellnessArray[7] = new Product("Complan Royale Chocolate  (750 g)",
        "Complan Growth Drink Mix is a nutritious and delicious formula which, when consumed in the right quantity, helps bridge the nutritional gap that affects the growth of kids. Contains up to 34 Vital Nutrients It has about 34 vital nutrients, such as calcium and iron, which help kids grow the way they’re supposed to. Apart from that, these nutrients also support brain development and they help maintain adequate fluid balance in your kid’s body. The Pro Immunity nutrients that are present in Complan, on the other hand, support immune functions to keep common infections, such as common cold, cough and fever, at bay. Dosage You can include Complan Growth Mix in your kid’s daily balanced diet and serve him/her with it twice a day.",
        385,
        "https://rukminim1.flixcart.com/image/832/832/jezzukw0/milk-drink-mix/g/r/g/750-royale-chocolate-carton-complan-original-imaf3kbwf8azwmcv.jpeg?q=70",
        2, HealthandWellness);
    HealthandWellnessArray[8] = new Product("Himalaya Diaper Rash Cream  (50 g)",
        "Diaper rash can make even the happiest of babies irritable and put them in pain. Ensure that your bundle of joy doesn’t turn grumpy with this rash cream from Himalaya. Five-leaved Chaste Tree Extract This cream has the extract of the chaste tree that has anti-inflammatory properties that soothes the rash and inhibits microbe growth as well. Natural Zinc The zinc content in this diaper rash cream from Himalaya cools down the inflamed skin and dries moisture up quickly to ensure that the rash clears quickly. Aloe Vera and Almond Oil To keep your baby’s bottom moisturized and chase away rash, the cream has a formula that is infused with aloe vera and almond oil, both of which have astringent properties. Protective Layer When you apply the cream on the baby’s bottom, it forms a protective layer between the cloth or diaper and the skin ensuring that the rash is not further aggravated. Spreads Easy, Mild Fragrance The cream is easy to spread and comes with a pleasing fragrance that is not overpowering yet is mild and soothing.",
        94,
        "https://rukminim1.flixcart.com/image/832/832/jyeq64w0/moisturizer-cream/q/g/2/20-diaper-rash-cream-himalaya-cream-original-imafhv9e6myx2mzd.jpeg?q=70",
        1, HealthandWellness);
    HealthandWellnessArray[9] = new Product("Carefree XL Sanitary Pad  (Pack of 10)",
        "Sanitary pads are a must have as a part of a woman’s necessary accessory. During periods, it is inevitable that women become over conscious about the way they carry themselves. The fear of staining and leakages will encompass a woman and leave her in constant worry and tension. To ensure proper comfort and to rid yourself of such worries you should use a highly absorbent sanitary pad. The Carefree Sanitary Pads are made with various capacities to ensure that it caters to your varying needs. The XL pads from Carefree are meant for the heavy flow days. These Sanitary Pads from Carefree are specially designed to give maximum protection to women during their periods. These comfortable napkins come with a special elastic belt that will help in holding the napkin in its place firmly. These comfortable and separate elastic bands are easy to wear. All you need to do is wear the belt and secure the two ends of the Carefree napkin into the belt and you are good to go. It will give you complete freedom and protection during those trying days of the month. The cottony soft cover on these Carefree Sanitary pads is gentle on the skin and it will help in keeping the skin away from irritations. Make sure that you always carry a napkin with you so that you are never caught unprepared.",
        95,
        "https://rukminim1.flixcart.com/image/832/832/j41mbgw0/sanitary-pad-pantyliner/x/y/d/extra-large-xl-10-sanitary-pad-carefree-original-imaevfrmbndqbyfc.jpeg?q=70",
        5, HealthandWellness);
    HealthandWellnessArray[10] = new Product("Durex Play Massage 2 in 1 Stimulating Lubricant  (200 ml)",
        "Give into your passions without any inhibitions. Leave the work to this Durex Play Massage 2-in-1 Stimulating Lubricant. This water-soluble formula eases vaginal dryness and any sort of discomfort so intimate moments between you and your partner are solely about each other. To switch things up, this lubricant contains guarana which improves physical endurance. Soft to touch, this formula washes off easily and has a pleasant smell.",
        552,
        "https://rukminim1.flixcart.com/image/832/832/jyrl4sw0/lubricant/6/u/h/200-play-massage-2-in-1-stimulating-durex-original-imafgxg8xqghpmza.jpeg?q=70",
        3, HealthandWellness);
    HealthandWellnessArray[11] = new Product("Durex Play Tingling Lubricant  (50 ml)",
        "Add an extra zing to your intimate moments by using this Durex Play Tingling Lubricant. Non-greasy and Non-sticky, this lube will be gentle and safe on your skin. What’s more, it’s sugar-free and doesn’t stain on your clothes. Optimised Tingling Effect This lube contains a unique ingredient that tingles, warms and cools at the same time to provide an optimized tingling effect. 100% Safe and Secure It is safe and gentle even on the intimate areas, creating a long-lasting sensation. Eases Vaginal Dryness It eases out the vaginal dryness and intimate discomfort to provide an exotic sexual experience. Safety Note Play Strawberry is water soluble and easily washed off. It's non-sticky and won't stain but it's best to avoid contact with eyes. If you experience irritation, stop using the lube. If irritation continues or additional lube is required all the time then please contact your doctor. Disclaimer While we work to ensure that product information is correct, on occasion manufacturers may alter their ingredient lists. Actual product packaging and materials may contain more and/or different information than that shown on our Website. We recommend that you do not solely rely on the information presented and that you always read labels, warnings, and directions before using or consuming a product. For additional information about a product, please contact the manufacturer. Content on this site is for reference purposes and is not intended to substitute for advice given by a physician, pharmacist, or other licensed health-care professional. You should not use this information as self-diagnosis or for treating a health problem or disease. Contact your health-care provider immediately if you suspect that you have a medical problem. Information and statements regarding dietary supplements are not intended to diagnose, treat, cure, or prevent any disease or health condition. Flipkart.com assumes no liability for inaccuracies or misstatements about products. Not for sale to persons under the age of 18. By placing an order for this product, you declare that you are 18 years of age or over. This item must be used responsibly and appropriately.",
        403,
        "https://rukminim1.flixcart.com/image/832/832/jyrl4sw0/lubricant/z/p/p/50-play-tingling-durex-original-imafgu6w3wfktzuv.jpeg?q=70",
        5, HealthandWellness);

    HouseholdCareAndPetFoodArray[0] = new Product("Whiskas Adult (+1 year) Fish 3 kg Dry Cat Food",
        "These little pockets of fish cat food are going to have your cat crunching and munching till the last bite. Easy to serve, healthy and crunchy, this cat food is going to give you a healthier and happier cat.",
        680,
        "https://rukminim1.flixcart.com/image/832/832/jj6130w0/pet-food/f/v/t/12-cat-18853301400104-whiskas-original-imaehgbfkdqym7g8.jpeg?q=70",
        2, HouseholdCareAndPetFood);
    HouseholdCareAndPetFoodArray[1] = new Product("Pedigree Puppy Milk, Vegetable 1.2 kg Dry Dog Food",
        "For a complete and tasty meal of milk and vegetables, serve your dog this tasty blend from Pedigree and watch him enjoy his meal times from now.",
        288,
        "https://rukminim1.flixcart.com/image/832/832/jj6130w0/pet-food/u/f/8/1-2-dog-8906002480715-pedigree-original-imaektvk3yc7hsgr.jpeg?q=70",
        2, HouseholdCareAndPetFood);
    HouseholdCareAndPetFoodArray[2] = new Product("Pedigree Adult Gravy Chicken, Liver Dog Treat  (80 g)",
        "With Pedigree for adult dogs (chicken and liver chunks flavoured gravy), your furball will be following you around the house waiting for you to reward him/her with the delicious goodness that the food has to offer. This pet food ensures that it maintains the right balance of vitamins, fibre, and protein so that he/she stays clear of kidney stones and other such ailments. It also boasts delicious flavour and aromas that will tempt your previously fussy little one to dig in. Bring home Pedigree for dogs and watch how his/her tail never stops wagging.",
        34,
        "https://rukminim1.flixcart.com/image/832/832/jkvh0nk0/pet-treat/k/3/5/80-dog-adult-chicken-and-liver-chunks-flavour-in-gravy-pedigree-original-imaf84h5bwj9edtz.jpeg?q=70",
        3, HouseholdCareAndPetFood);
    HouseholdCareAndPetFoodArray[3] = new Product("Whiskas Jelly Tuna Cat Treat  (85 g)",
        "Whiskas Adult Gravy Food provides complete nutrition for your adult pet cat. A complete and balanced cat food, Whiskas gravy is designed to take care of your cat's daily nutritional requirements and provide it with all the required vitamins and minerals along with moisture and nourishment for a healthy and happy life. A cat's love for fish is thoughtfully blended with loads of calcium, phosphorus, proteins, antioxidants, vitamins & minerals, in each pack. It helps maintain its fur, heart-health, weight, skin, teeth, muscles, bones and overall immunity. Whiskas gravy has a texture and aroma that appeals to the palate of your feline, and attracts even fussy eaters in for a filling and fun meal time!",
        35,
        "https://rukminim1.flixcart.com/image/832/832/jkvh0nk0/pet-treat/x/p/4/85-cat-tuna-in-jelly-1-years-whiskas-original-imaf84h5wpscpqgd.jpeg?q=70",
        2, HouseholdCareAndPetFood);
    HouseholdCareAndPetFoodArray[4] = new Product("Pedigree Meat Jerky Stix Liver Dog Treat  (80 g)",
        "Has it been a long time since your dog has been having the same food? If you think it needs a change, these grilled liver sticks from Pedigree are just what your dog needs.",
        123,
        "https://rukminim1.flixcart.com/image/832/832/jj6130w0/pet-treat/g/x/w/320-dog-8-91e-12-pedigree-original-imaepy7afghcc8py.jpeg?q=70",
        2, HouseholdCareAndPetFood);
    HouseholdCareAndPetFoodArray[5] = new Product(
        "Pedigree Gravy Chicken Chunks for Puppy Chicken 1.2 kg Wet Dog Food  (Pack of 15)",
        "Your cute little pup deserves more than simple home cooked food. Serve it this mouth watering and healthy meal of chicken and rice mixed with gravy and watch how it cleans its plate in no time.",
        425,
        "https://rukminim1.flixcart.com/image/832/832/k0zlsi80/pet-food/e/y/a/1-2-dog-18906002481658-pedigree-original-imafknzygkncfhmv.jpeg?q=70",
        1, HouseholdCareAndPetFood);
    HouseholdCareAndPetFoodArray[6] = new Product("Pedigree NA Milk, Chicken Dog Treat  (400 g)",
        "With Pedigree for puppies, your little fur ball will be running behind you for more as it provides him/her with a healthy and delicious combination of chicken and milk. With Pedigree for puppies, your little monster will not only get a healthy and shiny coat, but his/her digestive system, teeth, and bones will also get stronger.",
        82,
        "https://rukminim1.flixcart.com/image/832/832/k0zlsi80/pet-treat/8/k/d/400-dog-puppy-chicken-and-milk-pedigree-original-imafknz7fugjgkhs.jpeg?q=70",
        1, HouseholdCareAndPetFood);

    KajalAndMakeupArray[0] = new Product("L'Oreal Paris Paris Kajal Magique  (Supreme Black, 0.35 g)",
        "If you do not believe in the power and drama of a dash of kajal, then try the L'Oreal Paris Kajal Magique. The intense, long-lasting shade with the goodness of nutrient-rich ingredients make this L’Oreal kajal a must-have makeup essential.  Intense Color The mineral pigments of this kajal deliver bold and long-lasting color with every single stroke. Rich Ingredients This L’Oreal kajal contains Cocoa Butter, Vitamin E, and Olive Oil Esters to soothe your eyes. Waterproof Kajal This waterproof and smudge-proof kajal lasts up to 12 hours.",
        287,
        "https://rukminim1.flixcart.com/image/832/832/k0463rk0/kajal/f/g/8/0-35-magique-kajal-l-oreal-paris-original-imafjzaa4g6wqxyx.jpeg?q=70",
        4, KajalAndMakeup);
    KajalAndMakeupArray[1] = new Product("Lakme 9 to 5 Flawless Matte Complexion Compact  (Almond, 8 g)",
        "Get a glowing complexion by using the Lakme 9 to 5 Flawless Matte Complexion compact. It is enriched with Vitamin E formula to keep your skin well-nourished and gives a radiant look throughout the day. The almond shade of the compact blends seamlessly into the skin and hides the spots and freckles from skin effectively. This easy-to-carry compact will fit into your makeup kit easily. It has a mirror and a soft sponge to give you an even-toned appearance. Shake the excessive powder and wipe the sponge smoothly across your face and neck to get a flawless-looking skin. All Day Mattifying It offers a matte finish so your after-makeup face doesn’t look oily. Contains Vitamin E This compact is enriched with Vitamin E and a unique oil absorbing formula to offer a flawless skin. Three Shades It is available in three different shades to suit almost every skin tone. Long Stay It ensures your makeup remains intact for a long period of time which makes it ideal for office wear. About Lakme Lakme is one of the popular cosmetic brands which has been redefining fashion in India for over 15 years and it specializes in manufacturing products especially for the Indian skin.",
        450,
        "https://rukminim1.flixcart.com/image/832/832/jmjhifk0/compact/z/m/g/8-9-to-5-flawless-matte-complexion-lakme-original-imaewnaga5xg8aje.jpeg?q=70",
        5, KajalAndMakeup);
    KajalAndMakeupArray[2] = new Product(
        "Maybelline New York Color Sensational Powder Matte Lipstick  (Cherry Chic, 3.9 g)",
        "Maybelline New York introduces the new Color Sensational Powder Matte lipsticks. Now powder your pout sensational with 2X Matte intensity and silkier powder finish. Get a dramatic effect with 4X saturated powder pigments  honey nectar.. This Maybelline Matte Lipstick Has An Ultra Powdery Smooth Matte Finish And Long-Lasting Lipsticks. Intense Color Pay Off.. Does Not Smudge. Keeps Lips Hydrated.",
        465,
        "https://rukminim1.flixcart.com/image/832/832/k2p1q4w0/lipstick/b/j/t/3-9-new-york-color-sensational-powder-matte-lipstick-maybelline-original-imafhzjspqk3nxh9.jpeg?q=70",
        4, KajalAndMakeup);
    KajalAndMakeupArray[3] = new Product("Lakme 9 to 5 Complexion Care Face Cream - Beige Foundation  (Beige, 30 g)",
        "Sometimes your skin may need instant makeup when you have a meeting coming up in five minutes. For situations like these, this 9 to 5 Complexion Care Cream – Beige from Lakme will come in handy for you. If you have fair to wheatish complexion, then the beige shade of this cream could be ideal for you. Instantly Styled Skin This cream has the combination of your daily skin cream with just the right touch of makeup, so no matter what the occasion is, it will give you instantly styled skin. Apart from giving you even skin tone, it has SPF 20 that will protect your skin from the sun. For Moisturized Skin This cream is light and gets easily absorbed by your skin. It moisturizes and brightens your skin, while leaving it feeling fresh and natural.",
        301,
        "https://rukminim1.flixcart.com/image/832/832/jhkvgy80/fairness/9/m/u/30-9-to-5-complexion-care-cream-beige-lakme-original-imaev74zumwj2xmm.jpeg?q=70",
        1, KajalAndMakeup);
    KajalAndMakeupArray[4] = new Product("Maybelline Colossal Kajal Smudge Proof  (Black, 0.35 g)",
        "Liven up your eyes with just a stroke of the Colossal Kajal from Maybelline. With a deep black shade, your eyes are bound to keep anyone who sees them mesmerised. Intense Black All it takes is a glide of this pencil over your lash lines to make your eyes radiate confidence. 100% Suitable Eye makeup got you teary? Not anymore, as this kajal is safe for your eyes. Long-lasting It stays on for up to 12 hours, and it is smudge-free, so you can now avoid having to check for makeup smears around your eyes whenever you head to the restroom.",
        170,
        "https://rukminim1.flixcart.com/image/832/832/jy3anbk0/eye-liner/g/6/t/0-35-new-york-colossal-kajal-s-maybelline-original-imaeftkg6wgcxynz.jpeg?q=70",
        5, KajalAndMakeup);
    KajalAndMakeupArray[5] = new Product("Lakme Insta Eye Liner 9 ml  (Black)",
        "Define the outline of your eyes with some Color, with the Lakme Insta Liner. This eyeliner is endowed with a water-resistant formula that also makes it last longer. The deep intense color of this Lakme Insta Liner accentuates your eye makeup and adds a dash of dramatic beauty and glamour to them. The smooth Brush applies the liner over your eye lids in an even stroke and can be used for various looks you want to create. The Lakme Insta Liner comes in a transparent glass bottle with a sturdy screw type lid and is easy to carry in your bag and perfect for an instant touch up. The Lakme Insta Liner is light-weight and is a comfortable eye makeup for perfect definition. Its water resistant formula ensures no smudging or smearing, and it's deep intense color that does not fade. It is a perfect daily wear eyeliner! Lakme is one of India's leading color cosmetic brands offering a wide range of high-end, world-class color cosmetics and skincare products. Lakme has a vast product range specially crafted by experts for the Indian skin. The brand has also been redefining fashion in India for over 15 years with Lakme Fashion Week, India's premier fashion event.",
        117,
        "https://rukminim1.flixcart.com/image/832/832/jqpiqvk0/eye-liner/z/q/m/9-insta-eye-liner-lakme-original-imafcnzejpjw3btx.jpeg?q=70",
        2, KajalAndMakeup);
    KajalAndMakeupArray[6] = new Product("Lakme True Wear Nail Color 404",
        "Add a stroke of vibrancy and elegance with this Lakme True Wear Nail Color Reds & Maroons. With resin-based Color-lock technology, this nail color stays on for a long period. Contains Resins with Color-lock Technology You don’t have to worry about applying the nail color frequently, as this technology makes sure the nail color stays on for a longer period. Strengthens Nails The long-lasting nail enamel strengthens your nails and makes them chip-resistant.",
        110,
        "https://rukminim1.flixcart.com/image/832/832/jesunbk0/nail-polish/z/j/z/9-true-wear-nail-color-lakme-original-imaffuyg57m3982t.jpeg?q=70",
        5, KajalAndMakeup);
    KajalAndMakeupArray[7] = new Product("Lakme True Wear Color Crush 27",
        "This Lakme True Wear Color Crush nail polish adds a touch of spark to your nails, giving them a vibrant and elegant look. The Color Lock Technology makes it stay on for a long period. Flaunt your dazzling nails in any occasion and be ready to impress. Color Lock Technology It contains resins with Color Lock technology which makes the colour to stay for a long time and not fade away. Strengthens Your Nails The long-lasting, chip-resistant nail enamel strengthens your nails. Silk Sheen Coat your nails to perfection, giving them a vibrant and elegant silk sheen.",
        153,
        "https://rukminim1.flixcart.com/image/832/832/jesunbk0/nail-polish/q/8/v/9-true-wear-color-crush-lakme-original-imaffuygg3wzfw5y.jpeg?q=70",
        2, KajalAndMakeup);
    KajalAndMakeupArray[8] = new Product("Lakme 9 to 5 Primer  Matte Lip Color  (Maroon Mix, 3.6 g)",
        "Get those gorgeous lips that you have always dreamt of with this 9 to 5 Lip Color from Lakme. For board meetings or dinner dates, you can dab on this primer  matte lip color that will stay put on your lips for up to 12 hours. Long-lasting Matte Finish No more frequent touch-ups, as the built-in primer in this Lakme lip color ensures that the color stays on your lips for up to 12 hours. Smooth Application The smooth and creamy finish of this lip color will give you a rich and intense shade, without making your lips crease.",
        480,
        "https://rukminim1.flixcart.com/image/832/832/jvgzl3k0/lipstick/c/w/j/3-6-9-to-5-primer-plus-matte-lip-color-lakme-original-imaetvqtpfcfyu2g.jpeg?q=70",
        4, KajalAndMakeup);
    KajalAndMakeupArray[9] = new Product("Lakme Radiance Complexion Compact  (Pearl, 9 g)",
        "Look picture perfect with the Lakm Radiance Complexion Compact. Use this dynamic compact by Lakme and get a glowing complexion in an instant. Enriched with skin replenishing qualities of Vitamin E and C, it adds nourishment to your makeup! This compact keeps skin smooth and soft with its advanced Micromesh and Allantoin complex formula. The Lakm Radiance Complexion Compact is available in an easy to carry pack and you can use it even when you are in a hurry! It nourishes and moisturizes your skin, with the advanced Mircromesh technology which gives your face a matte finish, while the Allantoin complex soothes your skin and protects it from pollution.Whether you are heading to work or a special occasion, this Lakm Radiance Complexion Compact is sure to give your face that flawless and gorgeous look every single day. Go buy it now for the perfect addition to your makeup kit. Lakm is one of India's leading color cosmetic brands offering a wide range of high-end, world-class color cosmetics and skincare products. Lakm has a vast product range specially crafted by experts for the Indian skin. The brand has also been redefining fashion in India for over 15 years with Lakm Fashion Week, India's premier fashion event.",
        145,
        "https://rukminim1.flixcart.com/image/832/832/jqpiqvk0/compact/y/d/z/9-radiance-complexion-compact-lakme-original-imafcnze5mvpzt74.jpeg?q=70",
        2, KajalAndMakeup);
    KajalAndMakeupArray[10] = new Product("Maybelline New York Lip Gradation Lipstick  (Red 801 (Red 2), 1.25 g)",
        "Whether you’re going for a formal occasion or a casual occasion, dress your lips with this lip gradation from Maybelline New York and make a style statement. With a Red 2 shade, it can be a stylish way to colour your lips. Matte Finish This lip gradation has a creamy form and gives your lips matte finish, so you can flaunt that perfect pout. It is double-sided, so you can use one end to add a gorgeous tinge of colour to your lips, while the other end can be used to smudge it till the contours of your lips.",
        539,
        "https://rukminim1.flixcart.com/image/832/832/k2p1q4w0/lipstick/q/f/p/1-25-new-york-lip-gradation-lipstick-maybelline-original-imafhzg98dqyachu.jpeg?q=70",
        5, KajalAndMakeup);
    KajalAndMakeupArray[11] = new Product("Lakme 9 to 5 Flawless Matte Complexion Compact  (Melon, 8 g)",
        "Get that radiant look with this 9 to 5 Flawless Matte Complexion Compact from Lakme. This compact will enhance the beauty of your skin tone and will give you a natural complexion that is oil-free and even-toned. Thanks to its vitamin E and oil absorbing formula, this Lakme compact will nourish your skin and also hide dark spots. Matte Finish The matte texture of this compact will give you an even-toned and flawless look that will last all day long. Nourishes and Conditions the Skin It is infused with vitamin E and unique oil absorbing formula to nourish your skin and to give it a dazzling radiance. It blends evenly into your complexion and can also be used as a concealer to hide spots and freckles. Easy to Apply This compact comes with a mirror and a soft sponge, so you can easily use it at any time of the day.",
        450,
        "https://rukminim1.flixcart.com/image/832/832/jl5h3m80/compact/y/h/e/8-9-to-5-flawless-matte-complexion-lakme-original-imaewnag2g9yj8wg.jpeg?q=70",
        5, KajalAndMakeup);

    MasalasAndSpicesArray[0] = new Product("Kohinoor Punjabi Paneer Butter Masala  (15 g)",
        "The smell of fresh paneer butter masala being cooked is heavenly for those who are hardcore paneer fans. This Punjabi paneer butter masala from Kohinoor will take your taste buds on a joy ride. Lavish Spread Do you have guests coming over but not enough time to cook dinner? Cook up some rich and yummy paneer butter masala in no time. Smoky Flavour The smoky flavour of Kasoor methi will add a great finishing touch to the mouth-watering paneer butter masala gravy.",
        10,
        "https://rukminim1.flixcart.com/image/832/832/jynat8w0/spice-masala/y/h/z/15-punjabi-paneer-butter-masala-pouch-kohinoor-powder-original-imafgu3uzbfbd3d7.jpeg?q=70",
        2, MasalasAndSpices);
    MasalasAndSpicesArray[1] = new Product("Kohinoor Lazeez Sabzi Masala  (40 g)",
        "Some good veggies and a pinch of this Kohinoor Lazeez Sabzi Masala are all you need for a flavourful meal that everyone will love. Rich Aroma and Flavour With the perfect blend of 17 spices, this masala can instantly turn any bland dish into a delectable delight. Granular Texture It blends easily into most of your recipes, enhancing their taste and flavor.",
        27,
        "https://rukminim1.flixcart.com/image/832/832/jyt0knk0/spice-masala/h/r/n/40-lazeez-sabzi-masala-pouch-kohinoor-powder-original-imafgu3vyg9ztngc.jpeg?q=70",
        3, MasalasAndSpices);
    MasalasAndSpicesArray[2] = new Product("Flipkart Supermart Select Cardamom (Elaichi Black)  (100 g)",
        "The queen of spices - cardamom is a highly fragrant native Indian spice that adds a complex mix of citrusy, minty,  and herbal flavours all at the same time. Apart from its lingering pleasant aroma, it also contains vitamins and minerals, including riboflavin, niacin, vitamin C, iron, manganese and more to assist against heartburns and constipation. Flipkart Supermart Cardamoms are strong in flavour and aroma. They make sure your special dishes not only taste rich, but also have an inviting fragrance. Sourced from the finest traditional farms, our professionals handpick these Select produce carefully to ensure that the maximum nutrition from the farm reaches your food. Through multiple quality checks, cleaning and advanced packaging, Flipkart Supermart Select ensures an enhanced shelf-life while preserving the healthy, natural taste of the produce. So go ahead and enjoy a healthy, hearty meal with your family.",
        142,
        "https://rukminim1.flixcart.com/image/832/832/jhs0o7k0/spice-masala/f/m/3/20-cardamom-elaichi-black-pouch-flipkart-supermart-select-whole-original-imaff7dn8utzdhzu.jpeg?q=70",
        5, MasalasAndSpices);
    MasalasAndSpicesArray[3] = new Product("Kohinoor Mumbai Pav Bhaji Masala  (15 g)",
        "Indulge in the real flavours of pav bhaji by bringing home this packet of Kohinoor Mumbai Pav Bhaji Masala. For a Lip-smacking Delight This masala helps you prepare delicious pav bhajis with the same tanginess that you’d find in the authentic ones in the streets of Mumbai.",
        10,
        "https://rukminim1.flixcart.com/image/832/832/jynat8w0/spice-masala/a/e/c/15-mumbai-pav-bhaji-masala-pouch-kohinoor-powder-original-imafgu3u8tqvzdap.jpeg?q=70",
        1, MasalasAndSpices);
    MasalasAndSpicesArray[4] = new Product("Flipkart Supermart Select Cardamom (Elaichi Green)  (100 g)",
        "The queen of spices - cardamom is a highly fragrant native Indian spice that adds a complex mix of citrusy, minty,  and herbal flavours all at the same time. Apart from its lingering pleasant aroma, it also contains vitamins and minerals, including riboflavin, niacin, vitamin C, iron, manganese and more to assist against heartburns and constipation. Flipkart Supermart Cardamoms are strong in flavour and aroma. They make sure your special dishes not only taste rich, but also have an inviting fragrance. Sourced from the finest traditional farms, our professionals handpick these Select produce carefully to ensure that the maximum nutrition from the farm reaches your food. Through multiple quality checks, cleaning and advanced packaging, Flipkart Supermart Select ensures an enhanced shelf-life while preserving the healthy, natural taste of the produce. So go ahead and enjoy a healthy, hearty meal with your family.",
        420,
        "https://rukminim1.flixcart.com/image/832/832/jhs0o7k0/spice-masala/f/j/s/20-cardamom-elaichi-green-pouch-flipkart-supermart-select-whole-original-imaff7yyugjgqrzx.jpeg?q=70",
        5, MasalasAndSpices);
    MasalasAndSpicesArray[5] = new Product("Kohinoor Amritsari Tandoori Chicken Masala  (15 g)",
        "Are you in love with Tandoori Chicken? If yes, the bring home this Kohinoor Tandoori Chicken masala and enjoy these orange and spicy party favourites, all day and every day. Crafted By Experts This Kohinoor Tandoori Chicken masala was crafted by food experts, who blended together a series of aromatic spices to ensure that you get restaurant-grade food at home. Authentic Taste This masala has been created to offer you the taste of authentic Tandoori Chicken, so that you can enjoy your favourite appetizer at all times.",
        10,
        "https://rukminim1.flixcart.com/image/832/832/jynat8w0/spice-masala/v/2/u/15-amritsari-tandoori-chicken-masala-pouch-kohinoor-powder-original-imafgu3uzpjavfye.jpeg?q=70",
        1, MasalasAndSpices);
    MasalasAndSpicesArray[6] = new Product("Kohinoor Kashmiri Meat Masala  (15 g)",
        "With Kohinoor Kashmiri Meat Masala, you can whip up a delicious meal for your near and dear ones. Follow the instructions on the package or follow your family recipe to add that oomph factor to the flavourful dish that you can prepare with this masala powder. Enough for a Small Family This masala pouch can help you prepare your favourite meat dish and serve it to a group of 3-4 people. Lip-smacking Taste at Home Cover the meat with this tasteful masala to prepare a restaurant-worthy dish in the comfort of your home.",
        14,
        "https://rukminim1.flixcart.com/image/832/832/jynat8w0/spice-masala/w/j/q/15-kashmiri-meat-masala-pouch-kohinoor-powder-original-imafgu3t7pv8sygh.jpeg?q=70",
        2, MasalasAndSpices);
    MasalasAndSpicesArray[7] = new Product("Kohinoor Garam Masala-E-Khaas  (Airtight Glass Bottle Free)  (90 g)",
        "With this Kohinoor Garam Masala E-khaas as your secret ingredient, you can turn any recipe into a delicacy. Go ahead and show some love to the food you’re cooking; sprinkle this masala into curries and biryanis. A Unique Blend of 9 Aromatic Spices Infuse everyday dishes, such as curries, biryanis, and veggies with an authentic Indian taste simply by flavouring them with this masala. It is enriched with the intense flavour of green cardamom (which is revered to be ‘the queen of spices’) along with other aromatic ingredients.",
        97,
        "https://rukminim1.flixcart.com/image/832/832/jynat8w0/spice-masala/k/s/v/90-garam-masala-e-khaas-box-kohinoor-powder-original-imafgu3uthtgxmzz.jpeg?q=70",
        4, MasalasAndSpices);
    MasalasAndSpicesArray[8] = new Product("Maggi Magic Cubes Vegetarian Masala  (40 g)",
        "Add this Maggi Magic Cubes Vegetarian Masala to your recipes and make them taste all the more flavourful and delectable. Combination of Spices With its rich blend of spices and ingredients, this masala will add a yummy taste to almost all your food. Ideal for Curries and Rice Dishes Whether you’re preparing biryani or aloo-matar curry, this masala can instantly add a magical taste to your recipe.",
        34,
        "https://rukminim1.flixcart.com/image/832/832/jsdj8nk0/spice-masala/c/h/k/40-magic-cubes-vegetarian-masala-pouch-maggi-cubes-original-imafdyzpkrckjggp.jpeg?q=70",
        1, MasalasAndSpices);
    MasalasAndSpicesArray[9] = new Product("Kohinoor Punjabi Butter Chicken Masala  (15 g)",
        "Entice your senses with the stimulating aroma and unforgettable taste of butter chicken by cooking this dish at home with the Kohinoor Punjabi Butter Chicken Masala sachet. Authentic Creamy Gravy Watch juicy chicken pieces simmer in this authentic creamy gravy that will delight your taste buds to have a taste of it. Single Serve Sachet This masala mix from Kohinoor is enough to make a bowl of delicious gravy that can serve three to four people.",
        10,
        "https://rukminim1.flixcart.com/image/832/832/jynat8w0/spice-masala/a/s/e/15-punjabi-butter-chicken-masala-pouch-kohinoor-powder-original-imafgu3tmhspjhjp.jpeg?q=70",
        3, MasalasAndSpices);
    MasalasAndSpicesArray[10] = new Product("Kohinoor Hyderabadi Biryani Masala  (15 g)",
        "Is it getting cumbersome for you to prepare biryani? Bring home this Kohinoor Hyderabadi Biryani Masala that gives you the authentic taste of Hyderabadi biryani. The flavour it provides will make you feel like your biryani has come from the kitchen of a Nizam.",
        10,
        "https://rukminim1.flixcart.com/image/832/832/jynat8w0/spice-masala/j/k/v/15-hyderabadi-biryani-masala-pouch-kohinoor-powder-original-imafgu3txc69egby.jpeg?q=70",
        1, MasalasAndSpices);
    MasalasAndSpicesArray[11] = new Product("Flipkart Supermart Select Turmeric (Haldi Sticks)  (100 g)",
        "Turmeric is an age old ingredient - it is an excellent source for iron, manganese, vitamin B6, dietary fiber, copper, and potassium. Turmeric offers multiple anti-oxidising, anti-inflammatory and antiseptic applications and has numerous other benefits. With Flipkart Supermart Turmeric, we strive to provide the multi-utility turmeric in its pure form so that your everyday cooking has the boost of immunity and goodness of nature. Sourced from the finest traditional farms, our professionals handpick these Select produce carefully to ensure that the maximum nutrition from the farm reaches your food. Through multiple quality checks, cleaning and advanced packaging, Flipkart Supermart Select ensures an enhanced shelf-life while preserving the healthy, natural taste of the produce. So go ahead and enjoy a healthy, hearty meal with your family.",
        40,
        "https://rukminim1.flixcart.com/image/832/832/jc0ttow0/spice-masala/b/m/b/200-turmeric-haldi-sticks-pouch-flipkart-supermart-select-whole-original-imaff793j8g8dyfg.jpeg?q=70",
        3, MasalasAndSpices);

    RepellantsAndFreshenersArray[0] = new Product("Odonil Zipper Soulful Jasmine Blocks (Pack of 6)  (60 g)",
        "The sweet and sensuous fragrance of Jasmine will calm your senses and soothe your soul. It will bring calmness and serenity to your home and make it truly Soulful!",
        270,
        "https://rukminim1.flixcart.com/image/832/832/k34rki80/air-freshener/y/y/h/60-zipper-bar-odonil-zipper-original-imafmbj9frkyrmds.jpeg?q=70",
        4, RepellantsAndFresheners);
    RepellantsAndFreshenersArray[1] = new Product("Odonil Jasmine Fresh Spray  (153 g)",
        "Unlike fragrance oil diffusers, Odonil Room Freshener Sprays can be used at anytime, anywhere in your home. Just spray it and transform the mood of your family members. This variant lifts moods with the fun-loving yet timeless aroma of Jasmine as it cascades in a floral mist around your home.",
        134,
        "https://rukminim1.flixcart.com/image/832/832/k2m6ufk0/air-freshener/c/r/n/153-room-spray-liquid-odonil-original-imafhx8k97wmkbna.jpeg?q=70",
        3, RepellantsAndFresheners);
    RepellantsAndFreshenersArray[2] = new Product("Odonil Sandal Bouquet Spray  (153 g)",
        "Unlike fragrance oil diffusers, Odonil Room Freshener Sprays can be used at anytime, anywhere in your home. Just spray it and transform the mood of your family members. This warm and cosy sandalwood scent will truly make any home a heavenly abode.",
        134,
        "https://rukminim1.flixcart.com/image/832/832/k2m6ufk0/air-freshener/s/a/5/153-room-spray-sandal-bouquet-liquid-odonil-original-imafhx8kkahby7wb.jpeg?q=70",
        4, RepellantsAndFresheners);
    RepellantsAndFreshenersArray[3] = new Product("Odonil Citrus Fresh Spray  (153 g)",
        "Unlike fragrance oil diffusers, Odonil Room Freshener Sprays can be used at anytime, anywhere in your home. Just spray it and transform the mood of your family members. This Citrus fragrance injects an invigorating fizz into the air for a sparkling, radiant home atmosphere.",
        134,
        "https://rukminim1.flixcart.com/image/832/832/k2m6ufk0/air-freshener/6/z/x/153-room-spray-liquid-odonil-original-imafhx8kt9a5myhd.jpeg?q=70",
        1, RepellantsAndFresheners);
    RepellantsAndFreshenersArray[4] = new Product("Airwick Turquoise Oasis Refill  (250 ml)",
        "The right fragrance has the power to change the mood, bring back nostalgia, and relax your senses. With the Airwick Turquoise Oasis Spray, you will feel relaxed the moment you step inside your home. Apart from spreading aromatic fragrance, it neutralizes odours to make your home smell fresh and clean. Up to 2400 Sprays This home freshener has up to 2400 sprays per refill. Neutralises Odours It neutralizes odours to make your home smell better. Lasts Up to 60 Days One spray can will keep your home smelling pleasantly fragrant for up to 60 days. Natural Scents This Airwick spray smells like sun-bleached driftwood, salty sea spray, and a warm breeze, leaving behind a warm and refreshing aroma.",
        269,
        "https://rukminim1.flixcart.com/image/832/832/j431rbk0/air-freshener/c/m/t/250-fresh-matic-refill-life-scents-liquid-airwick-original-imaev2tgrr9uzxyu.jpeg?q=70",
        5, RepellantsAndFresheners);
    RepellantsAndFreshenersArray[5] = new Product("Odonil Rose Garden Spray  (153 g)",
        "Unlike fragrance oil diffusers, Odonil Room Freshener Sprays can be used at anytime, anywhere in your home. Just spray it and transform the mood of your family members. This Mystic Rose scent the fills the air with the enchanting and enigmatic aroma of rose petals.",
        134,
        "https://rukminim1.flixcart.com/image/832/832/k2m6ufk0/air-freshener/u/x/z/153-room-spray-liquid-odonil-original-imafhx8kkuztzc8n.jpeg?q=70",
        4, RepellantsAndFresheners);
    RepellantsAndFreshenersArray[6] = new Product("Odonil Lavender Mist Spray  (240 ml)",
        "Unlike fragrance oil diffusers, Odonil Room Freshener Sprays can be used at anytime, anywhere in your home. Just spray it and transform the mood of your family members. This variant lets you experience the calming aroma of Lavender, well-known in aromatherapy for its soothing effects.",
        134,
        "https://rukminim1.flixcart.com/image/832/832/k2m6ufk0/air-freshener/m/8/e/240-room-spray-liquid-odonil-original-imafhx8kcbzqc6ja.jpeg?q=70",
        5, RepellantsAndFresheners);
    RepellantsAndFreshenersArray[7] = new Product("Airwick Citrus Splash Blocks (Pack of 2)  (100 g)",
        "Let the refreshing aroma of Airwick Citrus Splash Blocks make your bathroom smell nice and fresh, always. The nature-inspired fragrance of this bathroom essential is locked in two different compartments to ensure that it lasts for 30 days. Nature-inspired Fragrance Whether you're taking a shower or brushing your teeth, the refreshing nature-inspired aroma in your bathroom will give a rejuvenating start to your mornings. This air freshener contains up to 33% more fragrance than the regular bathroom air fresheners. Drives Away Odours This Airwick bathroom essential also drives away unpleasant odour to make your bathroom smell clean and hygienic. Lasts for up to 30 Days It keeps your bathroom feel fresh for up to 30 days.",
        117,
        "https://rukminim1.flixcart.com/image/832/832/ju04akw0/air-freshener/c/b/j/100-everfresh-gel-gel-airwick-original-imaff7z5zcrbjhzh.jpeg?q=70",
        4, RepellantsAndFresheners);
    RepellantsAndFreshenersArray[8] = new Product("Odonil Zipper Blissful Citrus Blocks (Pack of 6)  (60 g)",
        "The sparkling fresh citrus is sure to invigorate the senses. Its aroma not just promises to uplift the mood but also makes you feel blissful!",
        280,
        "https://rukminim1.flixcart.com/image/832/832/k37mg7k0/air-freshener/g/v/2/60-zipper-bar-odonil-zipper-original-imafmcz9pevzxbya.jpeg?q=70",
        3, RepellantsAndFresheners);
    RepellantsAndFreshenersArray[9] = new Product("Odonil Zipper Joyful Lavender Blocks (Pack of 6)  (60 g)",
        "The elegant everlasting fragrance of lavender transcends you to a new level. The aromatic freshness of Lavender will certainly leave you Joyful!.",
        265,
        "https://rukminim1.flixcart.com/image/832/832/jr58l8w0/air-freshener/y/u/6/60-bar-zipper-odonil-original-imafdyhkcsjeymhg.jpeg?q=70",
        3, RepellantsAndFresheners);
    RepellantsAndFreshenersArray[10] = new Product("Airwick Freshmatic Summer Delights Automatic Spray  (250 ml)",
        "Bring home the AirWick Freshmatic Summer Delights Automatic Spray, and redefine your home with the scents of White Florals, Sweet Melon and Subtle Vanilla. This air freshener device releases bursts of fresh fragrance throughout the day to keep your home smelling wonderful. It comes with infused with Life Scents - a multi-layered fragrance that is constantly changing to give you a true-to-life experience right at home. AirWick Freshmatic - Automatic Freshness Its one-of-a-kind perfunctory air freshener device releases bursts of fresh fragrance, automatically, throughout the day to keep your surroundings smelling fresh at all times. Also, each spray is a controlled dose so that the smell is not overwhelming for you. Easy to Use All you have to do is insert the refill, along with the batteries, and set the timer. With every burst of the refreshing fragrance, your home smells clean and fresh at all times. You can now control the fragrance’s intensity as it comes with three time settings that give you the option to choose the time interval for the spray - every 10 minutes, 28 minutes and 38 minutes. Slim Design It is compact so that you can place it anywhere in your home. Each refill lasts up to 60 days at a low-fragrance intensity setting.   Life Scents By constantly changing, this fragrance creates a true-to-life experience right at home. This multi-layered scent will make your house feel like home. The ever-changing fragrances give a fresh lift to your surroundings that will help you define your home. Rich Palette of Fragrances The essential oils, extracted from fruits, flowers and plants, infused in this multi-layered fragrance will help uplift your mood at home. Explore the playful and fun scents of white florals, sweet melon and subtle vanilla.",
        495,
        "https://rukminim1.flixcart.com/image/832/832/jzog9e80/air-freshener/f/m/x/250-freshmatic-complete-kit-liquid-airwick-original-imafjnypawshnh5p.jpeg?q=70",
        4, RepellantsAndFresheners);
    RepellantsAndFreshenersArray[11] = new Product("Airwick Velvet Rose Blocks  (50 g)",
        "Keep your bathroom smelling fresh throughout the day with this Airwick EverFresh Gel. With its rich palette of fragrances, this freshener will offer a soothing and revitalizing feeling every time you step into your bathroom. Nature-inspired Fragrances It's filled with nature-inspired fragrances that are locked in two separate compartments, ensuring up to 30 days of freshness. Drives Away Odors This Airwick EverFresh Gel comes with the boosting fragrance of roses, so you can bid adieu to odors and keep your bathroom smelling good at all times.",
        123,
        "https://rukminim1.flixcart.com/image/832/832/j3vwk280/air-freshener/p/g/h/50-gel-everfresh-gel-airwick-original-imaeux9hjrrnabm3.jpeg?q=70",
        1, RepellantsAndFresheners);

    RiceAndRiceProductsArray[0] = new Product("Kohinoor Dubar Basmati Rice (Medium Grain)  (5 kg)",
        "The Kohinoor Dubar Basmati Rice lends a tasty and delicious touch to your everyday meals. Aged Naturally This rice is naturally aged because of which it gets its distinct taste and flavour. Also, it is carefully processed in a high-quality manufacturing facility. This process accentuates the rich aroma of the rice and makes your meals yummier. Half the Length The length of this rice is half the length of a full basmati grain, so you can use it to prepare rice-based dishes every day and even for special occasions.",
        399,
        "https://rukminim1.flixcart.com/image/832/832/jqpiqvk0/rice/x/v/f/5-white-dubar-basmati-rice-bag-kohinoor-original-imafcnv3hh899c72.jpeg?q=70",
        2, RiceAndRiceProducts);
    RiceAndRiceProductsArray[1] = new Product("Kohinoor Super Value Basmati Rice (Long Grain)  (5 kg)",
        "Enhance the taste of rice-based dishes, easily, by using the Kohinoor Super Value Basmati Rice. Carefully Selected Grains The grains are carefully picked out as per the length and aroma. So, you can enjoy even the simplest of meals such as lentils and rice with delight, as the taste of this rice adds more flavour to the meal. Rich Aroma This rice is processed in a high-quality manufacturing facility, which helps it to retain its aroma and flavour.",
        715,
        "https://rukminim1.flixcart.com/image/832/832/jt641ow0/rice/z/n/d/5-super-value-white-basmati-rice-bag-kohinoor-original-imafekrbnczxhnfy.jpeg?q=70",
        5, RiceAndRiceProducts);
    RiceAndRiceProductsArray[2] = new Product("Kohinoor Brown Basmati Rice (Medium Grain)  (1 kg)",
        "Include delectable dishes without compromising on your diet with this packet of Kohinoor Authentic Brown Basmati Rice. Wholesome Packed with natural nutrients, texture and flavour, brown basmati rice is considered to be wholesome as the wholeness is still intact, unlike other polished rice. Flavoursome Besides it being a healthy option, this brown basmati rice can be used to make delicious dishes like biryani, Yakhni pulao, fried rice, etc.",
        149,
        "https://rukminim1.flixcart.com/image/832/832/j3q6snk0/rice/x/x/h/1-brown-basmati-rice-jar-basmati-rice-vacuum-pack-kohinoor-original-imaeurzffrvxnp3p.jpeg?q=70",
        2, RiceAndRiceProducts);
    RiceAndRiceProductsArray[3] = new Product("Kohinoor Charminar Rozana Rice (Medium Grain)  (1 kg)",
        "Kohinoor Charminar - Rozana Basmati Rice (Medium Grain) (1 kg) Get the Kohinoor Charminar Rozana Basmati Rice and enjoy making rice-based dishes, such as biryani, fried rice and pulao at home. Flavoursome and Aromatic The Kohinoor Charminar Rozana Basmati Rice is aromatic, tasty and easy to prepare. Non-sticky Texture Known for its non-sticky texture, basmati rice is one of the most revered forms of rice in terms of aroma, taste and texture.",
        89,
        "https://rukminim1.flixcart.com/image/832/832/jynat8w0/rice/4/c/t/1-white-charminar-rozana-basmati-rice-pouch-kohinoor-original-imafgu3sezvwyge9.jpeg?q=70",
        3, RiceAndRiceProducts);
    RiceAndRiceProductsArray[4] = new Product("Kohinoor Super Silver Basmati Rice (Long Grain)  (1 kg)",
        "Make your favourite rice-based dishes, such as fried rice and biryanis with this packet of the Kohinoor Super Silver Basmati Rice. Delectable to Taste Easy to prepare and aromatic, this high-quality rice helps in enhancing the flavours of your homemade dishes. Naturally Aged Rice The Kohinoor Super Silver Basmati Rice has been aged for 12 months to give you the mouth-watering and flavoursome experience.",
        139,
        "https://rukminim1.flixcart.com/image/832/832/jynat8w0/rice/z/g/c/1-white-super-silver-basmati-rice-pouch-kohinoor-original-imafgu7wagzjdgmg.jpeg?q=70",
        4, RiceAndRiceProducts);
    RiceAndRiceProductsArray[5] = new Product("Kohinoor Charminar Rice (Long Grain)  (1 kg)",
        "The Nizams were famous for their larger-than-life way of living, and their exquisite and delectable cuisine. The Charminar Long Grain Rice is a tribute to the royal and flavourful taste of Nizami cuisine. Distinct Blend This high-quality, long-grained rice is distinctly blended, which adds to its taste. Ideal for Special Occasions T hrow a royal feast by treating your guests with rice-based dishes prepared using this rice. It is ideal for dishes that are cooked in bulk. ",
        75,
        "https://rukminim1.flixcart.com/image/832/832/jqpiqvk0/rice/f/8/u/1-white-charminar-plain-rice-pouch-kohinoor-original-imafcnv3evrukfb7.jpeg?q=70",
        3, RiceAndRiceProducts);
    RiceAndRiceProductsArray[6] = new Product("Kohinoor Charminar Brown Rice  (1 kg)",
        "The Charminar Brown Rice is, both, healthy and yummy. You can eat lip-smacking rice-based dishes, while at the same time also keep your calorie count in check. Mild and Nutty Flavour This brown rice is fluffy in texture and comes with a mild and nutty flavour. This distinct flavour adds more aroma and taste to your rice-based meals. Healthy Choice These rice grains come in a whole-grain size because of which the nutritious properties stay intact. So, you no longer have to compromise on your diet by skipping rice-based recipes.",
        89,
        "https://rukminim1.flixcart.com/image/832/832/jqpiqvk0/rice/t/t/b/1-brown-charminar-plain-rice-pouch-kohinoor-original-imafcnv3et3kbdf8.jpeg?q=70",
        5, RiceAndRiceProducts);
    RiceAndRiceProductsArray[7] = new Product("Kohinoor Charminar Everyday Rice (Broken)  (5 kg)",
        "The Charminar Everyday Rice is ideal for regular consumption. From special dishes such as Biryani and Pulao to the simplest of dishes like steamed rice, you can prepare them all by using this brand of rice. Also, you can buy it without any qualms about biting a hole in your purse, as it is pocket-friendly. Specially Processed This rice has been specially processed so that you can utilize it for everyday consumption. Cook Delicious Dishes The high-quality taste of this rice adds rich and mouth-watering flavor to any rice-based dish. You can easily prepare delicious rice-based recipes at home, instead of ordering from outside and savor it with your family and friends.",
        299,
        "https://rukminim1.flixcart.com/image/832/832/jqpiqvk0/rice/z/s/m/5-white-charminar-everyday-plain-rice-bag-kohinoor-original-imafcnv3nw3mrutm.jpeg?q=70",
        2, RiceAndRiceProducts);
    RiceAndRiceProductsArray[8] = new Product("Kohinoor Authentic Platinum Basmati Rice (Long Grain)  (5 kg)",
        "Kohinoor Authentic Platinum Basmati Rice (Long Grain) (1 kg) Treat your loved ones to some delectable dishes made using this pack of Kohinoor Traditional Authentic Basmati Rice. Full of Flavour Packed with flavour and easy to prepare, the Kohinoor Platinum Basmati Rice is a real treat for your tastebuds. Traditionally Aged This packet of basmati rice has been aged for 24 months to give it a distinct, nutty flavour. Get ready for some fragrant and delicious dishes made with the Kohinoor Authentic Platinum Basmati Rice.",
        875,
        "https://rukminim1.flixcart.com/image/832/832/jynat8w0/rice/u/u/h/5-white-authentic-platinum-basmati-rice-bag-kohinoor-original-imafgu3tzqfgm3pg.jpeg?q=70",
        4, RiceAndRiceProducts);
    RiceAndRiceProductsArray[9] = new Product("Kohinoor Royale Authentic Biryani Basmati Rice (Long Grain)  (5 kg)",
        "Kohinoor Royale Authentic Basmati Rice (Long Grain) (1 kg) Whether it’s biryani, peas pulao or fried rice, this packet of Kohinoor will give you the perfect consistency and taste. Perfect for All Occasions This packet of Kohinoor Royale Authentic Basmati Rice is great for everyday use and for special occasions as well. Long Grains The long grains look great, taste delectable and complement your side dishes as well.",
        499,
        "https://rukminim1.flixcart.com/image/832/832/jqpiqvk0/rice/t/6/z/5-white-royale-authentic-basmati-rice-bag-kohinoor-original-imafcnv32hme2ggp.jpeg?q=70",
        4, RiceAndRiceProducts);
    RiceAndRiceProductsArray[10] = new Product("Kohinoor Tibar Basmati Rice (Medium Grain)  (5 kg)",
        "Kohinoor Tibar Basmati Rice (Medium Grain) (1 kg) Prepare mouth-watering meals for your family by using a pack of Kohinoor Tibar Basmati Rice. Naturally Aged Naturally aged and processed, this basmati rice uses a superior-grade manufacturing facility to give it a delightful aroma and distinctive taste. Long Grains Perfect for biryani and pulao, the grains of the Kohinoor Tibar Basmati Rice is long and fulfilling.",
        589,
        "https://rukminim1.flixcart.com/image/832/832/jqpiqvk0/rice/e/y/3/5-white-tibar-basmati-rice-bag-kohinoor-original-imafcnv38hrfyyha.jpeg?q=70",
        3, RiceAndRiceProducts);
    RiceAndRiceProductsArray[11] = new Product("Kohinoor Charminar Select Basmati Rice (Medium Grain)  (5 kg)",
        "You can cook delectable dishes such as biryani and pulao, like a pro, by using the Kohinoor Charminar Select Basmati Rice. It tastes flavourful and has a distinct aroma, owing to which Kohinoor has dedicated this rice to the rich flavours of Nizami cuisine. Long and Delicate Grains The grains are processed with expertise, which helps them to retain their flavour and aroma. Enjoy Royal Food Everyday Now, literally, eat like a king or queen by enjoying rice-based dishes that are prepared by using this Kohinoor basmati rice. The distinct flavour adds more taste to the dish and also lends it a royal touch.",
        449,
        "https://rukminim1.flixcart.com/image/832/832/jqpiqvk0/rice/k/s/j/5-white-charminar-select-basmati-rice-bag-kohinoor-original-imafcnv3zrhydjnf.jpeg?q=70",
        2, RiceAndRiceProducts);

    ShavingNeedsArray[0] = new Product("AXE Denim After Shave Lotion  (100 ml)",
        "Don’t let shaving leave your skin dry and rough. This Axe Denim After Shave Lotion, with its nourishing formula, will come to your rescue. Its rich and masculine fragrance will keep you feeling fresh, while its calming properties will soothe your skin. Spicy and Masculine Scent A spicy, rich, masculine cologne scent with bursts of citrus gives you a day-long fresh feeling. Safe for Skin Designed for your facial skin, this lotion will leave your skin soft and fresh. Clean and Sleek Look A splash of this lotion is all you need to get a clean shave and to smell fresh.",
        184,
        "https://rukminim1.flixcart.com/image/832/832/j9n3ekw0/aftershave-lotion/w/v/h/100-denim-after-shave-lotion-axe-original-imaezphfpmhphdcn.jpeg?q=70",
        3, ShavingNeeds);
    ShavingNeedsArray[1] = new Product("Gillette Mach3 Start Manual Razor",
        "Gillette Mach3 Start mens razor features 3 blades for better comfort (vs. any ordinary razor), as well as a 360 Aqua Grip handle for total control, even when wet. The razor features a Lubrication Strip that helps your Start razor glide across your skin with comfort. The Mach3 Start has a Front Pivot that transfers pressure of your hand away from the blades for better skin comfort. Additionally, 10 Soft Microfins gently stretch the skin to create a smooth, even surface for a comfortable shave.",
        169,
        "https://rukminim1.flixcart.com/image/832/832/jnyxd3k0/shaving-razor/x/u/m/mach3-start-men-s-razor-handle-1-gillette-original-imafaj3ghtg5cezh.jpeg?q=70",
        1, ShavingNeeds);
    ShavingNeedsArray[2] = new Product("Nivea Men Sensitive Cooling After Shave Lotion  (100 ml)",
        "Looking for something cool and refreshing for your just-shaved skin? Try using this distinctively fragrant after-shave lotion from Nivea that will not only soothe and calm your skin, but also stimulate your senses with its refreshing notes. Alcohol-free This fast-absorbing lotion does not contain any alcohol-based ingredient that can irritate or burn your skin post shaving. In fact, it is a non-greasy blend of cooling agents that will alleviate any redness or dryness, and can be used on a daily basis.",
        181,
        "https://rukminim1.flixcart.com/image/832/832/jtbtt3k0/aftershave-lotion/t/x/f/100-sensitive-cooling-after-shave-lotion-nivea-men-original-imafeph7gggxtkzq.jpeg?q=70",
        5, ShavingNeeds);
    ShavingNeedsArray[3] = new Product("AXE Temptation After Shave Lotion  (100 ml)",
        "The AXE Temptation Aftershave Lotion has a heavenly chocolate scent that makes it masculine and irresistible. It will leave you feeling fresh and attractive the whole day. Invigorating Aroma If you’re looking for a refreshing and divine aftershave lotion that stimulates your senses, the AXE Temptation Aftershave Lotion offers value for money. Super-soft Skin Your skin will feel soft and stay moisturised throughout the day with regular usage of this product. The iconic fragrances will make sure that you not only look chic after your shave but also smell great.",
        184,
        "https://rukminim1.flixcart.com/image/832/832/jl16s280/aftershave-lotion/f/5/k/100-temptation-after-shave-lotion-axe-original-imaf84jzbqk9vfjt.jpeg?q=70",
        5, ShavingNeeds);
    ShavingNeedsArray[4] = new Product("Gillette Venus Razor11",
        "What It Is Gives your a close smooth shave. What It Does It offers precision edging blade for close shave. It is made for crisp lines and even trimming. It provides comfortable and close shave. Dermatologically tested and body approved.",
        213,
        "https://rukminim1.flixcart.com/image/832/832/jp4d4sw0/shaving-razor/c/h/m/venus-razor11-1-gillette-original-imafbfnuebxfgkqf.jpeg?q=70",
        3, ShavingNeeds);
    ShavingNeedsArray[5] = new Product("Gillette Venus Hair Removal Razor for Women",
        "Designed for women, Gillette Venus glides smoothly along your curves and leaves with you smooth Venus skin. Simply apply water and soap, glide Venus against the direction of hair growth and then wash and apply your favorite moisturizer!",
        213,
        "https://rukminim1.flixcart.com/image/832/832/jnyxd3k0/shaving-razor/e/z/a/venus-hair-removal-razor-for-women-1-gillette-original-imafaj3gjphuhscm.jpeg?q=70",
        4, ShavingNeeds);
    ShavingNeedsArray[6] = new Product("Gillette Fusion Power",
        "Get a refreshed and well-groomed look after every shave with Gillette’s Fusion Power Razor. Precision Trimmer Allows To Shave Tricky Places The trimmer is designed excellently and allows smooth shave and reaches all the tricky places.  5 Blades Help To Supply a Closer and More Comfortable Shave A closer and comfortable shave is possible with this razor that comes with 5 blades. Ergonomic Handle Provides Better Control In Wet Conditions The handle of the razor is designed ergonomically and provides good grip even when it is wet. Lubrastrip Delivers Incredible Glide Delivering a smooth and incredible glide, this razor comes with a lubrastrip. Power Function Reduces Friction During Shave The power function of this razor reduces cuts and frictions during shave.",
        430,
        "https://rukminim1.flixcart.com/image/832/832/j3orcsw0/shaving-razor/z/u/z/fusion-power-1-gillette-original-imaeurgewrc7x2vy.jpeg?q=70",
        1, ShavingNeeds);
    ShavingNeedsArray[7] = new Product("Gillette Venus Breeze Hair Removal Razor for Women",
        "Gillette Venus Breeze is the perfect solution for smooth and easy hair removal. Simply apply water, glide Venus Breeze against the direction of hair growth and then wash and apply your favorite moisturizer! The in-built gel bars with avocado oil for glide and freesia scent contain rich body butters and leave you with your smooth Venus skin in a few minutes!",
        269,
        "https://rukminim1.flixcart.com/image/832/832/jnyxd3k0/shaving-razor/d/r/p/venus-breeze-hair-removal-razor-for-women-1-gillette-original-imafaj3faa9gb8fr.jpeg?q=70",
        2, ShavingNeeds);
    ShavingNeedsArray[8] = new Product("Nivea Men Deep Impact Comfort After Shave Lotion  (100 ml)",
        "Shield your skin against irritation with this after-shave lotion from NIVEA. It comes infused with a comforting, antibacterial formula that helps your skin recover quickly after a shave. It leaves behind a woody masculine fragrance on your skin. Also, it is dermatologically tested to be safe on your skin. Comforting, Antibacterial Formula The powerful formula incorporated protects and comforts the skin after your shave. Non-drying and Quick Recovery This after-shave lotion prevents your skin from drying out, and helps your skin recover quickly after a shave. Impactful Fragrance It leaves behind a woody masculine fragrance on your skin to keep you prepared for a deep impact. Dermatologically Safe It is dermatologically proven to be safe on your sensitive skin.",
        179,
        "https://rukminim1.flixcart.com/image/832/832/jgwkzgw0/aftershave-lotion/n/m/k/100-deep-impact-after-shave-lotion-nivea-men-original-imaf4se4y67amnvy.jpeg?q=70",
        4, ShavingNeeds);
    ShavingNeedsArray[9] = new Product("Gillette Arctic Ice After Shave Splash  (100 ml)",
        "Start your day with a gush of the fresh Arctic breeze as it wakes you up and leaves you feeling refreshed and energised for the rest of your day. There are so many things you need to take care of before you leave the house all ready to start your day’s work, make sure you take good care of your skin as well. Men’s skin, though tougher and thicker, is subject to more damage because shaving opens up the pores of your skin  leaving it exposed to dirt and sun rays that can cause skin irritation. The Gillette After Shave Arctic Ice treats your skin with extra care after every shave. Your skin’s makeup changes every time you shave because the top layer is stripped off along with the hair, with this after shave lotion you can now make sure that your skin is nourished. This Gillette after shave provides an invisible layer of protection that shields your skin against the environmental factors that could cause your skin any damage. The long-lasting fragrance of the Gillette Arctic Ice leaves you feeling fresh all day long so you can feel confident and be at your best. This after shave ensures that your skin is kept soft always free from burning and redness due to dry skin. The razor takes away all the moisture from your skin and this after shave hydrates it so your skin remains moisturized all day long.",
        459,
        "https://rukminim1.flixcart.com/image/832/832/jiulk7k0/aftershave-splash/w/f/t/100-arctic-ice-after-shave-splash-gillette-original-imaf6jyyadg2dggh.jpeg?q=70",
        1, ShavingNeeds);

    SoapsAndBodyWashArray[0] = new Product("Nivea Waterlily & Oil Care Shower Gel  (250 ml)",
        "With the NIVEA Waterlilly and Oil shower gel soft, supple and gentle skin will be all yours. Its care oil pearls will keep your skin moisturized.  Start on a Fresh Note This shower gel will leave your body with the invigorating scent of the waterlily flower, thereby keeping you fresh all day long. Skin That’s Clean and Balanced This shower gel’s effective cleansing formula will keep your skin clean and balanced. Skin That’s Soft and Supple This shower gel has been enriched with care oil pearls that moisturize your skin, thereby making it soft and supple.",
        181,
        "https://rukminim1.flixcart.com/image/832/832/jtbtt3k0/body-wash/q/b/g/250-waterlily-oil-care-shower-gel-nivea-original-imafeph7hkaunnvz.jpeg?q=70",
        1, SoapsAndBodyWash);
    SoapsAndBodyWashArray[1] = new Product("Nivea Creme Soft Shower Gel  (250 ml)",
        "Enjoy the joy of feeling fresh with this NIVEA Creme Soft Shower Cream. This shower cream has been enriched with almond oil which helps keep your skin feeling soft and moisturized while leaving a mild scent behind. Gentle Protection and Cleaning This shower cream is enriched with the natural goodness of almond oil that gently cleanses your skin and keeps nourished. Hydration for Your Skin The Hydra IQ moisture technology in the Creme Soft Shower Cream keeps your skin feeling hydrated and cared for while maintaining your skin's ph balance.",
        159,
        "https://rukminim1.flixcart.com/image/832/832/jtbtt3k0/body-wash/b/x/b/250-creme-soft-shower-gel-nivea-original-imafeph7g7hgszk7.jpeg?q=70",
        1, SoapsAndBodyWash);
    SoapsAndBodyWashArray[2] = new Product("Set Wet Studio X Body Wash For Men - Refresh  (180 ml)",
        "Celebs are always ahead of the trend-setting curve with their dapper and suave looks, all thanks to expert styling. Its their X factor that separates the best from the rest! Set Wet Studio X, co-created with top celeb stylist Aalim Hakim is that X factor for your daily grooming routine. An expert grooming range for men who want to sport that celeb look everyday. Keep your style game effortlessly on point. Take the spotlight and be the trend. Welcome to tropical woes where the early morning post-shower freshness barely stays through the day. But hey, we've got you covered! Say hello to Studio X Refresh Body Wash For Men. It elevates your mood and makes you feel alive. Time to feel the celebrity vibe that lasts all day! Benefits : Co-created with top Celebrity Stylist Aalim Hakim to give you expert grooming - so that you can look and feel like a celeb everyday Set wet Studio X body wash for men- Refresh, unleashes a rush of cool aqua fragrance It consists of menthol which gives a mad burst of cooling to your body This men's body wash helps cleansing your body effectively It helps keep you refresh whole day long with a long lasting fragrance This body wash for men is effective even in the most humid conditions and is suitable for all skin types",
        159,
        "https://rukminim1.flixcart.com/image/832/832/jvtujrk0/body-wash/d/w/g/180-body-wash-for-men-refresh-set-wet-studio-x-original-imaffvhpgu3rbrba.jpeg?q=70",
        4, SoapsAndBodyWash);
    SoapsAndBodyWashArray[3] = new Product("Dove Pink Rosa Beauty Bathing Bar  (Rs 29 Savings Pack)  (3 x 100 g)",
        "We think that skin cleansing should be an act of beauty for your skin that leaves it feeling soft and cared for. And Dove Pink Rosa Beauty Bar also has a delicate blush of color that adds a touch of feminine sophistication to your bathroom. That�s combined with our � moisturizing cream to create a beauty bar that helps nourish your skin during cleansing. Dove Beauty Bars are specially formulated to deliver skin-natural nourishment, helping your skin to keep its natural moisture during cleansing. Dove Pink Rosa Beauty Bar contains our ultra-mild cleansers, which don�t strip skin of moisture like a regular soap bar can. It�s mild enough to be used on your face, body and hands � the perfect addition to your daily skin cleansing routine. Dove is the No.1 Brand recommended by dermatologists in India. For best results, lather up your Dove Beauty Bar and massage the smooth, creamy lather over your face and body before rinsing thoroughly. For soft, smooth hands, you can also enjoy regular hand-washing throughout the day with your Dove bar. Soap may dry out your hands, but the classic moisturizing formula of Dove bars will leave skin softer, smoother and more glowing. Buy Now!",
        172,
        "https://rukminim1.flixcart.com/image/832/832/soap/n/s/c/dove-300-pink-rosa-beauty-bathing-bar-3x100-g-original-imaeprzhnvceqayd.jpeg?q=70",
        2, SoapsAndBodyWash);
    SoapsAndBodyWashArray[4] = new Product("St. Ives Soothing Oatmeal & Shea Butter Body Wash  (400 ml)",
        "Keep calm and soothe on! Our Soothing Oatmeal and Shea Butter Body Wash gently cleanses skin with a rich, soothing lather. This is a creamy body wash infused with oatmeal and Shea butter extract that helps to restore your natural glow with every wash. Made with 100% natural extracts (oatmeal and Shea butter) it'll cleanse your skin with a sumptuous, soothing lather.",
        319,
        "https://rukminim1.flixcart.com/image/832/832/jwkzwy80/body-wash/2/b/r/400-soothing-oatmeal-shea-butter-body-wash-st-ives-original-imafh7kzzng6yf2q.jpeg?q=70",
        4, SoapsAndBodyWash);
    SoapsAndBodyWashArray[5] = new Product("Nivea Men Vitality Fresh Shower Gel  (250 ml)",
        "Recharge your mind and body with the 3-in-1 hydrating Nivea Men Vitality Fresh shower gel. This shower gel consists of vitalizing ocean minerals and gives you an uplifting fragrance Effective Cleansing Your skin will be deeply cleansed and you'll feel recharged, thanks to the effective cleansing formula of this shower gel.   Long-lasting Freshness The long-lasting freshness of this shower gel is attributed to the fragrance of menthol and water mint in its specialized formula. Care for Your Skin The rich foam formula of the Nivea Men Vitality Fresh shower gel hydrates your skin and takes good care of it.  ",
        181,
        "https://rukminim1.flixcart.com/image/832/832/jtbtt3k0/body-wash/a/k/d/250-vitality-fresh-shower-gel-nivea-men-original-imafeph7kkwqz3pu.jpeg?q=70",
        5, SoapsAndBodyWash);
    SoapsAndBodyWashArray[6] = new Product("Garnier Skin Naturals, Light Complete Face Wash  (100 g)",
        "Rescue your skin from the destructive effects of the sun’s rays and ensure absolute health and maximum beauty by using this Garnier White Complete Fairness Face Wash. Enriched with Pure Lemon Essence     Mild bleaching agents of pure lemon essence present themselves in this face wash so every wash after sun exposure takes off as much tan as possible. Improves Skin Complexion       When sun tan is removed from your skin, your complexion will improve and you will enjoy flaunting brighter, fairer skin. Tested by Dermatologists The face wash has been tested by dermatologists to ensure that the product is absolutely safe on your skin.              Gently Exfoliates Wash your face regularly and you will see how your face enjoys a radiant glow because the face wash removes dead cells and impurities effectively to keep your skin deeply cleansed and exfoliated.",
        144,
        "https://rukminim1.flixcart.com/image/832/832/k2p1q4w0/face-wash/z/t/f/100-skin-naturals-light-complete-face-wash-garnier-original-imafhzhqh4hg5avs.jpeg?q=70",
        3, SoapsAndBodyWash);
    SoapsAndBodyWashArray[7] = new Product("Fiama Patchouli and Macadamia Shower Gel  (185 ml)",
        "Wash away the troubles of your day, with the foamy, fresh, and fun Fiama Shower Gel. And while you enjoy your Fiama bath, let its skin-conditioners work their magic to give your skin a soft glow. This Patchouli and Macademia shower gel makes your day bright and shiny with its fruity, floral fragrance. It is filled with natural goodness, which gives you soft glowing skin and an indulgent experience. So get ready to let your bath, take care of you after a rough day.",
        87,
        "https://rukminim1.flixcart.com/image/832/832/jvtujrk0/body-wash/j/r/p/185-patchouli-and-macadamia-shower-gel-fiama-original-imafgggfavtjvhsv.jpeg?q=70",
        1, SoapsAndBodyWash);
    SoapsAndBodyWashArray[8] = new Product("Nivea Fresh Pure Care Shower Gel  (500 ml)",
        "Enjoy the joy of feeling fresh with this NIVEA Nivea Fresh Pure Shower Gel. This shower gel has been enriched with sea minerals which helps keep your skin feeling soft and moisturized while leaving a mild scent behind. Freshness That Lasts Enjoy the invigorating aquatic scent keeps you feeling fresh during and after the shower. Effective Cleansing and Care This shower gel is enriched with sea minerals that cleanses your skin better than soap while maintaining your skin’s pH balance.",
        317,
        "https://rukminim1.flixcart.com/image/832/832/jtbtt3k0/body-wash/s/g/v/500-fresh-pure-care-shower-gel-nivea-original-imafeph7g9jksfrq.jpeg?q=70",
        3, SoapsAndBodyWash);
    SoapsAndBodyWashArray[9] = new Product("Garnier Men Power White Anti-Pollution Double Action Face Wash  (50 g)",
        "Garnier Men PowerWhite FaceWash cleanses deeply removing oil, dirt and pollution. As a result skin looks more even, radiant & feels fresh all day. Simply massage on wet face & rinse with water. Use twice, daily. Garnier Men is India's No. 1 Men's FaceWash Brand*",
        81,
        "https://rukminim1.flixcart.com/image/832/832/jsm3vrk0/face-wash/q/b/p/50-power-white-double-action-garnier-men-original-imafe5bymx3ecyny.jpeg?q=70",
        3, SoapsAndBodyWash);
    SoapsAndBodyWashArray[10] = new Product("Biotique Bio Honey Cream Body Wash  (190 ml)",
        "Biotique Bio Honey Cream 100 % Soap Free Body Wash﻿ is a gel based is a blend of pure honey, winter cherry, galangal, coconut oil and soap nut, to cleanse and help brighten skin for a fresher, fairer, body finish. Lathers into rich suds that rinse off completely, without disturbing the skin’s natural pH balance.﻿ Biotique products are made incorporating the ancient ayurvedic therapies along with the latest bio-technological innovations to bring to you cosmetics and skin care product that are toxic free and have been dermatologically tested to be completely safe.﻿﻿﻿ The products, apart from being organically pure, are also preservative free and devoid of any strong chemicals.",
        171,
        "https://rukminim1.flixcart.com/image/832/832/jq2np8w0/body-wash/r/u/w/190-bio-honey-cream-body-wash-biotique-original-imafc64fxfuqzgdg.jpeg?q=70",
        5, SoapsAndBodyWash);
    SoapsAndBodyWashArray[11] = new Product("Nivea Men All-In-1 Oil Control Face Wash  (150 ml)",
        "NIVEA MEN ALL-IN-1 Face Wash, now in a convenient and reclosable Pump Pack. It's the first male face wash in India in a pump pack. A face wash that solves multiple problems on your face like dark spots, acne and excess oil. More convenient than traditional tubes, its re-closable feature also means it can be used on the go.",
        257,
        "https://rukminim1.flixcart.com/image/832/832/jgpfs7k0/face-wash/z/3/9/150-oil-control-all-in-one-nivea-men-original-imaf4vvfpcehdj3q.jpeg?q=70",
        1, SoapsAndBodyWash);

    BabyBathAndSkinCare.setProducts(Arrays.asList(BabyBathAndSkinCareArray));
    Beverages.setProducts(Arrays.asList(BeveragesArray));
    BreakfastCereals.setProducts(Arrays.asList(BreakfastCerealsArray));
    CookingSaucesAndVinegar.setProducts(Arrays.asList(CookingSaucesAndVinegarArray));
    CreamsLotionsSkinCare.setProducts(Arrays.asList(CreamsLotionsSkinCareArray));
    Dairy.setProducts(Arrays.asList(DairyArray));
    DeosPerfumesAndTalc.setProducts(Arrays.asList(DeosPerfumesAndTalcArray));
    DetergentsAndLaundry.setProducts(Arrays.asList(DetergentsAndLaundryArray));
    DiapersAndWipes.setProducts(Arrays.asList(DiapersAndWipesArray));
    FloorAndOtherCleaners.setProducts(Arrays.asList(FloorAndOtherCleanersArray));
    GheeAndOils.setProducts(Arrays.asList(GheeAndOilsArray));
    HairCare.setProducts(Arrays.asList(HairCareArray));
    HealthandWellness.setProducts(Arrays.asList(HealthandWellnessArray));
    HouseholdCareAndPetFood.setProducts(Arrays.asList(HouseholdCareAndPetFoodArray));
    KajalAndMakeup.setProducts(Arrays.asList(KajalAndMakeupArray));
    MasalasAndSpices.setProducts(Arrays.asList(MasalasAndSpicesArray));
    RepellantsAndFresheners.setProducts(Arrays.asList(RepellantsAndFreshenersArray));
    RiceAndRiceProducts.setProducts(Arrays.asList(RiceAndRiceProductsArray));
    ShavingNeeds.setProducts(Arrays.asList(ShavingNeedsArray));
    SoapsAndBodyWash.setProducts(Arrays.asList(SoapsAndBodyWashArray));

    categoryRepository.save(BabyBathAndSkinCare);
    categoryRepository.save(Beverages);
    categoryRepository.save(BreakfastCereals);
    categoryRepository.save(CookingSaucesAndVinegar);
    categoryRepository.save(CreamsLotionsSkinCare);
    categoryRepository.save(Dairy);
    categoryRepository.save(DeosPerfumesAndTalc);
    categoryRepository.save(DetergentsAndLaundry);
    categoryRepository.save(DiapersAndWipes);
    categoryRepository.save(FloorAndOtherCleaners);
    categoryRepository.save(GheeAndOils);
    categoryRepository.save(HairCare);
    categoryRepository.save(HealthandWellness);
    categoryRepository.save(HouseholdCareAndPetFood);
    categoryRepository.save(KajalAndMakeup);
    categoryRepository.save(MasalasAndSpices);
    categoryRepository.save(RepellantsAndFresheners);
    categoryRepository.save(RiceAndRiceProducts);
    categoryRepository.save(ShavingNeeds);
    categoryRepository.save(SoapsAndBodyWash);

    // Loading Customer Data
    Customer customer;
    Cart cart;
    List<Order> orders;
    customer = customerRepository.save(new Customer("James", "james@email.com", passwordEncoder.encode("jamespassword"),
        "209558", LocalDateTime.now().minusMinutes(16444)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[11], 4));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[6], 3));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(199408)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[1], 3));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[1], 3));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(128236)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(BabyBathAndSkinCareArray[2], 10));
    cart.addProductToCart(new CartItem(BabyBathAndSkinCareArray[7], 4));
    cart.addProductToCart(new CartItem(BabyBathAndSkinCareArray[10], 8));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[3], 8));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[1], 3));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[5], 2));
    cart.addProductToCart(new CartItem(HairCareArray[8], 10));
    cart.addProductToCart(new CartItem(HairCareArray[9], 7));
    cart.addProductToCart(new CartItem(HairCareArray[7], 7));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(184557)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[7], 3));
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[5], 10));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[3], 3));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[7], 2));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[5], 3));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(80945)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Robert", "robert@email.com",
        passwordEncoder.encode("robertpassword"), "216444", LocalDateTime.now().minusMinutes(76616)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[10], 3));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[10], 3));
    cart.addProductToCart(new CartItem(KajalAndMakeupArray[11], 5));
    cart.addProductToCart(new CartItem(KajalAndMakeupArray[11], 9));
    cart.addProductToCart(new CartItem(KajalAndMakeupArray[7], 8));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[1], 1));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(143250)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(RepellantsAndFreshenersArray[7], 2));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[0], 4));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[1], 8));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[0], 3));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[3], 9));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(33077)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(HouseholdCareAndPetFoodArray[0], 8));
    cart.addProductToCart(new CartItem(HouseholdCareAndPetFoodArray[0], 6));
    cart.addProductToCart(new CartItem(HouseholdCareAndPetFoodArray[6], 5));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[9], 6));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[3], 2));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[2], 6));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[3], 9));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(133445)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("John", "john@email.com", passwordEncoder.encode("johnpassword"),
        "7587", LocalDateTime.now().minusMinutes(124220)));
    orders = new ArrayList<Order>();

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Michael", "michael@email.com",
        passwordEncoder.encode("michaelpassword"), "122185", LocalDateTime.now().minusMinutes(236129)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[0], 7));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(39756)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[1], 10));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(112947)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("David", "david@email.com", passwordEncoder.encode("davidpassword"),
        "44206", LocalDateTime.now().minusMinutes(252562)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(DairyArray[0], 9));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(26137)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(DetergentsAndLaundryArray[7], 2));
    cart.addProductToCart(new CartItem(DetergentsAndLaundryArray[5], 5));
    cart.addProductToCart(new CartItem(HouseholdCareAndPetFoodArray[4], 7));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(5081)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[3], 4));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[3], 5));
    cart.addProductToCart(new CartItem(BeveragesArray[2], 5));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(32472)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("William", "william@email.com",
        passwordEncoder.encode("williampassword"), "97648", LocalDateTime.now().minusMinutes(74826)));
    orders = new ArrayList<Order>();

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Richard", "richard@email.com",
        passwordEncoder.encode("richardpassword"), "123568", LocalDateTime.now().minusMinutes(220594)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[6], 5));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[3], 8));
    cart.addProductToCart(new CartItem(KajalAndMakeupArray[8], 1));
    cart.addProductToCart(new CartItem(KajalAndMakeupArray[0], 9));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(62967)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Joseph", "joseph@email.com",
        passwordEncoder.encode("josephpassword"), "256345", LocalDateTime.now().minusMinutes(236961)));
    orders = new ArrayList<Order>();

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Thomas", "thomas@email.com",
        passwordEncoder.encode("thomaspassword"), "190454", LocalDateTime.now().minusMinutes(227633)));
    orders = new ArrayList<Order>();

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Charles", "charles@email.com",
        passwordEncoder.encode("charlespassword"), "18", LocalDateTime.now().minusMinutes(76258)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[8], 6));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[3], 10));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[0], 10));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[2], 4));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[1], 4));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(5)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Christopher", "christopher@email.com",
        passwordEncoder.encode("christopherpassword"), "198487", LocalDateTime.now().minusMinutes(95288)));
    orders = new ArrayList<Order>();

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Daniel", "daniel@email.com",
        passwordEncoder.encode("danielpassword"), "163065", LocalDateTime.now().minusMinutes(69425)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(KajalAndMakeupArray[1], 3));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(83823)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[0], 7));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[6], 9));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[1], 7));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(56713)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(GheeAndOilsArray[6], 8));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[2], 5));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[3], 3));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[4], 7));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[1], 2));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[3], 10));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[2], 5));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(130384)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Matthew", "matthew@email.com",
        passwordEncoder.encode("matthewpassword"), "80782", LocalDateTime.now().minusMinutes(87144)));
    orders = new ArrayList<Order>();

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Anthony", "anthony@email.com",
        passwordEncoder.encode("anthonypassword"), "58293", LocalDateTime.now().minusMinutes(70523)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(BeveragesArray[6], 6));
    cart.addProductToCart(new CartItem(BeveragesArray[2], 1));
    cart.addProductToCart(new CartItem(BeveragesArray[10], 10));
    cart.addProductToCart(new CartItem(BabyBathAndSkinCareArray[2], 10));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[8], 6));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[6], 9));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[2], 3));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(43074)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[6], 10));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[10], 6));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[1], 4));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(31284)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[10], 9));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[9], 8));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[8], 10));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(19330)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(RepellantsAndFreshenersArray[4], 8));
    cart.addProductToCart(new CartItem(RepellantsAndFreshenersArray[7], 7));
    cart.addProductToCart(new CartItem(RepellantsAndFreshenersArray[6], 3));
    cart.addProductToCart(new CartItem(HouseholdCareAndPetFoodArray[3], 7));
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[1], 3));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(13097)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Mark", "mark@email.com", passwordEncoder.encode("markpassword"),
        "139237", LocalDateTime.now().minusMinutes(103121)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[10], 4));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[0], 6));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[5], 8));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(14457)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[3], 2));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[4], 2));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[4], 1));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[8], 6));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[9], 4));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(88526)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(HairCareArray[4], 10));
    cart.addProductToCart(new CartItem(HairCareArray[11], 9));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(92129)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Donald", "donald@email.com",
        passwordEncoder.encode("donaldpassword"), "110402", LocalDateTime.now().minusMinutes(4512)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(BabyBathAndSkinCareArray[11], 10));
    cart.addProductToCart(new CartItem(BabyBathAndSkinCareArray[0], 6));
    cart.addProductToCart(new CartItem(BabyBathAndSkinCareArray[9], 3));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[9], 8));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(16605)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[2], 3));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[10], 2));
    cart.addProductToCart(new CartItem(DiapersAndWipesArray[0], 7));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(84635)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Steven", "steven@email.com",
        passwordEncoder.encode("stevenpassword"), "16176", LocalDateTime.now().minusMinutes(59841)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(BabyBathAndSkinCareArray[7], 6));
    cart.addProductToCart(new CartItem(HairCareArray[9], 4));
    cart.addProductToCart(new CartItem(HairCareArray[8], 2));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[2], 1));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[2], 8));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(249)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(DairyArray[5], 8));
    cart.addProductToCart(new CartItem(DairyArray[3], 2));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[5], 1));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[2], 6));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[1], 4));
    cart.addProductToCart(new CartItem(SoapsAndBodyWashArray[11], 10));
    cart.addProductToCart(new CartItem(SoapsAndBodyWashArray[1], 4));
    cart.addProductToCart(new CartItem(SoapsAndBodyWashArray[1], 8));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(156)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[6], 5));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[1], 6));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[6], 7));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(13976)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Paul", "paul@email.com", passwordEncoder.encode("paulpassword"),
        "107590", LocalDateTime.now().minusMinutes(215022)));
    orders = new ArrayList<Order>();

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Andrew", "andrew@email.com",
        passwordEncoder.encode("andrewpassword"), "44805", LocalDateTime.now().minusMinutes(25415)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(DetergentsAndLaundryArray[5], 4));
    cart.addProductToCart(new CartItem(DetergentsAndLaundryArray[4], 9));
    cart.addProductToCart(new CartItem(DetergentsAndLaundryArray[8], 1));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[2], 10));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[2], 9));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[9], 2));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(40499)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[7], 8));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[0], 8));
    cart.addProductToCart(new CartItem(SoapsAndBodyWashArray[0], 2));
    cart.addProductToCart(new CartItem(SoapsAndBodyWashArray[7], 5));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(4379)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[7], 1));
    cart.addProductToCart(new CartItem(ShavingNeedsArray[9], 7));
    cart.addProductToCart(new CartItem(ShavingNeedsArray[3], 6));
    cart.addProductToCart(new CartItem(ShavingNeedsArray[2], 3));
    cart.addProductToCart(new CartItem(SoapsAndBodyWashArray[5], 10));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(33255)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Joshua", "joshua@email.com",
        passwordEncoder.encode("joshuapassword"), "28093", LocalDateTime.now().minusMinutes(19482)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(BeveragesArray[6], 9));
    cart.addProductToCart(new CartItem(BeveragesArray[8], 9));
    cart.addProductToCart(new CartItem(BeveragesArray[0], 5));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[2], 2));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[6], 3));
    cart.addProductToCart(new CartItem(HouseholdCareAndPetFoodArray[2], 4));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(8818)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[3], 9));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[10], 8));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[0], 10));
    cart.addProductToCart(new CartItem(DiapersAndWipesArray[11], 3));
    cart.addProductToCart(new CartItem(DiapersAndWipesArray[1], 2));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[0], 5));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[10], 3));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(3846)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(BeveragesArray[9], 3));
    cart.addProductToCart(new CartItem(KajalAndMakeupArray[3], 4));
    cart.addProductToCart(new CartItem(KajalAndMakeupArray[0], 4));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[0], 2));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[4], 1));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[6], 9));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(22125)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(RepellantsAndFreshenersArray[2], 7));
    cart.addProductToCart(new CartItem(RepellantsAndFreshenersArray[10], 4));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(646)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Kenneth", "kenneth@email.com",
        passwordEncoder.encode("kennethpassword"), "80245", LocalDateTime.now().minusMinutes(136020)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[7], 1));
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[3], 4));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(57327)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Kevin", "kevin@email.com", passwordEncoder.encode("kevinpassword"),
        "149553", LocalDateTime.now().minusMinutes(53617)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(KajalAndMakeupArray[5], 4));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[9], 3));
    cart.addProductToCart(new CartItem(ShavingNeedsArray[1], 1));
    cart.addProductToCart(new CartItem(ShavingNeedsArray[8], 5));
    cart.addProductToCart(new CartItem(ShavingNeedsArray[5], 3));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(53550)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Brian", "brian@email.com", passwordEncoder.encode("brianpassword"),
        "200186", LocalDateTime.now().minusMinutes(185727)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(DairyArray[0], 3));
    cart.addProductToCart(new CartItem(DairyArray[4], 5));
    cart.addProductToCart(new CartItem(DetergentsAndLaundryArray[1], 8));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(197280)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[2], 3));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(75605)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[10], 2));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(15649)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(ShavingNeedsArray[1], 7));
    cart.addProductToCart(new CartItem(ShavingNeedsArray[3], 6));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(185189)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("George", "george@email.com",
        passwordEncoder.encode("georgepassword"), "91322", LocalDateTime.now().minusMinutes(196953)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(ShavingNeedsArray[3], 4));
    cart.addProductToCart(new CartItem(ShavingNeedsArray[5], 2));
    cart.addProductToCart(new CartItem(ShavingNeedsArray[5], 9));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[2], 1));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[4], 8));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[8], 8));
    cart.addProductToCart(new CartItem(DairyArray[1], 7));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(25461)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Timothy", "timothy@email.com",
        passwordEncoder.encode("timothypassword"), "120631", LocalDateTime.now().minusMinutes(238583)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(DetergentsAndLaundryArray[2], 6));
    cart.addProductToCart(new CartItem(BeveragesArray[9], 6));
    cart.addProductToCart(new CartItem(BeveragesArray[0], 7));
    cart.addProductToCart(new CartItem(BeveragesArray[9], 9));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(28475)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(GheeAndOilsArray[6], 3));
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[5], 1));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(90773)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[4], 7));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[1], 10));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[6], 7));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(48394)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(SoapsAndBodyWashArray[2], 5));
    cart.addProductToCart(new CartItem(SoapsAndBodyWashArray[5], 2));
    cart.addProductToCart(new CartItem(SoapsAndBodyWashArray[2], 9));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[5], 3));
    cart.addProductToCart(new CartItem(DetergentsAndLaundryArray[7], 10));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(29201)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Ronald", "ronald@email.com",
        passwordEncoder.encode("ronaldpassword"), "156261", LocalDateTime.now().minusMinutes(20375)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[0], 2));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[7], 1));
    cart.addProductToCart(new CartItem(DiapersAndWipesArray[11], 9));
    cart.addProductToCart(new CartItem(DiapersAndWipesArray[0], 2));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(65166)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(HairCareArray[11], 2));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(120542)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Edward", "edward@email.com",
        passwordEncoder.encode("edwardpassword"), "71633", LocalDateTime.now().minusMinutes(247869)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(HealthandWellnessArray[10], 8));
    cart.addProductToCart(new CartItem(HealthandWellnessArray[5], 7));
    cart.addProductToCart(new CartItem(HealthandWellnessArray[0], 8));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(71203)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(BeveragesArray[6], 2));
    cart.addProductToCart(new CartItem(BeveragesArray[10], 4));
    cart.addProductToCart(new CartItem(BeveragesArray[9], 5));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[1], 2));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[10], 5));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[9], 3));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(21514)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Jason", "jason@email.com", passwordEncoder.encode("jasonpassword"),
        "253876", LocalDateTime.now().minusMinutes(197760)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[7], 9));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[9], 6));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[10], 8));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(46698)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(DiapersAndWipesArray[10], 2));
    cart.addProductToCart(new CartItem(DiapersAndWipesArray[6], 4));
    cart.addProductToCart(new CartItem(BeveragesArray[9], 8));
    cart.addProductToCart(new CartItem(BeveragesArray[1], 6));
    cart.addProductToCart(new CartItem(BeveragesArray[5], 7));
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[4], 4));
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[2], 8));
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[8], 3));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(67862)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Jeffrey", "jeffrey@email.com",
        passwordEncoder.encode("jeffreypassword"), "239680", LocalDateTime.now().minusMinutes(54782)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(DiapersAndWipesArray[7], 9));
    cart.addProductToCart(new CartItem(HouseholdCareAndPetFoodArray[1], 8));
    cart.addProductToCart(new CartItem(HouseholdCareAndPetFoodArray[4], 2));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(158417)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(DiapersAndWipesArray[10], 5));
    cart.addProductToCart(new CartItem(DiapersAndWipesArray[2], 3));
    cart.addProductToCart(new CartItem(DiapersAndWipesArray[5], 5));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[10], 8));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(62985)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[5], 6));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[0], 5));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[4], 5));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(134652)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[1], 10));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(29638)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Ryan", "ryan@email.com", passwordEncoder.encode("ryanpassword"),
        "41681", LocalDateTime.now().minusMinutes(222809)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(GheeAndOilsArray[4], 3));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[1], 4));
    cart.addProductToCart(new CartItem(DiapersAndWipesArray[6], 9));
    cart.addProductToCart(new CartItem(DiapersAndWipesArray[3], 6));
    cart.addProductToCart(new CartItem(DiapersAndWipesArray[7], 10));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(40404)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Mary", "mary@email.com", passwordEncoder.encode("marypassword"),
        "89904", LocalDateTime.now().minusMinutes(76058)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[3], 1));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[1], 8));
    cart.addProductToCart(new CartItem(HairCareArray[11], 1));
    cart.addProductToCart(new CartItem(HairCareArray[7], 5));
    cart.addProductToCart(new CartItem(HairCareArray[4], 8));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(1819)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Patricia", "patricia@email.com",
        passwordEncoder.encode("patriciapassword"), "106090", LocalDateTime.now().minusMinutes(239433)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[2], 7));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[7], 6));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(59765)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[6], 2));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[3], 6));
    cart.addProductToCart(new CartItem(ShavingNeedsArray[4], 3));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(5578)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[7], 8));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[6], 10));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[9], 1));
    cart.addProductToCart(new CartItem(KajalAndMakeupArray[0], 5));
    cart.addProductToCart(new CartItem(KajalAndMakeupArray[3], 3));
    cart.addProductToCart(new CartItem(KajalAndMakeupArray[6], 3));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[3], 1));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(1358)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Jennifer", "jennifer@email.com",
        passwordEncoder.encode("jenniferpassword"), "89821", LocalDateTime.now().minusMinutes(52168)));
    orders = new ArrayList<Order>();

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Linda", "linda@email.com", passwordEncoder.encode("lindapassword"),
        "63143", LocalDateTime.now().minusMinutes(88485)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[5], 5));
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[6], 8));
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[4], 6));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(14525)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[1], 7));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(51847)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(BeveragesArray[7], 5));
    cart.addProductToCart(new CartItem(BeveragesArray[1], 7));
    cart.addProductToCart(new CartItem(BeveragesArray[2], 1));
    cart.addProductToCart(new CartItem(HairCareArray[9], 6));
    cart.addProductToCart(new CartItem(HairCareArray[2], 2));
    cart.addProductToCart(new CartItem(HairCareArray[1], 5));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[5], 2));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[7], 7));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[3], 5));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(44501)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Elizabeth", "elizabeth@email.com",
        passwordEncoder.encode("elizabethpassword"), "153833", LocalDateTime.now().minusMinutes(256901)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(HouseholdCareAndPetFoodArray[4], 4));
    cart.addProductToCart(new CartItem(HouseholdCareAndPetFoodArray[5], 2));
    cart.addProductToCart(new CartItem(HouseholdCareAndPetFoodArray[6], 10));
    cart.addProductToCart(new CartItem(DairyArray[5], 9));
    cart.addProductToCart(new CartItem(DairyArray[4], 2));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[2], 7));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[5], 6));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(152181)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(DairyArray[1], 1));
    cart.addProductToCart(new CartItem(DairyArray[2], 6));
    cart.addProductToCart(new CartItem(DairyArray[5], 6));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(44037)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[2], 10));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(149482)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(KajalAndMakeupArray[1], 3));
    cart.addProductToCart(new CartItem(HealthandWellnessArray[5], 1));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(50879)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Barbara", "barbara@email.com",
        passwordEncoder.encode("barbarapassword"), "97169", LocalDateTime.now().minusMinutes(123739)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[5], 4));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[7], 9));
    cart.addProductToCart(new CartItem(BabyBathAndSkinCareArray[6], 3));
    cart.addProductToCart(new CartItem(BabyBathAndSkinCareArray[9], 8));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(3532)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(GheeAndOilsArray[6], 10));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[7], 4));
    cart.addProductToCart(new CartItem(HouseholdCareAndPetFoodArray[5], 1));
    cart.addProductToCart(new CartItem(HouseholdCareAndPetFoodArray[2], 10));
    cart.addProductToCart(new CartItem(HouseholdCareAndPetFoodArray[1], 6));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(60670)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[11], 4));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[9], 8));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[9], 6));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(21271)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Susan", "susan@email.com", passwordEncoder.encode("susanpassword"),
        "60635", LocalDateTime.now().minusMinutes(205003)));
    orders = new ArrayList<Order>();

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Jessica", "jessica@email.com",
        passwordEncoder.encode("jessicapassword"), "4898", LocalDateTime.now().minusMinutes(203745)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(SoapsAndBodyWashArray[10], 4));
    cart.addProductToCart(new CartItem(SoapsAndBodyWashArray[4], 1));
    cart.addProductToCart(new CartItem(SoapsAndBodyWashArray[7], 8));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[6], 10));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[5], 7));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[9], 6));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[11], 3));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(4033)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(RepellantsAndFreshenersArray[4], 6));
    cart.addProductToCart(new CartItem(RepellantsAndFreshenersArray[2], 9));
    cart.addProductToCart(new CartItem(RepellantsAndFreshenersArray[2], 10));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[5], 4));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[7], 8));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[4], 8));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(1808)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[10], 1));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[3], 3));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[6], 5));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[9], 4));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[5], 4));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(3291)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Sarah", "sarah@email.com", passwordEncoder.encode("sarahpassword"),
        "65491", LocalDateTime.now().minusMinutes(30031)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[3], 4));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[5], 8));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[5], 5));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(44139)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(DairyArray[5], 9));
    cart.addProductToCart(new CartItem(DairyArray[3], 3));
    cart.addProductToCart(new CartItem(DairyArray[0], 2));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(30847)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(ShavingNeedsArray[3], 3));
    cart.addProductToCart(new CartItem(ShavingNeedsArray[7], 6));
    cart.addProductToCart(new CartItem(ShavingNeedsArray[7], 10));
    cart.addProductToCart(new CartItem(HouseholdCareAndPetFoodArray[3], 10));
    cart.addProductToCart(new CartItem(HouseholdCareAndPetFoodArray[5], 2));
    cart.addProductToCart(new CartItem(HouseholdCareAndPetFoodArray[3], 4));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(37438)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(BabyBathAndSkinCareArray[9], 3));
    cart.addProductToCart(new CartItem(BabyBathAndSkinCareArray[2], 4));
    cart.addProductToCart(new CartItem(BabyBathAndSkinCareArray[7], 9));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(61793)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Karen", "karen@email.com", passwordEncoder.encode("karenpassword"),
        "167381", LocalDateTime.now().minusMinutes(260005)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[1], 10));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[9], 1));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(16668)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[3], 9));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[8], 6));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[5], 6));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[0], 7));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[7], 9));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[9], 8));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[3], 6));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[11], 1));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[4], 1));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(26362)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[4], 7));
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[10], 9));
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[11], 4));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(63125)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Lisa", "lisa@email.com", passwordEncoder.encode("lisapassword"),
        "104408", LocalDateTime.now().minusMinutes(73093)));
    orders = new ArrayList<Order>();

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Nancy", "nancy@email.com", passwordEncoder.encode("nancypassword"),
        "115179", LocalDateTime.now().minusMinutes(259307)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(BeveragesArray[1], 10));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(20896)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(HairCareArray[8], 6));
    cart.addProductToCart(new CartItem(HairCareArray[3], 8));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(22740)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[9], 6));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[11], 7));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(77868)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Betty", "betty@email.com", passwordEncoder.encode("bettypassword"),
        "58956", LocalDateTime.now().minusMinutes(125826)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[10], 5));
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[11], 3));
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[9], 3));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[11], 10));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[4], 4));
    cart.addProductToCart(new CartItem(BabyBathAndSkinCareArray[2], 9));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(32819)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Margaret", "margaret@email.com",
        passwordEncoder.encode("margaretpassword"), "166902", LocalDateTime.now().minusMinutes(65314)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[7], 3));
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[10], 2));
    cart.addProductToCart(new CartItem(ShavingNeedsArray[5], 3));
    cart.addProductToCart(new CartItem(ShavingNeedsArray[1], 3));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(5449)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(DetergentsAndLaundryArray[3], 3));
    cart.addProductToCart(new CartItem(DetergentsAndLaundryArray[8], 8));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[1], 9));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[0], 10));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[1], 6));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[6], 3));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(159993)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[2], 7));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[0], 3));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[2], 3));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[1], 8));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(53438)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Sandra", "sandra@email.com",
        passwordEncoder.encode("sandrapassword"), "221949", LocalDateTime.now().minusMinutes(240551)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[11], 10));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(80485)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[6], 2));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[1], 6));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[2], 9));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(59952)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(BeveragesArray[4], 8));
    cart.addProductToCart(new CartItem(BeveragesArray[6], 8));
    cart.addProductToCart(new CartItem(BeveragesArray[7], 5));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[3], 10));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[2], 10));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[0], 8));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[7], 3));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(171757)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Ashley", "ashley@email.com",
        passwordEncoder.encode("ashleypassword"), "188672", LocalDateTime.now().minusMinutes(215609)));
    orders = new ArrayList<Order>();

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Kimberly", "kimberly@email.com",
        passwordEncoder.encode("kimberlypassword"), "70042", LocalDateTime.now().minusMinutes(7611)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(HealthandWellnessArray[3], 9));
    cart.addProductToCart(new CartItem(HealthandWellnessArray[11], 9));
    cart.addProductToCart(new CartItem(HealthandWellnessArray[7], 4));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[1], 5));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[4], 10));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(41061)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Emily", "emily@email.com", passwordEncoder.encode("emilypassword"),
        "165535", LocalDateTime.now().minusMinutes(196464)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(DetergentsAndLaundryArray[1], 3));
    cart.addProductToCart(new CartItem(DetergentsAndLaundryArray[5], 6));
    cart.addProductToCart(new CartItem(DetergentsAndLaundryArray[5], 9));
    cart.addProductToCart(new CartItem(HouseholdCareAndPetFoodArray[5], 7));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(36578)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(GheeAndOilsArray[0], 9));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[5], 2));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[5], 4));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[8], 5));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(90858)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(HairCareArray[2], 7));
    cart.addProductToCart(new CartItem(HairCareArray[3], 5));
    cart.addProductToCart(new CartItem(KajalAndMakeupArray[10], 7));
    cart.addProductToCart(new CartItem(KajalAndMakeupArray[5], 1));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(17527)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Donna", "donna@email.com", passwordEncoder.encode("donnapassword"),
        "61477", LocalDateTime.now().minusMinutes(196354)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(ShavingNeedsArray[5], 3));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(52864)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(DairyArray[4], 7));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(30088)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Michelle", "michelle@email.com",
        passwordEncoder.encode("michellepassword"), "201193", LocalDateTime.now().minusMinutes(112098)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(RepellantsAndFreshenersArray[8], 5));
    cart.addProductToCart(new CartItem(RepellantsAndFreshenersArray[1], 7));
    cart.addProductToCart(new CartItem(HealthandWellnessArray[0], 7));
    cart.addProductToCart(new CartItem(HealthandWellnessArray[6], 6));
    cart.addProductToCart(new CartItem(HealthandWellnessArray[3], 1));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[3], 3));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[2], 9));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[4], 8));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(159387)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[11], 7));
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[10], 2));
    cart.addProductToCart(new CartItem(DiapersAndWipesArray[4], 6));
    cart.addProductToCart(new CartItem(DiapersAndWipesArray[11], 5));
    cart.addProductToCart(new CartItem(HealthandWellnessArray[10], 10));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(168679)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(HairCareArray[6], 8));
    cart.addProductToCart(new CartItem(HairCareArray[7], 8));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[5], 1));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[6], 1));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(75822)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Carol", "carol@email.com", passwordEncoder.encode("carolpassword"),
        "132088", LocalDateTime.now().minusMinutes(234966)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(HealthandWellnessArray[0], 3));
    cart.addProductToCart(new CartItem(HealthandWellnessArray[8], 7));
    cart.addProductToCart(new CartItem(HealthandWellnessArray[8], 1));
    cart.addProductToCart(new CartItem(BabyBathAndSkinCareArray[9], 8));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(70361)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(RepellantsAndFreshenersArray[4], 6));
    cart.addProductToCart(new CartItem(RepellantsAndFreshenersArray[0], 4));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[0], 10));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[3], 8));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[3], 1));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(2627)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(GheeAndOilsArray[0], 7));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[3], 10));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[2], 5));
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[1], 2));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[10], 6));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[1], 1));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(30283)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[3], 10));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[5], 1));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[3], 6));
    cart.addProductToCart(new CartItem(CreamsLotionsSkinCareArray[9], 8));
    cart.addProductToCart(new CartItem(RepellantsAndFreshenersArray[10], 10));
    cart.addProductToCart(new CartItem(RepellantsAndFreshenersArray[5], 7));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(79555)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Amanda", "amanda@email.com",
        passwordEncoder.encode("amandapassword"), "42086", LocalDateTime.now().minusMinutes(84790)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(GheeAndOilsArray[6], 8));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[4], 5));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[2], 2));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(29735)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[9], 3));
    cart.addProductToCart(new CartItem(HealthandWellnessArray[1], 5));
    cart.addProductToCart(new CartItem(HealthandWellnessArray[10], 4));
    cart.addProductToCart(new CartItem(DetergentsAndLaundryArray[6], 9));
    cart.addProductToCart(new CartItem(DetergentsAndLaundryArray[2], 1));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(1736)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(BeveragesArray[6], 2));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[7], 7));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[5], 7));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[0], 10));
    cart.addProductToCart(new CartItem(CookingSaucesAndVinegarArray[0], 3));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(35738)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Dorothy", "dorothy@email.com",
        passwordEncoder.encode("dorothypassword"), "73911", LocalDateTime.now().minusMinutes(255181)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[10], 8));
    cart.addProductToCart(new CartItem(BeveragesArray[8], 6));
    cart.addProductToCart(new CartItem(BeveragesArray[2], 6));
    cart.addProductToCart(new CartItem(ShavingNeedsArray[8], 10));
    cart.addProductToCart(new CartItem(ShavingNeedsArray[4], 4));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(21965)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(DairyArray[2], 7));
    cart.addProductToCart(new CartItem(DairyArray[4], 9));
    cart.addProductToCart(new CartItem(DairyArray[1], 8));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(70290)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(HairCareArray[7], 3));
    cart.addProductToCart(new CartItem(HealthandWellnessArray[7], 5));
    cart.addProductToCart(new CartItem(HealthandWellnessArray[3], 8));
    cart.addProductToCart(new CartItem(HealthandWellnessArray[2], 7));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(51625)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Melissa", "melissa@email.com",
        passwordEncoder.encode("melissapassword"), "122233", LocalDateTime.now().minusMinutes(174674)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(BeveragesArray[10], 6));
    cart.addProductToCart(new CartItem(BeveragesArray[3], 3));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[2], 2));
    cart.addProductToCart(new CartItem(DeosPerfumesAndTalcArray[11], 3));
    cart.addProductToCart(new CartItem(KajalAndMakeupArray[9], 5));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(15440)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Deborah", "deborah@email.com",
        passwordEncoder.encode("deborahpassword"), "241177", LocalDateTime.now().minusMinutes(188363)));
    orders = new ArrayList<Order>();

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Stephanie", "stephanie@email.com",
        passwordEncoder.encode("stephaniepassword"), "111101", LocalDateTime.now().minusMinutes(90758)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(RepellantsAndFreshenersArray[6], 5));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(54672)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Rebecca", "rebecca@email.com",
        passwordEncoder.encode("rebeccapassword"), "70158", LocalDateTime.now().minusMinutes(131736)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(KajalAndMakeupArray[11], 6));
    cart.addProductToCart(new CartItem(HairCareArray[11], 6));
    cart.addProductToCart(new CartItem(HairCareArray[4], 6));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(25502)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(DetergentsAndLaundryArray[5], 5));
    cart.addProductToCart(new CartItem(DetergentsAndLaundryArray[7], 7));
    cart.addProductToCart(new CartItem(DetergentsAndLaundryArray[4], 10));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[5], 5));
    cart.addProductToCart(new CartItem(FloorAndOtherCleanersArray[10], 6));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(23420)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Sharon", "sharon@email.com",
        passwordEncoder.encode("sharonpassword"), "106102", LocalDateTime.now().minusMinutes(79515)));
    orders = new ArrayList<Order>();

    cart = new Cart();
    cart.addProductToCart(new CartItem(HouseholdCareAndPetFoodArray[5], 2));
    cart.addProductToCart(new CartItem(HouseholdCareAndPetFoodArray[2], 9));
    cart.addProductToCart(new CartItem(BeveragesArray[6], 8));
    cart.addProductToCart(new CartItem(BeveragesArray[3], 3));
    cart.addProductToCart(new CartItem(DairyArray[4], 3));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(41931)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(MasalasAndSpicesArray[2], 5));
    cart.addProductToCart(new CartItem(DairyArray[3], 2));
    cart.addProductToCart(new CartItem(DairyArray[5], 5));
    cart.addProductToCart(new CartItem(DairyArray[0], 4));
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[9], 9));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(65315)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(GheeAndOilsArray[6], 1));
    cart.addProductToCart(new CartItem(GheeAndOilsArray[6], 2));
    cart.addProductToCart(new CartItem(RiceAndRiceProductsArray[7], 9));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(58706)));
    cart = new Cart();
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[4], 3));
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[4], 6));
    cart.addProductToCart(new CartItem(BreakfastCerealsArray[8], 9));
    cart.addProductToCart(new CartItem(HairCareArray[6], 2));
    cart.addProductToCart(new CartItem(ShavingNeedsArray[3], 3));
    cart.addProductToCart(new CartItem(ShavingNeedsArray[7], 10));
    cart.addProductToCart(new CartItem(ShavingNeedsArray[8], 9));

    orders.add(new Order(cart.getCartItems(), cart.getTotalPrice(), LocalDateTime.now().minusMinutes(73434)));

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Laura", "laura@email.com", passwordEncoder.encode("laurapassword"),
        "81103", LocalDateTime.now().minusMinutes(233346)));
    orders = new ArrayList<Order>();

    customer.setOrders(orders);
    customerRepository.save(customer);

    customer = customerRepository.save(new Customer("Cynthia", "cynthia@email.com",
        passwordEncoder.encode("cynthiapassword"), "143429", LocalDateTime.now().minusMinutes(116922)));
    orders = new ArrayList<Order>();

    customer.setOrders(orders);
    customerRepository.save(customer);

    // List<Order> orders = new ArrayList<>();
    // Cart tempCart = new Cart();
    // tempCart.addProductToCart(new CartItem(ShavingNeedsArray[0], 2));
    // orders.add(new Order(tempCart.getCartItems(), tempCart.getTotalPrice()));
    // john.setOrders(orders);

    // customerRepository.save(john);
    // customerRepository.save(steve);
  }

}
