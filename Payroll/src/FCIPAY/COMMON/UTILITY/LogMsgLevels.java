package FCIPAY.COMMON.UTILITY;
/*
 * Module:        LogMsgLevels.java
 * Author:        Anand Balasubramanian
 * Date Written:  23/03/2004
* Description: The Level class defines a set of standard logging levels that
* can be used to control logging output.  The logging Level objects
* are ordered and are specified by ordered integers.  Enabling logging
* at a given level also enables logging at all higher levels.
* Revision Log  (mm/dd/yy initials description)
* --------------------------------------------------------
* mm/dd/yy xxx  What you changed
*/
import org.apache.log4j.Level;

public class LogMsgLevels 
{
	/**
	 * LEVEL_OFF is a special level that can be used to turn off logging.
	 */
	public static final Level LEVEL_OFF = Level.OFF;
	/**
	 * LEVEL_SEVERE is a message level indicating a serious failure.
	 * <p>
	 * In general LEVEL_SEVERE messages should describe events that are
	 * of considerable importance and which will prevent normal
	 * program execution.   They should be reasonably intelligible
	 * to end users and to system administrators.
	 */
	public static final Level LEVEL_SEVERE = Level.ERROR;
	/**
	 * LEVEL_WARNING is a message level indicating a potential problem.
	 * <p>
	 * In general LEVEL_WARNING messages should describe events that will
	 * be of interest to end users or system managers, or which
	 * indicate potential problems.
	 */
	public static final Level LEVEL_WARNING = Level.WARN;

	/**
	 * LEVEL_INFO is a message level for informational messages.
	 * <p>
	 * Typically LEVEL_INFO messages will be written to the console
	 * or its equivalent.  So the LEVEL_INFO level should only be 
	 * used for reasonably significant messages that will
	 * make sense to end users and system admins.
	 */
	public static final Level LEVEL_INFO = Level.INFO;

	/**
	 * LEVEL_CONFIG is a message level for static configuration messages.
	 * <p>
	 * LEVEL_CONFIG messages are intended to provide a variety of static
	 * configuration information, to assist in debugging problems
	 * that may be associated with particular configurations.
	 * For example, LEVEL_CONFIG message might include the CPU type,
	 * the graphics depth, the GUI look-and-feel, etc.
	 */
	public static final Level LEVEL_CONFIG = Level.DEBUG;

	/**
	 * LEVEL_FINE is a message level providing tracing information.
	 * <p>
	 * All of LEVEL_FINE, LEVEL_FINER, and LEVEL_FINEST are intended for relatively
	 * detailed tracing.  The exact meaning of the three levels will
	 * vary between subsystems, but in general, LEVEL_FINEST should be used
	 * for the most voluminous detailed output, LEVEL_FINER for somewhat
	 * less detailed output, and LEVEL_FINE for the  lowest volume (and
	 * most important) messages.
	 * <p>
	 * In general the LEVEL_FINE level should be used for information
	 * that will be broadly interesting to developers who do not have
	 * a specialized interest in the specific subsystem.
	 * <p>
	 * LEVEL_FINE messages might include things like minor (recoverable)
	 * failures.  Issues indicating potential performance problems
	 * are also worth logging as LEVEL_FINE.
	 */
	public static final Level LEVEL_FINE = Level.DEBUG;

	/**
	 * LEVEL_FINER indicates a fairly detailed tracing message.
	 * By default logging calls for entering, returning, or throwing
	 * an exception are traced at this level.
	 */
	public static final Level LEVEL_FINER = Level.DEBUG;

	/**
	 * LEVEL_FINEST indicates a highly detailed tracing message
	 */
	public static final Level LEVEL_FINEST = Level.DEBUG;

	/**
	 * LEVEL_ALL indicates that all messages should be logged.
	 */
	public static final Level LEVEL_ALL = Level.ALL;

}