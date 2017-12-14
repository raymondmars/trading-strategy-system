package com.trader.account;

import com.trader.entities.AccountBalance;

/**
 * Created by Raymond on 20/08/2017.
 */
public interface IAccount {
    /**
     * 获取当前资金状况
     * @return
     */
    AccountBalance getBalance();

    /**
     * 获取初始资金
     * @return
     */
    Double getInitCapital();
}
