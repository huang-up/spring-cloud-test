####服务治理
如何使用Spring Cloud来实现服务治理。

由于Spring Cloud为服务治理做了一层抽象接口，所以在Spring Cloud应用中可以支持多种不同的服务治理框架，比如：
1. Netflix Eureka
2. Consul
3. Zookeeper

在Spring Cloud服务治理抽象层的作用下，我们可以无缝地切换服务治理实现，并且不影响任何其他的服务注册、服务发现、服务调用等逻辑。

pom文件中<dependencyManagement>
通过不同目录来区分Brixton和Dalston的示例。