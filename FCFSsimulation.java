
public class FCFSsimulation extends Simulation
{		
	
	public FCFSsimulation(ProcessManager processManager) 
	{
		super(processManager);
	}
	@Override
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
	}
	public Process nextProcess() 
	{
		Process next = null;
		if(procMan.processList.get(0).isDone())
		{
			procMan.numberRealised++;
			procMan.processList.remove(0);
			if(procMan.processList.size()>0)
			{
				next = procMan.processList.get(0);
			}else{
				next = null;
			}
		}else {
			next = procMan.processList.get(0);
		}
		return next == null ? null : next;
	}
	@Override
	public boolean isDone() {
		return current == null && procMan.numberRealised > 0;
	}
	
	
}
