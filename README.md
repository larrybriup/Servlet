        开启tomcat服务sudo /opt/apache-tomcat-6.0.29/bin/startup.sh
        关闭tomcat服务sudo /opt/apache-tomcat-6.0.29/bin/shutdown.sh
    
    
    一个web项目最基本的项目结构:
    项目名字:WebTest
    
    1,文件夹WebTest
    
    2,WebTest中有一个文件夹WEB-INFO(名字是固定的)
    
    3,WEB-INF文件夹中,classes文件夹,lib文件夹,web.xml文件,这些名字都是固定的
    
    注意:
     WebTest文件夹下面还可以放页面,html,css样式,js样式,图片等.
        classes文件夹中放的是编译的.class文件,
        lib中放的是当前这个项目中运行需要的jar包
        
        
servlet:
    c/s客户端/服务器模式的软件,QQ或者大型游戏,用户需要先下载客户端
    b/s浏览器服务器模式的软件,用浏览器访问,网站等基本上全是b/s模式,用户不需要下载任
    何东西,只需要浏览器就可以访问到这个项目,
    
    要学习web项目就是这种b/s模式的
    
    web项目时期就是两个软件之间的信息交互,客户端机器中的浏览器软件和服务器断机器中web服务器软件之间的交换tomcat就是web服务器软件
    
    
    浏览器和tomat是不同的软件,但是在开发的过程中都会加入对http协议的支持,所以他们进行交互的时候是通过http协议规定的形式进行的交换信息的,客户端先发送一个请求,然后服务断接受到请求响应和之后再返回给客户端一个响应,并且吧请求的资源发给他.
    
    我们要做的就是,开发一个web项目,然后把这个web项目放到tomcat制定的位置里面,然后再运行tomcat软件,在运行的过程中,其他计算机里面,只要是和我们相通的,就可以同浏览器来访问这个项目.
    
    在浏览器访问tomcat的时候,tomcat会按照请求的要求去调用相关资源,并且发送给客户端浏览器.
    
    注意:web项目中,任何一个类中都不需要main方法,整个项目的运行,对象的创建,方法的运行,都是tomcat管理的.tomcat根据客户端的要求,会调用某个servlet中的指定方法,因此我们的项目就可以运行了
    
    
    Tomcat服务器:
        backup目录:备份文件目录
        bin目录:启动,关闭tomcat的相关的命令
        conf目录:tomcat的主要配置文件
        li目录:tomcat中可以同时部署多个项目,多个项目都需要用到jar包就可以放到这里
        logs目录:记录tomcat的日常运行的情况或者错误信息
        temp目录:tomcat运行期间可能会产生一些临时文件,临时文件爱你就放在这里
        webqpps目录:我们开发好的web项目需要放在这里,默认里面已经有一些tomcat自带的
        项目样例了
        work目录:编译jsp页面时需要用到这个目录
        
    部署:
        http://localhost:8001/
        http://ip:port/项目/项目中的资源
        
        WebTest:
            WEB-INF:classess lib
            
         javac -cp servlet-api.jar -d . FirstServlet.java
            -cp servlet-api.jar是编译的时候如果缺少文件就cp这个
            
            编译完之后把.class文件放到项目中的classes文件中然后配置web.xml就可以访问了.
            编译完之后,把这个.class文件已经包目录,放到项目中的classes目录里面,然后再项目中的web.xml文件进行配置,配置的目的是:想把一个路径映射成我们自己一个servlet,这个我们在浏览器里面就可以用个这个映射的路径来来访问这个servlet了.

浏览器中只能以类似于这样的信息:
  http://localhost:8001/WebTest/hello.html
  但是我们需要的是:
  要运行servlet至少要有servle对象,所以我们要有这个类的package.类名
  com.eagle.test.hello
  
  所以我们需要把一个路径映射成一个servlet
  比如:把/first映射成FirstServletTest这个servlet将来用户在浏览器中输入/first路径之后,就相当于告诉服务器去运行FirstServletTest

例如:
web.xml文件中加入:
<!-- 描述一下要做映射的servlet-->
        <servlet>

                <servlet-name>firstservlet</servlet-name>

                <servlet-class>com.eagle.test.FirstServlet</servlet-class>

        </servlet>
        <!--给一个已经描述过的servlet做映射-->
        <servlet-mapping>

                <servlet-name>firstservlet</servlet-name>

                <url-pattern>/first</url-pattern>

        </servlet-mapping>

    <servlet-name>给要描述的servlet起一个名字,目的是在下面做映射的时候能够找到    
    servlet
    <servlet-class>写上servlet的全包名加类名
     <servlet-mapping>中的<servlet-name>子标签指明这个映射是给哪一个servlet做的映射,通过之前起的servlet名字找
     <servlet-mapping>中的<url-pattern>子标签:
        这个就是我们要映射的路径,将来在浏览器里输入这个路径就相当于要访问我们这个servlet,注意:这个路径一定是以/开头的:/a   /a/b  /a/b/hello
        
        

