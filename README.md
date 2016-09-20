Material 风格测试用例：
    Material Design 中文版：http://www.apkbus.com/design/progress-activity.html

    学习内容出处： http://www.cnblogs.com/lcw/p/4074014.html
                 http://www.androidchina.net/1381.html

    1. 转场动画： http://www.bkjia.com/Androidjc/1049811.html

                http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0201/2394.html

        1.1 问题： (没有效果)
                  http://blog.csdn.net/u013268154/article/details/50855026

                  1.makeSceneTransitionAnimation必须运行在android5.0以上的系统才可以
                  2.要实现过度的两个控件必须都得在activity的布局文件中，使用include也行，但是不能用listview.addHeaderView 的形式使用



    2. Authentic Motion 真实的动效

       在不同的app上下文和状态下，动效可以提供一种可视化和连贯的体验。通过小规模的使用切换动画可以增加一些情趣。而不是为了动效而动效。总的来说，UI和内容元素不会简单的消失或者出现，它们会以动画的方式移动入到一个单元或者单独的出现。

    3. Signature element: 适当的尺寸
                合适的地方，text内容，app titles,应该对齐3个keylines：

                http://www.google.com/design/spec/layout/metrics-and-keylines.html#metrics-and-keylines-keylines-and-spacing

                在手机上，那些 keylines 距离左边是16dp和72dp，距离屏幕右边缘是16dp。在平板上是24dp和80dp。

                UI元素的对齐方式和大小应该根据一个8dp的网格。比如，app bar在手机上为56dp，在平板上是64dp。Padding和Margins可以使用像：8dp,16dp,24dp的值等等，更精确的text位置是使用一个4dp的网格

    4. 调色板
                http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2014/1111/1955.html

    5. ripple涟漪效果
                默认的 android:selectableItemBackground 和 android:selectableItemBackgroundBorderless 拥有这种效果，或者你可以使用RippleDrawable (<ripple>) 去自定义效果。
                在5.0之前的设备上，ripples没有这种预期的效果，因此，遵从默认的android:selectableItemBackground 行为。


    6. 抽屉
                标准的抽屉：在手机上不要宽于320dp，在平板上不要宽于400dp,但是不要小于屏幕宽度 – 标准的toolbar高度，比如在Nexus5中：360dp – 56dp = 304dp

                每一个抽屉条目的应该沿着grid网格，所有的行高为 48dp，上下8dp边距。

    7. MaterialDialog
                https://github.com/GoogleSample/L-Dialogs
                https://github.com/GoogleSample/MaterialDialog