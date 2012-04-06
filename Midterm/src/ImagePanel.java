import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

 public class ImagePanel extends JPanel {
		
	private static final long serialVersionUID = 1L;
		ImageIcon image;

		public ImagePanel(Dimension dim, String imageLocation) {

			image = new ImageIcon(imageLocation);
			setPreferredSize(dim);
			scaleImage(dim);
			JLabel imageLabel = new JLabel(image);
			add(imageLabel);

		}

		private void scaleImage(Dimension dim) {
			int iHeight = image.getIconHeight();
			int iWidth = image.getIconWidth();
			double iRatio = (double) iWidth / iHeight;
			double pRatio = (double) dim.width / dim.height;

			if (pRatio < iRatio) // scale image width
				image = new ImageIcon(image.getImage().getScaledInstance(
						dim.width, -1, Image.SCALE_SMOOTH));
			else
				// scale image height
				image = new ImageIcon(image.getImage().getScaledInstance(-1,
						dim.height, Image.SCALE_SMOOTH));
		}

	}