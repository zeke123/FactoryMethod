package com.zhoujian.factorymethod.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.zhoujian.factorymethod.R;
import com.zhoujian.factorymethod.factory.SenderFactory;
import com.zhoujian.factorymethod.impl.Sender;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**

 1、工厂方法模式（Factory Method）

 工厂方法模式分为三种：

 (1)普通工厂模式，就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建

 (2)多个工厂方法模式，是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，
 则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法

 (3)静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。

 (4)工厂模式适用于：凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建。
 静态工厂方法模式最常用

 */

public class MainActivity extends Activity
{

    private Sender mSender;
    private SenderFactory mMSenderFactory;
    @InjectView(R.id.button_one)
    Button mButtonOne;
    @InjectView(R.id.button_two)
    Button mButtonTwo;
    @InjectView(R.id.button_three)
    Button mButtonThree;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        clickEvent();
    }

    private void clickEvent()
    {
        //普通工厂模式
        mButtonOne.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //创建工厂
                mMSenderFactory = new SenderFactory();
                mSender = mMSenderFactory.produceSend(MainActivity.this, "sendmail");
                mSender.send();
            }
        });

        //多个工厂方法模式
        mButtonTwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //创建工厂
                mMSenderFactory = new SenderFactory();
                mSender = mMSenderFactory.produceSmsSend(MainActivity.this);
                mSender.send();
            }
        });

        //静态工厂方法模式
        mButtonThree.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mSender = SenderFactory.produceSms(MainActivity.this);
                mSender.send();
            }
        });
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }
}
