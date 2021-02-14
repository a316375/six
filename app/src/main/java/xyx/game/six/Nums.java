package xyx.game.six;

public class Nums implements Comparable<Nums> {
    String string;
    Integer time;

    public Nums(String string, Integer time) {
        this.string = string;
        this.time = time;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Nums{" +
                "string='" + string + '\'' +
                ", time=" + time +
                '}';
    }

    //根据次数排序
    @Override
    public int compareTo(Nums o) {
        return this.time.compareTo(o.getTime());
    }
}
