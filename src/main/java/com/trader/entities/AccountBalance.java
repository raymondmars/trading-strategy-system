package com.trader.entities;

/**
 * Created by Raymond on 19/08/2017.
 * 账户资金状况
 */
public class AccountBalance {

    /**
     * 参考市值
     */
    private Double refMarketValue;
    /**
     * 可用资金
     */
    private Double availableFunds;
    /**
     * 币种
     */
    private Integer currency;
    /**
     * 总资产
     */
    private Double totalAssets;
    /**
     * 参考盈亏
     */
    private Double refProfitAndLoss;
    /**
     * 资金余额
     */
    private Double fundBalance;
    /**
     * 资金账号
     */
    private String fundAccount;

    public Double getRefMarketValue() {
        return refMarketValue;
    }

    public void setRefMarketValue(Double refMarketValue) {
        this.refMarketValue = refMarketValue;
    }

    public Double getAvailableFunds() {
        return availableFunds;
    }

    public void setAvailableFunds(Double availableFunds) {
        this.availableFunds = availableFunds;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public Double getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(Double totalAssets) {
        this.totalAssets = totalAssets;
    }

    public Double getRefProfitAndLoss() {
        return refProfitAndLoss;
    }

    public void setRefProfitAndLoss(Double refProfitAndLoss) {
        this.refProfitAndLoss = refProfitAndLoss;
    }

    public Double getFundBalance() {
        return fundBalance;
    }

    public void setFundBalance(Double fundBalance) {
        this.fundBalance = fundBalance;
    }

    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }
}
