# Stock Trading Strategy System

# install tushare for Java
    1, To get source code from : https://github.com/RobotJiang/tushare-java.git
    2, Build it 
    3, Install to your local mvn repository use the below commands:
    
        mvn install:install-file -Dfile=~/xxx/tushare/target/tushare-1.0.0.jar \
             -DgroupId=org.waditu 
             -DartifactId=tushare 
             -Dversion=1.0.0 
             -Dpackaging=jar 
             -DlocalRepositoryPath=~/.m2/repository
