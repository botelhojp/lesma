/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lemas.form;

import java.awt.Dimension;
import java.awt.TextArea;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import lemas.Lemas;
import lemas.model.LemasLog;
import lemas.model.Project;
import lemas.model.Runner;
import lemas.model.Workspace;
import lemas.util.Data;

/**
 *
 * @author vanderson
 */
@SuppressWarnings("all")
public class FrameMain extends javax.swing.JFrame {

    private static FrameMain instance = new FrameMain();
    private static File arfffile;

    /**
     * Creates new form FrameCronos
     */
    private FrameMain() {        
        //setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        menu(false);
        //this.setExtendedState(FrameMain.MAXIMIZED_BOTH);
        JConsole.getInstance().setVisible(false);
        if (Lemas.file1 != null && Lemas.file2 != null) {
            arfffile = new File(Lemas.file1);
            FrameProject frame = FrameProject.getInstance();
            frame.setTitle("Open project");
            File file = new File(Lemas.file2);
            Project project = Data.fileToProject(file);
            project.setLoading(this.arfffile.getAbsolutePath());
            project.setSaveIn(file.getAbsolutePath());
            frame.updateScreen(project);
            frame.setTitle("Open Project - " + (new File(project.getLoading()).getName()));
            frame.setVisible(true);
        }
    }

    public static FrameMain getInstance() {
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jMenu1 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        menuOpenArff = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuNewProject = new javax.swing.JMenuItem();
        mnOpenProject = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuStop = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuExit = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Learning Environment for Systems Multi Agent");
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        jMenuFile.setText("Lemas");

        menuOpenArff.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menuOpenArff.setText("Open Arff");
        menuOpenArff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpenArffActionPerformed(evt);
            }
        });
        jMenuFile.add(menuOpenArff);
        jMenuFile.add(jSeparator1);

        menuNewProject.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuNewProject.setText("New Project");
        menuNewProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewProjectActionPerformed(evt);
            }
        });
        jMenuFile.add(menuNewProject);

        mnOpenProject.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mnOpenProject.setText("Open Project");
        mnOpenProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnOpenProjectActionPerformed(evt);
            }
        });
        jMenuFile.add(mnOpenProject);
        jMenuFile.add(jSeparator3);

        menuStop.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_0, java.awt.event.InputEvent.CTRL_MASK));
        menuStop.setText("Stop Container");
        menuStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuStopActionPerformed(evt);
            }
        });
        jMenuFile.add(menuStop);
        jMenuFile.add(jSeparator2);

        menuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        jMenuFile.add(menuExit);

        jMenuBar1.add(jMenuFile);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuOpenArffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpenArffActionPerformed

        message("Open Arff...");
        FileNameExtensionFilter filterExt = new FileNameExtensionFilter("Arff File (.arff)", "arff");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(filterExt);
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            arfffile = file;
            message("open file: " + arfffile.getAbsolutePath());
            menu(true);
        }
        Project prj = FrameProject.getInstance().getCurrentProject();
        if (prj != null) {
            prj.setLoading(arfffile.getAbsolutePath());
        }
    }//GEN-LAST:event_menuOpenArffActionPerformed

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
       System.out.println("formFocusLost");
    }//GEN-LAST:event_formFocusLost

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
         System.out.println("formFocusGained");
         if (!JConsole.getInstance().isVisible()){
            JConsole.getInstance().setVisible(true);
         }
    }//GEN-LAST:event_formFocusGained

    private void menuNewProjectActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mnNewProjectActionPerformed
        if (this.arfffile == null) {
            JOptionPane.showMessageDialog(new JFrame(), "Selecione um arquivo Arff", "Selecione um arquivo", JOptionPane.ERROR_MESSAGE);
        } else {
            message("New project...");
            FrameProject frame = FrameProject.getInstance();
//            frame.setBounds(0, 200, 400, 500);            
            frame.load();
            frame.clean();
            frame.setVisible(true);
        }
    }// GEN-LAST:event_mnNewProjectActionPerformed

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mnExitActionPerformed
        System.exit(0);
    }// GEN-LAST:event_mnExitActionPerformed

    private void mnOpenProjectActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mnOpenProjectActionPerformed
        message("Open project...");
        FrameProject frame = FrameProject.getInstance();        
        frame.setTitle("Open project");
        FileNameExtensionFilter filterExt = new FileNameExtensionFilter("Project Lesma file (.lma)", "lma");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(filterExt);
        fileChooser.setCurrentDirectory(new File(Workspace.FOLDER_PROJECT));
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            message("open file: " + file.getAbsolutePath());
            Project project = Data.fileToProject(file);
            if (this.arfffile != null) {
                project.setLoading(this.arfffile.getAbsolutePath());
            } else if (project.getLoading() == null) {
                menuOpenArffActionPerformed(null);
                project.setLoading(this.arfffile.getAbsolutePath());
            }
            project.setSaveIn(file.getAbsolutePath());
            frame.updateScreen(project);
            frame.setTitle("Open Project - " + (new File(project.getLoading()).getName()));
            frame.setVisible(true);
        }

        
//		}
        // frame.setVisible(true);
    }// GEN-LAST:event_mnOpenProjectActionPerformed

    private void menuStartActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuStartActionPerformed
        LemasLog.info("start");
        Runner.run();
    }// GEN-LAST:event_menuStartActionPerformed

    private void menuStopActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuStopActionPerformed
        LemasLog.info("stop");
        Runner.stop();
    }// GEN-LAST:event_menuStopActionPerformed

    private void log(String message) {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed"
        // desc=" Look and feel setting code (optional) ">
		/*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase
         * /tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenuItem menuNewProject;
    private javax.swing.JMenuItem menuOpenArff;
    private javax.swing.JMenuItem menuStop;
    private javax.swing.JMenuItem mnOpenProject;
    // End of variables declaration//GEN-END:variables

    private JTextArea log = JConsole.getInstance().getLog();

    public void message(String message) {
        if (FrameProject.getInstance().getVerLog()) {        	
            log.append(message);
            log.append("\n");
            log.getCaret().setDot(log.getText().length());
        }
    }

    public void clean() {
        log.setText("");
    }

    public void visibleWindows(boolean value) {
        JConsole.getInstance().setVisible(value);
        DialogResult.getInstance().setVisible(value);
    }

    private void menu(boolean value) {
//		this.menuNewProject.setEnabled(value);
//		this.mnOpenProject.setEnabled(value);
//		this.menuStop.setEnabled(value);
    }

    public static File getArfffile() {
        return arfffile;
    }

}
