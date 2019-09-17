package com.rosenfield.mvvmsampleapp.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Switch
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rosenfield.mvvmsampleapp.R
import com.rosenfield.mvvmsampleapp.databinding.ActivityLoginBinding
import com.rosenfield.mvvmsampleapp.enums.StatusConditions
import com.rosenfield.mvvmsampleapp.utils.hide
import com.rosenfield.mvvmsampleapp.utils.show
import com.rosenfield.mvvmsampleapp.utils.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewmodel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        binding.loginviewmodel = viewmodel
        viewmodel.authListener = this
    }

    override fun Status(status: StatusConditions, message: String) {

        when (status) {
            StatusConditions.fail -> {
                progress_bar.visibility = View.GONE

                toast(message)
            }
            StatusConditions.loading -> {
                progress_bar.show()

            }
            StatusConditions.success -> {
                progress_bar.visibility = View.GONE

                toast(message)
            }
        }

    }

    override fun OnSuccess(LoginResponce: LiveData<String>) {
        //progress_bar.hide()
        LoginResponce.observe(this, Observer {
            progress_bar.hide()
            toast(it)
        })
    }
}

