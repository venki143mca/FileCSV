package com.test;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.stream.ImageOutputStreamImpl;

import org.apache.commons.io.IOUtils;

import com.opencsv.CSVWriter;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			// writing to a file.
			PrintStream out = new PrintStream(new FileOutputStream("filename.txt"));
			writeDataToFile(out);
			System.out.println("DONE>");

			// writing to a csv
			WriteDataToCSV();
			
			System.out.println("DONE>");
		} catch (Exception ex) {

		}
	}

	private static void WriteDataToCSV() {
		String[] headers = { "type", "Name", "description" };
		String[] items2 = { "runtime", "IOEXCEPTON", "lamp" };
		String[] items3 = { "compile", "bowl", "spectacles" };

		List<String[]> entries = new ArrayList<String[]>();
		entries.add(headers);
		entries.add(items2);
		entries.add(items3);

		String fileName = "items.csv";
		CSVWriter writer = null;
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
			writer = new CSVWriter(osw);
			writer.writeAll(entries);
		} catch (Exception ex) {

		} finally {
			IOUtils.closeQuietly(writer);
		}

		
	}

	private static void writeDataToFile(PrintStream out) {
		for (int i = 0; i < 5; i++) {
			out.print("Here you go " + i + "\n");
		}

	}

}
