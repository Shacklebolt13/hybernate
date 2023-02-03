package app.example.hybernate;

import java.util.Properties;
import org.hibernate.cfg.Environment;

public final class HibernateProperties {

  public static final Properties properties = new Properties();

  static {
    properties.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
    properties.put(Environment.DRIVER, "org.h2.Driver");
    properties.put(Environment.URL, "jdbc:h2:file:./TestDataBase");
    properties.put(Environment.HBM2DDL_AUTO, "create");
    // properties.put(Environment.AUTOCOMMIT, "true");
    properties.put(Environment.SHOW_SQL, "true");
    // properties.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
    // properties.put(
    //   Environment.CACHE_REGION_FACTORY,
    //   "org.hibernate.cache.ehcache.EhCacheRegionFactory"
    // );
  }
}
