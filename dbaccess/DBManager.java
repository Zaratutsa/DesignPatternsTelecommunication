package dbaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import gui.*;

public class DBManager {
	public Database con;

	public DBManager() {
		con = Database.getInstance();
		con.connect();
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

	public List<User> getPatients() {
		ResultSet result = con.getQuery("SELECT * FROM user WHERE type='Client'");
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

	public List<Article> getArticles() {
		ResultSet result = con.getQuery("SELECT * FROM article");
		List<Article> articleList = new ArrayList<Article>();

		try {
			while (result.next()) {
				Article article = new Article(result.getInt(1), result.getString(2), result.getDouble(3),
						result.getString(4), result.getString(5), result.getInt(6));
				articleList.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return articleList;
	}

	public void addArticle(String name, double price, String description, String type, int status) {
		PreparedStatement preparedStmt;
		Connection conn = con.getConn();
		String query = "INSERT INTO ARTICLE (name, price, description, type, status)" + " VALUES (?, ?, ?, ?, ?)";
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, name);
			preparedStmt.setDouble(2, price);
			preparedStmt.setString(3, description);
			preparedStmt.setString(4, type);
			preparedStmt.setInt(5, status);

			preparedStmt.execute();
			JOptionPane.showMessageDialog(null, "Inserted into ARTICLE", "INSERT", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error adding into ARTICLE: " + e, "INSERT", JOptionPane.ERROR_MESSAGE);
		}
	}

	public List<Advert> getAdverts() {
		ResultSet result = con.getQuery("SELECT * FROM advert");
		List<Advert> advertList = new ArrayList<Advert>();
		AdvertFactory eF = new AdvertFactory();

		try {
			while (result.next()) {
				Advert advert = eF.factory(result.getString(5));
				advert.setId(result.getInt(1));
				advert.setDate(result.getString(2));
				advert.setPlace(result.getString(3));
				advert.setDuration();
				advert.setType();
				advert.setPrice();
				advert.setStatus(1);

				advertList.add(advert);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return advertList;
	}

	public void addAdvert(String date, String place, String duration, String type, double price, int status) {
		PreparedStatement preparedStmt;
		Connection conn = con.getConn();
		String query = "INSERT INTO ADVERT (date, place, duration, type, price, status)" + " VALUES (?, ?, ?, ?, ?, ?)";
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, date);
			preparedStmt.setString(2, place);
			preparedStmt.setString(3, duration);
			preparedStmt.setString(4, type);
			preparedStmt.setDouble(5, price);
			preparedStmt.setInt(6, status);

			preparedStmt.execute();
			JOptionPane.showMessageDialog(null, "Inserted into ADVERT", "INSERT", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error adding into ADVERT: " + e, "INSERT", JOptionPane.ERROR_MESSAGE);
		}
	}

	public List<Notification> getNotifications() {
		ResultSet result = con.getQuery("SELECT * FROM notification");
		List<Notification> notificationList = new ArrayList<Notification>();

		try {
			while (result.next()) {
				Notification notification = new Notification(result.getInt(1), result.getString(2), result.getString(3),
						result.getString(4), result.getInt(5), result.getString(6), result.getInt(7));
				notificationList.add(notification);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return notificationList;
	}

	public void addNotification(String email, String phoneNumber, String contents, int state, String date, int idUser) {
		PreparedStatement preparedStmt;
		Connection conn = con.getConn();
		String query = "INSERT INTO NOTIFICATION (email, phoneNumber, contents, state, date, iduser)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, email);
			preparedStmt.setString(2, phoneNumber);
			preparedStmt.setString(3, contents);
			preparedStmt.setInt(4, state);
			preparedStmt.setString(5, date);
			preparedStmt.setInt(6, idUser);

			preparedStmt.execute();
			JOptionPane.showMessageDialog(null, "Inserted into NOTIFICATION", "INSERT",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error adding into NOTIFICATION: " + e, "INSERT",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void updateNotification(int id) {
		PreparedStatement preparedStmt;
		Connection conn = con.getConn();
		String query = "UPDATE NOTIFICATION set state=1 WHERE id=?";
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, id);

			preparedStmt.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error updating NOTIFICATION: " + e, "UPDATE",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public List<Service> getSerices() {
		ResultSet result = con.getQuery("SELECT * FROM service");
		List<Service> serviceList = new ArrayList<Service>();

		try {
			while (result.next()) {
				Service service = new Service(result.getInt(1), result.getString(2), result.getDouble(3),
						result.getInt(4), result.getString(5), result.getInt(6));
				serviceList.add(service);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return serviceList;
	}

	public void addService(String description, double price, int duration, String type, int status) {
		PreparedStatement preparedStmt;
		Connection conn = con.getConn();
		String query = "INSERT INTO SERVICE (description, price, duration, type, status)" + " VALUES (?, ?, ?, ?, ?)";
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, description);
			preparedStmt.setDouble(2, price);
			preparedStmt.setInt(3, duration);
			preparedStmt.setString(4, type);
			preparedStmt.setInt(5, status);

			preparedStmt.execute();
			JOptionPane.showMessageDialog(null, "Inserted into SERVICE", "INSERT", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error adding into SERVICE: " + e, "INSERT", JOptionPane.ERROR_MESSAGE);
		}
	}

	// ============================================
	public List<Transaction> getTransaction() {
		ResultSet result = con.getQuery("SELECT * FROM transaction");
		List<Transaction> userList = new ArrayList<Transaction>();

		try {
			while (result.next()) {
				Transaction trans = new Transaction();
				trans.setId(result.getInt(1));
				trans.setName(result.getString(2));
				trans.setDescr(result.getString(3));
				trans.setPrice(result.getInt(4));
				trans.setDate(result.getString(5));
				userList.add(trans);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}

	public void addTransaction(String name, String description, float price, String Date) {
		PreparedStatement preparedStmt;
		Connection conn = con.getConn();
		String query = "INSERT INTO TRANSACTION (name, description, price, Date)" + " VALUES (?, ?, ?, ?)";
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, description);
			preparedStmt.setFloat(3, price);
			preparedStmt.setString(4, Date);

			preparedStmt.execute();
			JOptionPane.showMessageDialog(null, "Inserted into TRANSACTION", "INSERT", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error adding into TRANSACTION: " + e, "INSERT", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//
	// public void delUser(int id)
	// {
	// PreparedStatement preparedStmt;
	// Connection conn = con.getConn();
	// String query = "UPDATE USER set status=0 WHERE id=?";
	// try
	// {
	// preparedStmt = conn.prepareStatement(query);
	// preparedStmt.setInt(1, id);
	//
	// preparedStmt.execute();
	// JOptionPane.showMessageDialog(null, "Deleted USER", "DELETE",
	// JOptionPane.INFORMATION_MESSAGE);
	// }
	// catch (SQLException e)
	// {
	// JOptionPane.showMessageDialog(null, "Error deleting USER: " + e,
	// "DELETE", JOptionPane.ERROR_MESSAGE);
	// }
	// }
}
