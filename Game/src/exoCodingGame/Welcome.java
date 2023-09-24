package exoCodingGame;

public class Welcome {

    String key;
    String value;

    Welcome(String key, String value){
        this.key = key;
        this.value = value;
    }
    
    public Welcome(){
    	
    }

    public String getValue(String key){
        if(this.key.equals(key))
            return value;
        else 
            return "";
    }

    public String getKey(){
        return key;
    }

    public static String greet(String english) {

        Welcome [] mybdd = {new Welcome("english", "Welcome"), 
        new Welcome("czech", "Vitejte"),
        new Welcome("danish", "Velkomst"),
        new Welcome("dutch", "Welkom"),
        new Welcome("estonian", "Tere tulemast"),
        new Welcome("finnish", "Tervetuloa"),
        new Welcome("flemish", "Welgekomen"),
        new Welcome("french", "Bienvenue"),
        new Welcome("german", "Willkommen"),
        new Welcome("irish", "Failte"),
        new Welcome("italian", "Benvenuto"),
        new Welcome("latvian", "Gaidits"),
        new Welcome("lithuanian", "Laukiamas"),
        new Welcome("polish", "Witamy"),
        new Welcome("spanish", "Bienvenido"),
        new Welcome("swedish", "Valkommen"),
        new Welcome("welsh", "Croeso")};

        String res = "";
    
        for (int i=0; i<mybdd.length; i++)
        {
            if(mybdd[i].getValue(english) != ""){
                res = mybdd[i].getValue(english);
            }
        }
    

        if(res == ""){
            res = mybdd[0].getValue("english");
        }

        return res;

    }
}
