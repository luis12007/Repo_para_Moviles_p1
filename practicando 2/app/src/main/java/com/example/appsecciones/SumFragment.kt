package com.example.appsecciones

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import java.lang.ClassCastException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_SUM1 = "param1"
private const val ARG_SUM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SumFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SumFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var sum1: Int? = null
    private var sum2: Int? = null

    //var para listener
    private var listener : OnActionListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? OnActionListener
        if (listener == null)
            throw ClassCastException("$context must no sé")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            sum1 = it.getInt(ARG_SUM1, 0)
            sum2 = it.getInt(ARG_SUM2, 0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sum, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sumando1TextView: TextView = view.findViewById(R.id.textView1)
        val sumando2TextView: TextView = view.findViewById(R.id.textView2)
        val sumando3TextView: TextView = view.findViewById(R.id.textView3)
        val result = (sum1?.plus(sum2!!))?:0
        sumando1TextView.text = sum1.toString()
        sumando2TextView.text = sum2.toString()
        sumando3TextView.text = result.toString()

        val Actionbutton: Button = view.findViewById(R.id.Action_button)
        Actionbutton.setOnClickListener{
            listener?.onActionClick(result)
        }
    }

    interface OnActionListener{
        fun onActionClick(result:Int)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param sum1 Parameter 1.
         * @param sum2 Parameter 2.
         * @return A new instance of fragment SumFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(sum1: Int, sum2: Int) =
            SumFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SUM1, sum1)
                    putInt(ARG_SUM2, sum2)
                }
            }
    }
}