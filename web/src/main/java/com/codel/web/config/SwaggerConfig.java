package com.codel.web.config;


import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2  //开启swagger
public class SwaggerConfig {
//    @Bean
//    public Docket docket2() {
//        return new Docket(DocumentationType.SWAGGER_2).groupName("codehello");
//    }
//
//    //配置Swagger的Docket的bean实例   也就是存放接口的容器
//    @Bean
//    public Docket docket(Environment environment) {
////        开启适合的环境
//        //设置要配置的Swagger环境
//        Profiles profiles = Profiles.of("dev", "test");
//        //通过environment.acceptsProfiles判断是否处在自己设定的环境中
//        boolean flag = environment.acceptsProfiles(profiles);
//
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//
//                .enable(flag)//配置是否启动swagger,默认为true
//
////                配置组名
//                .groupName("codeL")
//
//
//                //        配置Swagger自定义扫描接口
//                /*
//                 * apis():指定扫描的接口
//                 *  RequestHandlerSelectors:配置要扫描接口的方式
//                 *       basePackage:指定要扫描的包
//                 *       any:扫面全部
//                 *       none:不扫描
//                 *       withClassAnnotation:扫描类上的注解(参数是类上注解的class对象)
//                 *       withMethodAnnotation:扫描方法上的注解(参数是方法上的注解的class对象)
//                 */
//                .select().apis(RequestHandlerSelectors.basePackage("com.codel.web.controller"))
//                /*
//                 * paths():过滤路径
//                 *  PathSelectors:配置过滤的路径
//                 *      any:过滤全部路径
//                 *      none:不过滤路径
//                 *      ant:过滤指定路径:按照按照Spring的AntPathMatcher提供的match方法进行匹配
//                 *      regex:过滤指定路径:按照String的matches方法进行匹配
//                 */
//
////                .paths(PathSelectors.ant("/web/controller/*"))
////                所有的接口
//                .paths(PathSelectors.any())
//                .build();
//        //配置Swagger信息
//    }
//
//    //配置Swagger页面的基本信息
//    private ApiInfo apiInfo() {
//        return new ApiInfo(
//                "codeL",
//                "我的Swagger API文档",
//                "1.0",
//                "https://bareth.blog.csdn.net/",
//                new Contact("codeL", "https://blog.csdn.net/Lesliesuai", "3189144168@qq.com"),//作者信息
//                "Apache 2.0",
//                "http://www.apache.org/licenses/LICENSE-2.0",
//                new ArrayList<VendorExtension>());
//    }
}

