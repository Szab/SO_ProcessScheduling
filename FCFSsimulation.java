
public class FCFSsimulation extends Simulation
{
	public FCFSsimulation(ProcessManager processManager) 
	{
		super(processManager);
	}
	public void serve() 
	{	
		if(procMan.processList.size() > 1)
		{
			Process process = nextProcess();
			procMan.workTime += process.duration;
			procMan.overallWaited += procMan.workTime - process.timeCreated;
			procMan.numberRealised++;
			procMan.processList.remove(process);
		}else {
			Process process = nextProcess();
			procMan.workTime += process.duration;
			procMan.overallWaited += process.duration;
			procMan.numberRealised++;
			procMan.processList.remove(process);
		}
	}
	public Process nextProcess() 
	{
		return procMan.processList.get(0);
	}
	public boolean isDone() {
		return procMan.processList.isEmpty();
	}
	
	
}
