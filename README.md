# 文件损坏器

本项目受B站视频 [BV1zk4y1k7Xe](https://www.bilibili.com/video/BV1zk4y1k7Xe) 启发，作用是在文件中每隔一段就替换（损坏）几个字节。

使用 Java 语言编写。

## 如何使用

- 需要安装 JDK ，建议 1.8 或更高版本。
- 在终端中输入以下命令（可根据实际情况进行修改）：

```
git clone https://github.com/zhangzhipeng651/FileDestructor.git
cd FileDestructor
javac -encoding UTF-8 FileDestructor.java
java FileDestructor
```

## 局限性

本程序只能处理约 2 GiB 内的文件。