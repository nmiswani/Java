/* PBL3: 
   Component Based Development
   Developed by: Group A
*/

package medicalhealth;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class LadyCycleApp extends javax.swing.JFrame {
    
    private final List<LadyCycleRecord> recordList = new ArrayList<>();

    public LadyCycleApp() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtCycleLength = new javax.swing.JTextField();
        cmbSymptom = new javax.swing.JComboBox<>();
        txtPeriodLength = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblSymptom = new javax.swing.JLabel();
        lblStartDate = new javax.swing.JLabel();
        lblSymptomLogging = new javax.swing.JLabel();
        lblMood = new javax.swing.JLabel();
        lblPainLevel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblPeriodLength = new javax.swing.JLabel();
        btnDisplayRecord = new javax.swing.JButton();
        icon = new javax.swing.JLabel();
        cmbMood = new javax.swing.JComboBox<>();
        dateAppointment = new com.toedter.calendar.JDateChooser();
        lblPastRecord = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        btnAddRecord = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuSystemInfo = new javax.swing.JMenuItem();
        jMenuExit = new javax.swing.JMenuItem();

        jLabel2.setBackground(java.awt.Color.darkGray);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setPreferredSize(new java.awt.Dimension(1000, 1000));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lady Cycle App");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(234, 234, 234));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtCycleLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 180, 30));

        cmbSymptom.setEditable(true);
        cmbSymptom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select", "Light", "Medium", "Heavy" }));
        cmbSymptom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSymptomActionPerformed(evt);
            }
        });
        getContentPane().add(cmbSymptom, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 240, 30));
        getContentPane().add(txtPeriodLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 180, 30));

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName.setText("Cycle Length (days)");
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 150, 30));

        lblSymptom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSymptom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSymptom.setText("Menstrual Flow");
        getContentPane().add(lblSymptom, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 420, 40));

        lblStartDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblStartDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblStartDate.setText("Start Date");
        lblStartDate.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(lblStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 130, 30));

        lblSymptomLogging.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSymptomLogging.setForeground(new java.awt.Color(255, 255, 255));
        lblSymptomLogging.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSymptomLogging.setText("Symptom Logging");
        lblSymptomLogging.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblSymptomLogging, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 410, 40));

        lblMood.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMood.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMood.setText("Mood");
        getContentPane().add(lblMood, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 420, 40));

        lblPainLevel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPainLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPainLevel.setText("Pain Level");
        getContentPane().add(lblPainLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 420, 40));

        jTable1.setBackground(new java.awt.Color(235, 235, 235));
        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Start Date", "End Date", "Menstrual", "Pain", "Mood"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTable1.setFillsViewportHeight(true);
        jTable1.setFocusCycleRoot(true);
        jTable1.setMaximumSize(null);
        jTable1.setName(""); // NOI18N
        jTable1.setRowHeight(25);
        jTable1.setShowGrid(true);
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 480, 230));

        lblPeriodLength.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPeriodLength.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPeriodLength.setText("Period Length (days)");
        getContentPane().add(lblPeriodLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 150, 30));

        btnDisplayRecord.setBackground(new java.awt.Color(0, 0, 0));
        btnDisplayRecord.setForeground(new java.awt.Color(255, 255, 255));
        btnDisplayRecord.setText("Display Past Period");
        btnDisplayRecord.setBorder(null);
        btnDisplayRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDisplayRecordMouseEntered(evt);
            }
        });
        btnDisplayRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayRecordActionPerformed(evt);
            }
        });
        getContentPane().add(btnDisplayRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 520, 150, 40));

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medicalhealth/icon.jpg"))); // NOI18N
        icon.setAutoscrolls(true);
        icon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        icon.setOpaque(true);
        getContentPane().add(icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, 180));

        cmbMood.setEditable(true);
        cmbMood.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select", "Happy", "Sad", "Anxious", "Irritated" }));
        cmbMood.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbMood.setName(""); // NOI18N
        cmbMood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMoodActionPerformed(evt);
            }
        });
        getContentPane().add(cmbMood, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 240, 30));

        dateAppointment.setDateFormatString("dd-MM-yyyy");
        getContentPane().add(dateAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 180, 30));

        lblPastRecord.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPastRecord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPastRecord.setText("Past Period's History");
        getContentPane().add(lblPastRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 520, 40));

        jSlider1.setBackground(new java.awt.Color(255, 255, 255));
        jSlider1.setMajorTickSpacing(1);
        jSlider1.setMaximum(10);
        jSlider1.setMinimum(1);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        getContentPane().add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 250, 50));

        btnAddRecord.setBackground(new java.awt.Color(0, 0, 0));
        btnAddRecord.setForeground(new java.awt.Color(255, 255, 255));
        btnAddRecord.setBorder(null);
        btnAddRecord.setLabel("Submit & Calculate");
        btnAddRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddRecordMouseEntered(evt);
            }
        });
        btnAddRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRecordActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 520, 150, 40));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 210));

        jPanel2.setBackground(new java.awt.Color(255, 102, 153));
        jPanel2.setMaximumSize(null);
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 520, 600));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 410, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 410, 350));

        jMenu1.setText("Menu");

        jMenuSystemInfo.setText("System Info");
        jMenuSystemInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSystemInfoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSystemInfo);

        jMenuExit.setText("Exit");
        jMenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuExitActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuExit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // Button to insert a new patient record
    private void btnDisplayRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayRecordActionPerformed
        try {
            // Fetch all records from the database
            List<LadyCycleRecord> records = DatabaseHelper.fetchAllRecords();

            if (records.isEmpty()) {
                // Display a message if no records are found
                JOptionPane.showMessageDialog(this, "No records found in the database.", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Create a DefaultTableModel to hold the table data
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            // Clear the existing rows
            model.setRowCount(0);

            // Add records to the table
            for (LadyCycleRecord record : records) {
                // Prepare the data for the table row
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String historyId = String.valueOf(record.getId()); // Get History ID
                String startDate = (record.getStartDate() != null) ? sdf.format(record.getStartDate()) : "N/A";
                String endDate = (record.getEndDate() != null) ? sdf.format(record.getEndDate()) : "N/A";
                String menstrualFlow = record.getSymptom();
                String painLevel = record.getPainLevel() + "/10";
                String mood = record.getMood();

                // Add a new row to the table
                model.addRow(new Object[] { historyId, startDate, endDate, menstrualFlow, painLevel, mood });
            }
            // Apply center alignment
            applyCenterRenderer();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error retrieving records: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDisplayRecordActionPerformed

    public class CenterRenderer extends DefaultTableCellRenderer {
        public CenterRenderer() {
            setHorizontalAlignment(CENTER); // Align content to the center
        }
    }
    
    private void applyCenterRenderer() {
        // Get the table's column model
        for (int i = 0; i < jTable1.getColumnModel().getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(new CenterRenderer());
        }
    }
    
    private void cmbSymptomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSymptomActionPerformed
        String selectedSymptom = (String) cmbSymptom.getSelectedItem();
        if (!"Please Select".equals(selectedSymptom)) {
            System.out.println("Selected Symptom: " + selectedSymptom);
        }
    }//GEN-LAST:event_cmbSymptomActionPerformed

    private void cmbMoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMoodActionPerformed
        String selectedMood = (String) cmbMood.getSelectedItem();
        if (!"Please Select".equals(selectedMood)) {
            System.out.println("Selected Mood: " + selectedMood);
        }
    }//GEN-LAST:event_cmbMoodActionPerformed

    // Menu option to show system information
    private void jMenuSystemInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSystemInfoActionPerformed
        JOptionPane.showMessageDialog(this, 
        "Lady Cycle is a Period Tracker App designed to " + 
        "make tracking menstrual cycles simple.",
        "Info", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuSystemInfoActionPerformed

    // Menu option to exit the application
    private void jMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExitActionPerformed
        int confirmExit = JOptionPane.showConfirmDialog(this, 
        "Are you sure you want to exit?", 
        "Exit Confirmation", 
        JOptionPane.YES_NO_OPTION);

        if (confirmExit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuExitActionPerformed

    private void btnDisplayRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDisplayRecordMouseEntered
        btnDisplayRecord.setToolTipText("Click to display all recorded cycle details.");
    }//GEN-LAST:event_btnDisplayRecordMouseEntered

    private void btnAddRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddRecordMouseEntered
        btnAddRecord.setToolTipText("Click to calculate and save the next period record.");
    }//GEN-LAST:event_btnAddRecordMouseEntered

    private void btnAddRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRecordActionPerformed
        // Get the selected date from the dateAppointment field (JDatePicker)
        Date selectedDate = dateAppointment.getDate();
        if (selectedDate == null) {
            JOptionPane.showMessageDialog(this, "Please select a start date.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convert the Date object to a formatted string (dd/MM/yyyy)
        SimpleDateFormat sdfInput = new SimpleDateFormat("dd-MM-yyyy");
        String startDateStr = sdfInput.format(selectedDate);  // Convert Date to String in dd/MM/yyyy format

        String cycleLengthStr = txtCycleLength.getText();
        String periodLengthStr = txtPeriodLength.getText();
        String symptom = (String) cmbSymptom.getSelectedItem(); // Get the selected symptom from the dropdown
        String mood = (String) cmbMood.getSelectedItem(); // Get the selected mood from the dropdown
        String painLevelStr = Integer.toString(jSlider1.getValue()); // Get the pain level from the JSlider

        // Validate input fields
        if (startDateStr.isEmpty() || cycleLengthStr.isEmpty() || periodLengthStr.isEmpty() || symptom.equals("Please Select") || mood.equals("Please Select") || painLevelStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Parse the start date from dd/MM/yyyy format
            SimpleDateFormat sdfParse = new SimpleDateFormat("dd-MM-yyyy");
            Date startDate = sdfParse.parse(startDateStr);

            // Convert the start date to MySQL format (yyyy-MM-dd)
            SimpleDateFormat mysqlFormat = new SimpleDateFormat("yyyy-MM-dd");
            String startDateForDB = mysqlFormat.format(startDate);

            // Parse cycle and period lengths
            int cycleLength = Integer.parseInt(cycleLengthStr);
            int periodLength = Integer.parseInt(periodLengthStr);
            int painLevel = Integer.parseInt(painLevelStr);

            // Calculate the next period (next start date)
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.DAY_OF_MONTH, cycleLength);
            Date nextPeriod = calendar.getTime();

            // Construct the message
            String message = "Average Cycle Length: " + cycleLength + " days\n" +
                             "Predicted Next Period Date: " + sdfInput.format(nextPeriod);

            // Show message dialog
            JOptionPane.showMessageDialog(null, message, "Cycle Information", JOptionPane.INFORMATION_MESSAGE);
            
             // Add record to the history
            LadyCycleRecord record = new LadyCycleRecord(0, startDate, cycleLength, periodLength, symptom, mood, painLevel);
            Date endDate = record.getEndDate(); // Calculate the end date based on the start date and period length

            // Debugging log
            System.out.println("Record added with Start Date: " + sdfInput.format(startDate) + ", End Date: " + (endDate != null ? sdfInput.format(endDate) : "N/A"));

            recordList.add(record);

            // Save to the database
            DatabaseHelper.insertRecord(record); // Save the record to the database

            // Reset the form fields
            dateAppointment.setDate(null);
            txtCycleLength.setText("");
            txtPeriodLength.setText("");
            jSlider1.setValue(0); // Reset the pain level slider
            cmbSymptom.setSelectedIndex(0); // Reset symptom dropdown
            cmbMood.setSelectedIndex(0); // Reset mood dropdown
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Cycle length, period length, and pain level must be valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Invalid date format.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddRecordActionPerformed

    // Main method to start the application
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new LadyCycleApp().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRecord;
    private javax.swing.JButton btnDisplayRecord;
    private javax.swing.JComboBox<String> cmbMood;
    private javax.swing.JComboBox<String> cmbSymptom;
    private com.toedter.calendar.JDateChooser dateAppointment;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuExit;
    private javax.swing.JMenuItem jMenuSystemInfo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblMood;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPainLevel;
    private javax.swing.JLabel lblPastRecord;
    private javax.swing.JLabel lblPeriodLength;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblSymptom;
    private javax.swing.JLabel lblSymptomLogging;
    private javax.swing.JTextField txtCycleLength;
    private javax.swing.JTextField txtPeriodLength;
    // End of variables declaration//GEN-END:variables
}
