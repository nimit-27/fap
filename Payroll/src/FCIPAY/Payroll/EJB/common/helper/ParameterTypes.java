package FCIPAY.Payroll.EJB.common.helper;
import oracle.jdbc.OracleTypes;
import java.sql.Types;

public class ParameterTypes extends OracleTypes 
{
  int i;
  public ParameterTypes()
  {
    i = 3;
  }
}