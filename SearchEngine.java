import java.io.IOException;
import java.net.URI;


public class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}

class Handler implements URLHandler {



    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return ("Missing query");
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[1].equals("pinapple")) {
                    return ("Pinapple");
                }
                else if(parameters[1].equals("apple")){
                    return("apple");
                }
                else if(parameters[1].equals("app")){
                    return("pinapple and apple");
                }
                else{
                    return ("You got here");
                }
            }
            return "404 Not Found!";
        }
    }
}

