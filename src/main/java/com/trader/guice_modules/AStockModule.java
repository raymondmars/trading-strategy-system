package com.trader.guice_modules;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.trader.common.AStockTradeUtility;
import com.trader.common.ITradeUtility;
import com.trader.deal.GFDealProvider;
import com.trader.deal.IDealProvider;
import com.trader.quotation.IQuotationProvider;
import com.trader.quotation.SinaQuoProvider;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Raymond on 22/08/2017.
 */
public class AStockModule extends AbstractModule {
    @Override
    protected void configure() {
        /**
         * 将新浪行情绑定到行情接口
         */
        bind(IQuotationProvider.class).to(SinaQuoProvider.class);

        /**
         * 将广发交易实现绑定到交易接口
         */
        bind(IDealProvider.class).to(GFDealProvider.class);

        /**
         * 将A股公用类绑定到交易公用接口
         */
        bind(ITradeUtility.class).to(AStockTradeUtility.class);

        /**
         * 注入配置属性
         */
        Properties properties = new Properties();
        try {
            properties.load(Object.class.getResourceAsStream("/application.properties"));
            Names.bindProperties(binder(), properties);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
