package application;

import java.io.*;

import java.util.*;

import problemDomain.*;

/**
 * Class Description:
 * Contains all the methods used for the Radio Station.
 *
 *
 * @author	John Osea
 * Date:	Feb 5, 2019
 * Time:	6:09:33 PM
 */
public class Radio
{
	// attributes
	private ArrayList<Item> item = new ArrayList<>();
	private Scanner kb = new Scanner(System.in);
	
	
	
	
	
	/**
	 * Initializes the newly created Radio.
	 * @throws IOException
	 */
	public Radio() throws IOException
	{
		loadItems();
		mainMenu();
	}
	
	
	
	
	
	/**
	 * Loads the items from a file into an ArrayList.
	 * The items in the text file are different lengths
	 * with different indices.
	 * 
	 * The line being read from the text file is typecasted
	 * in order to correctly sort the item into a proper 
	 * constructor. 
	 * 
	 * @throws IOException
	 */
	private void loadItems() throws IOException
	{
		BufferedReader fileRdr = new BufferedReader(new FileReader("res//database.txt"));
		String line = fileRdr.readLine();
		while(line != null)
		{
			String[] field = line.split(",");
			int itemIdentifier = Integer.parseInt(field[0]);
			if(itemIdentifier % 10 <= 2)
			{
				// TalkShow
				item.add(new TalkShow(Integer.parseInt(field[0]), field[1].charAt(0), field[2], field[3], field[4], field[5]));
			}
			else if(itemIdentifier % 10 <= 7)
			{
				// Song
				item.add(new Song(Integer.parseInt(field[0]), field[1].charAt(0), field[2], field[3], field[4], field[5]));
			}
			else
			{
				// Commercial
				item.add(new Commercial(Integer.parseInt(field[0]), field[1].charAt(0), field[2], field[3], field[4]));
			}
			line = fileRdr.readLine();
		}
		fileRdr.close();
	}
	
	
	
	
	
	/**
	 * Displays the main menu of actions the user can do.
	 * The choices are associated with their corresponding method.
	 * 
	 * The choices are:
	 * 
	 * 1. Add an item. - addItem();
	 * 2. Delete and item. - deleteItem();
	 * 3. Print ALL items. - printAllItems();
	 * 4. Print a particular type of item. - printParticularType();
	 * 5. Search for an item by its ID. - searchByID();
	 * 6. Make a random playlist. - playlist();
	 * 7. Exit. - Simply leaves the program.
	 * @throws IOException 
	 */
	private void mainMenu() throws IOException
	{
		int j = 0;
		
		System.out.println("=============================================");
		System.out.println("||         Welcome to Radio Station!       ||");
		System.out.println("=============================================");
		System.out.println("||   Choose from the selection:            ||"); 
		System.out.println("||   1. Add an item.                       ||");
		System.out.println("||   2. Delete an item.                    ||");
		System.out.println("||   3. Print ALL items.                   ||");
		System.out.println("||   4. Print a particular type of item.   ||");
		System.out.println("||   5. Search for an item by its ID.      ||");
		System.out.println("||   6. Make a random playlist.            ||");
		System.out.println("||   7. Exit.                              ||");
		System.out.println("=============================================");
		j = kb.nextInt(); 
		
		switch(j)
		{
			case 1:
				addItem();
				break;
			case 2:
				deleteItem();
				break;
			case 3:
				printAllItems();
				break;
			case 4:
				printParticularType();
				break;
			case 5:
				searchByID();
				break;
			case 6:
				playList();
				break;
			case 7:
				System.out.println();
				writeToFile(item);
				System.out.println("Thank you for tuning in!");
				System.out.println("End of Program.");
				break;
		}
	}
	
	
	
	
	
