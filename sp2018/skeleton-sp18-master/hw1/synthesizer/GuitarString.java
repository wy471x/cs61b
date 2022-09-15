package synthesizer;

/**
 * @author dunk
 */
public class GuitarString {
    /**
     * Constants. Do not change.
     * In case you're curious, the keyword final means
     * the values cannot be changed at runtime.
     * We'll discuss this and other topics
     * in lecture on Friday.
     */
    /**
     * Sample rate.
     */
    private static final int SR = 44100;

    /**
     * Decay factor.
     */
    private static final double DECAY = .996;

    /**
     * Buffer for storing sound data.
     */
    private BoundedQueue<Double> buffer;

    /**
     * Create a guitar string of the given frequency.
     * @param frequency
     **/
    public GuitarString(double frequency) {
        int capacity = (int) Math.round(this.SR / frequency);
        this.buffer = new ArrayRingBuffer<>(capacity);
    }


    /**
     * Pluck the guitar string by replacing the buffer with white noise.
     */
    public void pluck() {
        while (!this.buffer.isFull()) {
            this.buffer.enqueue(Math.random() - 0.5);
        }
    }

    /**
     * Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double sum = this.buffer.dequeue() + this.buffer.peek();
        double element = sum / 2 * this.DECAY;
        this.buffer.enqueue(element);
    }

    /**
     * Return the double at the front of the buffer.
     *
     * @return
     */
    public double sample() {
        return this.buffer.peek();
    }
}
