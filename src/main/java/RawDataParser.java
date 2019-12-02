import java.util.HashMap;
import java.util.Map;

public class RawDataParser {
    Map<String, Double> listOfItems = new HashMap<String, Double>(); //todo we may have to change it

    public void parseInput(String input){
        String[] itemsArray = input.split("##"); //split items from text file separated by ##

        for (int i=0; i<itemsArray.length; i++){
            //split each item for its name and price.. not alph, not number, not : . /
            String[] currentItem = itemsArray[i].split("[^a-zA-Z0-9:./]");
            addItemToMap(currentItem[0], currentItem[1]);
        }
    }

    public void addItemToMap(String item, String price){
        String correctItem = validateItem(item);
        Double correctPrice = validatePrice(price);

        listOfItems.put(correctItem,correctPrice);

    }

    public String validateItem(String item){
        String output = null;
        return output;
    }

    public Double validatePrice(String price){
        Double output = null;
        return output;
    }




}
