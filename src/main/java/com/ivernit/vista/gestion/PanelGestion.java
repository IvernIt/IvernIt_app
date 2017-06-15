package com.ivernit.vista.gestion;

import com.ivernit.modelo.Invernadero;
import com.ivernit.modelo.Usuario;
import com.ivernit.vista.auxiliarControls.EditToolbar;
import com.ivernit.utils.Strings;
import com.ivernit.vista.auxiliarControls.SingleColTableModel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * En este panel se muestran todas las opciones de gestión.
 *
 * @author Pablo
 */
public class PanelGestion extends JPanel implements ListSelectionListener {

    private int width;
    private int height;
    private JTable tInvernderos;
    private JTabbedPane tpGestion;
    private PanelModificar pModificar;
    private PanelVer pVer;
    private PanelResultados pResultado;
    private PanelControl pControl;
    private Usuario usuarioActivo;
    private boolean inicializando;

    public PanelGestion(int parentWidth, int parentHeight) {
        width = parentWidth;
        height = parentHeight;
        initComponents();
    }

    private void initComponents() {

        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.setLayout(new BorderLayout());
        this.add(panelLista(), BorderLayout.WEST);
        this.add(panelGestion(), BorderLayout.CENTER);
    }

    private Component panelLista() {
        JPanel pInvernaderos = new JPanel();
        pInvernaderos.setLayout(new BorderLayout());
        JScrollPane spLista = new JScrollPane();
        SingleColTableModel tmInvernderos = new SingleColTableModel();
        tmInvernderos.setHeader(Strings.INVERNADEROS);
        tInvernderos = new JTable(tmInvernderos);
        tInvernderos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tInvernderos.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tInvernderos.getSelectionModel().addListSelectionListener(this);
        tInvernderos.getTableHeader().setReorderingAllowed(false);
        spLista.setViewportView(tInvernderos);
        spLista.setPreferredSize(new Dimension(135, 0));
        pInvernaderos.add(spLista, BorderLayout.CENTER);
        pInvernaderos.add(new EditToolbar(tInvernderos), BorderLayout.PAGE_START);
        return pInvernaderos;
    }

    private Component panelGestion() {
        tpGestion = new JTabbedPane(JTabbedPane.TOP);
        pVer = new PanelVer();
        pModificar = new PanelModificar();
        pResultado = new PanelResultados();
        pControl = new PanelControl();
        tpGestion.add(Strings.VER, pVer);
        tpGestion.add(Strings.MODIFICAR, pModificar);
        tpGestion.add(Strings.RESULTADOS, pResultado);
        tpGestion.add(Strings.CONTROL_MANUAL, pControl);
        return tpGestion;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!this.inicializando) {
            if (!e.getValueIsAdjusting()) {
                actualizarDatos();
            }
        }
    }

    private void rellenarInvernaderos() {
        this.inicializando = true;
        SingleColTableModel modelo = (SingleColTableModel) tInvernderos.getModel();
        modelo.borrarDatos();
        if (usuarioActivo != null) {
            ArrayList<Invernadero> invernaderos = usuarioActivo.getInvernaderos();
            for (Invernadero invernadero : invernaderos) {
                modelo.addInv(invernadero);
            }
            try {
                tInvernderos.setRowSelectionInterval(0, 0);
            } catch (Exception e) {
            }
        }
        this.inicializando = false;
    }

    /**
     * Una vez iniciada la sesión, se cargará la información del usuario
     *
     * @param usuario usuario logeado
     * @param parentWidth ancho de la ventana principal
     * @param parentHeight alto de la ventana principal
     * @return
     */
    public PanelGestion init(Usuario usuario, int parentWidth, int parentHeight) {
        this.width = parentWidth;
        this.height = parentHeight;
        this.setBounds(0, 0, width, height);
        this.usuarioActivo = usuario;
        this.rellenarInvernaderos();
        this.tpGestion.setSelectedIndex(0);
        this.actualizarDatos();
        return this;
    }

    private void actualizarDatos() {
        SingleColTableModel modelo = (SingleColTableModel) tInvernderos.getModel();
        Invernadero selectedInv = modelo.getInv(tInvernderos.getSelectedRow());
        if (usuarioActivo != null) {
            pVer.actualizarDatos(selectedInv);
            pModificar.actualizarDatos(selectedInv);
            pResultado.actualizarDatos(selectedInv);
            pControl.actualizarDatos(selectedInv);
        }
    }
}
