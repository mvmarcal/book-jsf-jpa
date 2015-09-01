package org.bookjspjpa.com.entity;

public class Automobile {
	private long id;
	//teste branchs
	private Integer manufactureYear;
	private String model;
	private Integer modelYear;
	private String brand;
	private String comments;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getManufactureYear() {
		return manufactureYear;
	}
	public void setManufactureYear(Integer manufactureYear) {
		this.manufactureYear = manufactureYear;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getModelYear() {
		return modelYear;
	}
	public void setModelYear(Integer modelYear) {
		this.modelYear = modelYear;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Automovel [id=" + id + ", anoFabricacao=" + manufactureYear
				+ ", modelo=" + model + ", anoModelo=" + modelYear
				+ ", marca=" + brand + ", observacoes=" + comments + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((manufactureYear == null) ? 0 : manufactureYear.hashCode());
		result = prime * result
				+ ((modelYear == null) ? 0 : modelYear.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Automobile other = (Automobile) obj;
		if (manufactureYear == null) {
			if (other.manufactureYear != null)
				return false;
		} else if (!manufactureYear.equals(other.manufactureYear))
			return false;
		if (modelYear == null) {
			if (other.modelYear != null)
				return false;
		} else if (!modelYear.equals(other.modelYear))
			return false;
		if (id != other.id)
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		return true;
	}
	
	

}
