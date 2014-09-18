tex2gif
=======

LaTex To Gif  LaTex生成公式图片


#### 依赖环境

* 操作系统 Ubuntu

* 软件包

```
sudo apt-get install nginx
sudo apt-get install dvipng 
sudo apt-get install ghostscript
sudo apt-get install netpbm
sudo apt-get install texlive-latex-base latex-cjk-all texlive-latex-extra 
```

#### 程序配置

* 配置文件 config.properties

```
nginx_url=http://192.168.2.111/
textogif_dir= "bin文件夹所在位置/"
```
`配置后面必须带/`

#### 系统配置

* nginx 配置

`将root_dir配置到textogif_dir的目录`

* generate.sh配置

`DIR配置成textogif_dir的目录`


#### 使用方式

将war部署tomcat下

```
访问:http://192.168.2.211:8080/tex2gif/api/generate/gif?latex=x^2
```
`latex后面的参数是latex的公式`

系统返回

```
访问 http://192.168.2.244/jSlb0a5aD6.gif 得到图片
```


