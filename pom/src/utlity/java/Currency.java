/**
 * Created by ASUS on 13/03/2017.
 */
public class Currency {
    String[] currency = {"USD","EUR","THB"};

    public double exchange (String sourceCurrency, double amount, String targetCurrency){

        OUTER:
        {
            for (int i = 0; i < currency.length; i++) {
                if (sourceCurrency == currency[i]) break OUTER;
            }
            return Double.NaN;
        }

        OUTER:
        {
            for (int i = 0; i < currency.length; i++) {
                if (targetCurrency == currency[i]) break OUTER;
            }
            return Double.NaN;
        }

        if(sourceCurrency == targetCurrency){
            return amount;
        }else if (sourceCurrency == "USD"){
            return sourceIsUSD(sourceCurrency,amount,targetCurrency);
        }else if (targetCurrency == "USD"){
            return targetIsUSD(sourceCurrency,amount,targetCurrency);
        }else{
            return bothIsNotUSD(sourceCurrency,amount,targetCurrency);
        }
    }

    private double targetIsUSD (String sourceCurrency, double amount, String targetCurrency){
        if(sourceCurrency=="THB"){
            amount = amount/33.0;
            return amount;
        }else{
            amount = amount / 1.01;
            return amount;
        }
    }

    private double bothIsNotUSD (String sourceCurrency, double amount, String targetCurrency) {
        if (sourceCurrency == "THB") {
            amount = amount / 33.0;
            amount = amount * 1.01;
            return amount;
        }else {
            amount = amount / 1.01;
            amount = amount * 33;
            return amount;
        }
    }

    private double sourceIsUSD (String sourceCurrency, double amount, String targetCurrency){
        if(targetCurrency=="THB"){
            amount = amount * 33.0;
            return amount;
        }else{
            amount = amount * 1.01;
            return amount;
        }
    }
}
