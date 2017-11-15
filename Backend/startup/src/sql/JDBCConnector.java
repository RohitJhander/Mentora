package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import static globals.Credentials.MYDB_URL;
import static globals.Credentials.USERNAME;
import static globals.Credentials.PASSWORD;

public class JDBCConnector {
	private static boolean jdbcDriverRegistered = false;

	private static void registerJDBCDriver() throws ClassNotFoundException {
		if (jdbcDriverRegistered) {
			return;
		}
		Class.forName("com.mysql.jdbc.Driver");
		jdbcDriverRegistered = true;
	}

	private static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(MYDB_URL, USERNAME, PASSWORD);
	}

	private static Statement getStatement(Connection connection)
			throws SQLException {
		return connection.createStatement();
	}

	public static int executeMydbUpdateSql(String sql) {
		int id;
		try {
			registerJDBCDriver();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
		Connection connection = null;
		try {
			connection = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		Statement statement = null;
		try {
			statement = getStatement(connection);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		try {
			statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				id = generatedKeys.getInt(1);
				return id;
			} else {
				throw new SQLException("Creating user failed, no ID obtained.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<List<String>> executeMydbQuerySql(String sql) {
		try {
			registerJDBCDriver();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		Connection connection = null;
		try {
			connection = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		Statement statement = null;
		try {
			statement = getStatement(connection);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		try {
			return getListFromResultSet(statement.executeQuery(sql));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static List<List<String>> getListFromResultSet(ResultSet resultSet)
			throws SQLException {
		int numcols = resultSet.getMetaData().getColumnCount();
		List<List<String>> result = new ArrayList<>();
		while (resultSet.next()) {
			List<String> row = new ArrayList<String>(numcols);
			for (int i = 1; i <= numcols; i++) {
				row.add(resultSet.getString(i));
			}
			result.add(row);
		}
		return result;
	}
}