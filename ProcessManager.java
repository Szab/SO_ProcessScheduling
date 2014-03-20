import java.util.ArrayList;
import java.util.UUID;

public class ProcessManager
{
    public int numberRealised; // Liczba w pełni zrealizowanych procesów
    public int workTime; // Liczba zrealizowanych kwantów czasu
    private ArrayList<Process> _processList; // Lista procesów do zrealizowania
                                             // PAMIĘTAĆ O POPRAWNEJ KOLEJNOŚCI!
    private ArrayList<ProcessTemplate> _templateList; // Lista procesów do generowania
    
    // Dodaje generowane procesy do listy
    public void processGenerator()
    {
        for(ProcessTemplate template : _templateList)
        {
            if(template.remaining!=0 && workTime%template.interval == 0)
            {
                String randomID = template.id
                        +UUID.randomUUID().toString(); // Generowanie losowego ID
                Process newProcess = new Process(randomID,template.duration);
                _processList.add(newProcess);
                template.remaining--;
            }
        }
    }
    
    public ProcessManager(ArrayList<Process> processList, ArrayList<ProcessTemplate> templateList)
    {
        _processList = processList;
        _templateList = templateList;
    }
    
}
