package groupProject3451;

public class User implements userManager {

	

		private int nextTransID = 1;
		private String name;
		private double salary;
		private int transID;
		public User(String name, double salary) {
			this.name = name;
			this.salary = salary;
			this.transID = nextTransID;
			nextTransID++;
			
		}
		
		public String getname() {
			return name;
		}
		public double getSalary() {
			return salary;
		}
		public int getTransID() {
			return transID;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		@Override
	    public void addUser(User user) {
	        
	    }

	    @Override
	    public void removeUser(User user) {
	        
	    }
		
		
}
