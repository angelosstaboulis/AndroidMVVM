package com.example.assignmentnew.View

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.androidassignmentnew.ViewModel.CreditViewModel
import com.example.assignmentnew.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    val viewModel = CreditViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        lifecycleScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                val textViewID = findViewById<TextView>(R.id.id)
                val textViewUID = findViewById<TextView>(R.id.uid)
                val textViewCreditCardNumber = findViewById<TextView>(R.id.credit_card_number)
                val textViewCreditCardExpiryDate = findViewById<TextView>(R.id.credit_card_expiry_date)
                val textViewCreditCardType = findViewById<TextView>(R.id.credit_card_type)
                viewModel.getData(context = baseContext){
                    textViewID.text = it.id
                    textViewUID.text = it.uid
                    textViewCreditCardNumber.text = it.credit_card_number
                    textViewCreditCardExpiryDate.text = it.credit_card_expiry_date
                    textViewCreditCardType.text = it.credit_card_type
                }

            }
        }
    }
}