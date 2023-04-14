package poly;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {

    private Map<Integer, Double> mep;

    public Polynomial(Map<Integer, Double> mep) {
        this.mep = mep;
    }

    public Polynomial() {
        this.mep = new HashMap<>();
    }

    public Map<Integer, Double> getMep() {
        return mep;
    }

    public void setMep(Map<Integer, Double> mep) {
        this.mep = mep;
    }

    public Polynomial(String s) {
        this.mep = new HashMap<>();
        fromString(s);
    }

    public void fromString(String s) {
        Pattern pattern = Pattern.compile("((\\+|-)?\\d*)?x?(\\^?(\\d*))?");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            if(matcher.group(0).length()>0) {
                int power;
                double coefficient ;
                if(matcher.group(1).equals("+") || matcher.group(1).length()==0)
                    coefficient = 1;
                else if(matcher.group(1).equals("-"))
                    coefficient = -1;
                else
                    coefficient = Double.parseDouble(matcher.group(1));

                if(matcher.group(4).length()==0){
                    power = 0;
                    if(matcher.group(0).contains("x"))
                        power = 1;
                }
                else
                    power = Integer.parseInt(matcher.group(4));
                System.out.println(Double.toString(coefficient) + "x^" + Integer.toString(power));
                this.addTerm(power, coefficient);
            }


        }



    }

    public void addTerm(int power, double coefficient) {
        if (mep.containsKey(power)) {
            mep.put(power, mep.get(power) + coefficient);
        } else {
            mep.put(power, coefficient);
        }
    }

    public String toString() {
        String string = "";
        String[] in = new String[100];
        int i = 0;
        for (Map.Entry<Integer, Double> element : this.getMep().entrySet()) {
            String aux;
            if (element.getValue() != 0) {
                if (element.getKey() == 0)
                    aux = element.getValue().toString();
                else if (element.getKey() != 1)
                    aux = element.getValue().toString() + "x^" + element.getKey().toString();
                else
                    aux = element.getValue().toString() + "x";
                if (element.getValue() > 0)
                    aux = "+" + aux;
                string =aux + string;
            }
        }
        System.out.println(string);
        return string;
    }
}


