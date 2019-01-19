# CustomDatePicker
Android 自定义日期选择控件

详细说明参考 [Android 好看的自定义滚动式日期选择控件](https://blog.csdn.net/liuwan1992/article/details/52701475#comments)

&nbsp;

==================== 分割线 【更新日期：2018/12/21】 ====================

收到不少反馈项目中存在的问题，项目是初学 Android 时写的，一直没优化，最近花时间优化了下。由于代码中问题较多，所以本次更新直接对整个项目进行了重构，代码变动较大，主要有以下修改：

1. 重构项目，重命名变量和方法，优化代码结构（会导致与原先版本接口或方法名对应不上，需要调整接入）；

2. 优化内存泄漏；

3. 解决收到反馈的 bug，如月份+1问题等；

4. 解决联动时下一级单位归零问题，比如滚动月，选中的日不变化。当溢出可选范围时，自动选中较近的值，如12月31日滚动到11月时变为11月30日；

5. 解决刷新频繁问题，增加定制滚动动画的展示；

6. 因日期字符串格式太固定，新增对时间戳的调用支持；

Ps：我看很多人反馈时间范围的问题，这里特地说明一下，展示的时间范围是由传入参数决定的，注意 CustomDatePicker 的最后两个参数，决定了日期选择的范围。

由于结构变动较大，所以新建了分支：[**update_20181221**](https://github.com/liuwan1992/CustomDatePicker/tree/update_20181221)

&nbsp;  
效果图：

<img src="https://raw.githubusercontent.com/liuwan1992/CustomDatePicker/update_20181221/CustomDatePicker1.png" width = 30% height = 30% />&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://raw.githubusercontent.com/liuwan1992/CustomDatePicker/update_20181221/CustomDatePicker2.png" width = 30% height = 30% />
