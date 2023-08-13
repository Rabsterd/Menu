package edu.kh.menu.model.vo;

public class Menu {
	
	private String name;
	private String prise;
	private String PlaceOfOrigin;
	
	public Menu() {}

	public Menu(String name, String prise, String placeOfOrigin) {
		super();
		this.name = name;
		this.prise = prise;
		this.PlaceOfOrigin = placeOfOrigin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrise() {
		return prise;
	}

	public void setPrise(String prise) {
		this.prise = prise;
	}

	public String getPlaceOfOrigin() {
		return PlaceOfOrigin;
	}

	public void setPlaceOfOrigin(String placeOfOrigin) {
		PlaceOfOrigin = placeOfOrigin;
	}

	@Override
	public String toString() {
		return name + " 가격 : " + prise + " (원산지)" + PlaceOfOrigin;
	}
	
	
	
	
	
}
