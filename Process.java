public class Process
{
    public int duration = 0; // Czas potrzebny do realizacji procesu
    public int timeLeft = 0; // Pozostały czas do pełnej realizacji procesu
	public int timeCreated = 0; // Jednostka czasu w której utworzono proces
    String id = "";          // Identyfikator procesu
    
	// Konstruktor dwuparametrowy dla procesów wczytywanych na początku
	public Process(Strng id, Integer duration)
	{
		this(id, duration, 0);
	}
	
	// Właściwy konstruktor
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
}
