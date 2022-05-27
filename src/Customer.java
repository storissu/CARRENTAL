public class Customer extends Person {
	private int Id;
	private String username;
	private String password;
	private int budget;

	public Customer(int Id, String name, String surname, String mail, String phone, String city, String username,
			String password, int budget) {
		super(name, surname, mail, phone, city);
		this.Id = Id;
		this.username = username;
		this.password = password;
		this.budget = budget;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public void display() {
		System.out.println();
	}

}
