**NÝ++ - Der kalte Polarwind kommt zu euch**
--------

NÝ++ ist in Java geschrieben, was nicht gerade von schnelligkeit zeugt, jedoch Buggs vermindert. NÝ++ ist eine wunderschöne assemblerartige Programmiersprache, die es verdient auf einem Rechner installiert zu werden, da sie einfach, buggfrei und schnell zu lehrnen ist.

Auch wenn sie vom Syntax her, Assmbler ähnlich sieht, ist sie jedoch komplett anders im Gebrauch. Jedoch könnte sie, wie auch TPL, zum verstehen von Assemblertechniken benuzt werden.

###**Was hier vorgestellt wird**
* 0.1 Der Interpreter
* 0.2 Das Starten von Dateien
* 1.0 Variablen und Werte
* 1.1 Ausgabe
* 1.2 Rechnen
* 1.3 Goto Statements
* 1.4 Eingabe
* 1.5 If-Abfragen

###**0.1 Der Interpreter**

Der Interpreter liegt im Verzeichnis `Interpreter/jar/NÝ++.jar`, es wäre möglich ihn mit dem Befehl `java -jar NÝ++.jar [Dateiname.ny]` auszuführen.

###**0.2 Das Starten von Dateien**

Um den Interpreter gleich im Interpreter-Verzeichnis ausführen zu können gibt es die Datei `nypp` (für Linux und OSX) und die Datei `nypp.bat` (für Windows).

####**Linux und OSX**
Öffne ein Terminal im Interpreter-Verzeichnis und tippe `./nypp [DeineDatei.ny]` ein und der Interpreter führt die Datei aus.

####**Windows**
Öffne die CMD im Interpreter-Verzeichnis und Tippe `nypp [DeineDatei.ny]` ein und die Datei wird ausgeführt.

####**Beispiel - Alle OS's**
Wendet sattt `[DeineDatei.ny]`, mal `test.ny` und die Datei test.ny wird ausgeführt. In der Datei `test.ny` sind ca 76% der Programmiersprache enthalten.

--------------------

##**1 NÝ++ Crashkurs**

Hier werden jetzt die Grundlagen der Sprache erklärt.

###**1.0 Variablen und Werte**

In NÝ++ gibt es wie in Galdur, TPL und Ny Zellen. In NÝ++ gibt es 30 Zellen die genutzt werden können. Sie tragen keine unterschiedliche Namen, sondern werden mit `cell #[nummer];` angewählt. Wenn Beispielsweise die Zelle #3 ausgewählt (`cell #3;`) wird, dann gelten die nächsten Befehle nur für diese Zelle.

> Tipp: In NÝ++ beginnen Zellen immer mit einem #. Beispiel. #1 oder #13

Sobald eine andere Zelle angewählt wurde, zum Beispiel Zelle 7 (`cell #7;`), dann gelten die Befehle danach zur Zelle 7.

Um nun zum Beispiel den Wert von Zelle #1 auf 301 zu setzen, benutzen wir entweder das Schlüsselwort `add` oder `mov`.

`ADD` und `MOV` erklärt:

* ADD
	> Add erhöht den Wert, bzw. fügt einen Wert hinzu.

* MOV
	> Mov löscht die Zelle zuerst und setzt dann ihren Wert.

* REM
  > Wurde noch nicht angesprochen, zieht einen Wert ab.

Beides kann früher oder später, wenn man es nicht begriffen hat, zu Fehlern führen. Ein Beispiel dafür:
Wie wollen jetzt eine Zelle zwei mal verändern, zuerst tue ich das mit ADD, dan mit MOV.

* MOV

So sieht es bei MOV aus:

    cell    #0;
    mov  1;
    mov  2;

Der Wert von der Zelle #0, wird zuerst auf 1 und dann auf 2 gesetzt. Das bedeutet am ende haben wir die 2 in #0 stehen.

* ADD

So siet es bei ADD aus:

    cell #0;
    add 1;
    add 2;


Dem Wert von #0 wird erst 1 hinzugefügt und dann 2. Das bedeutet wir haben zum Schluss eine 3 drin stehen, da `1+2=3`.

