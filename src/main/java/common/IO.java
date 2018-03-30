package common;
/**
* @author {
* 	Name: Darpan Shah
* 	Date: Mar 30, 2018 9:44:01 AM
* }
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class IO {

	@SuppressWarnings({ "static-access" })
	public static File getFile(String fileName) {
		File f = null;
		try {
			f = new File(IO.class.getClassLoader().getSystemClassLoader().getSystemResource(fileName).getPath());
			return f;
		} catch (NullPointerException npe) {
			f = new File(fileName);
			if (f.exists()) {
				return f;
			}
		}
		throw new RuntimeException("could not create/open a file!");
	}

	public static BufferedReader getReader(File file) throws FileNotFoundException {
		return new BufferedReader(new FileReader(file));
	}

	public static BufferedReader getReader(String file) throws FileNotFoundException {
		return getReader(getFile(file));
	}

	public static String fileToString(File f) {
		String string = null;
		try {
			if (f != null && f.exists() && f.isFile()) {
				string = new String(Files.readAllBytes(f.toPath()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return string;
	}

	public static String fileToString(String f) {
		return fileToString(getFile(f));
	}

	public static void writeToFile(Object content, String file) throws IOException {
		RandomAccessFile stream = new RandomAccessFile(file, "rw");
		stream.setLength(0);
		FileChannel channel = stream.getChannel();
		byte[] bytes = content.toString().getBytes();
		ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
		buffer.put(bytes);
		buffer.flip();
		channel.write(buffer);
		stream.close();
		channel.close();
	}

	public static void main(String[] args) throws IOException {
		Set<String> set = new HashSet<String>();
		BufferedReader rdr = getReader("src/test/resources/loadXslBolt/cisco_nexusenv_csv.txt");
		String line = "";
		while ((line = rdr.readLine()) != null) {
			if (line.equals("") || line.length() < 3) {
				continue;
			}

			String md = line.split(",")[0].trim();
			set.add(md);
		}
		rdr.close();
		System.out.println("set size: " + set.size());
		System.out.println(set);
	}

	public static String nullCheck(String text) {
		if (text == null || text.length() < 1 || text == "") {
			throw new RuntimeException("Found null/empty string.");
		}
		return text;
	}

	public static String XmlToString(String xmlString, String xsltString) {
		return XmlToString(null, xmlString, xsltString);
	}

	public static String XmlToString(TransformerFactory tfactory, String xsltString, String xmlString) {
		if(tfactory == null){
			System.setProperty("javax.xml.transform.TransformerFactory", "net.sf.saxon.TransformerFactoryImpl");
			tfactory = TransformerFactory.newInstance();
		}
		StringWriter writer = new StringWriter();
		try {
			Transformer transformer = tfactory.newTransformer(new StreamSource(new StringReader(IO.nullCheck(xsltString))));
			transformer.transform(new StreamSource(new StringReader(IO.nullCheck(xmlString))), new StreamResult(writer));
			return writer.toString();
		} catch (TransformerException | NullPointerException e) {
			throw new RuntimeException("failed to convert xml to String. check input for transformer.");
		}
	}
	
	public static void print(String message){
		System.out.println(message);
	}
	
	public static String loadXmlString(String directory, String xsltype) {
		try {
			return IO.fileToString(makeupFileName(directory, xsltype));
		} catch (Exception e) {
			throw new RuntimeException("Failed to read X M L file for " + xsltype
					+ ". reason: failed to load XML file: " + e.getMessage());
		}
	}
	public static String loadXslString(boolean enableJson, String xsltype) {
		if (enableJson) {
			try {
				return IO.fileToString("src/test/resources/json/" + xsltype + ".xsl");
			} catch (Exception e) {
				throw new RuntimeException("Error while reading xsl file for " + xsltype
						+ ". reason: failed to load XML file: " + e.getMessage());
			}
		} else {
			return IO.fileToString("src/main/resources/xsl/" + xsltype + ".xsl");
		}
	}
	public static String makeupFileName(String directory, String xsltype){
		return directory + xsltype + ".out";
	}
	
	public static InputStream getStream(String filename) throws IOException{
		File file = getFile(filename);
		return new FileInputStream(file);
		
	}
	public static Set<String> getModulesFromCSV(String output){
		Set<String> set = new HashSet<String>();
		StringTokenizer tokenizer = new StringTokenizer(output, "\n");
		while(tokenizer.hasMoreTokens()){
			String line = tokenizer.nextToken();
			set.add(line.split(",")[2]);
		}
		return set;
	}
}

