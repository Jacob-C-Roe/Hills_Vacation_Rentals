/*
 * Created by: Jacob Roe
 * Created On: 11/10/2022
 * 
 * Modification Log
 * Date			Programmer		Description
 * 11/10/2022	Jacob Roe		Initial Implementation
 * 
 * Description: GUI display to check pricing of Hill's Vacation Rentals
 */
package rentals;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

public class Window extends JFrame {
	//Establish private objects to use in the window
	private int width;
	private int height;
	private JLabel welcome;
	private JToggleButton park;
	private JToggleButton lake;
	private JToggleButton pool;
	private ButtonGroup locations;
	private String[] roomsContents = {"1 room","2 rooms","3 rooms"};
	private JComboBox<String> rooms;
	private JToggleButton meals;
	private JButton getPrice;
	private JLabel price;
	
	//Establish integers for the price equation
	private int location;
	private int roomPrice;
	private int mealPlan;
	//JFrame constructor
	public Window(int w, int h) {
		super("Hill's Vacation Rentals");
		width = w;
		height = h;
		welcome = new JLabel("Welcome to Hill's Vacation Rentals");
		park = new JToggleButton("Parkside");
		lake = new JToggleButton("Lakeside");
		pool = new JToggleButton("Poolside");
		locations = new ButtonGroup();
		rooms = new JComboBox<String>(roomsContents);
		meals = new JToggleButton("Meals");
		price = new JLabel("total price: ");
		getPrice = new JButton("Click to get your total price!");
		
	}
	public void window() {
		//Create window object
		
		//Set the layout to Flow
		setLayout(new FlowLayout());
		
		//Set window size
		setSize(width,height);
		setResizable(true);
		
		
		//Set Font and add JLabel for welcome
		welcome.setFont(new Font("serif",Font.BOLD, 22));
		add(welcome);
		
		//Add ToggleButtons for Button Group
		locations.add(park);
		locations.add(lake);
		locations.add(pool);
		
		add(park);
		//Set Action Listener for park
		park.addActionListener(e -> {
			location = 600;
			});
		
		add(lake);
		//Set Action Listener for lake
		lake.addActionListener(e -> {
			location = 750;
			});
		
		add(pool);
		//Set Action Listener for pool
		pool.addActionListener(e -> {
			location = 825;
			});
		
		//Add JComboBox
		add(rooms);
		//Set Action Listener for pool
		rooms.addActionListener(e -> {
				//Create selected object to get the selected item
				String selected =  (String) rooms.getSelectedItem();
				//Switch case to set the roomNum equal to the selection
				switch (selected) {
					case "1 room":
						roomPrice = 1 * 75;
						break;
					case "2 rooms":
						roomPrice = 2 * 75;
						break;
					case "3 rooms":
						roomPrice = 3 * 75;
						break;
				}
			});
		
		//Add ToggleButton for meals
		add(meals);
		//Set ActiuonListener for meals
		meals.addActionListener(e -> {
			mealPlan = 200;		  
			});
		
		//Add JButton to get price
		add(getPrice);
		getPrice.addActionListener(e -> {
			double total = total();
			total();
			price.setText("total price: " + total);
			});
				
		//Add JLabel for total price
		price.setFont(new Font("serif",Font.PLAIN, 18));
		add(price);
		
		//Set the application to exit on closing the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set window to visible
		setVisible(true);
	}
	public double total() {
		double price = location + roomPrice + mealPlan;
		return price;
	}
	
}
