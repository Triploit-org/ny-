[wnd]
[main]

{init}
  cell  #1;
  mov   1;

  cell  #2;
  mov   2;
{initE}

{main}
  prv   #1;@
  cell  #3;
  mov   #1;

  cell  #4;
  mov   #2;

  cal   #1+#2;

  cell  #2;
  mov   #1;

  cell  #1;
  mov   #4;

  geq   #2,0,main;
{mainE}

say   "Alle Zahlen der Fibonacci Folge im Rahmen des Integers berechnet!";

[end]
