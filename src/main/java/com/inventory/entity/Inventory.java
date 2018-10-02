package com.inventory.entity;

public class Inventory {
	
	int id;
	String name;
	int price;
	String expire_date;
	int prudcttype_id;
	int quality;
	int sellin;
	String type;
	String rule;

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setExpire_date(String expire_date) {
		this.expire_date = expire_date;
	}

	public void setPrudcttype_id(int prudcttype_id) {
		this.prudcttype_id = prudcttype_id;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public void setSellin(int sellin) {
		this.sellin = sellin;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getExpire_date() {
		return expire_date;
	}

	public int getPrudcttype_id() {
		return prudcttype_id;
	}

	public int getQuality() {
		return quality;
	}

	public int getSellin() {
		return sellin;
	}

	public String getType() {
		return type;
	}

	public String getRule() {
		return rule;
	}


	
		/*
	 * {
  "id": "1",
  "name": "The Dark Knight",
  "discription": "After Gordon, Dent  organised ",
  "director": "Christopher Nolan",
  "hero": "Joker",
  "heroin": "NA",
  "budjet": "100",
  "produced_by": "DC Comics",
  "release_date": "20-10-2016",
  "language": "English",
  "category": "premium"
}
	 */
	
}
