package FCIPAY.Payroll.EJB.common.helper;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;
/**
 * 
 * The QueryValue Implementation<br>
 *
 * 
 *
 * @see java.util.Date
 * <br> java.util.Date
 * 
 * @see java.math.BigDecimal
 * <br> java.math.BigDecimal
 * 
 * @see java.sql.Blob
 * <br> java.sql.Blob
 * 
 * @see java.sql.Clob
 * <br> java.sql.Clob
 * 
 * @see java.sql.Time
 * <br> java.sql.Time
 * 
 * @see java.sql.Timestamp
 * <br> java.sql.Timestamp
 * 
 * 
 *  
 */

public class QueryValue implements Serializable{
	/**
	 * Variable to hold String value
	 */
	private String stringValue = null;
	/**
	 * Variable to hold BigDecimal value
	 */
	private BigDecimal bigDecimalValue = BigDecimal.valueOf(0L);
	/**
	 * Variable to hold short value
	 */
	private short shortValue = 0;
	/**
	 * Variable to hold int value
	 */
	private int intValue = 0;
	/**
	 * Variable to hold long value
	 */
	private long longValue = 0;
	/**
	 * Variable to hold float value
	 */
	private float floatValue = 0;
	/**
	 * Variable to hold double value
	 */
	private double doubleValue = 0;
	/**
	 * Variable to hold Date value
	 */
	private Date dateValue = null;
	/**
	 * Variable to hold Blob value
	 */
	private Blob blobValue = null;
	/**
	 * Variable to hold Clob value
	 */
	private Clob clobValue = null;
	/**
	 * Constructor
	 */
	public QueryValue() {
		super();
	}
	/**
	 * Set the String value
	 * @param value String
	 */
	public void setString(String value){
		stringValue = value;
	}
	/**
	 * Get the String value
	 * @return stringValue String
	 */
	public String getString(){
		return stringValue;
	}
	/**
	 * Set the BigDecimal value
	 * @param value BigDecimal
	 */
	public void setBigDecimal(java.math.BigDecimal value){
		bigDecimalValue = value;
	}
	/**
	 * Get the BigDecimal value
	 * @return bigDecimalValue BigDecimal
	 */
	public java.math.BigDecimal getBigDecimal(){
		return bigDecimalValue;
	}
	/**
	 * Set the short value
	 * @param value short
	 */
	public void setShort(short value){
		shortValue = value;
	}
	/**
	 * Get the short value
	 * @return shortValue short
	 */
	public short getShort(){
		return shortValue;
	}
	/**
	 * Set the int value
	 * @param value int
	 */
	public void setInt(int value){
		intValue = value;
	}
	/**
	 * Get the int value
	 * @return intValue int
	 */
	public int getInt(){
		return intValue;
	}
	/**
	 * Set the long value
	 * @param value long
	 */
	public void setLong(long value){
		longValue = value;
	}
	/**
	 * Get the long value
	 * @return longValue long
	 */
	public long getLong(){
		return longValue;
	}
	/**
	 * Set the float value
	 * @param value float
	 */
	public void setFloat(float value){
		floatValue = value;
	}
	/**
	 * Get the float value
	 * @return floatValue float
	 */
	public float getFloat(){
		return floatValue;
	}
	/**
	 * Set the double value
	 * @param value double
	 */
	public void setDouble(double value){
		doubleValue = value;
	}
	/**
	 * Get the double value
	 * @return doubleValue double
	 */
	public double getDouble(){
		return doubleValue;
	}
	/**
	 * Set the java.util.Date value
	 * @param value java.util.Date
	 */
	public void setDate(java.util.Date value){
		dateValue = value;
	}
	/**
	 * Set the java.sql.Date value
	 * @param value java.sql.Date
	 */
	public void setDate(java.sql.Date value){
		if (null == value) {
			return;
		}
		dateValue = new Date(value.getTime());
	}	
	/**
	 * Get the java.sql.Date value
	 * @return dateValue java.sql.Date
	 */
	public java.util.Date getDate(){
		return dateValue;
	}
	/**
	 * Set the Date
	 * @param value java.util.Date
	 */
	public void setTime(java.util.Date value){
		setDate(value);
	}
	/**
	 * Set the Time
	 * @param value java.sql.Time
	 */
	public void setTime(java.sql.Time value){
		if (null == value) {
			return;
		}
		dateValue = new Date(value.getTime());
	}
	/**
	 * Get the Time
	 * @return dateValue java.util.Date
	 */
	public java.util.Date getTime(){
		return dateValue;
	}
	/**
	 * Set the java.sql.Timestamp value
	 * @param value java.sql.Timestamp
	 */
	public void setTimestamp(java.sql.Timestamp value){
		if (null == value) {
			return;
		}
		dateValue = new Date(value.getTime() + (value.getNanos() / 1000000));
	}
	/**
	 * Get the java.sql.Timestamp value
	 * @return dateValue java.util.Date
	 */
	public java.util.Date getTimestamp(){
		return dateValue;
	}
	/**
	 * Set the Blob value
	 * @param value Blob
	 */
	public void setBlob(java.sql.Blob value){
		blobValue = value;
	}
	/**
	 * Get the Blob value
	 * @return blobValue Blob
	 */
	public java.sql.Blob getBlob(){
		return blobValue;
	}
	/**
	 * Set the Clob value
	 * @param value Clob 
	 */
	public void setClob(java.sql.Clob value){
		clobValue = value;
	}
	/**
	 * Get the Clob value
	 * @return clobValue Clob 
	 */
	public java.sql.Clob getClob(){
		return clobValue;
	}
}
