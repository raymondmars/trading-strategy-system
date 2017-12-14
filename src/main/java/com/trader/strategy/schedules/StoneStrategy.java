package com.trader.strategy.schedules;

import com.google.inject.Inject;
import com.trader.annotations.Strategy;
import com.trader.common.ITradeUtility;
import com.trader.deal.IDealProvider;
import com.trader.quotation.IQuotationProvider;
import com.trader.strategy.StrategyBase;

import java.util.concurrent.TimeUnit;

/**
 * Created by Raymond on 18/08/2017.
 */
@Strategy(name = "Stone Strategy")
public class StoneStrategy extends StrategyBase {

    @Inject
    public StoneStrategy(IQuotationProvider quotationProvider, IDealProvider dealProvider, ITradeUtility utility) {
        super(quotationProvider, dealProvider, utility);
    }
    @Override
    protected void execute() {
        this.log.info("hello, task: stone ...");
    }

    @Override
    protected Scheduler scheduler() {
        return Scheduler.newFixedRateSchedule(0, 2, TimeUnit.SECONDS);
    }

}
