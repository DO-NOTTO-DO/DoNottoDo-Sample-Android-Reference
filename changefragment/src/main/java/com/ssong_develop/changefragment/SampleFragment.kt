package com.ssong_develop.changefragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.properties.Delegates

/**
 * fragment의 생성과정을 조금 디테일하게 작성해보았습니다.
 *
 * fragment의 create 즉, 생성 단계의 메서드는 onCreate -> onCreateView -> onViewCreated 까지 입니다. (사실 onCreate 은 잘 끼지 않습니다.)
 *
 * onCreate에서는 fragment의 객체(instance)가 생성된 단계를 얘기합니다. -> 그래서 저는 객체가 생성될 때 companion object를 보면 알다 시피 특정 인자(navArgs)를 보냈습니다.
 * 그렇기 떄문에 이 단계에서 받은 값을 확인하고, 원하는 변수들을 초기화 해주고 있습니다.
 *
 * onCreateView에서 유심히 봐야 할 것은 View를 return해주는데 View의 타입이 nullable입니다.
 * 즉, View가 생성될 수도 있고, 모종의 이유로 인해 생성에 실패하는 경우도 있다는 뜻입니다.
 * 그렇기 떄문에, 이 단계에서는 binding을 "생성"하는 작업을 해야하는것이지, 특정 값을 "관찰"한다거나, View를 초기화 한다던가와 같은 작업은 삼가해야 합니다.
 *
 * onViewCreate에서는 param으로 view객체를 받게 되는데, 이는 View 즉, fragment를 보여줄 view (binding)객체가 제대로 생성됨을 의미합니다.
 * 그러므로 "관찰"하거나, 다른 component의 초기화등을 이 장소에서 진행하는 것입니다.
 */
class SampleFragment : Fragment() {

    private var argsNumber: Int? = null
    private lateinit var fragmentText : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        argsNumber = arguments?.getInt(ARG_NO)
        try {
            fragmentText = argsNumber?.let {
                "${it}번쨰 프라그먼트"
            } ?: run {
                throw IllegalArgumentException("제대로 값이 안넘어온 이슈")
            }
        } catch (exception: Exception) {
            // 인자를 제대로 받아내지 못한 것입니다.
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sample, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.text)
        textView.text = fragmentText
    }

    companion object {
        private const val ARG_NO = "ARG_NO"

        fun newInstance(number : Int): SampleFragment {
            val sampleFragment = SampleFragment()
            val args = Bundle()
            args.putInt(ARG_NO,number)
            sampleFragment.arguments = args
            return sampleFragment
        }
    }
}