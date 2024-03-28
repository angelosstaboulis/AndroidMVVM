package com.example.androidassignmentnew.ViewModel

import APIManager
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.androidassignmentnew.Model.CreditModel

class CreditViewModel {

    fun getData(context: Context, callback: (result: CreditModel) -> Unit){

        val modelCredit = MutableLiveData<CreditModel>()

        val api = APIManager()
        api.simpleRequest(context = context){
            val getid = it.id
            val getuid = it.uid
            val creditcardnumber = it.credit_card_number
            val creditcardexpirydate =  it.credit_card_expiry_date
            val creditcardtype = it.credit_card_type
            val model = CreditModel(id = getid,uid = getuid, credit_card_number = creditcardnumber, credit_card_expiry_date = creditcardexpirydate, credit_card_type = creditcardtype)
            modelCredit.value = model
            callback(model)
        }
    }
}