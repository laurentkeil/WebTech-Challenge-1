package main;

import xmltools.Transform;
import xmltools.XMLReader;

public class FunctionalityFour {
	
	public static String main(String[] args) {
		//Transform document
		//Write document transformed --> xhtml.html
		Transform.XSLT("actuator.xml", "JSON.xsl", "JSON.json");
		
		return XMLReader.convertDocumentToString("JSON.json");
		//Read xhtml to see if it works (without validation) and convertDocumentToString

	}
}
