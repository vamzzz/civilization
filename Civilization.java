import java.util.Scanner;
public class Civilization 
{
    static boolean playing = true;

    public static void main(String[] args) 
    {
        
        while(playing)
        {
            System.out.println("Choose one of the following Civilizations: American, Zulu, English, Chinese");
           	Scanner input = new Scanner(System.in);
           	String civ = input.nextLine();
           	String name = "";
           	if (civ.equals("American"))
           	{
           		name = "George Washington";
           	}
           	if (civ.equals("Zulu"))
           	{
           		name = "Shaka" ;
           	}
           	if (civ.equals("English"))
           	{
           		name = "Queen Elizabeth I";
           	}
           	if (civ.equals("Chinese"))
           	{
           		name = "Wu Zetian";
           	}
            System.out.println("Welcome " + name + ", we are ready to conquer the world. What would you like to call your first city?");
           	Scanner city = new Scanner(System.in);
           	String cityName = city.nextLine();

           	String[] cityArray;
           	cityArray = new String[5];
           	cityArray[0] = cityName;
            int cityNum = 0;
          

           	int attacks = 0;
           	Double gold = 20.5;
           	Double resource = 30.0;
           	int happy = 10;
           	int military = 0;
           	int tech = 0;

           	while ((tech < 20) && (attacks < 10)) {
              int cityNum1 = (cityNum + 1);
           		System.out.println("Hello " + name + ", you have\n"
           		+ cityNum1  + " Cities\n" + gold + " Gold\n" + resource + " Resources\n"
           		+ happy + " Happiness\n" + military + " Military Units\n" + tech + " Technology points\n" + attacks + " Attacks");

           		System.out.println("What would you like to do?\nSettle a City (Cost: 15.5 gold)\nDemolish a City (Gain: 1.5 resource)\nBuild Militia (Spend: 5 gold and 3 resources to increase military by 1)\nResearch Technology (Spend 50 gold and 2 resources to receive 1 Technology Point)\nAttack Enemy City (Lose: 6 Military Units and 3 Happiness & gain 10 gold)\nEnd Turn");

            	Scanner decisions = new Scanner(System.in);

            	String decision = decisions.nextLine();
            	if (decision.equals("Settle a City"))
            	{
            		for (int count = 0; count < 5;) {
            			if (cityArray[count] != null) // figure out how to get a while list ot iterate through list
            			{
            				System.out.println(cityArray[count]);
            				cityNum++;
            			}
            			else if ((gold >= 15.5) & (cityNum < 5))
            			{
            				System.out.println(name + ", what would you like to call your new city?");
            				gold = (gold - 15.5);
            				Scanner settle = new Scanner(System.in);
            				String newCity = settle.nextLine();
            				int aNum = 0;
            				boolean settled = true;
            				while ((aNum <5) && (settled))
            				{
            					if (cityArray[aNum] != null)
            					{
            						aNum++;
            					}
            					else
            					{
            						cityArray[aNum] = newCity;
            						settled = false;
            					}
            				}
            			}
            			else
            			{
            				System.out.println("I'm sorry, " + name + ". You do not meet the requirements to settle a city.");
            			}
            			count++;
            		}
            	}		
            	if (decision.equals("Demolish a City"))
            	{
           			int done = 0;
                boolean demolish = true;
                int count = 0;
           			while ((count < 5) && (demolish)) 
                {
            			if (cityArray[count]!= null)
            			{
            				System.out.println(cityArray[count]);
            				done++;
                  }
                  count++;
                }
            		if (done > 1)
            		{
            			System.out.println(name + ", which city would you like to demolish?");
            			resource = (resource + 1.5);
            			Scanner dead = new Scanner(System.in);
            			String flames = dead.nextLine();
          				int aNum = 0;
          				while ((aNum <5) && (demolish))
          				{
          					if (cityArray[aNum].equals(flames))
            				{
            					cityArray[aNum] = (null);
            					demolish = false;
                      cityNum = (cityNum - 1);
            				}
            			}
            	  }
            		else
            		{
            			System.out.println("I'm sorry, " + name + ". You need to have atleast two cities to demolish one.");
            		}
            	}
              if (decision.equals("Build Militia"))
           		{
           			if ((gold >= 5) && (resource >= 3)) 
                {
            			military = (military + 1);
            			gold = (gold - 5);
            			resource = (resource - 3);
            		}

            		else
            		{
            			System.out.println(name + ", you cannot perform that action.");
            		}
            	}

            	if (decision.equals("Research Technology")) 
            	{
            		if ((gold >= 50) && (resource >= 2))
            		{
            			gold = (gold - 50);
            			resource = (resource - 2);
            			tech = (tech + 1);
            		}
            			
            		else
            		{
            			System.out.println(name + ", you cannot perform that action.");
            		}

            	}

            	if (decision.equals("Attack Enemy City"))
            	{
            		if (military >= 6)
            		{
            			military = (military - 6);
            			happy = (happy - 3);
            			gold = (gold + 10);
            			attacks++;
            		}
            		else
            		{
            			System.out.println(name + ", you cannot perform that action.");
            		}		
            	}

            	if (decision.equals("End Turn"))
            	{
            		System.out.println("You have ended your turn.");
            	}
              if (happy > 20)
              {
                resource = (resource + 5);
              }
              else
              {
                resource++;
              }
              gold = (gold + (cityNum1 * 3));
              if (resource % 2 == 0)
              {
                happy++;
              }
              else
              {
                happy = (happy - 3);
              }
           	}


            // Your game code here

            // Use this to break out of the game loop. 
            // Feel free to move it around.
            playing = false;
        }
    }
}
