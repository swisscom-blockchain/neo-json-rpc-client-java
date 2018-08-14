package com.github.swisscom_blockchain.neo.rpcclient;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

public class JsonRpcHttpClientUtil {

    private static final TrustManager[] TRUST_ALL_MANAGER = new TrustManager[]{new X509TrustManager() {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
        }
    }};

    public static JsonRpcHttpClient create(String nodeEndpoint) {
        try {
            return new JsonRpcHttpClient(new URL(nodeEndpoint));
        } catch (MalformedURLException ex) {
            throw new NeoRpcRuntimeException(ex);
        }
    }

    public static void addBasicAuth(JsonRpcHttpClient client, String user, String password) {
        try {
            String credential = user + ":" + password;
            String basicAuth = DatatypeConverter.printBase64Binary(credential.getBytes("UTF-8"));

            Map<String, String> headers = new HashMap<>();
            headers.put("Authorization", "Basic " + basicAuth);
            client.setHeaders(headers);
        } catch (UnsupportedEncodingException ex) {
            throw new NeoRpcRuntimeException(ex);
        }
    }

    public static void enableTrustAllCerts(JsonRpcHttpClient client) {
        client.setHostNameVerifier((x, y) -> true);
        client.setSslContext(trustAllSSLContext());
    }

    private static SSLContext trustAllSSLContext() {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, TRUST_ALL_MANAGER, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

            return sslContext;
        } catch (KeyManagementException | NoSuchAlgorithmException ex) {
            throw new NeoRpcRuntimeException(ex);
        }
    }
}
