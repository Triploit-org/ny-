[wnd]
[main]

{init}
  {input}
    say   "1 > ";
    inp   #0;

    say   "2 > ";
    inp   #1;
{initE}

{main}
  {initv}
    cell  #2;
    mov   #0;

    cell  #3;
    mov   #1;

  {addtition}
    cal   #0+#1;
    say   "Addition: ";
    prv   #0;@

    cell  #1;
    mov   #3;
    cell  #0;
    mov   #2;

  {subtraktion}
    cal   #0-#1;
    say   "Subtraktion: ";
    prv   #0;@

    cell  #1;
    mov   #3;
    cell  #0;
    mov   #2;

  {multiplikation}
    cal   #0*#1;
    say   "Multiplikation: ";
    prv   #0;@

    cell  #1;
    mov   #3;
    cell  #0;
    mov   #2;

  {division}
    cal   #0/#1;
    say   "Division: ";
    prv   #0;@

    cell  #1;
    mov   #3;
    cell  #0;
    mov   #2;

  @say  "Fertig gerechnet!";@
  {endcalc}
    say   "1. Nochmal";@
    say   "2. Ende";@

    inp   #4;
    eq    #4,1,init;
    eq    #4,2,mainE;

    neq   #4,1,err;
    neq   #4,2,err;

  {err}
    say   "Diese Eingabe war Falsch!";@
    gt    endcalc;
{mainE}

[end]
