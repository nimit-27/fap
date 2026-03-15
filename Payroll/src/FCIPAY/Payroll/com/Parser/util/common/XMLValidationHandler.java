package FCIPAY.Payroll.com.Parser.util.common;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
public class XMLValidationHandler extends DefaultHandler {


	private ArrayList results = new
	ArrayList();
	
	public ArrayList getResults()
	{
		return results;
	}
    public void warning(SAXParseException e) throws 
    SAXException
    {
        //System.out.println("[warning] " + e);
		//results.add(e); 
		results.add(e.toString());
    }
	
	
	public void fatalError(SAXParseException e) throws
	SAXException
	{
		//System.out.println("[fatalError] " + e);
		//results.add(e); 
		results.add(e.toString());
	} 
	
	public void error(SAXParseException e) throws
	SAXException
	{
		//System.out.println("[error] " + e);
		//results.add(e);
		results.add(e.toString());
	}

}

