package com.trader.strategy;

import waditu.tushare.entity.QuoteData;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;

/**
 * Created by Raymond on 20/08/2017.
 */
public class QuoteHelper {
    private final static DecimalFormat decimalFormat   = new DecimalFormat("######0.00");
    private final static String ASK_KEY = "ask";
    private final static String BID_KEY = "bid";

    /**
     * 价格涨幅
     * @param data
     * @return
     */
    public static Double getChange(QuoteData data) {
        Double change = (data.price - data.pre_close)/data.pre_close;
        return  roundNumber(change, 4);
    }

    /**
     * 卖买挂单量比
     * @param data
     * @return
     */
    public static Double soldBuyRatio(QuoteData data) {
        HashMap<String,Double> map = getAskBidTotalVol(data);
        Double ratio = map.get(ASK_KEY)/map.get(BID_KEY);
        return roundNumber(ratio, 2);
    }

    /**
     * 买卖挂单量比
     * @param data
     * @return
     */
    public static Double buySoldRatio(QuoteData data) {
        HashMap<String,Double> map = getAskBidTotalVol(data);
        Double ratio = map.get(BID_KEY)/map.get(ASK_KEY);
        return roundNumber(ratio, 2);
    }

    /**
     * 获取买卖挂单总量
     * @param data
     * @return
     */
    private static HashMap<String, Double> getAskBidTotalVol(QuoteData data) {
        HashMap<String, Double> map = new HashMap<>(2);
        map.put(ASK_KEY, data.a1_v + data.a2_v + data.a3_v + data.a4_v);
        map.put(BID_KEY, data.b1_v + data.b2_v + data.b3_v + data.b4_v);
        return map;
    }

    /**
     * 格式 double 类型，保留指定小数位
     * @param number
     * @param scale
     * @return
     */
    public static Double roundNumber(Double number, int scale) {
        return (new BigDecimal(number)).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
