package problemDomain;


/**
 * Class Description:
 * Represents an Item object as an abstract object.
 *
 *
 * @author	John Osea
 * Date:	Feb 5, 2019
 * Time:	5:08:56 PM
 */
public abstract class Item
{
	private int id;
	private char category;
	private String origin;
	private String playTime;
	private String audioFile;
	
	
	
	/**
	 * Initializes the newly created Item.
	 * @param id
	 * @param category
	 * @param origin
	 * @param playTime
	 * @param audioFile
	 */
	public Item(int id, char category, String origin, String playTime, String audioFile)
	{
		super();
		setId(id);
		setCategory(category);
		setOrigin(origin);
		setPlayTime(playTime);
		setAudioFile(audioFile);
	}
	
	
	
	/**
	 * Returns the id.
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * Returns the category.
	 * @return the category
	 */
	public char getCategory()
	{
		return category;
	}
	
	/**
	 * Returns the origin.
	 * @return the origin
	 */
	public String getOrigin()
	{
		return origin;
	}
	
	/**
	 * Returns the playTime.
	 * @return the playTime
	 */
	public String getPlayTime()
	{
		return playTime;
	}
	
	/**
	 * Returns the audioFile.
	 * @return the audioFile
	 */
	public String getAudioFile()
	{
		return audioFile;
	}
	
	/**
	 * Sets the value of id.
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	
	/**
	 * Sets the value of category.
	 * @param category the category to set
	 */
	public void setCategory(char category)
	{
		this.category = category;
	}
	
	/**
	 * Sets the value of origin.
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin)
	{
		this.origin = origin;
	}
	
	/**
	 * Sets the value of playTime.
	 * @param playTime the playTime to set
	 */
	public void setPlayTime(String playTime)
	{
		this.playTime = playTime;
	}
	
	/**
	 * Sets the value of audioFile.
	 * @param audioFile the audioFile to set
	 */
	public void setAudioFile(String audioFile)
	{
		this.audioFile = audioFile;
	}	
	
	
	
	@Override
	public abstract String toString();
	
	
	
}