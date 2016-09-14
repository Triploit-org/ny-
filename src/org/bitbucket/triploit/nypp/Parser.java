package org.bitbucket.triploit.nypp;

import java.io.IOException;
import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import Statements.Files;
import Statements.Statement;

public class Parser {

	public static List<String> gtn = new ArrayList<String>();

	public static int __MaxCell = 31;
	public static int[] val = new int[100000];
	public static int valc = 0;
	public static int ln = 0;

	public static String tmp;
	public static String cmds;
	public static String cmd1;
	public static String cmd;
	public static boolean osf;
	public static String input = "";

	public static boolean kmt = false;
	public static boolean anw = false;

	@SuppressWarnings("resource")
	public static int parse(String rc, int lns)
	{
		char[] src = rc.toCharArray();
		ln = lns;

		for (int i = 0; i < src.length; i++)
		{
			char c = src[i];
			cmd1+=c;

			//print("vIndex: "+i);

			if (c == ' ' || c == '	' || c == '\n' || c == ';' || c == ']' || c == '}')
			{
				cmd1 = "";
			}

			cmd = cmd1.replace("null", "").toUpperCase();

			if (c == '{')
			{
				for(int x = i + 1; (src[x]+"").matches("\\s"); x++)
				{
					i = x;
				}

				i = i + 1;
				String nm = "";

				for(int x = i; !(src[x]+"").matches("}"); x++)
				{
					nm += src[x];
					i = x;
					//print("Hohle Sprungmarke: \""+nm.replace("}", "")+"\"");
				}
				nm = nm.replace(";", "");
				nm = nm.replace("}", "");

				//print("[ADD MARKE] \""+nm+"\"-"+i);
				gtn.add(nm+"-"+i);


			}

			cmd1 = "";
			cmd  = "";
		}

		for (int i = 0; i < src.length; i++)
		{
			char c = src[i];
			cmd1+=c;

			//print("Index: "+i);

			if (c == ' ' || c == '	' || c == '\n' || c == ';' || c == ']' || c == '@' || c == '_')
			{
				if (i >= src.length)
				{
					print("Error! Konnte den Code nicht parsen: Index out of Bounds/Index verlässt den Bereich des Arrays!");
				}

				for (int y = i+1; src[y] == ' ' || src[y] == '	' || src[y] == '\t' || src[y] == '\n' || src[y] == ';'; y++)
				{
					//i = y+1;


				}
				cmd1 = "";
			}

			if (c == '@')
			{
				System.out.println();
			}

			if (c == '_')
			{
				System.out.print(" ");
			}

			if (c == '?')
			{
				if (kmt)
				{
					kmt = false;
				}
				else
				{
					kmt = true;
				}
			}

			cmd = cmd1.replace("null", "").toUpperCase();
			//print("GET -> "+cmd);


			if (!kmt)
			{
				// ADD

				if (cmd.equals("ADD"))
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
						print("Wurde nach einem Befehl vieleleicht ein \";\" vergessen?");
					}
					nm = nm.replace(";", "");
					nm = nm.replace(" ", "");

					//print("[ADD] \""+nm+"\"");

					try
					{
						if (nm.startsWith("#"))
						{
							nm = nm.replace("#", "");
							int valcf = Integer.parseInt(nm);
							val[valc] += val[valcf];
						}
						else if (nm.equalsIgnoreCase("(rnd)"))
						{
							Random rand = new Random();

							int random = rand.nextInt((9999 - 0) + 1) + 0;
							val[valc] += random;
						}
						else
						{
							val[valc] += Integer.parseInt(nm);
						}
						//print("VALUE: "+val[valc]);
					}
					catch (Exception ex)
					{
						print("[ADD] Ist \""+nm+"\" eine Zahl oder fehlt ein \";\"?");
						return 0;
					}
				}

				if (cmd.equals("MOV"))
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
						print("Wurde nach einem Befehl vieleleicht ein \";\" vergessen?");
					}
					nm = nm.replace(";", "");
					nm = nm.replace(" ", "");

					//print("[ADD] \""+nm+"\"");

