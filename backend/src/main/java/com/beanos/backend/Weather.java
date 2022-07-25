package com.beanos.backend;
import org.springframework.web.client.RestTemplate;




public class Weather implements Services {
    public String vero = "véro";
    private String location;
    private String country;
    private int fahrenheit;
    private int celsius;
    private String description;
    private String icon;
    RestTemplate restTemplate;



    public String getValue(String db, int key) {
      String res ="";
      for (int i = key; db.charAt(i) != ','; i++) {
          res+=db.charAt(i);
      }
      res = res.substring(1, res.length() - 1);
  return (res);
  }
  public int getValueInt(String db, int key) {
    String res ="";
    for (int i = key; db.charAt(i) != '.'; i++) {
        res+=db.charAt(i);
    }
return (Integer.parseInt(res));
    }
    public Weather(){
      restTemplate = new RestTemplate();
      String db = restTemplate.getForObject("http://api.weatherapi.com/v1/current.json?key=87a4c1006c284f078a7154049210712&q=London", String.class);

      this.location = getValue(db, db.indexOf("name") + ("name\":").length());
      this.country = getValue(db, db.indexOf("country") + ("country\":").length());
      this.fahrenheit = getValueInt(db, db.indexOf("temp_f") + ("temp_f\":").length());
      this.celsius = getValueInt(db, db.indexOf("temp_c") + ("temp_c\":").length());
      this.description = getValue(db, db.indexOf("text") + ("text\":").length());
      this.icon = "http:" + getValue(db, db.indexOf("icon") + ("icon\":").length());
    }

    public void test() {
      System.out.println("verooooo");
    }

    public String getCity() {
        return this.location;
      }
    public String getRegion() {
        return this.country;
      }
    public int getFahrenheit() {
        return this.fahrenheit;
      }
      public int getCelsius() {
        return this.celsius;
      }
      public String getDescription() {
        return this.description;
      }
      public String getIcon() {
        return this.icon;
      }
    

}
