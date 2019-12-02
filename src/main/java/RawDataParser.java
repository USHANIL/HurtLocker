import java.util.HashMap;
import java.util.Map;

public class RawDataParser {
    Map<String, Double> listOfItems = new HashMap<String, Double>(); //todo we may have to change it

    public void parseInput(String input){
        String[] itemsArray = input.split("##"); //split items from text file separated by ##

        for (int i=0; i<itemsArray.length; i++){
            //split each item for its name and price.. not alpha, not number, not : . /
            String[] currentItem = itemsArray[i].split("[^a-zA-Z0-9:./]");
            addItemToMap(currentItem[0], currentItem[1]);
        }
    }

    public void addItemToMap(String item, String price){

        String correctItem = validateInput(item);
        Double correctPrice = Double.valueOf(validateInput(price));

        if (correctItem != null)
        {
            listOfItems.put(correctItem, correctPrice);
        }
        else {

        }

    }

    public String validateInput(String input){
        String output = input;
        return output;
    }


}
