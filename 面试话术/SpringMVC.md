![image-20240515162045609](C:/Users/WSJ/Desktop/704Sync_dataStructure/dataStructure/%E9%9D%A2%E8%AF%95%E8%AF%9D%E6%9C%AF/SpringMVC.assets/image-20240515162045609.png)

#### 流程

执行前；当一个请求发来时先进服务器（Tomcat）,在服务器中会有拦截器，过滤器啊，等这些功能走完之后，才真正的进入了框架中。

1.用户发来一个请求，首先进入的是前端控制器DispatcherServlet

2.前端控制器将（DispacherServlet）用户发来的请求发送给处理器映射器（HandlerMapping）

3.处理器映射器根据前端控制器发来的用户的请求找到对应符合的控制器（Handler）,并且将其封装成处理器执行链，返回给前端控制器。

4.处理器适配器接收到来自前端控制器的执行链后，找到对应执行此执行链的处理器适配器（HandlerAdapter）来调用的具体的控制器（就是说其对应的方法或者逻辑）

5.控制器执行完成后，会返回一个ModelAndView对象给处理器适配器

6.处理器适配器将返回来的ModelAndView对象返回给前端控制器(到这里所有的业务处理过程就要完了，接下就是将结果以页面的的形式相应给用户)

7.前端控制器将返回回来的ModelAndView对象交给视图解析器（ViewResolver），视图解析器根据传过里的View对象解析成对应的页面对象，然后将页面对象和Model对象返回给前端控制器。

8.前端控制器再将返回回来的对象交给视图（View）,视图根据传过来的Model对象再一次的对页面进行渲染，然后在返回给前端控制器。

9.前端控制器将完成的结果响应给浏览器，然后浏览器在展现给用户。

#### 代码流程

```java
doService ==> doDispatch
// 
HandlerAdapter ha = this.getHandlerAdapter(mappedHandler.getHandler());
if (!mappedHandler.applyPreHandle(processedRequest, response))  {return;}
 mv = ha.handle(processedRequest, response, mappedHandler.getHandler());
mappedHandler.applyPostHandle(processedRequest, response, mv);
// preHandle,postHandle,afterHandler都是在HandlerExecutionChain类里面

```

