package com.trader.quotation;

import waditu.tushare.entity.QuoteData;
import waditu.tushare.stock.Trading;

/**
 * Created by Raymond on 19/08/2017.
 * 新浪行情数据
 */
public class SinaQuoProvider implements IQuotationProvider {
    public QuoteData getRealtimeQuotes(String code) {
        return Trading.getRealtimeQuotes(code);
    }
}
