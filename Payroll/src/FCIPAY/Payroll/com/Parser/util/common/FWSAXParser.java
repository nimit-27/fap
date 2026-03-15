package FCIPAY.Payroll.com.Parser.util.common;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import oracle.xml.parser.v2.*;
//import org.apache.xerces.parsers.SAXParser;
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.lang.reflect.*;


public class FWSAXParser extends DefaultHandler {

 private String lastName;

 //static XMLReader parser;
 //private static SAXParser parser;
 private Stack aStack = new Stack();
 private Object objFinal;
 private String sPackage = "";


   void setPackage(String sPackage_) {
   		this.sPackage = sPackage_;
   }
   void setObject (Object obj ) {
        objFinal = obj;
   }

   Object getFinalObject() {
        return this.objFinal;
   }

  /**
    * Handle the start of an element.
    */
  public void startElement (String uri, String name,String qName, Attributes atts)
  {
    lastName = new String(name);

	//sChar = "";
	sCharStringBuffer = new StringBuffer();

   	try
  	{
	   aStack.push(name);
  	}
  	catch (Exception e)
  	{
	   //System.out.println( e );
	   throw new RuntimeException(e.getMessage());
  	}

  }


  /**
    * Handle the end of an element.
    */
  public void endElement (String uri, String name, String qName)
  {
  	try
  	{
 	   sPathMap = getPathMap();

	   String sChar = sCharStringBuffer.toString();

	   String sTempChar = new String(sChar);
	   sTempChar = sTempChar.replace('\r', ' ');
	   sTempChar = sTempChar.replace('\n', ' ');
	   sTempChar = sTempChar.trim();



	   	if( sChar != null && sChar.length() > 0 && sTempChar.length() > 0 ) {
		   populateValue( sChar, sPathMap);
   		}


	   //sChar = "";
	   sCharStringBuffer = new StringBuffer();

	   String sTopElement = (String)aStack.pop();
	   if ( sTopElement.equals(name)) {
			addToHashMap(getPathMap(sPathMap));
	   }
	   else {
		   aStack.push(sTopElement);
	   }
  	}
  	catch (Exception e)
  	{
	   //System.out.println( e );
	   throw new RuntimeException(e.getMessage());
  	}

  }


  /**
    * Handle character data.
    */

  ArrayList sPathMap = null;
  //String sChar = "";
  StringBuffer sCharStringBuffer = new StringBuffer();

  public void characters (char ch[], int start, int length)
  {
   	try
  	{
	   //sChar += new String(ch,start,length);
	   sCharStringBuffer.append(new String(ch,start,length));

  	}
  	catch (Exception e)
  	{
	   //System.out.println( e );
	   throw new RuntimeException(e.getMessage());
  	}
  }

  private ArrayList getPathMap() {

	  ArrayList aList = new ArrayList(aStack.size());
	  for ( int i=0 ; i < aStack.size(); i++) {
		  aList.add(aStack.get(i));
	  }
	  return aList;
  }

  //private StringBuffer sbfGetMethodPrefix = new StringBuffer("get_");
  //private StringBuffer sbfSetMethodPrefix = new StringBuffer("set_");

