package capturebookreader;

import javax.swing.UIManager;

public class CaptureBookReader {

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

        CaptureBookReaderScreen cap = new CaptureBookReaderScreen();
        cap.setSize(800, 600);
        cap.setVisible(true);
    }
}
