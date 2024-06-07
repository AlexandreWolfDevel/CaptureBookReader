package capturebookvideoreader;

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
        cap.setSize(800, 530);
        cap.setVisible(true);
    }
}
