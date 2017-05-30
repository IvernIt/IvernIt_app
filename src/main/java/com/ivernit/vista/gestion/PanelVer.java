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
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */
public class PanelVer extends JPanel {

    private enum Columnas {
        vegetal, estado, riego, luz, temperatura, tierra, total
    };
    private final DefaultTableModel tmVer;
    private final String[] columnNames = {Strings.VEGETAL,
        Strings.ESTADO,
        Strings.RIEGO,
        Strings.HORAS_LUZ,
        Strings.TEMPERATURA,
        Strings.TIPO_TIERRA};

    public PanelVer() {
        tmVer = new DefaultTableModel(null, columnNames);
        JTable tVer = new JTable(tmVer);
        JScrollPane spTabla = new JScrollPane(tVer);
        this.setLayout(new BorderLayout());
        this.add(spTabla, BorderLayout.CENTER);
    }

    void actualizarDatos(Invernadero inv) {
        int nCultivos = inv.getCultivo().size();
        Object[][] dataVector = new Object[nCultivos][Columnas.total.ordinal()];
        for (int i = 0; i < inv.getCultivo().size(); i++) {
            Cultivo cultivo = inv.getCultivo().get(i);
            Vegetal veg = cultivo.getUltimoVegetal();
            if (veg != null) {
                dataVector[i][Columnas.vegetal.ordinal()] = veg.getNombre();

                dataVector[i][Columnas.estado.ordinal()] = veg.getEstado().getNombre();
                dataVector[i][Columnas.riego.ordinal()] = veg.getParametro().getAgua() + Strings.UNIDAD_RIEGO;
                dataVector[i][Columnas.luz.ordinal()] = veg.getParametro().getHorasLuz();
                dataVector[i][Columnas.temperatura.ordinal()] = veg.getParametro().getTemperatura() + Strings.UNIDAD_TEMPERATURA;
                dataVector[i][Columnas.tierra.ordinal()] = veg.getParametro().getTipoTierra();
            }
        }
        tmVer.setDataVector(dataVector, columnNames);
    }

}
