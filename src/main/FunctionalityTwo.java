package main;

import org.jdom2.Document;

import xmltools.Transform;
import xmltools.XMLReader;

public class FunctionalityTwo {
	
	static boolean valid;
	
	public static String main(String[] args) {
		
		//Transform xml
		Transform.XSLT("user.xml", "integration.xsl", "actuator1.xml");
		
		Document doc = XMLReader.readXSDValidation("actuator.xsd", "actuator.xml");
		
		if(doc==null) {
			valid = false;
			return null;
		}
		else 
		{
			valid = true;
			return XMLReader.convertDocumentToString("actuator.xml");
		}
		//return null;
	}
	
	public static boolean getValidation() {
		return valid;
	}
	
}
