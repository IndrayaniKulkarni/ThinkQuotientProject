package com.vaccinePerson;

public class Vaccine {

//	* vaccname, batch no, manfacturer
	private String vaccineName;
	private int batchNo;
	private String manufacturer;
	
	public Vaccine(){
		
	}

	public Vaccine(String vaccineName, int batchNo, String manufacturer) {
		this.vaccineName = vaccineName;
		this.batchNo = batchNo;
		this.manufacturer = manufacturer;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public int getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(int batchNo) {
		this.batchNo = batchNo;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "Vaccine [vaccineName=" + vaccineName + ", batchNo=" + batchNo + ", manufacturer=" + manufacturer + "]";
	}
	
}
