package com.bitcodetech

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.fragment.app.Fragment
import com.bitcodetech.databinding.EditorFragmentBinding

class EditorFragment : Fragment() {

    private lateinit var binding: EditorFragmentBinding

    var text: String = ""
        set(value) {
            field = value
            binding.txtInfo.text = field
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EditorFragmentBinding.inflate(inflater)
        initListeners()
        return binding.root
    }

    interface OnDataEditorListener {
        fun onDataEdited(text: String)
    }

    var onDataEditorListener: OnDataEditorListener? = null

    private fun initListeners() {

        binding.radioLowercase.setOnCheckedChangeListener(
            object : OnCheckedChangeListener {
                override fun onCheckedChanged(cb: CompoundButton?, isChecked: Boolean) {
                    if (isChecked) {
                        text = text.lowercase()
                        //way 1
                        /*(activity as MainActivity).setDataToFormFragment(text)*/

                        //way 2
                        /*(requireActivity().supportFragmentManager.findFragmentById(R.id.formFragment) as FormFragment)
                            .text = text*/
                        /*(parentFragmentManager.findFragmentById(R.id.formFragment) as FormFragment)
                            .text = text*/

                        //way 3 ***
                        onDataEditorListener?.onDataEdited(text)

                    }
                }
            }
        )

        binding.radioUppercase.setOnCheckedChangeListener { button, isChecked ->
            if (isChecked) {
                text = text.uppercase()
                //way 1
                /*(activity as MainActivity).setDataToFormFragment(text)*/

                //way 2
                /*(requireActivity().supportFragmentManager.findFragmentById(R.id.formFragment) as FormFragment)
                            .text = text*/
                /*(parentFragmentManager.findFragmentById(R.id.formFragment) as FormFragment)
                    .text = text*/

                //way 3 ***
                onDataEditorListener?.onDataEdited(text)
            }

        }
    }
}