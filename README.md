## disegni javafx
qui salvo i miei disegni fatti per imparare javafx

nota: sto lavorando principalmente da terminale Ubuntu, su Windows i comandi possono cambiare

per riuscire ad eseguirli devi avere javafx installato.
Puoi adottare due strategie:
1. installare Eclipse, e dal suo marketplace installare javafx (ma a me non piace ...)
2. fare download della libreria javafx da terminale

e dopo imparare i comandi per eserguire

per aprire il terminale è necessario premere "Ctrl+Alt+T"
### comandi per scaricare javafx da terminale
premessa: in java 8 javafx dovrebbe essere già inclusa
e per vedere la versione puoi sempre fare i comandi:

`java -version`

`javac -version`

i comandi per installare:

`sudo apt install default-jdk`

`sudo apt install openjdk-8-jdk`

`sudo update-alternatives --config java`

`sudo update-alternatives --config javac`

NOTA BENE!
se i comandi
`sudo update-alternatives --config java`

`sudo update-alternatives --config javac`

vanno a buon fine dovrebbe chiederti di inserire un numero e compare la tabella delle scelte
in entrambi i casi quindi ne compare una quando facciamo eseguire

`sudo update-alternatives --config java`

e un'altra quando facciamo eseguire

`sudo update-alternatives --config javac`

In entrambi i casi è necessario vedere dove propone la versione di java 8


so che potrebbe anche funzionare (ma a me non ha funzionato):
installare java11 dal sito
ed eseguire il comando

`sudo apt install openjfx`

che dovrebbe essere la libreria di javafx

perdonatemi ma non sono esperta di queste cose e ho dovuto risolvere parecchi casini
se avete già eclipse con la libreria funzionante o già impostato javafx è meglio che non esegui niente di quello sopra 

### comandi per scaricare la repository github

puoi scaricare la repository sia dallo zip
sia tramite linea di comando

//per spostarsi nella directory dove si vuole salvare la repository
//che indicherò con PERCORSO (esempio Scrivania/github)

`cd PERCORSO`

esempio d'uso:

`cd Scrivania/github`

//per clonare la repository nella directory corrente

`git clone https://github.com/LiberaLongo/disegniJavaFX`

verrà creata la cartella chiamata disegniJavaFX, sottocartella di PERCORSO

### comandi per compilare ed eseguire
premessa:
compilare significa "tradurre" dal linguaggio ad alto livello (più vicino all'umano)
nel linguaggio a basso livello (linguaggio macchina)

è importante, prima di eseguire, compilare il progetto dalla propria macchina
(non tutte le macchine utilizzano lo stesso linguaggio macchina, è bene ricompilare per evitare problemi)

nota:
indicherò come NOMEFILE NOMEPROGETTO ecc. dei file con il nome che volete (o scegliete dopo aver fatto il comando ls)

spostarsi nella directory disegniJavaFX con il comando cd
(cd Scrivania/github/disegniJavaFX)

per il file singolo chiamato NOMEFILE.java

//compila

`javac NOMEFILE.java`

//esegui

`java NOMEFILE`

//attenzione a NON metterci il .class per eseguirlo

per il progetto chiamato NOMEPROGETTO
//compila tutti i file presenti nel NOMEPROGETTO

`javac NOMEPROGETTO/*.java`

//esegue il file con il main chiamato MAINFILE.java

`java NOMEPROGETTO.MAINFILE.java`

spero che questa piccola guida per principianti vi sia stata utile e buon divertimento!
