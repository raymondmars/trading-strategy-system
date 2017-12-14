package com.trader;

import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.ServiceManager;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.trader.guice_modules.AStockModule;
import com.trader.strategy.StrategyBase;
import com.trader.strategy.schedules.GoldenStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello Trader
 *
 */
public class App
{

    public static void main( String[] args ) throws InterruptedException {
        List<Service> services = new ArrayList<Service>();

        Injector injector = Guice.createInjector(new AStockModule());

        StrategyBase golden = injector.getInstance(GoldenStrategy.class);
        services.add(golden);

        ServiceManager manager = new ServiceManager(services);
        manager.startAsync();

    }
}
