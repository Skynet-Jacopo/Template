package com.example.administrator.template.EditText;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.template.R;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditTextActivity extends AutoLayoutActivity {

    @Bind(R.id.edt_issue_content)
    EditText mEdtIssueContent;
    @Bind(R.id.edt_name)
    EditText mEdtName;
    @Bind(R.id.edt_password)
    EditText mEdtPassword;
    @Bind(R.id.btn_issue)
    Button   mBtnIssue;
    @Bind(R.id.list_issue)
    ListView mListIssue;

    private List<String> datas = new ArrayList<>();
    private IssueAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();

    }

    private void initView() {

        mEdtIssueContent.setSelection(0);
        for (int i = 0; i < 20; i++) {
            datas.add("测试数据" + i);
        }
        mAdapter = new IssueAdapter(datas, getApplicationContext());
        mListIssue.setAdapter(mAdapter);
    }

    @OnClick({R.id.btn_issue})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_issue:
                Toast.makeText(EditTextActivity.this, "发表", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
