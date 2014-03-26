/* Klasa Process: reprezentacja procesu w programie */

public class Process
{
    public int duration = 0; // Czas potrzebny do realizacji procesu
    public int timeLeft = 0; // Pozosta³y czas do pe³nej realizacji procesu
    public int timeCreated = 0; // Jednostka czasu w której utworzono proces
    String id = ""; // Identyfikator procesu
    
// Konstruktor dwuparametrowy dla procesów wczytywanych na pocz¹tku
public Process(String id, Integer duration)
{
this.id=id;
this.duration=duration;
this.timeLeft = this.duration;
this.timeCreated=0;
}

// W³aœciwy konstruktor
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