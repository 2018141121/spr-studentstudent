package com.codel.mybatis_plus.utils;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator01 {
    //用户名 可修改为自己
    private static String author = "codeL";

    public static void main(String[] args) {
        //修改成本地数据库地址 问号后面最好别动
        String url = "jdbc:mysql://localhost:3306/demo?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8";
        //数据库用户名和密码
        String name = "root";
        String password = "abcde";
        //需要生成的表名称  [数据库表]
        String tableName = "user";
        generate( url,name,password,tableName);
    }

    private static void generate(String url,String name,String password, String... tableNamesInclude){
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(author);//作者名称
        gc.setOpen(false);
        //gc.setSwagger2(true); //实体属性 Swagger2 注解
        gc.setFileOverride(false);   // 是否覆盖已有文件
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
//        gc.setEntityName("%sDO");

        gc.setDateType(DateType.ONLY_DATE); // 设置日期类型为Date
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(name);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.codel");
        //pc.setModuleName(moduleName); //自定义模块名
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(tableNamesInclude);
        //strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}
