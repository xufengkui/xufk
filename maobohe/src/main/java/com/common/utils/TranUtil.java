package com.common.utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.JdbcTransactionObjectSupport;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionStatus;

/**
 * 编程式事务工具类
 *
 */
public class TranUtil {

	private DataSource dataSource = null;
	private TransactionStatus status = null;
	private DataSourceTransactionManager txManager = null;
	private TransactionDefinition definition = new DefaultTransactionDefinition();

	public TranUtil() {
		this.dataSource = (DataSource) SpringContextHolder.getBean("dataSource");
	}

	public TranUtil(String dataSource) {
		this.dataSource = (DataSource) SpringContextHolder.getBean(dataSource);
	}

	public TransactionDefinition getDefinition() {
		return this.definition;
	}

	public void setDefinition(TransactionDefinition definition) {
		this.definition = definition;
	}

	public TranUtil begin() {
		this.txManager = new DataSourceTransactionManager(this.dataSource);
		this.definition = getDefinition();
		this.status = this.txManager.getTransaction(this.definition);

		return this;
	}

	public void commit() throws SQLException {
		this.commit(null);
	}

	public void commit(Connection conn) throws SQLException {
		if (conn != null) {
			conn.commit();
		}
		this.txManager.commit(this.status);
	}

	public void rollback() {
		this.txManager.rollback(this.status);
	}

	/**
	 * 获取同一事务的connection
	 * 
	 * @return Connection
	 */
	public Connection getConnection() {
		JdbcTransactionObjectSupport obj = (JdbcTransactionObjectSupport) ((DefaultTransactionStatus) status)
				.getTransaction();
		Connection conn = obj.getConnectionHolder().getConnection();
		return conn;
	}

	/**
	 * 获取dataSource中的connection
	 * 
	 * @return Connection
	 * @throws SQLException
	 *             SQLException
	 */
	public Connection getConnectionDataSource() throws SQLException {
		Connection conn = this.dataSource.getConnection();
		return conn;
	}

	public static void closeConnection(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
}