  private void populateValue(Object value, ArrayList aPathMap) throws Exception {

	 //String sGetMethodName = "";
	 //String sSetMethodName = "";

	 StringBuffer sbfGetMethodName = new StringBuffer(20);
	 StringBuffer sbfSetMethodName = new StringBuffer(20);

	 try {


		 if ( null == aPathMap ) {
			 return;
		 }

		 Object objOriginal = objFinal;
		 Object objTempCurrent = objFinal;

		 ArrayList aTempPathMap = new ArrayList();
		 aTempPathMap.add(aPathMap.get(0));

		 for ( int i=1; i < aPathMap.size() ; i++ ) {


			 String sElement = (String)aPathMap.get(i);
			 aTempPathMap.add(sElement);


			 //sGetMethodName = "get_" + sElement;
			 sbfGetMethodName = (new StringBuffer("get_")).append(sElement);

			 //Method mGet = objTempCurrent.getClass().getMethod(sGetMethodName, null );
			 Method mGet = objTempCurrent.getClass().getMethod(sbfGetMethodName.toString(), null );

			 Object objChild = mGet.invoke(objTempCurrent,null);



			 if ( objChild == null ) {

				 Class retClass = mGet.getReturnType();
				 objChild = retClass.newInstance();

			 }

			 if ( objChild instanceof ArrayList ) {
				 //ArrayList aList = (ArrayList) objChild;
				 //objChild.add();
				 //String

				 //sSetMethodName = "set_" + sElement;
			 	 sbfSetMethodName = (new StringBuffer("set_")).append(sElement);


				 if ( i == (aPathMap.size() - 1) ) {

					((ArrayList)objChild).add(value);
					Method mSet = objTempCurrent.getClass().getMethod(sbfSetMethodName.toString(), new Class[]{ objChild.getClass() } );
				 	mSet.invoke(objTempCurrent, new Object[] { objChild } );

				 }
				 else {
					 //System.out.println(sElement);

					 ArrayList aList = (ArrayList)objChild;
					 Object objTemp = null;

					 String sTempPathMap = getPathMap(aTempPathMap);

					 int iCounter = getCounter(sTempPathMap);
					 //System.out.println("iCounter=" + iCounter + " sTempPathMap=" + sTempPathMap);

					 //if ( iCounter == 0 ) {
					 if ( aList.size() > iCounter) {
						objTemp = aList.get(iCounter);
					 }
					 else {

						//Class cTemp = Class.forName(sPackage + sElement);
						Class cTemp = Class.forName( ((new StringBuffer(sPackage)).append(sElement)).toString() );
						objTemp = cTemp.newInstance();
						aList.add(objTemp);

						//addToHashMap(sTempPathMap);
					 }
					// }



				 	 Method mSet = objTempCurrent.getClass().getMethod(sbfSetMethodName.toString(), new Class[]{ objChild.getClass() } );
				 	 mSet.invoke(objTempCurrent, new Object[] { objChild } );

					 objChild = objTemp;
				 }

			 }
			 else {

				 if ( i == (aPathMap.size() - 1) ) {
					 //System.out.println("Here 111");
					 objChild = value;
				 }

				 //String
				 //sSetMethodName = "set_" + sElement;
				 sbfSetMethodName = (new StringBuffer("set_")).append(sElement);
				 //System.out.println("MethodName=" + sSetMethodName + " Param: " + objChild.getClass().getName() );
				 Method mSet = objTempCurrent.getClass().getMethod(sbfSetMethodName.toString(), new Class[]{ objChild.getClass() } );
				 mSet.invoke(objTempCurrent, new Object[] { objChild } );

			 }

			objTempCurrent = objChild;
		 }

		 objFinal = objOriginal;
	 }
	 catch(Exception e) {
		//e.printStackTrace();
		 //System.out.println("get METHOD-NAME:" + sGetMethodName);
		 //System.out.println("set METHOD-NAME:" + sSetMethodName);
	     throw new Exception(e.getMessage() + " TAGMETHODNAME: " + sbfGetMethodName.toString()) ;
	 }

  }

  private void addToHashMap(String sPathMap) {

	   if ( sPathMap == null || sPathMap.trim().length() <= 0 ) return ;

	   Object objCounter = aCounterMap.get(sPathMap);
	   Integer iCounter = null;
	   if ( objCounter != null ) {
	   		 iCounter = (Integer) objCounter;
	   }
		else {
			iCounter = new Integer(0);
		}


		iCounter = new Integer(iCounter.intValue() + 1);
		aCounterMap.put( sPathMap , iCounter );

		Set keySet = aCounterMap.keySet();
		Iterator itrKey = keySet.iterator();

		while( itrKey.hasNext() ) {
		    String sKey = (String)itrKey.next();
		    if ( sKey.startsWith(sPathMap) && sKey.length() > sPathMap.length() ) {
		        aCounterMap.put( sKey, new Integer(0));
		    }
		}



  }

  private int getCounter(String sPathMap) {

	   if ( sPathMap == null || sPathMap.trim().length() <= 0 ) return 0;

	   Object objCounter = aCounterMap.get(sPathMap);
	   Integer iCounter = null;
	   if ( objCounter != null ) {
	   		 iCounter = (Integer) objCounter;
	   }
	   else {
			iCounter = new Integer(0);
	   }

	   return iCounter.intValue();

  }
  private String getPathMap (ArrayList aPathMap) {

	   if ( aPathMap == null || aPathMap.size() <= 0 ) return null;

	   //String sTot="";
	   StringBuffer sTotStringBuffer = new StringBuffer();
	   for ( int i=0; i < aPathMap.size(); i++) {
		   //sTot += (String)aPathMap.get(i) + "/";
		   sTotStringBuffer.append((String)aPathMap.get(i)).append("/");

	   }

	   //return sTot;
	   return sTotStringBuffer.toString();
  }
  private HashMap aCounterMap = new HashMap(20);
}
