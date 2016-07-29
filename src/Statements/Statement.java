package Statements;

import java.io.IOException;

import org.bitbucket.triploit.nypp.Parser;

public class Statement
{
	public static boolean loadAnw(String anw)
	{
		anw = anw.replace("null", "");
		
		if (anw.equals("IN"))
		{
			System.out.print(Parser.input);
			return true;
		}
		else if (anw.equals("WND"))
		{
			Files.wnd = false;
			return true;
		}
		else if (anw.equals("END"))
		{
			System.exit(0);
			return true;
		}
		else if (anw.equals("CLS"))
		{
			try
			{
				if (Parser.isWindows())
					Runtime.getRuntime().exec("cls");
				else 
					System.out.print(String.format("\033[2J"));
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		else
		{

			Parser.print("Error: Keine Anweisung mit dem Aufruf \""+anw+"\"!");
			return false;
		}
	}
}