					try
					{
						if (nm.startsWith("#"))
						{
							nm = nm.replace("#", "");
							int valcf = Integer.parseInt(nm);
							val[valc] = val[valcf];
						}
						else if (nm.equalsIgnoreCase("(rnd)"))
						{
							Random rand = new Random();

							int random = rand.nextInt((9999 - 0) + 1) + 0;
							val[valc] = random;
						}
						else if (nm.equalsIgnoreCase("fos"))
						{
							val[valc] = OpSys.System.getOSNum();
						}
						else
						{
							val[valc] = Integer.parseInt(nm);
						}
						//print("VALUE: "+val[valc]);
					}
					catch (Exception ex)
					{
						print("[ADD] Ist \""+nm+"\" eine Zahl oder fehlt ein \";\"?");
						return 0;
					}
				}

				// REM

				if (cmd.equals("REM"))
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
						print("Wurde nach einem Befehl vieleleicht ein \";\" vergessen?");
					}
					nm = nm.replace(";", "");
					nm = nm.replace(" ", "");

					//print("[ADD] \""+nm+"\"");

					try
					{
						if (nm.startsWith("#"))
						{
							nm = nm.replace("#", "");
							int valcf = Integer.parseInt(nm);
							val[valc] -= val[valcf];
						}
						else if (nm.equalsIgnoreCase("(rnd)"))
						{
							Random rand = new Random();

							int random = rand.nextInt((9999 - 0) + 1) + 0;
							val[valc] -= random;
						}
						else
						{
							val[valc] -= Integer.parseInt(nm);
						}
						//print("VALUE: "+val[valc]);
					}
					catch (Exception ex)
					{
						print("[ADD] Ist \""+nm+"\" eine Zahl oder fehlt ein \";\"?");
						return 0;
					}
				}

				// CELL

				if (cmd.equals("CELL"))
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
						print("Wurde nach einem Befehl vieleleicht ein \";\" vergessen?");
					}

					nm = nm.replace("#", "");
					nm = nm.replace(" ", "");
					nm = nm.replace(";", "");

					//print("[CELL] \""+nm+"\"");

					try
					{
						if (valc < __MaxCell && valc > -1)
						{
							valc = Integer.parseInt(nm);
						}
						else if (valc >= __MaxCell)
						{
							System.out.println("[CELL] Konnte nicht auf Zelle #"+nm+" wechseln da sie nicht definiert ist!");
						}
						//print("CELL: "+valc);
						//print("CELL VALUE: "+val[valc]);
					}
					catch (Exception ex)
					{
						print("[CELL] Ist \""+nm+"\" eine Zahl oder fehlt ein \";\"?");
						return 0;
					}
				}

				// DEF

				if (cmd.equals("DMC"))
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
						print("Wurde nach einem Befehl vieleleicht ein \";\" vergessen?");
					}

					nm = nm.replace("#", "");
					nm = nm.replace(" ", "");
					nm = nm.replace(";", "");

					//print("[CELL] \""+nm+"\"");

					try
					{
						__MaxCell = Integer.parseInt(nm);
					}
					catch (Exception ex)
					{
						print("[CELL] Ist \""+nm+"\" eine Zahl oder fehlt ein \";\"?");
						return 0;
					}
				}

				// OPEN FILE

				if (cmd.equals("OP"))
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
						print("Wurde nach einem Befehl vieleleicht ein \";\" vergessen?");
					}

					nm = nm.replace("#", "");
					nm = nm.replace(" ", "");
					nm = nm.replace(";", "");
					nm = nm.replace("\"", "");

					//print("[CELL] \""+nm+"\"");

					try
					{
						Statements.Files.parseFile(nm);
					}
					catch (Exception ex)
					{
						print("[OP] Ist \""+nm+"\" eine Datei oder fehlt ein \";\"?");
						ex.printStackTrace();
						return 0;
					}
				}

				// IN

				if (cmd.equals("INP"))
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
						print("Wurde nach einem Befehl vieleleicht ein \";\" vergessen?");
					}

					nm = nm.replace("#", "");
					nm = nm.replace(" ", "");
					nm = nm.replace(";", "");

					//print("[CELL] \""+nm+"\"");

					try
					{
						int cell = Integer.parseInt(nm);
						Scanner s = new Scanner(System.in);
						String in = s.nextLine();

						if (in.equalsIgnoreCase("q") || in.equalsIgnoreCase("exit") || in.equalsIgnoreCase("quit"))
						{
							System.exit(0);
						}

						if (in.equals(""))
						{
							continue;
						}

						try
						{
							int value = Integer.parseInt(in);

							if (cell <= __MaxCell)
								val[cell] = value;
							else
								print("[SYS] Konnte die Zelle nicht befüllen da sie nicht definiert wurde!");
							//print("V: "+val[cell]);
						}
						catch (Exception ex)
						{
							int value = in.length();

							if (cell <= __MaxCell)
								val[cell] = value;
							else
								print("[SYS] Konnte die Zelle nicht befüllen da sie nicht definiert wurde!");
						}
						//print("CELL: "+valc);
						//print("CELL VALUE: "+val[valc]);
					}
					catch (Exception ex)
					{
						print("[IN] Ist \""+nm+"\" eine Zahl oder fehlt ein \";\"?");
						return 0;
					}
				}


				// PRV

				if (cmd.equals("PRV"))
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
						print("Wurde nach einem Befehl vielleicht ein \";\" vergessen?");
					}

					nm = nm.replace("#", "");
					nm = nm.replace(" ", "");
					nm = nm.replace(";", "");

					//print("[PRV] READ CELL \""+nm+"\"");

					try
					{
						int lvc = valc;
						valc = Integer.parseInt(nm);

						if (valc <= __MaxCell)
						{
							System.out.print(val[valc]);
							valc = lvc;
						}
						else
							print("[SYS] Konnte die Zelle nicht befüllen da sie nicht definiert wurde!");
					}
					catch (Exception ex)
					{
						print("[PRV] Ist \""+nm+"\" eine Zahl oder fehlt ein \";\"?");
						return 0;
					}
				}



				// PSTR

				if (cmd.equals("PSTR"))
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
						print("Wurde nach einem Befehl vieleleicht ein \";\" vergessen?");
					}

					nm = nm.replace("#", "");
					nm = nm.replace(" ", "");
					nm = nm.replace(";", "");

					//print("[PSTR] READ CELL \""+nm+"\"");

					try
					{
						int lvc = valc;
						valc = Integer.parseInt(nm);
						int num = val[valc];

						if (valc <= __MaxCell)
						{
							System.out.print("" + getCharForNumber(num));
							valc = lvc;
						}
						else
							print("[SYS] Konnte die Zelle nicht befüllen da sie nicht definiert wurde!");

					}
					catch (Exception ex)
					{
						print("[PSTR] Ist \""+nm+"\" eine Zahl oder fehlt ein \";\"?");
						return 0;
					}
				}

				// DEL

				if (cmd.equals("DEL"))
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
						print("Wurde nach einem Befehl vieleleicht ein \";\" vergessen?");
					}

					nm = nm.replace("#", "");
					nm = nm.replace(" ", "");
					nm = nm.replace(";", "");

					//print("[PSTR] READ CELL \""+nm+"\"");

					try
					{
						int lvc = valc;
						valc = Integer.parseInt(nm);

						if (valc <= __MaxCell)
						{
							val[valc] = 0;
							valc = lvc;
						}
						else
							print("[SYS] Konnte die Zelle nicht befüllen da sie nicht definiert wurde!");
					}
					catch (Exception ex)
					{
						print("[DEL] Ist \""+nm+"\" eine Zahl oder fehlt ein \";\"?");
						return 0;
					}
				}

				// CAL

				if (cmd.equals("CAL"))
				{
					uSpace(src, i);

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
						print("Wurde nach einem Befehl vieleleiht ein \";\" vergessen?");
					}

					nm = nm.replace("#", "");
					nm = nm.replace(" ", "");
					nm = nm.replace(";", "");

					//print("[CAL] \""+nm+"\"");

					try
					{
						if (nm.contains("+"))
						{
							String[] num = nm.split("\\+");

							if (num.length < 2 || num.length > 2)
							{
								print("[CAL] Es wurden zu viele/wenige Argumente angegeben!"+num.length);
							}
							else
							{
								int v1 = Integer.parseInt(num[0]);
								int v2 = Integer.parseInt(num[1]);

								val[v1] = val[v1] + val[v2];
								val[v2] = 0;
								//System.out.println("V1 = "+v1);
							}
						}
						else if (nm.contains("-"))
						{
							String[] num = nm.split("\\-");

							if (num.length < 2 || num.length > 2)
							{
								print("[CAL] Es wurden zu viele/wenige Argumente angegeben!"+num.length);
							}
							else
							{
								int v1 = Integer.parseInt(num[0]);
								int v2 = Integer.parseInt(num[1]);

								val[v1] = val[v1] - val[v2];
								val[v2] = 0;
							}
						}
						else if (nm.contains("*"))
						{
							String[] num = nm.split("\\*");

							if (num.length < 2 || num.length > 2)
							{
								print("[CAL] Es wurden zu viele/wenige Argumente angegeben!"+num.length);
							}
							else
							{
								int v1 = Integer.parseInt(num[0]);
								int v2 = Integer.parseInt(num[1]);

								val[v1] = val[v1] * val[v2];
								val[v2] = 0;
							}

						}
						else if (nm.contains("/"))
						{
							String[] num = nm.split("\\/");

							if (num.length < 2 || num.length > 2)
							{
								print("[CAL] Es wurden zu viele/wenige Argumente angegeben!"+num.length);
							}
							else
							{
								int v1 = Integer.parseInt(num[0]);
								int v2 = Integer.parseInt(num[1]);

								val[v1] = val[v1] / val[v2];
								val[v2] = 0;
							}

						}
						else if (nm.contains("%"))
						{
							String[] num = nm.split("\\%");

							if (num.length < 2 || num.length > 2)
							{
								print("[CAL] Es wurden zu viele/wenige Argumente angegeben!"+num.length);
							}
							else
							{
								int v1 = Integer.parseInt(num[0]);
								int v2 = Integer.parseInt(num[1]);

								val[v1] = val[v1] % val[v2];
								val[v2] = 0;
							}

						}
					}
					catch (Exception ex)
					{
						print("[CAL] Ist \""+nm+"\" eine Zahl oder fehlt ein \";\"?");
						return 0;
					}
				}

				if (cmd.equals("GT"))
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
						print("Wurde nach einem Befehl vielleicht ein \";\" vergessen?");
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
								i = Integer.parseInt(name[1]);
								//print("[GT] I: "+i);
								//print("[GT] NM0: \""+name[0]+"\"");
								//print("[GT] NM1: "+name[1]);
								//print("[GT] SEARCHF: \""+nm+"\"");
								//print("[GT] Exists "+i);
							}

						}
					}
					catch (Exception ex)
					{
						print("[GT] Error in der Programmierung!");
						return 0;
					}
				}

				// EXIT

				if (cmd.equals("EXIT"))
				{
					System.exit(0);
				}

				// EQUALS

				if (cmd.equals("EQ"))
				{
					for(int x = i + 1; (src[x]+"").matches("\\s"); x++)
					{
						i = x+1;
					}
					i = i + 1;

					String nm = "";
					String[] arg;
					try
					{
						for(int x = i; !(src[x]+"").matches(";"); x++)
						{
							nm += src[x];
							i = x;
							//print("Hohle EQ: "+nm.replace(";", ""));
						}
					}
					catch(Exception ex)
					{
						print("Wurde nach einem Befehl vielleicht ein \";\" vergessen?");
					}
					nm = nm.replace(",", " ");

					//print("= "+nm);
					arg = nm.split(" ");


					try
					{
						int ce = Integer.parseInt(arg[0]);
						int v; //= Integer.parseInt(arg[1]);
						String m = arg[2];

						if (arg[1].startsWith("#"))
						{
							arg[1] = arg[1].replace("#", "");
							int valcf = Integer.parseInt(arg[1]);
							v = val[valcf];
							//print("Zelle!");
						}
						else
						{
							v = Integer.parseInt(arg[1]);
						}

						//print("Cell: "+ce);
						//print("Vall/Cell: "+v);
						//print("Poin: "+m);

						if (val[ce] == v)
						{
							for (int d = 0; d < gtn.size(); d++)
							{
								String[] dv = gtn.get(d).split("-");
								String gn = dv[0];
								int gi = Integer.parseInt(dv[1]);

								//print("GN: "+gn);
								//print("GI: "+gi+"\n");

								if (gn.equals(m))
								{
									i = gi;
								}
							}
						}
						else
						{
						}

					}
					catch (Exception ex)
					{
						print("Ist die Zelle eine Zelle und sind die ersten Argumente Zahlen?");
					}
				}

				// NOT EQUALS

				if (cmd.equals("NEQ"))
				{
					for(int x = i + 1; (src[x]+"").matches("\\s"); x++)
					{
						i = x+1;
					}
					i = i + 1;

					String nm = "";
					String[] arg;
					try
					{
						for(int x = i; !(src[x]+"").matches(";"); x++)
						{
							nm += src[x];
							i = x;
							//print("Hohle EQ: "+nm.replace(";", ""));
						}
					}
					catch(Exception ex)
					{
						print("Wurde nach einem Befehl vielleicht ein \";\" vergessen?");
					}
					nm = nm.replace(",", " ");

					//print("= "+nm);
					arg = nm.split(" ");


					try
					{
						int ce = Integer.parseInt(arg[0]);
						int v; //= Integer.parseInt(arg[1]);
						String m = arg[2];

						if (arg[1].startsWith("#"))
						{
							arg[1] = arg[1].replace("#", "");
							int valcf = Integer.parseInt(arg[1]);
							v = val[valcf];
							//print("Zelle!");
						}
						else
						{
							v = Integer.parseInt(arg[1]);
						}

						//print("Cell: "+ce);
						//print("Vall/Cell: "+v);
						//print("Poin: "+m);

						if (val[ce] != v)
						{
							for (int d = 0; d < gtn.size(); d++)
							{
								String[] dv = gtn.get(d).split("-");
								String gn = dv[0];
								int gi = Integer.parseInt(dv[1]);

								//print("GN: "+gn);
								//print("GI: "+gi+"\n");

								if (gn.equals(m))
								{
									i = gi;
								}
							}
						}
						else
						{
						}

					}
					catch (Exception ex)
					{
						print("Ist die Zelle eine Zelle und sind die ersten Argumente Zahlen?");
					}
				}

				// KleinerGleich  "<="

				if (cmd.equals("LEQ"))
				{
					for(int x = i + 1; (src[x]+"").matches("\\s"); x++)
					{
						i = x+1;
					}
					i = i + 1;

					String nm = "";
					String[] arg;
					try
					{
						for(int x = i; !(src[x]+"").matches(";"); x++)
						{
							nm += src[x];
							i = x;
							//print("Hohle EQ: "+nm.replace(";", ""));
						}
					}
					catch(Exception ex)
					{
						print("Wurde nach einem Befehl vielleicht ein \";\" vergessen?");
					}
					nm = nm.replace(",", " ");

					//print("= "+nm);
					arg = nm.split(" ");


					try
					{
						int ce = Integer.parseInt(arg[0]);
						int v; //= Integer.parseInt(arg[1]);
						String m = arg[2];

						if (arg[1].startsWith("#"))
						{
							arg[1] = arg[1].replace("#", "");
							int valcf = Integer.parseInt(arg[1]);
							v = val[valcf];
							//print("Zelle!");
						}
						else
						{
							v = Integer.parseInt(arg[1]);
						}

						//print("Cell: "+ce);
						//print("Vall/Cell: "+v);
						//print("Poin: "+m);

						if (val[ce] < v)
						{
							for (int d = 0; d < gtn.size(); d++)
							{
								String[] dv = gtn.get(d).split("-");
								String gn = dv[0];
								int gi = Integer.parseInt(dv[1]);

								//print("GN: "+gn);
								//print("GI: "+gi+"\n");

								if (gn.equals(m))
								{
									i = gi;
								}
							}
						}
						else
						{
						}

					}
					catch (Exception ex)
					{
						print("Ist die Zelle eine Zelle und sind die ersten Argumente Zahlen?");
					}
				}

				// GrößerGleich   ">="

				if (cmd.equals("GEQ"))
				{
					for(int x = i + 1; (src[x]+"").matches("\\s"); x++)
					{
						i = x+1;
					}
					i = i + 1;

					String nm = "";
					String[] arg;
					try
					{
						for(int x = i; !(src[x]+"").matches(";"); x++)
						{
							nm += src[x];
							i = x;
							//print("Hohle EQ: "+nm.replace(";", ""));
						}
					}
					catch(Exception ex)
					{
						print("Wurde nach einem Befehl vielleicht ein \";\" vergessen?");
					}
					nm = nm.replace(",", " ");

					//print("= "+nm);
					arg = nm.split(" ");


					try
					{
						int ce = Integer.parseInt(arg[0]);
						int v; //= Integer.parseInt(arg[1]);
						String m = arg[2];

						if (arg[1].startsWith("#"))
						{
							arg[1] = arg[1].replace("#", "");
							int valcf = Integer.parseInt(arg[1]);
							v = val[valcf];
							//print("Zelle!");
						}
						else
						{
							v = Integer.parseInt(arg[1]);
						}

						//print("Cell: "+ce);
						//print("Vall/Cell: "+v);
						//print("Poin: "+m);

						if (val[ce] > v)
						{
							for (int d = 0; d < gtn.size(); d++)
							{
								String[] dv = gtn.get(d).split("-");
								String gn = dv[0];
								int gi = Integer.parseInt(dv[1]);

								//print("GN: "+gn);
								//print("GI: "+gi+"\n");

								if (gn.equals(m))
								{
									i = gi;
								}
							}
						}
						else
						{
						}

					}
					catch (Exception ex)
					{
						print("Ist die Zelle eine Zelle und sind die ersten Argumente Zahlen?");
					}
				}

				// IF -> NOT WORKING

				if (cmd.equals("IFQ-X1123gH45"))
				{
					uSpace(src, i);

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
						print("Wurde nach einem Befehl vielleicht ein \";\" vergessen?");
					}

					nm = nm.replace(";", "");
					nm = nm.replace("  ", "");
					nm = nm.replace("	", "");

					//try
					//{
						nm = nm.substring(1);
						//print("COND: "+nm);
						String[] con = nm.replace("#", "").split(" ");
						String[] com = null;
						String com1 = "";
						String com2 = "";
						int comc = 0;
						int cell = 0;
						int arg = 0;

						for(int x = 0; x < con.length; x++)
						{
							//print(con[x] + "		| " + x);

							if (con[x].equals("GT") || con[x].startsWith("{") || con[x].startsWith("<") || con[x].equals("DEL") || con[x].equals("OP") || con[x].equals("PSTR") || con[x].equals("IN") || con[x].equals("GT") || con[x].equals("PRV") || con[x].equals("SAY") || con[x].equals("CAL") || con[x].equals("REM") || con[x].equals("ADD") || con[x].equals("[WND]") || con[x].equals("[END]"))
							{
								if (comc == 0)
								{
									try
									{
										if (con[x+1].equals("ELSE"))
										{
											System.out.println("*[ERR] Nach einer Goto-Anweisung muss eine 0 stehen! (IF ... == ... <ABC> 0 ELSE ...)");
											return 0;
										}
										else
										{
											com1 = con[x] + " " + con[x+1];
											com = com1.split(" ");
										}
									}
									catch (Exception ex)
									{
										com1 = con[x];
									}

									if (com1.equals("NOTH"))
									{
										print("Als erstes Argument darf kein NOTH stehen!");
										return 0;
									}
									
									//print(com[0]+"#");
									
									if (com[0].startsWith("<"))
									{
										print("GOTO in IF erkannt!");
										
										String nm1 = com[0].replace("<", "").replace(">", "").replace(";", "");
										print(nm1+"##");
										
										for(int x1 = 0; x1<gtn.size(); x1++)
										{
											String name[] = gtn.get(x1).split("-");

											if(name[0].equals(nm1))
											{
												i = Integer.parseInt(name[1]);
												System.out.println();
												print("[GT] I: "+i);
												print("[GT] NM0: \""+name[0]+"\"");
												print("[GT] NM1: "+name[1]+"\n");
												
												print("[GT] SEARCHF: \""+nm1+"\"");

												print("[GT] Exists "+i);
											}

										}
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

									if (com2.equals("NOTH"))
									{
										com2 = "DONOTH";
										print("2 NOTH!");
									}
									else
									{
										
									}

									x += 1;
								}
							}
						}

						com1 = com1+";";
						com2 = com2+";";
						print("C1: \""+com1+"\"\n	C2: \""+com2+"\"\n");

						if (con[0] != "")
						{
							cell = Integer.parseInt(con[0].replace("#", ""));
							if (cell < __MaxCell && cell >= 0)
								System.out.print("");
							else
								System.out.println("[IF] Zelle nicht gefunden!");
						}

						if (con[1].equals("=="))
						{
							try
							{
								arg = Integer.parseInt(con[2]);
								print("ARG: "+arg);
								print("CELL: "+val[cell]);

								if(val[cell] == arg)
								{
									Parser.parse(com1, ln);
									print("[IF] TRUE; \""+com1+"\"");
								}
								else
								{
									if (com2.equalsIgnoreCase("NOTH"))
									{
										Parser.parse(com2, 0);
										print("[IF] DONOTH");
									}
									else
									{
										com2 = com2.replace("<", "").replace(">", "").replace(";", "");
										com2 = "GT "+com2+";";
										print("[IF] FALSE: RUN \""+com2+"\"");
										Goto(com2, i, src);
									}
								}
							}
							catch (Exception ex)
							{
								print("Sind sie sich sicher das \""+con[2]+"\" eine Zahl ist oder feht da ein Leerzeichen?");
							}
						}

						else if (con[1].equals("NOT"))
						{
							try
							{
								arg = Integer.parseInt(con[2]);
								//print("ARG: "+arg);
								if(val[cell] != arg)
								{
									Parser.parse(com1, ln);
									print("[IFN] TRUE");
								}
								else
								{
									if (com2.equalsIgnoreCase("NOTH"))
									{

									}
									else
									{
										Parser.parse(com2, ln);
									}
									print("[IFN] FALSE");
								}
							}
							catch (Exception ex)
							{
								print("Sind sie sich sicher das \""+con[2]+"\" eine Zahl ist oder feht da ein Leerzeichen?");
							}
						}
						else
						{

						}


					//}
					/*catch (Exception ex)
					{
						print("[IF] Error im Statement!");
						return 0;
					}*/
				}

				if (cmd.equals("SAY"))
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
						print("Wurde nach einem Befehl vielleicht ein \";\" vergessen?");
					}

					char[] str = nm.substring(1, nm.length()-1).toCharArray();

					for(int z = 0; z<str.length; z++)
					{
						System.out.print(str[z]);
					}
				}

				

				if (cmd.equals("[WND"))
				{
					Files.wnd = false;
				}

				if (cmd.equals("[OS"))
				{
					osf = true;
				}

				if (cmd.equals("[MAIN"))
				{
					if (Main.mainfile.equals("NOTSETALPHA3DA"))
					{
						Main.mainfile = Main.afile;
						//print("MainFile: "+Main.mainfile);
					}
					else
					{
						print(" [MAIN] Error: "+Main.afile+": Mainfile is \""+Main.mainfile+"\"!");
					}
				}


				if (cmd.equals("[CLS"))
				{
					try
					{
						if (isWindows())
							Runtime.getRuntime().exec("cls");
						else
							System.out.print(String.format("\033[2J"));
					}
					catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (cmd.equals("[END"))
				{
					System.out.println();
					return 0;
				}
				
			}

		}

		return 0;
	}

	public static void print(String t)
	{
		System.out.println("* [SYS:"+ln+"] "+t);
		//System.out.println(Colors.ANSI_CYAN+"	Zeile: "+ln);
	}

	public static void Goto(String t, int i, char[] src)
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
			print("Wurde nach einem Befehl vielleicht ein \";\" vergessen?");
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
					i = Integer.parseInt(name[1]);
					//print("[GT] I: "+i);
					//print("[GT] NM0: \""+name[0]+"\"");
					//print("[GT] NM1: "+name[1]);
					//print("[GT] SEARCHF: \""+nm+"\"");
					//print("[GT] Exists "+i);
				}

			}
		}
		catch (Exception ex)
		{
			print("[GT] Error in der Programmierung!");
			return;
		}
	}

	public static void write(String t)
	{
		System.out.println(t);
	}

	public static boolean isWindows() {
        String OS = System.getProperty("os.name").toLowerCase();
        return (OS.indexOf("win") >= 0);
    }

	public static String getCharForNumber(int i) {
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
	}

	  public static final boolean isNL( char[] charArray, int index )
	  {
	      if ( ( charArray == null ) || ( charArray.length == 0 ) || ( index < 0 ) || ( index >= charArray.length ) )
	      {
	          return false;
	      }
	      else
	      {
	          return ( ( ( charArray[ index ] == '\n' ) ||
	                   ( charArray[ index ] == '\r' ) )  ? true : false );
	      }
	  }

	public static void uSpace(char[] src, int i)
	{
		for(int x = i + 1; (src[x]+"").matches("\\s") || (src[x]+"").matches(";") || (src[x]+"").matches("\\t") || (src[x]+"").matches(" ") || (src[x]+"").matches(",") || (src[x]+"").matches("	"); x++)
		{
			i = x;
		}
	}

}

class Colors {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
}
