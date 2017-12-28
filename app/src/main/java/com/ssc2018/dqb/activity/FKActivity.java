package com.ssc2018.dqb.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ssc2018.dqb.R;
import com.ssc2018.dqb.utils.ToastUtils;

/**
 * 作者：MrXu on 2017/12/27 10:52
 * 邮箱：17610872621@163.com
 */
public class FKActivity extends Activity {
    private TextView title;
    private ImageView back;
    private EditText idea_edit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        findView();
    }
    public void initData(){
        // 意见提交
        findViewById(R.id.submit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ideastr = idea_edit.getText().toString().trim();
                if (null!=ideastr && !ideastr.equals("")){
                    ToastUtils.show("谢谢您的宝贵意见，我们会及时处理",FKActivity.this);
                }else{
                    ToastUtils.show("请填写您的意见信息",FKActivity.this);
                }
            }
        });
    }
    public void findView(){
        idea_edit = (EditText) findViewById(R.id.idea_edit);
        title = (TextView) findViewById(R.id.title);
        title.setText("意见反馈");
        back = (ImageView) findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initData();
    }
    public int getContentView(){
        return R.layout.activity_idea_fk;
    }

}