	/**
	 * Allows the user to add an item by asking a couple of questions
	 * which the user can input accordingly. The inputs are then
	 * passed through a specific type of constructor depending 
	 * on the initial ID value.
	 */
	private void addItem() throws IOException
	{
		System.out.println("Enter the ID of the Item you want to add");
		int id = kb.nextInt();
		kb.nextLine();
		while(existingID(id))
		{
			System.out.println("ID already exists in the database. Try a different ID.");
			kb = new Scanner(System.in);
			id = kb.nextInt();
			kb.nextLine();
		}
		
		if (id % 10 <= 2)
			addTalkShow(id);
		else if (id % 10 <= 7)
			addSong(id);
		else
			addCommercial(id);	
	}
	
	
	
	
	
	/**
	 * Extension of the addItem() method for a TalkShow object.
	 * @param id id
	 */
	private void addTalkShow(int id) throws IOException
	{	
		int f = 0;
		char category = 0;
		do 
		{
			System.out.println("What is the category of the Talk Show?");
			System.out.println("1. Science");
			System.out.println("2. Politics");
			System.out.println("3. Miscellaneous");
			f = kb.nextInt();
			kb.nextLine();
			
			switch(f)
			{
				case 1:
					category = 'S';
					break;
				case 2:
					category = 'P';
					break;
				case 3:
					category = 'M';
					break;
			}
			
		}
		while(f < 1 || f > 3);
		
		System.out.println("What is the title of the talk show?");
		String title = kb.nextLine();		
		System.out.println("Who is the host of the talk show?");
		String origin = kb.nextLine();		
		System.out.println("How long is the talk show? (MM:SS)");
		String playTime = kb.nextLine();		
		System.out.println("What is the name of the audio file?");
		String audioFile = kb.nextLine();
		
		item.add(new TalkShow(id, category, title, origin, playTime, audioFile));
		
		System.out.println();
		mainMenu();
	}
	
	
	
	
	
	/**
	 * Extension of the addItem() method for a Song object.
	 * @param id id
	 */
	private void addSong(int id) throws IOException
	{		
		kb = new Scanner(System.in);
		int f = 0;
		char category = 0;
		do 
		{
			System.out.println("What is the category of the Song?");
			System.out.println("1. Classical");
			System.out.println("2. Country");
			System.out.println("3. Rock");
			System.out.println("4. pop");
			System.out.println("5. Alternative");
			f = kb.nextInt();
			kb.nextLine();
			
			switch(f)
			{
				case 1:
					category = 'L';
					break;
				case 2:
					category = 'C';
					break;
				case 3:
					category = 'R';
					break;
				case 4:
					category = 'P';
					break;
				case 5:
					category = 'A';
					break;
			}
		}
		while(f < 1 || f > 5);
		
		System.out.println("What is the title of the song");
		String title = kb.nextLine();		
		System.out.println("Who is the artist of the song?");
		String origin = kb.nextLine();		
		System.out.println("How long is the song? (MM:SS)");
		String playTime = kb.nextLine();
		System.out.println("What is the name of the audio file?");
		String audioFile = kb.nextLine();
		
		item.add(new Song(id, category, title, origin, playTime, audioFile));
		
		System.out.println();
		mainMenu();
	}
	
	
	
	
	
	/**
	 * Extension of the addItem() method for a Commercial Object.
	 * @param id id
	 */
	private void addCommercial(int id) throws IOException
	{		
		int f = 0;
		char category = 0;
		do 
		{
			System.out.println("What is the category of the Commercial?");
			System.out.println("1. Vehicle Dealers");
			System.out.println("2. Household Products");
			System.out.println("3. Computers");
			System.out.println("4. Miscellaneous");
			f = kb.nextInt();
			kb.nextLine();
			
			switch(f)
			{
				case 1:
					category = 'V';
					break;
				case 2:
					category = 'H';
					break;
				case 3:
					category = 'C';
					break;
				case 4:
					category = 'M';
					break;
			}
		}
		while(f < 1 || f > 4);
		
		System.out.println("Which company is the commercial from?");
		String origin = kb.nextLine();
		System.out.println("How long is the commercial? (MM:SS)");
		String playTime = kb.nextLine();
		System.out.println("What is the name of the audio file?");
		String audioFile = kb.nextLine();
		
		item.add(new Commercial(id, category, origin, playTime, audioFile));
		
		System.out.println();
		mainMenu();
	}
	
	
	
	
	
