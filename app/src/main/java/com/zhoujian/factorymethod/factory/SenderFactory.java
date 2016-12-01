package com.zhoujian.factorymethod.factory;

import android.content.Context;
import android.widget.Toast;
import com.zhoujian.factorymethod.bean.MailSender;
import com.zhoujian.factorymethod.bean.SmsSender;
import com.zhoujian.factorymethod.impl.Sender;

/**
 * Created by zhoujian on 2016/12/1.
 *
 * 发送的工厂类
 */

public class SenderFactory
{

    private static final String TAG = "SenderFactory";

    /**
     * 工厂类方法，返回的是一个接口类
     * @param type
     * @return Sender
     */


    //普通工厂模式  (如果传递的字符串出错，就不能创建对象)
    public Sender produceSend(Context mContext, String type)
    {
        if (type.equals("sendmail"))
        {
            return new MailSender(mContext);
        }
        else if(type.equals("sendsms"))
        {
            return new SmsSender(mContext);
        }
        else
        {
            Toast.makeText(mContext, "请输入正确的类型", Toast.LENGTH_SHORT).show();
            return null;
        }
    }


    //多个工厂方法模式(创建多个)
    public  Sender produceMailSend(Context mContext)
    {
        return new MailSender(mContext);
    }

    public Sender produceSmsSend(Context mContext)
    {
        return new SmsSender(mContext);
    }

    //静态工厂方法模式（比较常用，类可以直接调用）

    public static Sender produceMail(Context mContext)
    {
        return new MailSender(mContext);
    }

    public static Sender produceSms(Context mContext){

        return new SmsSender(mContext);
    }
}
