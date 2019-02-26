"# compress-image-webp"

## 配置方式：
build.gradle中添加：
apply plugin: 'compress.image.webp'
```
png2webp {
    useOriPng = false  //转换后是否用原png编译测试，false:使用${webPResPath}作为资源,true:使用${pngBackupPath}作为资源
    pngBackupPath = "" //转换webp原png文件备份目录, 默认为res同级目录：res_png_ori
    webPResPath = ""   //转换webp的目录, 默认为res同级目录：res_webp
    quality 75         //10-100,100为无损压缩
}
```

## 工程build.gradle中配置
```
repositories {
        maven {
        url 'https://dl.bintray.com/itrocker/Maven'
        }
}

dependencies {
    classpath 'cn.mydreamy.gradle.plugin:compress-image-webp:1.0.0'
}
```
    
    
