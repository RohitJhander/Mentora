package sql;

import javax.sql.DataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceFactory {

	private static MysqlDataSource mysqlDataSource = null;

	public static synchronized DataSource getMySQLDataSource(String dbUrl,
			String username, String password) {
		if (mysqlDataSource == null) {
			mysqlDataSource = new MysqlDataSource();
			mysqlDataSource.setURL(dbUrl);
			mysqlDataSource.setUser(username);
			mysqlDataSource.setPassword(password);
		}
		return mysqlDataSource;
	}
}
