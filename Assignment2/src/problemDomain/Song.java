package problemDomain;


/**
 * Class Description:
 * Subclass of item superclass. Contains title as the only unique characteristic apart from the item superclass.
 *
 * @author	John Osea
 * Date:	Feb 5, 2019
 * Time:	5:42:08 PM
 */
public class Song extends Item
{
	private String title;
	
	
	
	/**
	 * Initializes the newly created Song.
	 * @param id id of the item.
	 * @param category category of the song.
	 * @param origin artist/group that recorded the song
	 * @param playTime duration of the song.
	 * @param audioFile name of the audio file of the song.
	 * @param title unique characteristic for song item object. Refers to the title of the song.
	 */
	public Song(int id, char category, String title, String origin, String playTime, String audioFile)
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
		return  getId() + "," + getCategory() + "," + getTitle() + "," + getOrigin() + "," + getPlayTime() + "," + getAudioFile();
	}
	
}
