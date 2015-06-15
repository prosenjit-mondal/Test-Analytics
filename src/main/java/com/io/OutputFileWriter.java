package com.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputFileWriter {

	public static void writeToFile(String query, String path) {
		try {

			File file = new File(path);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(query);
			bw.newLine();

			bw.close();

			System.out.println("Written sucessfully in " + path);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
