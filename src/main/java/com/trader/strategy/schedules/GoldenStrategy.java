package com.trader.strategy.schedules;

import com.google.inject.Inject;
import com.trader.annotations.Strategy;
import com.trader.common.ITradeUtility;
import com.trader.deal.IDealProvider;
import com.trader.quotation.IQuotationProvider;
import com.trader.strategy.QuoteHelper;
import com.trader.strategy.StrategyBase;
import waditu.tushare.entity.QuoteData;

import javax.inject.Named;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * Created by Raymond on 18/08/2017.
 */
@Strategy(name = "Golden Strategy")
public class GoldenStrategy extends StrategyBase {

    @Inject
    @Named("strategy.golden.stock_code")
    String stockCode;

    @Inject
    public GoldenStrategy(IQuotationProvider quotationProvider, IDealProvider dealProvider, ITradeUtility utility) {
        super(quotationProvider, dealProvider, utility);
    }

    protected void execute() {
        System.out.println();
        System.out.format("正在执行黄金赚钱策略，我的主人 => %s \n", LocalDateTime.now().toString());
        //ask 卖价
        //bid 买价
        QuoteData data = this.quotationProvider.getRealtimeQuotes(stockCode);
        if(data != null) {
            System.out.println(String.format("涨幅：%.2f%%", QuoteHelper.getChange(data) * 100));
            System.out.println(String.format("买卖比例: %.2f", QuoteHelper.buySoldRatio(data)));
            System.out.println(String.format("%s %s %.3f %.3f %.3f", data.code, data.name, data.ask, data.bid, (data.ask - data.bid)));
            if(QuoteHelper.roundNumber(Math.abs(data.ask - data.bid), 3) > 0.01) {
                sendNotifyToMac(String.format("%s , %.3f , %.2f%%", data.name, data.price, QuoteHelper.getChange(data) * 100), String.format("买卖差价超过0.01, 当前为：%.3f", data.ask - data.bid));
            }
        } else {
            log.error("无法获取行情数据，请检查网络。。。");
        }
//        System.out.println(System.identityHashCode(this));
    }

    private void sendNotifyToMac(String title, String content) {
        String command = String.format("display notification \"%s\" with title \"%s\" sound name \"default\"", content, title);
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec(new String[] {"osascript","-e", command});
            //Runtime.getRuntime().exec(new String[] { "osascript", "-e", "display notification "This is a message" with title "Title" subtitle "Subtitle" sound name "Funk"" });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected Scheduler scheduler() {
        return Scheduler.newFixedRateSchedule(0, 10, TimeUnit.SECONDS);
    }

}
