import java.util.Random;
import java.text.DecimalFormat;


class RandomUserGenerator {
    private static String name;
    private static String transactions;
    
    static String Budget = String.valueOf(getBudget());
    
    private static int budget;
    private static int setRand = 0;
    private static int setName = 0;
    private static int setTransactions = 0;
    private static int setBudget = 0;

    public RandomUserGenerator(String name, int transactions, int budget) {
        this.name = name;
        this.transactions = generateTransaction();
        this.budget = budget;
    }

    public static String getName() {
        return name;
    }

    public static String getTransactions() {
        return transactions;
    }

    public static int getBudget() {
        return budget;
    }
    
    public static String generateName() {
    	
    	String Name = name;
    	
    	if(setName != 1) {
    		
    		Random random = new Random();
    		
    		// Generate a random name
    		String[] names = {"Alice","Bob","Charlie","David","Evan","Frank","Grace","Ethan","Danny","Hannah","Lucifer","Brett","Grace","Mireya","Madison","Julia","Kedzy", "Cynthia","Bill", "Jasmine", "Janki"};
    		String randomName = names[random.nextInt(names.length)];
    		
    		// Generate a random number of transactions (between 0 and 100)
    		int randomTransactions = random.nextInt(101);
    		
    		// Generate a random budget (between 1000 and 10000)
    		int randomBudget = (int) (Math.random() * 1999) + 1;
    		
    		// Create a random user
    		if(setRand != 1) {
    			
    			RandomUserGenerator randomUser = new RandomUserGenerator(randomName, randomTransactions, randomBudget);
    			name = randomUser.getName();
    			setRand = 1;
    		}
    		
    		
    		setName = 1;
    		
    		
    		return "Hello, Welcome back " + Name + "!";
    	}
    	else {
    		return "Hello, Welcome back " + Name + "!";
    	}
    }
    
    public static String generateTransaction() {

        // Generate a random store name
        String[] storeNames = {"Walmart     ","Dark Web    ", "Target      ", "Jewel       ","Wendys      ","Circuit City", "Best Buy    ","Mcdonalds  ","Burger King ","Pizza Hut   ", "Amazon      ", "Apple Store ", "Home Depot  ", "RadioShack  ", "Binnys      ","Sex Shop    "};
        //String[] storeNames = {"Grocery Store", "Electronics Mart", "Clothing Boutique", "Coffee Shop", "Bookstore", "Hardware Store"};
        Random random = new Random();
        int index = random.nextInt(storeNames.length);
        String storeName = storeNames[index];
        
        double min = 1.0;
        double max = 150.0;
        double valueSpent = min + (max - min) * random.nextDouble();
        
        return String.format("     %-55s Total: $%.2f", storeName, valueSpent);
        
    }
    
    public static String generateBudget() {
    	
    	
    	DecimalFormat df = new DecimalFormat("#,###");
    	
    	if(setBudget != 1) {
    		
    		
    		Random random = new Random();
    		
    		// Generate a random name
    		String[] names = {"Alice", "Bob", "Charlie", "David", "Evan", "Frank", "Grace", "Hannah", "Brett", "Mireya","Ethan","Cam", "Cynthia","Grace","Lucifer","Evan", "Jasmine","Charles","Destiny","Phil", "Janki"};
    		String randomName = names[random.nextInt(names.length)];
    		
    		// Generate a random number of transactions (between 0 and 100)
    		int randomTransactions = random.nextInt(101);
    		
    		int randomBudget = (int) (Math.random() * 2999) + 1;
    		setBudget = 1;
    		
    		// Create a random user
			if (setRand != 1) {

				RandomUserGenerator randomUser = new RandomUserGenerator(randomName, randomTransactions, randomBudget);
				
				Budget = df.format(randomUser.getBudget());
				
				setRand = 1;
			}
    		
    		
    		return "$" + Budget;
    	}
    	else {
    		return "$" +  Budget;
    	}
    }
    
}