/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.saladebatepapo;

import static br.edu.ifsc.saladebatepapo.CriptografiaRSA.PATH_CHAVE_PRIVADA;
import br.edu.ifsc.saladebatepapo.serverRSA.ClientChaves;
import br.edu.ifsc.saladebatepapo.serverRSA.ServidorDeChave;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author aluno
 */
public class BatePapo extends javax.swing.JFrame {

    /**
     * Creates new form BatePapo
     */
    ConectarThread conectar;
    DefaultListModel listModel;
    CriptografiaAES criptografia;
    Boolean conectou;
    ClientChaves clientRSA;
    byte[] chaveAES;
    ServidorDeChave file = new ServidorDeChave();
    String chaveDescripgrafada;

    //parte do cisual tela
    private UIManager.LookAndFeelInfo[] looks
            = UIManager.getInstalledLookAndFeels();
    private JRadioButton[] escolha = new JRadioButton[looks.length];
    private ButtonGroup grupoLooks = new ButtonGroup();

    public BatePapo() {
        initComponents();
        criptografia = new CriptografiaAES();
        clientRSA = new ClientChaves();
        conectou = false;
        getRootPane().setDefaultButton(jButtonEnviar);
        file.start();
        adicionaLookMenu();

    }

    public void adicionaLookMenu() {
        ItemSelecionado iselect = new ItemSelecionado();
        for (int i = 0; i < looks.length; i++) {
            escolha[i] = new JRadioButton(looks[i].getName());
            escolha[i].addItemListener(iselect);
            grupoLooks.add(escolha[i]);
            jMenuVisualizar.add(escolha[i]);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPorta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldGrupo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonEntrar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jComboBoxSkin = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldIP = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldMensagem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListBatePapo = new javax.swing.JList<String>();
        jButtonEnviar = new javax.swing.JButton();
        jMenuVisualizar = new javax.swing.JToolBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel2.setText("Porta");

        jTextFieldPorta.setText("6666");

        jLabel3.setText("Grupo");

        jTextFieldGrupo.setText("228.5.6.7");

        jLabel4.setText("IP Servidor chaves");

        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });

