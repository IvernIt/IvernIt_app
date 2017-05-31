/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.gestion;

import com.ivernit.modelo.Cultivo;
import com.ivernit.modelo.Invernadero;
import com.ivernit.modelo.Parametros;
import com.ivernit.vista.auxiliarControls.NorthBorderPane;
import com.ivernit.vista.auxiliarControls.DisabledJTextField;
import com.ivernit.vista.auxiliarControls.EditToolbar;
import com.ivernit.utils.Strings;
import com.ivernit.vista.auxiliarControls.SingleColTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.Date;
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
public class PanelModificar extends JPanel implements ListSelectionListener {

    private String SEPARADOR_VEGETAL = " | ";

    private enum Columnas {
        riego, luz, temperatura, tierra, total
    };
    private final String[] columnasParametros = {
        Strings.RIEGO,
        Strings.HORAS_LUZ,
        Strings.TEMPERATURA,
        Strings.TIPO_TIERRA};

    private JTable tParametros;
    private JTable tVegetales;
    private JTable tEstados;
    private Invernadero invernaderoActivo;

    public PanelModificar() {
        this.setLayout(new BorderLayout());
        this.add(crearPanelListaVegetales(), BorderLayout.WEST);
        this.add(crearPanelSeleccion(), BorderLayout.CENTER);
    }

    private JPanel crearPanelListaVegetales() {
        JPanel pVegetales = new JPanel(new BorderLayout());
        JScrollPane spVegetales = new JScrollPane();
        SingleColTableModel tmVegetales = new SingleColTableModel();
        tmVegetales.setHeader(Strings.VEGETALES);
        tmVegetales.addElement("Tomates 02/012017");
        tmVegetales.addElement("Lechugas 02/012017");
        tmVegetales.addElement("Cebollas 02/012017");
        tVegetales = new JTable(tmVegetales);
        tVegetales.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        try {
            tVegetales.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
        }
        tVegetales.getSelectionModel().addListSelectionListener(this);
        spVegetales.setViewportView(tVegetales);
        spVegetales.setPreferredSize(new Dimension(135, 100000));
        pVegetales.add(spVegetales, BorderLayout.CENTER);
        pVegetales.add(new EditToolbar(tVegetales), BorderLayout.PAGE_START);
        return pVegetales;

    }

    private JPanel crearPanelSeleccion() {
        JPanel pSeleccion = new JPanel(new GridLayout(2, 1));
        pSeleccion.add(crearPanelElegirEstado());
        pSeleccion.add(crearPanelParametros());
        return pSeleccion;
    }

    private JPanel crearPanelElegirEstado() {
        JPanel pElegirFase = new JPanel(new BorderLayout());
        pElegirFase.add(crearPanelListaEstados(), BorderLayout.WEST);
        pElegirFase.add(crearPanelCultivoIdeal(), BorderLayout.CENTER);
        return pElegirFase;
    }

    private JPanel crearPanelListaEstados() {
        JPanel pEstados = new JPanel(new BorderLayout());
        JScrollPane spEstados = new JScrollPane();
        SingleColTableModel tmEstados = new SingleColTableModel();
        tmEstados.setHeader(Strings.ESTADOS);
        tmEstados.addElement("Germinacion");
        tmEstados.addElement("Ahijamiento");
        tmEstados.addElement("Gran crecimiento");
        tmEstados.addElement("Maduracion");
        tEstados = new JTable(tmEstados);
        tEstados.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        try {
            tEstados.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
        }
        tEstados.getSelectionModel().addListSelectionListener(this);
        spEstados.setViewportView(tEstados);
        spEstados.setPreferredSize(new Dimension(135, 0));
        pEstados.add(spEstados, BorderLayout.CENTER);
        return pEstados;
    }

    private JPanel crearPanelCultivoIdeal() {
        JPanel pIdeal = new JPanel(new GridLayout(4, 2));
        pIdeal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        JLabel lAgua = new JLabel(Strings.RIEGO);
        JLabel lLuz = new JLabel(Strings.HORAS_LUZ);
        JLabel lTemperatura = new JLabel(Strings.TEMPERATURA);
        JLabel lTipoTierra = new JLabel(Strings.TIPO_TIERRA);
        JTextField tfAgua = new DisabledJTextField("5");
        JTextField tfLuz = new DisabledJTextField("11");
        JTextField tfTemperatura = new DisabledJTextField("22ºC");
        JTextField tfTierra = new DisabledJTextField("Limosa");
        pIdeal.add(new NorthBorderPane(lAgua));
        pIdeal.add(new NorthBorderPane(tfAgua));
        pIdeal.add(new NorthBorderPane(lLuz));
        pIdeal.add(new NorthBorderPane(tfLuz));
        pIdeal.add(new NorthBorderPane(lTemperatura));
        pIdeal.add(new NorthBorderPane(tfTemperatura));
        pIdeal.add(new NorthBorderPane(lTipoTierra));
        pIdeal.add(new NorthBorderPane(tfTierra));

        return pIdeal;
    }

    private JPanel crearPanelParametros() {
        JPanel pParametros = new JPanel(new BorderLayout());
        JScrollPane spParametros = new JScrollPane();
        DefaultTableModel tmParametros = new DefaultTableModel(null, columnasParametros);
        tParametros = new JTable(tmParametros);
        tParametros.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tParametros.getSelectionModel().addListSelectionListener(this);
        spParametros.setViewportView(tParametros);
        pParametros.add(spParametros, BorderLayout.CENTER);
        return pParametros;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() instanceof ListSelectionModel) {
            ListSelectionModel source = (ListSelectionModel) e.getSource();
            if (source == tEstados.getSelectionModel()) {

            } else if (source == tVegetales.getSelectionModel()) {

            } else if (source == tParametros.getSelectionModel()) {

            }
        }
    }

    public void actualizarDatos(Invernadero inv) {
        invernaderoActivo = inv;
        actualizarVegetales();
        try {
            actualizarParametros();
        } catch (Exception ex) {
            Logger.getLogger(PanelModificar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void actualizarParametros() throws ParseException, Exception {
        SingleColTableModel modeloVegetales = (SingleColTableModel) tVegetales.getModel();
        DefaultTableModel modeloParametos = (DefaultTableModel) tParametros.getModel();
        String[] vegetalActivo = modeloVegetales.getElement(tVegetales.getSelectedRow()).split("(" + SEPARADOR_VEGETAL + ")");
        String nombreVegetal = vegetalActivo[0];
        Date fechaInicio = Date.valueOf(vegetalActivo[2]);
        Object[][] dataVector = new Object[invernaderoActivo.getParametros().size()][Columnas.total.ordinal()];
        modeloParametos.setRowCount(0);
        for (int i = 0; i< invernaderoActivo.getParametros().size();i++) {
            Parametros param  = invernaderoActivo.getParametros().get(i);
            if (param != null) {
                dataVector[i][Columnas.riego.ordinal()] = param.getAgua() + Strings.UNIDAD_RIEGO;
                dataVector[i][Columnas.luz.ordinal()] = param.getHorasLuz();
                dataVector[i][Columnas.temperatura.ordinal()] = param.getTemperatura() + Strings.UNIDAD_TEMPERATURA;
                dataVector[i][Columnas.tierra.ordinal()] = param.getTipoTierra();
            }
        }
//        for (Cultivo cult : invernaderoActivo.getCultivo()) {
//            if (cult.getVegetales().get(0).getNombre().equals(nombreVegetal)) {
//                if (cult.getFechaDeInicio().equals(fechaInicio)) {
//                    
//                }
//            }
//        }
        try {
            tVegetales.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
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

}
