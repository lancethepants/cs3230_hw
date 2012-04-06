import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.SpringLayout;

import com.lavantech.gui.comp.DateTimePicker;

public abstract class ItemList extends JPanel {

	private static final long serialVersionUID = 1L;

	public ArrayList<Item> items;
	static int totalCompleted;

	public JPanel itemCount;
	public JPanel itemSubmit;
	public JPanel itemDisplay;

	JPanel primarySubmit = new JPanel();
	JPanel secondarySubmit;

	JLabel labelTotalItems;
	JLabel labelTotalCompleted;
	JLabel labelItemDescription;
	JLabel labelItemDate;
	JLabel labelItemAmount;
	JLabel submitLabel;

	JButton submitButton;
	JTextField submitTextField;
	JTextField submitIntegerField;
	JScrollPane pane;
	DateTimePicker myDate;

	String itemTypeMessage;
	String itemCompleteMessage;
	int listType;

	public ItemList(String itemTypeMessage, String itemCompleteMessage,
			int listType) {

		this.itemTypeMessage = itemTypeMessage;
		this.itemCompleteMessage = itemCompleteMessage;
		this.listType = listType;

		items = new ArrayList<Item>();
		totalCompleted = 0;

		itemCount = new JPanel();
		itemSubmit = new JPanel();
		itemDisplay = new JPanel();

		itemDisplay.setLayout(new BoxLayout(itemDisplay, BoxLayout.Y_AXIS));

		pane = new JScrollPane(itemDisplay);
		pane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setVisible(true);
		pane.setPreferredSize(new Dimension(200, 150));
		pane.setLayout(new ScrollPaneLayout());

		submitButton = new JButton("Submit");

		labelTotalItems = new JLabel();
		labelTotalCompleted = new JLabel();
		submitLabel = new JLabel("Item: ");

		submitIntegerField = new JTextField(10);
		submitTextField = new JTextField(10);

		submitTextField.setMaximumSize(new Dimension(375, 25));
		submitIntegerField.setMaximumSize(new Dimension(375, 25));

		myDate = new DateTimePicker();
		myDate.setPopupModal(true);

		setLayout(new BorderLayout());

		itemCount.setLayout(new BorderLayout());
		itemCount.add(labelTotalItems, BorderLayout.NORTH);
		itemCount.add(labelTotalCompleted, BorderLayout.CENTER);

		itemSubmit.setLayout(new BoxLayout(itemSubmit, BoxLayout.Y_AXIS));

		SpringLayout submitLayout = new SpringLayout();

		primarySubmit.setLayout(submitLayout);

		submitLayout.putConstraint(SpringLayout.NORTH, submitTextField, 15,
				SpringLayout.NORTH, itemSubmit);
		submitLayout.putConstraint(SpringLayout.NORTH, submitLabel, 15,
				SpringLayout.NORTH, itemSubmit);

		primarySubmit.add(submitLabel);
		primarySubmit.add(submitTextField);

		itemSubmit.add(primarySubmit);
		secondarySubmit = new JPanel();

		if (listType == 1) {
			submitLayout.putConstraint(SpringLayout.WEST, submitTextField, 50,
					SpringLayout.WEST, itemSubmit);
			submitLayout.putConstraint(SpringLayout.EAST, submitLabel, -5,
					SpringLayout.WEST, submitTextField);

			submitLayout.putConstraint(SpringLayout.NORTH, submitTextField, 30,
					SpringLayout.NORTH, itemSubmit);
			submitLayout.putConstraint(SpringLayout.NORTH, submitLabel, 30,
					SpringLayout.NORTH, itemSubmit);

			submitLayout.putConstraint(SpringLayout.WEST, submitButton, 67,
					SpringLayout.WEST, submitIntegerField);
			submitLayout.putConstraint(SpringLayout.NORTH, submitButton, 60,
					SpringLayout.NORTH, itemSubmit);
		}

		if (listType == 2) {
			submitLabel.setText("Description:");
			JLabel DateTime = new JLabel("Date and Time:");
			primarySubmit.add(DateTime);
			primarySubmit.add(myDate);
			itemSubmit.add(secondarySubmit);
			submitLayout.putConstraint(SpringLayout.WEST, submitTextField, 130,
					SpringLayout.WEST, itemSubmit);
			submitLayout.putConstraint(SpringLayout.EAST, submitLabel, -5,
					SpringLayout.WEST, submitTextField);
			submitLayout.putConstraint(SpringLayout.NORTH, submitButton, 75,
					SpringLayout.NORTH, itemSubmit);
			submitLayout.putConstraint(SpringLayout.WEST, submitButton, 156,
					SpringLayout.WEST,

					itemSubmit);

			submitLayout.putConstraint(SpringLayout.NORTH, myDate, 40,
					SpringLayout.NORTH, itemSubmit);
			submitLayout.putConstraint(SpringLayout.WEST, myDate, 130,
					SpringLayout.WEST, itemSubmit);
			submitLayout.putConstraint(SpringLayout.NORTH, DateTime, 40,
					SpringLayout.NORTH, itemSubmit);
			submitLayout.putConstraint(SpringLayout.EAST, DateTime, -5,
					SpringLayout.WEST, myDate);

		}
		if (listType == 3) {
			submitLabel.setText("Description:");
			JLabel amount = new JLabel("Amount:");
			primarySubmit.add(amount);
			primarySubmit.add(submitIntegerField);
			itemSubmit.add(secondarySubmit);
			submitLayout.putConstraint(SpringLayout.WEST, submitTextField, 100,
					SpringLayout.WEST, itemSubmit);
			submitLayout.putConstraint(SpringLayout.EAST, submitLabel, -5,
					SpringLayout.WEST, submitTextField);
			submitLayout.putConstraint(SpringLayout.NORTH, amount, 40,
					SpringLayout.NORTH, itemSubmit);
			submitLayout.putConstraint(SpringLayout.NORTH, submitIntegerField,
					40, SpringLayout.NORTH, itemSubmit);
			submitLayout.putConstraint(SpringLayout.WEST, submitIntegerField,
					100, SpringLayout.WEST, itemSubmit);
			submitLayout.putConstraint(SpringLayout.EAST, amount, -5,
					SpringLayout.WEST, submitIntegerField);
			submitLayout.putConstraint(SpringLayout.WEST, submitButton, 16,
					SpringLayout.WEST, submitIntegerField);
			submitLayout.putConstraint(SpringLayout.NORTH, submitButton, 67,
					SpringLayout.NORTH, itemSubmit);
		}

		primarySubmit.add(submitButton);

		add(itemCount, BorderLayout.NORTH);
		add(itemSubmit, BorderLayout.CENTER);
		add(pane, BorderLayout.SOUTH);

		if (listType == 1) {
			setPreferredSize(new Dimension(235, 300));
			setMinimumSize(new Dimension(235, 300));
		}

		if (listType == 2) {
			setPreferredSize(new Dimension(365, 300));
			setMinimumSize(new Dimension(365, 300));
		}
		if (listType == 3) {
			setPreferredSize(new Dimension(275, 300));
			setMinimumSize(new Dimension(275, 300));
		}

	}

