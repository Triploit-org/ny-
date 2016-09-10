package org.bitbucket.triploit.nypp;

import Statements.Files;

import java.io.IOException;
	
public class Main {

	public static String mainfile = "NOTSETALPHA3DA";
	public static String afile = "";
	
	public static void main(String[] args) throws IOException 
	{ 
		System.out.println("Ny++ Interpreter - V10916\nCopyright (c) Triploit\nAlle Rechte vorbehalten.\n");
		
		Files.parseFile(args[0]);
		
	}

}
