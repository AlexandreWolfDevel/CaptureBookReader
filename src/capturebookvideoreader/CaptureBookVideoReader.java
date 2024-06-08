package capturebookvideoreader;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class CaptureBookVideoReader {

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        CaptureBookVideoReaderScreen cap = new CaptureBookVideoReaderScreen();
        cap.setIconImage(new ImageIcon(cap.getClass().getResource("rsc/icon.png")).getImage());
        cap.setSize(800, 650);
        cap.setVisible(true);
    }
}
