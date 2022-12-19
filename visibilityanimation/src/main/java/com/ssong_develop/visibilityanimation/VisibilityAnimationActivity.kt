package com.ssong_develop.visibilityanimation

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VisibilityAnimationActivity : AppCompatActivity() {

    private lateinit var testTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visibility_animation)
        testTextView = findViewById<TextView>(R.id.test)

        testTextView.setOnClickListener {
            slideDownHide()
        }
    }

    /**
     * sample function to show slideDownHide animation
     */
    private fun slideDownHide() {
        testTextView.animateSlideDown(object : Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator?) {}

            override fun onAnimationEnd(p0: Animator?) {
                testTextView.visibility = View.GONE
            }

            override fun onAnimationCancel(p0: Animator?) {}

            override fun onAnimationRepeat(p0: Animator?) {}
        })
    }

    /**
     * sample function to show slideUpHide animation
     */
    private fun slideUpHide() {
        testTextView.animateSlideUp(
            object : Animator.AnimatorListener {
                override fun onAnimationStart(p0: Animator?) {}

                override fun onAnimationEnd(p0: Animator?) {
                    testTextView.visibility = View.GONE
                }

                override fun onAnimationCancel(p0: Animator?) {}

                override fun onAnimationRepeat(p0: Animator?) {}
            }
        )
    }
}

/** view gone with animate slide up **/
fun View.animateSlideUp(animatorListener: AnimatorListener) {
    this.animate()
        .translationY(-(this.height.toFloat()))
        .alpha(0f)
        .setListener(animatorListener)
}

/** view gone with animate slide down **/
fun View.animateSlideDown(animatorListener: AnimatorListener) {
    this.animate()
        .translationY(this.height.toFloat())
        .alpha(0f)
        .setListener(animatorListener)
}