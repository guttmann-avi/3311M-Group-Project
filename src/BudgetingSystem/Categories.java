package src.BudgetingSystem;

public interface Categories {

public String type = "";
	
	public void setCategory(String input); 
	public default String getCategory() {
		return type;
	}
}
