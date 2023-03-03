package src.BudgetingSystem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseOrganiser{
private static final Map<String, List<String>> CategoryList = new HashMap<>(); 
	static {
			CategoryList.put("Groceries", Arrays.asList("food", "drinks", "toiletries", "grocery", "pharmacy", "shopping"));
	        CategoryList.put("Clothing", Arrays.asList("clothing", "shoes"));
	        CategoryList.put("Entertainment", Arrays.asList("movie", "music", "game", "book", "sports"));
	        CategoryList.put("Appliance", Arrays.asList("phone","fridge", "machine", "dryer", "computer"));
	        CategoryList.put("Transportation", Arrays.asList("car", "bus", "plane","cab","train","subway"));
	        CategoryList.put("Other", null);
	}
	public static void categorizePurchases(List<Purchases> purchase) {
		for(Purchases purchases : purchase) {
			for (Map.Entry<String, List<String>> category : CategoryList.entrySet()) {
                for (String keyword : category.getValue()) {
                    if (purchases.getCategory().toLowerCase().contains(keyword.toLowerCase())) {
                        purchases.setCategory(category.getKey());
                        }
                    else {		
                    	purchases.setCategory("Other");
                    }
                }
            }
        }
	}
}
