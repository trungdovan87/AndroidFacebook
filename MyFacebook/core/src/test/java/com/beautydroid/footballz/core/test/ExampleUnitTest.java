package com.beautydroid.footballz.core.test;

import com.beautydroid.footballz.core.CoreModule;
import com.beautydroid.footballz.core.api.IFootballData;
import com.beautydroid.footballz.core.api.impl.FootballData;
import com.beautydroid.footballz.core.api.msg.ErrorMsg;
import com.beautydroid.footballz.core.api.msg.SeasonMsg;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    private Injector mInjector;
    IFootballData client;

    @Before
    public void setUp() {
        mInjector = Guice.createInjector(Stage.DEVELOPMENT, new CoreModule());
        client = mInjector.getInstance(IFootballData.class);
    }

    @Test
    public void testSeason() {
        client.listSeason(2014, new FootballData.StubCallback<List<SeasonMsg>, ErrorMsg>() {
            @Override
            public void onSuccess(List<SeasonMsg> successMsg) {
                assertEquals(14, successMsg.size());
                //check item 1
                SeasonMsg seasonMsg = successMsg.get(0);
                assertEquals(18, seasonMsg.getNumberOfTeams());
                assertEquals(306, seasonMsg.getNumberOfGames());
                assertEquals("2014", seasonMsg.getYear());
            }
        });
    }

    @Test
    public void testErrorSeason() {
        client.listSeason(2000, new FootballData.StubCallback<List<SeasonMsg>, ErrorMsg>() {
            @Override
            public void onError(ErrorMsg errorMsg) {
                assertEquals(errorMsg.getError(), "The resource you are looking for is restricted");
            }

            @Override
            public void onSuccess(List<SeasonMsg> successMsg) {
                fail("on success");
            }

            @Override
            public void onException(Exception ex) {
                fail("on exception");
            }
        });
    }
}