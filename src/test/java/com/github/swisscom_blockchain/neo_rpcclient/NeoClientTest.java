package com.github.swisscom_blockchain.neo_rpcclient;

import com.github.swisscom_blockchain.neo_rpcclient.dto.NeoAccountState;
import com.github.swisscom_blockchain.neo_rpcclient.dto.NeoBlock;
import com.github.swisscom_blockchain.neo_rpcclient.dto.NeoValidator;
import com.github.swisscom_blockchain.neo_rpcclient.dto.NeoVersion;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;

public class NeoClientTest {

    private NeoClient neoClient = TestBuilder.createClient();

    @Test
    public void getBestBlockHash() {
        String hash = neoClient.getBestBlockHash();
        assertThat(hash, is(not(isEmptyString())));
    }

    @Test
    public void getConnectionCount() {
        Integer connections = neoClient.getConnectionCount();
        assertThat(connections, is(greaterThan(0)));
    }

    @Test
    public void getBlock() {
        NeoBlock block = neoClient.getBlock("0xccfe419f98438d716a93eaf26499386096825d60085481bea404eda396d1deed");

        assertThat(block.getIndex(), is(1698744L));
        assertThat(block.getHash(), is("0xccfe419f98438d716a93eaf26499386096825d60085481bea404eda396d1deed"));
        assertThat(block.getMerkleroot(), is("0x1f6d57d27ae5db6e3fd3a4650e49bf07aecc04341579e88e557b83e4fb4fad24"));
        assertThat(block.getTime(), is(is(1534147628L)));
    }

    @Test
    public void getBestBlock() {
        NeoBlock block = neoClient.getBestBlock();
        assertThat(block.getHash(), is(not(isEmptyString())));
    }

    @Test
    public void getValidators() {
        List<NeoValidator> validators = neoClient.getValidators();
        assertThat(validators.size(), is(greaterThan(10)));
    }

    @Test
    public void getVersion() {
        NeoVersion version = neoClient.getVersion();
        Assert.assertTrue(version.getUseragent().contains("NEO"));
    }

    @Test
    public void getaccountstate() {
        NeoAccountState state = neoClient.getAccountState("ATphdznMVmtdREtr3nWAq4C5H4A8ioV4Bd");
        assertThat(state.getBalances().size(), is(2));
    }
}