package com.ssong_develop.changefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentManager

/**
 * Frament의 BackStack과 관련된 내용
 *
 * jetpack navigation component를 쓰면 굉장히 간편하게 화면의 움직임을 표현할 수 있지만, 이전에는 이와 같은 방식으로 접근을 했다 정도의 내용으로 접하면 되겠습니다.
 *
 * 하지만, fragment의 생성 시 주의사항은 꼭한번 읽고 fragment를 사용하면 좋습니다.
 *
 */
class ChangeFragmentView : AppCompatActivity() {
    companion object {
        private const val FRAGMENT_TAG = "FRAGMENT_TAG"
        private const val KEY_NUMBER = "KEY_NUMBER"
    }

    private var number = 0
    private val onBackStackChangedListener by lazy {
        FragmentManager.OnBackStackChangedListener {
            val fragmentManager = supportFragmentManager
            number = fragmentManager.fragments.filterNotNull().size
            Log.d("ssong-develop","onBackStackChanged number = ${number}")
        }
    }

    private lateinit var addButton: Button
    private lateinit var removeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_fragment_view)

        val fragmentManager = supportFragmentManager
        addButton = findViewById(R.id.add_btn)
        removeButton = findViewById(R.id.remove_btn)

        addButton.setOnClickListener {
            /**
             * fragmentBackStack에 fragment를 추가합니다
             */
            fragmentManager.beginTransaction()
                .add(R.id.fragment_container, SampleFragment.newInstance(number))
                .addToBackStack(null)
                .commit()
        }

        removeButton.setOnClickListener {
            if (number == 0) {
                Toast.makeText(this,"프라그먼트 백스택이 비어있습니다",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            /**
             * fragmentBackStack에 fragment를 하나 방출합니다.
             */
            fragmentManager.popBackStack()
        }

        fragmentManager.addOnBackStackChangedListener(onBackStackChangedListener)

        /**
         * 만약 처음 시작되는 것이라면, savedInstanceState는 처음 시작시 null이고 onPause에서 state를 만들어줍니다 이후 onStop에서 다시 돌아올 떄 onRestoreInstanceState를 통해서 상태값을 찾아옵니다.
         *
         */
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                .add(R.id.fragment_container,SampleFragment.newInstance(number), FRAGMENT_TAG)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroy() {
        val fragmentManager = supportFragmentManager
        fragmentManager.removeOnBackStackChangedListener(onBackStackChangedListener)
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_NUMBER, number)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        number = savedInstanceState.getInt(KEY_NUMBER)
    }
}