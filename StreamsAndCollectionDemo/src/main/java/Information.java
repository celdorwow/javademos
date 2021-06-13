import java.util.Optional;

public class Information {
    private final String comment;
    private final String suplier;
    private final int count;
    private final double avg1;
    private final double avg2;
    private final double avg3;
    private final String consumer;
    private final String purpose;
    private final double proportion;

    public Information(String comment,
                       String suplier,
                       int count,
                       double avg1,
                       double avg2,
                       double avg3,
                       String consumer,
                       String purpose,
                       double proportion) {
        this.comment = comment;
        this.suplier = suplier;
        this.count = count;
        this.avg1 = avg1;
        this.avg2 = avg2;
        this.avg3 = avg3;
        this.consumer = consumer;
        this.purpose = purpose;
        this.proportion = proportion;
    }

    public String getComment() {
        return comment;
    }

    public String getSuplier() {
        return suplier;
    }

    public int getCount() {
        return count;
    }

    public double getAvg1() {
        return avg1;
    }

    public double getAvg2() {
        return avg2;
    }

    public double getAvg3() {
        return avg3;
    }

    public String getConsumer() {
        return consumer;
    }

    public String getPurpose() {
        return purpose;
    }

    public double getProportion() {
        return proportion;
    }

    @Override
    public String toString() {
        return String.format("[%s ::: %s ::: %s ::: %s ::: %s ::: %s ::: %s ::: %s ::: %s]",
            comment, suplier, count, avg1, avg2, avg3, consumer, purpose, proportion);
    }
}
