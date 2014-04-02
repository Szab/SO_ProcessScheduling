
public class ROTsimulation extends Simulation
{	
	int status = 0;
	public ROTsimulation(ProcessManager processManager) 
	{
		super(processManager);
	}
	public boolean isDone() 
	{
		return current == null && procMan.numberRealised > 0;
	}
	public void serve() 
	{
		current = nextProcess();
		
		if(procMan.processList.size() > 1 && !current.isDone())
		{
			procMan.workTime++;
			current.doIt();
			procMan.overallWaited += procMan.processList.size()-1;
		}else {
			if(!(current == null || current.isDone()))
			{
				current.doIt();
				procMan.workTime++;
			}
		}
		status++;
	}
	public Process nextProcess()
	{
		Process next = null;
		if(current != null && current.isDone())
		{
			procMan.numberRealised++;
			procMan.processList.remove(current);
		}
		if(procMan.processList.size()>0)
		{
			next = procMan.processList.get(0);
			if(status != 0 && status % procMan.quantSize == 0)
			{
				procMan.processList.add(next);
				procMan.processList.remove(0);
				next = procMan.processList.get(0);
			}
		}
		return next;
	}
}
