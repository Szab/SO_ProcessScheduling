/* Klasa ProcessManager:
- Obsługa generatora procesów
- Zliczanie wykonań
- Generowanie statystyk
- Wybór algorytmu
*/

import java.util.ArrayList;
import java.util.UUID;

public class ProcessManager
{
    public int numberRealised = 0; // Liczba w pełni zrealizowanych procesów
    public int workTime = 0; // Liczba zrealizowanych kwantów czasu
    public int overallWaited = 0; // Suma czasów oczekiwania na wykonanie
    
    public ArrayList<Process> processList; // Lista procesów do zrealizowania
                                             // PAMIĘTAĆ O ZACHOWANIU KOLEJNOŚCI
    private ArrayList<ProcessTemplate> _templateList; // Lista szablonów dla generatora
    
    private Simulation _simulation = new Simulation(this); // Obecnie wykonywana symulacja
    
    // Zwraca sredni czas oczekiwania na realizacje
    public double getAverageTime()
    {
        return numberRealised==0 ? 0 : overallWaited/numberRealised;
    }
    
    // Obsługa procesu
    public void processController()
    {        
        while(!_simulation.isDone())
        {
            processGenerator();
            IOController.generate(this);
            _simulation.serve(processList);
        }
    }
    
    // Blokuje nieskończenie generowane procesy
    public void lockProcessGenerator()
    {
        for(ProcessTemplate template : _templateList)
        {
            if(template.remaining<0) template.remaining = 0;
        }
    }
    
    // Dodaje generowane procesy do listy
    private void processGenerator()
    {
        for(ProcessTemplate template : _templateList)
        {
            if(template.remaining!=0 && workTime%template.interval == 0)
            {
                String randomID = template.id
                        +UUID.randomUUID().toString(); // Generowanie losowego ID
                Process newProcess = new Process(randomID,template.duration, workTime);
                processList.add(newProcess);
                template.remaining--;
            }
        }
    }
    
    public ProcessManager(ArrayList<Process> processList, ArrayList<ProcessTemplate> templateList)
    {
        this.processList = processList;
        _templateList = templateList;
    }
    
}
