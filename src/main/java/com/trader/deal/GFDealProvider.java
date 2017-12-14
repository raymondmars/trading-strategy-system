package com.trader.deal;

import com.trader.entities.AccountBalance;

/**
 * Created by Raymond on 19/08/2017.
 * 广发证券交易接口
 */
public class GFDealProvider implements IDealProvider {
    @Override
    public Integer buy(String code, Double price, Integer quantity) {
        return null;
    }

    @Override
    public Integer sold(String code, Double price, Integer quantity) {
        return null;
    }

    @Override
    public Boolean checkTrade(Integer code) {
        return null;
    }

    @Override
    public AccountBalance getBalance() {
        return null;
    }

    @Override
    public Double getInitCapital() {
        return null;
    }

}
