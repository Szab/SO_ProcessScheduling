/* Klasa IOController:
- Wyświetlanie statystyk i obecnego stanu symulacji
- Interakcja z użykownikiem
*/

public class IOController
{
    public static void generate(ProcessManager manager)
    {
        System.out.flush();
        try
        {
                //Runtime.getRuntime().exec("cls");
        }
        catch(Exception ex)
        {
            
        }
        System.out.println("Obecnie realizowany: "+(manager.getCurrent() != null ? manager.getCurrent().id : "brak"));
        System.out.println("Wynik: "+manager.getAverageTime());
        System.out.println("Zrealizowano: "+manager.workTime);
        System.out.println("Procesow: "+manager.numberRealised);
    }
}
