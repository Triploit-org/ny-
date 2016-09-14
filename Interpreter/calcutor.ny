[wnd]
[main]

{init}
  {vinit}
    cell  #11;
    mov   2;

    say   "0 > ";
    inp   #0;
    say   "1 > ";
    inp   #1;

    cell  #2;
    mov   #0;

    cell  #3;
    mov   #1;
{initE}

{main}
  gt    dz;
  {gz}
    say   "Die eingegebene Zahl ist gerade!";@
    gt    dze;
  {ngz}
    say   "Die eingegebene Zahl ist nicht gerade!";@
    gt    dze;
  {dz}
    cal   #1%#11;

    eq    #1,0,gz;
    neq   #1,0,ngz;

    cell  #0;
    mov   #2;

    cell  #1;
    mov   #3;
    {dze}
  {addition}
    cal   #0+#1;
    say   "Addition: ";
    prv   #0;@

    cell  #0;
    mov   #2;

    cell  #1;
    mov   #3;

  {subtraktion}
    cal   #0-#1;
    say   "Subtraktion: ";
    prv   #0;@

    cell  #0;
    mov   #2;

    cell  #1;
    mov   #3;

  {multiplikation}
    cal   #0*#1;
    say   "Multiplikation: ";
    prv   #0;@

    cell  #0;
    mov   #2;

    cell  #1;
    mov   #3;

  {division}
    cal   #0/#1;
    say   "Division: ";
    prv   #0;@

    cell  #0;
    mov   #2;

    cell  #1;
    mov   #3;

  say   "Berechnung beendet!";@@
  {endcalc}
    say   "1. Wiederholen";@
    say   "2. Ende";@

    say   "> ";
    inp   #4;
    eq    #4,1,init;
    eq    #4,2,mainE;

    neq   #4,1,err;
    neq   #4,2,err;

  {err}
    say  "Die Eingabe war nicht korrekt!";@
    gt   endcalc;

{mainE}
[end]
