package p02_FileStream;

public class StreamProgressInfo {
    private Streamable stream;

    public StreamProgressInfo(Streamable stream) {
        this.stream = stream;
    }

    public int calculateCurrentPercent() {
        return (this.stream.getBytesSent() * 100) / this.stream.getLength();
    }
}
