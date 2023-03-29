package com.vaccinePerson;
import java.util.Arrays;
/** 
 * vacc by and at where
 * 
 * vaccname, batch no, manfacturer
 * vaccine type
 */
import java.util.Date;

public class Person {

	private int uhid =1000;//unique health id
	private String name;
	private int age;
	private Date dob;
	private Date vaccineStatus[];
	private long aadharNo; //12digits 
	private Vaccine vaccine;
	
	
	public Person(){
	}
	public Person(int uhid){
		this.uhid = uhid;
	}
	public Person(String name, int age, Date dob, Date[] vaccineStatus, int aadharNo) {
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.vaccineStatus = vaccineStatus;
		this.aadharNo = aadharNo;
	}

	public int getUhid() {
		return uhid;
	}

	public void setUhid(int uhid) {
		this.uhid = uhid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date[] getVaccineStatus() {
		return vaccineStatus;
	}

	public void setVaccineStatus(Date[] vaccineStatus) {
		this.vaccineStatus = vaccineStatus;
	}

	public long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}
	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", dob=" + dob + ", vaccineStatus="
				+ Arrays.toString(vaccineStatus) + ", aadharNo=" + aadharNo + ", vaccine=" + vaccine + "]";
	}
	
}
