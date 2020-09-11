# docker-some

初衷是了测试docker下打Springboot的jar包，配置了Dockerfile和docker-compose.yaml

1. 通过build.sh打jar包、打镜像
2. 通过start.sh启动应用
3. 通过stop.sh关闭应用
4. 通过exec.sh进入容器内部查看情况
5. 通过test.sh测试调用应用的接口

## xjar加密jar包建构

然后进一步测试使用xjar给jar包加密，xjar是github上的开源项目：https://github.com/core-lib/xjar

在pom配置文件中加入xjar的插件：

```xml
<project>
    <!-- 设置 jitpack.io 插件仓库 -->
    <pluginRepositories>
        <pluginRepository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </pluginRepository>
    </pluginRepositories>
    <!-- 添加 XJar Maven 插件 -->
    <build>
        <plugins>
            <plugin>
                <groupId>com.github.core-lib</groupId>
                <artifactId>xjar-maven-plugin</artifactId>
                <version>4.0.1</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>build</goal>
                        </goals>
                        <phase>package</phase>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```

然后再打包

```shell script
mvn clean package -Dxjar.password=hpcpltSEC202O
```

然后构建启动程序xjar

```shell script
GOOS=linux GOARCH=amd64 go build target/xjar.go
```

启动时通过启动程序启动xjar包

```shell script
./xjar java -jar docker-some-0.0.1-SNAPSHOT.xjar
```







