/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lemas.form;

import java.awt.Dimension;

import static java.awt.Frame.MAXIMIZED_BOTH;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import lemas.model.Project;
import lemas.model.Workspace;
import lemas.util.CommonsFrame;
import lemas.util.Data;

/**
 *
 * @author vanderson
 */
@SuppressWarnings("all")
public class FrameMain extends javax.swing.JFrame {
    
    private static FrameMain instance = new FrameMain();
    
    /**
     * Creates new form FrameCronos
     */
    private FrameMain() {
        setExtendedState(MAXIMIZED_BOTH);  
        initComponents();  
        this.setExtendedState(FrameMain.MAXIMIZED_BOTH);
        windowDialog.setVisible(false);        
        windowDialog1.setVisible(false);
        windowDialog2.setVisible(false);
    }
    
    public static FrameMain getInstance(){
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jMenu1 = new javax.swing.JMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        panelMain = new javax.swing.JPanel();
        windowDialog = new javax.swing.JInternalFrame();
        windowDialog1 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        windowDialog2 = new javax.swing.JInternalFrame();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmenuAgents = new javax.swing.JMenu();
        mnNewProject = new javax.swing.JMenuItem();
        mnOpenProject = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnExit = new javax.swing.JMenuItem();

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

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setForeground(new java.awt.Color(255, 255, 255));

        windowDialog.setBackground(new java.awt.Color(255, 255, 255));
        windowDialog.setTitle("Janela");
        windowDialog.setNormalBounds(new java.awt.Rectangle(0, 0, 500, 500));
        windowDialog.setVisible(true);

        javax.swing.GroupLayout windowDialogLayout = new javax.swing.GroupLayout(windowDialog.getContentPane());
        windowDialog.getContentPane().setLayout(windowDialogLayout);
        windowDialogLayout.setHorizontalGroup(
            windowDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );
        windowDialogLayout.setVerticalGroup(
            windowDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        windowDialog1.setMaximizable(true);
        windowDialog1.setResizable(true);
        windowDialog1.setTitle("Console");
        windowDialog1.setNormalBounds(new java.awt.Rectangle(0, 0, 500, 500));
        windowDialog1.setVisible(true);

        txtLog.setColumns(20);
        txtLog.setFont(new java.awt.Font("Courier 10 Pitch", 0, 12)); // NOI18N
        txtLog.setRows(5);
        jScrollPane1.setViewportView(txtLog);

        javax.swing.GroupLayout windowDialog1Layout = new javax.swing.GroupLayout(windowDialog1.getContentPane());
        windowDialog1.getContentPane().setLayout(windowDialog1Layout);
        windowDialog1Layout.setHorizontalGroup(
            windowDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
        );
        windowDialog1Layout.setVerticalGroup(
            windowDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
        );

        windowDialog2.setBackground(new java.awt.Color(255, 255, 255));
        windowDialog2.setMaximizable(true);
        windowDialog2.setResizable(true);
        windowDialog2.setTitle("Result");
        windowDialog2.setNormalBounds(new java.awt.Rectangle(0, 0, 500, 500));
        windowDialog2.setVisible(true);

        javax.swing.GroupLayout windowDialog2Layout = new javax.swing.GroupLayout(windowDialog2.getContentPane());
        windowDialog2.getContentPane().setLayout(windowDialog2Layout);
        windowDialog2Layout.setHorizontalGroup(
            windowDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        windowDialog2Layout.setVerticalGroup(
            windowDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(windowDialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(windowDialog2)
                    .addComponent(windowDialog1)))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(windowDialog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addComponent(windowDialog2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(windowDialog1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(931, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(341, 341, 341))
        );
        jDesktopPane1.setLayer(panelMain, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jmenuAgents.setText("Project");

        mnNewProject.setText("New");
        mnNewProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnNewProjectActionPerformed(evt);
            }
        });
        jmenuAgents.add(mnNewProject);

        mnOpenProject.setText("Open");
        mnOpenProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnOpenProjectActionPerformed(evt);
            }
        });
        jmenuAgents.add(mnOpenProject);
        jmenuAgents.add(jSeparator3);

        mnExit.setText("Exit");
        mnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnExitActionPerformed(evt);
            }
        });
        jmenuAgents.add(mnExit);

        jMenuBar1.add(jmenuAgents);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(605, 605, 605))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnNewProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnNewProjectActionPerformed
        message("New project...");
        FrameProject frame = FrameProject.getInstance();
        
        this.windowDialog.setSize(new Dimension(600,600));
        
        CommonsFrame.loadFrame(windowDialog, frame);
        
        
        frame.load();        
        frame.clean();
        //frame.setVisible(true);        
    }//GEN-LAST:event_mnNewProjectActionPerformed

    private void mnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnExitActionPerformed
       System.exit(0);
    }//GEN-LAST:event_mnExitActionPerformed

    private void mnOpenProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnOpenProjectActionPerformed
        message("Open project...");
        FrameProject frame = FrameProject.getInstance();        
        frame.setTitle("Open project");
        FileNameExtensionFilter filterExt = new FileNameExtensionFilter("Project Lesma file (.lma)", "lma"); 
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(filterExt);
        fileChooser.setCurrentDirectory(new File(Workspace.FOLDER_PROJECT));
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();                 
            message("open file: " +  file.getAbsolutePath());                    
            Project project = Data.fileToProject(file);            
            project.setSaveIn(file.getAbsolutePath());
            frame.updateScreen(project);
        }        
        CommonsFrame.loadFrame(windowDialog, frame);
        //frame.setVisible(true);        
    }//GEN-LAST:event_mnOpenProjectActionPerformed

     private void log(String message) {
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenu jmenuAgents;
    private javax.swing.JMenuItem mnExit;
    private javax.swing.JMenuItem mnNewProject;
    private javax.swing.JMenuItem mnOpenProject;
    private javax.swing.JPanel panelMain;
    private javax.swing.JTextArea txtLog;
    private javax.swing.JInternalFrame windowDialog;
    private javax.swing.JInternalFrame windowDialog1;
    private javax.swing.JInternalFrame windowDialog2;
    // End of variables declaration//GEN-END:variables

    public void message(String message) {
        txtLog.append(message + "\n");        
        txtLog.getCaret().setDot(txtLog.getText().length());
    }

   
    
    public JInternalFrame getWindow(){
        return windowDialog;
    }
    
    public JInternalFrame getFrameResult(){
        return windowDialog2;
    }

	public void visibleWindows(boolean value) {
		windowDialog1.setVisible(value);
        windowDialog2.setVisible(value);
	}


}
