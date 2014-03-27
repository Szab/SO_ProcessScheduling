
public class SJFWOsimulation extends Simulation
{
	Process current = getShort();
	
	public SJFWOsimulation(ProcessManager processManager) 
	{
		super(processManager);
	}
	@Override
	public boolean isDone() 
	{
		return current == null && procMan.numberRealised > 0;
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
		if(current.isDone())
		{
			procMan.numberRealised++;
			procMan.processList.remove(current);
			return getShort();
		}else {
			return current;
		}
	}
	public Process getShort()
	{
		int shortestTime = 100000;
		Process shortest = null;
		if(procMan.processList.size()>0)
		{
			for(Process tempProc : procMan.processList)
			{
				if(tempProc.timeLeft<shortestTime)
				{
					shortestTime = tempProc.timeLeft;
					shortest = tempProc;
				}
			}
		}
		return shortest;
	}
}
