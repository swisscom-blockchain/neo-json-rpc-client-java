package com.github.swisscom_blockchain.neo_rpcclient;

import com.github.swisscom_blockchain.neo_rpcclient.dto.NeoAccountState;
import com.github.swisscom_blockchain.neo_rpcclient.dto.NeoValidator;
import com.github.swisscom_blockchain.neo_rpcclient.dto.NeoVersion;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.github.swisscom_blockchain.neo_rpcclient.dto.NeoBlock;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<Object> params = new ArrayList<>();
        params.add(hash);
        params.add(1);
        return request("getblock", params, NeoBlock.class);
    }

    public NeoBlock getBestBlock() {
        String hash = getBestBlockHash();
        return getBlock(hash);
    }

    public List<NeoValidator> getValidators() {
        NeoValidator[] validators = request("getvalidators", createEmptyParams(), NeoValidator[].class);
        return Arrays.asList(validators);
    }

    public NeoVersion getVersion() {
        return request("getversion", createEmptyParams(), NeoVersion.class);
    }

    public String getDumpPrivKey(String address) {
        List<Object> params = new ArrayList<>();
        params.add(address);
        return request("dumpprivkey", params, String.class);

    }

    public NeoAccountState getAccountState(String address) {
        List<Object> params = new ArrayList<>();
        params.add(address);
        return request("getaccountstate", params, NeoAccountState.class);
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
