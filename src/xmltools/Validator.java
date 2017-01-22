package xmltools;

import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Element;

public class Validator {
	
	public static boolean isValidElt(List<Element> l1,List<Element> l2){
		boolean equals = true;
		for(Element a : l1){
			boolean notFound = true;
			for(Element b : l2){
				if(isEqual(b,a)) notFound = false;
			}
			if (notFound) equals = false;
		}
		return equals;
	}
	
	public static boolean isValidAttr(List<Element> l1,List<Attribute> l2){
		boolean equals = true;
		for(Element a : l1){
			boolean notFound = true;
			for(Attribute b : l2){
				if(isEqual(b,a)) notFound = false;
			}
			if (notFound) equals = false;
		}
		return equals;
	}
	
	private static boolean isEqual(Object a, Object b) {
		int caseObj = 0;
		if(a instanceof Element) {
			if(b instanceof Element) {
				caseObj = 1; 
			} else if(b instanceof Attribute) {
				caseObj = 2;
			}
		} else if(a instanceof Attribute) {
			if(b instanceof Element) {
				caseObj = 3;
			} else if(b instanceof Attribute) {
				caseObj = 4; 
			}
		}
		boolean equality=false;
		switch(caseObj){
			case 1: equality = ((Element) a).getText().toLowerCase().equals(((Element) b).getText().toLowerCase());
					break;
			case 2: equality = ((Attribute) b).getValue().toLowerCase().equals(((Element) a).getText().toLowerCase()); 
					break;
			case 3: equality = ((Element) b).getText().toLowerCase().equals(((Attribute) a).getValue().toLowerCase());
					break;
			case 4: equality = ((Attribute) a).getValue().toLowerCase().equals(((Attribute) b).getValue().toLowerCase());
					break;
			default: throw new RuntimeException();
		}
		return equality;
	}
}
