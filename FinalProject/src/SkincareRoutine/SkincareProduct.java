package SkincareRoutine;

public class SkincareProduct {
	private String name; //name of the product
	private String type; //cleanser, toner, etc...
	private int stepOrder; //1,2,3
	private String useTime; //AM, PM, both
	private String notes;
	private boolean checked;
	
	//constructor: this sets all the fields when we create an object 
	public SkincareProduct(String name, String type, int stepOrder, String useTime, String notes, boolean checked) {
		this.name = name;
		this.type = type;
		this.stepOrder = stepOrder;
		this.useTime = useTime;
		this.notes = notes;
		this.checked = checked;
	}
	//Getters and setters for each variable so other classes can access/ update them
	public String getName() { return name; }      // returns the name value
	public void setName(String name) { this.name = name; } //changes the name
	
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }
	
	public int getStepOrder() { return stepOrder; }
	public void setStepOrder(int stepOrder) { this.stepOrder = stepOrder; }
	
	public String getUseTime() { return useTime; }
	public void UseTime(String useTime) { this.useTime = useTime; }
	
	public String getNotes() { return notes; }
	public void setNotes(String notes) { this.notes = notes; }

    public boolean getChecked() { return checked; }
    public void setChecked(boolean checked) { this.checked = checked; }
    

	//this is what prints
	@Override
	public String toString() {
		return stepOrder + ". " + name + " (" + type + ", " + useTime + ")";
	}

}
