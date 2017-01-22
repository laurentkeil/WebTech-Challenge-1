package xmltools;

import java.io.File;
import java.io.IOException;
import java.util.List;

import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XQueryCompiler;
import net.sf.saxon.s9api.XQueryEvaluator;
import net.sf.saxon.s9api.XQueryExecutable;
import net.sf.saxon.s9api.XdmValue;

import org.jdom2.Document;
import org.jdom2.filter.Filter;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

public class Querying {
	public static <T> List<T> XPathEvaluation(String expr, Document doc, Filter<T> filter) {
		XPathFactory factory = XPathFactory.instance();
		XPathExpression<T> xpath = factory.compile(expr,filter,null);
		return xpath.evaluate(doc);
	}
	
	public static XdmValue XQueryEvaluation(String query) {
		try {
			Processor proc = new Processor(false);
			XQueryCompiler compiler = proc.newXQueryCompiler();
			XQueryExecutable executable = compiler.compile(new File(query));
			XQueryEvaluator evaluator = executable.load();
			XdmValue res = evaluator.evaluate();
			return res;
		} catch (SaxonApiException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
