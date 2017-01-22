package xmltools;


import java.io.File;

import org.jdom2.Document;
import org.jdom2.input.JDOMParseException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaderJDOMFactory;
import org.jdom2.input.sax.XMLReaderXSDFactory;
import org.jdom2.input.sax.XMLReaders;
import org.jdom2.output.XMLOutputter;

public class XMLReader {

	//return document xml if everything is valid follow xsd, else catch an exception
	public static Document readXSDValidation(String xsd, String xml) {
		try {
			File fileXSD = new File(xsd);
			XMLReaderJDOMFactory xsdFactory = new XMLReaderXSDFactory(fileXSD);
			SAXBuilder builder = new SAXBuilder(xsdFactory);
			try {
				Document doc = builder.build(new File(xml));
				return doc;
			} catch (JDOMParseException e) {
				System.out.println(e.getCause());
				//e.printStackTrace();
				return null;
			}
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
			return null;
		}

	}

	//Must have the dtd info in the XML files! ( <!DOCTYPE example SYSTEM "example.dtd" > )
	public static Document readDTDValidation(String xml) {
		try {
			SAXBuilder builder = new SAXBuilder(XMLReaders.DTDVALIDATING);

			try {
				Document doc = builder.build(new File(xml));
				return doc;
			} catch (JDOMParseException e) {
				System.out.println(e.getLineNumber() + ":"
						+ e.getColumnNumber() + " " + e.getCause());
				//e.printStackTrace();
				return null;
			}
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
			return null;
		}
	}

	public static Document read(String xml) {
		try {
			SAXBuilder builder = new SAXBuilder(XMLReaders.NONVALIDATING);
			try {
				Document doc = builder.build(new File(xml));
				return doc;
			} catch (JDOMParseException e) {
				System.out.println(e.getCause());
				//e.printStackTrace();
				return null;
			}
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
			return null;
		}
	}
	
	public static String convertDocumentToString(String xml) {
        try {
			SAXBuilder builder = new SAXBuilder(XMLReaders.NONVALIDATING);
			try {
				Document doc = builder.build(new File(xml));

				String output = new XMLOutputter().outputString(doc);

	            return output;
			} catch (JDOMParseException e) {
				System.out.println(e.getCause());
				//e.printStackTrace();
				return null;
			}
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
			return null;
		}
    }
}
