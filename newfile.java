import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		String fileName = "";
		String text = "";
		File file = new File("");
		
		print("File Name: ");
		fileName = s.nextLine();
		try {
			file = new File(fileName);
			if (file.createNewFile())
				println("File Created "+file.getName());
			else
				println("Can't Create The File");
		}catch (IOException e){
			print("Error: ");
			e.printStackTrace();
		}
		println(fileName+" Opened!!");
		try{
			while (true){
				print(">> ");
				text += s.nextLine();
				println("Select option: \n\ts => [save]\n\tsh => [show]\n\tshf => [show file]\n\tq => [quit]\n\tsq => [save and quit]\n\td => [delete]");
				String option = s.nextLine();
				if (option.equals("q"))
					break;
				else if (option.equals("sq")){
					FileWriter fileEditabel = new FileWriter(fileName);
					fileEditabel.write(text);
					fileEditabel.close();
					break;
				}else if (option.equals("s")){
					FileWriter fileEditabel = new FileWriter(fileName);
					fileEditabel.write(text);
					fileEditabel.close();
				}else if (option.equals("sh")){
					println(fileName+".......");
					print(text);
					println("\n...............");
				}else if (option.equals("shf")){
					try {
						Scanner reader = new Scanner(file);
						println(fileName+".......");
						while (reader.hasNextLine())
							print(reader.nextLine());
						reader.close();
						println("\n...............");
					}catch (IOException e){
						print("Error: ");
						e.printStackTrace();
					}
				}else if (option.equals("d")){
					if (file.delete()){
						println(fileName+" was deleted");
						break;
					}else
						println(fileName+" failed to delete");
				}
					
			}
		}catch (IOException e){
			print("Error: ");
			e.printStackTrace();
		}
	}
	public static void print(Object text){
		System.out.print(text);
	}
	public static void println(Object text){
		System.out.println(text);
	}
}