package FCIPAY.Payroll.com.Parser.util.common.vo;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * Copyright &#169; 2003-2004, American International Group, Inc. <br>
 * All rights reserved. <br>
 * Date 03/01/2005<br>
 * <br>
 *
 * <b>Project Name: PLCS</b><br>
 * Cafe Framework Version 2.1.1 <br>
 *
 * <b>Description: </b><br>
 * CacheObjects Value Object <br>
 *
 * <b>Change History: </b><br>
 *
 * @class name        : CacheObjects
 * @author            : Tata Consultancy Services
 * @version           : 1.0 
 * @tables mapped     : 
 * @extends           : 
 * @compilation Units : 
 * @information       : 
 * @attributes        : 
 * @arguments         : 
 * @implements        : 
 * @variables         : 
 *
 */
public class CacheObjects implements java.io.Serializable {

private ArrayList _CacheObject;

/**
 * Default constructor.
 */
public CacheObjects() {
	super ();
}

/**
 * Utility Constructor
 * 
 * @param _CacheObject_ ArrayList
 */
public CacheObjects(ArrayList _CacheObject_)
{
	super ();
	set_CacheObject( _CacheObject_);
}





/**
 * Checks if the _CacheObjectArrayList is empty
 * 
 * @return boolean
 */
public boolean isEmpty_CacheObject() {
	return ((null == _CacheObject) ? true : (_CacheObject.isEmpty()));
}



/**
 * Mutator method for _CacheObject
 * 
 * @param _CacheObject_ ArrayList
 */
public void set_CacheObject(ArrayList _CacheObject_) {
	this._CacheObject = _CacheObject_;
}

/**
 * Accessor method for _CacheObject
 * 
 * @return _CacheObject ArrayList
 */
public ArrayList get_CacheObject() {
	return this._CacheObject;
}


}
