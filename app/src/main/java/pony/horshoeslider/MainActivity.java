package pony.horshoeslider;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import san.radialslider.Slider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Slider slider = (Slider) findViewById(R.id.slider);

        slider.registerForSliderUpdates(new Slider.IListenForSliderState() {
            @Override
            public void onSliderMove(float reading) {

            }

            @Override
            public void onSliderUp(float reading) {

            }

            @Override
            public void onThumbSelected() {

            }
        });
    }
}
