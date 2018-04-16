#Spring MVC

本文档是在学习Spring Mvc官方文档的过程中的总结记录，方便后面消化回顾。文档的结构和官方文档尽量保持一致，主要记录的是Spring Mvc这个框架的特性以及怎么配置使用。

##1. Spring Mvc框架

###1.1 Spring Mvc框架简介
Spring Mvc框架是一个优秀的Web Mvc框架，这个框架和Spring无缝集成。（Spring Mvc支持Spring Web Flow，感兴趣的话可以自己了解下[SWf](http://projects.spring.io/spring-webflow/)的内容）.Spring Mvc框架有如下特性：

>- Clear separation of roles. Each role—controller, validator, command object, form object, model object, DispatcherServlet, handler mapping, view resolver, and so on—can be fulfilled by a specialized object（类职责分工明确）.
- Powerful and straightforward configuration of both framework and application classes as JavaBeans.This configuration capability includes easy referencing across contexts, such as from web controllers to business objects and validators.
- Adaptability, non-intrusiveness, and flexibility. Define any controller method signature you need,
possibly using one of the parameter annotations (such as @RequestParam, @RequestHeader,
@PathVariable, and more) for a given scenario.
- Reusable business code, no need for duplication. Use existing business objects as command or form
objects instead of mirroring them to extend a particular framework base class.
- Customizable binding and validation. Type mismatches as application-level validation errors that keep
the offending value, localized date and number binding, and so on instead of String-only form objects
with manual parsing and conversion to business objects.
- Customizable handler mapping and view resolution. Handler mapping and view resolution strategies
range from simple URL-based configuration, to sophisticated, purpose-built resolution strategies.
Spring is more flexible than web MVC frameworks that mandate a particular technique.
- Flexible model transfer. Model transfer with a name/value Map supports easy integration with any
view technology.
- Customizable locale, time zone and theme resolution, support for JSPs with or without Spring tag
library, support for JSTL, support for Velocity without the need for extra bridges, and so on.
- A simple yet powerful JSP tag library known as the Spring tag library that provides support for features
such as data binding and themes. The custom tags allow for maximum flexibility in terms of markup
code. For information on the tag library descriptor, see the appendix entitled Chapter 43, spring JSP
Tag Library
- A JSP form tag library, introduced in Spring 2.0, that makes writing forms in JSP pages much easier.
For information on the tag library descriptor, see the appendix entitled Chapter 44, spring-form JSP
Tag Library
- Beans whose lifecycle is scoped to the current HTTP request or HTTP Session. This is not a specific
feature of Spring MVC itself, but rather of the WebApplicationContext container(s) that Spring
MVC uses. These bean scopes are described in the section called “Request, session, global session,
application, and WebSocket scopes”

###1.2 DispatcherServlet介绍
整个Spring Mvc框架的核心是DispatcherServlet这个类。这个类的本质是Servlet，会在项目启动的时候被注册到Servlet容器（Tomcat等）中。DispatcherServlet这个类有个成员变量ApplicationContext，这个context又包含了rootcontext，所以它能很方便地拿到Spring IOC容器，使用Spring的各种功能。（经典的父子上下文配置。。。）   
图片-------------------------------图片-----------------------

DispatcherServlet有许多默认的配置，配置在DispatcherServlet.properties文件中
这个文件在org.springframework.web.servlet这个包下面。DispatcherServlet的相关类如下：

- HandlerMapping：帮助请求（request）找到合适的handler（用的最多的是HandlerMethod）；
- HandlerAdapter：用来执行HandlerMapping匹配到的handler;
- HandlerExceptionResolver:用来处理执行controller过程中抛出的异常。通常是返回一个异常处理视图；
- ViewResolver：将逻辑视图转换成View；
- LocaleResolver：
- ThemeResolver：
- MultipartResolver：
- FlashMapManager：

DispatcherServlet处理一个请求的流程：    
图片-------------------------------图片-----------------------

###1.3 Controller实现
要实现一个Controller，只需要用@Controller注解一个类就行了。Spring 3.1以后引入了RequestMappingHandlerMapping和RequestMappingHandlerAdapter等类来支持@Controller新特性。之前的Controller特性不建议使用了，虽然还被支持。

####@Controller and AOP Proxying
    <tx:annotation-driven proxytarget-class="true"/>

####URL模板功能
    
    @GetMapping(value = "/{pathValue}")
    @ResponseBody
    public String demoB( @PathVariable String pathValue,
                         @PathVariable Map<String,String> params ){
      logger.info("get path value:"+pathValue);
      return "l am demoaB...";
    }

重点类讲解:
RequestMappingHandlerAdapter在被Spring Mvc初始化的时候，会初始化它的成员变量HandlerMethodArgumentResolverComposite。这个类是HandlerMethodArgumentResolver的集合，HandlerMethodArgumentResolver的作用主要是处理用@RequestMapping注解的方法的参数的值。比如上面例子中的@PathVariable String pathValue（注意：RequestMappingHandlerAdapter这个类实现了InitializingBean这个接口，在RequestMappingHandlerAdapter的成员变量被初始化之后Spring会调用afterPropertiesSet()这个方法，这个方法中对HandlerMethodArgumentResolverComposite做了初始化）。

- RequestMappingHandlerAdapter
- HandlerMethodArgumentResolverComposite
- HandlerMethodArgumentResolver

URL正则功能   
  
- @RequestMapping("/spring-web/{symbolicName:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{extension:\\.[a-z]+}")   

通配符功能：  

- /{path1}/*
- /{path2}/{path3}/**

占位符功能：

- /path1/{path2}/${path3}  --path3的值需要我们在配置文件中配置

后缀匹配：

- /path1/path2/xx.xml (默认情况下Spring Mvc会忽略结尾的.xml，所以还是会匹配到/path1/path2/xx)


**个人觉得上面这种能匹配多个访问路径的方式少用。因为一不小心就会匹配上我们不需要的url。这样找问题时会比较疑惑**

####Matrix Variables
这个功能的使用场景待发掘

    <mvc:annotation-driven enable-matrix-variables="true"/>

####Request Parameters and Header Values
Spring Mvc提供了更加细粒度的url匹配。可以根据请求或请求头中某些值的值来进行匹配。

    //如果请求中有param这个参数就不匹配
    //http://localhost:8080/base/demoH/xx?param=chen
    @GetMapping(value = "/demoH/xx",params = "!param")
    @ResponseBody
    public String demoH(){
        return "l am demoaH...";
    }

    //请求参数中必须要有param这个参数，而且值一定要是chen才能匹配上
    @GetMapping(value = "/demoI/xx",params = "param=chen")
    @ResponseBody
    public String demoI(){
        return "l am demoaI...";
    }

    //请求头中必须要有param这个参数，而且值一定要是chen才能匹配上
    @GetMapping(value = "/demoJ/xx",headers = "param=chen")
    @ResponseBody
    public String demoJ(){
        return "l am demoaJ...";
    }

####Defining @RequestMapping handler methods（Controller中的方法，这边是*重点*）
controller中用@RequestMapping标记的的方法可以很灵活的填写方法入参，SpringMvc会根据请求自动给入参初始化赋值，格式化等。   

Controller方法支持的参数类型:

- HttpServletRequest/HttpServletResponse
- HttpSession(非线程安全)
- Locale/TimeZone
- HttpMethod
- java.security.Principal
- @PathVariable/
- @MatrixVariable/
- @RequestParam/ （对于POST和GET都生效，取url？name=xx这种形式的参数）
- @RequestHeader/
- @RequestBody/ （对于post请求生效 取请求体中的数据）
- @RequestPart/ （文件上传下载）
- @SessionAttribute/ （取session中数据）
- @RequestAttribute （取请求参数）
- HttpEntity<?>
- java.util.Map/org.springframework.ui.Model/org.springframework.ui.ModelMap

在GET请求中，不能使用@RequestBody。
在POST请求，可以使用@RequestBody和@RequestParam，但是如果使用@RequestBody，对于参数转化的配置必须统一。@RequestBody标注的参数会使用HttpMessageConvert进行转换。  

@ModelAttribute注解

    //@ModelAttribute注解可以用在Controller中的方法，用来初始化Model，每次访问这个
    //controller这两个方法都会被执行
    //也可以用在方法参数上,用来取值
    //支持的参数和普通的Controller方法一样
    @ModelAttribute
    public void init(Model model){
        model.addAttribute("message", "init message...");
    }

    @ModelAttribute
    public void init1(Model model){
        model.addAttribute("message1", "init message1...");
    }
    
    //这边三种方式，拿到的值都是上面初始化的model的值
    @RequestMapping(value = "/demoE/{path1}")
    @ResponseBody
    public String demoE(Map<String,Object> map,Model model,ModelMap modelMap){
        logger.info("into demoE");
        return "l am a demoE...";
    }

Controller方法支持的返回参数类型：

- ModelAndView
- Model
- Map
- View
- String
- Callable<?>
- ListenableFuture<?>等等

###1.4 Handler Mappings


##Spring mvc配置
SpringMvc提供了Java Config和xml namespace两种方式来配置springMvc,以覆盖SpringMvc的默认配置。下面会详细介绍这些配置。

###默认Servlet
当我们访问静态资源时，可能匹配不到任何handler，这是我们需要配置一个默认的Servlet Handler来处理静态资源。

    @Configuration
	@EnableWebMvc
	public class WebConfig extends WebMvcConfigurerAdapter {
		@Override
		public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable("handlerName");
	}
	}

xml形式的配置

    <mvc:default-servlet-handler default-servlet-name="myCustomDefaultServlet"/>

###Path Matching
PathMatchConfigurer（具体使用待定~）

###Message Convert
configureMessageConverters这个方法会覆盖掉Springmvc默认的convert配置。

    @Configuration
    @EnableWebMvc
    public class WebConfiguration extends WebMvcConfigurerAdapter {
	    @Override
	    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
	    .indentOutput(true)
	    .dateFormat(new SimpleDateFormat("yyyy-MM-dd"))
	    .modulesToInstall(new ParameterNamesModule());
	    converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
	    converters.add(new MappingJackson2XmlHttpMessageConverter(builder.xml().build()));
	    }
    }

xml形式的配置

    <mvc:annotation-driven>
		<mvc:message-converters>
			<bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
			<property name="objectMapper" ref="objectMapper"/>
			</bean>
			<bean class="org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter">
			<property name="objectMapper" ref="xmlMapper"/>
			</bean>
	    </mvc:message-converters>
	</mvc:annotation-driven>
	<bean id="objectMapper" class="org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean"
	p:indentOutput="true"
	p:simpleDateFormat="yyyy-MM-dd"
	p:modulesToInstall="com.fasterxml.jackson.module.paramnames.ParameterNamesModule"/>
	<bean id="xmlMapper" parent="objectMapper" p:createXmlMapper="true"/>


###高级配置
如果你需要对某个类进行更细粒度的配置，可以使用BeanPostProcessor进行配置。下面举个栗子。

    @Component
    public class MyPostProcessor implements BeanPostProcessor {
	    public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
	    if (bean instanceof RequestMappingHandlerAdapter) {
	    // Modify properties of the adapter
	    }
    }
    }

对于Java config形式的高级配置，我们首先可以参考WebMvcConfigurationSupport这个类。这个类中配置了很多@Bean。注意：@EnableWebMvc这个注解和DelegatingWebMvcConfiguration的实现类只需要配置一次。

    @Configuration
    public class WebConfig extends DelegatingWebMvcConfiguration {
	    @Override
	    public void addInterceptors(InterceptorRegistry registry){
	    // ...
	    }
	    @Override
	    @Bean
	    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
	    // Create or let "super" create the adapter
	    // Then customize one of its properties
	    }
    }

重点关注类：

- WebMvcConfigurationSupport
- DelegatingWebMvcConfiguration

##Spring Web Flow


##WebSocket
https://blog.csdn.net/mybook201314/article/details/70173674
http://www.ruanyifeng.com/blog/2017/05/websocket.html
http://ifeve.com/%E3%80%8Aspring-5-%E5%AE%98%E6%96%B9%E6%96%87%E6%A1%A3%E3%80%8B22-websocket-support/

###什么是WebSocket

###应用场景是怎样的
WebSocket最适合在Web应用程序中，客户端和服务器需要以高频率和低延迟交换事件。实时聊天,游戏，弹幕
低延迟和高频率的消息可以使WebSocket协议的使用成为关键

###没这个技术之前是怎么做的










