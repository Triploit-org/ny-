[wnd]
[main]

{init}
  {fosf}
    cell  #10;
    mov   fos;

    eq    #10,1,unix;
    eq    #10,2,solaris;
    eq    #10,3,osx;
    eq    #10,4,windows;
    eq    #10,5,other;
{initE}

{oscall}
  {unix}
    say   "Schoen einen Linux/Unix Nutzer zu treffen!";@
    gt    fw;

  {solaris}
    say   "Soetwas seltenes wie Solaris sieht man nicht oft!";@
    gt    fw;

  {osx}
    say   "Immerhin ein BSD abkömmling, OSX ist auch ok :-)!";@
    gt    fw;

  {windows}
    say   "Aha, ein standard Windows-Rechner!";@
    gt    fw;

  {other}
    say   "Welches Betriessystem nutzt du? Ich konnte es";@
    say   "leider nicht erkennen!";@
    gt    fw;
{oscallE}


{begin}
  {fw}
    say   "Bitte vergiss nicht: Du kannst nur Zahlen eingeben!";@@
    say   "#4 > ";
    inp   #4;

  {test}
    say     "#0 > ";
    inp     #0;

    eq      #0,#4,ende;
    leq     #0,#4,errork;
    geq     #0,#4,errorg;

    prv     #0;@
    gt      test;


  {ende}
    say     "Beide Eingaben waren gleich gross!";@
    gt      test;


  {errork}
    say     "Kleiner als #4!";@
    {iloop1}
      eq      #0,#4,test;
      cell    #0;
      add     1;
      prv     #0;@
      gt      iloop1;
    gt      test;


  {errorg}
    say     "Groesser als #4!";@
    {iloop2}
      eq      #0,#4,test;
      cell    #0;
      rem     1;
      prv     #0;@
      gt      iloop2;
    gt      test;
{beginE} {end}

[end]
