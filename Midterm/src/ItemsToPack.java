import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ItemsToPack extends ItemList {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemsToPack(String itemTypeMessage, String itemCompleteMessage) {
		super(itemTypeMessage, itemCompleteMessage, 1);
		displayLabels();

		submitButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

				addItem();
			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				addItem();
			}
		});

	}

	@Override
	public void addItem() {		
		
		if(!submitTextField.getText().isEmpty()){
			items.add(new Item(submitTextField.getText()));
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
