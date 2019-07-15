package com.example.currencyshowapp.service;

import com.example.currencyshowapp.model.Currency;
import com.example.currencyshowapp.model.Rate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.rmi.runtime.Log;

import java.util.List;

@Service
public class NbpService implements CurrencyService {

    @Override
    public Currency getCurrency(String code) {
        String apiPath = "http://api.nbp.pl/api/exchangerates/rates/C/" + code + "/?format=json";
        return new RestTemplate().getForObject(apiPath, Currency.class);
    }

    @Override
    public Currency getLastExchanges(String currency, int days) {
        String apiPath = "http://api.nbp.pl/api/exchangerates/rates/C/" + currency + "/last/" + days + "/?format=json";
        return new RestTemplate().getForObject(apiPath, Currency.class);
    }

    @Override
    public Currency getAllCurrencies() {
        return null;
    }

//    @Override
//    public List<Currency> getAllCurrencies() {
//        String apiPath = "http://api.nbp.pl/api/exchangerates/tables/A/?format=json";
//        return new RestTemplate().getForObject(apiPath, Currency.class);
//    }

    public void onSuccess() {
        try {
            JSONArray jsonArr = new JSONArray("http://api.nbp.pl/api/exchangerates/tables/A/?format=json");
            JSONObject jsonObj = jsonArr.getJSONObject(0);
            //this jsonObj holds the first jsonObject of your response

            JSONArray rateList = jsonObj.getJSONArray("rates");
            //rateList has the list of rates you obtained

            //NOW, to get all mids for this rate list

            for (int i = 0; i < rateList.length(); i++) {
                JSONObject jO = rateList.getJSONObject(i);
                Double mid = jO.getDouble("mid");
                //Double gbpcode = jO.getString("code");
                System.out.println(mid);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void parseJson(StringBuffer sb) throws JSONException {

        JSONObject obj = new JSONObject(sb.toString());


        JSONArray arr = obj.getJSONArray("rates");

        for (int i = 0; i < arr.length(); i++) {
            System.out.println(arr.getJSONObject(i).getString("mid"));
        }
    }
}
