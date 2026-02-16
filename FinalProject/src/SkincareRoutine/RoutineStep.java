package SkincareRoutine;

public class RoutineStep { //this class represents one step in the routine
	private String stepName;
	private int order;
	private String useTime; //AM or PM
	private SkincareProduct product; //links this step to a product
	
	private boolean done = false; //tracks if this step is completed
	
	//constructor: sets all values when creating a step
	public RoutineStep(String stepName, int order, String useTime, SkincareProduct product) {
		this.stepName = stepName;
		this.order = order;
		this.useTime = useTime;
		this.product = product;
	}
	public String getStepName() { return stepName; }
	public void setStepName(String stepName) { this.stepName = stepName; }
	
	public int getOrder() { return order; }
	public void setOrder(int order) { this.order = order; }
	
	public String getUseTime() { return useTime; }
	public void setUseTime(String useTime) { this.useTime = useTime; }
	
	public SkincareProduct getProduct() { return product; }
	public void setProduct(SkincareProduct product) { this.product = product; }
	
	public boolean isDone() { //returns true if completed
		return done;
	}
	public void markDone() { //marks this step as completed
		done = true;
	}
	
	//what prints
	@Override
	public String toString() {
		return order + ". " + stepName + " (" + useTime + ")" + (done ? " (done)": "");
	}

}
