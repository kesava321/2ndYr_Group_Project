import java.util.*;
/**Weather Data class*/

public class weather
{
    public int dayOfMonth;
    //Temperature is in Fahrenheit.
    public int maxTemperature;
    public int minTemperature;
    //Precipitation is hundrethds of inches. ex.  1/100 or 0.01
    public int precipitation;
    private ArrayList<String> weatherData;

    /**Constructor for objects of class weather*/
    public weather(int day, int max,int min, int precip)
    {
        day = dayOfMonth;
        max = maxTemperature;
        min = minTemperature;
        precip = precipitation;
        weatherData = new ArrayList<String>();
    }

    public void setDayOfMonth(int day){
        if(day>=1&&day<=31){
            day=dayOfMonth;
        }
        else{
            System.out.println("Value must be between 1 and 31!");
        }
    }
    public void setMaxTemperature(int max){
        if(max>=-50&&max<=120){
            max=maxTemperature;
        }
        else{
            System.out.println("Value must be between -50 and 120!");
        }
    }
    public void setMinTemperature(int min){
        if(min>=-50&&min<=120){
            min=minTemperature;
        }
        else{
            System.out.println("Value must be between -50 and 120!");
        }
    }
    public void setPrecipitation(int precip){

    }
    public int getDayOfMonth(){
        return dayOfMonth;
    }
    public int getMaxTemperature(){
        return maxTemperature;
    }
    public int getMinTemperature(){
        return minTemperature;
    }
    public double getPrecipitation(){
        return precipitation/100.0;
    }
}