	/**
	 * Checks the entire item ArrayList to determine whether the 
	 * user input ID value is already in the database.
	 * 
	 * @param id id
	 * @return true || false
	 */
	private boolean existingID(int id)
	{
		for(Item i : item)
		{
			if (i.getId() == id)
			{
				return true;
			}
		}		
		return false;
	}
	
	
	
	
	
	/**
	 * Deletes an Item from the item ArrayList with the equivalent ID value
	 * as the user entered ID value. 
	 */
	private void deleteItem() throws IOException
	{
		
		kb = new Scanner(System.in);
		
		int idIdx = 0;
		boolean found = false;
		System.out.println("Enter the ID of the item you want to delete: ");
		int id = kb.nextInt();
		kb.nextLine();
		
		for (int i = 0; i < item.size(); i++)
		{
			if(item.get(i).getId() == id)
			{
				found = true;
				idIdx = i;
			}
		}
		
		if(found)
		{
			item.remove(idIdx);
		}
		else
		{
			System.out.println("ID not found.");
		}
		
		System.out.println();
		mainMenu();
	}
	
	
	
	
	
	/**
	 * Prints all items contained in the item ArrayList
	 */
	private void printAllItems() throws IOException
	{
		for (Item i : item)
		{
			System.out.println(i.toString());
		}
		
		System.out.println();
		mainMenu();
	}	
	
	
	
	
	
	/**
	 * A method that would print out the user's choice of Item type and Item type category.
	 */
	private void printParticularType() throws IOException
	{
		char category = 0;
		
		System.out.println("Print Particular Type.");
		System.out.println("1. Talk Shows");
		System.out.println("2. Songs");
		System.out.println("3. Commercials");
		int j = kb.nextInt();
		kb.nextLine();
		
		switch(j)
		{
			case 1:
				category = chooseCategory(j);
				for(Item i : item)
				{
					if (i instanceof TalkShow && i.getCategory() == category)
					{
						System.out.println(((TalkShow)i).toString());
					}
				}
				
				System.out.println();
				mainMenu();
				
				break;
			case 2:
				category = chooseCategory(j);
				for(Item i : item)
				{
					if (i instanceof Song && i.getCategory() == category)
					{
						System.out.println(((Song)i).toString());
					}
				}
				
				System.out.println();
				mainMenu();
				
				break;
			case 3:
				category = chooseCategory(j);
				for(Item i : item)
				{
					if (i instanceof Commercial && i.getCategory() == category)
					{
						System.out.println(((Commercial)i).toString());
					}
				}
				
				System.out.println();
				mainMenu();
				
				break;
		}
	}
	
	
	
	
	
	/**
	 * A method used to choose a category from the choice made in printParticularType() method
	 * 
	 * This method uses the 'int j' variable to determine the choices for categories to display
	 * and then allows the user to choose the category.
	 * 
	 *  The char category is then returned in order to print out the SPECIFIC CATEGORY from the
	 *  SPECIFIC TYPE of ITEM.
	 *  
	 *  Some categories have the same char (letter) but belong to different types. One example would
	 *  be the Politics (P) category in TalkShow type and the Pop (P) category in Song type.
	 * 
	 * @param j number used to choose from the main menu
	 * @return category
	 */	
	private char chooseCategory(int j)
	{
		int p = 0;
		System.out.println("Which Category would you like to pick from?");
		
		if(j == 1)
		{
			System.out.println("1. Science");
			System.out.println("2. Politics");
			System.out.println("3. Miscellaneous");
			p = kb.nextInt();
			kb.nextLine();
			
			switch(p)
			{
				case 1:
					return 'S';
				case 2:
					return 'P';
				case 3:
					return 'M';
			}
		}
		else if (j == 2)
		{
			System.out.println("1. Classical");
			System.out.println("2. Country");
			System.out.println("3. Rock");
			System.out.println("4. Pop");
			System.out.println("5. Alternative");
			p = kb.nextInt();
			kb.nextLine();
			
			switch(p)
			{
				case 1:
					return 'L';
				case 2:
					return 'C';
				case 3:
					return 'R';
				case 4:
					return 'P';
				case 5:
					return 'A';
			}
		}
		else
		{
			System.out.println("1. Vehicle Dealers");
			System.out.println("2. Household Products");
			System.out.println("3. Computers");
			System.out.println("4. Miscellaneous");
			p = kb.nextInt();
			kb.nextLine();
			
			switch(p) 
			{
				case 1:
					return 'V';
				case 2:
					return 'H';
				case 3:
					return 'C';
				case 4:
					return 'M';
			}
		}
		return 0;
	}
	
	
	
	
	
