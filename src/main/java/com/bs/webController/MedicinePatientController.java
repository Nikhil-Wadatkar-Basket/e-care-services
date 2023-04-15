package com.bs.webController;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.bs.beans.MedicineCounter;
import com.bs.beans.MedicineDetails;
import com.bs.beans.MedicinePatient;
import com.bs.repo.MedicineCounterRepo;
import com.bs.repo.MedicinePatientRepo;
import com.bs.repo.MedicineRepo;

@Controller
public class MedicinePatientController {
	@Autowired
	private MedicineRepo medicineRepo;
	@Autowired
	private MedicineCounterRepo medicineCounterRepo;
	@Autowired
	private MedicinePatientRepo medicinePatientRepo;
	@Autowired
	private MedicineRepo medicineDetailsRepo;

	@GetMapping("/donateMedicine")
	public ModelAndView donateMedicine() {

		ModelAndView modelAndView = new ModelAndView("MedicinesCounter");
		modelAndView.addObject("empList",
				medicineRepo.findAll().stream().map(med -> med.getMedicineName()).collect(Collectors.toList()));
		return modelAndView;
	}

	@RequestMapping(value = "/addMemedicine", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String addMedicineByPatientID(@RequestParam MultiValueMap<String, String> medicineMap) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

		List<String> medicineList = medicineMap.get("name");
		List<String> quantityList = medicineMap.get("quantity");

		String patientName = medicineMap.getFirst("patientName");
		System.out.println("name:" + patientName);
		String doctorName = medicineMap.getFirst("doctorName");
		System.out.println("doctorName:" + doctorName);
		String date = medicineMap.getFirst("date");
		System.out.println("date :" + date);
		String city = medicineMap.getFirst("city");
		System.out.println("city :" + city);
		String contact = medicineMap.getFirst("contact");
		System.out.println("contact :" + contact);

		System.out.println("listNames:" + medicineList);
		System.out.println("listQuantity" + quantityList);

		// fill data in medicine counter
		prepareMedicineCounter(patientName, doctorName, date, contact, city, medicineList, quantityList);

		return "redirect:/dd";
	}

//	@SuppressWarnings("unlikely-arg-type")
	private void prepareMedicineCounter(String patientName, String doctorName, String date, String contact, String city,
			List<String> medicineList, List<String> quantityList) {
		/// save in medicine counter
		MedicineCounter counter = null;

		for (int i = 0; i < medicineList.size(); i++) {
			counter = new MedicineCounter();
			counter.setContact((contact));
			counter.setPatrientName(patientName);
			counter.setQuantity(Integer.valueOf(quantityList.get(i)));
			counter.setMedName(medicineList.get(i));
			counter.setPrice(getMedicinePriceByName(counter.getMedName()));
			MedicineCounter saved = medicineCounterRepo.save(counter);
			System.out.println("saved with ID:" + saved.getReceiptID());
		}
		// save in medicine patient
		Integer totalSumOfMedicine = 0;
		List<MedicineCounter> findAll = medicineCounterRepo.findAll();
		List<MedicineCounter> filteredList = new LinkedList<MedicineCounter>();

		for (MedicineCounter medicineCounter : findAll) {
			if (medicineCounter.getContact() == contact) {
				filteredList.add(medicineCounter);
				totalSumOfMedicine = totalSumOfMedicine + (medicineCounter.getPrice() * medicineCounter.getQuantity());

			}
		}

		System.out.println("All records:" + findAll);
		System.out.println("Filtered records:" + filteredList);
		System.out.println("Total price:" + totalSumOfMedicine);

		// store in medicine_patient table
		MedicinePatient medicinePatient = new MedicinePatient();
		medicinePatient.setCity(city);
		medicinePatient.setContact(contact);
		medicinePatient.setPatrientName(patientName);
		medicinePatient.setTotalPrice(totalSumOfMedicine);
		medicinePatient.setReceiptDate(date);

		MedicinePatient saveMediPatientObj = medicinePatientRepo.save(medicinePatient);

		System.out.println("saveMediPatientObj saved with ID:" + saveMediPatientObj.getMediPatID());
	}

	private Integer getMedicinePriceByName(String medName) {
//		Integer price = medicineDetailsRepo.findAll().stream().reduce(new MedicineCounter(), (a, b) -> {
//			if (a.getMedicineName().equalsIgnoreCase(medName))
//				return a;
//			else
//				return b;
//		}).getPrice();
		Integer price = 0;
		List<MedicineDetails> findAll = medicineDetailsRepo.findAll();
		for (MedicineDetails details : findAll) {
			if (details.getMedicineName().equalsIgnoreCase(medName)) {
				price = details.getPrice();
				break;
			}
		}
		return price;

//	getMedicineDetailByName
		// store total by phonr anumber in table
//	name, contact, totsal, date, city,
	}
}
