package com.bitcodetech

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bitcodetech.databinding.FormFragmentBinding

class FormFragment : Fragment() {

    private lateinit var binding : FormFragmentBinding
    var text : String = ""
    set(value) {
        field = value
        binding.edtInfo.setText(field)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FormFragmentBinding.inflate(inflater)
        initListeners()
        return binding.root

    }

    interface OnFormDataListener {
        fun onFormDataAvailable(text : String)
    }

    var onFormDataListener : OnFormDataListener? = null

    private fun initListeners() {
        binding.btnSetInfo.setOnClickListener {
            //way 1
            /*(activity as MainActivity)
                .setDataToEditorFragment(binding.edtInfo.text.toString())*/

            //way 2
            /*(requireActivity().supportFragmentManager.findFragmentById(R.id.editorFragment) as EditorFragment)
                .text = binding.edtInfo.text.toString()*/
            /*(parentFragmentManager.findFragmentById(R.id.editorFragment) as EditorFragment)
                .text = binding.edtInfo.text.toString()*/

            //Way 3 ***
            onFormDataListener?.onFormDataAvailable(
                binding.edtInfo.text.toString()
            )
        }
    }
}