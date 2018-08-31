package com.github.swisscom_blockchain.neo_rpcclient;

import com.github.swisscom_blockchain.neo_rpcclient.dto.NeoBlock;

/**
 * Tests which can be started manually from your IDE.
 */
public class ExplorativeTests {

    private NeoClient neoClient = TestBuilder.createClient();

    public void printAllValidators() {
        NeoBlock block = neoClient.getBestBlock();
        String previousHash = block.getPreviousblockhash();
        while(true) {
            block = neoClient.getBlock(previousHash);
            System.out.println("Block: " + block.getHash() + ", Validator: " + block.getNextconsensus());
            previousHash = block.getPreviousblockhash();
        }
    }

    public void dumpprivkey() {
        String privateKey = neoClient.getDumpPrivKey("<INSERT-YOUR-ADDRESS>");
        System.out.println(privateKey);
    }
}
