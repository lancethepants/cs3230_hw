import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class Item implements Comparable<Item> {

	private JLabel labeItemDesciption;
	private JLabel labeItemDate;
	private Date date;
	private int amount;
	private boolean isChecked = false;

	public Item(String itemDescription) {

		labeItemDesciption = new JLabel(itemDescription);
		labeItemDesciption.setVisible(true);
		labeItemDesciption.setSize(new Dimension(150, 15));

	}

	public Item(String itemDescription, Date date) {
		this.date = date;
		labeItemDesciption = new JLabel(itemDescription);			
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy  @ hh:mm aaa");		
		labeItemDate = new JLabel(formatter.format(date));
		//labeItemDate = new JLabel(date.toString());
	}

	public Item(String itemDescription, int amount) {

		this.amount = amount;
		labeItemDesciption = new JLabel(itemDescription);
	}

	public void setIsChecked(boolean set) {
		isChecked = set;
	}

	public boolean getIsChecked() {
		return isChecked;
	}

	public JLabel getItemDescription() {
		return labeItemDesciption;
	}

	public JLabel getItemDate() {
		return labeItemDate;
	}

	public JLabel getItemAmount() {
		return new JLabel("$" + amount);
	}

	public int getAmount() {
		return amount;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public int compareTo(Item o) {

		return date.compareTo(o.getDate());

	}

}
