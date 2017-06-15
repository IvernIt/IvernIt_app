package com.ivernit.ice;

import Ice.Current;
import soporte._ClienteDisp;

public class Cliente extends _ClienteDisp{

  @Override
  /*
  * Espera Recivir un mensaje del asistente
  */
  public void recivirMensaje(String mensaje, Current __current) {
    System.out.println(mensaje);    
  }

}
