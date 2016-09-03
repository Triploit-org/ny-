[wnd]
[main]

{main}
  say   "Hallo Welt";@ ? PRINT "HALLO WELT" ? 
  say   "1. Mach irgendwas";@
  say   "2. Nochmal";@
  say   "3. Sag Nochmal Hallo und Ende";@
  say   "4. Ende";@

  say   "> ";
  del   #0;
  inp   #0;@

  eq    #0,1,A; ? IF #0 == 1 THEN GOTO A ? 
  eq    #0,2,B; ? IF #0 == 2 THEN GOTO B ? 
  eq    #0,3,C; ? ... ?
  eq    #0,4,D;

  keq   #0,1,ERR; ? IF #0 < 1 GOTO ERR ?
  geq   #0,4,ERR; ? IF #0 > 4 GOTO ERR ?

  neq   #0,1,ERR; ? Kommentar ?
  neq   #0,2,ERR; ? IF #0 != 2 GOTO ERR ?
  neq   #0,3,ERR;
  neq   #0,4,ERR;

{ERR} ? ERR: ? 
  say   "ERROR: Du hast eine Zahl eingegeben die mit keiner aus dem Menü übereinanderstimmte!";@@
  gt      main;
  [end]

{A}
  cell    #3;
  add   1;
  cell    #0;

  say   "Hab 1 zu #3 hinzugefügt.";@
  say   "Wert von #3: ";
  prv    #3;@
  gt     main;

{B}
  gt    main;

{C}
  say   "Hallo Welt!";@
  gt     D;

{D}
  say   "Programme beendet!";@
  [end]

@
[end]
