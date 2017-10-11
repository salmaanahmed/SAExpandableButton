package com.interconn.salmaanahmed.saexpandablebutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Salmaan Ahmed on 10/10/2017.
 * Expandable button is used to expand and collapse a child view which can be anything
 * It should be passed a child view which will automatically hide and show on button click
 * It also have expand and collapse listener which can be used for some events
 */

public class ExpandableButton extends FrameLayout {

    /**
     * Interface for callbacks and listener
     */
    public interface ExpandableButtonListener {
        void onViewExpanded();
        void onViewCollapsed();
    }

    Context context;            //context
    TextView textView;          //text view
    ImageView imageArrow;       //image arrow
    View viewColor;             //strip color

    int childViewResId = 0;
    View childView;

    ExpandableButtonListener expandableButtonListener = null;


//    public ExpandableButton(@NonNull Context context) {
//        super(context);
//        initButton(context, null);
//    }

    public ExpandableButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initButton(context, attrs);
    }

//    public ExpandableButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        initButton(context, attrs);
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    public ExpandableButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//        initButton(context, attrs);
//    }

    /**
     * Initialize button on every constructor call.
     * Used to reference views and set attributes to the view.
     * @param context context
     * @param attrs attribute set for setting some properties
     */
    private void initButton(Context context, AttributeSet attrs) {
        this.context = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.expandable_button, this);
        textView = view.findViewById(R.id.tv_text);
        imageArrow = view.findViewById(R.id.iv_arrow);
        viewColor = view.findViewById(R.id.view_color);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.ExpandableButton, 0, 0);

        try {
            childViewResId = typedArray.getResourceId(R.styleable.ExpandableButton_childView, 0);
            setBarColor(typedArray.getColor(R.styleable.ExpandableButton_color, 0));
            setText(typedArray.getString(R.styleable.ExpandableButton_text));
            setIcon(typedArray.getDrawable(R.styleable.ExpandableButton_icon));
        } finally {
            typedArray.recycle();
        }
        setClickListener();
    }

    /**
     * Set text to expandable button
     * @param text string text
     */
    public void setText(String text) {
        textView.setText(text);
    }

    /**
     * Set color to bar on left side of the button
     * User can set color anytime to this view as indicators
     * @param color color of bar
     */
    public void setBarColor(int color) {
        if (color != 0) viewColor.setBackgroundColor(color);
    }

    /**
     * User can set any icon as arrow
     * @param icon drawable
     */
    public void setIcon(Drawable icon) {
        if (icon != null) imageArrow.setImageDrawable(icon);
    }

    public void setCallbackListener(ExpandableButtonListener expandableButtonListener) {
        this.expandableButtonListener = expandableButtonListener;
    }

    /**
     * Setting up the click listener
     */
    private void setClickListener() {
        this.setClickable(true);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onClicked();
            }
        });
    }

    /**
     * Toggle view visibility on click listener and fire callbacks
     */
    private void onClicked() {
        rotateArrow();
        if (childView.getVisibility() == GONE) {
            childView.setVisibility(VISIBLE);
            if (expandableButtonListener != null) expandableButtonListener.onViewExpanded();
        } else {
            childView.setVisibility(GONE);
            if (expandableButtonListener != null) expandableButtonListener.onViewCollapsed();
        }
    }

    private void rotateArrow() {
        if (imageArrow.getRotation() == 0) imageArrow.animate().rotation(180).start();
        else imageArrow.animate().rotation(0).start();
    }

    /**
     * Get child view on this method
     * Have to wait until the view is attached to window
     */
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (childViewResId != 0) {
            childView = getRootView().findViewById(childViewResId);
            childView.setVisibility(GONE);
        }
    }
}
