package FCIPAY.Payroll.com.Parser.util.common;

import org.xml.sax.*;
import org.xml.sax.helpers.*;
import oracle.xml.parser.v2.*;
//import org.apache.xerces.parsers.SAXParser;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.io.*;
import javax.xml.parsers.SAXParserFactory;
import FCIPAY.Payroll.com.Parser.util.common.XMLValidationHandler;

public class FWXMLUtility {

   /*static {
   	 org.apache.xml.security.Init.init();
   }*/

   private static boolean bReverseOrderAttr = false;

   static {

	   	try {
	   		Class cTempClass = Class.forName("IBA.Payroll.com.Parser.util.common.FWXMLUtilitySequence");
	   		Field[] fFieldArray = cTempClass.getDeclaredFields();
	   		if ( fFieldArray[0].getName().equals("ATTRIBUTE1") ) {
				bReverseOrderAttr = false;
			}
			else {
				bReverseOrderAttr = true;
			}
			//System.out.println("bReverseOrderAttr = " + bReverseOrderAttr);

		}
		catch(Exception e) {}
   }


   private static String timerClassName = null;
   public static void setTimerClassName(String timerClassName_) {
   		timerClassName = timerClassName_;
   }

   private static final String LINESEPARATOR = "\n";//System.getProperty("line.separator");

   public static Object xmlToObject ( String className, String sFileName ) throws Exception {

		String methodName = "xmlToObject";

		


		FWSAXParser handler = null;
		InputSource aSource = null;
		SAXParser parser = null;
		FileReader aFileReader = null;
		try {
			Class c = Class.forName(className);
			Object objFinal = c.newInstance();
			String sPackage = getPackage(className);
	        parser = null;
			try
			{
			   //parser = XMLReaderFactory.createXMLReader();
				parser = new SAXParser();

			}
			catch (Exception e)
			{

			   e.printStackTrace();
			   parser = null;
			   System.err.println("error: Unable to instantiate parser("+parser+")");
			   //System.exit(-1);
			   return null;
			}
			handler = new FWSAXParser();
			handler.setObject(objFinal);
			handler.setPackage(sPackage);

			parser.setContentHandler(handler);
			//parser.setErrorHandler(handler);
			aFileReader = new FileReader(sFileName);
			aSource = new InputSource(aFileReader);

			parser.parse(aSource);


			aSource = null;
			parser = null;
			//handler = null;
			return handler.getFinalObject();
		}
		catch(Throwable e) {
			//System.out.println("Got exception _________------------->");
			//e.printStackTrace();

			/*if ( null != aFileReader) {
				aFileReader.close();
				aFileReader = null;
			}*/

			aSource = null;
			parser = null;
      System.out.println(e.getMessage());
			throw new Exception(e.getMessage());
		}
		finally {

			if ( null != aFileReader) {
				aFileReader.close();
				aFileReader = null;
			}

			aSource = null;
			parser = null;

		}

		//return null;
   }



   public static void display(Object obj) throws Exception {

		if ( obj == null ) return;
		else {
			//System.out.println("Class: " + obj.getClass().getName());
			Method mList[] = obj.getClass().getMethods();
			if ( mList != null ) {
				for ( int i=0; i < mList.length ; i++) {
					String methodName = mList[i].getName();
					if ( methodName.startsWith("get_")) {
						//System.out.println(methodName);
						Object objRet = null;
						try {
							objRet = mList[i].invoke(obj, null);
						}
						catch(Exception e) {
							continue;
						}
				 		Class retClass = mList[i].getReturnType();

				 		if ( retClass.getName().equals("java.lang.String") ) {
							System.out.println( obj.getClass().getName() + ":" + methodName + "=" + objRet );
						}
						else if ( retClass.getName().equals("java.util.ArrayList") ) {
							if ( objRet != null ) {
								ArrayList aList = (ArrayList)objRet;
								for ( int j=0; j < aList.size(); j++) {
									if ( aList.get(j) instanceof String ) {
										System.out.println( obj.getClass().getName() + ":" + methodName + "[" + j + "]=" + aList.get(j) );
									}
									else {
										display(aList.get(j));
									}
								}
							}
						}
						else {
							display(objRet);
						}


					}
				}
			}
		}

   }


