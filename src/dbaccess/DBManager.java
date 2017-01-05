package dbaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class DBManager {
	public Database con;

	public DBManager() {
		con = Database.getInstance();
		con.connect();
	}
	
	public void configDB(){
		new ConfigDB();
	}
	
	public List<User> getUsers() {
		ResultSet result = con.getQuery("SELECT * FROM user");
		List<User> userList = new ArrayList<User>();

		try {
			while (result.next()) {
				User user = new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),
						result.getString(5), result.getInt(6), result.getString(7));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}

	public void addUser(String name, String surname, String login, String pass, int status, String type) {
		PreparedStatement preparedStmt;
		Connection conn = con.getConn();
		String query = "INSERT INTO USER (name, surname, login, pass, status, type)" + " VALUES (?, ?, ?, ?, ?, ?)";
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, surname);
			preparedStmt.setString(3, login);
			preparedStmt.setString(4, pass);
			preparedStmt.setInt(5, status);
			preparedStmt.setString(6, type);

			preparedStmt.execute();
			JOptionPane.showMessageDialog(null, "Inserted into USER", "INSERT", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error adding into USER: " + e, "INSERT", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void delUser(int id) {
		PreparedStatement preparedStmt;
		Connection conn = con.getConn();
		String query = "UPDATE USER set status=0 WHERE id=?";
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, id);

			preparedStmt.execute();
			JOptionPane.showMessageDialog(null, "Deleted USER", "DELETE", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error deleting USER: " + e, "DELETE", JOptionPane.ERROR_MESSAGE);
		}
	}

	public List<Device> getDevice() {
		ResultSet result = con.getQuery("SELECT * FROM device");
		List<Device> deviceList = new ArrayList<Device>();

		try {
			while (result.next()) {
				Device device = new Device();
				device.setId(result.getInt(1));
				device.setName(result.getString(2));
				device.setPrice(result.getDouble(3));
				device.setType(result.getString(4));
				deviceList.add(device);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return deviceList;
	}

	public void addDevice(String name, double price, String type) {
		PreparedStatement preparedStmt;
		Connection conn = con.getConn();
		String query = "INSERT INTO ARTICLE (name, price, type)" + " VALUES (?, ?, ?)";
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, name);
			preparedStmt.setDouble(2, price);
			preparedStmt.setString(3, type);

			preparedStmt.execute();
			JOptionPane.showMessageDialog(null, "Inserted into Device", "INSERT", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error adding into Device: " + e, "INSERT", JOptionPane.ERROR_MESSAGE);
		}
	}


	public List<Notification> getNotifications() {
		ResultSet result = con.getQuery("SELECT * FROM notification");
		List<Notification> notificationList = new ArrayList<Notification>();

		try {
			while (result.next()) {
				Notification notification = new Notification();
				notification.setId(result.getInt(1));
				notification.setMail(result.getString(2));
				notification.setDescribe(result.getString(3));
				notification.setDate(result.getString(4));
				notificationList.add(notification);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return notificationList;
	}

	public void addNotification(String email, String describe,String date) {
		PreparedStatement preparedStmt;
		Connection conn = con.getConn();
		String query = "INSERT INTO NOTIFICATION (email,describe, date)"
				+ " VALUES (?, ?, ?)";
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, email);
			preparedStmt.setString(2, describe);
			preparedStmt.setString(3, date);

			preparedStmt.execute();
			JOptionPane.showMessageDialog(null, "Inserted into NOTIFICATION", "INSERT",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error adding into NOTIFICATION: " + e, "INSERT",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// ============================================
	public List<Transaction> getTransaction() {
		ResultSet result = con.getQuery("SELECT * FROM transaction");
		List<Transaction> transList = new ArrayList<Transaction>();

		try {
			while (result.next()) {
				Transaction trans = new Transaction();
				trans.setId(result.getInt(1));
				trans.setName(result.getString(2));
				trans.setDescr(result.getString(3));
				trans.setPrice(result.getDouble(4));
				trans.setDate(result.getString(5));
				trans.setPayment(result.getString(6));
				transList.add(trans);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return transList;
	}

	public void addTransaction(String name, String description, float price, String Date, String payment) {
		PreparedStatement preparedStmt;
		Connection conn = con.getConn();
		String query = "INSERT INTO TRANSACTION (name, description, price, Date, payment)" + " VALUES (?, ?, ?, ?, ?)";
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, description);
			preparedStmt.setFloat(3, price);
			preparedStmt.setString(4, Date);
			preparedStmt.setString(5, payment);

			preparedStmt.execute();
			JOptionPane.showMessageDialog(null, "Inserted into TRANSACTION", "INSERT", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error adding into TRANSACTION: " + e, "INSERT", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
