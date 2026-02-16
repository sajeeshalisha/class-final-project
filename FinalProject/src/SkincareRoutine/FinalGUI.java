package SkincareRoutine;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;

public class FinalGUI {

private static FinalGUIBE finalGUI = new FinalGUIBE();
	
	//Add more 
	private static JTextField productName, productType, productTime, stepOrder;
	private static JTextArea note;
	private static JPanel displayArea, justHeader; 
	private static Color blue = new Color(140, 220, 240);
	
	
	public static void main(String[] args) {
		
		
		//frame
		JFrame frame = new JFrame("Personal Care Routine Tracker");
		frame.setSize(435,900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		
		
		//displays the product labels 
		int y = 60;
		
		JLabel productNameL = new JLabel("Product Name: ");
		productNameL.setBounds(10,y,100,20);
		frame.add(productNameL);
		
		y += 30;
		
		JLabel productTypeL = new JLabel("Product Type: ");
		productTypeL.setBounds(10,y,100,20);
		frame.add(productTypeL);
		y += 30;
		
		JLabel productTimeL = new JLabel("Enter the time to use (HH:MM AM/PM): ");
		productTimeL.setBounds(10,y,250,20);
		frame.add(productTimeL);
		
		y += 30;
		
		JLabel stepOrderL = new JLabel("Enter the step number: ");
		stepOrderL.setBounds(10, y, 200, 20);
		frame.add(stepOrderL);
		
		y += 30;
		
		JLabel noteL = new JLabel("Enter notes: ");
		noteL.setBounds(10, y, 200, 20);
		frame.add(noteL);
		
		
		
		//now adds in the fields to take the num, name, brand, etc
		
		productName = new JTextField();
		productName.setBounds(105, 60, 100, 20);
		//productName.setBounds(x, y, width, height);
		frame.add(productName);
		
		productType = new JTextField();
		productType.setBounds(100, 90, 100, 20);
		frame.add(productType);
		
		productTime = new JTextField();
		productTime.setBounds(240, 120, 100, 20);
		frame.add(productTime);
		
		stepOrder = new JTextField();
		stepOrder.setBounds(150, 150, 25, 20);
		frame.add(stepOrder);
		
		note = new JTextArea();
		note.setLineWrap(true);
		note.setWrapStyleWord(true);
		note.setBackground(blue);

		JScrollPane noteScroll = new JScrollPane(note);
		noteScroll.setBounds(10, 200, 400, 200);
		frame.add(noteScroll);

		
		
		
		//All the buttons. names are self explanatory
		
		JButton addRoutine = new JButton("Add Routine Step");
		addRoutine.setBounds(30, 410, 175, 30);
		addRoutine.setBackground(blue);
		addRoutine.setOpaque(true);
		frame.add(addRoutine);
		
		JButton removeRoutine = new JButton("Remove Routine Step");
		removeRoutine.setBounds(210, 410, 175, 30);
		removeRoutine.setBackground(blue);
		removeRoutine.setOpaque(true);
		frame.add(removeRoutine);
		
		
		JButton AMRoutine = new JButton("A.M");
		AMRoutine.setBounds(10, 480, 60, 20);
		AMRoutine.setBackground(blue);
		AMRoutine.setOpaque(true);
		frame.add(AMRoutine);
		
		JButton PMRoutine = new JButton("P.M");
		PMRoutine.setBounds(65, 480, 60, 20);
		PMRoutine.setBackground(blue);
		PMRoutine.setOpaque(true);
		frame.add(PMRoutine);
		
		JButton notesTab = new JButton("Notes");
		notesTab.setBounds(330, 480, 80, 20);
		notesTab.setBackground(blue);
		notesTab.setOpaque(true);
		frame.add(notesTab);

		
		
		
		//header, display, and label
		Font font = new Font("Verdana", Font.BOLD,20);
		JLabel header = new JLabel("      Your Personal Care Routine");
		header.setBounds(5, -20, 500, 100);
		header.setFont(font);
		frame.add(header);
				
		displayArea = new JPanel();
		displayArea.setBounds(10, 500, 400, 350);
		displayArea.setBackground(blue);
		frame.add(displayArea);
		
		
		justHeader = new JPanel();
		justHeader.setBounds(0, 0, 435, 50);
		justHeader.setBackground(blue);
		frame.add(justHeader);
		
		
		//all the actions for the buttons
		addRoutine.addActionListener(e -> addStep());
		removeRoutine.addActionListener(e -> removeStep());
		AMRoutine.addActionListener(e -> showAMRoutine());
		PMRoutine.addActionListener(e -> showPMRoutine());
		notesTab.addActionListener(e -> showNotes());

		
		
		//just the frame stuff
		frame.getContentPane().setBackground(new Color(215, 255, 255));
		frame.setVisible(true);
		
		
	}
	
	
	//if the person presses on this, it shows the AMRoutine
	private static void showAMRoutine() {
	    
	    displayArea.removeAll();
	    int y = 0;   // ⭐ ADD THIS
	    
	    for (SkincareProduct skincare : finalGUI.getProduct())
	    {
	        if (skincare != null)
	        {
	            String parts[] = skincare.getUseTime().split(" ");
	            if(parts.length != 2) continue;

	            String mornOrEve = parts[1];

	            if(mornOrEve.equalsIgnoreCase("AM") || mornOrEve.equalsIgnoreCase("A.M"))
	            {
	                JCheckBox hold = new JCheckBox(skincare.toString(), skincare.getChecked());
	                hold.setBounds(10, y, 400, 25);   // ⭐ USE y HERE
	                hold.setBackground(blue);
	                hold.setOpaque(true);

	                hold.addActionListener(e -> skincare.setChecked(hold.isSelected()));

	                displayArea.add(hold);
	                y += 25;   // ⭐ MOVE DOWN FOR NEXT ITEM
	            }
	        }
	    }

	    displayArea.revalidate();
	    displayArea.repaint();
	}
	
	
	//updates only the PM routine, but the code logic is the same as AM
	private static void showPMRoutine() {
		displayArea.removeAll();
		int y = 0;
		
		for (SkincareProduct skincare : finalGUI.getProduct())
		{
			if((skincare != null))
			{
				String parts[] = skincare.getUseTime().split(" ");
				if(parts.length !=2) continue;
				
				String mornOrEve = parts[1];		
				if((mornOrEve.equalsIgnoreCase("PM") || mornOrEve.equalsIgnoreCase("P.M")))
				{
					JCheckBox hold = new JCheckBox(skincare.toString(), skincare.getChecked());
					hold.setBounds(10, y, 400, 25);
					hold.setBackground(blue);
					hold.setOpaque(true);
					hold.addActionListener(e -> skincare.setChecked(hold.isSelected()));
					displayArea.add(hold);
					y+= 25;
				}
			}
		}
		displayArea.revalidate();
	    displayArea.repaint();
		
	}
	
	private static void showNotes() {
	    
	    displayArea.removeAll();
	    int y = 0;

	    for (SkincareProduct skincare : finalGUI.getProduct())
	    {
	        if (skincare == null) continue;

	        String noteText = skincare.getNotes();
	        if (noteText == null || noteText.isEmpty()) continue;

	        JTextArea noteBox = new JTextArea(
	            skincare.getName() + ":\n" + noteText
	        );

	        noteBox.setLineWrap(true);
	        noteBox.setWrapStyleWord(true);
	        noteBox.setEditable(false);
	        noteBox.setBackground(blue);

	        JScrollPane scroll = new JScrollPane(noteBox);
	        scroll.setBounds(10, y, 360, 60);

	        displayArea.add(scroll);
	        y += 70;
	    }

	    displayArea.revalidate();
	    displayArea.repaint();
	}

	
	private static void addStep()
	{
		
		String name = productName.getText();
		String type = productType.getText();
		String time = productTime.getText();
		
		int order = Integer.parseInt(stepOrder.getText());
		String notes = note.getText();
		
		finalGUI.addStep(new SkincareProduct(name, type, order, time, notes, false));
		
		String parts[] = time.split(" ");
		String ante = parts[1];
	
		
		if(ante.equalsIgnoreCase("AM") || ante.equalsIgnoreCase("A.M"))
		{
			JOptionPane.showMessageDialog(null, name + " added in AM");
			showAMRoutine();
		}
		else if(ante.equalsIgnoreCase("PM") || ante.equalsIgnoreCase("P.M"))
		{
			JOptionPane.showMessageDialog(null, name + " added in PM");
			showPMRoutine();
		}
		
	}
	
	private static void removeStep()
	{
		
		String name = productName.getText();
		String type = productType.getText();
		String time = productTime.getText();
		
		int order = Integer.parseInt(stepOrder.getText());
		String notes = note.getText();
		
		finalGUI.removeStep(new SkincareProduct(name, type, order, time, notes, false));
		
		String parts[] = time.split(" ");
		String ante = parts[1];
	
		
		if(ante.equalsIgnoreCase("AM") || ante.equalsIgnoreCase("A.M"))
		{
			JOptionPane.showMessageDialog(null, name + " removed from AM");
			showAMRoutine();
		}
		else if(ante.equalsIgnoreCase("PM") || ante.equalsIgnoreCase("P.M"))
		{
			JOptionPane.showMessageDialog(null, name + " removed from PM");
			showPMRoutine();
		}
	}
}
