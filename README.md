#### 股票交易策略基础模型
##### 背景介绍
量化交易这几年在国内开始火了起来，国内很多券商，公募，私募也都有自己的量化交易团队；其中针对个人的量化研究平台（包括策略撰写和回归测试），目前国内比较有名的当属 [聚宽](https://www.joinquant.net/) 和 [优矿](https://uqer.io/home/) 了。不过他们的前端脚本语言大多是基于 Python 的。总感觉用 Python 来写交易策略，业务逻辑和算法的封装实现，特别到后期，其可扩展性不如 Java 那么好。所以才想用 Java 来实现一个基础的模型，以后可以在这个基础上做更多的事情。
##### 此模型包含四大模块
#####1，行情模块  (Quotation Provider)   
   提供股票行情，实现了一个简单的接口，方便以后扩展到实时行情或者延迟行情。  
   
#####2，交易接口模块  (Deal Provider)   
   提供股票的买卖交易，该接口继承自用户账户接口，因为交易模块一般和用户信息相关，以后扩展时可以接入真实的交易模块。 
	
#####3，交易策略模块  (Strategy)   
提供交易的核心算法策略，可以自己添加自己的交易策略，所有策略继承自一个策略基类，该基类继承自一个 ScheduledService 用来实现策略的定时任务，可以任意配置每个策略的运行间隔时间。
	
#####4，用户账户模块  (Account)  
提供交易用户的基本情况，包括资金状况，初始资产 等等，便于策略模块和交易模块随时对用户进行查询和统计，获取用户资产状况，以便进行下一步操作。  

##### 运行环境
JRE 1.8  

##### 如何 build 
这是一个基于 maven 的项目，构建时，直接运行命令：mvn package

##### 此模型默认依赖 tushare for Java 库 请按照以下步骤安装：
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

##### 其他说明
1，为了降低各个模块之间的直接依赖，使用了 [Google 的 guice](https://github.com/google/guice) 来进行实体创建和注入，没有使用 Spring 的原因是，Spring对于这种小项目来说过于庞大。   
3，为了给每个策略添加定时任务功能，引入了 [Google Core Libraries for Java](https://github.com/google/guava) ，使用了他的 AbstractScheduledService  
2，每个策略目前可以通过配置股票代码来注入到对应的策略实现，可以实现不用重新 build 即可更换股票代码，对不同的股票进行回归测试。
