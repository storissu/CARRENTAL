
public class CarForSale extends Car {
	private String km;
	private boolean isUsed;
	private boolean isSold;
	private String price;
	
	

	public CarForSale(int id, String brand, String model, String color, String year, String engineType,
			String engineSize,String km, boolean isUsed,  String price,boolean isSold,String image) {
		super(id, brand, model, color, year, engineType, engineSize, image);
		this.km = km;
		this.isUsed = isUsed;
		this.isSold = isSold;
		this.price = price;
	}

	public String getKm() {
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
    public String toString() {
        return super.getId() + ";" + super.getBrand() + ";" + super.getModel() + ";" + super.getColor() + ";"
                + super.getYear() + ";" + super.getEngineType() + ";" + super.getEngineSize() + ";" + km + ";" + isUsed
                + ";" + price + ";" + isSold + ";" + super.getImage();
    }
	public boolean isSold() {
		return isSold;
	}

	public void setSold(boolean isSold) {
		this.isSold = isSold;
	}
	

}
