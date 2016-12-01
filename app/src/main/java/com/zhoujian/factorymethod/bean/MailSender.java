package com.zhoujian.factorymethod.bean;

import android.content.Context;
import android.widget.Toast;

import com.zhoujian.factorymethod.impl.Sender;

/**
 * Created by zhoujian on 2016/12/1.
 *
 * 发送邮件 要实现接口
 */

public class MailSender implements Sender
{

    private Context mContext;

    public MailSender(Context mContext)
    {

        this.mContext = mContext;
    }

    @Override
    public void send()
    {
        Toast.makeText(mContext, "发送邮件", Toast.LENGTH_SHORT).show();
    }
}
