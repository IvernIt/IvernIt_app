/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.services;

import javax.ws.rs.core.GenericType;

/**
 * Jersey REST client generated for REST resource:we [algorithm]<br>
 * USAGE:
 * <pre>
 *        CultivoIdeal client = new CultivoIdeal();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Pablo
 */
public class CultivoIdeal {

    private javax.ws.rs.client.WebTarget webTarget;
    private javax.ws.rs.client.Client client;
    private static final String BASE_URI = "http://sampru.sytes.net:8080/IvernIt_server-1.0/webresources/";

    public CultivoIdeal() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("algorithm");
    }

    /**
     * @param responseType Class representing the response
     * @param id query parameter
     * @param ec query parameter
     * @return response object (instance of responseType class)
     */
    public <T> T getXml(GenericType<T> responseType, String id, String ec) throws javax.ws.rs.ClientErrorException {
        String[] queryParamNames = new String[]{"id", "ec"};
        String[] queryParamValues = new String[]{id, ec};
        javax.ws.rs.core.Form form = getQueryOrFormParams(queryParamNames, queryParamValues);
        javax.ws.rs.core.MultivaluedMap<String, String> map = form.asMap();
        for (java.util.Map.Entry<String, java.util.List<String>> entry : map.entrySet()) {
            java.util.List<String> list = entry.getValue();
            String[] values = list.toArray(new String[list.size()]);
            webTarget = webTarget.queryParam(entry.getKey(), (Object[]) values);
        }
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }
    
    private javax.ws.rs.core.Form getQueryOrFormParams(String[] paramNames, String[] paramValues) {
        javax.ws.rs.core.Form form = new javax.ws.rs.core.Form();
        for (int i = 0; i < paramNames.length; i++) {
            if (paramValues[i] != null) {
                form = form.param(paramNames[i], paramValues[i]);
            }
        }
        return form;
    }

    public void close() {
        client.close();
    }

}
