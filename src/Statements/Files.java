package Statements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.bitbucket.triploit.nypp.Main;
import org.bitbucket.triploit.nypp.Parser;

public class Files
{

	public static boolean wnd = true;
	
	public static void parseFile(String nm)
	{
		File file = new File(nm);
		//File file = new File("/home/armisedr/Desktop/Dateien/test.ny");
		Main.afile = nm;
		
		if (file.getName().endsWith(".ny") || file.getName().endsWith(".nypp") || file.getName().endsWith(".npp") || file.getName().endsWith(".n"))
		{
	        String line;
			BufferedReader br = null;
			
			try 
			{
				int i = 0;
				try
				{
				br = new BufferedReader(new FileReader(file));
				}
				catch(IOException ec)
				{
					Parser.print("[OP] Datei nicht gefunden!");
				}
				String code = "";
				  
		        while (null != (line = br.readLine())) {
		        	//Parser.print("PräLine [ADD] :"+line);
		        	code += line+"\n";
		        	i++;
		        } 

	        	//Parser.print("PräLine [END] :\n"+code);
	            Parser.parse(code, i);
		        
		        if (Parser.anw)
		        {
		        	Parser.print("Es wurde vergessen eine Anweisung zu schliessen!");
		        }
		        
		        if (Parser.kmt)
		        {
		        	Parser.print("Es wurde ein ?Kommentar? vergesen zu schliessen!");
		        }
			}
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
				System.out.println("* [SYS] Da hat etwas nicht funktioniert!");
				
			}
			catch (IOException e)
			{
				Parser.print("[OP] Datei konnte nicht gefunden werden!");
				e.printStackTrace();
			} 
			finally 
			{
	          if (null != br) 
	          {
	            try {
	              br.close();
	            } 
	            catch (IOException e) 
	            {
	                e.printStackTrace();
	            } 
	          }
			}
			

			if (wnd)
				System.out.println("* [END] RTRN: 0");
		}
		else
		{
			Parser.print("Error: Datei ist keine Ny-Datei! (Endung muss \".ny\" sein)");
		}
		
	}

}
