package com.example.library2.views.viewtreeobserver

import android.annotation.SuppressLint
import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.library2.R

class ViewTreeObserverActivity : AppCompatActivity() {
    var mLinearLayout: LinearLayout? = null
    var mainView: ViewMain? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //set the main layout to our xml file with empty layouts
        setContentView(R.layout.activity_view_tree_observer)

        //get a reference to the interior layout we want to draw on
        mLinearLayout = findViewById<View>(R.id.layoutlinearmain) as LinearLayout

        //instantiate our custom view
        mainView = ViewMain(this)

        //clean up the layout if needed and push our custom view into it
        mLinearLayout!!.removeAllViews()
        mLinearLayout!!.addView(mainView)

        //once the view is ready the layout listener will be called
        mLinearLayout!!.viewTreeObserver.addOnGlobalLayoutListener(mainViewLayoutListener)
    }

    /***
     * this is used so we can get screen size before everything is finished loading
     * and visible on the screen
     */
    var mainViewLayoutListener: OnGlobalLayoutListener = object : OnGlobalLayoutListener {
        @SuppressLint("NewApi")
        override fun onGlobalLayout() {
            val obs = mLinearLayout!!.viewTreeObserver

            //deal with the view tree differently based on Android SDK version
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                obs.removeOnGlobalLayoutListener(this)
            } else {
                obs.removeGlobalOnLayoutListener(this)
            }

            //save what will be the full screen size
            //finish the view startup process now that we know the size
            mainView!!.initialize(Point(mLinearLayout!!.width, mLinearLayout!!.height))
        }
    }
}