package dbaccess;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ToolsFile {

	public static DataOutputStream createFile(String fileName) {

		try {

			// Creates a File object that allows you to work with files
			// on the hard drive. There is no difference between File
			// for character or binary stream writing, or reading

			File listOfNames = new File(fileName);

			// FileOutputStream is used to write streams of data to a file
			// You define whether a new file is created versus appended
			// to based on if you add a boolean to the FileOutputStream
			// FileOutputStream(file, true) : Appends to the file
			// FileOutputStream(file, false) : Creates a new file

			// BufferedOutputStream gathers all the data and then writes
			// it all at one time (Speeds up the Program)
			// DataOutputStream is used to write primitive data to the file

			DataOutputStream infoToWrite = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(listOfNames)));
			return infoToWrite;
		}

		catch (IOException e) {

			System.out.println("An I/O Error Occurred");
			// Closes the program
			System.exit(0);

		}
		return null;

	}

	// Read info from the file
	
	public static String[] initDBFromFile(String PATH){
		File listOfNames = new File(PATH);

		boolean eof = false;
		String str[]=new String[5];

		try {

			// A DataInputStream object has the methods for reading the data
			// The BufferedInputStream gathers the data in blocks
			// FileInputStream gets data from the file

			DataInputStream getInfo = new DataInputStream(new BufferedInputStream(new FileInputStream(listOfNames)));

			// Using a while loop that pulls data until EOFException is thrown
			int i=0;
			while (!eof) {
					str[i] = getInfo.readUTF();
					++i;
				}
		} // END OF TRY
		catch (EOFException e) {
			eof = true;
			return str;
		}

		// Can be thrown by FileInputStream

		catch (FileNotFoundException e) {

			System.out.println("Couldn't Find the File");
			System.exit(0);
		}

		catch (IOException e) {

			System.out.println("An I/O Error Occurred");
			System.exit(0);

		}
		return null;
	}

	public void readFile(String PATH, JTextField[] fil) {

		// Open a new connection to the file

		File listOfNames = new File(PATH);

		boolean eof = false;

		try {

			// A DataInputStream object has the methods for reading the data
			// The BufferedInputStream gathers the data in blocks
			// FileInputStream gets data from the file

			DataInputStream getInfo = new DataInputStream(new BufferedInputStream(new FileInputStream(listOfNames)));

			// Using a while loop that pulls data until EOFException is thrown

			while (!eof) {
				for (int j = 0; j < fil.length; j++) {
					String custName = getInfo.readUTF();
					fil[j].setText(custName);
					// System.out.println(custName);
				}
			}
		} // END OF TRY
		catch (EOFException e) {
			eof = true;
		}

		// Can be thrown by FileInputStream

		catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Couldn't Find the File :" + e, "INSERT", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		catch (IOException e) {
			JOptionPane.showMessageDialog(null,"An I/O Error Occurred :" + e, "INSERT", JOptionPane.ERROR_MESSAGE);
			System.exit(0);

		}
	}

	/// *
	public void writeFile(JTextField[] fil, DataOutputStream custOutput) {

		try {
			// Write primitive data to the file

			// Writes a String in UTF format
			for (int i = 0; i < fil.length; i++) {
				custOutput.writeUTF(fil[i].getText());
			}
		}

		catch (IOException e) {
			JOptionPane.showMessageDialog(null,"An I/O Error Occurred :" + e, "INSERT", JOptionPane.ERROR_MESSAGE);
			System.exit(0);

		}

	}
}