	public void displayList() {

		itemDisplay.removeAll();
		repaint();
		totalCompleted = 0;

		if (listType == 2) {

			Collections.sort(items);
		}

		for (int i = 0; i < items.size(); i++) {

			final Item item = items.get(i);
			JPanel itemPanel = new JPanel();
			final JButton deleteButton = new JButton("Delete");
			deleteButton.setVisible(false);
			deleteButton.setForeground(Color.RED);
			deleteButton.setSize(new Dimension(50, 15));
			final JCheckBox checkBox = new JCheckBox();
			labelItemDescription = item.getItemDescription();
			labelItemDate = item.getItemDate();
			labelItemAmount = item.getItemAmount();

			MouseListener deleteButtonListener = new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					deleteButton.setVisible(false);

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					deleteButton.setVisible(true);

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub

				}
			};

			if (items.get(i).getIsChecked()) {
				checkBox.setSelected(true);
			}

			labelItemDescription.addMouseListener(deleteButtonListener);
			checkBox.addMouseListener(deleteButtonListener);
			deleteButton.addMouseListener(deleteButtonListener);
			itemPanel.addMouseListener(deleteButtonListener);

			labelItemDescription.setMaximumSize(new Dimension(100, 30));
			checkBox.setMaximumSize(new Dimension(30, 30));
			deleteButton.setMaximumSize(new Dimension(10, 30));

			itemPanel.add(labelItemDescription);
			itemPanel.add(checkBox);

			if (listType == 2) {
				labelItemDate.addMouseListener(deleteButtonListener);
				itemPanel.add(labelItemDate);

			}
			if (listType == 3) {
				labelItemAmount.addMouseListener(deleteButtonListener);
				itemPanel.add(labelItemAmount);
			}

			itemPanel.add(deleteButton);

			if (listType == 1) {

				SpringLayout layout = new SpringLayout();

				itemPanel.setLayout(layout);
				layout.putConstraint(SpringLayout.WEST, checkBox, 100,
						SpringLayout.WEST, itemPanel);
				layout.putConstraint(SpringLayout.WEST, deleteButton, 15,
						SpringLayout.EAST, checkBox);
			}

			if (listType == 2) {

				SpringLayout layout = new SpringLayout();

				layout.putConstraint(SpringLayout.WEST, checkBox, 100,
						SpringLayout.WEST, itemPanel);
				layout.putConstraint(SpringLayout.WEST, labelItemDate, 12,
						SpringLayout.EAST, checkBox);
				layout.putConstraint(SpringLayout.WEST, deleteButton, 10,
						SpringLayout.EAST, labelItemDate);
				itemPanel.setLayout(layout);
			}

			if (listType == 3) {

				SpringLayout layout = new SpringLayout();

				layout.putConstraint(SpringLayout.WEST, checkBox, 100,
						SpringLayout.WEST, itemPanel);
				layout.putConstraint(SpringLayout.WEST, labelItemAmount, 125,
						SpringLayout.WEST, itemPanel);
				layout.putConstraint(SpringLayout.WEST, deleteButton, 175,
						SpringLayout.WEST, itemPanel);
				itemPanel.setLayout(layout);

			}

			itemPanel.setPreferredSize(new Dimension(380, 30));
			itemPanel.setMaximumSize(new Dimension(380, 30));
			itemPanel.setMinimumSize(new Dimension(380, 30));
			itemDisplay.add(itemPanel);
			itemDisplay.setMinimumSize(new Dimension(300, 300));

			checkBox.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {

					if (checkBox.isSelected()) {
						item.setIsChecked(true);
					} else if (!checkBox.isSelected()) {
						item.setIsChecked(false);
					}
					displayLabels();
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

					if (checkBox.isSelected()) {
						item.setIsChecked(true);
					} else if (!checkBox.isSelected()) {
						item.setIsChecked(false);
					}

					displayLabels();
				}
			});

			deleteButton.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {

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

					items.remove(item);
					displayList();
				}
			});

		}
		displayLabels();
	}

	public abstract void displayLabels();

	public abstract void addItem() throws Exception;

}
