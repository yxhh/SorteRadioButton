package com.yw.my.sorteradiobutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by yw on 17-8-23.
 */

public class SortButton extends RelativeLayout {
    private TextView textView;
    private ImageView upArrow, downArrow;

    public SortButton(Context context) {
        super(context);
        init(context, null);
    }

    public SortButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public SortButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SortButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.sort_radio_button, this);
            textView = (TextView) view.findViewById(R.id.sort_radiobutton);
            upArrow = (ImageView) view.findViewById(R.id.sort_up);
            downArrow = (ImageView) view.findViewById(R.id.sort_down);
            TypedArray mTypeArray = getContext().obtainStyledAttributes(attrs, R.styleable.SortRadioButton);

            String radioText = mTypeArray.getString(R.styleable.SortRadioButton_uiText);
            if (!TextUtils.isEmpty(radioText)) {
                textView.setText(radioText);
            }
            int radioTextSize = (int) mTypeArray.getDimension(R.styleable.SortRadioButton_uiTextSize, -1);
            if (radioTextSize != -1) {
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, radioTextSize);
            }
            int radioTextColor = mTypeArray.getColor(R.styleable.SortRadioButton_uiTextColor, -1);
            if (radioTextColor != -1) {
                textView.setTextColor(radioTextColor);
            }
            int upIconResource = mTypeArray.getResourceId(R.styleable.SortRadioButton_uiUpIcon, -1);
            if (upIconResource != -1) {
                upArrow.setImageResource(upIconResource);
            }
            int downIconResource = mTypeArray.getResourceId(R.styleable.SortRadioButton_uiDownIcon, -1);
            if (downIconResource != -1) {
                downArrow.setImageResource(downIconResource);
            }
            boolean isShowArrow = mTypeArray.getBoolean(R.styleable.SortRadioButton_isShowArrow, true);
            if (isShowArrow) {
                upArrow.setVisibility(VISIBLE);
                downArrow.setVisibility(VISIBLE);
            } else {
                downArrow.setVisibility(GONE);
                upArrow.setVisibility(GONE);
            }
            boolean selected = mTypeArray.getBoolean(R.styleable.SortRadioButton_selected, false);
            if (selected) {
                textView.setSelected(true);
                upArrow.setSelected(true);
            }
            mTypeArray.recycle();
        }
    }

    public TextView getTextView() {
        return textView;
    }

    public void setStateUp() {
        textView.setSelected(true);
        upArrow.setSelected(true);
        downArrow.setSelected(false);
    }

    public void setStateDown() {
        textView.setSelected(true);
        upArrow.setSelected(false);
        downArrow.setSelected(true);
    }

    public void clearState() {
        upArrow.setSelected(false);
        downArrow.setSelected(false);
        textView.setSelected(false);
    }
}
