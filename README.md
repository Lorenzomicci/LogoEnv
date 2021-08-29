# LogoEnv
Simple logo environment

Logo è un linguaggio di programmazione didattico sviluppato alla fine degli anni 60. L’idea degli sviluppatori era quello di fornire un semplice strumento per “programmare” dei disegni. L’obiettivo del progetto è quello di sviluppare un ambiente di esecuzione per il Logo in Java.
Una descrizione dettagliata del linguaggio e della sua storia è disponibile nella pagina Wikipedia di Logo. Di seguito viene riportata una breve descrizione. 

Il linguaggio Logo
Un programma Logo ha come obiettivo quello di disegnare un insieme di segmenti (rettilinei o curvi) all’interno di un’area di disegno. L’esecuzione di un programma fa muovere un cursore (storicamente rappresentato come una tartaruga o un triangolo) generando un disegno sottostante. 

L’area dove viene realizzato il disegno prodotto dal programma consiste in una porzione di piano aventi dimensioni finite (base,altezza). La coordinata (0,0) indica il punto in basso a sinistra del piano. La posizione centrale dell’area di disegno, ossia quelle di coordinate  (base/2,altezza/2), viene detta home. L’area è anche caratterizzata da un colore di sfondo. Il colore iniziale è bianco. 

Il cursore è caratterizzato dai seguenti attributi:
Posizione: posizione del cursore 
Direzione: indica l’angolo verso cui è puntato il cursore. L’angolo viene rappresentato con un intero nell’intervallo [0,360] dove lo 0 indica la direzione orizzontale verso destra (ore 3, se consideriamo un orologio). 
Colore Linea: indica il colore della linea prodotta dal cursore come conseguenza di uno spostamento. 
Colore Area: indica il colore dell’area che viene colorata quando una serie di segmenti producono un’area chiusa.
Plot: è un parametro booleano che sta ad indicare se durante uno spostamento il cursore genera o meno un tracciato. 

Per default, il cursore è posizionato nella home, ha una direzione di gradi 0, il colore della linea è il nero, mentre il colore dell’area è il bianco (come il colore di sfondo di default). 

Il movimento del cursore viene definito per mezzo di un programma che è costituito da una lista di istruzioni della seguente forma:

FORWARD <dist>: sposta il cursore in avanti verso la sua direzione (se si raggiungono i limiti dell’area il cursore si ferma al bordo);
BACKWARD <dist>: sposta il cursore indietro rispetto la sua direzione (se si raggiungono i limiti dell’area il cursore si ferma al bordo);
LEFT <angle>: ruota il cursore in senso antiorario dei gradi descritti dal parametro (gli angoli sono indicati come interi nel range [0, 360]); 
RIGHT <angle>: ruota il cursore in senso orario dei gradi descritti dal parametro (gli angoli sono indicati come interi nel range [0, 360]); 
CLEARSCREEN: cancella quanto disegnato;
HOME: muove il cursore nella posizione di home;
PENUP: stacca la penna dal foglio;
PENDOWN: attacca la penna al foglio;
SETPENCOLOR <byte> <byte> <byte>: imposta il colore della penna al colore rappresentato dal colore RGB rappresentato dai tre byte dati (<byte> indica un valore intero nel range [0,255]);
SETFILLCOLOR <byte> <byte> <byte>: imposta il colore del riempimento di un’area chiusa;
SETSCREENCOLOR <byte> <byte> <byte>: imposta il colore di background dell’area di disegno;
SETPENSIZE <size>: indica la grandezza del tratto della penna, <size> è un intero di grandezza maggiore o uguale a 1; 
RIPETI <num> [ <cmds> ]: ripete la sequenza di comandi presenti nella lista dei comandi <cmds>.


Durante il movimento del cursore, come indicato dal programma, il cursore genera una sequenza di linee. Quando le linee si chiudono viene individuata un’area chiusa, questa consiste in una sequenze di linee che, partono e terminano nello stesso punto. Una volta individuata un’area chiusa, le linee non possono più far parte di una seconda area chiusa. 

