

import java.util.ArrayList;

public class Company {
	private Admin admin;
	private ArrayList<Customer> customers;
	private ArrayList<CarForRent> carsforrent;
	private ArrayList<CarForSale> carsforsale;
	private static int carCountRent = 0;
	private static int carCountSale = 0;
	private static int customerCount = 0;

	public Company() {
		carsforrent = new ArrayList<CarForRent>();
		carsforsale = new ArrayList<CarForSale>();
		customers = new ArrayList<Customer>();
	}

	public int getCarCountSale() {
		return carCountSale;
	}
	
	public int getCarCountRent() {
		return carCountRent;
	}

	public Customer getCustomer(int i) {
		return customers.get(i);
	}
	
	public Customer getLastCustomer() {
		return customers.get(customers.size()-1);
	}
	
	public ArrayList<Customer> getAllCustomers() {
		return customers;
	}


	public ArrayList<CarForRent> getCarsForRent() {
		return carsforrent;
	}

	public ArrayList<CarForSale> getCarsForSale() {
		return carsforsale;
	}


	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public void setCarsForRent(ArrayList<CarForRent> carsforrent) {
		this.carsforrent = carsforrent;
	}
	
	public void setCarsForSale(ArrayList<CarForSale> carsforsale) {
		this.carsforsale = carsforsale;
	}


	public void addCarForRent(CarForRent car) {
		carsforrent.add(car);
		carCountRent++;
	}
	
	public void addCarForSale(CarForSale car) {
		carsforsale.add(car);
		carCountSale++;
	}
	
	public void removeCarForSale(CarForSale car) {
		carsforsale.remove(car);
		carCountSale--;
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
		customerCount++;
	}
	

	public int getCustomerCount() {
		return customerCount;
	}


}
