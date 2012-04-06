import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Budget extends ItemList {
	
	private static final long serialVersionUID = 1L;

	public Budget(String itemTypeMessage, String itemCompleteMessage) {
		super(itemTypeMessage, itemCompleteMessage, 3);
		displayLabels();
		
		submitButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {				
				
				addItem();
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
			public void mouseClicked(MouseEvent arg0) {
				
				addItem();
			}
		});
	}

	@Override
	public void addItem() {
				
		if(!submitTextField.getText().isEmpty() && !submitIntegerField.getText().isEmpty()){			
		
			items.add(new Item(submitTextField.getText(), Integer.parseInt(submitIntegerField.getText())));
			submitTextField.setText("");
			submitIntegerField.setText("");
			displayList();
		}

	}

	@Override
	public void displayLabels() {		
		
		int totalBudget = 0;
		int totalSpent = 0;
		
		for(int i = 0; i < items.size(); i++){
			
			Item item = items.get(i);
			totalBudget += item.getAmount();
			if(item.getIsChecked()){
				totalSpent += item.getAmount();
			}
			
		}
		
		labelTotalItems.setText(itemTypeMessage + " $" + Integer.toString(totalBudget));
		labelTotalCompleted.setText(itemCompleteMessage + " $" + Integer.toString(totalSpent));
		
	}

}
