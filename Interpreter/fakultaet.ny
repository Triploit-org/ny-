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







? int Zahl;                             ------------?                     ? DIM $Zahl AS INTEGER            ?
? int temp;                             ------------?                     ? DIM $temp AS INTEGER            ?
                                                                          ? PRINT "Fakultät: "              ?
? cin >> Zahl;                          ------------?                     ? INPUT $Zahl;                    ?
? temp = Zahl;                          ------------?                     ? $temp = $Zahl                   ?
?  temp = Zahl;                         ------------?                     ?  $temp = $Zahl                  ?
?  c = temp - 1;                        ------------?                     ?  $c = $temp - 1                 ?
? int b;                                ------------?                     ? DIM $b AS INTEGER               ?
? b = 1;                                ------------?                     ? $b = 1                          ?
? if (b == temp)                        ------------?                     ? IF $b = $temp THEN GOTO mainE   ?
? if (b >(=) temp)                      ------------?                     ? IF $b > $temp THEN GOTO mainE   ?
? Zahl = Zahl * c;                      ------------?                     ? $Zahl = $Zahl * $c              ?
? c--;                                  ------------?                     ? $c = $c - 1                     ?
? cout << "Ergebnis: " << Zahl << endl; ------------?                     ? PRINT "Ergebnis: ",Zahl         ?

?
    Originaler C Code (https://www.easy-coding.de/Thread/7964-Fakult%C3%A4t-berechnen/ von Aalon):


        #include <iostream>
        using namespace std;
        int main()
        {
        	int Zahl, temp, c;

        	cout << "Fakultaet von: ";
        	cin >> Zahl;
        	temp = Zahl;
        	c = temp - 1;
        	for(int b=1;b<temp;b++)
        	{
        		Zahl = Zahl * c;
        		c--;
        	}

        	cout << "Ergebnis: " << Zahl << endl;

        	system("PAUSE");
        	return 0;
        }
?
