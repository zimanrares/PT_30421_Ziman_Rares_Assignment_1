package logic;

import poly.Polynomial;

import java.util.Map;

public class Ops {

    public static Polynomial add ( Polynomial p1, Polynomial p2){
        Polynomial res = new Polynomial();

        for (Map.Entry<Integer, Double> element : p1.getMep().entrySet()){
            int power = element.getKey();
            if(p2.getMep().containsKey(power)){
                res.getMep().put(power, p2.getMep().get(power) + p1.getMep().get(power));
            }
            else{
                res.getMep().put(power, p1.getMep().get(power));
            }
        }
        for (Map.Entry<Integer, Double> element2 : p2.getMep().entrySet()){
            if (!p1.getMep().containsKey(element2.getKey())){
                res.getMep().put(element2.getKey(), element2.getValue());
            }
        }
        return res;
    }

    public static Polynomial multiply ( Polynomial p1, Polynomial p2){
        Polynomial res = new Polynomial();
        for (Map.Entry<Integer, Double> element : p1.getMep().entrySet()){
            for (Map.Entry<Integer, Double> element2 : p2.getMep().entrySet()){
                int power = element.getKey() + element2.getKey();
                if (res.getMep().containsKey(power)){
                    res.getMep().put(power, res.getMep().get(power) + element.getValue() * element2.getValue());
                }
                else{
                    res.getMep().put(power, element.getValue() * element2.getValue());
                }
            }
        }
        return res;
    }
    public static Polynomial derivative ( Polynomial p1){
        Polynomial res = new Polynomial();
        for (Map.Entry<Integer, Double> element : p1.getMep().entrySet()){
            if (element.getKey() != 0){
                res.getMep().put(element.getKey() - 1, element.getValue() * element.getKey());
            }
        }
        return res;
    }
    public static Polynomial integrate ( Polynomial p1){
        Polynomial res = new Polynomial();
        for (Map.Entry<Integer, Double> element : p1.getMep().entrySet()){
            res.getMep().put(element.getKey() + 1, element.getValue() / (element.getKey() + 1));
        }
        return res;
    }
    public static Polynomial divide ( Polynomial p1, Polynomial p2){
        Polynomial res = new Polynomial();
        Polynomial aux1 = new Polynomial(p1.getMep());
        Polynomial aux2 = new Polynomial(p2.getMep());
        while (!aux1.getMep().isEmpty()){
            int power = aux1.getMep().entrySet().iterator().next().getKey() - aux2.getMep().entrySet().iterator().next().getKey();
            double coefficient = aux1.getMep().entrySet().iterator().next().getValue() / aux2.getMep().entrySet().iterator().next().getValue();
            Polynomial aux3 = new Polynomial();
            aux3.getMep().put(power, coefficient);
            Polynomial aux4 = multiply(aux3, aux2);
            aux1 = add(aux1, aux4);
            res = add(res, aux3);
        }
        return res;
    }
    public static Polynomial subtract ( Polynomial p1, Polynomial p2){
        Polynomial res = new Polynomial();
        for (Map.Entry<Integer, Double> element : p1.getMep().entrySet()){
            int power = element.getKey();
            if(p2.getMep().containsKey(power)){
                res.getMep().put(power, p1.getMep().get(power) - p2.getMep().get(power));
            }
            else{
                res.getMep().put(power, p1.getMep().get(power));
            }
        }
        for (Map.Entry<Integer, Double> element2 : p2.getMep().entrySet()){
            if (!p1.getMep().containsKey(element2.getKey())){
                res.getMep().put(element2.getKey(), -element2.getValue());
            }
        }
        return res;
    }
}
