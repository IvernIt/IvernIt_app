/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.cliente;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:we [parameters/agua/{num}]<br>
 * USAGE:
 * <pre>
 *        ClienteAgua client = new ClienteAgua();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author sampru
 */
public class ClienteAgua {

  private WebTarget webTarget;
  private Client client;
  private static final String BASE_URI = "http://localhost:8080/Control/webresources/";

  public ClienteAgua(String num) {
    client = javax.ws.rs.client.ClientBuilder.newClient();
    String resourcePath = java.text.MessageFormat.format("parameters/agua/{0}", new Object[]{num});
    webTarget = client.target(BASE_URI).path(resourcePath);
  }

  public void setResourcePath(String num) {
    String resourcePath = java.text.MessageFormat.format("parameters/agua/{0}", new Object[]{num});
    webTarget = client.target(BASE_URI).path(resourcePath);
  }

  /**
   * @param responseType Class representing the response
   * @return response object (instance of responseType class)
   */
  public <T> T putAgua(Class<T> responseType) throws ClientErrorException {
    return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
  }

  public void close() {
    client.close();
  }
  
}
