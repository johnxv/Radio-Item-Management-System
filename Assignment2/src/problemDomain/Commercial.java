package problemDomain;


/**
 * Class Description:
 * Subclass of item superclass. Contains no other unique characteristic apart from the item superclass.
 *
 * @author	John Osea
 * Date:	Feb 5, 2019
 * Time:	6:00:25 PM
 */
public class Commercial extends Item
{

	/**
	 * Initializes the newly created Commercial.
	 * @param id id of the commercial.
	 * @param category category of the commercial.
	 * @param origin company the commercial is from.
	 * @param playTime duration of the commercial.
	 * @param audioFile name of the audio file of the commercial.
	 */
	public Commercial(int id, char category, String origin, String playTime, String audioFile)
	{
		super(id, category, origin, playTime, audioFile);
	}
	
	@Override
	public String toString()
	{
		return  getId() + "," + getCategory() + "," + getOrigin() + "," + getPlayTime() + "," + getAudioFile();
	}
	
}
