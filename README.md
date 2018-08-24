# disegniJavaFX
qui salvo i miei disegni programmati con javafx

se non sai ancora come compilare i files segui queste istruzioni

Supponi di:
1. aver un sistema operativo Linux (io l'ho fatto da Ubuntu)
2. voler salvare questa cartella sulla Scrivania

Allora puoi fare:
Ctrl+Alt+T
(per aprire il terminale)

cd Scrivania/
(per spostarti nella directory Scrivania)

git clone "https://github.com/LiberaLongo/disegniJavaFX"
(clona il progetto nella tua directory locale, in teoria basta farlo una sola volta)
git pull
(per aggiornare la cartella)

(e se non funziona:
(spostarsi nella directory Scrivania e fare:
"rm -rf disegniJavaFX"
(rimouve la cartella, e poi riclonarla)

ls
(per vedere il contenuto della cartella)

cd disegniJavaFX/

una volta fatti questi semplici comandi puoi:
decidere di voler aprire il file chiamato "NOMEFILE" appartenete al package "NOMEPACCHETTO"

se all'inizio del file non vedi la scritta "package ..."
ti basta:

javac NOMEFILE.java
(per compilare)

java NOMEFILE
(per eseguire)

altrimenti se vedi la scritta "package ..."
ti basta fare:

javac NOMEPACCHETTO/*.java
(per compilare tutto il pacchetto)

java NOMEPACCHETTO.NOMEFILEMAIN)
(per eseguire il fail che contiene la scritta "class ... extends Application")

ricapitolando i comandi:

cd <path>

ls

per file singolo

javac NOMEFILE.java

java NOMEFILE

per interi pakage

javac NOMEPACCHETTO/*.java

java NOMEPACCHETTO.NOMEFILEMAIN

vuoi un esempio concreto?
supponi di aver già clonato il progetto sulla scrivania

Ctrl+Alt+t

cd Scrivania/disegniJavaFX

javac ksisters/*.java

java ksisters.Ksisters

#in alternativa su Windows
clonare il file premendo sul pulsante clone del sito di github
unzippare
usare i soliti comandi (java e javac) per compilare ed eseguire
