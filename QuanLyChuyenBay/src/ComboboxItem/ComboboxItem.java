package ComboboxItem;

public class ComboboxItem {
	   String displayValue;
	   int hiddenValue;

	   //Constructor
	   public ComboboxItem (String d, int h)
	   {
	        displayValue = d;
	        hiddenValue = h;
	   }

	   //Accessor
	   public int HiddenValue()
	   {
	       return hiddenValue;
	   }

	   //Override ToString method
	   @Override
	   public String toString()
	   {
	        return displayValue;
	   }
}
