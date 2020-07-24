package com.android.fonttextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

public class FontTextView extends AppCompatTextView {

    private String typefaceName;

    public FontTextView(Context context) {
        this(context, null);
    }

    public FontTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FontTextView);
        if (ta != null) {
            typefaceName = ta.getString(R.styleable.FontTextView_typefaceName);
            ta.recycle();
        }
        setTypface(this, typefaceName);
    }

    /**
     * 设置字体
     *
     * @param textView     需要设置字体的tv
     * @param typefaceNmae 字体的全名  需要放在assets里
     */
    private void setTypface(TextView textView, String typefaceNmae) {
        if (textView == null || TextUtils.isEmpty(typefaceNmae)) {
            return;
        }
        try {
            Typeface fromAsset = Typeface.createFromAsset(getContext().getAssets(), typefaceNmae);
            if (fromAsset != null) {
                textView.setTypeface(fromAsset);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
