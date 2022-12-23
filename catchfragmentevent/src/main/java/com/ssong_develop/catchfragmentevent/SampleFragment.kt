package com.ssong_develop.catchfragmentevent

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class SampleFragment : Fragment() {

    private var fragmentEventListener: OnFragmentEventListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        /**
         * 여기서 context는 SampleFragment를 띄우는 부모를 얘기합니다.
         *
         * 여기 기준에서는 CatchFragmentEventView라는 activity에서 SampleFragment를 띄우기 때문에 context는 CatchFragmentEventView가 됩니다.
         *
         * 이떄, Listener를 달아 SampleFragment에서 일어나는 이벤트를 activity로 전파시키는 데, activity에서 원하는 Listener를 구현하고 있지 않다면, 이는 작동하지 않기 떄문에
         *
         * 아래와 같은 방식으로 OnFragmentEventListener를 구현했는지 체크를 하고 fragment를 생성하도록 합니다
         */
        if (context is OnFragmentEventListener) {
            fragmentEventListener = context
        } else {
            throw RuntimeException("${context.toString()} need to implementation OnFragmentEventListener")
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
        view.findViewById<Button>(R.id.btn).setOnClickListener {
            fragmentEventListener?.onFragmentInteraction()
        }
    }

    override fun onDetach() {
        fragmentEventListener = null
        super.onDetach()
    }

    interface OnFragmentEventListener {
        fun onFragmentInteraction()
    }
}