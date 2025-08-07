package Company;
import java.util.ArrayList;

public class products {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private ArrayList<product> keyboards;
	private ArrayList<product> switches;
	private ArrayList<product> keycaps;
	public products() {
		keyboards = new ArrayList<>();
		keyboards.add(new product("redMechanical", 1, 150.0, "keyboard", "Red mechanical keyboard that comes with cherry mx red switches for a more silent experience and custom red patterned keycaps"));
		keyboards.add(new product("retroMechanical", 2, 200.00, "keyboard", "A retro themed mechanical keyboard that comes in 5 different shades of blue, purple, and neon green"));
		keyboards.add(new product("blueMechanical", 3, 150.00, "keyboard", "Blue mechanical keyboard that comes with blue mx switches and bright blue keycaps that are removeable"));
		keyboards.add(new product("CustomeBuild", 4, 250.00, "keybaord", "This is a fully custom build. This keyboard option gives full customizable options to the buyer"));
		switches.add(new product("cherry mx red", 5, 15.00, "switch", "These switches are for the user that wants a more tactile or stealthy sound to their keyboard"));
		switches.add(new product("chery mx silent red", 6, 18.50, "switch", "These switches provide an even more tactile sound than the original cherry mx red switches"));
		keycaps.add(new product("neon retro", 7, 100.0, "keycap", "These neon retro themed keycaps come in multiple shade of an assortment of colors"));
		
		
	}

	public static class product{
		private double price;
		private String name;
		private int ID;
		private String type;
		private String description;
		
		public product() {
		}
		
		public product(String name, int ID, double price, String type, String description) {
			this.name = name;
			this.ID = ID;
			this.price = price;
			this.type = type;
			this.description = description;
		}
		
		
		public String getName() {
			return name;
		}
		
		public double getPrice() {
			return price;
		}
		
		public int getprodID() {
			return ID;
		}
		
		public String prodType() {
			return type;
		}
		
		public String prodDescription() {
			return description;
		}
		
		
		
	}
	

>>>>>>> 1d928df7e21dd13ed74eebda67452c50ee9f96ae

    }
    private ArrayList<product> keyboards;
    private ArrayList<product> switches;
    private ArrayList<product> keycaps;
    public products() {
        keyboards = new ArrayList<>();
        keyboards.add(new product("redMechanical", 1, 150.0, "keyboard", "Red mechanical keyboard that comes with cherry mx red switches for a more silent experience and custom red patterned keycaps"));
        keyboards.add(new product("retroMechanical", 2, 200.00, "keyboard", "A retro themed mechanical keyboard that comes in 5 different shades of blue, purple, and neon green"));
        keyboards.add(new product("blueMechanical", 3, 150.00, "keyboard", "Blue mechanical keyboard that comes with blue mx switches and bright blue keycaps that are removeable"));
        keyboards.add(new product("CustomeBuild", 4, 250.00, "keybaord", "This is a fully custom build. This keyboard option gives full customizable options to the buyer"));
        switches.add(new product("cherry mx red", 5, 15.00, "switch", "These switches are for the user that wants a more tactile or stealthy sound to their keyboard"));
        switches.add(new product("chery mx silent red", 6, 18.50, "switch", "These switches provide an even more tactile sound than the original cherry mx red switches"));
        keycaps.add(new product("neon retro", 7, 100.0, "keycap", "These neon retro themed keycaps come in multiple shade of an assortment of colors"));


    }
    
    public static class product{
        private double price;
        private String name;
        private int ID;
        private String type;
        private String description;

        public product() {
        }

        public product(String name, int ID, double price, String type, String description) {
            this.name = name;
            this.ID = ID;
            this.price = price;
            this.type = type;
            this.description = description;
        }


        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getprodID() {
            return ID;
        }

        public String prodType() {
            return type;
        }

        public String prodDescription() {
            return description;
        }



    }



}