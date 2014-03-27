import java.util.ArrayList;
import java.util.*;
public class Main
{

    public static void main(String[] args)
    {
        FileParser parser = new FileParser("D:/procesy.txt");
        parser.loadProcessList();
        ArrayList<Process> lista = parser.getProcessList();
        ArrayList<ProcessTemplate> lista2 = parser.getTemplateList();
        
        ProcessManager manager = new ProcessManager(lista,lista2);
        manager.processController();
    }
    
}
