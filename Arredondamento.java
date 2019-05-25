package arredondamento;

/**
 *
 * @author joaobonsengno
 */
public class Arredondamento {
    public static String arredondarValor(String valor){
        valor = tornarCompativel(valor);
        Integer flag = 0;
        StringBuilder builderValor = new StringBuilder(valor);
        try{
            if(valor.endsWith("1")|valor.endsWith("2")){
                //Verifica se a String termina com 1 ou 2, para arredondar para baixo
                String modificada = valor.substring(0, valor.length()-1);
                builderValor = new StringBuilder(modificada);
                builderValor.append("0");
            }else if(valor.endsWith("3")|valor.endsWith("4")|valor.endsWith("6")|valor.endsWith("7")){
                //Verifica se a String termina com 3, 4, 6 ou 7 para arredondar para baixo (5)
                String modificada = valor.substring(0, valor.length()-1);
                builderValor = new StringBuilder(modificada);
                builderValor.append("5");
            }else if(valor.endsWith("8")|valor.endsWith("9")){
                //Verifica se a String termina com 8 ou 9, para arredondar para cima
                int j = valor.length();
                j -= 2;
                //Pega x.Xx
                Character penultimo = valor.charAt(j);
                String t = Character.toString(penultimo);
                Integer inteiro = Integer.parseInt(t);
                if(inteiro==9){
                    //Valor x.98 ou x.99
                    j = valor.length();
                    j -= 4;
                    //Pega X.xx
                    penultimo = valor.charAt(j);
                    t = Character.toString(penultimo);
                    inteiro = Integer.parseInt(t);
                    if(inteiro==9){
                        //Valor x9.98 ou x9.99
                        flag = 1;
                        j = valor.length();
                        j -= 5;
                        //Pega Xx.xx
                        penultimo = valor.charAt(j);
                        t = Character.toString(penultimo);
                        inteiro = Integer.parseInt(t);
                        if(inteiro==9){
                            //Valor 99.98 ou 99.99
                            flag = 2;
                            j = valor.length();
                            j -= 6;
                            //Pega Xxx.xx
                            penultimo = valor.charAt(j);
                            t = Character.toString(penultimo);
                            inteiro = Integer.parseInt(t);
                            if(inteiro==9){
                                //Valor 999.98 ou 999.99
                                flag = 3;
                                j = valor.length();
                                j -= 7;
                                //Pega Xxxx.xx
                                penultimo = valor.charAt(j);
                                t = Character.toString(penultimo);
                                inteiro = Integer.parseInt(t);
                                if(inteiro==9){
                                    //Valor 9999.98 ou 9999.99
                                    flag = 4;
                                    j = valor.length();
                                    j -= 8;
                                    //Pega Xxxx.xx
                                    penultimo = valor.charAt(j);
                                    t = Character.toString(penultimo);
                                    inteiro = Integer.parseInt(t);
                                    if(inteiro==9){
                                        //Valor 99999.98 ou 99999.99
                                        flag = 5;
                                        j = valor.length();
                                        j -= 9;
                                        //Pega Xxxxxx.xx
                                        penultimo = valor.charAt(j);
                                        t = Character.toString(penultimo);
                                        inteiro = Integer.parseInt(t);
                                    }else{
                                        //Valor x79999.98 ou x79999.99, por exemplo
                                        inteiro += 1;
                                        t = Integer.toString(inteiro);
                                        String modificada = valor.substring(0, valor.length()-8);
                                        builderValor = new StringBuilder(modificada);
                                        builderValor.append(t);
                                        builderValor.append("0000.00");
                                    }
                                }else{
                                    //Valor x7999.98 ou x7999.99, por exemplo
                                    inteiro += 1;
                                    t = Integer.toString(inteiro);
                                    String modificada = valor.substring(0, valor.length()-7);
                                    builderValor = new StringBuilder(modificada);
                                    builderValor.append(t);
                                    builderValor.append("000.00");
                                }
                            }else{
                                //Valor x799.98 ou x799.99, por exemplo
                                inteiro += 1;
                                t = Integer.toString(inteiro);
                                String modificada = valor.substring(0, valor.length()-6);
                                builderValor = new StringBuilder(modificada);
                                builderValor.append(t);
                                builderValor.append("00.00");
                            }
                        }else{
                            //Valor 799.98 ou 799.99, por exemplo
                            inteiro += 1;
                            t = Integer.toString(inteiro);
                            String modificada = valor.substring(0, valor.length()-5);
                            builderValor = new StringBuilder(modificada);
                            builderValor.append(t);
                            builderValor.append("0.00");
                        }
                    }else{
                        //Valor x7.98 ou x7.99, por exemplo
                        inteiro += 1;
                        t = Integer.toString(inteiro);
                        String modificada = valor.substring(0, valor.length()-4);
                        builderValor = new StringBuilder(modificada);
                        builderValor.append(t);
                        builderValor.append(".00");
                    }
                }else{
                    //Valor x.79, por exemplo
                    inteiro += 1;
                    t = Integer.toString(inteiro);
                    String modificada = valor.substring(0, valor.length()-2);
                    builderValor = new StringBuilder(modificada);
                    builderValor.append(t);
                    builderValor.append("0");
                }
            }
        }catch(java.lang.IndexOutOfBoundsException ex){
            System.out.println(ex);
            if (flag == 1){
                String modificada = "";
                builderValor = new StringBuilder(modificada);
                builderValor.append("10.00");
            }else if (flag == 2){
                String modificada = "";
                builderValor = new StringBuilder(modificada);
                builderValor.append("100.00");
            }else if (flag == 3){
                String modificada = "";
                builderValor = new StringBuilder(modificada);
                builderValor.append("1000.00");
            }else if (flag == 4){
                String modificada = "";
                builderValor = new StringBuilder(modificada);
                builderValor.append("10000.00");
            }else if (flag == 5){
                String modificada = "";
                builderValor = new StringBuilder(modificada);
                builderValor.append("100000.00");
            }
        }finally{
            String retorno = builderValor.toString();
            return retorno;
        }
    }
    
