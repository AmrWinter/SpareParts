package CustomControl;


/**
 * DO WHAT YOU WANT TO PUBLIC LICENSE
 * Version 2, December 2004
 * <p>
 * Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>
 * <p>
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed as long
 * as the name is changed.
 * <p>
 * DO WHAT YOU WANT TO PUBLIC LICENSE
 * TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 * <p>
 * 0. You just DO WHAT YOU WANT TO.
 */

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.inputmethod.InputMethodManager;


import com.alexforprog.spareparts.R;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * Text view that auto adjusts text size to fit within the view.
 * If the text size equals the minimum text size and still does not
 * fit, append with an ellipsis.
 *
 * @author Chase Colburn
 * @since Apr 4, 2011
 */

public class myEditText3 extends com.rengwuxian.materialedittext.MaterialEditText {

    Context context;

    public myEditText3(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        init();
    }

    public myEditText3(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public myEditText3(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface custom_font = Typeface.createFromAsset(getContext().getAssets(), "fonts/DroidKufi-Regular.ttf");
            this.setTypeface(custom_font);
            this.setAccentTypeface(custom_font);
            this.setBaseColor(ContextCompat.getColor(this.getContext(), R.color.primary));
            this.setPrimaryColor(ContextCompat.getColor(this.getContext(), R.color.primary));
            this.setTextColor(ContextCompat.getColor(this.getContext(), R.color.primary));
            this.setHintTextColor(ContextCompat.getColor(this.getContext(), R.color.primary));
            this.setErrorColor(ContextCompat.getColor(this.getContext(), R.color.primary_dark));
            this.setHelperTextColor(ContextCompat.getColor(this.getContext(), R.color.primary));
            this.setUnderlineColor(ContextCompat.getColor(this.getContext(), R.color.primary));
            this.setFloatingLabelTextColor(ContextCompat.getColor(this.getContext(), R.color.primary));
            this.setFloatingLabel(MaterialEditText.FLOATING_LABEL_HIGHLIGHT);
            this.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
//            this.setIconRight(R.drawable.ic_camera_white);


        }
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if(focused){
//            Toast.makeText(this.getContext(), "got the focus", Toast.LENGTH_LONG).show();
        }else {
//            Toast.makeText(this.getContext(), "lost the focus", Toast.LENGTH_LONG).show();
//            hideSoftKeyboard((Activity)getContext());
        }
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    @Override
    public void setIconLeft(Drawable drawable) {
        super.setIconLeft(drawable);
    }

    @Override
    public void setIconRight(Drawable drawable) {
        super.setIconRight(drawable);
    }


    @Override
    public void setBackgroundDrawable(Drawable background) {
        super.setBackgroundDrawable(background);
    }
}