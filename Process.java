public class Process
{
    public int duration = 0; // Czas potrzebny do realizacji procesu
    public int timeLeft = 0; // Pozostały czas do pełnej realizacji procesu
    String id = "";          // Identyfikator procesu
    
    public Process(String id, Integer duration)
    {
        this.duration = duration.intValue();
        this.timeLeft = this.duration;
        this.id = id;
    }
    
    public boolean isDone()
    {
        return timeLeft == 0;
    }
}
