
public class SJFWsimulation extends Simulation
{
	
	public SJFWsimulation(ProcessManager processManager)
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
			if(!(current == null) && !current.isDone())
			{
			current.doIt();
			procMan.workTime++;
			}
		}
		
	}
	public Process nextProcess()
	{
		return getShort();
	}
	public Process getShort()
	{
		if(current != null && current.isDone())
		{
			procMan.numberRealised++;
			procMan.processList.remove(current);
		}
		int shortestTime = -1;
		Process shortest = null;
		if(procMan.processList.size()>0)
		{
			for(int i=0; i<procMan.processList.size(); i++)
			{
				Process tempProc = procMan.processList.get(i);
				if((shortestTime<0)||(tempProc.timeLeft<shortestTime))
				{
					shortestTime = tempProc.timeLeft;
					shortest = tempProc;
				}				
			}
		}
		return shortest;
	}
}