package main;

import org.jdom2.Document;

import net.sf.saxon.s9api.XdmItem;
import net.sf.saxon.s9api.XdmValue;
import xmltools.Querying;
import xmltools.Transform;
import xmltools.XMLReader;

public class FunctionalityThree {
	
	private static String res = "";
	private static boolean valid;
	public static String getQuery(int choice) {
		String query = "";
		boolean xQuery = true;
		switch (choice) {
		case 1:
			query = "p1-q1.xq";
			break;
		case 2:
			query = "p1-q2.xq";
			break;
		case 3:
			query = "p1-q3.xq";
			break;
		case 4:
			query = "p1-q4.xq";
			break;
		case 5:
			query = "p2-q1.xq";
			break;
		case 6:
			valid = false;
			xQuery = false;
			Transform.XSLT( "actuator.xml", "p2-q2-xslt.xsl", "p2-q2-xslt.xml");
			Document res = XMLReader.read("p2-q2-xslt.xml");
			if(res!=null)
				valid=true;
			//query = "p2-q2.xq";
			break;
		}
		
		if (xQuery) {
			XdmValue result = Querying.XQueryEvaluation(query);
			for (XdmItem item : result) {
				res = res+item.toString()+"\n";
				//System.out.println(res);
			}
		}

		return res+"\n\n";
	}
	
	public static String resetRes(){
		res = "";
		return res;
	}
	
	public static boolean getValidation(){
		return valid;
	}
}