package com.bitcodetech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var formFragment : FormFragment
    private lateinit var editorFragment : EditorFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        formFragment = supportFragmentManager.findFragmentById(R.id.formFragment) as FormFragment
        editorFragment = supportFragmentManager.findFragmentById(R.id.editorFragment) as EditorFragment

        formFragment.onFormDataListener = MyOnFormDataListener()
        editorFragment.onDataEditorListener = MyOnDataEditorListener()
    }

    //way 3 **
    inner class MyOnFormDataListener : FormFragment.OnFormDataListener {
        override fun onFormDataAvailable(text: String) {
            mt(text)
            editorFragment.text = text
        }
    }

    //way 3 **
    inner class MyOnDataEditorListener : EditorFragment.OnDataEditorListener {
        override fun onDataEdited(text: String) {
            mt(text)
            formFragment.text = text
        }
    }

    private fun mt(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    //way 1
    fun setDataToEditorFragment(text : String) {
        editorFragment.text = text
    }

    //way 1
    fun setDataToFormFragment(text : String) {
        formFragment.text = text
    }
}