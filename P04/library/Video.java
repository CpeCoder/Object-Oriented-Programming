package library;
import java.time.Duration;

public class Video extends Publication{
	private Duration runtime;
	
	public Video(String title, String author, int copyright, int runtime){
		super(title, author, copyright);
		if(runtime <= 0){
			throw new InvalidRuntimeException(title, runtime);
		}
		this.runtime = Duration.ofMinutes(runtime);
	}

	@Override
	public String toString(){
		StringBuilder output;

		String duration = String.format(", runtime " + runtime.toMinutes() + " minutes\n");
		output = toStringBuilder("Video ", duration);
        	
		return output.toString();
	}
}
