import java.awt.EventQueue;

import es.uca.gii.csi.caves.data.Data;
import es.uca.gii.csi.caves.gui.FrmMain;

/**
 * Programa principal
 */
public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{			
				try {
					Data.LoadDriver();
					FrmMain window = new FrmMain();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
