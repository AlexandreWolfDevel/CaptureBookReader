package capturebookvideoreader;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

public class CaptureBookVideoReaderScreen extends javax.swing.JFrame {

    private BufferedImage images[] = null;
    private Robot robot = null;
    private int offset = -1;

    private int screenResolutionX = 1920;
    private int screenResolutionY = 1200;

    private int offsetScroolX = 0;
    private int offsetScroolY = 0;
    private int positionX = 0;
    private int positionY = 0;

    public CaptureBookVideoReaderScreen() {

        initComponents();
        
        getResolution();

        System.out.println(screenResolutionX + " " + screenResolutionY);

        int pageDown = 0;
        int pageRoll = 0;
        for (int i = 0; i < 255; i++) {
            cbNextPageKey.addItem(KeyEvent.getKeyText(i));
            cbRollPageKey.addItem(KeyEvent.getKeyText(i));

            if (KeyEvent.getKeyText(i).equals("Page Down")) {
                pageDown = i;
            } else if (KeyEvent.getKeyText(i).equals("End")) {
                pageRoll = i;
            }
        }

        cbNextPageKey.setSelectedIndex(pageDown);
        cbRollPageKey.setSelectedIndex(pageRoll);

        offsetScroolX = spShowImage.getHorizontalScrollBarPolicy();
        offsetScroolY = spShowImage.getVerticalScrollBarPolicy();

        try {
            
            robot = new Robot();
            
            Properties props = new Properties();
            FileInputStream file = new FileInputStream("./CaptureBookReader.properties");
            props.load(file);

            tfTimeBetweenCaptures.setText(props.getProperty("tfTimeBetweenCaptures"));
            tfNumBookPages.setText(props.getProperty("tfNumBookPages"));
            tfNumCapturesInPage.setText(props.getProperty("tfNumCapturesInPage"));
            tfTimeToFirstCapture.setText(props.getProperty("tfTimeToFirstCapture"));
            cbTryReconstructPages.setSelected(Boolean.parseBoolean(props.getProperty("cbTryReconstructPages")));

            cbNextPageKey.setSelectedIndex(Integer.parseInt(props.getProperty("cbNextPageKey")));
            tfNumTouchPage.setText(props.getProperty("tfNumTouchPage"));
            cbRollPageKey.setSelectedIndex(Integer.parseInt(props.getProperty("cbRollPageKey")));
            tfNumTouchRoll.setText(props.getProperty("tfNumTouchRoll"));
            tfPixelsInnerPages.setText(props.getProperty("tfPixelsInnerPages"));

            cbSaveImagesBlock.setSelected(Boolean.parseBoolean(props.getProperty("cbSaveImagesBlock")));
            cbSavePages.setSelected(Boolean.parseBoolean(props.getProperty("cbSavePages")));
            cbGeneratePDF.setSelected(Boolean.parseBoolean(props.getProperty("cbGeneratePDF")));
            cbSaveSettingsParameters.setSelected(Boolean.parseBoolean(props.getProperty("cbSaveSettingsParameters")));
            cbFixPixelsInnerPages.setSelected(Boolean.parseBoolean(props.getProperty("cbFixPixelsInnerPages")));

            tfFilesDestination.setText(props.getProperty("tfFilesDestination"));
            tfPositionX1.setText(props.getProperty("tfPositionX1"));
            tfPositionY1.setText(props.getProperty("tfPositionY1"));
            tfPositionX2.setText(props.getProperty("tfPositionX2"));
            tfPositionY2.setText(props.getProperty("tfPositionY2"));

            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getResolution() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenResolutionX = (int) screenSize.getWidth();
        screenResolutionY = (int) screenSize.getHeight();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbToolBar = new javax.swing.JToolBar();
        btTestLocations = new javax.swing.JButton();
        btPreview = new javax.swing.JButton();
        btCapture = new javax.swing.JButton();
        spMain = new javax.swing.JSplitPane();
        paLeft = new javax.swing.JPanel();
        pqCaptures = new javax.swing.JPanel();
        paCapturesTop = new javax.swing.JPanel();
        paTime = new javax.swing.JPanel();
        lbTimeBetweenCaptures = new javax.swing.JLabel();
        tfTimeBetweenCaptures = new javax.swing.JFormattedTextField();
        paNumberBookPages = new javax.swing.JPanel();
        lbNumBookPages = new javax.swing.JLabel();
        tfNumBookPages = new javax.swing.JFormattedTextField();
        paNumCapturesInPage = new javax.swing.JPanel();
        lbNumCapturesInPage = new javax.swing.JLabel();
        tfNumCapturesInPage = new javax.swing.JFormattedTextField();
        paTimeToFirstCapture = new javax.swing.JPanel();
        lbTimeToFistCapture = new javax.swing.JLabel();
        tfTimeToFirstCapture = new javax.swing.JFormattedTextField();
        cbTryReconstructPages = new javax.swing.JCheckBox();
        paKeys = new javax.swing.JPanel();
        paKeysTop = new javax.swing.JPanel();
        paNextPageKey = new javax.swing.JPanel();
        lbNextePageKey = new javax.swing.JLabel();
        cbNextPageKey = new javax.swing.JComboBox<>();
        paNumTouchPage = new javax.swing.JPanel();
        lbNumTouchPage = new javax.swing.JLabel();
        tfNumTouchPage = new javax.swing.JFormattedTextField();
        paRolPagekey = new javax.swing.JPanel();
        lbRollPageKey = new javax.swing.JLabel();
        cbRollPageKey = new javax.swing.JComboBox<>();
        paNumTouchRoll = new javax.swing.JPanel();
        lbNumTouchRoll = new javax.swing.JLabel();
        tfNumTouchRoll = new javax.swing.JFormattedTextField();
        paPixelsInnerPages = new javax.swing.JPanel();
        lbPixelsInnerPages = new javax.swing.JLabel();
        tfPixelsInnerPages = new javax.swing.JFormattedTextField();
        paSave = new javax.swing.JPanel();
        cbSaveImagesBlock = new javax.swing.JCheckBox();
        cbSavePages = new javax.swing.JCheckBox();
        cbGeneratePDF = new javax.swing.JCheckBox();
        cbSaveSettingsParameters = new javax.swing.JCheckBox();
        cbFixPixelsInnerPages = new javax.swing.JCheckBox();
        paFiles = new javax.swing.JPanel();
        paFilesTop = new javax.swing.JPanel();
        paFilesNames = new javax.swing.JPanel();
        lbFilesDestination = new javax.swing.JLabel();
        tfFilesDestination = new javax.swing.JTextField();
        btFileDestination = new javax.swing.JButton();
        paPositions = new javax.swing.JPanel();
        paPositionsX1 = new javax.swing.JPanel();
        lbPositionX1 = new javax.swing.JLabel();
        tfPositionX1 = new javax.swing.JFormattedTextField();
        paPositionsY1 = new javax.swing.JPanel();
        lbPositionY1 = new javax.swing.JLabel();
        tfPositionY1 = new javax.swing.JFormattedTextField();
        paPositionsX2 = new javax.swing.JPanel();
        lbPositionX2 = new javax.swing.JLabel();
        tfPositionX2 = new javax.swing.JFormattedTextField();
        paPositionsY2 = new javax.swing.JPanel();
        lbPositionY2 = new javax.swing.JLabel();
        tfPositionY2 = new javax.swing.JFormattedTextField();
        tbPanes = new javax.swing.JTabbedPane();
        spShowImage = new javax.swing.JScrollPane();
        lbShowImage = new javax.swing.JLabel();
        spShowSecondaryImage = new javax.swing.JScrollPane();
        lbShowSecondaryImage = new javax.swing.JLabel();
        spShowThirdImage = new javax.swing.JScrollPane();
        lbShowThirdImage = new javax.swing.JLabel();
        paButton = new javax.swing.JPanel();
        tfStatusInfo = new javax.swing.JTextField();
        tfStatusBar = new javax.swing.JTextField();
        pbProgressBar = new javax.swing.JProgressBar();
        mbMainMenu = new javax.swing.JMenuBar();
        mmFiles = new javax.swing.JMenu();
        mmUtil = new javax.swing.JMenu();
        miSetInitialSuggestedValues = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Capture Book Reader");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                eventWindowClosing(evt);
            }
        });

        tbToolBar.setRollover(true);

        btTestLocations.setText("Test Locations ");
        btTestLocations.setFocusable(false);
        btTestLocations.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btTestLocations.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btTestLocations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTestLocationsActionPerformed(evt);
            }
        });
        tbToolBar.add(btTestLocations);

        btPreview.setText("Preview Capture");
        btPreview.setFocusable(false);
        btPreview.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btPreview.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPreviewActionPerformed(evt);
            }
        });
        tbToolBar.add(btPreview);

        btCapture.setText("Capture");
        btCapture.setFocusable(false);
        btCapture.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCapture.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbToolBar.add(btCapture);

        getContentPane().add(tbToolBar, java.awt.BorderLayout.NORTH);

        spMain.setDividerSize(3);

        paLeft.setLayout(new java.awt.GridLayout(4, 3));

        pqCaptures.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pqCaptures.setLayout(new java.awt.BorderLayout());

        paCapturesTop.setLayout(new javax.swing.BoxLayout(paCapturesTop, javax.swing.BoxLayout.Y_AXIS));

        paTime.setLayout(new java.awt.GridLayout(1, 2));

        lbTimeBetweenCaptures.setText("Time Between Captures");
        paTime.add(lbTimeBetweenCaptures);

        tfTimeBetweenCaptures.setText("300");
        paTime.add(tfTimeBetweenCaptures);

        paCapturesTop.add(paTime);

        paNumberBookPages.setLayout(new java.awt.GridLayout(1, 2));

        lbNumBookPages.setText("Num. book pages");
        paNumberBookPages.add(lbNumBookPages);

        tfNumBookPages.setText("100");
        paNumberBookPages.add(tfNumBookPages);

        paCapturesTop.add(paNumberBookPages);

        paNumCapturesInPage.setLayout(new java.awt.GridLayout(1, 2));

        lbNumCapturesInPage.setText("Num. captures in page");
        paNumCapturesInPage.add(lbNumCapturesInPage);

        tfNumCapturesInPage.setText("2");
        paNumCapturesInPage.add(tfNumCapturesInPage);

        paCapturesTop.add(paNumCapturesInPage);

        paTimeToFirstCapture.setLayout(new java.awt.GridLayout(1, 2));

        lbTimeToFistCapture.setText("Time to first capture");
        paTimeToFirstCapture.add(lbTimeToFistCapture);

        tfTimeToFirstCapture.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        tfTimeToFirstCapture.setText("5000");
        paTimeToFirstCapture.add(tfTimeToFirstCapture);

        paCapturesTop.add(paTimeToFirstCapture);

        pqCaptures.add(paCapturesTop, java.awt.BorderLayout.NORTH);

        cbTryReconstructPages.setSelected(true);
        cbTryReconstructPages.setText("Try reconstruct pages (connect pages)");
        pqCaptures.add(cbTryReconstructPages, java.awt.BorderLayout.CENTER);

        paLeft.add(pqCaptures);

        paKeys.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        paKeys.setLayout(new java.awt.BorderLayout());

        paKeysTop.setLayout(new javax.swing.BoxLayout(paKeysTop, javax.swing.BoxLayout.Y_AXIS));

        paNextPageKey.setLayout(new java.awt.GridLayout(1, 2));

        lbNextePageKey.setText("Next page key");
        paNextPageKey.add(lbNextePageKey);
        paNextPageKey.add(cbNextPageKey);

        paKeysTop.add(paNextPageKey);

        paNumTouchPage.setLayout(new java.awt.GridLayout(1, 2));

        lbNumTouchPage.setText("Num. touch page");
        paNumTouchPage.add(lbNumTouchPage);

        tfNumTouchPage.setText("1");
        paNumTouchPage.add(tfNumTouchPage);

        paKeysTop.add(paNumTouchPage);

        paRolPagekey.setLayout(new java.awt.GridLayout(1, 2));

        lbRollPageKey.setText("Roll page key");
        paRolPagekey.add(lbRollPageKey);
        paRolPagekey.add(cbRollPageKey);

        paKeysTop.add(paRolPagekey);

        paNumTouchRoll.setLayout(new java.awt.GridLayout(1, 2));

        lbNumTouchRoll.setText("Num. touch roll");
        paNumTouchRoll.add(lbNumTouchRoll);

        tfNumTouchRoll.setText("1");
        paNumTouchRoll.add(tfNumTouchRoll);

        paKeysTop.add(paNumTouchRoll);

        paPixelsInnerPages.setLayout(new java.awt.GridLayout(1, 2));

        lbPixelsInnerPages.setText("Pixels inner pages");
        paPixelsInnerPages.add(lbPixelsInnerPages);

        tfPixelsInnerPages.setText("100");
        paPixelsInnerPages.add(tfPixelsInnerPages);

        paKeysTop.add(paPixelsInnerPages);

        paKeys.add(paKeysTop, java.awt.BorderLayout.NORTH);

        paLeft.add(paKeys);

        paSave.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        paSave.setLayout(new javax.swing.BoxLayout(paSave, javax.swing.BoxLayout.Y_AXIS));

        cbSaveImagesBlock.setText("Save images block");
        paSave.add(cbSaveImagesBlock);

        cbSavePages.setSelected(true);
        cbSavePages.setText("Save pages");
        paSave.add(cbSavePages);

        cbGeneratePDF.setSelected(true);
        cbGeneratePDF.setText("Generate PDF");
        paSave.add(cbGeneratePDF);

        cbSaveSettingsParameters.setSelected(true);
        cbSaveSettingsParameters.setText("Save Settings Parameters");
        paSave.add(cbSaveSettingsParameters);

        cbFixPixelsInnerPages.setText("Fix Pixels inner Pages (defined by user)");
        paSave.add(cbFixPixelsInnerPages);

        paLeft.add(paSave);

        paFiles.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        paFiles.setLayout(new java.awt.BorderLayout());

        paFilesTop.setLayout(new javax.swing.BoxLayout(paFilesTop, javax.swing.BoxLayout.Y_AXIS));

        paFilesNames.setLayout(new java.awt.BorderLayout());

        lbFilesDestination.setText("Files destination ");
        paFilesNames.add(lbFilesDestination, java.awt.BorderLayout.WEST);

        tfFilesDestination.setText("/temp/screenshot");
        paFilesNames.add(tfFilesDestination, java.awt.BorderLayout.CENTER);

        btFileDestination.setText("...");
        paFilesNames.add(btFileDestination, java.awt.BorderLayout.EAST);

        paFilesTop.add(paFilesNames);

        paFiles.add(paFilesTop, java.awt.BorderLayout.NORTH);

        paPositions.setLayout(new javax.swing.BoxLayout(paPositions, javax.swing.BoxLayout.Y_AXIS));

        paPositionsX1.setLayout(new java.awt.GridLayout(1, 2));

        lbPositionX1.setText("Position X1");
        paPositionsX1.add(lbPositionX1);

        tfPositionX1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        tfPositionX1.setText("0");
        paPositionsX1.add(tfPositionX1);

        paPositions.add(paPositionsX1);

        paPositionsY1.setLayout(new java.awt.GridLayout(1, 2));

        lbPositionY1.setText("Position Y1");
        paPositionsY1.add(lbPositionY1);

        tfPositionY1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        tfPositionY1.setText("0");
        paPositionsY1.add(tfPositionY1);

        paPositions.add(paPositionsY1);

        paPositionsX2.setLayout(new java.awt.GridLayout(1, 2));

        lbPositionX2.setText("Position X2");
        paPositionsX2.add(lbPositionX2);

        tfPositionX2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        tfPositionX2.setText("1920");
        paPositionsX2.add(tfPositionX2);

        paPositions.add(paPositionsX2);

        paPositionsY2.setLayout(new java.awt.GridLayout(1, 2));

        lbPositionY2.setText("Position Y2");
        paPositionsY2.add(lbPositionY2);

        tfPositionY2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        tfPositionY2.setText("1200");
        paPositionsY2.add(tfPositionY2);

        paPositions.add(paPositionsY2);

        paFiles.add(paPositions, java.awt.BorderLayout.SOUTH);

        paLeft.add(paFiles);

        spMain.setLeftComponent(paLeft);

        lbShowImage.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                eventMouseMoved(evt);
            }
        });
        lbShowImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventShowImageClilck(evt);
            }
        });
        spShowImage.setViewportView(lbShowImage);

        tbPanes.addTab("Main Process", spShowImage);

        spShowSecondaryImage.setViewportView(lbShowSecondaryImage);

        tbPanes.addTab("Secondary (1 st page)", spShowSecondaryImage);

        spShowThirdImage.setViewportView(lbShowThirdImage);

        tbPanes.addTab("Secondary (2 nd page)", spShowThirdImage);

        spMain.setRightComponent(tbPanes);
        tbPanes.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(spMain, java.awt.BorderLayout.CENTER);

        paButton.setLayout(new java.awt.BorderLayout());

        tfStatusInfo.setEditable(false);
        tfStatusInfo.setText("    x      ,       y ");
        paButton.add(tfStatusInfo, java.awt.BorderLayout.LINE_START);

        tfStatusBar.setEditable(false);
        tfStatusBar.setText("Capture Book Reader 1.0a");
        paButton.add(tfStatusBar, java.awt.BorderLayout.CENTER);
        paButton.add(pbProgressBar, java.awt.BorderLayout.EAST);

        getContentPane().add(paButton, java.awt.BorderLayout.SOUTH);

        mmFiles.setText("File");
        mbMainMenu.add(mmFiles);

        mmUtil.setText("Util");

        miSetInitialSuggestedValues.setText("Set initial suggested values");
        miSetInitialSuggestedValues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSetInitialSuggestedValuesActionPerformed(evt);
            }
        });
        mmUtil.add(miSetInitialSuggestedValues);

        mbMainMenu.add(mmUtil);

        setJMenuBar(mbMainMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btTestLocationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTestLocationsActionPerformed
        try {
            Thread.sleep(Integer.parseInt(tfTimeToFirstCapture.getText()));
            BufferedImage captureScreen = robot.createScreenCapture(new Rectangle(screenResolutionX, screenResolutionY));
            lbShowImage.setIcon(new ImageIcon(captureScreen));
            tbPanes.setSelectedIndex(0);
            playSound("beep.wav");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btTestLocationsActionPerformed

    private void eventMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventMouseMoved
        positionX = evt.getX() + spShowImage.getHorizontalScrollBarPolicy() - offsetScroolX;
        positionY = evt.getY() + spShowImage.getVerticalScrollBarPolicy() - offsetScroolY;
        tfStatusInfo.setText("  x=" + positionX + ", y=" + positionY);
    }//GEN-LAST:event_eventMouseMoved

    private void eventShowImageClilck(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventShowImageClilck
        if (evt.getButton() == 3) {
            PopupPositions popup = new PopupPositions(this, true);
            popup.setPositions(positionX, positionY);
            popup.setParentClass(this);
            popup.setLocation(evt.getXOnScreen(), evt.getYOnScreen());
            popup.setVisible(true);
        }
    }//GEN-LAST:event_eventShowImageClilck

    private void eventWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_eventWindowClosing
        if (cbSaveSettingsParameters.isSelected()) {
            try {
                FileOutputStream file = new FileOutputStream("./CaptureBookReader.properties");

                file.write(("tfTimeBetweenCaptures=" + tfTimeBetweenCaptures.getText() + "\n").getBytes());
                file.write(("tfNumBookPages=" + tfNumBookPages.getText() + "\n").getBytes());
                file.write(("tfNumCapturesInPage=" + tfNumCapturesInPage.getText() + "\n").getBytes());
                file.write(("tfTimeToFirstCapture=" + tfTimeToFirstCapture.getText() + "\n").getBytes());
                file.write(("cbTryReconstructPages=" + cbTryReconstructPages.isSelected() + "\n").getBytes());

                file.write(("cbNextPageKey=" + cbNextPageKey.getSelectedIndex() + "\n").getBytes());
                file.write(("tfNumTouchPage=" + tfNumTouchPage.getText() + "\n").getBytes());
                file.write(("cbRollPageKey=" + cbRollPageKey.getSelectedIndex() + "\n").getBytes());
                file.write(("tfNumTouchRoll=" + tfNumTouchRoll.getText() + "\n").getBytes());
                file.write(("tfPixelsInnerPages=" + tfPixelsInnerPages.getText() + "\n").getBytes());

                file.write(("cbSaveImagesBlock=" + cbSaveImagesBlock.isSelected() + "\n").getBytes());
                file.write(("cbSavePages=" + cbSavePages.isSelected() + "\n").getBytes());
                file.write(("cbGeneratePDF=" + cbGeneratePDF.isSelected() + "\n").getBytes());
                file.write(("cbSaveSettingsParameters=" + cbSaveSettingsParameters.isSelected() + "\n").getBytes());
                file.write(("cbFixPixelsInnerPages=" + cbFixPixelsInnerPages.isSelected() + "\n").getBytes());

                file.write(("tfFilesDestination=" + tfFilesDestination.getText() + "\n").getBytes());
                file.write(("tfPositionX1=" + tfPositionX1.getText() + "\n").getBytes());
                file.write(("tfPositionY1=" + tfPositionY1.getText() + "\n").getBytes());
                file.write(("tfPositionX2=" + tfPositionX2.getText() + "\n").getBytes());
                file.write(("tfPositionY2=" + tfPositionY2.getText() + "\n").getBytes());

                file.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_eventWindowClosing

    private void btPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPreviewActionPerformed
        try {

            Thread.sleep(Integer.parseInt(tfTimeToFirstCapture.getText()));

            int capX = Integer.parseInt(tfPositionX1.getText());
            int capY = Integer.parseInt(tfPositionX1.getText());
            int capWidth = Integer.parseInt(tfPositionX2.getText()) - capX;
            int capHeigth = Integer.parseInt(tfPositionY2.getText()) - capY;

            robot.mouseMove((capX + capWidth) / 2, (capY + capHeigth) / 2);
            click(0);

            offset = -1;

            if (Integer.parseInt(tfNumCapturesInPage.getText()) > 1) {

                click(0);
                click(0);

                BufferedImage captureScreen[] = new BufferedImage[2];

                for (int i = 0; i < 2; i++) {

                    captureScreen[i] = robot.createScreenCapture(new Rectangle(screenResolutionX, screenResolutionY));
                    captureScreen[i] = captureScreen[i].getSubimage(capX, capY, capWidth, capHeigth);

                    int rolls = Integer.parseInt(tfNumTouchRoll.getText());
                    for (int j = 0; j < rolls; j++) {
                        key(cbRollPageKey.getSelectedIndex());
                    }

                    click(0);
                    click(0);

                    Thread.sleep(Integer.parseInt(tfTimeBetweenCaptures.getText()));
                }

                lbShowSecondaryImage.setIcon(new ImageIcon(captureScreen[0]));
                lbShowThirdImage.setIcon(new ImageIcon(captureScreen[1]));

                BufferedImage fullImage = imageUnion(captureScreen);
                lbShowImage.setIcon(new ImageIcon(fullImage));

                tbPanes.setSelectedIndex(0);
            } else {
                BufferedImage captureScreen = robot.createScreenCapture(new Rectangle(screenResolutionX, screenResolutionY));
                captureScreen = captureScreen.getSubimage(capX, capY, capWidth, capHeigth);
                lbShowImage.setIcon(new ImageIcon(captureScreen));
                tbPanes.setSelectedIndex(0);
            }
            playSound("beep.wav");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btPreviewActionPerformed

    private void miSetInitialSuggestedValuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSetInitialSuggestedValuesActionPerformed
        tfTimeBetweenCaptures.setText("300");
        tfNumBookPages.setText("30");
        tfNumCapturesInPage.setText("2");
        tfTimeToFirstCapture.setText("5000");
        cbTryReconstructPages.setSelected(true);

        cbNextPageKey.setSelectedIndex(34);
        tfNumTouchPage.setText("1");
        cbRollPageKey.setSelectedIndex(35);
        tfNumTouchRoll.setText("1");
        tfPixelsInnerPages.setText("100");

        cbSaveImagesBlock.setSelected(false);
        cbSavePages.setSelected(false);
        cbGeneratePDF.setSelected(true);
        cbSaveSettingsParameters.setSelected(true);
        cbFixPixelsInnerPages.setSelected(false);

        tfFilesDestination.setText("/temp/files");
        tfPositionX1.setText("0");
        tfPositionY1.setText("0");
        tfPositionX2.setText("1920");
        tfPositionY2.setText("1080");
    }//GEN-LAST:event_miSetInitialSuggestedValuesActionPerformed

    private void process() {
        try {
            Thread.sleep(5000);

            images = new BufferedImage[Integer.parseInt(tfNumCapturesInPage.getText())];
            int capX = Integer.parseInt(tfPositionX1.getText());
            int capY = Integer.parseInt(tfPositionX1.getText());
            int capWidth = Integer.parseInt(tfPositionX2.getText()) - capX;
            int capHeigth = Integer.parseInt(tfPositionY2.getText()) - capY;


            robot.mouseMove((capX + capWidth) / 2, (capY + capHeigth) / 2);

            offset = -1;
            int page = 0;
            while (page < 5) {

                for (int j = 0; j < Integer.parseInt(tfNumCapturesInPage.getText()); j++) {
                    click(0);
                    click(0);
                    BufferedImage captureScreen = robot.createScreenCapture(new Rectangle(screenResolutionX, screenResolutionY));
                    images[j] = captureScreen.getSubimage(capX, capY, capWidth, capHeigth);
                    key(cbRollPageKey.getSelectedIndex());
                    Thread.sleep(100);
                }

                BufferedImage fullImage = imageUnion(images);
                ImageIO.write(fullImage, "png", new File(tfFilesDestination.getText() + "_" + capHeigth + "_" + page + ".png"));

                page++;
                click(0);
                key(cbNextPageKey.getSelectedIndex());

                Thread.sleep(Integer.parseInt(tfTimeBetweenCaptures.getText()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void click(int button) {
        robot.mousePress(button);
        robot.mouseRelease(button);
    }

    private void key(int keyTouch) {
        robot.keyPress(keyTouch);
        robot.keyRelease(keyTouch);
    }

    private boolean compareImages(BufferedImage img1, BufferedImage img2) {

        boolean resp = true;
        int x = 0;
        while (x < img1.getWidth() && resp) {
            int y = 0;
            while (y < img1.getHeight()) {
                if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
                    resp = false;
                    break;
                }
                y++;
            }
            x++;
        }
        return resp;
    }

    public void setValuePositions(boolean quad1) {
        if (quad1) {
            tfPositionX1.setText("" + positionX);
            tfPositionY1.setText("" + positionY);
        } else {
            tfPositionX2.setText("" + positionX);
            tfPositionY2.setText("" + positionY);
        }
    }

    private BufferedImage imageUnion(BufferedImage images[]) {
        int capX = Integer.parseInt(tfPositionX1.getText());
        int capY = Integer.parseInt(tfPositionX1.getText());
        int capWidth = Integer.parseInt(tfPositionX2.getText()) - capX;
        int capHeigth = Integer.parseInt(tfPositionY2.getText()) - capY;
        int pixelsInnerPages = Integer.parseInt(tfPixelsInnerPages.getText());
        BufferedImage fullImage = new BufferedImage(capWidth, capHeigth * images.length, BufferedImage.TYPE_INT_ARGB);
        if (images.length > 1) {

            if (offset == -1) {
                BufferedImage subEndInitialPage = images[0].getSubimage(0, capHeigth - pixelsInnerPages, capWidth, pixelsInnerPages);
                offset = 0;
                boolean findit = false;
                while (offset < capHeigth - pixelsInnerPages && !findit) {
                    BufferedImage subBegingNextPage = images[1].getSubimage(0, offset, capWidth, pixelsInnerPages);
                    if (compareImages(subEndInitialPage, subBegingNextPage)) {
                        findit = true;
                    } else {
                        offset++;
                    }
                }
            }

            for (int i = 0; i < images.length; i++) {
                int posY = i * (capHeigth - offset - pixelsInnerPages);
                fullImage.getGraphics().drawImage(images[i], 0, posY, null);
            }

        } else if (images.length == 1) {
            fullImage = images[0];
        }
        return fullImage;
    }

    public void imageToPdf(byte[] imageFile, OutputStream outputStream) {

    }

    private void playSound(String fileName) {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(CaptureBookVideoReaderScreen.class.getResourceAsStream("./rsc/" + fileName));
            clip.open(inputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCapture;
    private javax.swing.JButton btFileDestination;
    private javax.swing.JButton btPreview;
    private javax.swing.JButton btTestLocations;
    private javax.swing.JCheckBox cbFixPixelsInnerPages;
    private javax.swing.JCheckBox cbGeneratePDF;
    private javax.swing.JComboBox<String> cbNextPageKey;
    private javax.swing.JComboBox<String> cbRollPageKey;
    private javax.swing.JCheckBox cbSaveImagesBlock;
    private javax.swing.JCheckBox cbSavePages;
    private javax.swing.JCheckBox cbSaveSettingsParameters;
    private javax.swing.JCheckBox cbTryReconstructPages;
    private javax.swing.JLabel lbFilesDestination;
    private javax.swing.JLabel lbNextePageKey;
    private javax.swing.JLabel lbNumBookPages;
    private javax.swing.JLabel lbNumCapturesInPage;
    private javax.swing.JLabel lbNumTouchPage;
    private javax.swing.JLabel lbNumTouchRoll;
    private javax.swing.JLabel lbPixelsInnerPages;
    private javax.swing.JLabel lbPositionX1;
    private javax.swing.JLabel lbPositionX2;
    private javax.swing.JLabel lbPositionY1;
    private javax.swing.JLabel lbPositionY2;
    private javax.swing.JLabel lbRollPageKey;
    private javax.swing.JLabel lbShowImage;
    private javax.swing.JLabel lbShowSecondaryImage;
    private javax.swing.JLabel lbShowThirdImage;
    private javax.swing.JLabel lbTimeBetweenCaptures;
    private javax.swing.JLabel lbTimeToFistCapture;
    private javax.swing.JMenuBar mbMainMenu;
    private javax.swing.JMenuItem miSetInitialSuggestedValues;
    private javax.swing.JMenu mmFiles;
    private javax.swing.JMenu mmUtil;
    private javax.swing.JPanel paButton;
    private javax.swing.JPanel paCapturesTop;
    private javax.swing.JPanel paFiles;
    private javax.swing.JPanel paFilesNames;
    private javax.swing.JPanel paFilesTop;
    private javax.swing.JPanel paKeys;
    private javax.swing.JPanel paKeysTop;
    private javax.swing.JPanel paLeft;
    private javax.swing.JPanel paNextPageKey;
    private javax.swing.JPanel paNumCapturesInPage;
    private javax.swing.JPanel paNumTouchPage;
    private javax.swing.JPanel paNumTouchRoll;
    private javax.swing.JPanel paNumberBookPages;
    private javax.swing.JPanel paPixelsInnerPages;
    private javax.swing.JPanel paPositions;
    private javax.swing.JPanel paPositionsX1;
    private javax.swing.JPanel paPositionsX2;
    private javax.swing.JPanel paPositionsY1;
    private javax.swing.JPanel paPositionsY2;
    private javax.swing.JPanel paRolPagekey;
    private javax.swing.JPanel paSave;
    private javax.swing.JPanel paTime;
    private javax.swing.JPanel paTimeToFirstCapture;
    private javax.swing.JProgressBar pbProgressBar;
    private javax.swing.JPanel pqCaptures;
    private javax.swing.JSplitPane spMain;
    private javax.swing.JScrollPane spShowImage;
    private javax.swing.JScrollPane spShowSecondaryImage;
    private javax.swing.JScrollPane spShowThirdImage;
    private javax.swing.JTabbedPane tbPanes;
    private javax.swing.JToolBar tbToolBar;
    private javax.swing.JTextField tfFilesDestination;
    private javax.swing.JFormattedTextField tfNumBookPages;
    private javax.swing.JFormattedTextField tfNumCapturesInPage;
    private javax.swing.JFormattedTextField tfNumTouchPage;
    private javax.swing.JFormattedTextField tfNumTouchRoll;
    private javax.swing.JFormattedTextField tfPixelsInnerPages;
    private javax.swing.JFormattedTextField tfPositionX1;
    private javax.swing.JFormattedTextField tfPositionX2;
    private javax.swing.JFormattedTextField tfPositionY1;
    private javax.swing.JFormattedTextField tfPositionY2;
    private javax.swing.JTextField tfStatusBar;
    private javax.swing.JTextField tfStatusInfo;
    private javax.swing.JFormattedTextField tfTimeBetweenCaptures;
    private javax.swing.JFormattedTextField tfTimeToFirstCapture;
    // End of variables declaration//GEN-END:variables
}
