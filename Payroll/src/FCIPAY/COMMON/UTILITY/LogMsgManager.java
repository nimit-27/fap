package FCIPAY.COMMON.UTILITY;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.*;
import FCIPAY.COMMON.UTILITY.MsgLogger;

public class LogMsgManager implements LoggerFactory
{
    public LogMsgManager(){
    }
 	public Logger makeNewLoggerInstance(String name) {
		return new MsgLogger(name);
	}       
}