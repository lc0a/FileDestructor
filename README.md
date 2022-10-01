# 文件损坏器

本项目受B站视频 [BV1zk4y1k7Xe](https://www.bilibili.com/video/BV1zk4y1k7Xe) 启发，作用是在文件中每隔一段就替换（损坏）几个字节。

使用 Java 语言编写。

## 如何使用

（可根据实际情况进行，不必完全遵照）

1. 需要安装 JDK ，建议 1.8 或更高版本。
2. 在终端中输入以下命令：

    ```
    git clone https://github.com/zhangzhipeng651/FileDestructor.git
    cd FileDestructor
    javac -encoding UTF-8 FileDestructor.java
    ```
3. 将需要处理的文件放入 `FileDestructor` 目录
4. 执行 `java FileDestructor`
5. 根据本程序的提示输入相关数据，例如：
    ```
    输入文件名:test.mp4
    文件大小: 26286930 字节
    正在读取文件 test.mp4 ...
    读取文件完成!
    每隔多少字节进行一次损坏？114514
    每次损坏多少个字节？3
    将损坏后的文件保存到:out.mp4
    正在保存文件 out.mp4 ...
    保存成功!
    ```
    
## 效果展示

原视频：https://vdse.bdstatic.com/192d9a98d782d9c74c96f09db9378d93.mp4

原视频约第5秒时截图：

![Original](demo_original.png)

使用本程序处理视频后：

![After](demo_after.png)




## 局限性

本程序只能处理约 2 GiB 内的文件。
