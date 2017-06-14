/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.gestion;

import com.ivernit.modelo.Cultivo;
import com.ivernit.modelo.Invernadero;
import com.ivernit.modelo.Parametros;
import com.ivernit.modelo.Resultados;
import com.ivernit.modelo.Usuario;
import com.ivernit.services.CultivoIdeal;
import com.ivernit.vista.auxiliarControls.NorthBorderPane;
import com.ivernit.vista.auxiliarControls.DisabledJTextField;
import com.ivernit.vista.auxiliarControls.EditToolbar;
import com.ivernit.utils.Strings;
import com.ivernit.vista.auxiliarControls.ImagePanel;
import com.ivernit.vista.auxiliarControls.SimpleTableRender;
import com.ivernit.vista.auxiliarControls.SingleColTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.Date;
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
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Pablo
 */
public class PanelModificar extends JPanel implements ListSelectionListener {

    private JPanel pIdeal;
    private final String IMAGEN_PREMIUM = "icons/premium.png";
    private CultivoIdeal cultivoIdeal;
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
    private final String SEPARADOR_VEGETAL = " | ";
    private SimpleTableRender rEstados;
    private SimpleTableRender rParametros;
    
    public PanelModificar() {
        cultivoIdeal = new CultivoIdeal();
        this.setLayout(new BorderLayout());
        this.add(crearPanelListaVegetales(), BorderLayout.WEST);
        this.add(crearPanelSeleccion(), BorderLayout.CENTER);
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
        rEstados = new SimpleTableRender();
        tmEstados.setHeader(Strings.ESTADOS);
        tmEstados.addElement(Strings.GERMINACION);
        tmEstados.addElement(Strings.AHIJAMIENTO);
        tmEstados.addElement(Strings.GRAN_CRECIMIENTO);
        tmEstados.addElement(Strings.MADURACION);
        tEstados = new JTable(tmEstados);
        tEstados.setDefaultRenderer(Object.class, rEstados);
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
        JPanel premiunPane = new ImagePanel(IMAGEN_PREMIUM);
        pIdeal = new JPanel(new GridLayout(4, 2));
        pIdeal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        JLabel lAgua = new JLabel(Strings.RIEGO);
        JLabel lLuz = new JLabel(Strings.HORAS_LUZ);
        JLabel lTemperatura = new JLabel(Strings.TEMPERATURA);
        JLabel lTipoTierra = new JLabel(Strings.TIPO_TIERRA);
        JTextField tfAguaIdeal = new DisabledJTextField("");
        JTextField tfLuzIdeal = new DisabledJTextField("");
        JTextField tfTemperaturaIdeal = new DisabledJTextField("");
        JTextField tfTierraIdeal = new DisabledJTextField("");
        pIdeal.add(new NorthBorderPane(lAgua));
        pIdeal.add(new NorthBorderPane(tfAguaIdeal));
        pIdeal.add(new NorthBorderPane(lLuz));
        pIdeal.add(new NorthBorderPane(tfLuzIdeal));
        pIdeal.add(new NorthBorderPane(lTemperatura));
        pIdeal.add(new NorthBorderPane(tfTemperaturaIdeal));
        pIdeal.add(new NorthBorderPane(lTipoTierra));
        pIdeal.add(new NorthBorderPane(tfTierraIdeal));
        pIdeal.setOpaque(true);
        premiunPane.add(pIdeal,BorderLayout.CENTER);        
        return premiunPane;
    }
    
    private JPanel crearPanelParametros() {
        JPanel pParametros = new JPanel(new BorderLayout());
        JScrollPane spParametros = new JScrollPane();
        rParametros = new SimpleTableRender();
        DefaultTableModel tmParametros = new DefaultTableModel(null, columnasParametros);
        tParametros = new JTable(tmParametros);
        tParametros.setDefaultRenderer(Object.class, rParametros);
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
        actualizarParametros();
        if (Usuario.getUsuarioActivo().isPremium()) {
            rellenarPanelIdea();
            pIdeal.setVisible(true);
        } else {
            pIdeal.setVisible(false);
        }
        
    }
    
    private void actualizarParametros() {
        Parametros parametroActivo = null;
        if (invernaderoActivo.getCultivo().size() > 0) {
            SingleColTableModel modeloVegetales = (SingleColTableModel) tVegetales.getModel();
            DefaultTableModel modeloParametos = (DefaultTableModel) tParametros.getModel();
            String[] vegetalActivo = modeloVegetales.getElement(tVegetales.getSelectedRow()).split("(" + SEPARADOR_VEGETAL + ")");
            String nombreVegetal = vegetalActivo[0];
            Date fechaInicio = Date.valueOf(vegetalActivo[2]);
            modeloParametos.setRowCount(0);
            for (Cultivo cult : invernaderoActivo.getCultivo()) {
                if (cult.getVegetales().get(0).getNombre().equals(nombreVegetal)) {
                    if (cult.getFechaDeInicio().equals(fechaInicio)) {
                        parametroActivo = cult.getUltimoVegetal().getParametros();
                        break;
                    }
                }
            }
            for (int i = 0; i < invernaderoActivo.getParametros().size(); i++) {
                Parametros param = invernaderoActivo.getParametros().get(i);
                Object[] dataVector = new Object[Columnas.total.ordinal()];
                if (parametroActivo != null && parametroActivo.getId() == param.getId()) {
                    rParametros.setActiva(i);
                }
                if (param != null) {
                    dataVector[Columnas.riego.ordinal()] = param.getAgua() + Strings.UNIDAD_RIEGO;
                    dataVector[Columnas.luz.ordinal()] = param.getHorasLuz();
                    dataVector[Columnas.temperatura.ordinal()] = param.getTemperatura() + Strings.UNIDAD_TEMPERATURA;
                    dataVector[Columnas.tierra.ordinal()] = param.getTipoTierra();
                }
                ((DefaultTableModel) tParametros.getModel()).insertRow(i, dataVector);
            }
            try {
                tParametros.setRowSelectionInterval(0, 0);
            } catch (Exception e) {
            }
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
    
    private void rellenarPanelIdea() {
        GenericType<Resultados> gType = new GenericType<Resultados>() {};
        Resultados rIdeal = (Resultados) cultivoIdeal.getXml(gType, "1","1");
        
    }
    
    
    
}
