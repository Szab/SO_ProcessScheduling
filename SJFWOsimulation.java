
public class SJFWOsimulation extends Simulation
{
	
	public SJFWOsimulation(ProcessManager processManager) 
	{
		super(processManager);
                current = getShort();
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
		if((current.isDone()))
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
		int shortestTime = -1;
		Process shortest = null;
		if(procMan.processList.size()>0)
		{
			for(Process tempProc : procMan.processList)
			{
				if((shortestTime==-1)||(tempProc.duration<shortestTime))
				{
					shortestTime = tempProc.duration;
					shortest = tempProc;
				}
			}
		}
		return shortest;
	}
}
