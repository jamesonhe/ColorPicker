package wang.relish.colorpicker.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import wang.relish.colorpicker.ColorPickerDialog;

public class MainActivity extends AppCompatActivity {


    private View mRootView;

    private int mRed, mGreen, mBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootView = findViewById(R.id.rootView);
        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = mRootView.getDrawingCacheBackgroundColor();
                mRed = (color & 0xff0000) >> 16;
                mGreen = (color & 0x00ff00) >> 8;
                mBlue = (color & 0x0000ff);
                ColorPickerDialog dialog = ColorPickerDialog.getInstance(mRed, mGreen, mBlue);
                dialog.setOnColorSelectCompletedListener(new ColorPickerDialog.OnColorSelectCompletedListener() {
                    @Override
                    public void onColorSelectCompleted(ColorPickerDialog dialog, int r, int g, int b) {
                        mRed = r;
                        mGreen = g;
                        mBlue = b;
                        int color = Color.rgb(r, g, b);
                        mRootView.setBackgroundColor(color);
                    }
                });
                dialog.show(getSupportFragmentManager(), "");
            }
        });
    }
}
