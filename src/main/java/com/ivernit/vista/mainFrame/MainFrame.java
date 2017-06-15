package com.ivernit.vista.mainFrame;

import com.ivernit.modelo.Usuario;
import com.ivernit.vista.ayuda.PanelAyuda;
import com.ivernit.utils.Strings;
import com.ivernit.vista.gestion.PanelGestion;
import com.ivernit.vista.inicio.PanelLogin;
import com.ivernit.vista.inicio.PanelRegistro;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * ventana principal del programa
 *
 * @author Pablo
 */
public class MainFrame extends JFrame {

    private static MainFrame mainFrame = null;
    private final int xSize = 680;
    private final int ySize = 400;
    private final ImageIcon I_IVERNIT = new ImageIcon("icons/IvernitLogo.png");
    private final MainMenuBar menu;
    private final PanelLogin pLogin;
    private final PanelGestion pGestion;
    private final PanelRegistro pRegistro;

    public MainFrame() {
        mainFrame = this;
        pLogin = new PanelLogin(0, 0);
        pRegistro = new PanelRegistro(0, 0);
        pGestion = new PanelGestion(0, 0);
        menu = new MainMenuBar();
        init();
    }

    /**
     * Obtiene la instancia activa de la ventana principal
     *
     * @return ventana activa
     */
    public static MainFrame get() {
        return mainFrame;
    }

    private void init() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double screenW = screenSize.getWidth();
        double screenH = screenSize.getHeight();
        Container contentPane;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation((int) (screenW / 2 - xSize / 2), ((int) (screenH / 2 - ySize / 2)));
        this.setPreferredSize(new Dimension(xSize, ySize));
        this.setResizable(false);
        this.setTitle(Strings.TITULO);
        this.setIconImage(I_IVERNIT.getImage());

        menu.inicioSesion();
        this.setJMenuBar(menu);
        this.pack();
        contentPane = this.getContentPane();
        contentPane.setLayout(null);
        contentPane.add(pLogin.init(contentPane.getWidth(), contentPane.getHeight()));
        this.pack();
        this.setVisible(true);
    }

    /**
     * Muestra panel de registro
     */
    public void mostrarRegistro() {
        Container contentPane = this.getContentPane();
        contentPane.removeAll();
        contentPane.add(pRegistro.init(contentPane.getWidth(), contentPane.getHeight()));
        contentPane.repaint();
    }

    /**
     * Muestra panel de gestión
     */
    public void mostrarGestion() {
        Usuario usuario = pLogin.getUsuario();
        Container contentPane = this.getContentPane();
        contentPane.removeAll();
        contentPane.add(pGestion.init(usuario, contentPane.getWidth(), contentPane.getHeight()));
        menu.sesionIniciada();
        this.revalidate();
        this.repaint();
    }

    /**
     * Muestra panel de ayuda
     */
    public void mostrarAyuda() {
        Container contentPane = this.getContentPane();
        contentPane.removeAll();
        contentPane.add(new PanelAyuda(contentPane.getWidth(), contentPane.getHeight()));
        contentPane.repaint();
    }

    /**
     * Muestra panel de Login
     */
    public void mostrarLogin() {
        Container contentPane = this.getContentPane();
        contentPane.removeAll();
        menu.inicioSesion();
        contentPane.add(pLogin.init(contentPane.getWidth(), contentPane.getHeight()));
        contentPane.repaint();
    }

    public boolean doLogin() {
        return pLogin.login();
    }

    public void resetLogin() {
        pLogin.contrasenaIncorrecta();
    }

}
