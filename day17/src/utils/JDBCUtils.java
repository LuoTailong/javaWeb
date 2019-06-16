package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class JDBCUtils {

	static ComboPooledDataSource cpds = new ComboPooledDataSource();

	public static Connection getConnection() throws Exception {
		return cpds.getConnection();
	}

	public static DataSource getDataSource() {
		return cpds;
	}

}