	/**
	 * Search an Item by ID value with the equivalent user input ID value
	 * from the item ArrayList.
	 */
	private void searchByID() throws IOException
	{
		System.out.println("Enter the ID of the item you want to search for.");
		int id = kb.nextInt();
		kb.nextLine();
		
		for(int i = 0; i < item.size(); i++)
		{
			if (item.get(i).getId() == id)
			{
				System.out.println(item.get(i).toString());
			}
		}
		
		System.out.println();
		mainMenu();
	}
	
	
	
	
	
	/**
	 * Creates a playlist consisting of randomly selected type of item
	 * wherein the playlist time fits within the user entered time.
	 * 
	 * The user entered time is entered with the 
	 * 
	 * "mm:ss"
	 * 
	 * format. This method also converts that time format all to total time
	 * in seconds.
	 */
	private void playList() throws IOException
	{
		ArrayList<Item> playlist = new ArrayList<>();
		String timeStr;
		
		int k = 0;
		int userTime = 0;
		int playlistTime = 0;
		
		Random r = new Random();
		
		System.out.println("Enter playlist time: ");
		kb.nextLine();
		timeStr = kb.nextLine();
		userTime = timeConvert(timeStr);
		
		while(playlistTime <= (userTime - 30))
		{
			int p = r.nextInt(item.size());
			
			playlist.add(item.get(p));
			timeStr = playlist.get(k).getPlayTime();
			playlistTime += timeConvert(timeStr);
			
			if (playlistTime >= (userTime + 30))
			{
				playlist.remove(k);
				playlistTime -= timeConvert(timeStr);
			}
			else 
			{
				k++;
			}			
		}
		
		System.out.println();
		for(int i = 0; i < playlist.size(); i++)
		{
			System.out.println(playlist.get(i).toString());
		}
		System.out.println("Play List time: \t" + playlistTime / 60 + ":" + playlistTime % 60);
		playlistTime = 0;
		playlist.clear();
		
		System.out.println();
		mainMenu();
	}
	
	
	
	
	
	/**
	 * Converts the time String to a time String Array. The time String Array
	 * is then converted to integers. The minute time value is converted to seconds
	 * by multiplying the value by 60. This value is then added to the seconds in order
	 * to get the total time in seconds. 
	 * 
	 * @param s String value from the itemDB.txt. Formatted as "mm:ss".
	 * @return timeInt
	 */
	private int timeConvert(String s)
	{
		String[] timeSt = s.trim().split(":");
		int mm = Integer.parseInt(timeSt[0]);
		int ss = Integer.parseInt(timeSt[1]);
		
		return (ss + (mm * 60));
	}
	
	
	
	
	/**
	 * Prints an updated list back to the text file.
	 * 
	 * @param item item ArrayList
	 * @throws IOException
	 */
	private void writeToFile(ArrayList<Item> item) throws IOException
	{
		PrintWriter pw = new PrintWriter("res\\database.txt");
		
		for(int i = 0; i < item.size(); i++)
		{
			pw.println(item.get(i).toString());
		}
		
		pw.close();
	}
}