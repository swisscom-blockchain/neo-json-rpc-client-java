package com.github.swisscom_blockchain.neo_rpcclient;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;

public class TestBuilder {

    public static NeoClient createClient() {
        String endpoint = System.getenv("endpoint");
        String basicUser = System.getenv("basicUser");
        String basicPass = System.getenv("basicPass");

        JsonRpcHttpClient client = NeoClientUtil.create(endpoint);
        NeoClientUtil.addBasicAuth(client, basicUser, basicPass);
        NeoClientUtil.enableTrustAllCerts(client);

        return new NeoClient(client);
    }
}
