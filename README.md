# flutter_android_interactive

演示如何在android现有项目中集成flutter项目，进行混合开发。[google官方教程](https://github.com/flutter/flutter/wiki/Add-Flutter-to-existing-apps)

## 集成方法

### 创建Flutter Module

```
flutter create -t module [flutter_module]
```
模块创建好后使用Android Studio导入执行gradle任务，出现`.android`目录。

### 配置原生Android项目

1.在项目的`settings.gradle`中增加如下配置

```
setBinding(new Binding([gradle: this]))
evaluate(new File(
        settingsDir.parentFile,
        "flutter_module/.android/include_flutter.groovy"
))
```
注意，这里`flutter_module`为Flutter模块所在的文件名。

2.在项目的`build.gradle`的dependencies中加入`flutter`依赖

```
dependencies {
    ...
    implementation project(':flutter')
}
```

3.继承`FlutterActivity`, 创建Flutter页面的容器Activity。

```
public class FlutterPageActivity extends FlutterActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FlutterMain.startInitialization(this);
        super.onCreate(savedInstanceState);
        GeneratedPluginRegistrant.registerWith(this);
        getFlutterView().setInitialRoute("flutterView");


        registerPlugins(getFlutterView());

    }

    /**
     * 注册插件
     *
     * @param flutterView
     */
    private void registerPlugins(FlutterView flutterView) {


    }
}
```

4.调用Flutter页面。

```
public void toFlutter(View view) {
    Intent intent = new Intent(MainActivity.this, FlutterPageActivity.class);
    startActivity(intent);
}
```


