package SkincareRoutine;
import java.util.ArrayList;

public class RoutineManager 
{
	private ArrayList<SkincareProduct> products;
	private ArrayList<RoutineStep> steps;
	
	public RoutineManager()
	{
		products = new ArrayList<>();
		steps = new ArrayList<>();
	}
	
	public void addProduct(SkincareProduct product)
	{
		products.add(product);
	}
	
	public void addStep(RoutineStep step)
	{
		steps.add(step);
	}
	
	public ArrayList<RoutineStep> getAMSteps()
	{
		ArrayList<RoutineStep> AM = new ArrayList<>();
		
		for(RoutineStep step : steps)
		{
			if (step.getUseTime().equals("AM"))
			{
				AM.add(step);
			}
		}
		
		return AM;
	}
	
	public ArrayList<RoutineStep> getPMSteps()
	{
		ArrayList<RoutineStep> PM = new ArrayList<>();
		
		for(RoutineStep step : steps)
		{
			if (step.getUseTime().equals("PM"))
			{
				PM.add(step);
			}
		}
		
		return PM;
	}
	
	public void markStepAsDone(int idx)
	{
		if (idx >= 0 && idx < steps.size())
		{
			steps.get(idx).markDone();
		}
	}
	
	public double getPercentageOfCompletion()
	{
		if (steps.isEmpty())
		{
			return 0;
		}
		
		int count = 0;
		
		for(RoutineStep step : steps)
		{
			if (step.isDone())
			{
				count++;
			}
		}
		
		return (count * 100.00) / steps.size();
	}
}
