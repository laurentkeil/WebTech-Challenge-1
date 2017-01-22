package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.filter.Filters;

import xmltools.Validator;
import xmltools.Querying;
import xmltools.XMLReader;

public class FunctionalityOne {
	private static boolean valid = true;
	private static String output = "******************************";
    private static Map<String, Document> docsToValid = new HashMap<>();
	
	public static void main(String[] args) {
		
		output = output + "\n***** Validation of XML files *****";

		//TODO put the docs xml, xsd or dtd here (readXSD or readDTD)
		docsToValid.put("air", XMLReader.readXSDValidation("air-conditioner.xsd","air-conditioner.xml"));
		docsToValid.put("bulb", XMLReader.readXSDValidation("bulb.xsd","bulb.xml"));
		docsToValid.put("light", XMLReader.readXSDValidation("light-sensor.xsd","light-sensor.xml"));
		docsToValid.put("thermo", XMLReader.readXSDValidation("thermostat.xsd","thermostat.xml"));
		docsToValid.put("user", XMLReader.readXSDValidation("user.xsd","user.xml"));
		
		Set<Entry<String, Document>> docs = docsToValid.entrySet();
		Iterator<Entry<String, Document>> iter = docs.iterator();
		while(iter.hasNext() && valid){
			Entry<String, Document> e = iter.next();
			if (e.getValue() == null) {
				valid = false;
				output = output + "\n***** Fails for test on " + e.getKey() + " *****";
			}
		}

		if (valid == true) {
			output = output + "\n***** XML Documents are valid*****";
		}
		output = output + "\n******************************";
		output = output + "\n***** Constraints validation *****";

		
		// TODO Constraints validation, change xpath and function that validate cosntraints
		
		//check valid user-ID
		String xPath1 = "//*[local-name() = 'ID']/text()";
		if (valid) {
			String xPath2 = "//*[local-name() = 'user-ID']/text()";
			valid = validationBwDoc1andDoc2(docsToValid.get("user"), xPath1, docsToValid.get("air"), xPath2, "EE");
			System.out.println("check constraint validation user-ID from air :" + valid);
		}
		if (valid) {
			String xPath2 = "/bulbData/user-ID";
			valid = validationBwDoc1andDoc2(docsToValid.get("user"), xPath1, docsToValid.get("bulb"), xPath2, "EE");
			System.out.println("check constraint validation user-ID from bulb :" + valid);
		}
		if (valid) {
			String xPath2 = "/lightSensorData/user-ID";
			valid = validationBwDoc1andDoc2(docsToValid.get("user"), xPath1, docsToValid.get("light"), xPath2, "EE");
			System.out.println("check constraint validation user-ID from light :" + valid);
		}
		if (valid) {
			String xPath2 = "/thermostatData/user-ID";
			valid = validationBwDoc1andDoc2(docsToValid.get("user"), xPath1, docsToValid.get("thermo"), xPath2, "EE");
			System.out.println("check constraint validation user-ID from thermo :" + valid);
		}
		
		//check date
		if (valid) {
			String xPath = "/air-conditioner-data/dailyMeasurement[number(translate(date,'-',''))<number(translate(now(),'-',''))]";
			List<Element> list1 = Querying.XPathEvaluation(xPath, docsToValid.get("air"), Filters.element());
			valid = list1.size() == 0;
			System.out.println("check constraint Date from air :" + valid);
		}
		if (valid){
			String xPath = "/bulb/dailyMeasurement[number(translate(date,'-',''))<number(translate(now(),'-',''))]";
			List<Element> list1 = Querying.XPathEvaluation(xPath, docsToValid.get("bulb"), Filters.element());
			valid = list1.size() == 0;
			System.out.println("check constraint Date from bulb :" + valid);
		}
		if (valid) {
			String xPath = "/lightSensorData/dailyMeasurement/date[number(concat(year,month,day))<number(translate(now(),'-',''))]";
			List<Element> list1 = Querying.XPathEvaluation(xPath, docsToValid.get("light"), Filters.element());
			valid = list1.size() == 0;
			System.out.println("check constraint date from light :" + valid);
		}
		if (valid) {
			String xPath = "/thermostatData/dailyMeasurement[number(translate(date,'-',''))<number(translate(now(),'-',''))]";
			List<Element> list1 = Querying.XPathEvaluation(xPath, docsToValid.get("thermo"), Filters.element());
			valid = list1.size() == 0;
			System.out.println("check constraint date from thermostat :" + valid);
		}
		
		//check timestamp
		if (valid) {
			String xPath = "/air-conditioner-data/dailyMeasurement/measurement[number(substring(time-stamp,1,2))<24 and number(substring(time-stamp,4,2))<60 and number(substring(time-stamp,7,2))<60]";
			List<Element> list1 = Querying.XPathEvaluation(xPath, docsToValid.get("air"), Filters.element());
			valid = list1.size() == 0;
			System.out.println("check constraint Time-stamp from air :" + valid);
		}
		if (valid) {
			String xPath = "/bulbData/dailyMeasurement/measurement[number(substring(time-stamp,1,2))<24 and number(substring(time-stamp,4,2))<60 and number(substring(time-stamp,7,2))<60]";
			List<Element> list1 = Querying.XPathEvaluation(xPath, docsToValid.get("bulb"), Filters.element());
			valid = list1.size() == 0;
			System.out.println("check constraint Time-stamp from bulb :" + valid);
		}
		if (valid) {
			String xPath = "/lightSensorData/dailyMeasurement/measurement[number(substring(time-stamp,1,2))<24 and number(substring(time-stamp,4,2))<60 and number(substring(time-stamp,7,2))<60]";
			List<Element> list1 = Querying.XPathEvaluation(xPath, docsToValid.get("light"), Filters.element());
			valid = list1.size() == 0;
			System.out.println("check constraint Time-stamp from light :" + valid);
		}
		if (valid) {
			String xPath = "/thermostatData/dailyMeasurement/measurement[number(substring(time-stamp,1,2))<24 and number(substring(time-stamp,4,2))<60 and number(substring(time-stamp,7,2))<60]";
			List<Element> list1 = Querying.XPathEvaluation(xPath, docsToValid.get("thermo"), Filters.element());
			valid = list1.size() == 0;
			System.out.println("check constraint Time-stamp from thermostat :" + valid);
		}
		
		
		if (valid == true) {
			output = output + "\n***** Each constraint is valid *****";
		} else {
			output = output + "\n***** Constraints aren't valid *****";
		}
		output = output + "\n******************************";
				
	}

	public static boolean getValidation() {
		return valid;
	}
	
	public static String getAnswer() {
		return output;
	}
	
	//generic validation to check if same user-ID
	private static boolean validationBwDoc1andDoc2(Document doc1, String query1, Document doc2, String query2, String type) {
		boolean valid = false;
		if (type.equals("EE")) {
			List<Element> list1 = Querying.XPathEvaluation(query1, doc1, Filters.element());
			System.out.println(list1);//TODO
			List<Element> list2 = Querying.XPathEvaluation(query2, doc2, Filters.element());
			valid = Validator.isValidElt(list1, list2);
		} else {
			List<Element> list1 = Querying.XPathEvaluation(query1, doc1, Filters.element());
			List<Attribute> list2 = Querying.XPathEvaluation(query2, doc2, Filters.attribute());
			valid = Validator.isValidAttr(list1, list2);
		}
		return valid;
	}
	
}
