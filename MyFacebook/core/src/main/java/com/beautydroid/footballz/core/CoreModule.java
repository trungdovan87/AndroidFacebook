package com.beautydroid.footballz.core;

import com.beautydroid.footballz.core.api.IFootballData;
import com.beautydroid.footballz.core.api.impl.FootballData;
import com.google.inject.AbstractModule;

public class CoreModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(IFootballData.class).to(FootballData.class);
    }
}
