package com.emmaluo.mybatislearning.model;

import java.lang.reflect.Field;

/**
 * Created by zcluo on 2016/6/24.
 */
public class PhoneNumber {
    private String countryCode;
    private String stateCode;
    private String number;
    public PhoneNumber(){

    }
    public PhoneNumber(String countryCode, String stateCode, String
            number)
    {
        this.countryCode = countryCode;
        this.stateCode = stateCode;
        this.number = number;
    }
    public PhoneNumber(String string)
    {
        if(string != null)
        {
            String[] parts = string.split("-");
            if(parts.length > 0) this.countryCode = parts[0];
            if(parts.length > 1) this.stateCode = parts[1];
            if(parts.length > 2) this.number = parts[2];
        }
    }
    public String getAsString()
    {
        return countryCode + "-" + stateCode + "-" + number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString(){
        //return super.toString();
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        result.append(this.getClass().getName());
        result.append(" Object {");
        result.append(newLine);

        //determine fields declared in this class only (no fields of superclass)
        Field[] fields = this.getClass().getDeclaredFields();

        //print field names paired with their values
        for (Field field : fields) {
            result.append("  ");
            try {
                result.append(field.getName());
                result.append(": ");
                //requires access to private field:
                result.append(field.get(this));
            }
            catch (IllegalAccessException ex) {
                System.out.println(ex);
            }
            result.append(newLine);
        }
        result.append("}");

        return result.toString();
    }
}