	private static String getPackage(String classWithPackage) {
		if ( classWithPackage == null ) return "";
		int intLastIndexOfDot = classWithPackage.lastIndexOf(".");
		if ( intLastIndexOfDot == -1 ) return "";
		else {
			return classWithPackage.substring(0,intLastIndexOfDot + 1);
		}
	}

//==========================================

	private static String getClassNameWithoutPackage(String sClassNameWithPackage) {
		if ( null == sClassNameWithPackage ) {
			return "";
		}

		int indexOfDot = sClassNameWithPackage.lastIndexOf(".");
		if ( indexOfDot != -1 && indexOfDot < sClassNameWithPackage.length() ) {

			return sClassNameWithPackage.substring(indexOfDot + 1, sClassNameWithPackage.length());
		}

		return sClassNameWithPackage;
	}

	public static String objectToXSD( String sClassName ) throws Exception {

		//String sClassName = objIn.getClass().getName();
		Class cClass = Class.forName(sClassName);
		Object objIn = cClass.newInstance();
		String sClassNameWithoutPackage = getClassNameWithoutPackage(sClassName);
		String sPackageName = getPackage(sClassName);

		String sXSD = "";
		int level = 0;
		sXSD += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		sXSD += LINESEPARATOR;
		sXSD += "<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" elementFormDefault=\"qualified\">";
		sXSD += LINESEPARATOR;
		sXSD += getSpaces(level + 1) + "<xs:element name=\"" + sClassNameWithoutPackage  + "\">";
		sXSD += LINESEPARATOR;
		sXSD += getSpaces(level + 2) + "<xs:complexType>";
		sXSD += LINESEPARATOR;
		sXSD += getSpaces(level + 3) + "<xs:sequence>";
		sXSD += LINESEPARATOR;

		sXSD += objectToXSDInternal(objIn, sPackageName, level + 3);
		sXSD += getSpaces(level + 3) + "</xs:sequence>";
		sXSD += LINESEPARATOR;
		sXSD += getSpaces(level + 2) + "</xs:complexType>";
		sXSD += LINESEPARATOR;
		sXSD += getSpaces(level + 1) +"</xs:element>";
		sXSD += LINESEPARATOR;
		sXSD += "</xs:schema>";

		return sXSD;


	}