    public static String tornarCompativel(String valor){
        boolean flag = true;
        valor = new StringBuilder(valor).reverse().toString();
        StringBuilder builder = new StringBuilder();
        
        for (int i=0; i<valor.length(); i++) {
            Character c = valor.charAt(i);
            String str = Character.toString(c);
            if (str.equals(",")|str.equals(".")){
                flag = false;
                builder = new StringBuilder(valor);
                if(i==1){
                    String ponto = ".";
                    String decimal = builder.substring(0, i);
                    String mantissa = builder.substring(i+1, valor.length());
                    StringBuilder mantissaBuilder = new StringBuilder(mantissa).reverse();
                    mantissa = mantissaBuilder.toString();
                    StringBuilder finalBuilder = new StringBuilder(mantissa);
                    finalBuilder.append(ponto);
                    finalBuilder.append(decimal);
                    finalBuilder.append("0");   
                    String retorno = finalBuilder.toString();
                    return retorno;
                }else{
                    String ponto = ".";
                    String decimal = builder.substring(0, i);
                    String mantissa = builder.substring(i+1, valor.length());
                    StringBuilder mantissaBuilder = new StringBuilder(mantissa).reverse();
                    mantissa = mantissaBuilder.toString();
                    StringBuilder decimalBuilder = new StringBuilder(decimal).reverse();
                    decimal = decimalBuilder.toString();
                    StringBuilder finalBuilder = new StringBuilder(mantissa);
                    finalBuilder.append(ponto);
                    finalBuilder.append(decimal);   
                    String retorno = finalBuilder.toString();
                    return retorno;
                }
            }
        }
        if (flag){
            StringBuilder semPonto = new StringBuilder(valor).reverse();
            semPonto.append(".00");
            String retorno = semPonto.toString();
            return retorno;
        }
        String retorno = builder.toString();
        return retorno;
    }
}