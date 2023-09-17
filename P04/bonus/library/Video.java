package library;

import java.time.Duration;

/**
 * The {@code Video} class represents a video publication, extending the
 * {@link Publication}
 * class, and includes additional properties such as runtime duration.
 */
public class Video extends Publication {
	private Duration runtime;

	/**
	 * Constructs a new {@code Video} with the specified title, author, copyright
	 * year, and runtime.
	 *
	 * @param title     the title of the video.
	 * @param author    the author or director of the video.
	 * @param copyright the copyright year of the video.
	 * @param runtime   the runtime duration of the video in minutes.
	 * @throws InvalidRuntimeException if the runtime is non-positive.
	 */
	public Video(String title, String author, int copyright, int runtime) {
		super(title, author, copyright);
		if (runtime <= 0) {
			throw new InvalidRuntimeException(title, runtime);
		}
		this.runtime = Duration.ofMinutes(runtime);
	}

	/**
	 * Generates a string representation of the video, including its title, author,
	 * copyright year, and runtime duration.
	 *
	 * @return a string representation of the video.
	 */
	@Override
	public String toString() {
		StringBuilder output;

		String duration = String.format(", runtime " + runtime.toMinutes() + " minutes\n");
		output = toStringBuilder("Video ", duration);

		return output.toString();
	}
}
