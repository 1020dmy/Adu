package com.example.myapplication7;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager systemService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        systemService = (SensorManager) getSystemService(SENSOR_SERVICE);
//        getAllSen();
//        //获取方向传感器
//        Sensor defaultSensor = systemService.getDefaultSensor(Sensor.TYPE_ORIENTATION);
//        //注册传感器
//        systemService.registerListener(new Lisl(),defaultSensor,SensorManager.SENSOR_DELAY_NORMAL);
        initGuangXian();
    }

    private void initGuangXian() {
        //获取光线
        Sensor sensor = systemService.getDefaultSensor(Sensor.TYPE_LIGHT);
        //注册
        systemService.registerListener(new Lis2(),sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
    class Lis2 implements SensorEventListener{

        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_LIGHT){
                float value = event.values[0];
                Log.i("147",value+"");
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }

    public class Lisl implements SensorEventListener {

        @Override
        public void onSensorChanged(SensorEvent event) {
            int accuracy = (int) event.values[0];
            Log.i("123",accuracy+"传感器接收到的数据");
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }


    private void getAllSen() {
        //得到传感器
        //得到所有传感器的集合
        List<Sensor> sensorList = systemService.getSensorList(Sensor.TYPE_ALL);
        for (int i = 0; i < sensorList.size(); i++) {
            //遍历没一条数据
            Sensor sensor = sensorList.get(i);
            //名
            String name = sensor.getName();
            //版本号
            int version = sensor.getVersion();
            //厂商
            String vendor = sensor.getVendor();

            Log.i("111",name+version+vendor);

        }

    }
}



