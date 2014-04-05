package com.hackpsu.hack;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.files.FileHandle;
public class FileReader
{
	private static FileReader fileReader;
	private ArrayList<String> errorList;
	private int device = 0;
	private String folder[] = {"res/", ""};
	
	private FileReader()
	{
		if (Gdx.app.getType() ==  ApplicationType.Android) device = 1;
		if (Gdx.app.getType() == ApplicationType.iOS) device = 1;
		loadErrorList();
	}
	
	private void loadErrorList()
	{
		errorList = new ArrayList<String>();
//		FileHandle file = Gdx.files.internal(folder[device] + "codes2.csv");
//		Scanner sc = new Scanner(file.read());
//		while (sc.hasNext())
//		{
//			errorList.add(sc.nextLine());
//		}
//		sc.close();
		FileHandle file = Gdx.files.internal(folder[device] + "codes2.sav");
		try
		{
			ObjectInputStream ois = new ObjectInputStream(file.read());
			errorList = (ArrayList<String>) ois.readObject();
		} catch (Exception e)
		{
			System.err.println("Failed to loads error data.");
		}
	}

	public static FileReader getFileReader()
	{
		if (fileReader == null) fileReader = new FileReader();
		return fileReader;
	}
	
	/**
	 * Load all the data of an error into a
	 * data array.
	 * @param system to search for
	 * @param errorCode to search for
	 * @return the data array
	 */
	public String[] loadErrorData(String system, String errorCode)
	{
//		InputStream is = getClass().getResourceAsStream("codes2.csv");
//		Scanner sc = new Scanner(is);
//		String str = "";
//		while (sc.hasNext() && !str.contains(system))
//		{
//			if (str.contains(system)) System.err.println("System found.");
//			str = sc.nextLine();
//		}
//		while (sc.hasNext() && !str.contains(errorCode))
//		{
//			str = sc.nextLine();
//		}
//		sc.close();
//		if (str.contains(errorCode))
//		{
//			String strArray[] = str.split(",");
//			return strArray;
//		}
		for (String str : errorList)
		{
			if (str.toLowerCase().contains(errorCode.toLowerCase()))
			{
				return str.split(",");
			}
		}
		return new String[]
		{ "Error not found..." };
	}
}
