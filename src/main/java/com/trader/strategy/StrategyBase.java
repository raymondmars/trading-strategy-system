package com.trader.strategy;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.trader.annotations.Strategy;
import com.trader.common.ITradeUtility;
import com.trader.deal.IDealProvider;
import com.trader.quotation.IQuotationProvider;
import org.apache.commons.logging.LogFactory;


/**
 * Created by Raymond on 18/08/2017.
 */
public abstract class StrategyBase extends AbstractScheduledService {

    protected final static org.apache.commons.logging.Log log = LogFactory.getLog(StrategyBase.class);

    /**
     * 交易行情提供商
     */
    protected final IQuotationProvider quotationProvider;
    /**
     * 交易接口提供商
     */
    protected final IDealProvider dealProvider;

    /**
     * 交易辅助类
     */
    protected final ITradeUtility tradeUtility;

    //构造器注入
    public StrategyBase(IQuotationProvider quotationProvider, IDealProvider dealProvider, ITradeUtility utility) {
        super();
        this.quotationProvider = quotationProvider;
        this.dealProvider = dealProvider;
        this.tradeUtility = utility;

    }
    @Override
    protected void runOneIteration() throws Exception {
        if(this.tradeUtility.isTradeTime()) {
            this.execute();
        } else {
            log.error("当前不是交易时间...");
        }
    }

    @Override
    protected void startUp() {
        Strategy ste = this.getClass().getAnnotation(Strategy.class);
        log.info(String.format("Start => %s ...", ste == null? "none name" : ste.name()));
    }


    @Override
    protected void shutDown() {
        Strategy ste = this.getClass().getAnnotation(Strategy.class);
        log.info(String.format("Shutdown => %s ...", ste == null? "none name" : ste.name()));
    }

    //所有策略必须实现该方法
    protected abstract void execute();

}
