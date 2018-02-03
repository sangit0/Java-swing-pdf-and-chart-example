
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sangit
 */
public class chartDemo extends javax.swing.JFrame {

    /**
     * Creates new form chartDemo
     */
    public chartDemo() {
        initComponents();
        pie();
        barChart();
        lineChart();
        tablePopulate();
    }
    void tablePopulate(){
        DefaultTableModel model= (DefaultTableModel) amountTBL.getModel();
        model.setRowCount(0); 
        
         model.addRow (new Object[]{"January","2121"});
         model.addRow (new Object[]{"Feb","1211"});
         model.addRow (new Object[]{"March","3443"});
         model.addRow (new Object[]{"April","2321"});
         model.addRow (new Object[]{"May","4341"});
         model.addRow (new Object[]{"June","2323"});
         model.addRow (new Object[]{"July","1212"});
         model.addRow (new Object[]{"August","1211"});

         
    }
    void pie(){
           DefaultPieDataset piedataset = new DefaultPieDataset();  
         
         
       piedataset.setValue("Accounts", new Integer(11));  
       piedataset.setValue("Human Resource", new Integer(22)); 
       piedataset.setValue("Commercial", new Integer(11));  
       piedataset.setValue("Production", new Integer(21));  
       piedataset.setValue("Marketing", new Integer(10));  
       
       
      JFreeChart piechart = ChartFactory.createPieChart3D(  
         "Pie Chart",   // Title  
         piedataset,  //dataset           
         true,    //legends              
         true,    //tools               
         false    //urls                
      );  
      
       PiePlot p=(PiePlot)piechart.getPlot();
      
       ChartPanel frame= new ChartPanel(piechart); 
       
     // piechart.getTitle().setPaint(Color.black);    // Set the colour of the title  
      //piechart.setBackgroundPaint(Color.WHITE);
      
      p.setBackgroundPaint(Color.white); 
     // p.
      
     //p.setRangeGridlinePaint(Color.blue); 
       // chart1.removeAll();
        chart1.add(frame,BorderLayout.CENTER);
        
       // chart1.validate();
    
        
    }
    void barChart(){
        int i=0;
           Random e= new Random();
           int []a=new int [100];
           for(int r=0;r<8;r++){
               a[r]=e.nextInt(30-10)+18;
           }
        DefaultCategoryDataset bardataset = new DefaultCategoryDataset();  
//      for(int j=0;j<c;j++){
       bardataset.setValue(a[0],Integer.toString(a[0]) ,"2015" );
       bardataset.setValue(a[1],Integer.toString(a[1]) ,"2014" );
       bardataset.setValue(a[2],Integer.toString(a[2]) ,"2013" );
       bardataset.setValue(a[3],Integer.toString(a[3]) ,"2012" );
       bardataset.setValue(a[4],Integer.toString(a[4]) ,"2011" );
       bardataset.setValue(a[5],Integer.toString(a[5]) ,"2010" ); 
       bardataset.setValue(a[6],Integer.toString(a[6]) ,"2009" );
       
        JFreeChart barchart = ChartFactory.createBarChart3D(  
        
         "Yearly data", //Title      
         "Year",            // X axis 
         "Number",              //y
         bardataset,             //dataset
         PlotOrientation.VERTICAL,  //Orientation     
         true,                //legends
         true,                //tools
         false               
      ); 
        
       barchart.getTitle().setPaint(Color.black);  
       barchart.setBackgroundPaint(Color.WHITE);
    
     
// Set the background colour of the chart  
     CategoryPlot cp = barchart.getCategoryPlot(); 
     
     cp.setBackgroundPaint(Color.white);       
     cp.setRangeGridlinePaint(Color.blue);      // Set the colour of the plot gridlines  
     
     
     ChartPanel frame= new ChartPanel(barchart); 

    

    ((BarRenderer)cp.getRenderer()).setBarPainter(new StandardBarPainter());

    BarRenderer r = (BarRenderer)barchart.getCategoryPlot().getRenderer();
    r.setSeriesPaint(0, Color.orange);
     
     
     chart2.add(frame,BorderLayout.CENTER);
    }
    void lineChart(){
         Random e= new Random();
           int []a=new int [100];
           for(int r=0;r<8;r++){
               a[r]=e.nextInt(30-10)+18;
           }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
        dataset.setValue(a[0],"Amount" ,"2015" );
        dataset.setValue(a[1],"Amount" ,"2014" );
        dataset.setValue(a[2],"Amount" ,"2013" );
        dataset.setValue(a[3],"Amount" ,"2012" );
        dataset.setValue(a[4],"Amount" ,"2011" );
        dataset.setValue(a[5],"Amount" ,"2010" ); 
        dataset.setValue(a[6],"Amount" ,"2009" );
     
       
      JFreeChart chart = ChartFactory.createLineChart(  
         "Line Chart",  // Title  
         
         "Year.",             // X-axis Label  
         "Amount",             //y 
         dataset,             
         PlotOrientation.VERTICAL,        
         false,                 
         true,                
         false                    
      ); 
        chart.getTitle().setPaint(Color.black);     
  chart.setBackgroundPaint(Color.WHITE);
    

     CategoryPlot cp = chart.getCategoryPlot(); 
     cp.setBackgroundPaint(Color.white);       
     cp.setRangeGridlinePaint(Color.blue);      
      ChartPanel frame= new ChartPanel(chart); 


       chart3.add(frame,BorderLayout.CENTER);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        chart2 = new javax.swing.JPanel();
        chart1 = new javax.swing.JPanel();
        chart3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        amountTBL = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chart2.setLayout(new java.awt.BorderLayout());

        chart1.setLayout(new java.awt.BorderLayout());

        chart3.setLayout(new java.awt.BorderLayout());

        amountTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Month", "Amount"
            }
        ));
        jScrollPane1.setViewportView(amountTBL);

        jButton1.setText("Create PDF and chart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(chart2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chart3, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chart2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(chart3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)))
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          DefaultTableModel model= (DefaultTableModel) amountTBL.getModel();
           String dataSet[][] = new String[8][2];
           
           for(int i=0;i<model.getRowCount();i++){
               for(int j=0;j<model.getColumnCount();j++){
                   dataSet[i][j]= (String) model.getValueAt(i, j);
                   //System.out.print(dataSet[i][j]);

                   
               }
           }
          // barChart(dataSet);
           
           JFreeChart jf= barChart(dataSet);

           chartToPDF(jf);
        
    }//GEN-LAST:event_jButton1ActionPerformed
 void chartToPDF(JFreeChart jf){
        
         Document doc = new Document();
        try {
           
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("Report.pdf"));
            
            doc.open();
            doc.add(new Paragraph("Report on Monthly sales",FontFactory.getFont(FontFactory.TIMES_BOLD, 20, 20, BaseColor.YELLOW)));
                                  
          doc.add(new Paragraph("\n\n"));

            //PDF table
            
              PdfPTable p = new PdfPTable(2);
             
//              PdfPCell cell= new PdfPCell(new Paragraph("Report on monthly sales"));
//              cell.setColspan(2);
//              cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//              cell.setBackgroundColor(BaseColor.ORANGE);
//
//              p.addCell(cell);
              
              p.addCell("Month");   
              p.addCell("Amount");           

             DefaultTableModel model= (DefaultTableModel) amountTBL.getModel();
           
            for(int i=0;i<model.getRowCount();i++){
               for(int j=0;j<model.getColumnCount();j++){
                 p.addCell((String) model.getValueAt(i, j));
                   //System.out.print(dataSet[i][j]);
                   
               }
            }
             
         
             doc.add(p);
             
             doc.add(new Paragraph("\n\n"));

             
           //add chart to PDF
           
          BufferedImage bufImg = jf.createBufferedImage(500, 300);
          Image chartIMG = Image.getInstance(writer, bufImg, 1.0f);           
           
           doc.add(chartIMG);
//           
           //close doc file
           
            doc.close();
            JOptionPane.showMessageDialog(null,"Report Saved");

        
        } catch (FileNotFoundException ex) {
        } catch (DocumentException ex) {
        } catch (IOException ex) {
        }
        
 }
    JFreeChart barChart(String dataset[][]){
        
        DefaultCategoryDataset bardataset = new DefaultCategoryDataset();  
//      for(int j=0;j<c;j++){
         for(int i=0;i<dataset.length;i++)
       bardataset.setValue(Integer.parseInt(dataset[i][1]),dataset[i][0] ,dataset[i][1] );
      
        
       JFreeChart barchart = ChartFactory.createBarChart3D(  
        
         "Monthly sales amount(In million BDT)",       //title
         "Month",    // x axis         
         "Amount",   // y axis           
         bardataset,             
         PlotOrientation.VERTICAL,      
         false,                
         true,                
         false               
      ); 
        
       barchart.getTitle().setPaint(Color.black);  
       barchart.setBackgroundPaint(Color.WHITE);
    
     
// Set the background colour of the chart  
     CategoryPlot cp = barchart.getCategoryPlot(); 
     cp.setBackgroundPaint(Color.white);       
     cp.setRangeGridlinePaint(Color.blue);      // Set the colour of the plot gridlines  
     ChartPanel frame= new ChartPanel(barchart); 

    

    //((BarRenderer)cp.getRenderer()).setBarPainter(new StandardBarPainter());

     BarRenderer r = (BarRenderer)barchart.getCategoryPlot().getRenderer();
     r.setSeriesPaint(0, Color.orange);
     
     
     chart2.removeAll();
     chart2.add(frame,BorderLayout.CENTER);
     chart2.validate();
     
     return barchart;
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
            java.util.logging.Logger.getLogger(chartDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chartDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chartDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chartDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chartDemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable amountTBL;
    private javax.swing.JPanel chart1;
    private javax.swing.JPanel chart2;
    private javax.swing.JPanel chart3;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
