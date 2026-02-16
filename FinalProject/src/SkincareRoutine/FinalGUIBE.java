package SkincareRoutine;

import java.util.ArrayList;
import java.util.List;

public class FinalGUIBE {
	
	private List<SkincareProduct> prod;
	public static final int DEF_SIZE =10;
	
	public FinalGUIBE()
	{
		init(DEF_SIZE);
	}
	
	public void init(int size)
	{
		if (size>= 1)
		{
			prod = new ArrayList<>(size);
		}
		else 
		{
			prod = new ArrayList<>(DEF_SIZE);
		}
	}
	
	public void addStep(SkincareProduct Prods)
	{
		if (Prods == null) {
            return;
        }

        for (int i = 0; i < prod.size(); i++) {
            SkincareProduct skincare = prod.get(i);
            // avoid null pointer
            if (skincare == null) continue;
            if (skincare.getStepOrder() == Prods.getStepOrder()) {
                String t1 = skincare.getUseTime();
                String t2 = Prods.getUseTime();
                if (t1 != null && t2 != null && t1.equalsIgnoreCase(t2)) {
                    // duplicate order+time -> reject
                    return;
                }
            }
        }

        prod.add(Prods);
		
        String time = Prods.getUseTime();
        if (time == null) return;

        String[] parts = time.split(" ");
        if (parts.length < 2) return;
		
		String ante = parts[1];
		
		if(ante.equalsIgnoreCase("AM") || ante.equalsIgnoreCase("A.M"))
		{
			this.sortByAM();
		}
		else if (ante.equalsIgnoreCase("PM") || ante.equalsIgnoreCase("P.M"))
		{
			this.sortByPM();
		}
	}
	
	public void removeStep(SkincareProduct Prods)
	{
	    if (Prods == null) {
	        return;
	    }

	    for (int i = 0; i < prod.size(); i++) {
	        SkincareProduct skincare = prod.get(i);
	        if (skincare == null) continue;

	        if (skincare.getStepOrder() == Prods.getStepOrder()) {
	            String t1 = skincare.getUseTime();
	            String t2 = Prods.getUseTime();

	            if (t1 != null && t2 != null && t1.equalsIgnoreCase(t2)) {
	                prod.remove(i);   // ⭐ THIS IS THE REAL REMOVE
	                return;           // stop after removing one match
	            }
	        }
	    }
	}

	
	private void sortByAM()
	{
		boolean swap = true;
		while(swap)
		{
			swap = false;
			for(int i = 0; i<prod.size()-1;i++ )
			{
				if(prod.get(i).getStepOrder() > prod.get(i+1).getStepOrder())
				{
					SkincareProduct temp= prod.get(i);
					prod.set(i, prod.get(i+1));
					prod.set(i+1, temp);
					swap=true;
				}
			}
		}
	}
	
	private void sortByPM()
	{
		boolean swap = true;
		while(swap)
		{
			swap = false;
			for(int i = 0; i<prod.size()-1;i++ )
			{
				if(prod.get(i).getStepOrder() > prod.get(i+1).getStepOrder())
				{
					SkincareProduct temp= prod.get(i);
					prod.set(i, prod.get(i+1));
					prod.set(i+1, temp);
					swap=true;
				}
			}
		}
	}
	
	
	public List<SkincareProduct> getProduct()
	{
		return prod;
	}

}