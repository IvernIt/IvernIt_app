/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.gestion;

import com.ivernit.modelo.Cultivo;
import com.ivernit.modelo.Invernadero;
import com.ivernit.modelo.Vegetal;
import com.ivernit.utils.Strings;
import com.ivernit.vista.auxiliarControls.SingleColTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */
public class PanelResultados extends JPanel implements ListSelectionListener {

    private enum Columnas {
        estado, riego, luz, temperatura, tierra, total
    };
    private JTable tVegetales;
    private JTextField tfResultado;
    private JTable tParametros;
    private Invernadero invernaderoActivo;
    private final String SEPARADOR_VEGETAL = " | ";
    String[] columnNames = {
        Strings.ESTADO,
        Strings.RIEGO,
        Strings.HORAS_LUZ,
        Strings.TEMPERATURA,
        Strings.TIPO_TIERRA};

    public PanelResultados() {
        this.setLayout(new BorderLayout());
        this.add(crearPanelListaVegetales(), BorderLayout.WEST);
        this.add(crearPanelResultados(), BorderLayout.CENTER);
    }

    private JPanel crearPanelListaVegetales() {
        JPanel pVegetales = new JPanel(new BorderLayout());
        JScrollPane spVegetales = new JScrollPane();
        SingleColTableModel tmVegetales = new SingleColTableModel();
        tmVegetales.setHeader(Strings.VEGETALES);
        tVegetales = new JTable(tmVegetales);
        tVegetales.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        try {
            tVegetales.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
        }
        tVegetales.getSelectionModel().addListSelectionListener(this);
        spVegetales.setViewportView(tVegetales);
        spVegetales.setPreferredSize(new Dimension(135, 0));
        pVegetales.add(spVegetales, BorderLayout.CENTER);
        return pVegetales;

    }

    private JPanel crearPanelResultados() {
        JPanel pSeleccion = new JPanel(new GridLayout(2, 1));
        pSeleccion.add(crearPanelParametros());
        pSeleccion.add(crearPanelNota());
        return pSeleccion;
    }

    private JPanel crearPanelNota() {
        JPanel pNota = new JPanel(new GridLayout(1, 2));
        pNota.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel lResultado = new JLabel(Strings.RESULTADO + " : ");
        lResultado.setFont(new Font(Font.SANS_SERIF, 0, 31));
        lResultado.setHorizontalAlignment(JLabel.RIGHT);
        tfResultado = new JTextField("A");
        tfResultado.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 72));
        tfResultado.setHorizontalAlignment(JTextField.CENTER);
        pNota.add(lResultado);
        pNota.add(tfResultado);
        return pNota;
    }

    private JPanel crearPanelParametros() {
        JPanel pParametros = new JPanel(new BorderLayout());
        JScrollPane spParametros = new JScrollPane();
        DefaultTableModel tmParametros = new DefaultTableModel(null, columnNames);
        tParametros = new JTable(tmParametros);
        try {
            tParametros.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
        }
        spParametros.setViewportView(tParametros);
        pParametros.add(spParametros, BorderLayout.CENTER);
        return pParametros;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    public void actualizarDatos(Invernadero inv) {
        this.invernaderoActivo = inv;
        this.actualizarVegetales();
        try {
            this.actializarParametros();
        } catch (ParseException ex) {
            Logger.getLogger(PanelResultados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarVegetales() {
        SingleColTableModel modelo = (SingleColTableModel) tVegetales.getModel();
        modelo.setRowCount(0);
        for (Cultivo cult : this.invernaderoActivo.getCultivo()) {
            modelo.addElement(cult.getVegetales().get(0).getNombre() + SEPARADOR_VEGETAL + cult.getFechaDeInicio());
        }
        try {
            tVegetales.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
        }
    }

    private void actializarParametros() throws ParseException {
        if (invernaderoActivo.getCultivo().size() > 0) {
            SingleColTableModel modeloVegetales = (SingleColTableModel) tVegetales.getModel();
            DefaultTableModel modeloParametos = (DefaultTableModel) tParametros.getModel();
            String[] vegetalActivo = modeloVegetales.getElement(tVegetales.getSelectedRow()).split("(" + SEPARADOR_VEGETAL + ")");
            String nombreVegetal = vegetalActivo[0];
            Date fechaInicio = Date.valueOf(vegetalActivo[2]);
            Object[][] dataVector = null;
            modeloParametos.setRowCount(0);
            for (Cultivo cult : invernaderoActivo.getCultivo()) {
                if (cult.getVegetales().get(0).getNombre().equals(nombreVegetal)) {
                    if (cult.getFechaDeInicio().equals(fechaInicio)) {
                        dataVector = new Object[cult.getVegetales().size()][Columnas.total.ordinal()];
                        for (int i = 0; i < cult.getVegetales().size(); i++) {
                            Vegetal veg = cult.getVegetales().get(i);
                            dataVector[i][Columnas.estado.ordinal()] = veg.getEstado().getNombre();
                            dataVector[i][Columnas.riego.ordinal()] = veg.getParametro().getAgua() + Strings.UNIDAD_RIEGO;
                            dataVector[i][Columnas.luz.ordinal()] = veg.getParametro().getHorasLuz();
                            dataVector[i][Columnas.temperatura.ordinal()] = veg.getParametro().getTemperatura() + Strings.UNIDAD_TEMPERATURA;
                            dataVector[i][Columnas.tierra.ordinal()] = veg.getParametro().getTipoTierra();
                        }
                        tfResultado.setText(cult.getResultado());
                        break;
                    }
                }
            }
            modeloParametos.setDataVector(dataVector, columnNames);
            try {
                tVegetales.setRowSelectionInterval(0, 0);
            } catch (Exception e) {
            }

        }
    }
}
