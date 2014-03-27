
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
			if(current.isDone())
			{
				procMan.processList.remove(current);
				procMan.numberRealised++;
			}
		}else {
			if(!(current == null) && !current.isDone())
			{
			current.doIt();
			procMan.workTime++;
			if(current.isDone())
			{
				procMan.processList.remove(current);
				procMan.numberRealised++;
			}
			}
		}
		
	}
	public Process nextProcess()
	{
		return getShort();
	}
	public Process getShort()
	{
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