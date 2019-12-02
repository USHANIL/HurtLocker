import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RawDataParser {
    // i am thinking the string to be item:price and integer to be number of times it occured
    Map<String, Integer> listOfItems = new LinkedHashMap<String, Integer>(); //todo we may have to change it.. itemprice and count
    Map<String, Integer> listOfItemsandPrice = new LinkedHashMap<String, Integer>(); //todo to store item and count

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
        if (!correctItem.equals(""))
        {
            Integer num = 1;
            if (listOfItems.containsKey(correctItem)) {num += listOfItems.get(correctItem);}
            listOfItems.put(correctItem, num);
        }
        else { //throw exception
            Integer num = 1;
            if (listOfItems.containsKey("Errors")) {num += listOfItems.get("Errors");}
            listOfItems.put("Errors", num);
        }

    }

    public void addItemandCount(String item){
        int count =1;
        if(listOfItemsandPrice.containsKey(item)){count += listOfItemsandPrice.get(item);}
        listOfItemsandPrice.put(item,count);
    }

    //split by - data will be either name or Price
    public String validateInput(String item, String price){

        String[] outputItem = item.split("[:]");
        String[] outputPrice = price.split("[:]");
        StringBuilder sb = new StringBuilder();
        if(outputItem.length >1 && outputPrice.length >1) {
            String itemName = outputItem[1].toLowerCase().replace("0","o");
            addItemandCount(itemName);

            sb.append(itemName);
            sb.append(":");
            sb.append(outputPrice[1].toLowerCase());
        }
        return sb.toString();
    }

    public void printMap() {

        for (HashMap.Entry<String, Integer> entry1 : listOfItemsandPrice.entrySet()) {
            String str = entry1.getKey();
            Integer num = entry1.getValue();



            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("name:\t"+str)
                    .append("\t\tseen: "+num+" times\n")
                    .append("=============\t\t=============\n");

            for(HashMap.Entry<String,Integer> entry2 : listOfItems.entrySet()){
                String[] str1 = entry2.getKey().split("[:]");
                Integer num1 = entry2.getValue();

                if (str1[0].equals(str)) {
                    stringBuilder.append("Price:\t" + str1[1])
                            .append("\t\tseen: " + num1 + " times\n")
                            .append("-------------\t\t-------------\n");
                }
            }
            System.out.println(stringBuilder);
        }
        System.out.println("Errors:\t \t\t\tseen: " + listOfItems.get("Errors")+" times\n");
    }

}
