package framework.yaomy.log;


import play.Logger;

public class GGLogger
{
  public static void info(Object obj)
  {
    Logger.info((obj == null) ? null : obj.toString(), new Object[0]);
  }

  public static void info(String message, Object[] args) {
    Logger.info(message, args);
  }

  public static void info(Throwable e, String message, Object[] args) {
    Logger.info(e, message, args);
  }

  public static void debug(Object obj)
  {
    Logger.debug((obj == null) ? null : obj.toString(), new Object[0]);
  }

  public static void debug(String message, Object[] args) {
    Logger.debug(message, args);
  }

  public static void debug(Throwable e, String message, Object[] args) {
    Logger.debug(e, message, args);
  }

  public static void warn(Object obj)
  {
    Logger.warn((obj == null) ? null : obj.toString(), new Object[0]);
  }

  public static void warn(String message, Object[] args) {
    Logger.warn(message, args);
  }

  public static void warn(Throwable e, String message, Object[] args) {
    Logger.warn(e, message, args);
  }

  public static void error(Object obj)
  {
    Logger.error((obj == null) ? null : obj.toString(), new Object[0]);
  }

  public static void error(String message, Object[] args) {
    Logger.error(message, args);
  }

  public static void error(Throwable e, String message, Object[] args) {
    Logger.error(e, message, args);
  }

  public static void fatal(Object obj)
  {
    Logger.fatal((obj == null) ? null : obj.toString(), new Object[0]);
  }

  public static void fatal(String message, Object[] args) {
    Logger.fatal(message, args);
  }

  public static void fatal(Throwable e, String message, Object[] args) {
    Logger.fatal(e, message, args);
  }
}
