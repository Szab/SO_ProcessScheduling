/* Klasa Process: reprezentacja procesu w programie */

public class Process
{
    public int duration = 0; // Czas potrzebny do realizacji procesu
    public int timeLeft = 0; // Pozosta�y czas do pe�nej realizacji procesu
    public int timeCreated = 0; // Jednostka czasu w kt�rej utworzono proces
    String id = ""; // Identyfikator procesu
    
// Konstruktor dwuparametrowy dla proces�w wczytywanych na pocz�tku
public Process(String id, Integer duration)
{
this(id,duration,0);
}

// W�a�ciwy konstruktor
    public Process(String id, Integer duration, Integer timeCreated)
    {
        this.duration = duration;
        this.timeCreated = timeCreated;
        this.timeLeft = this.duration;
        this.id = id;
    }
    
    public boolean isDone()
    {
        return timeLeft == 0;
    }
    public void doIt()
    {
    	timeLeft--;
    }
}
