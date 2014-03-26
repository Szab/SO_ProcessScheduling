public abstract class Simulation 
{
	public int simulationOption = 0;
	
    public ProcessManager procMan;
	
	public Simulation(ProcessManager processManager)
	{
		procMan = processManager;
	}
	public abstract boolean isDone();
	public abstract void serve();
}
