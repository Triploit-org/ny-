package org.bitbucket.triploit.nypp;

import java.io.IOException;

import Statements.Files;
	
public class Main {

	public static String mainfile = "NOTSETALPHA3DA";
	public static String afile = "";
	
	public static void main(String[] args) throws IOException 
	{ 
		System.out.println("Ny++ Interpreter - V0.4.8\nCopyright (c) Triploit\nAlle Rechte vorbehalten.\n");
		
		Files.parseFile(args[0]);
		
	}

}
