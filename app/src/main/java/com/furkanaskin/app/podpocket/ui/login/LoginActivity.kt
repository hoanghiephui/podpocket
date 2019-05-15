package com.furkanaskin.app.podpocket.ui.login

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.Observable
import com.furkanaskin.app.podpocket.R
import com.furkanaskin.app.podpocket.core.BaseActivity
import com.furkanaskin.app.podpocket.core.Constants
import com.furkanaskin.app.podpocket.databinding.ActivityLoginBinding
import com.furkanaskin.app.podpocket.ui.dashboard.DashboardActivity
import com.jaychang.st.SimpleText
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.doAsync

/**
 * Created by Furkan on 14.04.2019
 */

class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>(LoginViewModel::class.java) {
    override fun getLayoutRes(): Int = R.layout.activity_login

    override fun initViewModel(viewModel: LoginViewModel) {
        binding.viewModel = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()

        val simpleText = SimpleText.from(getString(R.string.agreement))
                .first(getString(R.string.agreement_part_first))
                .textColor(R.color.colorPrimary)
                .pressedTextColor(R.color.colorPrimary)
                .onClick(textViewAgreement) { text, range, tag ->
                    showAgreementDialog()
                }
                .first(getString(R.string.agreement_part_second))
                .textColor(R.color.colorPrimary)
                .pressedTextColor(R.color.colorPrimary)
                .onClick(textViewAgreement) { text, range, tag ->
                    showAgreementDialog()
                }
                .first(getString(R.string.agreement_part_third))
                .textColor(R.color.textColor)
                .pressedTextColor(R.color.colorPrimary)
                .onClick(textViewAgreement) { text, range, tag ->
                    showAgreementDialog()
                }
                .first(getString(R.string.agreement_part_fourth))
                .textColor(R.color.colorPrimary)
                .pressedTextColor(R.color.colorPrimary)
                .onClick(textViewAgreement) { text, range, tag ->
                    showAgreementDialog()
                }


        textViewAgreement.text = simpleText

        viewModel.registerSuccess.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                showRegisterSuccessDialog()
                viewModel.setType(Constants.LoginActivityType.LOGIN_TYPE)
            }

        })

        viewModel.loginSuccess.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
                runOnUiThread {
                    startActivity(intent)
                    finish()
                }


            }

        })

    }

    private fun init() {
        val viewType = intent.getIntExtra(Constants.IntentName.LOGIN_ACTIVITY_TYPE, Constants.LoginActivityType.LOGIN_TYPE)
        viewModel.setType(viewType)
    }

    private fun showAgreementDialog() {
        AlertDialog.Builder(this)
                .setMessage(R.string.agreement_message)
                .setNeutralButton("Tamam"
                ) { dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.cancel()
                }
                .create()
                .show()
    }

    private fun showRegisterSuccessDialog() {
        AlertDialog.Builder(this)
                .setMessage(R.string.register_success_dialog)
                .setNeutralButton("Tamam"
                ) { dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.cancel()
                }
                .create()
                .show()
    }

}