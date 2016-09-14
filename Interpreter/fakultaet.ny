[wnd]
[main]
dmc   #20;
?   #0  = Zahl  ? ?
?   #1  = temp  ? ?
?   #2  = c     ? ?
?   #3  = b     ? ?

{init}
  cell  #0;
  cell  #1;
  say   "Fakultaet (#0) > ";

  inp   #0;
  mov   #0;

  cell  #2;
  mov   #1;
  rem   1;
{initE}


{main}
  cell  #12;
  mov   #2;

  cell  #3;
  add   1;

  eq    #3,#1,mainE;
  geq   #3,#1,mainE;
  cal   #0*#2;

  cell  #2;
  mov   #12;
  rem   1;

  gt    main;
{mainE}

say   "Ergebnis (#0): ";
prv   #0;@

[end]
