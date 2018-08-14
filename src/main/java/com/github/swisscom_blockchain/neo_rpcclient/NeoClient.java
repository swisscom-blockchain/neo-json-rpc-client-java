package com.github.swisscom_blockchain.neo_rpcclient;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.github.swisscom_blockchain.neo_rpcclient.dto.NeoBlock;

import java.util.ArrayList;
import java.util.List;

public class NeoClient {

    private final JsonRpcHttpClient client;

    /**
     * Constructor requires a JSONRpcHttpClient. Initialize it by yourself.
     * Or have a look at "NeoClientUtil".
     *
     * @param client
     */
    public NeoClient(JsonRpcHttpClient client) {
        this.client = client;
    }

    public String getBestBlockHash() {
        return request("getbestblockhash", createEmptyParams(), String.class);
    }

    public Integer getConnectionCount() {
        return request("getconnectioncount", createEmptyParams(), Integer.class);
    }

    public NeoBlock getBlock(String hash) {
        List<Object> list = new ArrayList<>();
        list.add(hash);
        list.add(1);
        return request("getblock", list, NeoBlock.class);
    }

    public NeoBlock getBestBlock() {
        String hash = getBestBlockHash();
        return getBlock(hash);
    }

    private <T> T request(String method, Object data, Class<T> clazz) {
        try {
            return client.invoke(method, data, clazz);
        } catch (Throwable t) {
            throw new NeoRpcRuntimeException(t);
        }
    }

    private List<String> createEmptyParams() {
        List<String> params = new ArrayList<>();
        /*
        Hack: If it's an empty list the JsonRpcClient doesn't add '"params": []' to the JSON-RPC request.
        And the Neo node returns "code: -32600, Invalid Request"
         */
        params.add("");
        return params;
    }
}