Bei ADD und MOV ist es auch möglich, Zellen in Zellen zu verschieben oder zu addieren. Dies geht dann so:

    cell #0;
    add 3;
    cell #1;
    add 1;
    add #0;

Am Ende steht eine 4 in Zelle 1, da zuerst zu Zelle #0 3, dann zu Zelle #1, 1 hinzugefügt wurde und dann der Wert von Zelle #0 in Zelle #1 addiert wird.

Bei MOV dann so:

    cell #2;
    mov 1;
    cell #3;
    mov #2;
Am Ende steht dann die 1 in #3, da sie dorthin verschoben wird. Natürlich behält auch #2 ihren Wert.

* REM
Die Zelle wird gelöscht:
    cell #3;
    add 2;
    rem 2;    

Zur Zelle #3 wird am Anfang 2 dazugezählt und dann wieder 2 abgezogen. Dies geht natürlich auch mit Zellen.

**Zellen auf 0 setzen**

Das geht mit der Funktion `del [zelle];`, diese Funktion löscht den Wert von einer Zelle komplett:

    cell #3;
    add 3;
    del #3;

Am Anfang werden 3 hinzugezählt und dann wird der Wert auf 0 gesetzt. So einfach ist das.

###**1.0.1 Header**

Header stehen immer in eckigen Klammern und beschreiben einen einzigen Befehl der dem Parser sagt wie er den Code behandeln soll:

> Tipp: Kommentare beginnen und enden mit einem ?, sie werden vom Interpreter ignoriert.

    [end] ? Beendet ein Programm ?
    [wnd] ? Es kommt keine RETURN Nachricht beim beenden ohne [end] ?
    [main] ? Legt die Main-Date fest, ist aber eher unwichtig ?

Diese Header (außer [end]), sollten immer am Anfang einer Datei stehen:

    [wnd] ? Retrun wird nicht angezeigt ?
    [main] ? Dies hier ist die Main-Datei ?
    cell #0;
    add 5;
    cell #1;
    add #0;
    add 4;
    [end] ? Programm wird hier unwiederruflich beendet ?

###**1.1 Ausgabe**

Wir haben zwar jetzt schon ein bisschen mit Werten gearbeitet, jedoch konnten wir diese nie Ausgeben. Um jedoch zu Überprüfen ob ein Quellcode hinhaut, müssen wir die Werte manchmal ausgeben. Um Zellen auszugeben benutzen wir das Schlüsselwort `prv [zelle];`.

Beispiel dafür:

    [wnd]
    cell #0;
    add 5;
    prv #0;@
    [end]
Ausgabe:

    user@pc:~$ ./nypp test.ny
    NÝ++ Interpreter - V0.4.8
    Copyright (c) Triploit
    Alle Rechte vorbehalten.

    5
    user@pc:~$ _


PRV gibt also 5 aus, das @ am Ende kann weggelassen werden, jedoch steht es für einen Zeilenumbruch. Man kann auch mehrere @ schreiben um mehr Zeilenumbrüche hervorzurufen.

Um aber ganze Sätze auszugeben, gibt es zwei möglichkeiten. Zum einen kann man den Wert einer Zelle in ASCII Zeichen umwandeln, das geht mit dem Schlüsselwort `pstr [zelle];`.

    [wnd]
    [main]
    cell #0;
    add 2;
    pstr #0;@
    [end]

Lässt ein "B" auf der Konsole erscheinen. Hier wird das Zahlensystem A1-Z26 verwendet.

Aber das ist für große Texte meißt zu umständlich, deshalb gibt aus auch noch das Schlüsselwort `say "Dies ist ein Beispieltext!";`

    [wnd]
    [main]
    say "Hallo Welt!";@
    [end]
In Anführungszeichen wird dann der Satz gegeben, die Ausgabe wäre dann `Hallo Welt`.


###**1.2 Rechnen**

Eine Möglichkeit haben wir schon betrachtet, nämlich ADD. In NÝ++ gibt es jedoch ein anderes Schlüsselwort dafür, das alle vier Grundrechenarten rechnen kann. Dieses Schlüsselwort nennt sich `cal`:

    [wnd]
    cell #1;
    mov 4;
    cell #2;
    mov 5;
    cal #1+#2;
    prv #1;@
    [end]
