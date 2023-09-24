package MainPackage;

//import java.io.FileWriter;
//import java.io.IOException;
import org.json.JSONObject;



public class Errorcodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creating a JSONObject object
		JSONObject jsonObject = new JSONObject();
		
		//System.out.println ("Test : filling json with error codes");
        for(int i = 0; i < args.length; i++) {
        	//System.out.println(Integer.parseInt(args[i]));
        	
        	switch (args[i]){
    		case "-1" :
    			//Inserting key-value pairs into the json object
    			jsonObject.put("-1", "Pas d'argument.");
    			System.out.println(jsonObject);
    			System.exit(-1);
    			break;
    		case "0" :
    			
    			jsonObject.put("0", "Pas de message d'erreur, tout s'est bien passé.");
    			System.out.println(jsonObject);
    			System.exit(0);
    			break ;
    		case "1" :
    			
    			jsonObject.put("1", "Message d'erreur du cas 1.");
    			System.out.println(jsonObject);
    			System.exit(1);
    			break;
    		case "2" :
    			jsonObject.put("2", "Message d'erreur du cas 2.");
    			System.out.println(jsonObject);
    			System.exit(2);
    			break;
    		case "3" :
    			jsonObject.put("3", "Message d'erreur du cas 3.");
    			System.out.println(jsonObject);
    			System.exit(3);
    			break;
    		default :
    			jsonObject.put("4", "Pas de code d'erreur.");
    			System.out.println(jsonObject);
    			System.exit(4);
    			break ;
    		}

    		
    		/*try {
    		FileWriter file = new FileWriter("E:/output.json");
    		file.write(jsonObject.toString());
    		file.close();
    		} catch (IOException e) {
    		// TODO Auto-generated catch block
    			e.printStackTrace();
    		}*/
    		/*System.out.println("JSON file created: "+jsonObject);*/
        }
		
		
		
		
	}

        // solution 1
        //System.exit( 32 );
        // solution 2
        // retourner un json 
        //  {
        //   returnCode : 1
        //   returnMessage : "My message"
        //  }

	

}
