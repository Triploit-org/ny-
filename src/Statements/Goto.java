package Statements;

import java.util.List;

import org.bitbucket.triploit.nypp.Parser;

public class Goto
{
	
	public static int exec(char[] src, int i, List<String> gtn)
	{
		
		for(int x = i + 1; (src[x]+"").matches("\\s"); x++)
		{
			i = x;
		}
		
		i = i + 1;
		String nm = "";
		
		try
		{
			for(int x = i; !(src[x]+"").matches(";"); x++)
			{
				nm += src[x];
				i = x;
				//print("Hohle Zahl: "+nm.replace(";", ""));
			}
		}
		catch(Exception ex)
		{
			Parser.print("Wurde nach einem Befehl vielleicht ein \";\" vergessen?");
		}
		nm = nm.replace("#", "");
		nm = nm.replace(" ", "");
		nm = nm.replace(";", "");
		nm = nm.replace("{", "");
		nm = nm.replace("}", "");
		
		try
		{
			for(int x = 0; x<gtn.size(); x++)
			{
				String name[] = gtn.get(x).split("-");
				
				if(name[0].equals(nm))
				{
					Parser.print("[GT] I="+i);
					i = Integer.parseInt(name[1]);
					//Parser.print("[GT] NM0: \""+name[0]+"\"");
					//Parser.print("[GT] NM1: "+name[1]);
					//Parser.print("[GT] SEARCHF: \""+nm+"\"");
					//Parser.print("[GT] Exists and sets I="+i+"\n");
				}								

			}
		}
		catch (Exception ex)
		{
			Parser.print("[GT] Error in der Programmierung!");
			return 0;
		}
		return i;
		
	}

}
