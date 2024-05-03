package JavaBasics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileIODemo {

	public static void main(String[] args) throws IOException {
		
		String filePath = "C:\\Users\\Ajayk\\git\\JavaBasics\\JavaBasics\\src\\main\\java\\JavaBasics\\ajay.txt";
		String dirPath = "D:Ajay";
		
		FileWriter writer = null;
		FileReader reader = null;FileReader reader1 = null;
		
		BufferedWriter bWriter = null;
		BufferedReader bReader = null;
		
		PrintWriter pw = null;
		try
		{
//File I/O Basics
//File
			File file = new File(filePath);
			System.out.println(file.exists());
//Creating a file with file as above name "ajay". If we do not have that file in our local storage.
			file.createNewFile();
			
			//Folder or Directory
			File file1 = new File(dirPath);
			file1.mkdir();
			System.out.println(file1.exists());
			
			String str[] = file1.list();
			int count = 1;
			for(String name:str)
			{
				System.out.println("Folder-"+count+" inside Ajay Folder: "+name);
				count++;
			}
			
			//------------------------------
//Writing Data into file
			writer = new FileWriter(file,true);//***NOTE:- Here true will enable us to append the present data to old file without deleting the previous data.
			//writer.write("HI"); //It will remove all previous data and writes new data
			writer.append("\n");
			writer.append("Im learning Java");
			
			
//Read Data from file
			reader = new FileReader(file);
			int i = reader.read();
			while(i!=-1) //-1 indicates that no more data to read from the file.
			{
				System.out.print((char)i);
				i = reader.read();
			}
			//Other way
			char ch[] = new char[(int) file.length()];
			reader.read(ch);
			
			for(char c:ch)
			{
				System.out.print(c);
			}
			

//Optimized way
			bWriter = new BufferedWriter(writer);
			bWriter.write("...");
			bWriter.newLine();
			bWriter.write("Im Learning Spring as well");
			
			reader1 = new FileReader(file);
			bReader = new BufferedReader(reader1);
			String str1 = bReader.readLine();
			while(str1!=null)
			{
				System.out.println("----");
				System.out.println(str1);
				str1 = bReader.readLine();
			}
			
			
//PrintWrite
			// Write text to the file
			pw = new PrintWriter(writer);
            pw.println("Hello, PrintWriter!");
            pw.println("This is a sample text.");
            pw.printf("Formatted: %d %s%n", 123, "abc");

            System.out.println("Data has been written to " + filePath);
			
		}catch(Exception e)
		{
			System.out.println("No file");
		}finally
		{
			bWriter.flush(); //Optional
			bWriter.close();
			bReader.close();
			writer.close();
			reader.close();
		}
	}

}
