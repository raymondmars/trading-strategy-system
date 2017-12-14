package com.trader.quotation;

import waditu.tushare.entity.QuoteData;

/**
 * Created by Raymond on 19/08/2017.
 * 股票行情提供者
 */
public interface IQuotationProvider {
    QuoteData getRealtimeQuotes(String code);
}
