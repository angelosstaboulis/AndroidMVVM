import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.androidassignmentnew.Model.CreditModel
import org.json.JSONObject

class APIManager {
    fun simpleRequest(context: Context?, callback: (result: CreditModel) -> Unit) {
        val queue = Volley.newRequestQueue(context)
        val url = "https://random-data-api.com/api/v2/credit_cards"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                val getid = response.getString("id")
                val getuid = response.getString("uid")
                val creditcardnumber = response.getString("credit_card_number")
                val creditcardexpirydate =  response.getString("credit_card_expiry_date")
                val creditcardtype = response.getString("credit_card_type")
                val model = CreditModel(id = getid,uid = getuid, credit_card_number = creditcardnumber, credit_card_expiry_date = creditcardexpirydate, credit_card_type = creditcardtype)
                callback(model)
            },
            { error ->
                // TODO: Handle error
            }
        )

        queue.add(jsonObjectRequest)

    }
}