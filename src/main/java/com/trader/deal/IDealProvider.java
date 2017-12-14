package com.trader.deal;

import com.trader.account.IAccount;

/**
 * Created by Raymond on 19/08/2017.
 * 交易接口提供商
 */
public interface IDealProvider extends IAccount {
    /**
     * 买入股票
     * @param code 股票代码
     * @param price 买入价格
     * @param quantity 买入数量
     * @return 交易编号
     */
    Integer buy(String code, Double price, Integer quantity);

    /**
     * 卖出股票
     * @param code  股票代码
     * @param price 卖出价格
     * @param quantity 卖出数量
     * @return 交易编号
     */
    Integer sold(String code, Double price, Integer quantity);

    /**
     * 检查交易是否成功
     * @param code 交易编号
     * @return 是否成功
     */
    Boolean checkTrade(Integer code);


}
