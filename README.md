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





    二、 MaterialDesign 控件：
                推荐博客:  http://blog.csdn.net/bruceyangjie/article/details/52164585
                          http://blog.csdn.net/bruceyangjie/article/details/52164595
                          http://blog.csdn.net/bruceyangjie/article/details/52164609
                          http://blog.csdn.net/qq_31340657/article/details/51918773

                1. TextInputLayout:
                    提升用户体验的EditText，里面包裹一个EditText即可轻松使用,
                    <android.support.design.widget.TextInputLayout
                            android:layout_marginTop="20dp"
                            android:layout_width="match_parent"
                            android:layout_height="wrap_content">
                            <EditText
                                android:layout_width="match_parent"
                                android:layout_height="wrap_content"
                                android:inputType="textPassword"
                                android:hint="Email"/>
                    </android.support.design.widget.TextInputLayout>

                    TextInputLayout的颜色来自style中的colorAccent的颜色,除了显示提示信息，还可以通过调用setError()在EditText下面显示一条错误信息。

                2. TabLayout的使用
                    实现简单的标题栏（跟ViewPager一起使用）：
                    根据官方文档说明，TabLayout的使用有以下两种方式：

                    <1> 通过TabLayout的addTab()方法添加新构建的Tab实例到TabLayout中：

                        TabLayout tabLayout = ...;
                        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
                        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
                        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));


                    <2> 第二种则是使用ViewPager和TabLayout一站式管理Tab，也就是说不需要像第一种方式那样手动添加Tab：

                        ViewPager viewPager = ...;
                        TabLayout tabLayout = ...;
                        viewPager.addOnPageChangeListener(new TabLayoutOnPageChangeListener(tabLayout));

                    你需要设置一个setOnTabSelectedListener(OnTabSelectedListener)来监听每个tab被选中时状态改变的回调;
                    如果你在你的layout里面使用了viewpager的话,你就需要调用setupWithViewPager(ViewPager)来将二者进行绑定,这个layout会将viewpager的标题和内容进行自动填充;

                    而我们TabLayout的Demo就是用得第二种方式：

                        //Fragment+ViewPager+FragmentViewPager组合的使用
                        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
                        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),
                                this);
                        viewPager.setAdapter(adapter);

                        //TabLayout
                        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
                        tabLayout.setupWithViewPager(viewPager); (***必须要***)

                    注意： tab内容需要居中，两种方式实现（xml／代码(两个属性必须同时使用才有效果)）：
                                app:tabGravity="fill"
                                app:tabMode="fixed"

                                or

                                tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
                                tabLayout.setTabMode(TabLayout.MODE_FIXED);



                3. NavigationView
                     侧边栏,

                4. Floating Action Button
                     浮动按钮，默认颜色为主题中colorAccent的悬浮操作按钮，它是一个带有阴影的圆形按钮，可以通过fabSize来改变其大小;有以下属性:

                         默认颜色为colorAccent的颜色值,可以通过app:backgroundTint 属性或者setBackgroundTintList (ColorStateList tint)方法去改变背景颜色。
                         改变尺寸:通过设置 app:fabSize 属性(mini or normal)
                         android:src 改变drawable
                         app:rippleColor 设置点击时候的颜色(水波纹效果)
                         app:borderWidth 设置button的边框宽度,该属性尤为重要，如果不设置0dp，那么在4.1的sdk上FAB会显示为正方形，而且在5.0以后的sdk没有阴影效果。所以设置为borderWidth=”0dp”
                         app:elevation 设置平常阴影状态的深度(默认6dp)
                         app:pressedTranslationZ 设置点击状态的阴影深度(默认12dp)
                         app:layout_anchor - 设置FAB的锚点，即以哪个控件为参照点设置位置
                         app:layout_anchorGravity - 设置FAB相对锚点的位置，值有 bottom、center、right、left、top等

                5. Snackbar
                     SnackBar通过在屏幕底部展示一个简洁的信息,为用户提供一个友好的反馈,用法类似于Toast,
                     区别在于第一个参数不需要上下文而是所依附的父view,而且在同一时间内只能显示一个Snackbar,同时可以为用户提供一个动作操作,用户可以在它消失之前滑动删除; 最简单用法:

                     FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                             fab.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View view) {
                                     Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                                             .setAction("Action", null).show();
                                 }
                             });

                6. CoordinatorLayout
                    官方解释：
                    CoordinatorLayout是一个强大的FrameLayout
                    CoordinatorLayout有两个主要的应用方向:
                        作为顶级应用程序的装饰或一个 chrome layout
                        作为用于与一个或多个子视图的特殊交互的容器

                    其实CoordinatorLayout只是一个从另一层面去控制子view之间触摸事件的布局而已,可以实现不同的视觉滚动效果；

                    例子1. 在旧版本的布局中，当SnackBar和FAB 同时出现的时候，FAB会被SN覆盖； 但是使用CoordinatorLayout作为主布局，FAB则会自动上下滑动，视觉效果比较好；（代码主布局中）

                    我们平时在代码中使用起来也很简单,只要使用CoordinatorLayout作为基本布局，将自动产生向上移动的动画。浮动操作按钮有一个 默认的 behavior来检测Snackbar的添加并让按钮在Snackbar之上呈现上移与Snackbar等高的动画。
                    小贴士:FloatingActionButton.Behavior: It’s main function is to move FloatingActionButton views so that any displayed Snackbars do not cover them.


                7. AppBarLayout
                    AppBarLayout 是继承LinerLayout实现的一个ViewGroup容器组件,默认的AppBarLayout是垂直方向的,
                    它的作用是把AppBarLayout所包裹的内容都作为AppBar, 支持手势滑动操作,可以管理其中的控件在内容滚动时的行为,

                8. CoordinatorLayout与AppbarLayout的结合使用(上滑的时候可以自动隐藏toolbar)
                        我们现在来分析一下整个布局中CoordinatorLayout的作用:

                        因为CoordinatorLayout是一个超级的FrameLayout,所以我们只要设置android:layout_gravity="bottom|end"这个属性即可将FloatingActionBar放置在底部靠右的位置;

                        如果我们想要在手指向上滑动的时候Toolbar隐藏,就需要给Toolbar设置一个属性,app:layout_scrollFlags="scroll|enterAlways",来确定滚动出屏幕时候的动作,我们现在来解释一些这些参数:
                            scroll: 所有想滚动出屏幕的view**都需要**设置这个flag， 没有设置这个flag的view将被固定在屏幕顶部。例如，TabLayout 没有设置这个值，将会停留在屏幕顶部。
                            enterAlways: 配合scroll使用,设置这个flag时，任意向下的滚动都会导致该view变为可见，当向上滑的时候Toolbar就隐藏，下滑的时候显示，启用快速“返回模式”。
                            enterAlwaysCollapsed: 这个flag定义的是何时进入（已经消失之后何时再次显示）,配合scroll使用,当你的视图已经设置minHeight属性又使用此标志时，那么view将在到达这个最小高度的时候开始显示，并且从这个时候开始慢慢展开，当滚动到顶部的时候完全展开。
                            exitUntilCollapsed: 这个flag是定义何时退出，当你定义了一个minHeight，这个view将在滚动到达这个最小高度的时候消失。
                            注意:这些flag的模式一般是前两个一起使用或者 scroll与enterAlwaysCollapsed 一起使用,而最后一个flag只有在CollapsingToolbarLayout中才有用,所以这些flag的使用场景,一般都是固定的;

                        当然,为了使Toolbar可以滚动,还需要一个条件,就是CoordinatorLayout布局下需要包裹一个可以滑动的布局，比如 RecyclerView或者NestedScrollView(ListView及ScrollView不支持),CoordinatorLayout包含的子布局中带有滚动属性的View需要设置app:layout_behavior属性。
                        示例中Viewpager设置了此属性:app:layout_behavior="@string/appbar_scrolling_view_behavior",这样一来AppBarLayout就能响应RecyclerView中的滚动事件,CoordinatorLayout在接受到滑动时会通知AppBarLayout 中可滑动的Toolbar可以滑出屏幕了;

                    总结:如果想让Toolbar划出屏幕,需要做到以下4点
                        CoordinatorLayout作为顶层的父布局
                        需要给Toolbar也就是想要划出屏幕的view设置flag值,app:layout_scrollFlags=”scroll|enterAlways”
                        需要给可滑动的组件设置一个layout_behavior的属性,示例中为viewpager,app:layout_behavior="@string/appbar_scrolling_view_behavior"
                        可滑动的组件目前经测试支持RecyclerView,NestedScrollView,示例中viewpager中包含的就是一个RecyclerView

                9. CollapsingToolbarLayout-----可折叠的Toolbar
                    继承自FrameLayout
                    上一个例子（CoordinatorLayout与AppbarLayout的结合使用）,我们只是在AppbarLayout中使用了可隐藏/展示的Toolbar的话, 只能固定到屏幕顶端并且不能做出好的动画效果,而且无法控制不同元素如何响应collapsing(折叠)的细节，所以为了达到此目的，CollapsingToolbarLayout就应运而生.

                    CollapsingToolbarLayout一般都是需要包括一个Toolbar,这样就可以实现一个可折叠的Toolbar,一般都是作为AppbarLayout的子view使用,CollapsingToolbarLayout的子视图类似于LinearLayout垂直方向排放。

                    CollapsingToobarLayout的属性及用法:

                        Collapsing title：ToolBar的标题，CollapsingToolbarLayout和Toolbar在一起使用的时候，title会在展开的时候自动变得比较大，而在折叠的时候让字体变小过渡到默认值。注意，你必须在CollapsingToolbarLayout上调用setTitle()，而不是在Toolbar上进行设置。
                        Content scrim：ToolBar被折叠到顶部固定时候的背景，你可以调用setContentScrim(Drawable)方法改变背景或者 在属性中使用app:contentScrim=”?attr/colorPrimary”来改变背景。
                        Status bar scrim：状态栏的背景，调用方法setStatusBarScrim(Drawable)。
                        Parallax scrolling children：CollapsingToolbarLayout滑动时，子视图的视觉因子，可以通过属性app:layout_collapseParallaxMultiplier=”0.7”来改变。值的范围[0.0,1.0]，值越大视差越大。
                        CollapseMode ：子视图的折叠模式，需要在子视图设置;
                            “pin”：固定模式，在折叠的时候最后固定在顶端；
                            “parallax”：视差模式，在折叠的时候会有个视差折叠的效果。我们可以在布局中使用属性app:layout_collapseMode=”parallax”来改变。
                        layout_anchor : 这个是CoordinatorLayout提供的属性,与layout_anchorGravity 一起使用,可以用来放置与其他视图关联在一起的悬浮视图（如 FloatingActionButton）或者头像

                     注意:

                        我们使用了下面的参数设置了FloatingActionButton的位置，两个属性共同作用使得浮动按钮可以随着手势能折叠消失和展现。

                        app:layout_anchor=”@id/appbar”
                        app:layout_anchorGravity=”bottom|right|end”

                        AppBarLayout 的高度layout_height固定，不能 “wrap_content”，如果不固定的话动画效果不友好
                        CollapsingToolbarLayout的子视图设置layout_collapseMode属性
                        关联悬浮视图设置app:layout_anchor，app:layout_anchorGravity属性

                10. Palette 调色板
                    本例在PaletteActivity中，只用了一张图片展示效果；
                    实现：
                                    //同步的synchronously
                                        Palette.Builder builder =  Palette.from(mBitmap);
                                    //  mPalette = builder.generate();

                                    //异步的AsyncTask
                                        builder.generate(new Palette.PaletteAsyncListener() {
                                            @Override
                                                        public void onGenerated(Palette palette) {
                                                            // 进行获取颜色并使用

                                                        }
                                        });

                    能够获取6种颜色开关 --> 6 X 3 = 18 种颜色(每种开关又包含3种颜色，Rgb, bodyColor 和  TitleColor)
                    getBodyTextColor();      //适用于描述文字
                    getRgb();                //主要颜色  适用于设置toolbar颜色
                    getTitleTextColor();     //适合toolbar标题颜色


                    // Set the toolbar background and text colors
                      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                      toolbar.setBackgroundColor(vibrantSwatch.getRgb());
                      toolbar.setTitleTextColor(vibrantSwatch.getTitleTextColor());

![image](https://github.com/Jerry-Yin/MaterialDemo/image/img1.jpg)
