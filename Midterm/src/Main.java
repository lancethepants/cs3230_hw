import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		SpringLayout layout = new SpringLayout();
		panel.setLayout(layout);

		ImagePanel myImage = new ImagePanel(new Dimension(430, 106),
				"images/left4dead.png");
		JLabel labelPack = new JLabel("Items to pack");
		JLabel labelItinery = new JLabel("Itinery");
		JLabel labelBudget = new JLabel("Budget");
		JLabel Excursion = new JLabel("Excursion");

		ItemsToPack itemsToPack = new ItemsToPack("Total number of items: ",
				"Items packed: ");
		Itinerary itinerary = new Itinerary("Total number of items: ",
				"Items completed: ");
		Budget budget = new Budget("Allocated items: ", "Items spent: ");

		layout.putConstraint(SpringLayout.WEST, myImage, 230,
				SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, itemsToPack, 175,
				SpringLayout.NORTH, myImage);
		layout.putConstraint(SpringLayout.NORTH, itinerary, 175,
				SpringLayout.NORTH, myImage);
		layout.putConstraint(SpringLayout.NORTH, budget, 175,
				SpringLayout.NORTH, myImage);
		layout.putConstraint(SpringLayout.WEST, itemsToPack, 5,
				SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.WEST, itinerary, 5,
				SpringLayout.EAST, itemsToPack);
		layout.putConstraint(SpringLayout.WEST, budget, 5, SpringLayout.EAST,
				itinerary);		
		layout.putConstraint(SpringLayout.EAST, frame, 5, SpringLayout.EAST,
				itinerary);
		
		layout.putConstraint(SpringLayout.WEST, labelPack, 70,
				SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, labelPack, -25,
				SpringLayout.NORTH, itemsToPack);
		
		layout.putConstraint(SpringLayout.WEST, labelItinery, 415,
				SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, labelItinery, -25,
				SpringLayout.NORTH, itemsToPack);
		
		layout.putConstraint(SpringLayout.WEST, labelBudget, 740,
				SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, labelBudget, -25,
				SpringLayout.NORTH, itemsToPack);
		
		layout.putConstraint(SpringLayout.WEST, Excursion, 400,
				SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, Excursion, 5,
				SpringLayout.SOUTH, myImage);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(910, 520);

		panel.add(Excursion);
		panel.add(labelPack);
		panel.add(labelItinery);
		panel.add(labelBudget);
		panel.add(itemsToPack);
		panel.add(itinerary);
		panel.add(budget);
 
		panel.add(myImage);
		frame.add(panel);

	}
}
