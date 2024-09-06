package com.invcd.design.currency;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import org.codehaus.jettison.json.JSONException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConverter {

    @Cacheable
    @RequestMapping("/converter")
    @GetMapping
    public String getConvertedValue(@RequestParam(value="fromamount") BigDecimal value,
            @RequestParam(value="fromcurr") String fromCountry, @RequestParam(value="targetcurr") String toCountry)
            throws IOException, InterruptedException, JSONException {
        NumberFormat fromFormat = NumberFormat.getCurrencyInstance(new Locale("",fromCountry));
        NumberFormat toFormat = NumberFormat.getCurrencyInstance(new Locale("",toCountry));

        return toFormat.format(value.multiply(new BigDecimal(
                new CurrencyFactory().getRate(fromFormat.getCurrency().getCurrencyCode(),
                        toFormat.getCurrency().getCurrencyCode()))));
    }
}
