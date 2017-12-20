#### 股票交易策略基础模型

##### 此模型包含四大模块
1，行情模块  (Quotation Provider)    
2，交易接口模块  (Deal Provider)   
3，交易策略模块  (Strategy)    
4，用户账户模块  (Account)    

#### 此模型默认依赖 tushare for Java 库 请按照以下步骤安装：
    1, To get source code from : https://github.com/RobotJiang/tushare-java.git
    2, Build it 
    3, Install to your local mvn repository use the below commands:
    
        mvn install:install-file -Dfile=~/xxx/tushare/target/tushare-1.0.0.jar \
             -DgroupId=org.waditu 
             -DartifactId=tushare 
             -Dversion=1.0.0 
             -Dpackaging=jar 
             -DlocalRepositoryPath=~/.m2/repository     
             
(该库主要是为了获取行情数据，如果不需要可以移除)
