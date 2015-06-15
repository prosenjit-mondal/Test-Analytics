package com.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class CSVWriter implements IWriter {

	public void graphDataWriter(String query) {
		// TODO Auto-generated method stub

		// createBookQuery();
		Properties prop = null;
		String path = null;
		try {
			prop = new Properties();
			prop.load(new FileInputStream(
					"./src/main/resources/config.properties"));
			path = prop.getProperty("prod.path");
			;
			OutputFileWriter.writeToFile(query, path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
