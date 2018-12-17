package com.liuwan.customdatepicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.liuwan.customdatepicker.widget.CustomDatePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 说明：
 * 作者：liuwan
 * 添加时间：2016/9/28
 * 修改人：liuwan
 * 修改时间：2018/12/17 13:40
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private TextView mTvSelectedDate, mTvSelectedTime;
    private CustomDatePicker mDatePicker, mTimerPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.ll_date).setOnClickListener(this);
        mTvSelectedDate = findViewById(R.id.tv_selected_date);
        initDatePicker();

        findViewById(R.id.ll_time).setOnClickListener(this);
        mTvSelectedTime = findViewById(R.id.tv_selected_time);
        initTimerPicker();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_date:
                // 日期格式为yyyy-MM-dd
                mDatePicker.show(mTvSelectedDate.getText().toString());
                break;

            case R.id.ll_time:
                // 日期格式为yyyy-MM-dd HH:mm
                mTimerPicker.show(mTvSelectedTime.getText().toString());
                break;
        }
    }

    private void initDatePicker() {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        String now = sdf.format(new Date());
        mTvSelectedDate.setText(now);

        mDatePicker = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(long timestampMillis) { // 回调接口，获得选中的时间
                mTvSelectedDate.setText(sdf.format(new Date(timestampMillis)));
            }
        }, "2010-01-01 00:00", now); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        mDatePicker.showSpecificTime(false); // 不显示时和分
        mDatePicker.setIsLoop(false); // 不允许循环滚动
    }

    private void initTimerPicker() {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        mTvSelectedTime.setText(now);

        mTimerPicker = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(long timestampMillis) { // 回调接口，获得选中的时间
                mTvSelectedTime.setText(sdf.format(new Date(timestampMillis)));
            }
        }, "2010-01-01 00:00", now); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        mTimerPicker.showSpecificTime(true); // 显示时和分
        mTimerPicker.setIsLoop(true); // 允许循环滚动
    }

}
