
package com.example.rangebarsample;

import com.appyvet.rangebar.RangeBar;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity implements ColorPickerDialog.OnColorChangedListener {

    // Sets the initial values such that the image will be drawn
    private static final int INDIGO_500 = 0xff3f51b5;

    // Sets variables to save the colors of each attribute
    private int mBarColor;

    private int mConnectingLineColor;

    private int mPinColor;

    // Initializes the RangeBar in the application
    private RangeBar rangebar;

    // Saves the state upon rotating the screen/restarting the activity
    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("BAR_COLOR", mBarColor);
        bundle.putInt("CONNECTING_LINE_COLOR", mConnectingLineColor);
    }

    // Restores the state upon rotating the screen/restarting the activity
    @Override
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        mBarColor = bundle.getInt("BAR_COLOR");
        mConnectingLineColor = bundle.getInt("CONNECTING_LINE_COLOR");

        // Change the text colors to the appropriate colors, and the text as
        // well
        colorChanged(Component.BAR_COLOR, mBarColor);
        colorChanged(Component.CONNECTING_LINE_COLOR, mConnectingLineColor);

        // Gets the RangeBar
        rangebar = (RangeBar) findViewById(R.id.rangebar1);

        // Gets the index value TextViews
        final TextView leftIndexValue = (TextView) findViewById(R.id.leftIndexValue);
        final TextView rightIndexValue = (TextView) findViewById(R.id.rightIndexValue);
        // Resets the index values every time the activity is changed
        leftIndexValue.setText("" + rangebar.getLeftIndex());
        rightIndexValue.setText("" + rangebar.getRightIndex());

        // Sets focus to the main layout, not the index text fields
        findViewById(R.id.mylayout).requestFocus();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Removes title bar and sets content view
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        // Sets fonts for all
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Thin.ttf");
        ViewGroup root = (ViewGroup) findViewById(R.id.mylayout);
        setFont(root, font);

        // Gets the buttons references for the buttons
        final Button barColor = (Button) findViewById(R.id.barColor);
        final Button connectingLineColor = (Button) findViewById(R.id.connectingLineColor);
        final Button pinColor = (Button) findViewById(R.id.pinColor);
        final TextView indexButton = (TextView) findViewById(R.id.setIndex);
        final TextView valueButton = (TextView) findViewById(R.id.setValue);

        //Sets the buttons to bold.
        indexButton.setTypeface(font, Typeface.BOLD);
        barColor.setTypeface(font,Typeface.BOLD);
        connectingLineColor.setTypeface(font,Typeface.BOLD);
        pinColor.setTypeface(font, Typeface.BOLD);

        // Gets the RangeBar
        rangebar = (RangeBar) findViewById(R.id.rangebar1);

        // Setting Index Values -------------------------------

        // Gets the index value TextViews
        final EditText leftIndexValue = (EditText) findViewById(R.id.leftIndexValue);
        final EditText rightIndexValue = (EditText) findViewById(R.id.rightIndexValue);

        // Sets the display values of the indices
        rangebar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onIndexChangeListener(RangeBar rangeBar, int leftThumbIndex,
                    int rightThumbIndex,
                    String leftThumbValue, String rightThumbValue) {
                leftIndexValue.setText("" + leftThumbIndex);
                rightIndexValue.setText("" + rightThumbIndex);
            }
        });

        // Sets the indices themselves upon input from the user
        indexButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Gets the String values of all the texts
                String leftIndex = leftIndexValue.getText().toString();
                String rightIndex = rightIndexValue.getText().toString();

                // Catches any IllegalArgumentExceptions; if fails, should throw
                // a dialog warning the user
                try {
                    if (!leftIndex.isEmpty() && !rightIndex.isEmpty()) {
                        int leftIntIndex = Integer.parseInt(leftIndex);
                        int rightIntIndex = Integer.parseInt(rightIndex);
                        rangebar.setThumbIndices(leftIntIndex, rightIntIndex);
                    }
                } catch (IllegalArgumentException e) {
                }
            }
        });

        // Sets the indices by values based upon input from the user
        valueButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Gets the String values of all the texts
                String leftValue = leftIndexValue.getText().toString();
                String rightValue = rightIndexValue.getText().toString();

                // Catches any IllegalArgumentExceptions; if fails, should throw
                // a dialog warning the user
                try {
                    if (!leftValue.isEmpty() && !rightValue.isEmpty()) {
                        float leftIntIndex = Float.parseFloat(leftValue);
                        float rightIntIndex = Float.parseFloat(rightValue);
                        rangebar.setThumbValues(leftIntIndex, rightIntIndex);
                    }
                } catch (IllegalArgumentException e) {
                }
            }
        });

        // Setting Number Attributes -------------------------------

        // Sets tickStart
        final TextView tickStart = (TextView) findViewById(R.id.tickStart);
        SeekBar tickStartSeek = (SeekBar) findViewById(R.id.tickStartSeek);
        tickStartSeek.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar tickCountSeek, int progress, boolean fromUser) {
                try {
                    rangebar.setTickStart(progress);
                } catch (IllegalArgumentException e) {
                }
                tickStart.setText("tickStart = " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // Sets tickEnd
        final TextView tickEnd = (TextView) findViewById(R.id.tickEnd);
        SeekBar tickEndSeek = (SeekBar) findViewById(R.id.tickEndSeek);
        tickEndSeek.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar tickCountSeek, int progress, boolean fromUser) {
                try {
                    rangebar.setTickEnd(progress);
                } catch (IllegalArgumentException e) {
                }
                tickEnd.setText("tickEnd = " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // Sets tickInterval
        final TextView tickInterval = (TextView) findViewById(R.id.tickInterval);
        SeekBar tickIntervalSeek = (SeekBar) findViewById(R.id.tickIntervalSeek);
        tickIntervalSeek.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar tickCountSeek, int progress, boolean fromUser) {
                try {
                    rangebar.setTickInterval(progress / 10.0f);
                } catch (IllegalArgumentException e) {
                }
                tickInterval.setText("tickInterval = " + progress / 10.0f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // Sets barWeight
        final TextView barWeight = (TextView) findViewById(R.id.barWeight);
        SeekBar barWeightSeek = (SeekBar) findViewById(R.id.barWeightSeek);
        barWeightSeek.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar barWeightSeek, int progress, boolean fromUser) {
                rangebar.setBarWeight(progress);
                barWeight.setText("barWeight = " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // Sets connectingLineWeight
        final TextView connectingLineWeight = (TextView) findViewById(R.id.connectingLineWeight);
        SeekBar connectingLineWeightSeek = (SeekBar) findViewById(R.id.connectingLineWeightSeek);
        connectingLineWeightSeek.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar connectingLineWeightSeek, int progress, boolean fromUser) {
                rangebar.setConnectingLineWeight(progress);
                connectingLineWeight.setText("connectingLineWeight = " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // Sets thumbRadius
        final TextView thumbRadius = (TextView) findViewById(R.id.thumbRadius);
        SeekBar thumbRadiusSeek = (SeekBar) findViewById(R.id.thumbRadiusSeek);
        thumbRadiusSeek.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar thumbRadiusSeek, int progress, boolean fromUser) {
                if (progress == 0) {
                    rangebar.setThumbRadius(-1);
                    thumbRadius.setText("thumbRadius = N/A");
                }
                else {
                    rangebar.setThumbRadius(progress);
                    thumbRadius.setText("thumbRadius = " + progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // Setting Color Attributes---------------------------------

        // Sets barColor
        barColor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                initColorPicker(Component.BAR_COLOR, mBarColor, mBarColor);
            }
        });

        // Sets connectingLineColor
        connectingLineColor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                initColorPicker(Component.CONNECTING_LINE_COLOR, mConnectingLineColor, mConnectingLineColor);
            }
        });

        // Sets pinColor
        pinColor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                initColorPicker(Component.PIN_COLOR, mPinColor, mPinColor);
            }
        });

    }

    /**
     * Sets the changed color using the ColorPickerDialog.
     * 
     * @param component Component specifying which input is being used
     * @param newColor Integer specifying the new color to be selected.
     */
    @Override
    public void colorChanged(Component component, int newColor) {

        String hexColor = String.format("#%06X", (0xFFFFFF & newColor));

        switch (component)
        {
            case BAR_COLOR:
                mBarColor = newColor;
                rangebar.setBarColor(newColor);
                final TextView barColorText = (TextView) findViewById(R.id.barColor);
                barColorText.setText("barColor = " + hexColor);
                barColorText.setTextColor(newColor);
                break;

            case CONNECTING_LINE_COLOR:
                mConnectingLineColor = newColor;
                rangebar.setConnectingLineColor(newColor);
                final TextView connectingLineColorText = (TextView) findViewById(R.id.connectingLineColor);
                connectingLineColorText.setText("connectingLineColor = " + hexColor);
                connectingLineColorText.setTextColor(newColor);
                break;

            case PIN_COLOR:
                mPinColor = newColor;
                final TextView pinColorText = (TextView) findViewById(R.id.pinColor);

                if (newColor == -1) {
                    pinColorText.setText("pinColor = N/A");
                    pinColorText.setTextColor(INDIGO_500);
                }
                else {
                    pinColorText.setText("pinColor = " + hexColor);
                    pinColorText.setTextColor(newColor);
                }
                break;
        }
    }

    /**
     * Sets the font on all TextViews in the ViewGroup. Searches recursively for
     * all inner ViewGroups as well. Just add a check for any other views you
     * want to set as well (EditText, etc.)
     */
    private void setFont(ViewGroup group, Typeface font) {
        int count = group.getChildCount();
        View v;
        for (int i = 0; i < count; i++) {
            v = group.getChildAt(i);
            if (v instanceof TextView || v instanceof EditText || v instanceof Button) {
                ((TextView) v).setTypeface(font);
            } else if (v instanceof ViewGroup)
                setFont((ViewGroup) v, font);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Initiates the colorPicker from within a button function.
     * 
     * @param component Component specifying which input is being used
     * @param initialColor Integer specifying the initial color choice. *
     * @param defaultColor Integer specifying the default color choice.
     */
    private void initColorPicker(Component component, int initialColor, int defaultColor)
    {
        ColorPickerDialog colorPicker = new ColorPickerDialog(this,
                                                              this,
                                                              component,
                                                              initialColor,
                                                              defaultColor);
        colorPicker.show();

    }

}
