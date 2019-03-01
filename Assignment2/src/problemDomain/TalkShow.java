package problemDomain;


/**
 * Class Description:
 * Subclass of item superclass. Contains title as the only unique characteristic apart from the item superclass.
 *
 * @author	John Osea
 * Date:	Feb 5, 2019
 * Time:	6:02:18 PM
 */
public class TalkShow extends Item
{
	private String title;
	
	
	
	/**
	 * Initializes the newly created TalkShow.
	 * @param id id of the talk show
	 * @param category category of the talk show.
	 * @param origin host of the talk show. 
	 * @param playTime duration of the talk show.
	 * @param audioFile name of the audio file of the talk show.
	 * @param title unique characteristic for talk show item object. Refers to the title of the talk show.
	 */
	public TalkShow(int id, char category, String title, String origin, String playTime, String audioFile)
	{
		super(id, category, origin, playTime, audioFile);
		setTitle(title);
	}



	
	/**
	 * Returns the title.
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Sets the value of title.
	 * @param title the title to set
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	
	
	@Override
	public String toString()
	{
		return getId() + "," + getCategory() + "," + getTitle() + "," + getOrigin() + "," + getPlayTime() + "," + getAudioFile();
	}
	
}
