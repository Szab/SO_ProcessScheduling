import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class FileParser
{
    private String _path = "";                  // Ścieżka pliku z procesami
    private ArrayList<Process> _processList; 
    private ArrayList<ProcessTemplate> _templateList;// Lista robocza
    
    public FileParser(String path)
    {
        _path = path;
        _processList = new ArrayList<Process>();
        _templateList = new ArrayList<ProcessTemplate>();
    }
    
    // Ładowanie procesów do zmiennej
    public void loadProcessList()
    {
        FileReader reader = null;
        BufferedReader breader = null;

        try
        {
            reader = new FileReader(_path);
            breader = new BufferedReader(reader);
            
            while(breader.ready())
            {
                String fileLine = breader.readLine();
                String[] command = fileLine.split(" ");
                if( command.length==2 )
                {
                    _processList.add( new Process(command[0],Integer.parseInt(command[1]) ));
                }
                if( command[0].equals("GEN") )
                {
                    _templateList.add( new ProcessTemplate(command[3],Integer.parseInt(command[4])
                            ,Integer.parseInt(command[1]),Integer.parseInt(command[2])) );
                }
            }
            
            System.out.println("Wczytano z pliku "+_path);           
        }
        catch(Exception ex)
        {
            System.out.println("Wystąpił błąd wczytywania pliku: "+ex.getMessage());
        }
        finally
        {
            if(breader != null) 
            {
                try
                {
                    breader.close();
                }
                catch(Exception ex)
                {
                    System.out.println("Błąd przy zamykaniu pliku. "+ex.getMessage());
                }
            }
            if(reader != null)
            {
                try
                {
                    reader.close();
                }
                catch(Exception ex)
                {
                    System.out.println("Błąd przy zamykaniu pliku. "+ex.getMessage());
                }
            }
        }
    }
    
    // Przekazywanie listy procesów
    public ArrayList<Process> getProcessList() 
    {
        return _processList;
    }
    
    // Przekazywanie listy wzorów
    public ArrayList<ProcessTemplate> getTemplateList()
    {
                return _templateList;
    }
    
}
