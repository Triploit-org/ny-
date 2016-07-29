package Statements;

import org.bitbucket.triploit.nypp.Parser;

public class IF
{
	int tmpi = 0;

	public static void exec(char[] src, int i, int[] val)
	{
			Parser.uSpace(src, i);
			
			i = i + 1;
			String nm = "";
			
			try
			{
				for(int x = i; !(src[x]+"").matches(";"); x++)
				{
					nm += src[x];
					i = x;
					//print("Hohle IF: "+nm.replace(";", ""));
				}
			}
			catch(Exception ex)
			{
				Parser.print("Wurde nach einem Befehl vielleicht ein \";\" vergessen?");
			}
			
			nm = nm.replace(";", "");
			
			//try
			//{
				nm = nm.substring(1);
				//print("COND: "+nm);
				String[] con = nm.replace("#", "").split(" ");
				String com1 = "";
				String com2 = "";
				int comc = 0;
				int cell = 0;
				int arg = 0;
				
				for(int x = 0; x < con.length; x++)
				{		
					
					if (con[x].equals("GT") || con[x].equals("DEL") || con[x].equals("PSTR") || con[x].equals("IN") || con[x].equals("GT") || con[x].equals("PRV") || con[x].equals("SAY") || con[x].equals("CAL") || con[x].equals("REM") || con[x].equals("ADD") || con[x].equals("[WND]") || con[x].equals("[END]"))
					{
						if (comc == 0)
						{
							com1 = con[x] + " " + con[x+1];
							
							if (com1.equals("NOTH"))
							{
								com1 = "";
								Parser.print("1 NOTH!");
							}
							
							x += 1;
							comc++;
						}
						else
						{
							try
							{
								com2 = con[x] + " " + con[x+1];
							}
							catch (Exception ex)
							{
								com2 = con[x];										
							}
							
							if (com2.equals("NOTH") || con[6].equals("NOTH"))
							{
								com2 = "DONOTH";
								Parser.print("2 NOTH!");
							}
							
							x += 1;
						}
					}
				}

				com1 = com1+";";
				com2 = com2+";";
				//Parser.print("C1: \""+com1+"\"\n	C2: \""+com2+"\"\n");
				
				if (con[0] != "")
				{
					cell = Integer.parseInt(con[0].replace("#", ""));
					if (cell <10&&cell>=0)
						System.out.print("");
					else
						System.out.println("[IF] Zelle nicht gefunden!");
				}
				
				if (con[1].equals("=="))
				{
					try
					{
						arg = Integer.parseInt(con[2]);
						//print("ARG: "+arg);
						//print("CELL: "+val[cell]);
						
						if(val[cell] == arg)
						{
							//Parser.print("[IF] TRUE; \""+com1+"\"");
							if (com1.equalsIgnoreCase("GT"))
							{
								Goto.exec(com1.toCharArray(), 0, Parser.gtn);
							}
							else
							{
								Parser.parse(com1, 0);
							}
						}
						else
						{
							if (com2.equalsIgnoreCase("NOTH"))
							{
								//Parser.parse(com2, ln);
								//Parser.print("[IF] DONOTH");
							}
							else
							{
								//Parser.print("[IF] FALSE; \""+com2+"\" I="+i);
								Parser.parse(com2, 0);
							}
						}
					}
					catch (Exception ex)
					{
						Parser.print("Sind sie sich sicher das \""+con[2]+"\" eine Zahl ist oder feht da ein Leerzeichen?");
					}
				}
				
				else if (con[1].equals("NOT"))
				{
					try
					{
						arg = Integer.parseInt(con[2]);
						//print("ARG: "+arg);
						//print("CELL: "+val[cell]);
						
						if(val[cell] != arg)
						{
							//Parser.print("[IF] TRUE; \""+com1+"\"");
							if (com1.equalsIgnoreCase("GT"))
							{
								Goto.exec(com1.toCharArray(), 0, Parser.gtn);
							}
							else
							{
								Parser.parse(com1, 0);
							}
						}
						else
						{
							if (com2.equalsIgnoreCase("NOTH"))
							{
								//Parser.parse(com2, ln);
								//Parser.print("[IF] DONOTH");
							}
							else
							{
								//Parser.print("[IF] FALSE; \""+com2+"\" I="+i);
								Parser.parse(com2, 0);
							}
						}
					}
					catch (Exception ex)
					{
						Parser.print("Sind sie sich sicher das \""+con[2]+"\" eine Zahl ist oder feht da ein Leerzeichen?");
					}
				}
				else
				{
					Parser.print("[IF] Unbekannter Vergleichs-Operator \""+con[1]+"\"!");
				}
									
		
	}

}
