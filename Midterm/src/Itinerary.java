import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Itinerary extends ItemList {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Itinerary(String itemTypeMessage, String itemCompleteMessage) {
		super(itemTypeMessage, itemCompleteMessage, 2);

		displayLabels();

		submitButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

				try {
					addItem();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					addItem();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}

	@Override
	public void addItem() throws Exception {

		if (!submitTextField.getText().isEmpty()) {			
			
			items.add(new Item(submitTextField.getText(),
				myDate.getDate()));	
			
			submitTextField.setText("");
			displayList();
		}				

	}

	@Override
	public void displayLabels() {
		
		totalCompleted = 0;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getIsChecked()) {
				totalCompleted += 1;
			}
		}
		labelTotalCompleted.setText(itemCompleteMessage
				+ Integer.toString(totalCompleted));

		labelTotalItems.setText(itemTypeMessage
				+ Integer.toString(items.size()));
		
	}

}
