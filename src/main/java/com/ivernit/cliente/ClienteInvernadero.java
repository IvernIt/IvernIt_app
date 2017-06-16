/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.cliente;

/**
 * Jersey REST client generated for REST resource:we [parameters]<br>
 * USAGE:
 * <pre>
 *        ClienteInvernadero client = new ClienteInvernadero();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author sampru
 */
public class ClienteInvernadero {

  private javax.ws.rs.client.WebTarget webTarget;
  private javax.ws.rs.client.Client client;
  private static final String BASE_URI = "http://localhost:8080/Control/webresources/";

  public ClienteInvernadero() {
    client = javax.ws.rs.client.ClientBuilder.newClient();
    webTarget = client.target(BASE_URI).path("parameters");
  }

  /**
   * @param responseType Class representing the response
   * @return response object (instance of responseType class)
   */
  public <T> T getAll(Class<T> responseType) throws javax.ws.rs.ClientErrorException {
    return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
  }

  public void close() {
    client.close();
  }
  
}
