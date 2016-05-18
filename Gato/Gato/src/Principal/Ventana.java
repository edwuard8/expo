/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 *
 * @author WILMER
 */
public class Ventana extends javax.swing.JFrame implements MouseListener {

    private JLabel[][] cuadros = new JLabel[3][3];
    private boolean[][] estados = new boolean[3][3];
    int x = 8, y = 8;
    ImageIcon aspa = new ImageIcon(getClass().getResource("/Iconos/aspa.png"));
    ImageIcon circulo = new ImageIcon(getClass().getResource("/Iconos/circulo.png"));
    ImageIcon defecto = new ImageIcon(getClass().getResource("/Iconos/default.png"));
    int turno = 0;
    int[] contador = new int[4];

    /**
     * Creates new form Otrto
     */
    public Ventana() {
        initComponents();
        this.setLocationRelativeTo(null);
        InsertarCuadros();
    }
    void InsertarCuadros() {
        //esto es para poder insertar los cuadros          
        jPanel2.setLayout(null);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //ASIGNAMOS UN LABEL A CADA PUNTO DE LA MATRIZ 
                cuadros[i][j] = new JLabel();
                //POSICIONAMOS EN LAS CELDAS DE LA VENTANA
                cuadros[i][j].setBounds(x, y, 130, 130);
                //AUMENTAMOS X YA QUE EL RECORRIDO ES HORIZONTAL
                x += 138;
                //PONEMOS LOS ICONOS POR DEFECTO A CADA CUADRO
                cuadros[i][j].setIcon(defecto);
                estados[i][j] = false;
                //AGREGAMOS AL PANEL LOS CUADROS
                jPanel2.add(this.cuadros[i][j]);
                //ESCUCHA EVENTO DEL MOUSE
                cuadros[i][j].addMouseListener(this);
            }
            //AUMENTAMOS Y PARA LAS SIGUIENTES FILAS
            y += 138;
            //REINICIAMOS EL VALOR DE X PARA LAS SIGUIENTES FILAS
            x = 8;
        }
    }

    //NUESTRO METODO DEBE RECIBIR COMO PARAMETRO QUE JUGADOR GANA
    //PARA ESTO PASAMOS EL TIPO DE ICONO ES EL QUE DEBE VERIFICAR
    void Ganador(ImageIcon tipo) {
        //RECORREMOS LOS CUADROS PARA VER SI EXISTE ALGUN GANADOR
        int k=2;
        //EMPIEZA EN 2 PORQUE TIENE QUE DECRECER 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cuadros[i][j].getIcon() == tipo) {
                    contador[0]++;
                }
                //SEGUNDA FORMA DE GANAR VERTICALES LOS i CAMBIAN
                if(cuadros[j][i].getIcon() == tipo){
                    contador[1]++;
                }
                if(cuadros[j][j].getIcon() == tipo){
                    contador[2]++;
                }
                
                if(cuadros[k][j].getIcon() == tipo){
                    contador[3]++;
                }
              
                k--;
            }
            //VERIFICAR SI EXISTE GANADOR EN HORIZONTAL
            if (contador[0] == 3) {
                PintarCuadro(cuadros[i][0]);
                PintarCuadro(cuadros[i][1]);
                PintarCuadro(cuadros[i][2]);
                TerminarJuego();
                 break;
            } else if (contador[1] == 3) {
                
                PintarCuadro(cuadros[0][i]);
                PintarCuadro(cuadros[1][i]);
                PintarCuadro(cuadros[2][i]);
                
                TerminarJuego();
                break;
            } else if (contador[2] == 3) {
                //PINTAMOS LOS CUADROS
                PintarCuadro(cuadros[0][0]);
                PintarCuadro(cuadros[1][1]);
                PintarCuadro(cuadros[2][2]);
                
                TerminarJuego();
                break;
            }else if (contador[3] == 3) {
                
                PintarCuadro(cuadros[0][2]);
                PintarCuadro(cuadros[1][1]);
                PintarCuadro(cuadros[2][0]);
                
                TerminarJuego();
                break;
            }else {
               
                contador[0]=0;
                contador[1]=0;
                contador[2]=0;
                contador[3]=0;
               
                k = 2;
            }
        }
    }

    void PintarCuadro(JLabel pintar) {
        pintar.setBorder(new LineBorder(Color.YELLOW));
    } 
 
    void TerminarJuego(){
        //RECORREMOS EL TABLERO
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //VERIFICAMOS LOS ESTADOS DE CADA CUADRO
                if(estados[i][j] == false){
                    cuadros[i][j].setVisible(false);
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/Iconos/icon.png")).getImage());
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setMinimumSize(new java.awt.Dimension(425, 425));
        jPanel2.setPreferredSize(new java.awt.Dimension(425, 425));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 0));
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 3, true));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 5, 400));

        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 3, true));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 10, 5, 400));

        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 3, true));
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 400, 5));

        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 3, true));
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 278, 400, 5));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //RECORREMOS LA MATRIZ PARA VER QUE LABEL RECIBIO EL CLICK
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //VERIFICAMOS
                if (e.getSource() == cuadros[i][j]) {
                    //VERIFICAMOS EL ESTADO DEL CUADRO
                    if (estados[i][j] == false) {
                        turno++;
                        //VERIFICAMOS SI ES PAR NO IMPAR
                        if (turno % 2 == 0) {
                            //CAMBIAMOS EL ICONO DEL CUADRO
                            cuadros[i][j].setIcon(circulo);
                        } else {
                            cuadros[i][j].setIcon(aspa);
                        }
                        estados[i][j] = true;      
                        if(cuadros[i][j].getIcon() == circulo){
                            Ganador(circulo);
                        }else{
                            Ganador(aspa);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
