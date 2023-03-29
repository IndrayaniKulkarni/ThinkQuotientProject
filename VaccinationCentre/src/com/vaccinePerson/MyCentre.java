package com.vaccinePerson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class MyCentre {

	static int count = 0;
	static SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
	static Scanner sc = new Scanner(System.in);

	public static void searchByName(Person p[], String name) {

		for (int i = 0; i < count; i++) {
			if (p[i].getName().equals(name)) {
				System.out.println(p[i]);
			}
		}
	}

	public static int searchByUHID(Person p[], int UHID) {

		for (int i = 0; i < count; i++) {
			if (p[i].getUhid() == UHID) {
//				System.out.println(p[i]);
				return i;
			}
		}
		return -1;
	}

	public static void vaccineDetails(Person p) {
		Vaccine v1 = new Vaccine("Pfizer-BioNTech vaccine", 2453, "Pfizer");
		Vaccine v2 = new Vaccine("Moderna vaccine", 2453, "Moderna");
		Vaccine v3 = new Vaccine("Janssen/Johnson & Johnson vaccine", 2453, "Johnson & Johnson");

		int v;
		System.out.println("1." + v1 + "\n2." + v2 + "\n3." + v3 + "\n");
		System.out.println("Which vaccine (input int) : ");
		v = sc.nextInt();

		switch (v) {
		case 1:
			p.setVaccine(v1);
			break;
		case 2:
			p.setVaccine(v2);
			break;
		case 3:
			p.setVaccine(v3);
			break;
		default:
			System.out.println("Error..");
			break;
		}
	}

	public static void addPerson(Person p) throws ParseException {

		System.out.println("UHID :" + p.getUhid());
		System.out.println("Name :");
		p.setName(sc.next());
		System.out.println("Date of Birth \"dd/MM/yyyy\" :");
		String bdate = sc.next();
		Date dateDob = null;
		try {
			dateDob = f1.parse(bdate);
			p.setDob(dateDob);
			Date currentDate = new Date();
//			p.setAge(Math.abs(currentDate - p.getDob()));
//			System.out.println(dateDob);

		} catch (ParseException e) {
			System.out.println("Invalid date..");
		}

		System.out.println("Vaccine status :");
		System.out.println(Arrays.toString(p.getVaccineStatus()));
		System.out.println("\nEnter vaccine date \"dd/MM/yyyy\" :");
		String s = sc.next();
		Date status = f1.parse(s);

		if (p.getVaccineStatus() == null) {
//			String s = sc.next();
//			Date status = f1.parse(s);
			Date arr[] = new Date[3];
			arr[0] = status;
			p.setVaccineStatus(arr);
		} else if (p.getVaccineStatus()[0] != null && p.getVaccineStatus()[1] == null
				&& p.getVaccineStatus()[2] == null) {
//			String s = sc.next();
//			Date status = f1.parse(s);
			Date arr[] = new Date[3];
			arr[0] = p.getVaccineStatus()[0];
			arr[1] = status;
			p.setVaccineStatus(arr);
		} else if (p.getVaccineStatus()[0] != null && p.getVaccineStatus()[1] != null
				&& p.getVaccineStatus()[2] == null) {
//			String s = sc.next();
//			Date status = f1.parse(s);
			Date arr[] = new Date[3];
			arr[0] = p.getVaccineStatus()[0];
			arr[1] = p.getVaccineStatus()[1];
			arr[2] = status;
			p.setVaccineStatus(arr);
		}

		// age
		LocalDate dob = dateDob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate vacc = status.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		p.setAge(Period.between(dob, vacc).getYears());

		System.out.println("Aadhar Number (12 digits):");
		p.setAadharNo(sc.nextLong());
		System.out.println("\nVaccine details :");
		vaccineDetails(p);

	}

	public static void deletePerson(Person[] p, int id) {
		boolean status = false;
		int regid = 1000;
//		for (int i = 0; i < count; i++) {
		if (id == count) { // last record
			p[id] = null;
			count--;
		}
		if (id != -1) {
			status = true;

			for (int j = id; j < count - 1; j++) {
				p[j] = p[j + 1];
			}
			p[count - 1] = null;
			count--;
			System.out.println("Person deleted successfully...");
//				break;
		} else {
			regid++;
		}
//		}
		if (!status) {
			System.out.println("Record not found..");
		}
	}

	/*
	 * public static void updatePerson(Person p[], int id) throws ParseException {
	 * 
	 * boolean status = false; int regid = 1001; for (int i = 0; i < count; i++) {
	 * if (regid == id) { status = true; System.out.println("Person details = ");
	 * System.out.println(p[i]); addPerson(p[id]);
	 * System.out.println("Person updated successfully..."); break; } else {
	 * regid++; } } if (!status) { System.out.println("Record not found.."); }
	 * System.out.println("After updation = "); System.out.println(p[id]); }
	 */

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		String etc = "";
		System.out.println("\n-----------------No of enteries = \n");
		int n = sc.nextInt();
		Person p[] = new Person[n];
		int ch;

		char yOrN = 'n';
		int width = 50;
		String title = "VACCINATION CENTRE";
		System.out.println("__________________________________________________");

		do {

			System.out.println("\t" + title);
			System.out.println();
			System.out.println("\t" + "1. Add a person");
			System.out.println("\t" + "2. Update a person");
			System.out.println("\t" + "3. Delete a person");
			System.out.println("\t" + "4. Search a person");
			System.out.println("\t" + "5. Display a person list");
			System.out.println("\t" + "6. Exit");
			System.out.println("\tChoice = ");
			ch = sc.nextInt();
			int uhid = 1000;
			switch (ch) {
			case 1:// add
				try {
					if (count <= n) {
						p[count] = new Person(uhid + count + 1);
						addPerson(p[count]);
						count++;
					}
				} catch (Exception e) {
					System.out.println("Number of enteries are " + e);
				}
				break;
			case 2:// update
				System.out.println("UHID =");
				int id = sc.nextInt();
				int i = searchByUHID(p, id);
				System.out.println("Current details = ");
//				System.out.println(p[searchByUHID(p, id)]);
				System.out.println(p[i].getUhid() + "\t" + p[i].getName() + "\t" + p[i].getAge() + "\t"
						+ new String(f1.format(p[i].getDob())) + new String(Arrays.toString(p[i].getVaccineStatus()))
						+ "\t" + p[i].getAadharNo() + "\t" + p[i].getVaccine().getVaccineName());
				if (i != -1) {
					addPerson(p[i]);
				}
				break;
			case 3:// delete
				System.out.println("UHID =");
				id = sc.nextInt();
				i = searchByUHID(p, id);
				System.out.println("Current details = ");
				System.out.println(p[i].getUhid() + "\t" + p[i].getName() + "\t" + p[i].getAge() + "\t"
						+ new String(f1.format(p[i].getDob())) + new String(Arrays.toString(p[i].getVaccineStatus()))
						+ "\t" + p[i].getAadharNo() + "\t" + p[i].getVaccine().getVaccineName());
				// System.out.println(p[searchByUHID(p, id)]);
				deletePerson(p, searchByUHID(p, id));
				break;
			case 4:// search
				System.out.println("1. Search by ID");
				System.out.println("2. Search by name");
				System.out.println("choice = ");
				int s = sc.nextInt();
				switch (s) {
				case 1://search by unique health id
					System.out.println("UHID = ");
					id = sc.nextInt();
					if (searchByUHID(p, id) != -1) {
						System.out.println(p[searchByUHID(p, id)]);
					} else {
						System.out.println("Record not found..");
					}
					break;
				case 2://search by name of person
					System.out.println("Name = ");
					String name = sc.next();
					searchByName(p, name);
					break;
				default:
					System.out.println("Error ");
					break;
				}
				break;
			case 5:// display the list of people
				System.out.printf("%-10s%-15s%-10s%-15s%-25s%-15s%-10s%n", "UHID", "Name", "age", "DOB",
						"VaccineStatus", "AadharNo", "Vaccine");
				System.out.println(
						"----------------------------------------------------------------------------------------------------");
				for (i = 0; i < count; i++) {
					System.out.println(p[i].getUhid() + "\t" + p[i].getName() + "\t" + p[i].getAge() + "\t"
							+ new String(f1.format(p[i].getDob()))
							+ new String(Arrays.toString(p[i].getVaccineStatus())) + "\t" + p[i].getAadharNo() + "\t"
							+ p[i].getVaccine().getVaccineName());
				}
				break;
			case 6:
				System.err.println("-------------------EXIT-------------------");
				break;
			default:
				System.out.println("Sorry ...choose correct menu.");
				break;
			}
			System.out.println("*Do you wish to continue (y/Y)? = ");
			yOrN = sc.next().charAt(0);
			System.out.println("__________________________________________________");
		} while (yOrN == 'y' || yOrN == 'Y');
	}

}