	private static String objectToXSDInternal( Object objIn, String sPackageName, int level ) throws Exception {

		if ( null == objIn ) {
			return "";
		}

		String sXML = "";

		Class cIn = objIn.getClass();
		String sClassName = cIn.getName();


		if ( sClassName.equals("java.util.ArrayList")) {


			ArrayList aList = (ArrayList)objIn;
			for ( int i=0; i < aList.size(); i++) {
				Object obj = aList.get(i);
				sXML += objectToXSDInternal(obj, sPackageName, level);
			}
		}
		else if ( sClassName.equals("java.lang.String") ) {
			return objIn.toString();
		}
		else {

			Field[] fFieldArray = cIn.getDeclaredFields();

			for( int i=0 ; i < fFieldArray.length; i++ ) {

				Field aField = fFieldArray[i];
				String sFieldName = aField.getName();
				Class cType = aField.getType();

				String sTagName = getTagName(sFieldName);

				String sMethodName = "get" + sFieldName;

				Method m = cIn.getMethod(sMethodName, null);

				Class cReturnType = m.getReturnType();
				//Object objRet = m.invoke(objIn,null);

				if ( cReturnType.getName().equals("java.util.ArrayList") ) {

					//<xs:element name="CLAIM" maxOccurs="unbounded">
					sXML += getSpaces(level + 1) + "<xs:element name=\"" + sTagName + "\" maxOccurs=\"unbounded\">";
					sXML += LINESEPARATOR;
					sXML += getSpaces(level + 2) + "<xs:complexType>";
					sXML += LINESEPARATOR;
					sXML += getSpaces(level + 3) + "<xs:sequence>";
					sXML += LINESEPARATOR;

					Class cRetType = Class.forName(getClassNameWithPackage(sTagName, sPackageName));
					Object objRet = cRetType.newInstance();

					sXML += objectToXSDInternal(objRet, sPackageName, level + 3);

					sXML += getSpaces(level + 3) + "</xs:sequence>";
					sXML += LINESEPARATOR;
					sXML += getSpaces(level + 2) + "</xs:complexType>";
					sXML += LINESEPARATOR;
					sXML += getSpaces(level + 1) + "</xs:element>";
					sXML += LINESEPARATOR;

				}
				else if ( cReturnType.getName().equals("java.lang.String") ) {

					sXML += getSpaces(level + 1) + "<xs:element name=\"" + sTagName + "\" type=\"xs:string\" minOccurs=\"0\">";
					sXML += LINESEPARATOR;
					sXML += getSpaces(level + 1) + "</xs:element>";
					sXML += LINESEPARATOR;

				}
				else {

					sXML += getSpaces(level + 1) + "<xs:element name=\"" + sTagName + "\" minOccurs=\"0\">";
					sXML += LINESEPARATOR;
					sXML += getSpaces(level + 2) + "<xs:complexType>";
					sXML += LINESEPARATOR;
					sXML += getSpaces(level + 3) + "<xs:sequence>";
					sXML += LINESEPARATOR;

					Object objRet = cReturnType.newInstance();

					sXML += objectToXSDInternal(objRet, sPackageName, level + 3);

					sXML += getSpaces(level + 3) + "</xs:sequence>";
					sXML += LINESEPARATOR;
					sXML += getSpaces(level + 2) + "</xs:complexType>";
					sXML += LINESEPARATOR;
					sXML += getSpaces(level + 1) +"</xs:element>";
					sXML += LINESEPARATOR;
				}



			}
		}

		return sXML;


	}

