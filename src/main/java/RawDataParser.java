import java.util.HashMap;
import java.util.Map;

public class RawDataParser {
    // i am thinking the string to be item:price and integer to be number of times it occured
    Map<String, Integer> listOfItems = new HashMap<String, Integer>(); //todo we may have to change it

    public void parseInput(String input){
        String[] itemsArray = input.split("##"); //split items from text file separated by ##

        for (int i=0; i<itemsArray.length; i++){
            //split each item for its name and price.. not alpha, not number, not : . /
            String[] currentItem = itemsArray[i].split("[^a-zA-Z0-9:./]");
            addItemToMap(currentItem[0], currentItem[1]);
        }
    }

    public void addItemToMap(String item, String price){

        String correctItem = validateInput(item,price);
       // Double correctPrice = Double.valueOf(validateInput(price));

        if (!correctItem.equals(""))
        {
            //listOfItems.put(correctItem, correctPrice);
            Integer num = 1;
            if (listOfItems.containsKey(correctItem)) {num += listOfItems.get(correctItem);}
            listOfItems.put(correctItem, num);
        }
        else { //throw exception

        }

    }

    //split by - data will be either name or Price
    public String validateInput(String item, String price){

        String[] outputItem = item.split("[:]");
        String[] outputPrice = price.split("[:]");
        StringBuilder sb = new StringBuilder();
        if(outputItem.length >1 && outputPrice.length >1) {
            sb.append(outputItem[1].toLowerCase());
            sb.append(":");
            sb.append(outputPrice[1].toLowerCase());
        }
        return sb.toString();
    }


}