        jButtonSair.setText("Sair");
        jButtonSair.setEnabled(false);
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jComboBoxSkin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Padrão", "Dark", "Matrix" }));
        jComboBoxSkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSkinActionPerformed(evt);
            }
        });

        jLabel5.setText("Skin");

        jTextFieldIP.setText("localhost");
        jTextFieldIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxSkin, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldIP)
                            .addComponent(jTextFieldGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEntrar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSkin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEntrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jButtonSair)
                        .addComponent(jTextFieldIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextFieldMensagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldMensagemKeyPressed(evt);
            }
        });

        jListBatePapo.setFocusable(false);
        jScrollPane1.setViewportView(jListBatePapo);

        jButtonEnviar.setText("Enviar");
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEnviar))
                .addContainerGap())
        );

        jMenuVisualizar.setRollover(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jMenuVisualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jMenuVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed

        if (jTextFieldGrupo.getText().equals("")
                || jTextFieldNome.getText().equals("") || jTextFieldPorta.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else if (conectou) {
            System.out.println("conectou enviar: " + conectou);
            String nome = jTextFieldNome.getText();
            String texto = jTextFieldMensagem.getText();
            jTextFieldMensagem.setText("");
            jTextFieldMensagem.requestFocus();
            prepararMensagem(nome, texto);
        } else {
            JOptionPane.showMessageDialog(null, "Entre na sala primeiro!");
        }
    }//GEN-LAST:event_jButtonEnviarActionPerformed

    private void jTextFieldMensagemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMensagemKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jButtonEnviar.doClick();
//aqui vai o q voce deseja fazer quando o usuario clicar enter naquele jtextfield
        }
    }//GEN-LAST:event_jTextFieldMensagemKeyPressed

    private void jTextFieldIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIPActionPerformed

    private void jComboBoxSkinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSkinActionPerformed
        // TODO add your handling code here:
        if (jComboBoxSkin.getSelectedIndex() == 1) {
            Color corFundo = Color.BLACK;
            Color corFonte = Color.WHITE;
            jPanel1.setBackground(corFundo);
            jPanel2.setBackground(corFundo);
            jLabel1.setForeground(corFonte);
            jLabel2.setForeground(corFonte);
            jLabel3.setForeground(corFonte);
            jLabel4.setForeground(corFonte);
            jLabel5.setForeground(corFonte);
            jListBatePapo.setBackground(Color.DARK_GRAY);
            jListBatePapo.setForeground(Color.WHITE);

        } else if (jComboBoxSkin.getSelectedIndex() == 2) {
            Color corFundo = Color.darkGray;
            Color corFonte = Color.GREEN;
            jPanel1.setBackground(corFundo);
            jPanel2.setBackground(corFundo);
            jLabel1.setForeground(corFonte);
            jLabel2.setForeground(corFonte);
            jLabel3.setForeground(corFonte);
            jLabel4.setForeground(corFonte);
            jLabel5.setForeground(corFonte);
            jListBatePapo.setBackground(corFundo);
            jListBatePapo.setForeground(corFonte);
        } else if (jComboBoxSkin.getSelectedIndex() == 0) {
            Color corFundo = null;
            Color corFonte = Color.BLACK;
            jPanel1.setBackground(corFundo);
            jPanel2.setBackground(corFundo);
            jLabel1.setForeground(corFonte);
            jLabel2.setForeground(corFonte);
            jLabel3.setForeground(corFonte);
            jLabel4.setForeground(corFonte);
            jLabel5.setForeground(corFonte);
            jListBatePapo.setBackground(Color.WHITE);
            jListBatePapo.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jComboBoxSkinActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed

        if (conectou) {
            String nome = jTextFieldNome.getText();
            String texto = "Saiu da sala";
            prepararMensagem(nome, texto);
            conectar.parar();
            conectou = false;
            habilitaCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Entre na sala primeiro!");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        // TODO add your handling code here:
        if (jTextFieldGrupo.getText().equals("")
                || jTextFieldNome.getText().equals("") || jTextFieldPorta.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else if (Integer.parseInt(jTextFieldPorta.getText()) < 1 || Integer.parseInt(jTextFieldPorta.getText()) > 65535) {
            JOptionPane.showMessageDialog(null, "Porta deve ser entre 1 - 65535");
        } else {

            try {
                System.out.println("vai ir a chave");
                clientRSA.enviaChavePublica(jTextFieldIP.getText());
                System.out.println("Foi a chave");

                Thread.sleep(2000);

                System.out.println("aki antes de receber");
                clientRSA.receberArquivoCriptografado(jTextFieldIP.getText());

                System.out.println("depois de receber");
                chaveDescripgrafada = descriptografaRSA();
                System.out.println("Chave descriptografada: " + chaveDescripgrafada);

            } catch (IOException ex) {
                Logger.getLogger(BatePapo.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BatePapo.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(BatePapo.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            conectar = new ConectarThread(Integer.parseInt(jTextFieldPorta.getText()),
                    jTextFieldNome.getText(), this, jTextFieldGrupo.getText(), chaveDescripgrafada);
            System.out.println("Conectado");
            listModel = new DefaultListModel();
            jListBatePapo.setModel(listModel);
            conectar.start();

            conectou = true;
            System.out.println("conectou: " + conectou);
            String nome = jTextFieldNome.getText();
            String texto = "Entrou na sala";
            prepararMensagem(nome, texto);
            habilitaCampos();
        }

    }//GEN-LAST:event_jButtonEntrarActionPerformed

    public void inserirTexto(String texto) {
        listModel.addElement(texto);

    }

    public void criptografaRSA(String msgOriginal, String ArquivoChavePublica) throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream inputStream = null;

        // Criptografa a Mensagem usando a Chave Pública
        inputStream = new ObjectInputStream(new FileInputStream(ArquivoChavePublica));
        PublicKey chavePublica = (PublicKey) inputStream.readObject();
        chaveAES = CriptografiaRSA.criptografa(msgOriginal, chavePublica);
    }

    public String descriptografaRSA() throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream inputStreamChavePrivada = null;
        System.out.println("antes de ler os arquivos");
        inputStreamChavePrivada = new ObjectInputStream(new FileInputStream(PATH_CHAVE_PRIVADA));
        System.out.println("Leu os arquivos");
        PrivateKey chavePrivada = (PrivateKey) inputStreamChavePrivada.readObject();
        File sourceFile = new File("chaveConexaoCriptografada.key");
        byte[] criptografado = getBytes(sourceFile);
        String textoPuro = CriptografiaRSA.decriptografa(criptografado, chavePrivada);
        System.out.println("metodo de criptografar: " + textoPuro);
        return textoPuro;

    }

    public byte[] getBytes(File file) {
        int len = (int) file.length();
        byte[] sendBuf = new byte[len];
        FileInputStream inFile = null;
        try {
            inFile = new FileInputStream(file);
            inFile.read(sendBuf, 0, len);
        } catch (FileNotFoundException fnfex) {
        } catch (IOException ioex) {
        }
        return sendBuf;
    }

    public void prepararMensagem(String nome, String texto) {

        String mensagemOriginal;
        mensagemOriginal = nome + " Diz: " + texto;
        System.out.println("mensagem original" + mensagemOriginal + " Chave: " + chaveDescripgrafada);
        byte[] criptografado = null;
        try {
            criptografado = criptografia.criptografar(mensagemOriginal, chaveDescripgrafada);
            System.out.println("criptografado: " + Arrays.toString(criptografado));
            String descriptografado = criptografia.descriptografar(criptografado, chaveDescripgrafada);
            System.out.println("Descriptografado no try:" + descriptografado);

        } catch (Exception ex) {
            Logger.getLogger(BatePapo.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.out.println(
                    "pau no criptografar");
        }

        enviarMensagem(criptografado);
    }

    public void enviarMensagem(byte[] data) {
        conectar.enviarMensagem(data);

    }

    public void habilitaCampos() {

        jTextFieldGrupo.setEnabled(!jTextFieldGrupo.isEnabled());
        jTextFieldNome.setEnabled(!jTextFieldNome.isEnabled());
        jTextFieldPorta.setEnabled(!jTextFieldPorta.isEnabled());
        jTextFieldIP.setEnabled(!jTextFieldIP.isEnabled());
        jButtonEntrar.setEnabled(!jButtonEntrar.isEnabled());
        jButtonSair.setEnabled(!jButtonSair.isEnabled());
    }

    private class ItemSelecionado implements ItemListener {

        public void itemStateChanged(ItemEvent e) {
            for (int i = 0; i < escolha.length; i++) {
                if (escolha[i].isSelected()) {
                    atualiza(i);
                }
            }
        }
    }

    public void atualiza(int i) {
        try {
            UIManager.setLookAndFeel(looks[i].getClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            java.util.logging.Logger.getLogger(BatePapo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BatePapo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BatePapo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BatePapo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BatePapo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox<String> jComboBoxSkin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jListBatePapo;
    private javax.swing.JToolBar jMenuVisualizar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldGrupo;
    private javax.swing.JTextField jTextFieldIP;
    private javax.swing.JTextField jTextFieldMensagem;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPorta;
    // End of variables declaration//GEN-END:variables
}
