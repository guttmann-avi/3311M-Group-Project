package src.BudgetingSystem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseOrganiser {
	private static final Map<String, List<String>> CategoryList = new HashMap<>();
	static {
		CategoryList.put("Groceries", Arrays.asList("food", "drinks", "toiletries", "grocery", "pharmacy", "shopping","groceries"));
		CategoryList.put("Clothing", Arrays.asList("clothing", "shoes", "clothes", "boots","clothing"));
		CategoryList.put("Entertainment", Arrays.asList("movie", "music", "game", "book", "sports","entertainment"));
		CategoryList.put("Appliance", Arrays.asList("phone", "fridge", "machine", "dryer", "computer","appliance"));
		CategoryList.put("Transportation", Arrays.asList("car", "bus", "plane", "cab", "train", "subway", "gas","transportation"));
		CategoryList.put("Other", null);
	}

	public static void categorizePurchases(Purchases purchase) {
		String keywordHelper = purchase.getCategory();
		purchase.setCategory(keywordHelper);
		breakpoint: if (purchase.getCategory() != null) {
			for (Map.Entry<String, List<String>> category : CategoryList.entrySet()) {
				if (category.getValue() != null) {
					if (category.getValue().contains(keywordHelper.toLowerCase())) {
						purchase.setCategory(category.getKey());
						break breakpoint;
					}
					else {
						purchase.setCategory("Other");
					}
				}

			}
		}
//			else if (purchase.getCategory() != null && purchase.getCategory() == keywordHelper) {
//				purchase.setCategory("Other");
	//}
	else {
				purchase.setCategory("Other");
			}
		}
	}

