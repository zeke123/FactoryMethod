package com.zhoujian.factorymethod.bean;

import android.content.Context;
import android.widget.Toast;
import com.zhoujian.factorymethod.impl.Sender;

/**
 * Created by zhoujian on 2016/12/1.
 *
 * 发送短信  要实现接口
 */

public class SmsSender implements Sender
{

    private Context mContext;

    public SmsSender(Context mContext)
    {
        this.mContext = mContext;
    }

    @Override
    public void send()
    {
        Toast.makeText(mContext, "发送短信", Toast.LENGTH_SHORT).show();
    }
}