	public static String objectToXML( Object objIn ) throws Exception {

		//System.out.println("COMING HERE IN objectToXML");
		String methodName = "objectToXML";

		


		try {
			StringBuffer sXMLBuffer = new StringBuffer();
			sXMLBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			if ( objIn == null ) {
				return sXMLBuffer.toString();
			}
			sXMLBuffer.append(LINESEPARATOR);

			String sClassName = objIn.getClass().getName();
			String sClassNameWithoutPackage = getClassNameWithoutPackage(sClassName);
			sXMLBuffer.append("<").append(sClassNameWithoutPackage).append(">");
			sXMLBuffer.append(LINESEPARATOR);

			sXMLBuffer.append(objectToXMLInternal(objIn, 0));

			sXMLBuffer.append("</").append(sClassNameWithoutPackage).append(">");

			return sXMLBuffer.toString();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {

		}
		return null;
	}

	private static StringBuffer objectToXMLInternal( Object objIn, int level ) throws Exception {
		if ( null == objIn ) {
			return new StringBuffer();
		}

		StringBuffer sXMLBuffer = new StringBuffer();

		Class cIn = objIn.getClass();
		String sClassName = cIn.getName();


		if ( sClassName.equals("java.util.ArrayList")) {


			ArrayList aList = (ArrayList)objIn;
			if( aList.size() > 0 ) {

				if ( bReverseOrderAttr ) {

					for ( int i=(aList.size() - 1); i >= 0; i--) {
						Object obj = aList.get(i);
						if ( obj != null ) {
							String sTempClassName = obj.getClass().getName();

							if ( sTempClassName.equals("java.lang.String" ) ) {

								//System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
								sXMLBuffer.append(objectToXMLInternal(obj, level + 1));


							}
							else {
								String sClassNameWithoutPackage = getClassNameWithoutPackage(sTempClassName);
								//System.out.println("sClassNameWithoutPackage= " + sClassNameWithoutPackage);
								sXMLBuffer.append(getSpaces(level + 1) ).append("<").append(sClassNameWithoutPackage).append(">");
								sXMLBuffer.append(LINESEPARATOR);
								sXMLBuffer.append(objectToXMLInternal(obj, level + 1));
								sXMLBuffer.append(getSpaces(level + 1) ).append("</").append(sClassNameWithoutPackage).append(">");
								sXMLBuffer.append(LINESEPARATOR);
							}

						}
					}
				}
				else {

					for ( int i=0; i < aList.size(); i++) {
						Object obj = aList.get(i);
						if ( obj != null ) {

							String sTempClassName = obj.getClass().getName();
							if ( sTempClassName.equals("java.lang.String" ) ) {

								//System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
								sXMLBuffer.append(objectToXMLInternal(obj, level + 1));
							}
							else {

								String sClassNameWithoutPackage = getClassNameWithoutPackage(sTempClassName);
								//System.out.println("sClassNameWithoutPackage= " + sClassNameWithoutPackage);

								sXMLBuffer.append(getSpaces(level + 1)).append("<").append(sClassNameWithoutPackage).append(">");
								sXMLBuffer.append(LINESEPARATOR);
								//System.out.println(obj.getClass().getName());
								sXMLBuffer.append(objectToXMLInternal(obj, level + 1));
								sXMLBuffer.append(getSpaces(level + 1)).append("</").append(sClassNameWithoutPackage).append(">");
								sXMLBuffer.append(LINESEPARATOR);
							}

						}
					}
				}


			}
		}
		else if ( sClassName.equals("java.lang.String") ) {
			String sTempStr = objIn.toString();

			if ( sTempStr.startsWith("<![CDATA") ) {
				return new StringBuffer(sTempStr);
			}
			else {
				return new StringBuffer(encodeXML(sTempStr));
			}
			//return objIn.toString();
		}
		else {

			Field[] fFieldArray = cIn.getDeclaredFields();

			if ( bReverseOrderAttr ) {

				for( int i=(fFieldArray.length - 1) ; i >= 0; i-- ) {

					Field aField = fFieldArray[i];
					String sFieldName = aField.getName();
					Class cType = aField.getType();

					String sTagName = getTagName(sFieldName);

					String sMethodName = "get" + sFieldName;


					Method m = null;
					try {
						m = cIn.getMethod(sMethodName, null);
					}
					catch(Exception e) {
						continue;
					}

					Object objRet = m.invoke(objIn,null);

					String sReturnClassName = "";
					if ( objRet != null ) {
						sReturnClassName = objRet.getClass().getName();
						if ( sReturnClassName.equals("java.util.ArrayList") ) {
							ArrayList aList = (ArrayList)objRet;
							if ( aList.size() > 0) {
								Object objTemp = aList.get(0);
								if ( objTemp instanceof String ) {
									sXMLBuffer.append(getSpaces(level + 1)).append("<").append(sTagName).append(">");
									sXMLBuffer.append(objectToXMLInternal(objRet, level + 1));
									sXMLBuffer.append("</").append(sTagName).append(">");
									sXMLBuffer.append(LINESEPARATOR);
								}
								else {
									sXMLBuffer.append(objectToXMLInternal(objRet, level ));
								}							}
						}
						else if ( sReturnClassName.equals("java.lang.String") )  {

							sXMLBuffer.append(getSpaces(level + 1)).append("<").append(sTagName).append(">");
							//sXML += LINESEPARATOR;
							sXMLBuffer.append(objectToXMLInternal(objRet, level + 1));
							sXMLBuffer.append("</" + sTagName + ">");
							sXMLBuffer.append(LINESEPARATOR);

						}
						else {
							sXMLBuffer.append(getSpaces(level + 1)).append("<").append(sTagName).append(">");
							sXMLBuffer.append(LINESEPARATOR);
							sXMLBuffer.append(objectToXMLInternal(objRet, level + 1));
							sXMLBuffer.append(getSpaces(level + 1)).append("</" + sTagName).append(">");
							sXMLBuffer.append(LINESEPARATOR);

						}
					}
				}// end for

			}
			else {

				for( int i=0 ; i < fFieldArray.length; i++ ) {

					Field aField = fFieldArray[i];
					String sFieldName = aField.getName();
					Class cType = aField.getType();

					String sTagName = getTagName(sFieldName);

					String sMethodName = "get" + sFieldName;


					Method m = null;
					try {
						m = cIn.getMethod(sMethodName, null);
					}
					catch(Exception e) {
						continue;
					}

					Object objRet = m.invoke(objIn,null);

					String sReturnClassName = "";
					if ( objRet != null ) {
						sReturnClassName = objRet.getClass().getName();
						if ( sReturnClassName.equals("java.util.ArrayList") ) {

							//System.out.println("sFieldName=" + sFieldName);
							ArrayList aList = (ArrayList)objRet;


							if ( aList.size() > 0) {

								Object objTemp = aList.get(0);
								if ( objTemp instanceof String ) {
									sXMLBuffer.append(getSpaces(level + 1)).append("<").append(sTagName).append(">");
									sXMLBuffer.append(objectToXMLInternal(objRet, level + 1));
									sXMLBuffer.append("</").append(sTagName).append(">");
									sXMLBuffer.append(LINESEPARATOR);
								}
								else {
									sXMLBuffer.append(objectToXMLInternal(objRet, level ));
								}
							}
						}
						else if ( sReturnClassName.equals("java.lang.String") )  {

							sXMLBuffer.append(getSpaces(level + 1)).append("<").append(sTagName).append(">");
							//sXML += LINESEPARATOR;
							sXMLBuffer.append(objectToXMLInternal(objRet, level + 1));
							sXMLBuffer.append("</").append(sTagName).append(">");
							sXMLBuffer.append(LINESEPARATOR);

						}
						else {
							sXMLBuffer.append(getSpaces(level + 1)).append("<").append(sTagName).append(">");
							sXMLBuffer.append(LINESEPARATOR);
							sXMLBuffer.append(objectToXMLInternal(objRet, level + 1));
							sXMLBuffer.append(getSpaces(level + 1)).append("</").append(sTagName).append(">");
							sXMLBuffer.append(LINESEPARATOR);

						}
					}
				}// end for

			}
		}

		return sXMLBuffer;

	}
	/*private static String objectToXMLInternal( Object objIn, int level ) throws Exception {
		if ( null == objIn ) {
			return "";
		}

		String sXML = "";

		Class cIn = objIn.getClass();
		String sClassName = cIn.getName();


		if ( sClassName.equals("java.util.ArrayList")) {


			ArrayList aList = (ArrayList)objIn;
			if( aList.size() > 0 ) {

				if ( bReverseOrderAttr ) {

					for ( int i=(aList.size() - 1); i >= 0; i--) {
						Object obj = aList.get(i);
						if ( obj != null ) {
							String sTempClassName = obj.getClass().getName();

							if ( sTempClassName.equals("java.lang.String" ) ) {

								//System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
								sXML += objectToXMLInternal(obj, level + 1);


							}
							else {
								String sClassNameWithoutPackage = getClassNameWithoutPackage(sTempClassName);
								//System.out.println("sClassNameWithoutPackage= " + sClassNameWithoutPackage);
								sXML += getSpaces(level + 1) + "<" + sClassNameWithoutPackage + ">";
								sXML += LINESEPARATOR;
								sXML += objectToXMLInternal(obj, level + 1);
								sXML += getSpaces(level + 1) + "</" + sClassNameWithoutPackage + ">";
								sXML += LINESEPARATOR;
							}

						}
					}
				}
				else {

					for ( int i=0; i < aList.size(); i++) {
						Object obj = aList.get(i);
						if ( obj != null ) {

							String sTempClassName = obj.getClass().getName();
							if ( sTempClassName.equals("java.lang.String" ) ) {

								//System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
								sXML += objectToXMLInternal(obj, level + 1);
							}
							else {

								String sClassNameWithoutPackage = getClassNameWithoutPackage(sTempClassName);
								//System.out.println("sClassNameWithoutPackage= " + sClassNameWithoutPackage);

								sXML += getSpaces(level + 1) + "<" + sClassNameWithoutPackage + ">";
								sXML += LINESEPARATOR;
								//System.out.println(obj.getClass().getName());
								sXML += objectToXMLInternal(obj, level + 1);
								sXML += getSpaces(level + 1) + "</" + sClassNameWithoutPackage + ">";
								sXML += LINESEPARATOR;
							}

						}
					}
				}


			}
		}
		else if ( sClassName.equals("java.lang.String") ) {
			String sTempStr = objIn.toString();

			if ( sTempStr.startsWith("<![CDATA") ) {
				return sTempStr;
			}
			else {
				return encodeXML(sTempStr);
			}
			//return objIn.toString();
		}
		else {

			Field[] fFieldArray = cIn.getDeclaredFields();

			if ( bReverseOrderAttr ) {

				for( int i=(fFieldArray.length - 1) ; i >= 0; i-- ) {

					Field aField = fFieldArray[i];
					String sFieldName = aField.getName();
					Class cType = aField.getType();

					String sTagName = getTagName(sFieldName);

					String sMethodName = "get" + sFieldName;


					Method m = null;
					try {
						m = cIn.getMethod(sMethodName, null);
					}
					catch(Exception e) {
						continue;
					}

					Object objRet = m.invoke(objIn,null);

					String sReturnClassName = "";
					if ( objRet != null ) {
						sReturnClassName = objRet.getClass().getName();
						if ( sReturnClassName.equals("java.util.ArrayList") ) {
							ArrayList aList = (ArrayList)objRet;
							if ( aList.size() > 0) {
								Object objTemp = aList.get(0);
								if ( objTemp instanceof String ) {
									sXML += getSpaces(level + 1) + "<" + sTagName + ">";
									sXML += objectToXMLInternal(objRet, level + 1);
									sXML += "</" + sTagName + ">";
									sXML += LINESEPARATOR;
								}
								else {
									sXML += objectToXMLInternal(objRet, level );
								}							}
						}
						else if ( sReturnClassName.equals("java.lang.String") )  {

							sXML += getSpaces(level + 1) + "<" + sTagName + ">";
							//sXML += LINESEPARATOR;
							sXML += objectToXMLInternal(objRet, level + 1);
							sXML += "</" + sTagName + ">";
							sXML += LINESEPARATOR;

						}
						else {
							sXML += getSpaces(level + 1) + "<" + sTagName + ">";
							sXML += LINESEPARATOR;
							sXML += objectToXMLInternal(objRet, level + 1);
							sXML += getSpaces(level + 1) + "</" + sTagName + ">";
							sXML += LINESEPARATOR;

						}
					}
				}// end for

			}
			else {

				for( int i=0 ; i < fFieldArray.length; i++ ) {

					Field aField = fFieldArray[i];
					String sFieldName = aField.getName();
					Class cType = aField.getType();

					String sTagName = getTagName(sFieldName);

					String sMethodName = "get" + sFieldName;


					Method m = null;
					try {
						m = cIn.getMethod(sMethodName, null);
					}
					catch(Exception e) {
						continue;
					}

					Object objRet = m.invoke(objIn,null);

					String sReturnClassName = "";
					if ( objRet != null ) {
						sReturnClassName = objRet.getClass().getName();
						if ( sReturnClassName.equals("java.util.ArrayList") ) {

							//System.out.println("sFieldName=" + sFieldName);
							ArrayList aList = (ArrayList)objRet;


							if ( aList.size() > 0) {

								Object objTemp = aList.get(0);
								if ( objTemp instanceof String ) {
									sXML += getSpaces(level + 1) + "<" + sTagName + ">";
									sXML += objectToXMLInternal(objRet, level + 1);
									sXML += "</" + sTagName + ">";
									sXML += LINESEPARATOR;
								}
								else {
									sXML += objectToXMLInternal(objRet, level );
								}
							}
						}
						else if ( sReturnClassName.equals("java.lang.String") )  {

							sXML += getSpaces(level + 1) + "<" + sTagName + ">";
							//sXML += LINESEPARATOR;
							sXML += objectToXMLInternal(objRet, level + 1);
							sXML += "</" + sTagName + ">";
							sXML += LINESEPARATOR;

						}
						else {
							sXML += getSpaces(level + 1) + "<" + sTagName + ">";
							sXML += LINESEPARATOR;
							sXML += objectToXMLInternal(objRet, level + 1);
							sXML += getSpaces(level + 1) + "</" + sTagName + ">";
							sXML += LINESEPARATOR;

						}
					}
				}// end for

			}
		}

		return sXML;

	}*/

	private static String getTagName( String sFieldName) {
		if ( sFieldName == null ) return "";

		int indexOfUnderScore = sFieldName.indexOf("_");
		if ( indexOfUnderScore == 0 && sFieldName.length() >= 2 ) {
			return sFieldName.substring(1,sFieldName.length());
		}

		return sFieldName;
	}

	private static String getClassNameWithPackage(String sTagName, String sPackageName ) {
		if ( sPackageName == null || sPackageName.trim().length() <= 0 ) {
			return sTagName;
		}
		return sPackageName + sTagName;
	}

	private static String getSpaces(int iCount) {
		String sRet = "";
		for ( int i=0; i < iCount; i++) {
			sRet += "    ";
		}
		return sRet;
	}

    /**
     * Encode special characters in XML
     * @param strIn java.lang.String
     * @return strOut.toString() java.lang.String
     */
    public static String encodeXML (String strIn) {

//		log(strIn);
        String[] xmlEncFrom = {"&", "\"", "<", ">" };//, "'"};
        String[] xmlEncTo = {"&amp;", "&quot;", "&lt;", "&gt;"};//, "&apos;"};

        int idx = 0;

        if (strIn == null) {
            return null;
        }

        StringBuffer strOut = new StringBuffer (strIn);
        StringBuffer strTemp = null;

        for (int i = 0; i < xmlEncFrom.length; i++) {
            idx = strOut.toString ().indexOf (xmlEncFrom[i]);
            while (idx != -1) {
                strTemp = new StringBuffer ();
                strTemp.append (strOut.substring (0, idx)).
                append (xmlEncTo[i]).
                append (strOut.substring (idx + xmlEncFrom[i].length ()));
                strOut = strTemp;
                idx = strOut.toString ().
                indexOf (xmlEncFrom[i], idx + xmlEncTo[i].length ());
            }
        }
        return strOut.toString ();
    }

public static ArrayList validateXMLWithXSD(String xml, String
			schema) throws SAXException,
javax.xml.parsers.ParserConfigurationException, IOException
{


	try {

		javax.xml.parsers.SAXParserFactory parserFactory =
		SAXParserFactory.newInstance();
		parserFactory.setNamespaceAware(true);
		parserFactory.setValidating(true);
		parserFactory.setFeature("http://apache.org/xml/features/validation/schema",
		true);
		parserFactory.setFeature("http://apache.org/xml/features/validation/schema-full-checking",
		true);
		javax.xml.parsers.SAXParser saxParser = parserFactory.newSAXParser();
		saxParser.setProperty("http://apache.org/xml/properties/schema/external-noNamespaceSchemaLocation",
		schema);
		InputSource is = new InputSource(new
		StringReader(xml));
		XMLValidationHandler handler = new XMLValidationHandler();
		saxParser.parse(is, handler);
		ArrayList aList = handler.getResults();
		return aList;
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return null;


}


public static ArrayList validateXMLWithXSD(File file , String
			schema) throws SAXException,
javax.xml.parsers.ParserConfigurationException, IOException
{


	try {

		String sFileName = file.getAbsolutePath();

		//System.out.println("---sFileName --> " + sFileName);

		javax.xml.parsers.SAXParserFactory parserFactory =
		SAXParserFactory.newInstance();
		parserFactory.setNamespaceAware(true);
		parserFactory.setValidating(true);
		parserFactory.setFeature("http://apache.org/xml/features/validation/schema",
		true);
		parserFactory.setFeature("http://apache.org/xml/features/validation/schema-full-checking",
		true);
		javax.xml.parsers.SAXParser saxParser = parserFactory.newSAXParser();
		saxParser.setProperty("http://apache.org/xml/properties/schema/external-noNamespaceSchemaLocation",
		schema);
		InputSource is =new InputSource(sFileName);

		XMLValidationHandler handler = new XMLValidationHandler();
		saxParser.parse(is, handler);
		ArrayList aList = handler.getResults();
		return aList;
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return null;


}
}