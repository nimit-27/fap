package FCIPAY.Payroll.com.Parser.util.common.vo;




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
 * CacheObject Value Object <br>
 *
 * <b>Change History: </b><br>
 *
 * @class name        : CacheObject
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
public class CacheObject implements java.io.Serializable {

private String _name;
private String _description;
private String _populatorClass;
private String _cachedObjectClass;
private String _isEnabled;

/**
 * Default constructor.
 */
public CacheObject() {
	super ();
}

/**
 * Utility Constructor
 * 
 * @param _name_ String
 * @param _description_ String
 * @param _populatorClass_ String
 * @param _cachedObjectClass_ String
 * @param _isEnabled_ String
 */
public CacheObject(
		String _name_
		,String _description_
		,String _populatorClass_
		,String _cachedObjectClass_
		,String _isEnabled_
		) {
	super ();
	set_name( _name_);
	set_description( _description_);
	set_populatorClass( _populatorClass_);
	set_cachedObjectClass( _cachedObjectClass_);
	set_isEnabled( _isEnabled_);
}

/**
 * Mutator method for _name
 * 
 * @param _name_ String
 */
public void set_name(String _name_) {
	this._name = _name_;
}

/**
 * Accessor method for _name
 * 
 * @return _name String
 */
public String get_name() {
	return this._name;
}

/**
 * Mutator method for _description
 * 
 * @param _description_ String
 */
public void set_description(String _description_) {
	this._description = _description_;
}

/**
 * Accessor method for _description
 * 
 * @return _description String
 */
public String get_description() {
	return this._description;
}

/**
 * Mutator method for _populatorClass
 * 
 * @param _populatorClass_ String
 */
public void set_populatorClass(String _populatorClass_) {
	this._populatorClass = _populatorClass_;
}

/**
 * Accessor method for _populatorClass
 * 
 * @return _populatorClass String
 */
public String get_populatorClass() {
	return this._populatorClass;
}

/**
 * Mutator method for _cachedObjectClass
 * 
 * @param _cachedObjectClass_ String
 */
public void set_cachedObjectClass(String _cachedObjectClass_) {
	this._cachedObjectClass = _cachedObjectClass_;
}

/**
 * Accessor method for _cachedObjectClass
 * 
 * @return _cachedObjectClass String
 */
public String get_cachedObjectClass() {
	return this._cachedObjectClass;
}

/**
 * Mutator method for _isEnabled
 * 
 * @param _isEnabled_ String
 */
public void set_isEnabled(String _isEnabled_) {
	this._isEnabled = _isEnabled_;
}

/**
 * Accessor method for _isEnabled
 * 
 * @return _isEnabled String
 */
public String get_isEnabled() {
	return this._isEnabled;
}


}
