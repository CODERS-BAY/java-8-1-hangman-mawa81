# Java 

## Stack

### Java 7.1

Implementiere einen IntStack! Ein Stack ist ein Stapel, der immer die Dinge zuerst abarbeitet, die er zuletzt bekommen hat nach dem `Last in first out` Prinzip.
Die Klasse Stack sollte folgende Methoden haben: 
* void push(int newElement) 
    * fügt ein neues Element oben in den Stack ein
* int size()
    * gibt die Anzahl der Elemente im Stack  zurück
* int pop()
    * gibt das letzte Elemente des Stacks zurück und entfernt dieses vom Stack
* int peek()
    * gibt das letzte Elemente des Stacks zurück ohne den Stack zu modifizieren
* int[] pop(int n)
    * gibt die letzten n Elemente des Stacks zurück und entfernt diese vom Stack 
    
Wird auf einen leeren Stack `pop() oder peek()` aufgerufen sollte eine `StackTooSmallException` geworfen werden. 

Leg in der Main Methode einen Stack an und schreib ein paar Beispiel-Verwendungen.  