servlet
    1,什么是servlet?
        servlet其实就是一种java类,只不过这个servle有一些特殊的作用,所以我们叫他
        servlet,
    2,servlet的作用:
        可以让浏览器通过一个路径去访问.
    3,怎么把一个类变成servlet?
        1)实现一个接口javax.servlet.Servlet
        2)继承一个抽象类,javax.servlet.GenericServlet
        3)继承一个抽象类,javax.servlet.http.HttpServlet
        注意:servlet接口中有五个抽象方法,其中最重要的是
            service(ServletRequest req, ServletResponse res) 
            抽象类GenericServlet实现了Servlet但是留了一个方法没有实现,除此之外他
            还增加了一个新的方法
            抽象类HttpServlet,继承了GenericServlet,但是其没有任何抽象方法,除了从
            父类继承的方法之外,他还有很多新的方法,注意:这个类里面有两个servlet方
            法,但是参数类型不同
            
        1)Servlet接口中的servlet方法
            无论我们使用那一种方式写出来的一个servlet类中一定会有一个方法叫做
            servlet,因为这个方法是Servlet接口中定义的,tomcat调用的时候只会调用这
            个,注意:这个servlet方法中参数类型
        2)GenericServlet两个init方法
            带参函数的init方法是从Servlet接口中实现的,还有一个我参的init方
            法,tomcat服务器创建servlet对象的时候,会帮我们去调用inint有参进行s
            ervlet类中的初始化工作,所以如果想servlet中初始化自己的数据,就要重写
            inint方法,有参的可以调用午餐的,所以只需要重写午餐的就可以了;
            
        3)HttpServlet中的两个service方法
            
            这个是从Servlet接口中实现的方法,
            service(ServletRequest req, ServletResponse resp){
                //强转参数类型,调用新定义的service方法
                ...
                //新定义的service方法判断当前请求的类型是什么
                ...
            }
         
         4servlet的生命周期
            servlet的对象是单列:在web项目整个运行期间,每个servlet只会有一个对象存
            在,默认情况下这个servlet是第一次被访问的时候才会创建的,而且之后不管再
            访问多少次,也不会再创建对象了(我们可以设置某一个servlet的对象,在服务器
            启动的时候就可以创建出来)
            1)默认情况下第一次被访问的时候创建servlet对象(调用午餐构造器)
            2)调用init方法
            3)我们访问的时候会调用service方法
            4)在销毁servlet对象的时候就会调用destroy方法.
            
            通过设置可以在servlet对象启动的时候就被创建
            web.xml:
            <servlet>
            <servlet-name>LifeServlet</servlet-name>
            <servlet-class>com.eagle.servlet.LifeServletTest</servlet-class>
            <load-on-startup>1</load-on-startup>
            </servlet>
             <load-on-startup>1</load-on-startup>表示这个servlet在启动的时候就会
             被创建,标签里面的数字大小决定了被创建的顺序,小的被先创建
             
         5,servlet的线程安全问题
          问题产生的原因:
          1)servlet是单列,一个servlet只有一个对象
          2)web项目本身就头多线程的特点,这个特点是由服务器提供的,两个线程去访问同
          意个servlet是完全可能的,这就产生了线程的安全问题了
          解决方案:
          1)加锁synchronized
          2)尽量少的定义成员变量,只有成员变量才会产生线程的安全问题,在多个线程访问
          的时候,方法中的局部变量是没这样的问题的,
          3)其他(实现一些安全性的接口)
         
	  
	6,客户端向服务器发送请求并传参
		客户端发的可以是get形式也可以是post形式
		1,哪些方式属于get/post方式
			get方式:
				a.浏览器中输入地址然后回车
				b,超链接
				c.页面中引入的css样式
				d.页面中引入js的文件
				e.<img src="image/a.jpg"/>
				f.form表单中method="get"请求
				g.ajax中设置异步提交方式为get
				h.其他
			post方式:
				a.form表单中method="post"请求
				b.ajax中设置异步提交方式为post
				c.其他
		2,get和post的区别
			主要体现在所传的参数上
			a.get方式提交的时候传参数
			  参数是直接放在要请求的url后面的
			 url http://ip:port/WebTest/servlet
			 传参直接加在后面&多参
			.../servlet?name=tom&age=20
			特点:直观,但是多了不现实

	post方式传参
		参数是放在请求的体部的.(请求分为请求头,请求体)
		参数是放在请求的体部而不是头部
		特点:看不到参数,安全,传的多
	7,servlet中接受客户端穿传过来的参数
		<a href="ParamServletTest">click here sanpao三炮</a>
		ParamServletTest是映射路径,不带/
		客户端都是以这样的形式传递参数的:
		参数名=参数值
		所以我们要用参数名字来拿参数值
		key value
		接受到的只能是String类型或者String类型的数组
		入股客户端用的是多选框,传过来的是一个String类型的数组,
		String[] hoppy=req.getParameterValues("hoppy");
		在表单中,参数值就是用户填的内容,或者所选的value值
	8,乱码
		a.get方式提交数据,servlet拿到是乱码
			server.xml URIEcoding="UTF-8"
		b.post方式提交数据,servlet拿到是乱码
			req.setCharacterEncoding("GBK");
		c,servlet向浏览器返回数据,浏览器显示乱码
		在代码中,获得输出流之前,我们要先设置输出流用什么编码把数据写回去的:
		res.setCharacterEncoding("UTF-8");
		同时我们还可以通知浏览器用什么编码:
		res.setContentType("text/html;charset=utf-8");
		主要:如果不通知浏览器,浏览器就会用自己默认的编码解析

				
	9,servlet中的跳转
		a.服务器内部跳转
			1)跳转到一个页面
			2)跳转到一个serlet

			req.setCharacterEncoding("UTF-8");
		String name=req.getParameter("name");
		String page="";
		if("大超".equals(name)) {
			page="success.html";
		}else {
			page="error.html";
		}
		//获得一个跳转对象,服务器内部跳转
		RequestDispatcher rd = req.getRequestDispatcher(page);
		//跳转
		rd.forward(req, res);
		特点:
		1,不管服务器内部跳转多少次,地址栏中的地址都是第一次访问到的地址
		2,在服务器跳转过程中,req和res的值不变,就是把他们的对象进行转发,如果转发的对象是一个页面就把这个页面返回给浏览器,
		如果是servlet就调用这个servlet的service方法,把req和res当做参数传递进来.
		3.在服务器内部跳转的过程中,每一个环节使用的req和res都是同一个对象.
		b.客户端重定向
			1)跳转到一个页面
			2)跳转到一个serlet
		
		String page="页面/servlet";
		resp.sendRedirect(page);
		特点:
			1,浏览器中显示的跳转到的那个资源(页面/servlet),而不是第一次访问的servlet地址.
			2,客户端重定向,其实就是让客户端浏览器重新发一个新的请求到要跳转的资源.
			3,在客户端重定向的过程中,每一个req都是浏览器发的新的req对象,
	10,web项目中的路径
		路径WebRoot/path 下面
		两个页面:
		pathA.html
		  A中超链接到B页面
		PathB.html

		一个servelt映射路径:
		/PathServeltTest
		这个setvlet直接跳转到A页面

		正常情况下访问:Servlet/path/pathA.html
		乐意链接到B

		404的情况:
		 Servlet/PathServletTest
		 先访问servelt再跳转到A,
		 这个时候再点击超链接:href="pathB.html",
		 路径是Servlet/PathServletTest,只是跳转到了A
		 但是要访问的B在Servlet/path/pathA.html
         11,路径中最左边的/
	    注意:如果路径最左边没有/,那么就是代表当前路径算
		例如:一个servlet的映射路径
		 /servlet/test/myfirstservelt
		 这里的第一个/是我们要讨论的

		 这个/两种情况
		 1代表地址栏中端口号后的那个
			 http://ip:port/
			 a,页面中的变量加/代表端口号后的/
		 2代表地址栏中项目名字后面那个
			http://ip:port/项目名字/
			b,web.xml文件中的/代表地址栏中项目名字后面的/
			c,服务器跳转中的/代表项目名字后的/
			d,重定向的/代表端口号后的/
	12,request,session,application
		这三个对象可以在服务器内部保存和传递数据
		HttpServletRrequest request
		HttpSession session
		ServletContext application

		request:
			//存值
			req.setAttribute("msg", "Hello Kitty!");
			String page="ScopeServletTest";
			//取数据
			String msg=(String)req.getAttribute("msg");
			作用范围:在一次请求之内起作用
			客户端重定向是不行的,因为他会发出多个请求.
		
		session:
			//获得,存值
			HttpSession session = req.getSession();
			session.setAttribute("msg", "Hello MiMi!");
			//取数据
			HttpSession session = req.getSession();
			String msg = (String)session.getAttribute("msg");
			作用范围:
				一个会话当中起作用.
				横跨多个请求,可以被多个请求共享.
		application:
			//获得
			ServletContext applicattion = req.getSession().getServletContext();
			//取数据
			ServletContext application = req.getSession().getServletContext();
			String msg=(String)application.getAttribute("msg");
			作用范围:
				整个项目中只有一个application对象,是可以共享的,

		作用范围:request<session<application
			(page<request<session<application)
			page只在一个页面起作用,比request更小
			
	注意:getParameter("key")方法是接受哦客户端传过来的值,
		getAttribute("key")方法是取到之前调用setAttribute方法保存到这个对象里面的值.
	13,会话追踪技术:session,cookie
		http协议的访问是无状态的访问,这次访问不会知道之前当的情况的,http协议的访问是不会帮
		我们保存访问记录的.但有些时候是不需要知道之前访问的状态的,如访问静态页面,第一此访
		问点击了页面中的"校园风采",第二次点击了"学生作品",这两次访问之前没有任何关系,不需
		要知道各自访问的状态.
		session是保存在服务器端的一个对象,这个对象是有服务器完成的
		cookie客户端和服务器两段都有,存在形式不一样,在客户端是以文件的形式存在的,在服务器
		端是以java对象的形式存在的.
		客户端访问服务器的时候,服务器会给这个客户端创建一个会话,也就是一个session对象,服务
		器内存里同时可能有多个session,分别对应不同的客户端,每个session都有一个唯一的id,叫
		做JSESSIONID.
		服务器端给客户端产生一个session对象,会通过这次访问的response对象把这个这个session
		的JSESSIONID的值返回给浏览器,浏览器会把他以一个cookie文件的形式保存起来.
		
		Cookie c1= new Cookie("name", "Tom");
		Cookie c2= new Cookie("msg", "Hello!");
		//设置cookie的期限
		c1.setMaxAge(60*60*24*365);
		c2.setMaxAge(60*60*24*365*10);
		//由响应带走
		resp.addCookie(c1);
		resp.addCookie(c2);
	
		resp对象会把cookie带回浏览器,浏览器把cookie中的内容保存到对应的文件中,如果没有设
		置cooie的时间那么默认是会话时间,会话结束就失效.
		//从req中拿到一个cookie数组
		Cookie[] c = req.getCookies();
		if(c!=null){
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			//遍历数组.拿出key和value
			for(Cookie cc:c){
				String key=cc.getName();
				String value=cc.getValue();
				out.println("<h1>"+key+":"+value+"</h1>");
			}
			out.println("</body>");
			out.println("</html>");
			
			out.flush();
			out.close();
		}
		注意:session的创建时间.
	14,url重写,也是会话追踪技术的一种
		禁用cookie之后,需要URL重写
		String url=resp.encodeURL("GetDataServlet");
		out.println("<a href='"+url+"'>GetDataServlet</a>");
		重写后变成
		<a href='GetDataServlet;jsessionid=5DBF502510C8AFD5C3056C4B8A284BC6'>
		GetDataServlet</a>
		
	15,Filter
		作用:过滤请求并转发,可以拦截请求.拦路者.
		
		如何写一个Filter:
		写一个Filter类,然后实现接口Filter,接口中有三个方法:init(),destroy(),doFilter(),
		init:这个过滤器创建对象的时候会调用到这个方法.
		destroy:对象被销毁的时候调用这个方法.
		doFilter:当过滤器拦截到要拦截的资源的时候调用这个方法.
		FilterChain是一个过滤器链.
		chain.doFilter(req, resp);表示把当前的req和resp传给下一个过滤器,如果,没有了,就放
		行.如果访问没有符合过滤器的条件,那么就跳转到另外一个页面.
		最后还需要在web,xml中进行配置:
		 <filter>
  	<filter-name>encodingFilter</filter-name>
  	<filter-class>com.eagle.filter.EncodingFilter</filter-class>
	  </filter>
	  <filter-mapping>
  	<filter-name>encodingFilter</filter-name>
  	<url-pattern>/*</url-pattern>
  </filter-mapping>
  这个配置和servlet的配置很相似,/*表示当前过滤器过滤的是项目下的所有的资源,如果有两个filter-mapping,可以分别都去和同一个<filter>标签对应.
  注意:这里/代表地址兰中项目名字后的/,某一个资源是否被拦截看的是你配置的拦截路径,*/
  
  16,监听器(listener):
  	作用:监听web中一些事件的发生,如果某些事情发生了那么监听器就会调用某些方法.
  	比如:
  	在web监听requset对象的创建和销毁.ServletRequestListener
  	写一个类,实现一些特点的接口.在web.xml中进行配置
  	<listener>
  	<listener-class>com.eagle.listener.RequestListener</listener-class>
   </listener>
   监听session对象的创建和销毁HttpSessionListener
   监听application对象,
   
   create table t_user(
   	id number primary key,
   	name varchar2(12),
   	password varchar2(16),
   	age number(4)
   );
		

		
		





          
            
    





