package com.mkyong;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncryptDecryptController {

    private static final String secretKey = "IT!SC0mP3C@T3d";
    @RequestMapping("/encrypt/{plainStr}")
    public String encrypt(@PathVariable String plainStr) throws Exception{
        CryptoUtil util = new CryptoUtil();
        return util.encrypt(secretKey, plainStr);

    }

    @RequestMapping("/decrypt/{decryptedStr}")
    public String decrypt(@PathVariable String decryptedStr) throws Exception {
        CryptoUtil util = new CryptoUtil();
        return util.decrypt(secretKey, decryptedStr);
    }

    @RequestMapping("/convert/{from}/{to}/{amount}")
    private double getRate(@PathVariable String from, @PathVariable String to,@PathVariable String amount) {
        try {
            URL url = new URL("http://download.finance.yahoo.com/d/quotes.csv?s="+from+to+"=X&f=l1&e=.cs");
            //URL url = new URL("http://api.fixer.io/latest?base=GBP");
            URLConnection con = url.openConnection();
            con.setConnectTimeout(60000);
            con.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.124 Safari/537.36");
            con.setReadTimeout(60000);
            System.setProperty("http.proxyHost", "proxy1.slc.co.uk");
            System.setProperty("http.proxyPort", "8080");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();
            if (line.length() > 0) {
                return Double.parseDouble(line)*Double.parseDouble(amount);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }



}