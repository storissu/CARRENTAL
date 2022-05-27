
public class Car {
	protected int id;
	private String brand;
	private String model;
	private String color;
	private String year;
	private String engineType;
	private String engineSize;
	private String image;
	public Car(int id, String brand, String model, String color, String year, String engineType, String engineSize,String image) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.year = year;
		this.engineType = engineType;
		this.engineSize = engineSize;
		this.image=image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public String getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(String engineSize) {
		this.engineSize = engineSize;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	

}
