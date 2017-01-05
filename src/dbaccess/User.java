package dbaccess;

import javax.swing.JOptionPane;

public class User
{	
	private int id;
	private String name;
	private String surname;
	private String login;
	private String pass;
	private int status;
	private String type;
	
	
	public User(int id, String name, String surname, String login, String pass, int status, String type) 
	{
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.pass = pass;
		this.status = status;
		this.type = type;
	}

	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getSurname() 
	{
		return surname;
	}
	
	public void setSurname(String surname) 
	{
		this.surname = surname;
	}
	
	public String getLogin()
	{
		return login;
	}
	
	public void setLogin(String login) 
	{
		this.login = login;
	}
	
	public String getPass() 
	{
		return pass;
	}
	
	public void setPass(String pass) 
	{
		this.pass = pass;
	}
	
	public int getStatus() 
	{
		return status;
	}

	public void setStatus(int status) 
	{
		this.status = status;
	}
	
	public String getType() 
	{
		return type;
	}
	
	public void setType(String type) 
	{
		this.type = type;
	}
	
	/*public UserState getUserState() 
	{
		return state;
	}

	public void setUserState(UserState state) 
	{
		this.state = state;
	}*/
	
	public void updateNotification(int notificationState)
	{
		JOptionPane.showMessageDialog(null, this + " | NEW STATE: " + notificationState, "STATE OF NOTIFICATION CHANGED", JOptionPane.INFORMATION_MESSAGE);
	}
	
	@Override
	public String toString()
	{
		return this.id + " | " + this.name + " | " + this.surname + " | TYPE: " + this.type;
	}
}
