package com.ivernit.ice;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import Ice.ObjectPrx;
import com.ivernit.utils.Strings;
import com.ivernit.vista.mainFrame.MainFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import soporte.ClientePrx;
import soporte.ClientePrxHelper;
import soporte.ModeradorPrx;
import soporte.ModeradorPrxHelper;

public class ClienteIce extends Thread {

    Ice.Communicator comm = null;

    Scanner teclado;
    InputStream in;
    OutputStream out;

    //Cliente
    ModeradorPrx proxy;
    Cliente cliente;
    ClientePrx clientePrx;

    //Server
    Ice.ObjectAdapter adapter;
    Ice.Identity identity;
    private volatile boolean activo = true;
    private final JTextArea area;

    public ClienteIce(JTextArea area) {
        this.area = area;
        teclado = new Scanner(System.in);
        comm = Ice.Util.initialize();
        Ice.ObjectPrx base = comm.stringToProxy("Moderador:tcp -h 172.17.28.4 -p 5577");
        try {
            proxy = ModeradorPrxHelper.checkedCast(base);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        if (proxy == null) {
            JOptionPane.showConfirmDialog(MainFrame.get(),
                    Strings.ERROR_DE_CONCEXION,Strings.ERROR,
                    JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void run() {
        init();
        while (activo) {
            try {
                Thread.sleep(1000);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void init() {
        comm = Ice.Util.initialize();
        adapter = comm.createObjectAdapterWithEndpoints("Cliente", "tcp -h 172.17.18.108 -p 5589");
        cliente = new Cliente(area);
        Ice.Object object = cliente;
        identity = comm.stringToIdentity("Cliente");
        adapter.add(object, identity);
        adapter.activate();
        ObjectPrx obj = adapter.addWithUUID(cliente);
        clientePrx = ClientePrxHelper.checkedCast(obj);
        proxy.addCliente(clientePrx);
    }

    public void enviarMensaje(String msg) {
        proxy.responderOficinista(clientePrx, msg);
    }

    public void cerrar() {
        proxy.removeCliente(clientePrx);
        this.activo = false;
    }
}