Wir sehen das #1 und #2 zusammengerechnet wurden, danach wird das Ergebnis in #1 gespeichert, was dann ausgegeben wird.

Statt einem Plus, können folgende Zeichen auch eingesetzt werden:  
 `*` (Multiplikation)  
 `/` (Divison)  
 `-` (Subtraktion)

###**1.3 Goto Statements**

Goto Statements müssten allen aus Batch oder BASIC bekannt sein. Es sind Marken, zu denen man aus jedem Bereich des Codes aus hinspringen kann.

Sprungmarken werden sie genannt und so deklariert:

    {name}

Damit haben wir die Marke name deklariert und können mit dem Befehl `gt name;` von überall aus dort hinspringen, wo diese Marke deklariert wurde.

Wenn wir dies in ein programm einbauen, können wird dadurch Schleifen entstehen lassen:

    [wnd]
    [main]
    {anfang} ? Neue Marke Anfang ?
    cell #0;
    add 1;
    prv #0;
    gt anfang; ? Gehe zur Marke "anfang" ?
    [end]

Dieses programm zählt unendlich lange hoch, solange bis man es mit Strg+C abbricht. Sprungmarken sind sehr nützlich, müssen jedoch mit Bedacht verwendet werden, da sie sich zu Spaghetticode (siehe Wikipedia) entwickeln können, was sehr unübersichtlich und schmerzhaft für den Programmierer endet.

###**1.4 Eingabe**

Manchmal ist es vonnöten, das der User etwas eingibt. Vorab gesagt:

> Da man nur mit Zahlen arbeiten kann, kann man auch nur Zahlen
> eingeben.

Um nun aber dem User nach Input zu fragen, benutzen wir das Schlüsselwort `inp [zelle];`.
Hier ein Beispiel:

    [wnd]
    [main]
    say "Gib eine Zahl ein: ";
    inp #0;
    prv #0;
    [end]
Bei diesem Programm wird der Benutzer aufgefordert eine Zahl einzugeben und dann Enter zu drücken. Dies kann sehr hilfreich sein um den Benutzer entscheiden zu lassen was passiert.

###**1.5 If-Abfragen**

Es ist bei den meisten Programmiersprachen so, das man Werte vergleichen kann. So auch hier.
Wenn wir in NÝ++ zwei Werte vergleichen wollen, gibt es dafür 4 Schlüsselwörter:

####**EQ**

EQ überprüft ob eine Zelle einem Wert gleicht. Wenn das so ist, springt es zu einer Sprungmarke:

    eq	#0,1,anfang;

Hier wird überprüft, ob #0 den Wert 1 beinhaltet, wenn dies so ist, dann geht er zur Sprungmarke `anfang`.

####**NEQ**

EQ überprüft ob eine Zelle einem Wert **nicht** gleicht. Wenn das so ist, springt es zu einer Sprungmarke:

    neq	#0,1,anfang;

Hier wird überprüft, ob #0 den Wert 1 beinhaltet, wenn dies so ist, dann geht er zur Sprungmarke `anfang`.
####**KEQ**

KEQ überprüft ob ein Wert kleiner ist als ein Anderer. Wenn das so ist, springt es zu einer Sprungmarke:

    keq	#0,1,anfang;

Hier wird überprüft, ob #0 den Wert 1 beinhaltet, wenn dies so ist, dann geht er zur Sprungmarke `anfang`.
####**GEQ**

KEQ überprüft ob ein Wert größer ist als ein Anderer. Wenn das so ist, springt es zu einer Sprungmarke:

    geq	#0,1,anfang;

Hier wird überprüft, ob #0 den Wert 1 beinhaltet, wenn dies so ist, dann geht er zur Sprungmarke `anfang`.

> Tipp: Natürlich ist es auch möglich, Zellen zu vergleichen: `eq #1,#2,richtig;`


Danke für das Interesse an der Sache, Projektleiter Survari.
