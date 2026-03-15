package FCIPAY.COMMON.UTILITY;
/*
 * Module:        MsgLogger.java
 * Author:        Anand Balasubramanian
 * Date Written:  18/03/2004
* Description:  All messages are logged through this class
* Revision Log  (mm/dd/yy initials description)
* --------------------------------------------------------
* mm/dd/yy xxx  What you changed
*/
import org.apache.log4j.Logger;
import org.apache.log4j.*;
import FCIPAY.COMMON.UTILITY.LogMsgManager;
import FCIPAY.COMMON.UTILITY.LogMsgLevels;
public class MsgLogger extends Logger 
{
	private static LogMsgManager msgManager = new LogMsgManager();
	public MsgLogger(String name) {
		super(name);
	}
	public static Logger getInstance(Object aObject) {
		return Logger.getLogger(aObject.getClass().getName(), msgManager);
	}
	public static Logger getLogger(Object aObject) {
		return Logger.getLogger(aObject.getClass().getName(), msgManager);
	}    
    public void logDEBUG(Object psDebugMessage){
        log(FCIPAY.COMMON.UTILITY.LogMsgLevels.LEVEL_CONFIG,psDebugMessage);
    }
    public void logFATAL(Object psDebugMessage){
        log(FCIPAY.COMMON.UTILITY.LogMsgLevels.LEVEL_ALL,psDebugMessage);
    }
    public void logERROR(Object psDebugMessage){
        log(FCIPAY.COMMON.UTILITY.LogMsgLevels.LEVEL_SEVERE,psDebugMessage);
    }

    public void logINFO(Object psDebugMessage){
        log(FCIPAY.COMMON.UTILITY.LogMsgLevels.LEVEL_INFO,psDebugMessage);
    }    
    public void logWARNING(Object psDebugMessage){
        log(FCIPAY.COMMON.UTILITY.LogMsgLevels.LEVEL_WARNING,psDebugMessage);
    }        
}