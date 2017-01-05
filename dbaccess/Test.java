package dbaccess;

import java.util.List;

import gui.User;

public class Test {
	public static void main(String[] args) {
		DBManager db=new DBManager();
		List<User> userList=db.getUsers();
		System.out.println(userList);
	}
}
