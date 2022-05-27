public class CarForRent extends Car {
	private boolean isAvailable;
	private String date;
	private String pricePerHour;
	
	
	public CarForRent(int id, String brand, String model, String color, String year, String engineType,
			String engineSize, boolean isAvailable,String pricePerHour, String image) 
	{
		super(id, brand, model, color, year, engineType, engineSize, image);
		this.isAvailable = isAvailable;
		this.date = date;
		this.pricePerHour = pricePerHour;
	}


	public boolean isAvailable() {
		return isAvailable;
	}


	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getPricePerHour() {
		return pricePerHour;
	}


	public void setPricePerHour(String pricePerHour) {
		this.pricePerHour = pricePerHour;
	}
	
	@Override
    public String toString() {
        return super.getId() + ";" + super.getBrand() + ";" + super.getModel() + ";" + super.getColor() + ";"
                + super.getYear() + ";" + super.getEngineType() + ";" + super.getEngineSize() + ";" + isAvailable + 
                ";" + pricePerHour + ";" + super.getImage();
    }
	
	


	
	
}

